package com.tencent.mobileqq.apollo.task;

import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ApolloAioBubblePush$1
  implements Runnable
{
  ApolloAioBubblePush$1(ApolloAioBubblePush paramApolloAioBubblePush, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.a.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject2 = localApolloManagerServiceImpl.getCurrentPushItem(4);
    Object localObject1 = localObject2;
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
        QLog.d("ApolloAioBubblePush", 2, new Object[] { "onEnterAIO, pick BUBBLE_PUSH_MSG_TYPE_AIO_GUIDE_3D, pushItem=", localObject2 });
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localApolloManagerServiceImpl.getCurrentPushItem(7);
      localApolloManagerServiceImpl.mIsBubbleTab = false;
    }
    if ((localObject2 != null) && (((DrawerPushItem)localObject2).reddotGameId > 0)) {
      localApolloManagerServiceImpl.pushApolloPanelGame(((DrawerPushItem)localObject2).reddotGameId);
    }
    if ((localObject2 == null) || (((DrawerPushItem)localObject2).show_sum < ((DrawerPushItem)localObject2).show_counts)) {
      ApolloAioBubblePush.a(this.this$0, (DrawerPushItem)localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAioBubblePush", 2, new Object[] { "[onEnterAIO] pushItem:", ApolloAioBubblePush.a(this.this$0) });
    }
    ApolloAioBubblePush.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloAioBubblePush.1
 * JD-Core Version:    0.7.0.1
 */