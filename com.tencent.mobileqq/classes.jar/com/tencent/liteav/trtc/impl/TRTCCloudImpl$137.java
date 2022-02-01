package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$137
  implements Runnable
{
  TRTCCloudImpl$137(TRTCCloudImpl paramTRTCCloudImpl, long paramLong, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.mRoomInfo.setTinyId(String.valueOf(this.val$tinyID));
    this.this$0.mRoomInfo.setToken(this.this$0.mContext, this.val$token);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.137
 * JD-Core Version:    0.7.0.1
 */