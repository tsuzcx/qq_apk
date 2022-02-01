package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class ApolloAvatarVideoProcessor$1
  implements Runnable
{
  ApolloAvatarVideoProcessor$1(ApolloAvatarVideoProcessor paramApolloAvatarVideoProcessor, AppInterface paramAppInterface) {}
  
  public void run()
  {
    ApolloAvatarVideoProcessor.a(this.this$0, new ApolloAvatarVideoProcessor.VideoUploadProcessorHandler(this.this$0, null));
    ApolloAvatarVideoProcessor.a(this.this$0).addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class, "all")).addHandle(ApolloAvatarVideoProcessor.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor.1
 * JD-Core Version:    0.7.0.1
 */