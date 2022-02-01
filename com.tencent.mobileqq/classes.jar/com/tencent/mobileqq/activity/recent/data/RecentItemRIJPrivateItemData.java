package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatService;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class RecentItemRIJPrivateItemData
  extends RecentItemChatMsgBaseData
{
  public static final String DEFAULT_NICK_NAME = " ";
  public static final String TAG = "RecentItemRIJPrivateItemData";
  public String avatarUrl = "";
  private boolean mIsSetTop = false;
  private IReadInJoyUserInfoModule.RefreshUserInfoCallBack refreshUserCallback;
  
  public RecentItemRIJPrivateItemData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public RecentItemRIJPrivateItemData(RecentUser paramRecentUser, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    super(paramRecentUser);
    this.refreshUserCallback = paramRefreshUserInfoCallBack;
  }
  
  private void a(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.time != 0L))
    {
      this.mDisplayTime = paramMessage.time;
      this.mUnreadNum = j().getConversationFacade().getUnreadCount(paramMessage.frienduin, paramMessage.istroop);
    }
    else
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
    if (this.mDisplayTime == 0L) {
      this.mDisplayTime = e().opTime;
    }
  }
  
  private void a(Message paramMessage, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramMessage == null) {
      return;
    }
    paramMessage.prefixOfNickname = "";
    this.msgSummary = getMsgSummaryTemp();
    buildMessageBody(paramMessage, getRecentUserType(), paramBaseQQAppInterface, paramContext, this.msgSummary);
  }
  
  private void c()
  {
    long l;
    StringBuilder localStringBuilder;
    try
    {
      l = Long.parseLong(getRecentUserUin());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateTitleName] e = ");
      localStringBuilder.append(localNumberFormatException);
      QLog.e("RecentItemRIJPrivateItemData", 1, localStringBuilder.toString());
      l = 0L;
    }
    if (l == 0L)
    {
      QLog.i("RecentItemRIJPrivateItemData", 1, "[updateTitleName] uin is invalid.");
      return;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(l, this.refreshUserCallback);
    if (localReadInJoyUserInfo != null)
    {
      this.mTitleName = localReadInJoyUserInfo.nick;
      this.avatarUrl = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getResultFaceUrl(localReadInJoyUserInfo);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[updateTitleName] uinLong = ");
        localStringBuilder.append(l);
        localStringBuilder.append(", nick = ");
        localStringBuilder.append(localReadInJoyUserInfo.nick);
        localStringBuilder.append(", avatarUrl = ");
        localStringBuilder.append(this.avatarUrl);
        QLog.i("RecentItemRIJPrivateItemData", 2, localStringBuilder.toString());
      }
    }
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = " ";
    }
  }
  
  private void h()
  {
    this.mUnreadFlag = 1;
  }
  
  private void i()
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
  
  private IRIJPrivateChatService j()
  {
    return (IRIJPrivateChatService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IRIJPrivateChatService.class, "");
  }
  
  public int getRecentUserType()
  {
    return e().getType();
  }
  
  public String getRecentUserUin()
  {
    return e().uin;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super.update(paramBaseQQAppInterface, paramContext);
    if (paramContext == null) {
      return;
    }
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return;
    }
    Message localMessage = ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade().getLastMessage(getRecentUserUin(), getRecentUserType());
    a(localMessage);
    h();
    a(localMessage, paramBaseQQAppInterface, paramContext);
    dealStatus(paramBaseQQAppInterface);
    dealDraft(paramBaseQQAppInterface, this.msgSummary);
    extraUpdate(paramBaseQQAppInterface, paramContext, this.msgSummary);
    i();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemRIJPrivateItemData
 * JD-Core Version:    0.7.0.1
 */