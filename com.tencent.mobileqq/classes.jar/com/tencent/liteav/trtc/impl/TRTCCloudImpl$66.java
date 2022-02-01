package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$66
  implements Runnable
{
  TRTCCloudImpl$66(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    this.this$0.getBeautyManager().setBeautyStyle(this.val$style);
    this.this$0.getBeautyManager().setBeautyLevel(this.val$beauty);
    this.this$0.getBeautyManager().setWhitenessLevel(this.val$white);
    this.this$0.getBeautyManager().setRuddyLevel(this.val$ruddiness);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.66
 * JD-Core Version:    0.7.0.1
 */