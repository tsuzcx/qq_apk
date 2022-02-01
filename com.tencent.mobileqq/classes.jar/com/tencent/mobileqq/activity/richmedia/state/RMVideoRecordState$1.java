package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

class RMVideoRecordState$1
  implements Runnable
{
  RMVideoRecordState$1(RMVideoRecordState paramRMVideoRecordState, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.unlockFrameSync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.1
 * JD-Core Version:    0.7.0.1
 */