package com.tencent.mobileqq.apollo.screenshot.api.impl;

import com.tencent.qphone.base.util.QLog;

class ApolloAvatarVideoProcessorImpl$6
  implements ApolloAvatarVideoProcessorImpl.OnCompressFinishListener
{
  ApolloAvatarVideoProcessorImpl$6(ApolloAvatarVideoProcessorImpl paramApolloAvatarVideoProcessorImpl) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompressFinish isSuccess: ");
      localStringBuilder.append(paramBoolean);
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, localStringBuilder.toString());
      ApolloAvatarVideoProcessorImpl.access$1300(this.a, paramInt, paramString);
      return;
    }
    if (paramInt == ApolloAvatarVideoProcessorImpl.access$1600()[1])
    {
      paramString = new StringBuilder();
      paramString.append("onCompressFinish isSuccess: ");
      paramString.append(paramBoolean);
      paramString.append("encodeWithResolution resolution: ");
      paramString.append(paramInt);
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, paramString.toString());
      paramString = this.a;
      ApolloAvatarVideoProcessorImpl.access$1100(paramString, ApolloAvatarVideoProcessorImpl.access$1000(paramString, 1));
      return;
    }
    if (paramInt == ApolloAvatarVideoProcessorImpl.access$1600()[2])
    {
      paramString = new StringBuilder();
      paramString.append("onCompressFinish isSuccess: ");
      paramString.append(paramBoolean);
      paramString.append("encodeWithResolution resolution: ");
      paramString.append(paramInt);
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, paramString.toString());
      paramString = this.a;
      ApolloAvatarVideoProcessorImpl.access$1100(paramString, ApolloAvatarVideoProcessorImpl.access$1000(paramString, 2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl.6
 * JD-Core Version:    0.7.0.1
 */