package com.tencent.ark;

import android.graphics.SurfaceTexture;

class ArkPlayerSurfaceHolder$1
  implements Runnable
{
  ArkPlayerSurfaceHolder$1(ArkPlayerSurfaceHolder paramArkPlayerSurfaceHolder) {}
  
  public void run()
  {
    if ((this.this$0.mSurfaceTexture == null) || (this.this$0.mOffscreenContext == null) || (this.this$0.mFrameCallback == 0L)) {}
    while (!this.this$0.mOffscreenContext.makeCurrent()) {
      return;
    }
    this.this$0.mSurfaceTexture.updateTexImage();
    ark.PlayerStub.FrameInfo localFrameInfo = new ark.PlayerStub.FrameInfo();
    localFrameInfo.width = this.this$0.mFrameWidth;
    localFrameInfo.height = this.this$0.mFrameHeight;
    localFrameInfo.texture = this.this$0.mTextureID;
    ark.PlayerUpdateFrame(this.this$0.mFrameCallback, this.this$0.mFrameUserdata, localFrameInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkPlayerSurfaceHolder.1
 * JD-Core Version:    0.7.0.1
 */