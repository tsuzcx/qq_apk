package com.tencent.ark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArkTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener, ArkViewImplement.ArkViewInterface, View.OnTouchListener, View.OnLongClickListener
{
  protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
  protected static String TAG = null;
  private Bitmap mBitmap;
  protected Lock mBitmapLock;
  private Canvas mCanvas;
  protected EGLContextHolder mContextHolder;
  protected final boolean mIsGpuRendering = ENV.isHardwareAcceleration();
  private Path mPath;
  private Rect mRectBitmap;
  protected Rect mRectUpdate;
  protected SurfaceTexture mSurfaceTexture;
  protected Object mSurfaceTextureLocker;
  protected Lock mUpdateLock;
  public ArkViewImplement mViewImpl;
  
  public ArkTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (TAG == null)
    {
      if (this.mIsGpuRendering)
      {
        paramContext = "ArkApp.ArkTextureView.hw";
        TAG = paramContext;
      }
    }
    else
    {
      if (this.mIsGpuRendering) {
        break label166;
      }
      this.mRectUpdate = new Rect();
      this.mBitmapLock = new ReentrantLock();
      this.mUpdateLock = new ReentrantLock();
      this.mPath = new Path();
      this.mRectBitmap = new Rect();
    }
    for (;;)
    {
      setSurfaceTextureListener(this);
      setOpaque(false);
      this.mViewImpl = new ArkViewImplement(this, this);
      if ((isAvailable()) && (ENV.mIsDebug)) {
        ENV.logD(TAG, String.format("surface.available.this.%h", new Object[] { this }));
      }
      return;
      paramContext = "ArkApp.ArkTextureView.sw";
      break;
      label166:
      this.mSurfaceTextureLocker = new Object();
    }
  }
  
  public void destroyBitmapBuffer()
  {
    if (this.mIsGpuRendering) {
      return;
    }
    this.mBitmapLock.lock();
    try
    {
      this.mCanvas = null;
      if (this.mBitmap != null)
      {
        this.mBitmap.recycle();
        this.mBitmap = null;
      }
      if (this.mRectBitmap != null) {
        this.mRectBitmap.setEmpty();
      }
      return;
    }
    finally
    {
      this.mBitmapLock.unlock();
    }
  }
  
  public void doDetach(ArkViewModel paramArkViewModel)
  {
    this.mViewImpl.doDetach(paramArkViewModel);
  }
  
  public void doInputCommand(int paramInt)
  {
    this.mViewImpl.doInputCommand(paramInt);
  }
  
  public Bitmap getBitmapBuffer()
  {
    if ((this.mIsGpuRendering) || (this.mBitmap == null) || (this.mBitmap.isRecycled())) {
      return null;
    }
    return this.mBitmap;
  }
  
  EGLContextHolder getContextHolder()
  {
    return this.mContextHolder;
  }
  
  public Rect getInputRect()
  {
    return this.mViewImpl.getInputRect();
  }
  
  public void initArkView(ArkViewModel paramArkViewModel)
  {
    if (this.mRectUpdate != null) {
      this.mRectUpdate.setEmpty();
    }
    this.mViewImpl.initArkView(paramArkViewModel);
  }
  
  public boolean onCheckIsTextEditor()
  {
    return this.mViewImpl.onCheckIsTextEditor();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return this.mViewImpl.onCreateInputConnection(paramEditorInfo);
  }
  
  public boolean onInvalidate(Rect paramRect)
  {
    if (this.mIsGpuRendering) {
      return true;
    }
    Rect localRect = ArkViewModel.scaleRect(paramRect, this.mViewImpl.mScale);
    if ((this.mCanvas != null) && (this.mViewImpl.mBorderType != 0) && (this.mViewImpl.mRound))
    {
      this.mCanvas.save();
      this.mCanvas.clipRect(localRect);
      this.mCanvas.drawPath(this.mPath, ArkViewImplement.sPaintPath);
      this.mCanvas.restore();
    }
    try
    {
      if ((this.mBitmap == null) || (this.mBitmap.isRecycled()))
      {
        ENV.logE(TAG, String.format("onInvalidate.mBitmap.null.this.%h", new Object[] { this }));
        return false;
      }
      paramRect = lockCanvas(ArkViewModel.scaleRect(paramRect, this.mViewImpl.mScale));
      if (paramRect == null)
      {
        ENV.logE(TAG, String.format("onInvalidate.lockCanvas.null.this.%h", new Object[] { this }));
        return false;
      }
      paramRect.drawBitmap(this.mBitmap, this.mRectBitmap, this.mViewImpl.mRectView, ArkViewImplement.sPaintOpaque);
      unlockCanvasAndPost(paramRect);
      return true;
    }
    catch (OutOfMemoryError paramRect)
    {
      ENV.logE(TAG, paramRect.getMessage());
    }
    return false;
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean) {}
  
  public void onLoadSuccess() {}
  
  public void onLoading() {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == this) {
      return this.mViewImpl.doOnLongClick(paramView);
    }
    return false;
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    this.mViewImpl.onStartTemporaryDetach();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (ENV.mIsDebug) {
      ENV.logD(TAG, String.format("onSurfaceTextureAvailable.this.%h.size.(%d, %d)", new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (this.mIsGpuRendering) {
      onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
    do
    {
      return;
      paramSurfaceTexture = this.mViewImpl.getViewModel();
    } while (paramSurfaceTexture == null);
    paramSurfaceTexture.postRedraw();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    if (!this.mIsGpuRendering) {
      return true;
    }
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkTextureView.ENV.logD(ArkTextureView.TAG, String.format("onSurfaceTextureDestroyed.this.%h", new Object[] { ArkTextureView.this }));
        ArkViewModel localArkViewModel = ArkTextureView.this.mViewImpl.getViewModel();
        if (localArkViewModel != null) {
          localArkViewModel.destroyDrawTarget();
        }
        if (ArkTextureView.this.mContextHolder != null)
        {
          ArkTextureView.this.mContextHolder.release();
          ArkTextureView.this.mContextHolder = null;
        }
      }
    });
    synchronized (this.mSurfaceTextureLocker)
    {
      this.mSurfaceTexture = null;
      return true;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    if (!this.mIsGpuRendering) {
      return;
    }
    if (ENV.mIsDebug) {
      ENV.logD(TAG, String.format("onSurfaceTextureSizeChanged.1.this.%h.size.(%d, %d)", new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    synchronized (this.mSurfaceTextureLocker)
    {
      this.mSurfaceTexture = paramSurfaceTexture;
      ArkDispatchTask.getInstance().post(new Runnable()
      {
        public void run()
        {
          ArkTextureView.ENV.logD(ArkTextureView.TAG, String.format("onSurfaceTextureSizeChanged.2.this.%h.size.(%d, %d)", new Object[] { ArkTextureView.this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
          ??? = ArkTextureView.this.mViewImpl.getViewModel();
          if (??? != null) {
            ((ArkViewModel)???).mTimeRecord.beginOfCreateContext = System.currentTimeMillis();
          }
          for (;;)
          {
            synchronized (ArkTextureView.this.mSurfaceTextureLocker)
            {
              if (ArkTextureView.this.mSurfaceTexture == null)
              {
                ArkTextureView.ENV.logD(ArkTextureView.TAG, String.format("onSurfaceTextureSizeChanged.surface.null: %h", new Object[] { ArkTextureView.this }));
                return;
              }
              if ((ArkTextureView.this.mContextHolder != null) && (ArkTextureView.this.mSurfaceTexture == ArkTextureView.this.mContextHolder.mSurfaceTexture))
              {
                ArkTextureView.this.mContextHolder.sizeChanged(paramInt1, paramInt2);
                ??? = ArkTextureView.this.mViewImpl.getViewModel();
                if (??? == null) {
                  break;
                }
                ((ArkViewModel)???).createDrawTarget(null);
                return;
              }
              if (ArkTextureView.this.mContextHolder != null)
              {
                ArkTextureView.ENV.logD(ArkTextureView.TAG, String.format("onSurfaceTextureSizeChanged.surface.rebind: %h", new Object[] { ArkTextureView.this }));
                ArkTextureView.this.mContextHolder.release();
                ArkTextureView.this.mContextHolder = null;
              }
              EGLContextHolder localEGLContextHolder = ArkViewModel.getOffscreenContext();
              if (localEGLContextHolder == null)
              {
                ArkTextureView.ENV.logD(ArkTextureView.TAG, String.format("onSurfaceTextureSizeChanged.offscreenContext.null: %h", new Object[] { ArkTextureView.this }));
                return;
              }
            }
            ArkTextureView.this.mContextHolder = new EGLContextHolder();
            ArkTextureView.this.mContextHolder.create(localObject2.mContext, ArkTextureView.this.mSurfaceTexture, paramInt1, paramInt2);
          }
        }
      });
      return;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (ENV.mShowVsyncLog) {
      ENV.logD(TAG, String.format("onSurfaceTextureUpdated.this.%h", new Object[] { this }));
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this) {
      return this.mViewImpl.doOnTouch(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public Bitmap recreateBitmapBuffer(Rect paramRect)
  {
    if (this.mIsGpuRendering) {
      return null;
    }
    if (paramRect.isEmpty())
    {
      ENV.logE(TAG, String.format("recreateBitmapBuffer.return.null.view.%h", new Object[] { this }));
      return null;
    }
    paramRect = ArkViewModel.scaleRect(paramRect, this.mViewImpl.mScale);
    int i = paramRect.width();
    int j = paramRect.height();
    this.mBitmapLock.lock();
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (this.mBitmap.getWidth() >= i) && (this.mBitmap.getHeight() >= j))
    {
      this.mRectBitmap = paramRect;
      this.mViewImpl.refreshDrawPath(paramRect, this.mPath);
      this.mBitmapLock.unlock();
      return this.mBitmap;
    }
    ENV.logI(TAG, String.format("recreateBitmapBuffer.1.view.%h", new Object[] { this }));
    this.mCanvas = null;
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
    if (this.mRectBitmap != null) {
      this.mRectBitmap.setEmpty();
    }
    try
    {
      this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      this.mRectBitmap = paramRect;
      if (this.mBitmap != null) {
        this.mCanvas = new Canvas(this.mBitmap);
      }
      this.mBitmapLock.unlock();
      this.mViewImpl.refreshDrawPath(paramRect, this.mPath);
      return this.mBitmap;
    }
    catch (OutOfMemoryError paramRect)
    {
      ENV.logE(TAG, paramRect.getMessage());
      if (this.mBitmap != null)
      {
        this.mBitmap.recycle();
        this.mBitmap = null;
      }
      return null;
    }
    finally
    {
      this.mBitmapLock.unlock();
    }
  }
  
  public void setAlignLeft(boolean paramBoolean)
  {
    this.mViewImpl.mAlignLeft = paramBoolean;
  }
  
  public void setBorderType(int paramInt)
  {
    this.mViewImpl.mBorderType = paramInt;
  }
  
  public void setClipRadius(float paramFloat)
  {
    this.mViewImpl.mClipRadius = paramFloat;
  }
  
  public void setClipRadiusTop(float paramFloat)
  {
    this.mViewImpl.mClipRadiusTop = paramFloat;
  }
  
  public void setInputCallback(ArkViewImplement.InputCallback paramInputCallback)
  {
    this.mViewImpl.mInputCallback = paramInputCallback;
  }
  
  public void setInputSetCaretHolderSize(int paramInt1, int paramInt2)
  {
    this.mViewImpl.setInputSetCaretHolderSize(paramInt1, paramInt2);
  }
  
  public void setInputSetSelectHolderSize(int paramInt1, int paramInt2)
  {
    this.mViewImpl.setInputSetSelectHolderSize(paramInt1, paramInt2);
  }
  
  public void setLoadCallback(ArkViewImplement.LoadCallback paramLoadCallback)
  {
    this.mViewImpl.mLoadCallback = paramLoadCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.ArkTextureView
 * JD-Core Version:    0.7.0.1
 */