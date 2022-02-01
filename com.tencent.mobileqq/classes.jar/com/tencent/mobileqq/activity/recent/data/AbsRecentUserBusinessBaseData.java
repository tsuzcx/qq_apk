package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;

public abstract class AbsRecentUserBusinessBaseData
  extends RecentUserBaseData
{
  public AbsRecentUserBusinessBaseData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  protected void a(Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
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
  
  public final void buildMessageBody(IMCoreMessageStub paramIMCoreMessageStub, int paramInt, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (((paramIMCoreMessageStub instanceof Message)) && ((paramBaseQQAppInterface instanceof QQAppInterface))) {
      a((Message)paramIMCoreMessageStub, paramInt, (QQAppInterface)paramBaseQQAppInterface, paramContext, paramMsgSummary);
    }
  }
  
  public final void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramMsgSummary);
    }
  }
  
  public final void dealStatus(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface);
    }
  }
  
  public final void extraUpdate(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext, paramMsgSummary);
    }
  }
  
  public final void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData
 * JD-Core Version:    0.7.0.1
 */