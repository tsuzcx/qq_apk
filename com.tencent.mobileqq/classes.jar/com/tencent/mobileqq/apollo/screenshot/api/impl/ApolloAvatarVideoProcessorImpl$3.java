package com.tencent.mobileqq.apollo.screenshot.api.impl;

import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ApolloAvatarVideoProcessorImpl$3
  implements IApolloAvatarFileManager.OnGetFramePathListener
{
  ApolloAvatarVideoProcessorImpl$3(ApolloAvatarVideoProcessorImpl paramApolloAvatarVideoProcessorImpl) {}
  
  public void a(boolean paramBoolean, List<String> paramList, int paramInt)
  {
    if ((paramBoolean) && (paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = this.a;
      ApolloAvatarVideoProcessorImpl.access$502((ApolloAvatarVideoProcessorImpl)localObject, ApolloAvatarVideoProcessorImpl.access$600((ApolloAvatarVideoProcessorImpl)localObject, paramList));
      localObject = ApolloAvatarVideoProcessorImpl.access$700(this.a, paramInt);
      if (localObject == null)
      {
        QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, "exits due to videoDirPath null");
        if (ApolloAvatarVideoProcessorImpl.access$300(this.a) != null) {
          ApolloAvatarVideoProcessorImpl.access$300(this.a).a(false, ApolloAvatarVideoProcessorImpl.access$400(this.a));
        }
        return;
      }
      ApolloAvatarVideoProcessorImpl.access$802(this.a, new ArrayList());
      ApolloAvatarVideoProcessorImpl.access$800(this.a).addAll(paramList);
      ApolloAvatarVideoProcessorImpl.access$902(this.a, (String)localObject);
      paramList = new StringBuilder();
      paramList.append("videoPath = ");
      paramList.append((String)localObject);
      paramList.append(", cover path = ");
      paramList.append(ApolloAvatarVideoProcessorImpl.access$500(this.a));
      paramList.append(", pic list size = ");
      paramList.append(ApolloAvatarVideoProcessorImpl.access$800(this.a).size());
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, paramList.toString());
      paramList = this.a;
      ApolloAvatarVideoProcessorImpl.access$1100(paramList, ApolloAvatarVideoProcessorImpl.access$1000(paramList, 0));
      return;
    }
    QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, "getFrameFilePath pic list is empty");
    if (ApolloAvatarVideoProcessorImpl.access$300(this.a) != null) {
      ApolloAvatarVideoProcessorImpl.access$300(this.a).a(false, ApolloAvatarVideoProcessorImpl.access$400(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl.3
 * JD-Core Version:    0.7.0.1
 */