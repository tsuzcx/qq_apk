package com.tencent.mobileqq.activity.richmedia.state;

import alxx;
import anzj;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;

public class RMVideoRecordState$2
  implements Runnable
{
  public RMVideoRecordState$2(alxx paramalxx) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风读取数据错误...");
    }
    localRMVideoStateMgr.h = true;
    localRMVideoStateMgr.e = false;
    if (localRMVideoStateMgr.a != null)
    {
      if (localRMVideoStateMgr.a.i != -1) {
        break label95;
      }
      localRMVideoStateMgr.b(0, anzj.a(2131712349), false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风被禁用,音频录制失败 errorcode=" + localRMVideoStateMgr.a.i);
      }
      return;
      label95:
      if (localRMVideoStateMgr.a.i == -2) {
        localRMVideoStateMgr.b(0, anzj.a(2131712354), false);
      } else if (localRMVideoStateMgr.a.i == -3) {
        localRMVideoStateMgr.b(0, anzj.a(2131712356), false);
      } else {
        localRMVideoStateMgr.b(0, anzj.a(2131712352), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2
 * JD-Core Version:    0.7.0.1
 */