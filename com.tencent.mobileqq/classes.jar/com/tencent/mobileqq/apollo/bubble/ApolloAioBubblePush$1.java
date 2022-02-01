package com.tencent.mobileqq.apollo.bubble;

import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class ApolloAioBubblePush$1
  implements Runnable
{
  ApolloAioBubblePush$1(ApolloAioBubblePush paramApolloAioBubblePush, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloManagerService.class, "all");
    Object localObject2 = localApolloManagerServiceImpl.getCurrentPushItem(4);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localApolloManagerServiceImpl.getCurrentPushItem(3);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localApolloManagerServiceImpl.getCurrentPushItem(9);
    }
    Object localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = localApolloManagerServiceImpl.getCurrentPushItem(2);
    }
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = localApolloManagerServiceImpl.getCurrentPushItem(10);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        QLog.d("[cmshow]ApolloAioBubblePush", 2, new Object[] { "onEnterAIO, pick BUBBLE_PUSH_MSG_TYPE_AIO_GUIDE_3D, pushItem=", localObject2 });
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localApolloManagerServiceImpl.getCurrentPushItem(7);
      localApolloManagerServiceImpl.mIsBubbleTab = false;
    }
    if ((localObject2 == null) || (((DrawerPushItem)localObject2).show_sum < ((DrawerPushItem)localObject2).show_counts)) {
      ApolloAioBubblePush.a(this.this$0, (DrawerPushItem)localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloAioBubblePush", 2, new Object[] { "[onEnterAIO] pushItem:", ApolloAioBubblePush.a(this.this$0) });
    }
    ApolloAioBubblePush.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.bubble.ApolloAioBubblePush.1
 * JD-Core Version:    0.7.0.1
 */