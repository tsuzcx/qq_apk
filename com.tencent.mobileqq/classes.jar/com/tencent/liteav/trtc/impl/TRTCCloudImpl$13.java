package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloud;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class TRTCCloudImpl$13
  implements Runnable
{
  TRTCCloudImpl$13(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloud paramTRTCCloud) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.mSubClouds.iterator();
    while (localIterator.hasNext())
    {
      TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)((WeakReference)localIterator.next()).get();
      if ((localTRTCCloudImpl != null) && (localTRTCCloudImpl == this.val$subCloud))
      {
        localTRTCCloudImpl.destroy();
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.13
 * JD-Core Version:    0.7.0.1
 */