package com.tencent.mobileqq.apollo.player.api.impl;

import com.tencent.mobileqq.apollo.player.FrameData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ApolloBrickPlayerImpl$1$2
  implements Runnable
{
  ApolloBrickPlayerImpl$1$2(ApolloBrickPlayerImpl.1 param1, String paramString, ApolloBrickPlayerImpl.BrickCMSPlayerListener paramBrickCMSPlayerListener) {}
  
  public void run()
  {
    FrameData localFrameData = (FrameData)ApolloBrickPlayerImpl.access$1200().get(this.jdField_a_of_type_JavaLangString);
    if (localFrameData == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("manual callback onRecordFrame for action:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", index:");
    localStringBuilder.append(localFrameData.a());
    QLog.w("[cmshow]ApolloBrickPlayer", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiImplApolloBrickPlayerImpl$BrickCMSPlayerListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiImplApolloBrickPlayerImpl$1.this$0.mCMSAIOAction, localFrameData.a(), localFrameData.a(), localFrameData.b(), localFrameData.c(), localFrameData.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloBrickPlayerImpl.1.2
 * JD-Core Version:    0.7.0.1
 */