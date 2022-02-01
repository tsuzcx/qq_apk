package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ContactUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ConversationFacadeProxy;

public class RecentItemChatMsgBaseData
  extends RecentUserBaseData
{
  public static final String IS_ENABLE_UNREAD_STATE = "isEnableUnreadState";
  @ParcelAnnotation.NotParcel
  protected IMCoreMessageStub mLastMessage;
  
  public RecentItemChatMsgBaseData(BaseRecentUser paramBaseRecentUser)
  {
    super(paramBaseRecentUser);
  }
  
  private void handleCommonUpdateInner(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    this.mLastMessage = null;
    QQMessageFacadeStub localQQMessageFacadeStub = paramIMCoreAppRuntime.getMessageFacade();
    if (localQQMessageFacadeStub != null) {
      this.mLastMessage = localQQMessageFacadeStub.getLastMessage(this.mUser.uin, this.mUser.getType());
    }
    if (this.mLastMessage != null) {}
    for (this.mUnreadNum = RecentRoute.ConversationFacadeProxy.getUnreadCount(this.mLastMessage, paramIMCoreAppRuntime);; this.mUnreadNum = 0)
    {
      this.msgSummary = getMsgSummaryTemp();
      return;
    }
  }
  
  public final void buildMessageBody(IMCoreMessageStub paramIMCoreMessageStub, int paramInt, IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.buildMessageBody(paramIMCoreMessageStub, paramInt, paramIMCoreAppRuntime, paramContext, paramMsgSummary);
  }
  
  public final void dealDraft(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary)
  {
    super.dealDraft(paramIMCoreAppRuntime, paramMsgSummary);
  }
  
  public final void dealStatus(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    super.dealStatus(paramIMCoreAppRuntime);
  }
  
  public void extraUpdate(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    dealStatus(paramIMCoreAppRuntime);
    dealDraft(paramIMCoreAppRuntime, paramMsgSummary);
    updateMsgUnreadStateMenu();
    super.extraUpdate(paramIMCoreAppRuntime, paramContext, paramMsgSummary);
  }
  
  public boolean isEnableUnreadState()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.mUser.getType() != 0)
    {
      bool1 = bool2;
      if (this.mArgsBundle != null)
      {
        bool1 = bool2;
        if (!this.mArgsBundle.getBoolean("isEnableUnreadState", false)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  protected final void processC2CDisplayTimeInner()
  {
    if ((this.mLastMessage != null) && (this.mLastMessage.getTime() != 0L))
    {
      this.mDisplayTime = this.mLastMessage.getTime();
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mUser.opTime;
      }
      return;
    }
    this.mDisplayTime = this.mUser.opTime;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    super.update(paramIMCoreAppRuntime, paramContext);
    handleCommonUpdateInner(paramIMCoreAppRuntime);
    if (this.mUser.getType() == 0)
    {
      processC2CDisplayTimeInner();
      this.mTitleName = RecentRoute.ContactUtilsProxy.getBuddyName(paramIMCoreAppRuntime, this.mUser.uin, true);
      buildMessageBody(this.mLastMessage, this.mUser.getType(), paramIMCoreAppRuntime, paramContext, this.msgSummary);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgBaseData
 * JD-Core Version:    0.7.0.1
 */