package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;

class RMVideoRecordState$2
  implements Runnable
{
  RMVideoRecordState$2(RMVideoRecordState paramRMVideoRecordState) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]麦克风读取数据错误...");
    }
    localRMVideoStateMgr.z = true;
    localRMVideoStateMgr.r = false;
    if (localRMVideoStateMgr.p != null)
    {
      if (localRMVideoStateMgr.p.t == -1) {
        localRMVideoStateMgr.b(0, HardCodeUtil.a(2131910945), false);
      } else if (localRMVideoStateMgr.p.t == -2) {
        localRMVideoStateMgr.b(0, HardCodeUtil.a(2131910950), false);
      } else if (localRMVideoStateMgr.p.t == -3) {
        localRMVideoStateMgr.b(0, HardCodeUtil.a(2131910952), false);
      } else {
        localRMVideoStateMgr.b(0, HardCodeUtil.a(2131910948), false);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] EVENT_READ_MIC [error]麦克风被禁用,音频录制失败 errorcode=");
        localStringBuilder.append(localRMVideoStateMgr.p.t);
        QLog.d("RMRecordState", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2
 * JD-Core Version:    0.7.0.1
 */