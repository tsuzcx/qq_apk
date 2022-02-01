package com.tencent.mobileqq.apollo.screenshot.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class ApolloAvatarVideoProcessorImpl$1
  implements Runnable
{
  ApolloAvatarVideoProcessorImpl$1(ApolloAvatarVideoProcessorImpl paramApolloAvatarVideoProcessorImpl, AppInterface paramAppInterface) {}
  
  public void run()
  {
    ApolloAvatarVideoProcessorImpl localApolloAvatarVideoProcessorImpl = this.this$0;
    ApolloAvatarVideoProcessorImpl.access$002(localApolloAvatarVideoProcessorImpl, new ApolloAvatarVideoProcessorImpl.VideoUploadProcessorHandler(localApolloAvatarVideoProcessorImpl, null));
    ApolloAvatarVideoProcessorImpl.access$000(this.this$0).addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class, "all")).addHandle(ApolloAvatarVideoProcessorImpl.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl.1
 * JD-Core Version:    0.7.0.1
 */