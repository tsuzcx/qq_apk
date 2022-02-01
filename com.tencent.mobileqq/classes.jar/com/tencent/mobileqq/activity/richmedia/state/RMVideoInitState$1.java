package com.tencent.mobileqq.activity.richmedia.state;

import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class RMVideoInitState$1
  implements Runnable
{
  RMVideoInitState$1(RMVideoInitState paramRMVideoInitState) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit,run start");
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.n())
    {
      RMVideoStateMgr.b(null);
      if (!localRMVideoStateMgr.n()) {
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(GloableValue.b);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(".nomedia");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      label95:
      break label95;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit, post timeout runnable");
    }
    localRMVideoStateMgr.I.postDelayed(this.this$0.g, 10000L);
    localRMVideoStateMgr.s();
    localRMVideoStateMgr.t();
    localRMVideoStateMgr.r();
    try
    {
      AVCodec.get().init();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      this.this$0.c = false;
    }
    this.this$0.c = true;
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit,run finish");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.1
 * JD-Core Version:    0.7.0.1
 */