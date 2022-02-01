package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$169$1
  implements Runnable
{
  TRTCCloudImpl$169$1(TRTCCloudImpl.169 param169, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$1.this$0.mTRTCListener;
    if (localObject != null)
    {
      ((TRTCCloudListener)localObject).onUserVideoAvailable(this.val$userId, true);
      TRTCCloudImpl.access$9700(this.this$1.this$0, this.this$1.this$0.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { this.val$userId, Boolean.valueOf(true) }));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.format("onUserVideoAvailable by recv first video. userID:%s, bAvailable:%b", new Object[] { this.val$userId, Boolean.valueOf(true) }));
      ((StringBuilder)localObject).append(" self:");
      ((StringBuilder)localObject).append(this.this$1.this$0.hashCode());
      Monitor.a(2, ((StringBuilder)localObject).toString(), "", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.169.1
 * JD-Core Version:    0.7.0.1
 */