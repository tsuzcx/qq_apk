package com.tencent.mobileqq.activity.richmedia.state;

import alxs;
import alyg;
import android.widget.Toast;
import anzj;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class RMFileEventNotify$1
  implements Runnable
{
  public RMFileEventNotify$1(alxs paramalxs) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[runOnUIThread][stopWatching-delete-quit]");
    }
    Toast.makeText(VideoEnvironment.a(), anzj.a(2131712332), 1).show();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a("RMFileEventNotify");
    if (localRMVideoStateMgr.a != null) {
      localRMVideoStateMgr.a.A();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMFileEventNotify.1
 * JD-Core Version:    0.7.0.1
 */