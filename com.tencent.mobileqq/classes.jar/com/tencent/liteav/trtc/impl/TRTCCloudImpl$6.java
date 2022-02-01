package com.tencent.liteav.trtc.impl;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class TRTCCloudImpl$6
  implements Runnable
{
  TRTCCloudImpl$6(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.mSubClouds.iterator();
    while (localIterator.hasNext())
    {
      TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)((WeakReference)localIterator.next()).get();
      if (localTRTCCloudImpl != null) {
        localTRTCCloudImpl.setListenerHandler(TRTCCloudImpl.access$300(this.this$0));
      } else {
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.6
 * JD-Core Version:    0.7.0.1
 */