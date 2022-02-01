package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$13
  implements Runnable
{
  TRTCCloudImpl$13(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((TRTCCloudImpl)localObject).mRecvMode = 0;
    if ((this.val$autoRecvAudio) && (this.val$autoRecvVideo)) {
      ((TRTCCloudImpl)localObject).mRecvMode = 1;
    } else if (this.val$autoRecvAudio) {
      this.this$0.mRecvMode = 2;
    } else if (this.val$autoRecvVideo) {
      this.this$0.mRecvMode = 3;
    } else {
      this.this$0.mRecvMode = 4;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("setDefaultStreamRecvMode audio:%b, video:%b", new Object[] { Boolean.valueOf(this.val$autoRecvAudio), Boolean.valueOf(this.val$autoRecvVideo) }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    this.this$0.apiOnlineLog((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.13
 * JD-Core Version:    0.7.0.1
 */