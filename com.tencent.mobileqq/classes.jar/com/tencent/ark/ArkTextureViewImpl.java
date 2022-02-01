package com.tencent.ark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;

public class ArkTextureViewImpl
  extends TextureView
  implements TextureView.SurfaceTextureListener, ArkTextureView.ArkTextureViewInterface
{
  protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
  protected static String TAG = "ArkApp.ArkTextureViewImpl";
  private Object mLock = new Object();
  private SurfaceTexture mSurface;
  private volatile boolean mSurfaceAvailable = false;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private ArkTextureViewImpl.ViewContext mViewContext;
  public ArkViewImplement mViewImpl;
  
  public ArkTextureViewImpl(Context paramContext, ArkViewImplement paramArkViewImplement)
  {
    super(paramContext);
    this.mViewImpl = paramArkViewImplement;
    setSurfaceTextureListener(this);
    setOpaque(false);
    if ((isAvailable()) && (ENV.mIsDebug)) {
      ENV.logD(TAG, String.format("surface.available.this.%h", new Object[] { this }));
    }
  }
  
  private void createContext(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if ((paramSurfaceTexture == null) || (paramInt1 == 0) || (paramInt2 == 0))
    {
      ENV.logE(TAG, String.format("createContext.surface.not.ready.this.%h", new Object[] { this }));
      return;
    }
    ENV.logD(TAG, String.format("createContext.this.%h.viewContext.%h", new Object[] { this, this.mViewContext }));
    ArkViewModel localArkViewModel = this.mViewImpl.getViewModel();
    for (;;)
    {
      int i;
      try
      {
        if (this.mViewContext == null)
        {
          i = 1;
          if (localArkViewModel != null) {
            break label191;
          }
          ENV.logI(TAG, String.format("createContext.current.view.model.is.null.this.%h.surface.%h", new Object[] { this, paramSurfaceTexture }));
          return;
        }
      }
      finally {}
      if (this.mViewContext.viewModel != localArkViewModel)
      {
        this.mViewContext = null;
        ENV.logE(TAG, String.format("createContext.model.changed.this.%h.viewContext.%h.model.%h.new.model.%h.", new Object[] { this, this.mViewContext, this.mViewContext.viewModel, localArkViewModel }));
        i = 1;
        continue;
        label191:
        if (i != 0)
        {
          this.mViewContext = new ArkTextureViewImpl.ViewContext(null);
          this.mViewContext.viewModel = localArkViewModel;
        }
        this.mViewContext.surfaceTexture = paramSurfaceTexture;
        ArkTextureViewImpl.ViewContext localViewContext = this.mViewContext;
        ENV.logI(TAG, String.format("createContext.1.this.%h.size.(%d, %d).model.%h.surface.%h", new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localArkViewModel, paramSurfaceTexture }));
        ArkDispatchQueue.asyncRun(localArkViewModel.getQueueKey(), new ArkTextureViewImpl.2(this, paramInt1, paramInt2, localArkViewModel, localViewContext, paramSurfaceTexture));
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private static void releaseContext(ArkTextureViewImpl.ViewContext paramViewContext)
  {
    if ((paramViewContext != null) && (paramViewContext.viewModel != null))
    {
      ENV.logD(TAG, String.format("releaseContext.begin.model.%h.context.%h.queue.%s", new Object[] { paramViewContext.viewModel, paramViewContext.contextHolder, paramViewContext.viewModel.getQueueKey() }));
      ArkDispatchQueue.asyncRun(paramViewContext.viewModel.getQueueKey(), new ArkTextureViewImpl.1(paramViewContext));
    }
  }
  
  public void checkSurfaceAvailable()
  {
    if (this.mSurfaceAvailable) {
      return;
    }
    if (isAvailable())
    {
      ENV.logE(TAG, String.format("checkSurfaceAvailable.become.available.this.%h", new Object[] { this }));
      onSurfaceTextureAvailable(getSurfaceTexture(), getWidth(), getHeight());
      return;
    }
    ENV.logE(TAG, String.format("checkSurfaceAvailable.not.available.this.%h", new Object[] { this }));
  }
  
  public void createContext()
  {
    createContext(this.mSurface, this.mSurfaceWidth, this.mSurfaceHeight);
  }
  
  public void destroyBitmapBuffer() {}
  
  public Bitmap getBitmapBuffer()
  {
    return null;
  }
  
  EGLContextHolder getContextHolder()
  {
    try
    {
      if ((this.mViewContext != null) && (this.mViewContext.contextHolder != null))
      {
        EGLContextHolder localEGLContextHolder = this.mViewContext.contextHolder;
        return localEGLContextHolder;
      }
      ENV.logE(TAG, String.format("getContextHolder.context.is.null.this.%h", new Object[] { this }));
      return null;
    }
    finally {}
  }
  
  public void initArkView(ArkViewModel paramArkViewModel) {}
  
  public boolean onInvalidate(Rect paramRect)
  {
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Rect localRect = this.mViewImpl.mRectView;
    if (!localRect.isEmpty())
    {
      if ((localRect.width() < 400) || (localRect.height() < 400)) {
        ENV.logE(TAG, String.format("ark view onMeasure, view rect too small: %d, %d", new Object[] { Integer.valueOf(localRect.width()), Integer.valueOf(localRect.height()) }));
      }
      setMeasuredDimension(localRect.width(), localRect.height());
      return;
    }
    ENV.logE(TAG, String.format("ark view onMeasure, view rect is empty, this=%h", new Object[] { this }));
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    ENV.logI(TAG, String.format("onSurfaceTextureAvailable.this.%h.surface.%h.size.(%d, %d)", new Object[] { this, paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if ((this.mSurface == paramSurfaceTexture) && (this.mSurfaceWidth == paramInt1) && (this.mSurfaceHeight == paramInt2))
    {
      ENV.logI(TAG, String.format("onSurfaceTextureAvailable.already.called.this.%h.surface.%h.size.(%d, %d)", new Object[] { this, paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return;
    }
    onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    ENV.logI(TAG, String.format("onSurfaceTextureDestroyed.this.%h.viewContext.%h.surface.%h", new Object[] { this, this.mViewContext, ??? }));
    releaseContext();
    synchronized (this.mLock)
    {
      this.mSurfaceAvailable = false;
      return true;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    ENV.logI(TAG, String.format("onSurfaceTextureSizeChanged.this.%h.surface.%h.width.%d.height.%d.viewContext.%h", new Object[] { this, paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.mViewContext }));
    synchronized (this.mLock)
    {
      this.mSurfaceAvailable = true;
      this.mSurface = paramSurfaceTexture;
      this.mSurfaceWidth = paramInt1;
      this.mSurfaceHeight = paramInt2;
      createContext(paramSurfaceTexture, paramInt1, paramInt2);
      return;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (ENV.mShowVsyncLog) {
      ENV.logD(TAG, String.format("onSurfaceTextureUpdated.this.%h", new Object[] { this }));
    }
  }
  
  public Bitmap recreateBitmapBuffer(Rect paramRect)
  {
    return null;
  }
  
  public void releaseContext()
  {
    Object localObject1 = null;
    ArkEnvironmentManager localArkEnvironmentManager = ENV;
    String str = TAG;
    ArkTextureViewImpl.ViewContext localViewContext = this.mViewContext;
    if (this.mViewContext != null) {
      localObject1 = this.mViewContext.viewModel;
    }
    localArkEnvironmentManager.logD(str, String.format("releaseContext.this.%h.viewContext.%h.model.%h", new Object[] { this, localViewContext, localObject1 }));
    try
    {
      localObject1 = this.mViewContext;
      this.mViewContext = null;
      releaseContext((ArkTextureViewImpl.ViewContext)localObject1);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkTextureViewImpl
 * JD-Core Version:    0.7.0.1
 */