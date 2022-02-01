package com.tencent.mobileqq.apollo.screenshot.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.screenshot.ApolloVideoUtils;
import java.io.File;

class ApolloAvatarVideoProcessorImpl$7
  implements Runnable
{
  ApolloAvatarVideoProcessorImpl$7(ApolloAvatarVideoProcessorImpl paramApolloAvatarVideoProcessorImpl, int paramInt, AppInterface paramAppInterface, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApolloAvatarVideoProcessorImpl.access$900(this.this$0));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("_compress.mp4");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = ApolloVideoUtils.a(this.b.getApplicationContext(), this.c, (String)localObject, this.a);
    ApolloAvatarVideoProcessorImpl.access$1700(this.this$0).a(bool, this.a, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl.7
 * JD-Core Version:    0.7.0.1
 */