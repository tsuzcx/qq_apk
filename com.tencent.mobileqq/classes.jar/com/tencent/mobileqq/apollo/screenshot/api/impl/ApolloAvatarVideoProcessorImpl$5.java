package com.tencent.mobileqq.apollo.screenshot.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.screenshot.ApolloVideoEncoder.OnEncodeFinishListener;
import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloAvatarVideoProcessorImpl$5
  implements ApolloVideoEncoder.OnEncodeFinishListener
{
  ApolloAvatarVideoProcessorImpl$5(ApolloAvatarVideoProcessorImpl paramApolloAvatarVideoProcessorImpl) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEncodeFinish: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ApolloAvatarVideoProcessorImpl.access$1000(this.a, 0));
      ((StringBuilder)localObject).append(".mp4");
      if (paramString.endsWith(((StringBuilder)localObject).toString()))
      {
        localObject = this.a;
        ApolloAvatarVideoProcessorImpl.access$1300((ApolloAvatarVideoProcessorImpl)localObject, ApolloAvatarVideoProcessorImpl.access$1000((ApolloAvatarVideoProcessorImpl)localObject, 0), paramString);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ApolloAvatarVideoProcessorImpl.access$1000(this.a, 1));
      ((StringBuilder)localObject).append(".mp4");
      if (paramString.endsWith(((StringBuilder)localObject).toString()))
      {
        localObject = this.a;
        ApolloAvatarVideoProcessorImpl.access$1300((ApolloAvatarVideoProcessorImpl)localObject, ApolloAvatarVideoProcessorImpl.access$1000((ApolloAvatarVideoProcessorImpl)localObject, 1), paramString);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ApolloAvatarVideoProcessorImpl.access$1000(this.a, 2));
      ((StringBuilder)localObject).append(".mp4");
      if (paramString.endsWith(((StringBuilder)localObject).toString()))
      {
        localObject = this.a;
        ApolloAvatarVideoProcessorImpl.access$1300((ApolloAvatarVideoProcessorImpl)localObject, ApolloAvatarVideoProcessorImpl.access$1000((ApolloAvatarVideoProcessorImpl)localObject, 2), paramString);
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("onEncodeFinish fail! errno = ");
      paramString.append(paramInt);
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, paramString.toString());
      if (paramInt == 2) {
        ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).delAllFrameFiles(ApolloAvatarVideoProcessorImpl.access$400(this.a), ApolloAvatarVideoProcessorImpl.access$1400(this.a), ((AppInterface)ApolloAvatarVideoProcessorImpl.access$1500(this.a).get()).getCurrentUin());
      }
      if (ApolloAvatarVideoProcessorImpl.access$300(this.a) != null) {
        ApolloAvatarVideoProcessorImpl.access$300(this.a).a(false, ApolloAvatarVideoProcessorImpl.access$400(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl.5
 * JD-Core Version:    0.7.0.1
 */