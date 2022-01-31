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
import java.io.IOException;

public class GifDrawable
  extends Drawable
  implements AnimationCallback
{
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  private int mGifHeight;
  private GifState mGifState;
  private int mGifWidth;
  private int mTargetDensity = 160;
  boolean mUseAnimation = true;
  
  public GifDrawable(AbstractGifImage paramAbstractGifImage)
  {
    this(paramAbstractGifImage, null);
  }
  
  public GifDrawable(AbstractGifImage paramAbstractGifImage, Resources paramResources)
  {
    this(new GifState(paramAbstractGifImage), paramResources);
    this.mGifState.mTargetDensity = this.mTargetDensity;
  }
  
  public GifDrawable(GifState paramGifState, Resources paramResources)
  {
    this.mGifState = paramGifState;
    paramGifState.mGif.attachDrawable(this);
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramGifState.mTargetDensity)
    {
      computeImageSize();
      return;
    }
  }
  
  public GifDrawable(File paramFile, Resources paramResources)
    throws IOException
  {
    this(paramFile, paramResources, false);
  }
  
  public GifDrawable(File paramFile, Resources paramResources, boolean paramBoolean)
    throws IOException
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
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +10 -> 13
    //   6: aload_0
    //   7: invokevirtual 107	java/io/File:exists	()Z
    //   10: ifne +7 -> 17
    //   13: iconst_0
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: aconst_null
    //   18: astore_3
    //   19: aconst_null
    //   20: astore 4
    //   22: new 109	java/io/RandomAccessFile
    //   25: dup
    //   26: aload_0
    //   27: ldc 111
    //   29: invokespecial 114	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore_0
    //   33: iconst_3
    //   34: newarray byte
    //   36: astore_3
    //   37: aload_0
    //   38: aload_3
    //   39: invokevirtual 118	java/io/RandomAccessFile:read	([B)I
    //   42: pop
    //   43: aload_3
    //   44: iconst_0
    //   45: baload
    //   46: bipush 71
    //   48: if_icmpne +21 -> 69
    //   51: aload_3
    //   52: iconst_1
    //   53: baload
    //   54: bipush 73
    //   56: if_icmpne +13 -> 69
    //   59: aload_3
    //   60: iconst_2
    //   61: baload
    //   62: istore_1
    //   63: iload_1
    //   64: bipush 70
    //   66: if_icmpeq +13 -> 79
    //   69: aload_0
    //   70: ifnull +7 -> 77
    //   73: aload_0
    //   74: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   77: iconst_0
    //   78: ireturn
    //   79: aload_0
    //   80: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   83: aload_0
    //   84: ifnull -69 -> 15
    //   87: aload_0
    //   88: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   91: iconst_1
    //   92: ireturn
    //   93: astore_0
    //   94: iconst_1
    //   95: ireturn
    //   96: astore_0
    //   97: aload 4
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_0
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: astore_0
    //   122: goto -45 -> 77
    //   125: astore_0
    //   126: goto -18 -> 108
    //   129: astore_3
    //   130: goto -11 -> 119
    //   133: astore 4
    //   135: aload_0
    //   136: astore_3
    //   137: aload 4
    //   139: astore_0
    //   140: goto -29 -> 111
    //   143: astore_3
    //   144: goto -44 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramFile	File
    //   62	5	1	i	int
    //   1	15	2	bool	boolean
    //   18	98	3	arrayOfByte	byte[]
    //   129	1	3	localIOException	IOException
    //   136	1	3	localFile	File
    //   143	1	3	localException	java.lang.Exception
    //   20	78	4	localObject1	Object
    //   133	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   87	91	93	java/io/IOException
    //   22	33	96	java/lang/Exception
    //   22	33	110	finally
    //   73	77	121	java/io/IOException
    //   104	108	125	java/io/IOException
    //   115	119	129	java/io/IOException
    //   33	43	133	finally
    //   79	83	133	finally
    //   33	43	143	java/lang/Exception
    //   79	83	143	java/lang/Exception
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
    this.mGifState = new GifState(this.mGifState);
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
  
  public void setGIFPlayOnceListener(OnGIFPlayOnceListener paramOnGIFPlayOnceListener)
  {
    if ((this.mGifState != null) && (this.mGifState.mGif != null)) {
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
  
  static final class GifState
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    AbstractGifImage mGif;
    int mGravity = 119;
    Paint mPaint = new Paint(6);
    int mTargetDensity = 160;
    boolean stickerPause = false;
    
    public GifState(AbstractGifImage paramAbstractGifImage)
    {
      this.mGif = paramAbstractGifImage;
    }
    
    public GifState(GifState paramGifState)
    {
      this.mGif = paramGifState.mGif;
      this.mChangingConfigurations = paramGifState.mChangingConfigurations;
      this.mGravity = paramGifState.mGravity;
      this.mTargetDensity = paramGifState.mTargetDensity;
      this.mPaint = new Paint(6);
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new GifDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new GifDrawable(this, paramResources);
    }
    
    public void setStickerPause(boolean paramBoolean)
    {
      this.stickerPause = paramBoolean;
    }
  }
  
  public static abstract interface OnGIFPlayOnceListener
  {
    public abstract void onPlayOnce();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.GifDrawable
 * JD-Core Version:    0.7.0.1
 */