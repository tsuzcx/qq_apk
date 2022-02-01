package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Queue;

class BusinessEggsAnimation$BusinessEggsQueueDriver
  implements Runnable
{
  private BusinessEggsAnimation$BusinessEggsQueueDriver(BusinessEggsAnimation paramBusinessEggsAnimation) {}
  
  public void run()
  {
    if ((BusinessEggsAnimation.c(this.this$0).isEmpty()) && (BusinessEggsAnimation.b(this.this$0).isEmpty()) && (BusinessEggsAnimation.a(this.this$0).isEmpty()))
    {
      BusinessEggsAnimation.a(this.this$0, BusinessEggsAnimation.a(this.this$0));
      BusinessEggsAnimation.a(this.this$0, null);
      if (QLog.isColorLevel()) {
        QLog.i("BusinessEggsAnimation", 2, "[BusinessEggsQueueDriver#run] all queues empty");
      }
      return;
    }
    if (!BusinessEggsAnimation.c(this.this$0).isEmpty())
    {
      BusinessEggsElement localBusinessEggsElement = (BusinessEggsElement)BusinessEggsAnimation.c(this.this$0).remove();
      BusinessEggsAnimation.a(this.this$0).add(localBusinessEggsElement);
      localBusinessEggsElement.a();
      if (QLog.isColorLevel()) {
        QLog.i("BusinessEggsAnimation", 2, "[BusinessEggsQueueDriver#run] peak one then play");
      }
    }
    BusinessEggsAnimation.a(this.this$0, BusinessEggsAnimation.b(this.this$0));
    BusinessEggsAnimation.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation.BusinessEggsQueueDriver
 * JD-Core Version:    0.7.0.1
 */