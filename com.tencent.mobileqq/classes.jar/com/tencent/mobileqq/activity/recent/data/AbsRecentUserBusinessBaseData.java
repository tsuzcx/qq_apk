package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public abstract class AbsRecentUserBusinessBaseData
  extends RecentUserBaseData
{
  @ParcelAnnotation.NotParcel
  public RecentUser mUser;
  
  public AbsRecentUserBusinessBaseData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUser = paramRecentUser;
  }
  
  public RecentUser a()
  {
    return this.mUser;
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.buildMessageBody(paramMessage, paramInt, paramQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.dealStatus(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.update(paramQQAppInterface, paramContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.extraUpdate(paramQQAppInterface, paramContext, paramMsgSummary);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    super.dealDraft(paramQQAppInterface, paramMsgSummary);
  }
  
  public final void buildMessageBody(IMCoreMessageStub paramIMCoreMessageStub, int paramInt, IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (((paramIMCoreMessageStub instanceof QQMessageFacade.Message)) && ((paramIMCoreAppRuntime instanceof QQAppInterface))) {
      a((QQMessageFacade.Message)paramIMCoreMessageStub, paramInt, (QQAppInterface)paramIMCoreAppRuntime, paramContext, paramMsgSummary);
    }
  }
  
  public final void dealDraft(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramMsgSummary);
    }
  }
  
  public final void dealStatus(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime);
    }
  }
  
  public final void extraUpdate(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext, paramMsgSummary);
    }
  }
  
  public final void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData
 * JD-Core Version:    0.7.0.1
 */