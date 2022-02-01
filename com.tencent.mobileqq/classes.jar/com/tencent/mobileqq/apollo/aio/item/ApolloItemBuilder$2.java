package com.tencent.mobileqq.apollo.aio.item;

import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.statistics.product.ApolloAioBubbleReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloItemBuilder$2
  implements Runnable
{
  ApolloItemBuilder$2(ApolloItemBuilder paramApolloItemBuilder, MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    if (this.a.mApolloMessage == null) {
      return;
    }
    Object localObject = ((IApolloDaoManagerService)this.this$0.d.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(this.a.mApolloMessage.id);
    if ((localObject != null) && (this.this$0.f != null) && (this.b != null) && (!this.a.hasPlayed) && (((ApolloActionData)localObject).feeType == 1) && (this.this$0.f.a == 1))
    {
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.c, this.a, 0);
      ((ApolloItemBuilder.PlusOneManagerTask)localObject).e = this.this$0.o;
      ThreadManager.getUIHandler().post((Runnable)localObject);
      localObject = new ApolloItemBuilder.PlusOneManagerTask(this.this$0, this.c, this.a, 1);
      ThreadManager.getUIHandler().postDelayed((Runnable)localObject, 8000L);
      ApolloAioBubbleReportUtil.a.a(this.this$0.d, this.this$0.e, ApolloItemBuilder.a(this.this$0), this.this$0.f, this.a);
      ApolloItemBuilder.a(this.this$0, this.a.uniseq);
      return;
    }
    if (this.b != null)
    {
      ThreadManager.getUIHandler().post(new ApolloItemBuilder.2.1(this));
      return;
    }
    QLog.i("[cmshow]ApolloItemBuilder", 1, "convertView is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */