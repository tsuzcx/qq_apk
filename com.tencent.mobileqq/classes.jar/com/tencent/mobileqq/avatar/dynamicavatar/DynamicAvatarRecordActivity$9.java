package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class DynamicAvatarRecordActivity$9
  implements Runnable
{
  DynamicAvatarRecordActivity$9(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopRecord(): Async, mVideoFileDir:");
        localStringBuilder.append(this.a.s);
        localStringBuilder.append(",is to call AVideoCodec.recordSubmit()");
        QLog.i("DynamicAvatarRecordActivity", 2, localStringBuilder.toString());
      }
      RecordManager.a().b().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      synchronized (this.a.H)
      {
        this.a.H.set(true);
        this.a.H.notifyAll();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("stopRecord(): Async, mVideoFileDir:");
          ((StringBuilder)???).append(this.a.s);
          ((StringBuilder)???).append(", call AVideoCodec.recordSubmit() fail, error = ");
          ((StringBuilder)???).append(localUnsatisfiedLinkError.getMessage());
          QLog.d("DynamicAvatarRecordActivity", 2, ((StringBuilder)???).toString());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.9
 * JD-Core Version:    0.7.0.1
 */