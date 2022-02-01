package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$147
  implements Runnable
{
  TRTCCloudImpl$147(TRTCCloudImpl paramTRTCCloudImpl, long paramLong, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject = this.this$0.mTRTCListener;
    if (localObject != null) {
      try
      {
        String str = this.this$0.mRoomInfo.getUserIdByTinyId(this.val$tinyId);
        if (str != null)
        {
          long l = System.currentTimeMillis();
          TRTCCloudImpl.access$8108(this.this$0);
          if (l - TRTCCloudImpl.access$8200(this.this$0) > 10000L)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onRecvSEIMsg. userId=");
            localStringBuilder.append(str);
            localStringBuilder.append(", message = ");
            localStringBuilder.append(new String(this.val$message));
            localStringBuilder.append(", recvSEIMsgCountInPeriod = ");
            localStringBuilder.append(TRTCCloudImpl.access$8100(this.this$0));
            localStringBuilder.append(" self:");
            localStringBuilder.append(this.this$0.hashCode());
            TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
            TRTCCloudImpl.access$8202(this.this$0, l);
            TRTCCloudImpl.access$8102(this.this$0, 0L);
          }
          ((TRTCCloudListener)localObject).onRecvSEIMsg(str, this.val$message);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecvSEIMsg Error, user id is null for tinyId=");
        ((StringBuilder)localObject).append(this.val$tinyId);
        ((StringBuilder)localObject).append(" self:");
        ((StringBuilder)localObject).append(this.this$0.hashCode());
        TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
        return;
      }
      catch (Exception localException)
      {
        TXCLog.e("TRTCCloudImpl", "onRecvSEIMsg failed.", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.147
 * JD-Core Version:    0.7.0.1
 */