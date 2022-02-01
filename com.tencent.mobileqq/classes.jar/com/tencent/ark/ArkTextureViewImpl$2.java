package com.tencent.ark;

import android.graphics.SurfaceTexture;

class ArkTextureViewImpl$2
  implements Runnable
{
  ArkTextureViewImpl$2(ArkTextureViewImpl paramArkTextureViewImpl, int paramInt1, int paramInt2, ArkViewModel paramArkViewModel, ArkTextureViewImpl.ViewContext paramViewContext, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    ArkTextureViewImpl.ENV.logD(ArkTextureViewImpl.TAG, String.format("createContext.2.this.%h.size.(%d, %d)", new Object[] { this.this$0, Integer.valueOf(this.val$width), Integer.valueOf(this.val$height) }));
    this.val$viewModel.mTimeRecord.beginOfCreateContext = System.currentTimeMillis();
    if (this.val$viewContext.surfaceTexture == null)
    {
      ArkTextureViewImpl.ENV.logE(ArkTextureViewImpl.TAG, String.format("createContext.surface.null: %h", new Object[] { this.this$0 }));
      return;
    }
    if ((this.val$viewContext.contextHolder != null) && (this.val$viewContext.contextHolder.mSurfaceTexture == this.val$surface))
    {
      ArkTextureViewImpl.ENV.logI(ArkTextureViewImpl.TAG, String.format("createContext.sizeChanged: %h", new Object[] { this.this$0 }));
      this.val$viewContext.contextHolder.sizeChanged(this.val$width, this.val$height);
    }
    for (;;)
    {
      this.val$viewModel.mTimeRecord.endOfCreateContext = System.currentTimeMillis();
      this.val$viewModel.createDrawTarget(null);
      return;
      if (this.val$viewContext.contextHolder != null)
      {
        ArkTextureViewImpl.ENV.logD(ArkTextureViewImpl.TAG, String.format("createContext.surface.rebind: %h, model:%h, context:%h", new Object[] { this.this$0, this.val$viewContext.viewModel, this.val$viewContext.contextHolder }));
        this.val$viewContext.contextHolder.release();
        this.val$viewContext.contextHolder = null;
      }
      EGLContextHolder localEGLContextHolder = this.val$viewModel.getContext();
      if (localEGLContextHolder == null)
      {
        ArkTextureViewImpl.ENV.logE(ArkTextureViewImpl.TAG, String.format("createContext.offscreenContext.null: %h, model:%h", new Object[] { this.this$0, this.val$viewContext.viewModel }));
        return;
      }
      synchronized (ArkTextureViewImpl.access$100(this.this$0))
      {
        if (!ArkTextureViewImpl.access$200(this.this$0))
        {
          ArkTextureViewImpl.ENV.logE(ArkTextureViewImpl.TAG, String.format("createContext.Surface is unavailable", new Object[0]));
          return;
        }
      }
      this.val$viewContext.contextHolder = new EGLContextHolder();
      this.val$viewContext.contextHolder.create(localObject2.mContext, this.val$viewContext.surfaceTexture, this.val$width, this.val$height);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkTextureViewImpl.2
 * JD-Core Version:    0.7.0.1
 */