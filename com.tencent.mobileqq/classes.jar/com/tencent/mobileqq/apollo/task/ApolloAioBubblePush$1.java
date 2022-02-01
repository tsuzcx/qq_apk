package com.tencent.mobileqq.apollo.task;

import amsx;
import anlm;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ApolloAioBubblePush$1
  implements Runnable
{
  public ApolloAioBubblePush$1(anlm paramanlm, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    amsx localamsx = (amsx)this.a.getManager(153);
    Object localObject2 = localamsx.a(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localamsx.a(3);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localamsx.a(9);
    }
    Object localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = localamsx.a(2);
    }
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = localamsx.a(10);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        QLog.d("ApolloAioBubblePush", 2, new Object[] { "onEnterAIO, pick BUBBLE_PUSH_MSG_TYPE_AIO_GUIDE_3D, pushItem=", localObject2 });
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localamsx.a(7);
      localamsx.o = false;
    }
    if ((localObject2 != null) && (((DrawerPushItem)localObject2).reddotGameId > 0)) {
      localamsx.f(((DrawerPushItem)localObject2).reddotGameId);
    }
    if ((localObject2 == null) || (((DrawerPushItem)localObject2).show_sum < ((DrawerPushItem)localObject2).show_counts)) {
      anlm.a(this.this$0, (DrawerPushItem)localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAioBubblePush", 2, new Object[] { "[onEnterAIO] pushItem:", anlm.a(this.this$0) });
    }
    anlm.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloAioBubblePush.1
 * JD-Core Version:    0.7.0.1
 */