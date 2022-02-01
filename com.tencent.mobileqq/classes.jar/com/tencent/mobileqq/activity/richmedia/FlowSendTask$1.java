package com.tencent.mobileqq.activity.richmedia;

import aksc;
import bbva;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class FlowSendTask$1
  implements Runnable
{
  public FlowSendTask$1(aksc paramaksc) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_k_of_type_JavaLangString, 2, "FlowSendTask(): isPTV:" + this.this$0.d + ", mVideoFileDir:" + this.this$0.jdField_a_of_type_JavaLangString + ",is to call AVideoCodec.recordSubmit()");
      }
      bbva.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        this.this$0.jdField_k_of_type_Int = -6;
        synchronized (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.set(true);
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.this$0.jdField_k_of_type_JavaLangString, 2, "FlowSendTask(): isPTV:" + this.this$0.d + ", mVideoFileDir:" + this.this$0.jdField_a_of_type_JavaLangString + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowSendTask.1
 * JD-Core Version:    0.7.0.1
 */