package com.tencent.mobileqq.apollo.api.player.impl;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ApolloBrickPlayerImpl$1$2
  implements Runnable
{
  ApolloBrickPlayerImpl$1$2(ApolloBrickPlayerImpl.1 param1, String paramString, ApolloBrickPlayerImpl.BrickCMSPlayerListener paramBrickCMSPlayerListener) {}
  
  public void run()
  {
    FrameData localFrameData = (FrameData)ApolloBrickPlayerImpl.access$1400().get(this.jdField_a_of_type_JavaLangString);
    if (localFrameData == null) {
      return;
    }
    QLog.w("ApolloBrickPlayer", 1, "manual callback onRecordFrame for action:" + this.jdField_a_of_type_JavaLangString + ", index:" + localFrameData.a());
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplApolloBrickPlayerImpl$BrickCMSPlayerListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplApolloBrickPlayerImpl$1.this$0.mCMSAIOAction, localFrameData.a(), localFrameData.a(), localFrameData.b(), localFrameData.c(), localFrameData.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloBrickPlayerImpl.1.2
 * JD-Core Version:    0.7.0.1
 */