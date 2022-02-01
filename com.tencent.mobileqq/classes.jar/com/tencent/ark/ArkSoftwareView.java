package com.tencent.ark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArkSoftwareView
  extends View
  implements ArkTextureView.ArkTextureViewInterface
{
  protected static final ArkEnvironmentManager ENV = ;
  protected static final String TAG = "ArkApp.ArkSoftwareView";
  private Bitmap mBitmap;
  protected Lock mBitmapLock = new ReentrantLock();
  private Bitmap mBitmapView;
  private Canvas mCanvas;
  private Canvas mCanvasView;
  private final Runnable mOnInvalidUIThread = new ArkSoftwareView.1(this);
  private Path mPath = new Path();
  private Rect mRectBitmap = new Rect();
  protected Rect mRectUpdate = new Rect();
  protected Lock mUpdateLock = new ReentrantLock();
  public ArkViewImplement mViewImpl;
  
  public ArkSoftwareView(Context paramContext, ArkViewImplement paramArkViewImplement)
  {
    super(paramContext);
    this.mViewImpl = paramArkViewImplement;
  }
  
  public void checkSurfaceAvailable() {}
  
  public void createContext() {}
  
  public void destroyBitmapBuffer()
  {
    this.mBitmapLock.lock();
    try
    {
      this.mCanvas = null;
      this.mCanvasView = null;
      if (this.mBitmap != null)
      {
        this.mBitmap.recycle();
        this.mBitmap = null;
      }
      if (this.mBitmapView != null)
      {
        this.mBitmapView.recycle();
        this.mBitmapView = null;
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
  
  /* Error */
  public void draw(Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   4: invokevirtual 110	com/tencent/ark/ArkViewImplement:getViewModel	()Lcom/tencent/ark/ArkViewModel;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   15: invokeinterface 83 1 0
    //   20: aload_0
    //   21: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   24: getfield 113	com/tencent/ark/ArkViewImplement:mRectView	Landroid/graphics/Rect;
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   32: ifnull +30 -> 62
    //   35: aload_0
    //   36: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   39: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   42: ifne +20 -> 62
    //   45: aload_0
    //   46: getfield 66	com/tencent/ark/ArkSoftwareView:mRectBitmap	Landroid/graphics/Rect;
    //   49: invokevirtual 120	android/graphics/Rect:isEmpty	()Z
    //   52: ifne +10 -> 62
    //   55: aload_2
    //   56: invokevirtual 120	android/graphics/Rect:isEmpty	()Z
    //   59: ifeq +34 -> 93
    //   62: getstatic 40	com/tencent/ark/ArkSoftwareView:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   65: ldc 12
    //   67: ldc 122
    //   69: iconst_1
    //   70: anewarray 124	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_0
    //   76: aastore
    //   77: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokevirtual 134	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   87: invokeinterface 102 1 0
    //   92: return
    //   93: aload_0
    //   94: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   97: getfield 138	com/tencent/ark/ArkViewImplement:mOpaque	Z
    //   100: ifeq +39 -> 139
    //   103: aload_0
    //   104: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   107: getfield 142	com/tencent/ark/ArkViewImplement:mBorderType	I
    //   110: ifne +29 -> 139
    //   113: aload_1
    //   114: aload_0
    //   115: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   118: aload_0
    //   119: getfield 66	com/tencent/ark/ArkSoftwareView:mRectBitmap	Landroid/graphics/Rect;
    //   122: aload_2
    //   123: getstatic 146	com/tencent/ark/ArkViewImplement:sPaintOpaque	Landroid/graphics/Paint;
    //   126: invokevirtual 152	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   129: aload_0
    //   130: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 102 1 0
    //   138: return
    //   139: aload_1
    //   140: aload_0
    //   141: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   144: aload_0
    //   145: getfield 66	com/tencent/ark/ArkSoftwareView:mRectBitmap	Landroid/graphics/Rect;
    //   148: aload_2
    //   149: getstatic 155	com/tencent/ark/ArkViewImplement:sPaint	Landroid/graphics/Paint;
    //   152: invokevirtual 152	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   155: goto -26 -> 129
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   163: invokeinterface 102 1 0
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	ArkSoftwareView
    //   0	170	1	paramCanvas	Canvas
    //   27	122	2	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   20	62	158	finally
    //   62	83	158	finally
    //   93	129	158	finally
    //   139	155	158	finally
  }
  
  public Bitmap getBitmapBuffer()
  {
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {
      return null;
    }
    return this.mBitmap;
  }
  
  public void initArkView(ArkViewModel paramArkViewModel)
  {
    this.mRectUpdate.setEmpty();
  }
  
  public boolean onInvalidate(Rect paramRect)
  {
    Rect localRect = ArkViewModel.scaleRect(paramRect, this.mViewImpl.mScale);
    if ((this.mCanvas != null) && (this.mViewImpl.mBorderType != 0) && (this.mViewImpl.mRound))
    {
      this.mCanvas.save();
      this.mCanvas.clipRect(localRect);
      this.mCanvas.drawPath(this.mPath, ArkViewImplement.sPaintPath);
      this.mCanvas.restore();
    }
    this.mUpdateLock.lock();
    this.mRectUpdate.union(paramRect);
    this.mUpdateLock.unlock();
    this.mBitmapLock.lock();
    try
    {
      if ((this.mBitmapView == null) || (this.mBitmapView.isRecycled()) || (this.mCanvasView == null))
      {
        ENV.logE("ArkApp.ArkSoftwareView", String.format("onInvalidate.return.2.view: %h", new Object[] { this }));
        return false;
      }
      this.mBitmapView = this.mBitmap.copy(Bitmap.Config.ARGB_8888, true);
      this.mBitmapLock.unlock();
      ArkDispatchTask.getInstance().postToMainThread(this.mOnInvalidUIThread);
      return true;
    }
    catch (OutOfMemoryError paramRect)
    {
      ENV.logE("ArkApp.ArkSoftwareView", paramRect.getMessage());
      return false;
    }
    finally
    {
      this.mBitmapLock.unlock();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Rect localRect = this.mViewImpl.mRectView;
    if (!localRect.isEmpty())
    {
      setMeasuredDimension(localRect.width(), localRect.height());
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public Bitmap recreateBitmapBuffer(Rect paramRect)
  {
    if (paramRect.isEmpty())
    {
      ENV.logE("ArkApp.ArkSoftwareView", String.format("recreateBitmapBuffer.rect.empty.uiview: %h", new Object[] { this }));
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
    ENV.logI("ArkApp.ArkSoftwareView", String.format("recreateBitmapBuffer.1 uiview: %h", new Object[] { this }));
    this.mCanvas = null;
    this.mCanvasView = null;
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
    if (this.mBitmapView != null)
    {
      this.mBitmapView.recycle();
      this.mBitmapView = null;
    }
    if (this.mRectBitmap != null) {
      this.mRectBitmap.setEmpty();
    }
    try
    {
      this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      this.mBitmapView = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      this.mRectBitmap = paramRect;
      if (this.mBitmap != null) {
        this.mCanvas = new Canvas(this.mBitmap);
      }
      if (this.mBitmapView != null) {
        this.mCanvasView = new Canvas(this.mBitmapView);
      }
      this.mBitmapLock.unlock();
      this.mViewImpl.refreshDrawPath(paramRect, this.mPath);
      return this.mBitmap;
    }
    catch (OutOfMemoryError paramRect)
    {
      ENV.logE("ArkApp.ArkSoftwareView", paramRect.getMessage());
      if (this.mBitmap != null)
      {
        this.mBitmap.recycle();
        this.mBitmap = null;
      }
      if (this.mBitmapView != null)
      {
        this.mBitmapView.recycle();
        this.mBitmapView = null;
      }
      ENV.logE("ArkApp.ArkSoftwareView", String.format("recreateBitmapBuffer.return.null.oom.uiview: %h", new Object[] { this }));
      return null;
    }
    finally
    {
      this.mBitmapLock.unlock();
    }
  }
  
  public void releaseContext() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkSoftwareView
 * JD-Core Version:    0.7.0.1
 */