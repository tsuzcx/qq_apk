package com.tencent.mobileqq.activity.richmedia;

import ahjd;
import awjj;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class NewFlowCameraActivity$EncodeTask$1
  implements Runnable
{
  public NewFlowCameraActivity$EncodeTask$1(ahjd paramahjd, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.a.jdField_a_of_type_JavaLangString + ",is to call AVideoCodec.recordSubmit()");
      }
      awjj.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        synchronized (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PTV.NewFlowCameraActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.a.jdField_a_of_type_JavaLangString + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.EncodeTask.1
 * JD-Core Version:    0.7.0.1
 */