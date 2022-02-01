package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.trtc.TRTCCloudListener;
import java.io.UnsupportedEncodingException;

class TRTCCloudImpl$146
  implements Runnable
{
  TRTCCloudImpl$146(TRTCCloudImpl paramTRTCCloudImpl, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, int paramInt3) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null)
    {
      try
      {
        localTRTCCloudListener.onRecvCustomCmdMsg(this.val$userId, this.val$cmdID, this.val$seq, this.val$msg.getBytes("UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        TXCLog.e("TRTCCloudImpl", "onRecvCustomCmdMsg failed.", localUnsupportedEncodingException);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.146
 * JD-Core Version:    0.7.0.1
 */