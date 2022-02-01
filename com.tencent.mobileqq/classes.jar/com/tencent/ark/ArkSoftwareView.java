package com.tencent.ark;

import android.content.Context;
import android.graphics.Bitmap;
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
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mViewImpl.getViewModel() == null) {
      return;
    }
    this.mBitmapLock.lock();
    try
    {
      Rect localRect = this.mViewImpl.mRectView;
      if ((this.mBitmapView != null) && (!this.mBitmapView.isRecycled()) && (!this.mRectBitmap.isEmpty()) && (!localRect.isEmpty()))
      {
        if ((this.mViewImpl.mOpaque) && (this.mViewImpl.mBorderType == 0)) {
          paramCanvas.drawBitmap(this.mBitmapView, this.mRectBitmap, localRect, ArkViewImplement.sPaintOpaque);
        } else {
          paramCanvas.drawBitmap(this.mBitmapView, this.mRectBitmap, localRect, ArkViewImplement.sPaint);
        }
        return;
      }
      Logger.logI("ArkApp.ArkSoftwareView", String.format("draw.return.bitmap is null uiview: %h", new Object[] { this }));
      return;
    }
    finally
    {
      this.mBitmapLock.unlock();
    }
  }
  
  public Bitmap getBitmapBuffer()
  {
    Bitmap localBitmap = this.mBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      return this.mBitmap;
    }
    return null;
  }
  
  public void initArkView(ArkViewModel paramArkViewModel)
  {
    this.mRectUpdate.setEmpty();
  }
  
  /* Error */
  public boolean onInvalidate(Rect paramRect)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   5: getfield 169	com/tencent/ark/ArkViewImplement:mScale	F
    //   8: invokestatic 175	com/tencent/ark/ArkViewModel:scaleRect	(Landroid/graphics/Rect;F)Landroid/graphics/Rect;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 85	com/tencent/ark/ArkSoftwareView:mCanvas	Landroid/graphics/Canvas;
    //   16: ifnull +61 -> 77
    //   19: aload_0
    //   20: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   23: getfield 128	com/tencent/ark/ArkViewImplement:mBorderType	I
    //   26: ifeq +51 -> 77
    //   29: aload_0
    //   30: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   33: getfield 178	com/tencent/ark/ArkViewImplement:mRound	Z
    //   36: ifeq +41 -> 77
    //   39: aload_0
    //   40: getfield 85	com/tencent/ark/ArkSoftwareView:mCanvas	Landroid/graphics/Canvas;
    //   43: invokevirtual 182	android/graphics/Canvas:save	()I
    //   46: pop
    //   47: aload_0
    //   48: getfield 85	com/tencent/ark/ArkSoftwareView:mCanvas	Landroid/graphics/Canvas;
    //   51: aload_2
    //   52: invokevirtual 185	android/graphics/Canvas:clipRect	(Landroid/graphics/Rect;)Z
    //   55: pop
    //   56: aload_0
    //   57: getfield 85	com/tencent/ark/ArkSoftwareView:mCanvas	Landroid/graphics/Canvas;
    //   60: aload_0
    //   61: getfield 64	com/tencent/ark/ArkSoftwareView:mPath	Landroid/graphics/Path;
    //   64: getstatic 188	com/tencent/ark/ArkViewImplement:sPaintPath	Landroid/graphics/Paint;
    //   67: invokevirtual 192	android/graphics/Canvas:drawPath	(Landroid/graphics/Path;Landroid/graphics/Paint;)V
    //   70: aload_0
    //   71: getfield 85	com/tencent/ark/ArkSoftwareView:mCanvas	Landroid/graphics/Canvas;
    //   74: invokevirtual 195	android/graphics/Canvas:restore	()V
    //   77: aload_0
    //   78: getfield 59	com/tencent/ark/ArkSoftwareView:mUpdateLock	Ljava/util/concurrent/locks/Lock;
    //   81: invokeinterface 83 1 0
    //   86: aload_0
    //   87: getfield 52	com/tencent/ark/ArkSoftwareView:mRectUpdate	Landroid/graphics/Rect;
    //   90: aload_1
    //   91: invokevirtual 199	android/graphics/Rect:union	(Landroid/graphics/Rect;)V
    //   94: aload_0
    //   95: getfield 59	com/tencent/ark/ArkSoftwareView:mUpdateLock	Ljava/util/concurrent/locks/Lock;
    //   98: invokeinterface 102 1 0
    //   103: aload_0
    //   104: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   107: invokeinterface 83 1 0
    //   112: aload_0
    //   113: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   116: ifnull +59 -> 175
    //   119: aload_0
    //   120: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   123: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   126: ifne +49 -> 175
    //   129: aload_0
    //   130: getfield 87	com/tencent/ark/ArkSoftwareView:mCanvasView	Landroid/graphics/Canvas;
    //   133: ifnonnull +6 -> 139
    //   136: goto +39 -> 175
    //   139: aload_0
    //   140: aload_0
    //   141: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   144: getstatic 205	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   147: iconst_1
    //   148: invokevirtual 209	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   151: putfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   154: aload_0
    //   155: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   158: invokeinterface 102 1 0
    //   163: invokestatic 214	com/tencent/ark/ArkDispatchTask:getInstance	()Lcom/tencent/ark/ArkDispatchTask;
    //   166: aload_0
    //   167: getfield 73	com/tencent/ark/ArkSoftwareView:mOnInvalidUIThread	Ljava/lang/Runnable;
    //   170: invokevirtual 218	com/tencent/ark/ArkDispatchTask:postToMainThread	(Ljava/lang/Runnable;)V
    //   173: iconst_1
    //   174: ireturn
    //   175: ldc 12
    //   177: ldc 220
    //   179: iconst_1
    //   180: anewarray 145	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_0
    //   186: aastore
    //   187: invokestatic 151	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: invokestatic 223	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   197: invokeinterface 102 1 0
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_1
    //   205: goto +16 -> 221
    //   208: astore_1
    //   209: ldc 12
    //   211: aload_1
    //   212: invokevirtual 227	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   215: invokestatic 223	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: goto -25 -> 193
    //   221: aload_0
    //   222: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   225: invokeinterface 102 1 0
    //   230: goto +5 -> 235
    //   233: aload_1
    //   234: athrow
    //   235: goto -2 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	ArkSoftwareView
    //   0	238	1	paramRect	Rect
    //   11	41	2	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   112	136	204	finally
    //   139	154	204	finally
    //   175	193	204	finally
    //   209	218	204	finally
    //   112	136	208	java/lang/OutOfMemoryError
    //   139	154	208	java/lang/OutOfMemoryError
    //   175	193	208	java/lang/OutOfMemoryError
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
  
  /* Error */
  public Bitmap recreateBitmapBuffer(Rect paramRect)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 120	android/graphics/Rect:isEmpty	()Z
    //   4: ifeq +23 -> 27
    //   7: ldc 12
    //   9: ldc 244
    //   11: iconst_1
    //   12: anewarray 145	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: invokestatic 151	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   22: invokestatic 223	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aconst_null
    //   26: areturn
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   32: getfield 169	com/tencent/ark/ArkViewImplement:mScale	F
    //   35: invokestatic 175	com/tencent/ark/ArkViewModel:scaleRect	(Landroid/graphics/Rect;F)Landroid/graphics/Rect;
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 232	android/graphics/Rect:width	()I
    //   43: istore_2
    //   44: aload_1
    //   45: invokevirtual 235	android/graphics/Rect:height	()I
    //   48: istore_3
    //   49: aload_0
    //   50: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 83 1 0
    //   58: aload_0
    //   59: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +64 -> 130
    //   69: aload 4
    //   71: invokevirtual 117	android/graphics/Bitmap:isRecycled	()Z
    //   74: ifne +56 -> 130
    //   77: aload_0
    //   78: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   81: invokevirtual 247	android/graphics/Bitmap:getWidth	()I
    //   84: iload_2
    //   85: if_icmplt +45 -> 130
    //   88: aload_0
    //   89: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   92: invokevirtual 250	android/graphics/Bitmap:getHeight	()I
    //   95: iload_3
    //   96: if_icmplt +34 -> 130
    //   99: aload_0
    //   100: aload_1
    //   101: putfield 66	com/tencent/ark/ArkSoftwareView:mRectBitmap	Landroid/graphics/Rect;
    //   104: aload_0
    //   105: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 64	com/tencent/ark/ArkSoftwareView:mPath	Landroid/graphics/Path;
    //   113: invokevirtual 254	com/tencent/ark/ArkViewImplement:refreshDrawPath	(Landroid/graphics/Rect;Landroid/graphics/Path;)V
    //   116: aload_0
    //   117: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   120: invokeinterface 102 1 0
    //   125: aload_0
    //   126: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   129: areturn
    //   130: ldc 12
    //   132: ldc_w 256
    //   135: iconst_1
    //   136: anewarray 145	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_0
    //   142: aastore
    //   143: invokestatic 151	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokestatic 157	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield 85	com/tencent/ark/ArkSoftwareView:mCanvas	Landroid/graphics/Canvas;
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield 87	com/tencent/ark/ArkSoftwareView:mCanvasView	Landroid/graphics/Canvas;
    //   159: aload_0
    //   160: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   163: astore 4
    //   165: aload 4
    //   167: ifnull +13 -> 180
    //   170: aload 4
    //   172: invokevirtual 94	android/graphics/Bitmap:recycle	()V
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   180: aload_0
    //   181: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   184: astore 4
    //   186: aload 4
    //   188: ifnull +13 -> 201
    //   191: aload 4
    //   193: invokevirtual 94	android/graphics/Bitmap:recycle	()V
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   201: aload_0
    //   202: getfield 66	com/tencent/ark/ArkSoftwareView:mRectBitmap	Landroid/graphics/Rect;
    //   205: astore 4
    //   207: aload 4
    //   209: ifnull +8 -> 217
    //   212: aload 4
    //   214: invokevirtual 99	android/graphics/Rect:setEmpty	()V
    //   217: aload_0
    //   218: iload_2
    //   219: iload_3
    //   220: getstatic 205	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   223: invokestatic 260	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   226: putfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   229: aload_0
    //   230: iload_2
    //   231: iload_3
    //   232: getstatic 205	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   235: invokestatic 260	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   238: putfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   241: aload_0
    //   242: aload_1
    //   243: putfield 66	com/tencent/ark/ArkSoftwareView:mRectBitmap	Landroid/graphics/Rect;
    //   246: aload_0
    //   247: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   250: ifnull +18 -> 268
    //   253: aload_0
    //   254: new 134	android/graphics/Canvas
    //   257: dup
    //   258: aload_0
    //   259: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   262: invokespecial 263	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   265: putfield 85	com/tencent/ark/ArkSoftwareView:mCanvas	Landroid/graphics/Canvas;
    //   268: aload_0
    //   269: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   272: ifnull +18 -> 290
    //   275: aload_0
    //   276: new 134	android/graphics/Canvas
    //   279: dup
    //   280: aload_0
    //   281: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   284: invokespecial 263	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   287: putfield 87	com/tencent/ark/ArkSoftwareView:mCanvasView	Landroid/graphics/Canvas;
    //   290: aload_0
    //   291: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   294: invokeinterface 102 1 0
    //   299: aload_0
    //   300: getfield 75	com/tencent/ark/ArkSoftwareView:mViewImpl	Lcom/tencent/ark/ArkViewImplement;
    //   303: aload_1
    //   304: aload_0
    //   305: getfield 64	com/tencent/ark/ArkSoftwareView:mPath	Landroid/graphics/Path;
    //   308: invokevirtual 254	com/tencent/ark/ArkViewImplement:refreshDrawPath	(Landroid/graphics/Rect;Landroid/graphics/Path;)V
    //   311: aload_0
    //   312: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   315: areturn
    //   316: astore_1
    //   317: goto +81 -> 398
    //   320: astore_1
    //   321: ldc 12
    //   323: aload_1
    //   324: invokevirtual 227	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   327: invokestatic 223	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_0
    //   331: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   334: ifnull +15 -> 349
    //   337: aload_0
    //   338: getfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   341: invokevirtual 94	android/graphics/Bitmap:recycle	()V
    //   344: aload_0
    //   345: aconst_null
    //   346: putfield 89	com/tencent/ark/ArkSoftwareView:mBitmap	Landroid/graphics/Bitmap;
    //   349: aload_0
    //   350: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   353: ifnull +15 -> 368
    //   356: aload_0
    //   357: getfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   360: invokevirtual 94	android/graphics/Bitmap:recycle	()V
    //   363: aload_0
    //   364: aconst_null
    //   365: putfield 96	com/tencent/ark/ArkSoftwareView:mBitmapView	Landroid/graphics/Bitmap;
    //   368: ldc 12
    //   370: ldc_w 265
    //   373: iconst_1
    //   374: anewarray 145	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: aload_0
    //   380: aastore
    //   381: invokestatic 151	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   384: invokestatic 223	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload_0
    //   388: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   391: invokeinterface 102 1 0
    //   396: aconst_null
    //   397: areturn
    //   398: aload_0
    //   399: getfield 57	com/tencent/ark/ArkSoftwareView:mBitmapLock	Ljava/util/concurrent/locks/Lock;
    //   402: invokeinterface 102 1 0
    //   407: aload_1
    //   408: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	ArkSoftwareView
    //   0	409	1	paramRect	Rect
    //   43	188	2	i	int
    //   48	184	3	j	int
    //   62	151	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   217	268	316	finally
    //   268	290	316	finally
    //   321	349	316	finally
    //   349	368	316	finally
    //   368	387	316	finally
    //   217	268	320	java/lang/OutOfMemoryError
    //   268	290	320	java/lang/OutOfMemoryError
  }
  
  public void releaseContext() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkSoftwareView
 * JD-Core Version:    0.7.0.1
 */