package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.d;

class TRTCCustomTextureUtil$3
  implements Runnable
{
  TRTCCustomTextureUtil$3(TRTCCustomTextureUtil paramTRTCCustomTextureUtil, h paramh, k paramk) {}
  
  public void run()
  {
    Object localObject = this.val$rotateFilter;
    if (localObject != null) {
      ((h)localObject).d();
    }
    localObject = this.val$I4202RGBAFilter;
    if (localObject != null) {
      ((k)localObject).d();
    }
    if (TRTCCustomTextureUtil.access$100(this.this$0) != null)
    {
      TRTCCustomTextureUtil.access$300(this.this$0, "CustomCapture release");
      TRTCCustomTextureUtil.access$100(this.this$0).r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil.3
 * JD-Core Version:    0.7.0.1
 */