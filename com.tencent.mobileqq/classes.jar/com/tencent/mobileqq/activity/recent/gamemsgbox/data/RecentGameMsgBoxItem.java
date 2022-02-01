package com.tencent.mobileqq.activity.recent.gamemsgbox.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.IGameMsgCallback;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class RecentGameMsgBoxItem
  extends RecentUserBaseData
{
  public static final int SEX_FEMALE = 2;
  public static final int SEX_MALE = 1;
  public static final int SEX_UNKNOW = 0;
  private static final String TAG = "RecentGameMsgBoxItem";
  private static Map<Integer, String> sOnlineTypeMap = new HashMap();
  public String mGameLevelUrl;
  public String mGameName;
  public String mGameRankUrl;
  public boolean mIsSetTop;
  public int mSex;
  
  static
  {
    sOnlineTypeMap.put(Integer.valueOf(1), "[在线]");
    sOnlineTypeMap.put(Integer.valueOf(2), "[游戏中]");
  }
  
  public RecentGameMsgBoxItem(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a()
  {
    boolean bool;
    if (e().showUpTime != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsSetTop = bool;
    this.mMenuFlag &= 0xFFFFFF0F;
    int j = this.mMenuFlag;
    int i;
    if (this.mIsSetTop) {
      i = 32;
    } else {
      i = 16;
    }
    this.mMenuFlag = (j | i);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    GameDetailInfo localGameDetailInfo = ((IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class)).findGameDetailInfoByConvertUin(this.mUser.uin);
    if (localGameDetailInfo != null) {
      this.mTitleName = localGameDetailInfo.e;
    }
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(getRecentUserUin(), paramBaseQQAppInterface);
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage, int paramInt, MsgSummary paramMsgSummary)
  {
    GameDetailInfo localGameDetailInfo2 = ((IGameMsgManagerService)paramBaseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetail(RoleIdUtil.b(paramMessage));
    GameDetailInfo localGameDetailInfo1 = localGameDetailInfo2;
    if (localGameDetailInfo2 == null) {
      localGameDetailInfo1 = ((IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class)).findGameDetailInfoByConvertUin(this.mUser.uin);
    }
    if ((localGameDetailInfo1 != null) && (sOnlineTypeMap.get(Integer.valueOf(localGameDetailInfo1.j)) != null)) {
      paramMsgSummary.prefixOfContent = ((CharSequence)sOnlineTypeMap.get(Integer.valueOf(localGameDetailInfo1.j)));
    }
    ((IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class, "")).getCallback().a(paramContext, paramBaseQQAppInterface, paramMessage, paramInt, paramMsgSummary, false, false);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    GameDetailInfo localGameDetailInfo = ((IGameMsgManagerService)paramBaseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetail(RoleIdUtil.b(paramMessage));
    paramMessage = localGameDetailInfo;
    if (localGameDetailInfo == null) {
      paramMessage = ((IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class)).findGameDetailInfoByConvertUin(this.mUser.uin);
    }
    if (paramMessage != null)
    {
      if (paramMessage.i == 1) {
        this.mSex = 1;
      } else if (paramMessage.i == 2) {
        this.mSex = 2;
      } else {
        this.mSex = 0;
      }
      this.mGameName = paramMessage.k;
      this.mGameLevelUrl = paramMessage.g;
      this.mGameRankUrl = paramMessage.q;
      paramMessage.a();
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, String paramString)
  {
    if (paramMessage != null)
    {
      this.mDisplayTime = paramMessage.time;
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mUser.lastmsgtime;
      }
      this.mUnreadNum = ((IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(paramMessage.frienduin, paramMessage.istroop);
      paramMessage.nickName = null;
      return;
    }
    this.mDisplayTime = 0L;
    this.mUnreadNum = 0;
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary, DraftSummaryInfo paramDraftSummaryInfo)
  {
    if ((paramDraftSummaryInfo != null) && (!TextUtils.isEmpty(paramDraftSummaryInfo.getSummary())))
    {
      this.mDisplayTime = paramDraftSummaryInfo.getTime();
      paramMsgSummary.bShowDraft = true;
      String str2 = paramDraftSummaryInfo.getSummary();
      String str1 = "";
      Object localObject = (IGameMsgManagerService)paramBaseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
      IMessageFacade localIMessageFacade = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      paramDraftSummaryInfo = str1;
      if (localIMessageFacade != null)
      {
        paramDraftSummaryInfo = ((IGameMsgManagerService)localObject).getSingleGameDetail(RoleIdUtil.b(localIMessageFacade.getLastMessage(getRecentUserUin(), getRecentUserType())));
        localObject = paramDraftSummaryInfo;
        if (paramDraftSummaryInfo == null) {
          localObject = ((IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class)).findGameDetailInfoByConvertUin(this.mUser.uin);
        }
        paramDraftSummaryInfo = str1;
        if (localObject != null)
        {
          paramDraftSummaryInfo = str1;
          if (sOnlineTypeMap.get(Integer.valueOf(((GameDetailInfo)localObject).j)) != null) {
            paramDraftSummaryInfo = (String)sOnlineTypeMap.get(Integer.valueOf(((GameDetailInfo)localObject).j));
          }
        }
      }
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(paramDraftSummaryInfo);
      paramBaseQQAppInterface.append(str2);
      paramMsgSummary.mDraft = new QQText(paramBaseQQAppInterface.toString(), 3, 16);
    }
  }
  
  private void b(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    if (this.mLastMsg == null) {
      return;
    }
    if (AppSetting.e) {
      this.mContentDesc = c(paramBaseQQAppInterface, paramMessage).toString();
    }
  }
  
  private StringBuilder c(BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mTitleName);
    localStringBuilder.append(",");
    if (this.mUnreadNum != 0) {
      if (this.mUnreadNum == 1) {
        localStringBuilder.append(paramBaseQQAppInterface.getApplication().getString(2131917032));
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append(paramBaseQQAppInterface.getApplication().getString(2131917033));
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append(String.format(paramBaseQQAppInterface.getApplication().getString(2131917031), new Object[] { Integer.valueOf(this.mUnreadNum) }));
      }
    }
    if (this.mMsgExtroInfo != null)
    {
      localStringBuilder.append(this.mMsgExtroInfo);
      localStringBuilder.append(",");
    }
    Object localObject = ((IGameMsgManagerService)paramBaseQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetail(RoleIdUtil.b(paramMessage));
    paramMessage = (Message)localObject;
    if (localObject == null) {
      paramMessage = ((IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class)).findGameDetailInfoByConvertUin(this.mUser.uin);
    }
    localObject = this.mLastMsg.toString();
    paramBaseQQAppInterface = (BaseQQAppInterface)localObject;
    if (paramMessage != null)
    {
      paramBaseQQAppInterface = (BaseQQAppInterface)localObject;
      if (sOnlineTypeMap.get(Integer.valueOf(paramMessage.j)) != null) {
        paramBaseQQAppInterface = this.mLastMsg.toString().replace((CharSequence)sOnlineTypeMap.get(Integer.valueOf(paramMessage.j)), "");
      }
    }
    localStringBuilder.append(((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(paramBaseQQAppInterface));
    localStringBuilder.append(",");
    localStringBuilder.append(this.mShowTime);
    return localStringBuilder;
  }
  
  private void c()
  {
    this.mUnreadFlag = 1;
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
      if (this.mDisplayTime <= getLastDraftTime())
      {
        IMessageFacade localIMessageFacade = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
        if (localIMessageFacade != null) {
          a(paramBaseQQAppInterface, paramMsgSummary, localIMessageFacade.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType()));
        }
      }
    }
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject1 = getRecentUserUin();
      int i = getRecentUserType();
      Message localMessage = null;
      Object localObject2 = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (localObject2 != null) {
        localMessage = ((IMessageFacade)localObject2).getLastMessage((String)localObject1, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentGameMsgBoxItem", 2, new Object[] { "getLastMessage: ", localMessage });
      }
      a(paramBaseQQAppInterface);
      a(paramBaseQQAppInterface, localMessage);
      a(paramBaseQQAppInterface, localMessage, (String)localObject1);
      c();
      localObject1 = getMsgSummaryTemp();
      if (localObject1 == null) {
        return;
      }
      a(paramBaseQQAppInterface, paramContext, localMessage, i, (MsgSummary)localObject1);
      dealStatus(paramBaseQQAppInterface);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mStatus = ");
        ((StringBuilder)localObject2).append(this.mStatus);
        QLog.d("RecentGameMsgBoxItem", 2, ((StringBuilder)localObject2).toString());
      }
      dealDraft(paramBaseQQAppInterface, (MsgSummary)localObject1);
      extraUpdate(paramBaseQQAppInterface, paramContext, (MsgSummary)localObject1);
      a();
      b(paramBaseQQAppInterface, localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */