package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCSubCloud;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class TRTCCloudImpl$15
  implements Runnable
{
  TRTCCloudImpl$15(TRTCCloudImpl paramTRTCCloudImpl, TRTCSubCloud paramTRTCSubCloud) {}
  
  public void run()
  {
    this.this$0.mSubClouds.add(new WeakReference(this.val$subCloud));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.15
 * JD-Core Version:    0.7.0.1
 */