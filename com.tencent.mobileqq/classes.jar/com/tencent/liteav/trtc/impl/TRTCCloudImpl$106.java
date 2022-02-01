package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$106
  implements Runnable
{
  TRTCCloudImpl$106(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEffectPlayStart -> effectId = ");
    localStringBuilder.append(this.val$effectId);
    localStringBuilder.append(" code = ");
    localStringBuilder.append(this.val$errCode);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$0.mTRTCListener;
    if (localObject != null)
    {
      int i = this.val$errCode;
      if (i < 0) {
        ((TRTCCloudListener)localObject).onAudioEffectFinished(this.val$effectId, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.106
 * JD-Core Version:    0.7.0.1
 */