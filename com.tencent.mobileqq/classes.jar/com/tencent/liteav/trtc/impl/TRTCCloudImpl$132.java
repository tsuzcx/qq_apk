package com.tencent.liteav.trtc.impl;

import android.os.Bundle;

class TRTCCloudImpl$132
  implements Runnable
{
  TRTCCloudImpl$132(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_ID", this.val$notifyNo);
    localBundle.putLong("EVT_TIME", System.currentTimeMillis());
    localBundle.putString("EVT_MSG", this.val$errInfo);
    TRTCCloudImpl.access$9000(this.this$0, this.val$ID, this.val$notifyNo, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.132
 * JD-Core Version:    0.7.0.1
 */