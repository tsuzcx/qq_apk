package com.tencent.mobileqq.activity.richmedia.state;

import ahxs;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class RMVideoRecordState$1
  implements Runnable
{
  public RMVideoRecordState$1(ahxs paramahxs, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.unlockFrameSync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.1
 * JD-Core Version:    0.7.0.1
 */