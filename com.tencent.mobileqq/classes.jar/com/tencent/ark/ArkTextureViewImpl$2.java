package com.tencent.ark;

import android.graphics.SurfaceTexture;

class ArkTextureViewImpl$2
  implements Runnable
{
  ArkTextureViewImpl$2(ArkTextureViewImpl paramArkTextureViewImpl, int paramInt1, int paramInt2, ArkViewModel paramArkViewModel, ArkTextureViewImpl.ViewContext paramViewContext, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    Logger.logD(ArkTextureViewImpl.TAG, String.format("createContext.2.this.%h.size.(%d, %d)", new Object[] { this.this$0, Integer.valueOf(this.val$width), Integer.valueOf(this.val$height) }));
    this.val$viewModel.mTimeRecord.beginOfCreateContext = System.currentTimeMillis();
    if (this.val$viewContext.surfaceTexture == null)
    {
      Logger.logE(ArkTextureViewImpl.TAG, String.format("createContext.surface.null: %h", new Object[] { this.this$0 }));
      return;
    }
    EGLContextHolder localEGLContextHolder;
    if ((this.val$viewContext.contextHolder != null) && (this.val$viewContext.contextHolder.mSurfaceTexture == this.val$surface))
    {
      Logger.logI(ArkTextureViewImpl.TAG, String.format("createContext.sizeChanged: %h", new Object[] { this.this$0 }));
      this.val$viewContext.contextHolder.sizeChanged(this.val$width, this.val$height);
    }
    else
    {
      if (this.val$viewContext.contextHolder != null)
      {
        Logger.logD(ArkTextureViewImpl.TAG, String.format("createContext.surface.rebind: %h, model:%h, context:%h", new Object[] { this.this$0, this.val$viewContext.viewModel, this.val$viewContext.contextHolder }));
        this.val$viewContext.contextHolder.release();
        this.val$viewContext.contextHolder = null;
      }
      localEGLContextHolder = this.val$viewModel.getContext();
      if (localEGLContextHolder == null)
      {
        Logger.logE(ArkTextureViewImpl.TAG, String.format("createContext.offscreenContext.null: %h, model:%h", new Object[] { this.this$0, this.val$viewContext.viewModel }));
        return;
      }
    }
    synchronized (ArkTextureViewImpl.access$100(this.this$0))
    {
      if (!ArkTextureViewImpl.access$200(this.this$0))
      {
        Logger.logE(ArkTextureViewImpl.TAG, String.format("createContext.Surface is unavailable", new Object[0]));
        return;
      }
      this.val$viewContext.contextHolder = new EGLContextHolder();
      this.val$viewContext.contextHolder.create(localEGLContextHolder.mContext, this.val$viewContext.surfaceTexture, this.val$width, this.val$height);
      this.val$viewModel.mTimeRecord.endOfCreateContext = System.currentTimeMillis();
      this.val$viewModel.createDrawTarget(null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkTextureViewImpl.2
 * JD-Core Version:    0.7.0.1
 */