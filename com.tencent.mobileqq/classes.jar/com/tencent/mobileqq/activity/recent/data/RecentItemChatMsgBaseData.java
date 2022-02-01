package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.msg.ConversationFacadeProxy;
import com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy;
import com.tencent.mobileqq.msg.api.IMessageFacade;

public class RecentItemChatMsgBaseData
  extends RecentUserBaseData
{
  public static final String IS_ENABLE_UNREAD_STATE = "isEnableUnreadState";
  @ParcelAnnotation.NotParcel
  protected Message mLastMessage;
  
  public RecentItemChatMsgBaseData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.mLastMessage = null;
    Object localObject = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    if (localObject != null)
    {
      if (!(((IMessageFacade)localObject).getQQMessageFacadeStub() instanceof QQMessageFacadeStub)) {
        return;
      }
      localObject = (QQMessageFacadeStub)((IMessageFacade)localObject).getQQMessageFacadeStub();
      if (localObject != null) {
        this.mLastMessage = ((QQMessageFacadeStub)localObject).getLastMessage(this.mUser.uin, this.mUser.getType());
      }
      localObject = this.mLastMessage;
      if (localObject != null) {
        this.mUnreadNum = ConversationFacadeProxy.a((Message)localObject, paramBaseQQAppInterface);
      } else {
        this.mUnreadNum = 0;
      }
      this.msgSummary = getMsgSummaryTemp();
    }
  }
  
  protected final void a()
  {
    Message localMessage = this.mLastMessage;
    if ((localMessage != null) && (localMessage.getTime() != 0L))
    {
      this.mDisplayTime = this.mLastMessage.getTime();
      if (this.mDisplayTime == 0L) {
        this.mDisplayTime = this.mUser.opTime;
      }
    }
    else
    {
      this.mDisplayTime = this.mUser.opTime;
    }
  }
  
  public boolean a()
  {
    int i = this.mUser.getType();
    boolean bool2 = false;
    boolean bool1;
    if (i != 0)
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
  
  protected final void buildMessageBody(Message paramMessage, int paramInt, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.buildMessageBody(paramMessage, paramInt, paramBaseQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public final void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    super.dealDraft(paramBaseQQAppInterface, paramMsgSummary);
  }
  
  public final void dealStatus(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super.dealStatus(paramBaseQQAppInterface);
  }
  
  protected void extraUpdate(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    dealStatus(paramBaseQQAppInterface);
    dealDraft(paramBaseQQAppInterface, paramMsgSummary);
    b();
    super.extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super.update(paramBaseQQAppInterface, paramContext);
    a(paramBaseQQAppInterface);
    if (this.mUser.getType() == 0)
    {
      a();
      this.mTitleName = ContactUtilsProxy.a(paramBaseQQAppInterface, this.mUser.uin, true);
      buildMessageBody(this.mLastMessage, this.mUser.getType(), paramBaseQQAppInterface, paramContext, this.msgSummary);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgBaseData
 * JD-Core Version:    0.7.0.1
 */