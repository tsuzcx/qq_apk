package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentItemGameMsgBoxData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GameMsgBoxRuntimeServiceImpl
  implements IGameMsgBoxRuntimeService
{
  public static final long REPORT_DELAY = 3000L;
  public static final String TAG = "GameMsgBoxRuntimeServiceImpl";
  public static final AtomicBoolean dataReady = new AtomicBoolean(false);
  public final int AUTHORIZE_MAX_TIME = 1;
  private final String SP_GAME_MSG_READ = "sp_game_msg_read";
  private final String SP_KEY_GAME_MSG_READ = "sp_key_game_msg_read";
  private final String SP_KEY_GAME_TOP = "sp_key_game_top";
  private final String SP_KEY_TIME_SET = "sp_key_game_time_set";
  private AtomicBoolean isRead = new AtomicBoolean(true);
  private AppRuntime mAppRuntime;
  private View mElementView;
  IConversationFacade mIConversationFacade;
  private LinearLayout mPageView;
  private SharedPreferences mSharedPreferences;
  private Runnable reportRunnable;
  private Set<String> timeSet = new HashSet();
  
  public static boolean isToday(long paramLong)
  {
    return (int)((System.currentTimeMillis() - paramLong) / 86400000L) == 0;
  }
  
  private static boolean isUinAuthorize(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    paramAppRuntime = (IGameMsgManagerService)paramAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
    paramString = paramAppRuntime.getSessionInfoByUin(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return paramAppRuntime.isGameMsgSync(paramString.h());
  }
  
  private boolean shouldFilterOutCurMsg(GameCenterSessionInfo paramGameCenterSessionInfo, IGameMsgManagerService paramIGameMsgManagerService)
  {
    IGameMsgBoxManager localIGameMsgBoxManager = (IGameMsgBoxManager)this.mAppRuntime.getRuntimeService(IGameMsgBoxManager.class, "");
    return (paramGameCenterSessionInfo.h() == null) || (paramIGameMsgManagerService.isGameMsgBlocked(paramGameCenterSessionInfo.h())) || (!paramIGameMsgManagerService.isGameMsgSync(paramGameCenterSessionInfo.h())) || ((localIGameMsgBoxManager.getGameMsgBoxSp().contains("size")) && (!localIGameMsgBoxManager.isGameInGameBox(paramGameCenterSessionInfo.h())));
  }
  
  public void addAuthorizeShow(String paramString)
  {
    try
    {
      if (this.timeSet.contains(paramString))
      {
        QLog.d("GameMsgBoxRuntimeServiceImpl", 1, "addAuth but exist");
        return;
      }
      boolean bool3 = isToday(getLastAuthTime().longValue() * 1000L);
      if (QLog.isColorLevel())
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (!bool3)
        {
          bool1 = bool2;
          if (this.timeSet.size() < 1) {
            bool1 = true;
          }
        }
        QLog.d("GameMsgBoxRuntimeServiceImpl", 1, new Object[] { "addAuthShow: ", Boolean.valueOf(bool1), " times is: ", paramString });
      }
      if ((!bool3) && (this.timeSet.size() < 1))
      {
        this.timeSet.add(String.valueOf(paramString));
        paramString = this.mSharedPreferences.edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_key_game_time_set");
        localStringBuilder.append(this.mAppRuntime.getAccount());
        paramString.putStringSet(localStringBuilder.toString(), this.timeSet).apply();
      }
      return;
    }
    finally {}
  }
  
  public void buildGameBox()
  {
    if ((((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab()) && (!((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()))
    {
      RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.mAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.GAME_MSG_BOX_UIN, 10015);
      if (getGameRecentUser().isEmpty()) {
        QLog.d("GameMsgBoxRuntimeServiceImpl", 1, "build game box but list is empty");
      }
      if (((localRecentUserProxy instanceof FullCache)) && (!localRecentUserProxy.c(localRecentUser)))
      {
        QLog.d("GameMsgBoxRuntimeServiceImpl", 1, "add to cache");
        ((FullCache)localRecentUserProxy).addCache(localRecentUser);
      }
      return;
    }
    QLog.d("GameMsgBoxRuntimeServiceImpl", 1, "buildGameBox but ab is false");
  }
  
  public boolean getBoxIsRead()
  {
    return this.isRead.get();
  }
  
  public int getBoxUnReadCnt()
  {
    if ((!getBoxIsRead()) && (getDataReady()))
    {
      IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)this.mAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
      if (this.mIConversationFacade.isUinInRecentList(AppConstants.GAME_MSG_BOX_UIN, 10015))
      {
        Object localObject = localIGameMsgManagerService.getSessionInfoList(2, "-10001");
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          int i = 0;
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)((Iterator)localObject).next();
            if (!shouldFilterOutCurMsg(localGameCenterSessionInfo, localIGameMsgManagerService)) {
              i += localGameCenterSessionInfo.o();
            }
          }
        }
        int j = 0;
        if (QLog.isColorLevel()) {
          QLog.d("GameMsgBoxRuntimeServiceImpl", 1, new Object[] { "getBoxUnreadCnt: ", Integer.valueOf(j) });
        }
        return j;
      }
      return 0;
    }
    QLog.d("GameMsgBoxRuntimeServiceImpl", 1, "getBoxUnread but box is read");
    return 0;
  }
  
  public boolean getDataReady()
  {
    return dataReady.get();
  }
  
  public List<RecentUser> getGameRecentUser()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((IRecentUserProxyService)this.mAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    int i = 0;
    localObject = ((RecentUserProxy)localObject).a(true, false);
    while (i < ((List)localObject).size())
    {
      RecentUser localRecentUser = (RecentUser)((List)localObject).get(i);
      if (10007 == localRecentUser.type) {
        localArrayList.add(localRecentUser);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean getGameTop()
  {
    SharedPreferences localSharedPreferences = this.mSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_game_top");
    localStringBuilder.append(this.mAppRuntime.getAccount());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public Long getLastAuthTime()
  {
    String str1 = null;
    try
    {
      Iterator localIterator = this.timeSet.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break label86;
        }
        str2 = (String)localIterator.next();
        if (str1 == null) {
          break;
        }
      } while (Long.parseLong(str1) >= Long.parseLong(str2));
      break label80;
      l = Long.parseLong(str1);
      return Long.valueOf(l);
    }
    finally
    {
      for (;;)
      {
        String str2;
        long l;
        for (;;)
        {
          throw localObject1;
        }
        label80:
        Object localObject2 = str2;
        continue;
        label86:
        if (localObject2 == null) {
          l = 0L;
        }
      }
    }
  }
  
  public boolean isAuthorizeShow(String paramString)
  {
    try
    {
      boolean bool2 = this.timeSet.contains(paramString);
      boolean bool1 = true;
      if (bool2) {
        return true;
      }
      if ((this.timeSet.size() < 1) && (Long.parseLong(paramString) > getLastAuthTime().longValue()))
      {
        bool2 = isToday(getLastAuthTime().longValue() * 1000L);
        if (!bool2) {}
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean isCurMsgNeedShowRed(MessageRecord paramMessageRecord)
  {
    AppRuntime localAppRuntime = this.mAppRuntime;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAppRuntime != null)
    {
      if (paramMessageRecord == null) {
        return false;
      }
      if (!((IGameMsgBoxManager)localAppRuntime.getRuntimeService(IGameMsgBoxManager.class, "")).isGameInGameBox((BaseQQAppInterface)this.mAppRuntime, paramMessageRecord.frienduin)) {
        return false;
      }
      if (!isUinAuthorize(this.mAppRuntime, paramMessageRecord.frienduin, true))
      {
        bool1 = bool2;
        if (!isUinAuthorize(this.mAppRuntime, paramMessageRecord.frienduin, true))
        {
          bool1 = bool2;
          if (!isAuthorizeShow(String.valueOf(paramMessageRecord.time))) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isMsgAuthorizeShow(String paramString)
  {
    try
    {
      boolean bool = this.timeSet.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
    this.mSharedPreferences = this.mAppRuntime.getApplication().getSharedPreferences("sp_game_msg_read", 0);
    Object localObject1 = this.isRead;
    Object localObject2 = this.mSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_game_msg_read");
    localStringBuilder.append(this.mAppRuntime.getAccount());
    ((AtomicBoolean)localObject1).set(((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), false));
    this.mIConversationFacade = ((IConversationFacade)paramAppRuntime.getRuntimeService(IConversationFacade.class, ""));
    localObject1 = this.mSharedPreferences;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sp_key_game_time_set");
    ((StringBuilder)localObject2).append(this.mAppRuntime.getAccount());
    this.timeSet = ((SharedPreferences)localObject1).getStringSet(((StringBuilder)localObject2).toString(), this.timeSet);
    this.mPageView = new LinearLayout(paramAppRuntime.getApp());
    this.mElementView = new View(paramAppRuntime.getApp());
    this.mPageView.addView(this.mElementView);
  }
  
  public void onDestroy() {}
  
  public void processGameMsg(RecentUserProxy paramRecentUserProxy, MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.frienduin;
    if (!isUinAuthorize(this.mAppRuntime, str, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameMsgBoxRuntimeServiceImpl", 1, "processGameMsg: but use not Auth");
      }
      paramRecentUserProxy = paramRecentUserProxy.b(AppConstants.GAME_MSG_BOX_UIN, 10015);
      if (!isAuthorizeShow(String.valueOf(paramMessageRecord.time)))
      {
        long l;
        if (paramRecentUserProxy.lastmsgtime == 0L) {
          l = paramMessageRecord.time;
        } else {
          l = paramRecentUserProxy.lastmsgtime;
        }
        paramMessageRecord.saveExtInfoToExtStr("mr_ext_show_time", String.valueOf(l));
      }
    }
  }
  
  public void reportItemEvent(String paramString1, String paramString2, String paramString3)
  {
    VideoReport.setPageId(this.mPageView, paramString2);
    VideoReport.setElementId(this.mElementView, paramString3);
    paramString3 = new HashMap();
    if (getBoxUnReadCnt() > 0) {
      paramString2 = "1";
    } else {
      paramString2 = "2";
    }
    paramString3.put("red_dot", paramString2);
    VideoReport.setElementParam(this.mElementView, "red_dot", paramString2);
    ThreadManagerV2.executeOnSubThread(new GameMsgBoxRuntimeServiceImpl.2(this, paramString1, paramString3));
  }
  
  public void reportItemExp(AppInterface paramAppInterface, View paramView, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, Object paramObject, int[] paramArrayOfInt)
  {
    if (!(paramObject instanceof RecentItemGameMsgBoxData)) {
      return;
    }
    VideoReport.setPageId(paramView.getRootView(), "pg_gb_entrance");
    VideoReport.setElementId(paramView, "em_gb_box");
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    RecentItemGameMsgBoxData localRecentItemGameMsgBoxData = (RecentItemGameMsgBoxData)paramObject;
    int i = localRecentItemGameMsgBoxData.mUnreadNum;
    paramObject = "1";
    if (i > 0) {
      paramAppInterface = "1";
    } else {
      paramAppInterface = "2";
    }
    VideoReport.setElementParam(paramView, "red_dot", paramAppInterface);
    HashMap localHashMap = new HashMap();
    if (localRecentItemGameMsgBoxData.mUnreadNum > 0) {
      paramAppInterface = paramObject;
    } else {
      paramAppInterface = "2";
    }
    localHashMap.put("red_dot", paramAppInterface);
    paramAppInterface = this.reportRunnable;
    if (paramAppInterface != null) {
      paramView.removeCallbacks(paramAppInterface);
    }
    this.reportRunnable = new GameMsgBoxRuntimeServiceImpl.1(this);
    paramView.postDelayed(this.reportRunnable, 3000L);
    paramAppInterface = paramSwipItemBaseHolder.rightMenuItems;
    int j = paramAppInterface.length;
    i = 0;
    while (i < j)
    {
      paramView = paramAppInterface[i];
      if (Utils.a(Integer.valueOf(paramView.menuId), Integer.valueOf(paramArrayOfInt[0]))) {
        VideoReport.setElementId(paramView.menuView, "em_gb_box_top_cancel");
      } else if (Utils.a(Integer.valueOf(paramView.menuId), Integer.valueOf(paramArrayOfInt[1]))) {
        VideoReport.setElementId(paramView.menuView, "em_gb_box_top");
      } else if (Utils.a(Integer.valueOf(paramView.menuId), Integer.valueOf(paramArrayOfInt[2]))) {
        VideoReport.setElementId(paramView.menuView, "em_gb_box_delete");
      }
      i += 1;
    }
  }
  
  public void setBoxRead(boolean paramBoolean)
  {
    this.isRead.set(paramBoolean);
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_game_msg_read");
    localStringBuilder.append(this.mAppRuntime.getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgBoxRuntimeServiceImpl", 2, new Object[] { "setBoxRead: ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void setDataReady()
  {
    dataReady.set(true);
  }
  
  public void setGameTop(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_game_top");
    localStringBuilder.append(this.mAppRuntime.getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxRuntimeServiceImpl
 * JD-Core Version:    0.7.0.1
 */