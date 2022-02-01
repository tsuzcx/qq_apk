package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$164
  implements Runnable
{
  TRTCCloudImpl$164(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt3) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null)
    {
      localTRTCCloudListener.onRecvCustomCmdMsg(this.val$userId, this.val$cmdID, this.val$seq, this.val$msg);
      if (this.val$ordered)
      {
        int i = this.val$missMsgCount;
        if (i > 0) {
          localTRTCCloudListener.onMissCustomCmdMsg(this.val$userId, this.val$cmdID, -1, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.164
 * JD-Core Version:    0.7.0.1
 */