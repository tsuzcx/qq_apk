package com.tencent.mobileqq.activity.richmedia.state;

import akvk;
import android.os.Handler;
import bbsu;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class RMVideoInitState$1
  implements Runnable
{
  public RMVideoInitState$1(akvk paramakvk) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoInitState", 2, "[@] delayInit,run start");
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.f())
    {
      RMVideoStateMgr.b(null);
      if (localRMVideoStateMgr.f()) {}
    }
    for (;;)
    {
      return;
      File localFile = new File(bbsu.a + File.separator + ".nomedia");
      if (!localFile.exists()) {}
      try
      {
        localFile.createNewFile();
        label84:
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoInitState", 2, "[@] delayInit, post timeout runnable");
        }
        localRMVideoStateMgr.a.postDelayed(this.this$0.a, 10000L);
        localRMVideoStateMgr.l();
        localRMVideoStateMgr.m();
        localRMVideoStateMgr.k();
        try
        {
          AVCodec.get().init();
          this.this$0.c = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RMVideoInitState", 2, "[@] delayInit,run finish");
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            localUnsatisfiedLinkError.printStackTrace();
            this.this$0.c = false;
          }
        }
      }
      catch (IOException localIOException)
      {
        break label84;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.1
 * JD-Core Version:    0.7.0.1
 */