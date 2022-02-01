package com.tencent.mobileqq.activity.recent.gamemsgbox.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.imcore.proxy.msg.MsgUtilsProxy;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class RecentItemGameMsgBoxData
  extends RecentUserBaseData
{
  public static final String TAG = "RecentItemGameMsgBoxData";
  private boolean toastFlag = false;
  
  public RecentItemGameMsgBoxData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private Message a(BaseQQAppInterface paramBaseQQAppInterface, List<RecentUser> paramList, boolean paramBoolean)
  {
    IGameMsgBoxManager localIGameMsgBoxManager = (IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class);
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (!localIGameMsgBoxManager.isGameInGameBox(paramBaseQQAppInterface, localRecentUser.uin))
      {
        if (!this.toastFlag)
        {
          localIGameMsgBoxManager.updateShowGameMsgUpgradingToast(true);
          this.toastFlag = true;
        }
      }
      else if ((!b(paramBaseQQAppInterface, localRecentUser.uin)) && ((!paramBoolean) || (a(paramBaseQQAppInterface, localRecentUser.uin))) && ((paramList == null) || (Math.max(localRecentUser.lastmsgtime, localRecentUser.lastmsgdrafttime) > Math.max(paramList.lastmsgtime, paramList.lastmsgdrafttime)))) {
        paramList = localRecentUser;
      }
    }
    if (paramList == null) {
      return null;
    }
    return ((IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramList.uin, paramList.getType());
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, List<RecentUser> paramList, Message paramMessage)
  {
    Object localObject = (IGameMsgBoxRuntimeService)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "");
    paramContext = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "");
    IGameMsgBoxManager localIGameMsgBoxManager = (IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class);
    if (((IGameMsgBoxRuntimeService)localObject).getBoxIsRead())
    {
      this.mUnreadNum = 0;
      return;
    }
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject = (RecentUser)paramList.next();
      if ((a(paramBaseQQAppInterface, ((RecentUser)localObject).uin)) && (localIGameMsgBoxManager.isGameInGameBox(paramBaseQQAppInterface, ((RecentUser)localObject).uin))) {
        i += paramContext.getUnreadCount(((RecentUser)localObject).uin, ((RecentUser)localObject).getType());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemGameMsgBoxData", 1, new Object[] { "unreadCount: ", Integer.valueOf(i) });
    }
    if (i != 0)
    {
      this.mDisplayTime = paramMessage.time;
      this.mUser.lastmsgtime = paramMessage.time;
      this.mUnreadNum = i;
      this.mUnreadFlag = 1;
      return;
    }
    if ((!a(paramBaseQQAppInterface, paramMessage.frienduin)) && (c(paramBaseQQAppInterface, String.valueOf(paramMessage.time))) && (localIGameMsgBoxManager.isGameInGameBox(paramBaseQQAppInterface, paramMessage.frienduin)))
    {
      QLog.d("RecentItemGameMsgBoxData", 1, "unread show authorize msg");
      this.mDisplayTime = paramMessage.time;
      this.mUser.lastmsgtime = paramMessage.time;
      this.mUnreadNum = 1;
      this.mUnreadFlag = 2;
      ((IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "")).setUnreadMark(AppConstants.GAME_MSG_BOX_UIN, 10015, 0);
      return;
    }
    if ((TextUtils.isEmpty(paramMessage.getExtInfoFromExtStr("mr_ext_show_time"))) && (i == 0))
    {
      this.mUnreadNum = 0;
      return;
    }
    this.mUnreadNum = i;
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, List<RecentUser> paramList, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((paramMessage != null) && (!b(paramBaseQQAppInterface, paramMessage.frienduin)) && (d(paramBaseQQAppInterface, paramMessage.frienduin) != null)) {
      if (!a(paramBaseQQAppInterface, paramMessage.frienduin))
      {
        paramList = a(paramBaseQQAppInterface, paramList, true);
        long l = ((IGameMsgBoxRuntimeService)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getLastAuthTime().longValue();
        if ((paramList != null) && (paramList.time > l))
        {
          this.mDisplayTime = paramMessage.time;
          paramList.nickName = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(paramList.frienduin, paramBaseQQAppInterface);
          MsgUtilsProxy.a(paramContext, paramBaseQQAppInterface, paramList, this.mUser.type, paramMsgSummary, false, false);
          return;
        }
        if (c(paramBaseQQAppInterface, String.valueOf(paramMessage.time)))
        {
          paramBaseQQAppInterface = paramMessage.getExtInfoFromExtStr("mr_ext_show_time");
          if (QLog.isColorLevel())
          {
            boolean bool = false;
            if (paramList == null) {
              bool = true;
            }
            QLog.d("RecentItemGameMsgBoxData", 1, new Object[] { "lastMsg is null = ", Boolean.valueOf(bool), " times is: ", paramBaseQQAppInterface });
          }
        }
      }
    }
    try
    {
      this.mDisplayTime = Long.parseLong(paramBaseQQAppInterface);
    }
    catch (NumberFormatException paramBaseQQAppInterface)
    {
      label225:
      break label225;
    }
    this.mDisplayTime = paramMessage.time;
    paramMsgSummary.strContent = new QQText(HardCodeUtil.a(2131896923), 3, 16);
    return;
    MsgUtilsProxy.a(paramContext, paramBaseQQAppInterface, null, this.mUser.type, null, false, false);
    return;
    this.mDisplayTime = paramMessage.time;
    paramMessage.nickName = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(paramMessage.frienduin, paramBaseQQAppInterface);
    MsgUtilsProxy.a(paramContext, paramBaseQQAppInterface, paramMessage, this.mUser.type, paramMsgSummary, false, false);
    return;
    MsgUtilsProxy.a(paramContext, paramBaseQQAppInterface, null, this.mUser.type, null, false, false);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if (AppSetting.e)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(HardCodeUtil.a(2131896924));
      paramBaseQQAppInterface.append(this.mLastMsg.toString());
      this.mContentDesc = paramBaseQQAppInterface.toString();
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary, RecentUser paramRecentUser)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      this.mUser.lastmsgdrafttime = 0L;
      IMessageFacade localIMessageFacade = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      if ((localIMessageFacade != null) && (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) && (this.mDisplayTime < paramRecentUser.lastmsgdrafttime)) {
        a(paramBaseQQAppInterface, paramMsgSummary, paramRecentUser, localIMessageFacade.getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType()));
      }
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary, RecentUser paramRecentUser, DraftSummaryInfo paramDraftSummaryInfo)
  {
    if ((paramDraftSummaryInfo != null) && (!TextUtils.isEmpty(paramDraftSummaryInfo.getSummary())))
    {
      this.mDisplayTime = paramDraftSummaryInfo.getTime();
      this.mUser.lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
      paramMsgSummary.bShowDraft = true;
      paramBaseQQAppInterface = paramDraftSummaryInfo.getSummary();
      paramRecentUser = new StringBuilder();
      paramRecentUser.append("");
      paramRecentUser.append(paramBaseQQAppInterface);
      paramMsgSummary.mDraft = new QQText(paramRecentUser.toString(), 3, 16);
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    this.mStatus = 0;
    if (!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN))
    {
      paramBaseQQAppInterface = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (paramBaseQQAppInterface != null)
      {
        paramBaseQQAppInterface = paramBaseQQAppInterface.getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType());
        if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())))
        {
          this.mStatus = 4;
          return;
        }
        this.mStatus = 0;
      }
    }
  }
  
  private boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = (IGameMsgManagerService)paramBaseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    paramString = paramBaseQQAppInterface.getSessionInfoByUin(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemGameMsgBoxData", 1, "info is null");
    }
    if (paramString == null) {
      return false;
    }
    boolean bool = paramBaseQQAppInterface.isGameMsgSync(paramString.h());
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemGameMsgBoxData", 1, new Object[] { "is Uin Auth: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private boolean b(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = (IGameMsgManagerService)paramBaseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    paramString = paramBaseQQAppInterface.getSessionInfoByUin(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemGameMsgBoxData", 1, "info is null");
    }
    if (paramString == null) {
      return true;
    }
    boolean bool = paramBaseQQAppInterface.isGameMsgBlocked(paramString.h());
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemGameMsgBoxData", 1, new Object[] { "is Uin Block: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private boolean c(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = (IGameMsgBoxRuntimeService)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "");
    boolean bool = paramBaseQQAppInterface.isAuthorizeShow(paramString);
    if (bool) {
      paramBaseQQAppInterface.addAuthorizeShow(paramString);
    }
    return bool;
  }
  
  private String d(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((IGameMsgManagerService)paramBaseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoByUin(paramString).h();
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super.update(paramBaseQQAppInterface, paramContext);
    this.mTitleName = HardCodeUtil.a(2131896924);
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    List localList = ((IGameMsgBoxRuntimeService)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getGameRecentUser();
    Message localMessage = a(paramBaseQQAppInterface, localList, false);
    if (localMessage == null)
    {
      this.mUnreadNum = 0;
      this.msgSummary.a();
      extraUpdate(paramBaseQQAppInterface, paramContext, this.msgSummary);
      return;
    }
    Object localObject1 = null;
    Iterator localIterator = localList.iterator();
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      RecentUser localRecentUser;
      do
      {
        if (!localIterator.hasNext()) {
          break label158;
        }
        localRecentUser = (RecentUser)localIterator.next();
        localObject1 = localRecentUser;
        if (localObject2 == null) {
          break;
        }
      } while (Math.max(localRecentUser.lastmsgtime, localRecentUser.lastmsgdrafttime) <= Math.max(localObject2.lastmsgtime, localObject2.lastmsgdrafttime));
      localObject1 = localRecentUser;
    }
    label158:
    a(paramBaseQQAppInterface, paramContext, localList, localMessage, localMsgSummary);
    a(paramBaseQQAppInterface, paramContext, localList, localMessage);
    a(paramBaseQQAppInterface, localObject2);
    a(paramBaseQQAppInterface, this.msgSummary, localObject2);
    this.mUser.opTime = this.mDisplayTime;
    this.mUser.lastmsgtime = this.mDisplayTime;
    extraUpdate(paramBaseQQAppInterface, paramContext, localMsgSummary);
    a(paramBaseQQAppInterface, localMessage, localMsgSummary);
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportGameMsgBoxExplosure883(paramBaseQQAppInterface, this.mUnreadNum, localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentItemGameMsgBoxData
 * JD-Core Version:    0.7.0.1
 */