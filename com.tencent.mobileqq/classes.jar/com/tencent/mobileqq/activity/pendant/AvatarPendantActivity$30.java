package com.tencent.mobileqq.activity.pendant;

import com.tencent.mobileqq.apollo.handler.api.IApolloGetAvatarDataVasHandler;
import com.tencent.mobileqq.qroute.QRoute;

class AvatarPendantActivity$30
  implements Runnable
{
  AvatarPendantActivity$30(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    ((IApolloGetAvatarDataVasHandler)QRoute.api(IApolloGetAvatarDataVasHandler.class)).getApolloAvatarData(this.this$0.app, AvatarPendantActivity.m(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.30
 * JD-Core Version:    0.7.0.1
 */