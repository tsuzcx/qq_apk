package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import java.io.File;

public class GifDrawable
  extends Drawable
  implements AnimationCallback
{
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  private int mGifHeight;
  private GifDrawable.GifState mGifState;
  private int mGifWidth;
  private int mTargetDensity = 160;
  boolean mUseAnimation = true;
  
  public GifDrawable(AbstractGifImage paramAbstractGifImage)
  {
    this(paramAbstractGifImage, null);
  }
  
  public GifDrawable(AbstractGifImage paramAbstractGifImage, Resources paramResources)
  {
    this(new GifDrawable.GifState(paramAbstractGifImage), paramResources);
    this.mGifState.mTargetDensity = this.mTargetDensity;
  }
  
  public GifDrawable(GifDrawable.GifState paramGifState, Resources paramResources)
  {
    this.mGifState = paramGifState;
    paramGifState.mGif.attachDrawable(this);
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    } else {
      this.mTargetDensity = paramGifState.mTargetDensity;
    }
    computeImageSize();
  }
  
  public GifDrawable(File paramFile, Resources paramResources)
  {
    this(paramFile, paramResources, false);
  }
  
  public GifDrawable(File paramFile, Resources paramResources, boolean paramBoolean)
  {
    this(NativeGifFactory.getNativeGifObject(paramFile, paramBoolean), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mGifWidth = this.mGifState.mGif.getScaledWidth(this.mTargetDensity);
    this.mGifHeight = this.mGifState.mGif.getScaledHeight(this.mTargetDensity);
  }
  
  /* Error */
  public static boolean isGifFile(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +110 -> 111
    //   4: aload_0
    //   5: invokevirtual 102	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: new 104	java/io/RandomAccessFile
    //   16: dup
    //   17: aload_0
    //   18: ldc 106
    //   20: invokespecial 109	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_0
    //   24: iconst_3
    //   25: newarray byte
    //   27: astore_1
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 113	java/io/RandomAccessFile:read	([B)I
    //   33: pop
    //   34: aload_1
    //   35: iconst_0
    //   36: baload
    //   37: bipush 71
    //   39: if_icmpne +32 -> 71
    //   42: aload_1
    //   43: iconst_1
    //   44: baload
    //   45: bipush 73
    //   47: if_icmpne +24 -> 71
    //   50: aload_1
    //   51: iconst_2
    //   52: baload
    //   53: bipush 70
    //   55: if_icmpeq +6 -> 61
    //   58: goto +13 -> 71
    //   61: aload_0
    //   62: invokevirtual 116	java/io/RandomAccessFile:close	()V
    //   65: aload_0
    //   66: invokevirtual 116	java/io/RandomAccessFile:close	()V
    //   69: iconst_1
    //   70: ireturn
    //   71: aload_0
    //   72: invokevirtual 116	java/io/RandomAccessFile:close	()V
    //   75: iconst_0
    //   76: ireturn
    //   77: astore_2
    //   78: aload_0
    //   79: astore_1
    //   80: aload_2
    //   81: astore_0
    //   82: goto +9 -> 91
    //   85: goto +18 -> 103
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 116	java/io/RandomAccessFile:close	()V
    //   99: aload_0
    //   100: athrow
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 116	java/io/RandomAccessFile:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_0
    //   114: goto -13 -> 101
    //   117: astore_1
    //   118: goto -33 -> 85
    //   121: astore_0
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_0
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: goto -29 -> 99
    //   131: astore_0
    //   132: iconst_0
    //   133: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramFile	File
    //   27	69	1	localObject1	java.lang.Object
    //   117	1	1	localException	java.lang.Exception
    //   127	1	1	localIOException	java.io.IOException
    //   77	4	2	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   24	34	77	finally
    //   61	65	77	finally
    //   13	24	88	finally
    //   13	24	113	java/lang/Exception
    //   24	34	117	java/lang/Exception
    //   61	65	117	java/lang/Exception
    //   65	69	121	java/io/IOException
    //   71	75	124	java/io/IOException
    //   95	99	127	java/io/IOException
    //   107	111	131	java/io/IOException
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mApplyGravity)
    {
      Gravity.apply(this.mGifState.mGravity, this.mGifWidth, this.mGifHeight, getBounds(), this.mDstRect);
      this.mApplyGravity = false;
    }
    if (((this.mGifState.mGif instanceof NativeGifImage)) && (this.mGifState.stickerPause))
    {
      ((NativeGifImage)this.mGifState.mGif).drawFirstFrame(paramCanvas, this.mDstRect, this.mGifState.mPaint);
      return;
    }
    this.mGifState.mGif.draw(paramCanvas, this.mDstRect, this.mGifState.mPaint, this.mUseAnimation);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mGifState;
  }
  
  public int getGravity()
  {
    return this.mGifState.mGravity;
  }
  
  public AbstractGifImage getImage()
  {
    return this.mGifState.mGif;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mGifHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mGifWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
  }
  
  public Drawable mutate()
  {
    this.mGifState = new GifDrawable.GifState(this.mGifState);
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mGifState.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mGifState.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mGifState.mPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mGifState.mPaint.setFilterBitmap(paramBoolean);
  }
  
  public void setGIFPlayOnceListener(GifDrawable.OnGIFPlayOnceListener paramOnGIFPlayOnceListener)
  {
    GifDrawable.GifState localGifState = this.mGifState;
    if ((localGifState != null) && (localGifState.mGif != null)) {
      this.mGifState.mGif.setGIFPlayOnceListener(paramOnGIFPlayOnceListener);
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.mGifState.mGravity = paramInt;
    this.mApplyGravity = true;
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeImageSize();
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.GifDrawable
 * JD-Core Version:    0.7.0.1
 */