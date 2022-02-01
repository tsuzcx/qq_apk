package com.tencent.mobileqq.apollo.meme.api.impl;

import com.tencent.mobileqq.apollo.meme.FrameData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ApolloBrickPlayerImpl$1$2
  implements Runnable
{
  ApolloBrickPlayerImpl$1$2(ApolloBrickPlayerImpl.1 param1, String paramString, ApolloBrickPlayerImpl.CustomMemePlayerListener paramCustomMemePlayerListener) {}
  
  public void run()
  {
    FrameData localFrameData = (FrameData)ApolloBrickPlayerImpl.access$1200().get(this.a);
    if (localFrameData == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("manual callback onRecordFrame for action:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", index:");
    localStringBuilder.append(localFrameData.d());
    QLog.w("[cmshow]ApolloBrickPlayer", 1, localStringBuilder.toString());
    this.b.a(this.c.this$0.mMemeAction, localFrameData.d(), localFrameData.e(), localFrameData.f(), localFrameData.g(), localFrameData.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.impl.ApolloBrickPlayerImpl.1.2
 * JD-Core Version:    0.7.0.1
 */