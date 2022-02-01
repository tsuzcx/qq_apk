package com.tencent.mobileqq.apollo.task;

import amme;
import anho;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class ApolloAioBubblePush$1
  implements Runnable
{
  public ApolloAioBubblePush$1(anho paramanho, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    amme localamme = (amme)this.a.getManager(QQManagerFactory.APOLLO_MANAGER);
    Object localObject2 = localamme.a(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localamme.a(3);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localamme.a(9);
    }
    Object localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = localamme.a(2);
    }
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = localamme.a(10);
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
      localObject2 = localamme.a(7);
      localamme.o = false;
    }
    if ((localObject2 != null) && (((DrawerPushItem)localObject2).reddotGameId > 0)) {
      localamme.f(((DrawerPushItem)localObject2).reddotGameId);
    }
    if ((localObject2 == null) || (((DrawerPushItem)localObject2).show_sum < ((DrawerPushItem)localObject2).show_counts)) {
      anho.a(this.this$0, (DrawerPushItem)localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAioBubblePush", 2, new Object[] { "[onEnterAIO] pushItem:", anho.a(this.this$0) });
    }
    anho.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloAioBubblePush.1
 * JD-Core Version:    0.7.0.1
 */