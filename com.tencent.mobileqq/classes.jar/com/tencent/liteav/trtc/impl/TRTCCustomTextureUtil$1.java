package com.tencent.liteav.trtc.impl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.c.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.d;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;

class TRTCCustomTextureUtil$1
  implements Runnable
{
  TRTCCustomTextureUtil$1(TRTCCustomTextureUtil paramTRTCCustomTextureUtil, g paramg, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame) {}
  
  public void run()
  {
    this.val$glThreadHandler.d();
    if (this.val$glThreadHandler.d)
    {
      if (this.val$frame.texture != null)
      {
        this.val$frame.texture.textureId = TRTCCustomTextureUtil.access$000(this.this$0, this.val$frame.texture.textureId, this.val$frame);
        TRTCCustomTextureUtil.access$100(this.this$0).a(this.val$frame.texture.textureId, this.val$frame.width, this.val$frame.height, this.val$glThreadHandler.e.e(), this.val$frame.timestamp, this.val$frame.rotation);
      }
    }
    else
    {
      if (this.val$frame.texture != null)
      {
        this.val$frame.texture.textureId = TRTCCustomTextureUtil.access$000(this.this$0, this.val$frame.texture.textureId, this.val$frame);
        TRTCCustomTextureUtil.access$100(this.this$0).a(this.val$frame.texture.textureId, this.val$frame.width, this.val$frame.height, this.val$glThreadHandler.g.d(), this.val$frame.timestamp, this.val$frame.rotation);
        return;
      }
      int i;
      if (this.val$frame.pixelFormat == 1)
      {
        i = 1;
      }
      else
      {
        i = this.val$frame.pixelFormat;
        i = 3;
      }
      if (TRTCCustomTextureUtil.access$200(this.this$0) == null)
      {
        localk = new k(i);
        localk.a(true);
        if (!localk.a()) {
          TXCLog.e("TRTCCustomTextureUtil", "mI4202RGBAFilter init failed!!, break init");
        }
        localk.a(this.val$frame.width, this.val$frame.height);
        TRTCCustomTextureUtil.access$202(this.this$0, localk);
      }
      k localk = TRTCCustomTextureUtil.access$200(this.this$0);
      if (localk != null)
      {
        GLES20.glViewport(0, 0, this.val$frame.width, this.val$frame.height);
        localk.a(this.val$frame.data);
        i = localk.q();
        i = TRTCCustomTextureUtil.access$000(this.this$0, i, this.val$frame);
        TRTCCustomTextureUtil.access$100(this.this$0).a(i, this.val$frame.width, this.val$frame.height, this.val$glThreadHandler.g.d(), this.val$frame.timestamp, this.val$frame.rotation);
        return;
      }
      TRTCCustomTextureUtil.access$100(this.this$0).a(this.val$frame.data, i, this.val$frame.width, this.val$frame.height, this.val$glThreadHandler.g.d(), this.val$frame.timestamp, this.val$frame.rotation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil.1
 * JD-Core Version:    0.7.0.1
 */