package com.tencent.component.media.image.processor;

import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;

@Public
public class ScaleProcessor
  extends ImageProcessor
{
  private static volatile Matrix sScaleMatrix;
  private int mHeight;
  private boolean mIsScaleInProportion;
  private int mWidth;
  
  @Public
  public ScaleProcessor(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  @Public
  public ScaleProcessor(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mIsScaleInProportion = paramBoolean;
  }
  
  public static BitmapReference createBitmap(BitmapReference paramBitmapReference, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, boolean paramBoolean)
  {
    int i = paramInt1 + paramInt3;
    if (i <= paramBitmapReference.getWidth())
    {
      int j = paramInt2 + paramInt4;
      if (j <= paramBitmapReference.getHeight())
      {
        if ((!paramBitmapReference.isMutable()) && (paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == paramBitmapReference.getWidth()) && (paramInt4 == paramBitmapReference.getHeight()) && ((paramMatrix == null) || (paramMatrix.isIdentity()))) {
          return paramBitmapReference;
        }
        Canvas localCanvas = new Canvas();
        Rect localRect = new Rect(paramInt1, paramInt2, i, j);
        RectF localRectF = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
        Object localObject1 = Bitmap.Config.ARGB_8888;
        Object localObject2 = paramBitmapReference.getConfig();
        if (localObject2 != null)
        {
          paramInt1 = ScaleProcessor.1.$SwitchMap$android$graphics$Bitmap$Config[localObject2.ordinal()];
          if (paramInt1 != 1)
          {
            if (paramInt1 != 2) {
              localObject1 = Bitmap.Config.ARGB_8888;
            } else {
              localObject1 = Bitmap.Config.ALPHA_8;
            }
          }
          else {
            localObject1 = Bitmap.Config.RGB_565;
          }
        }
        if ((paramMatrix != null) && (!paramMatrix.isIdentity()))
        {
          paramInt1 = paramMatrix.rectStaysRect() ^ true;
          Object localObject3 = new RectF();
          paramMatrix.mapRect((RectF)localObject3, localRectF);
          paramInt2 = Math.round(((RectF)localObject3).width());
          paramInt3 = Math.round(((RectF)localObject3).height());
          localObject2 = ImageManager.getInstance();
          if (paramInt1 != 0) {
            localObject1 = Bitmap.Config.ARGB_8888;
          }
          localObject2 = ((ImageManager)localObject2).getBitmap(paramInt2, paramInt3, (Bitmap.Config)localObject1);
          localCanvas.setBitmap(((BitmapReference)localObject2).getBitmap());
          localCanvas.translate(-((RectF)localObject3).left, -((RectF)localObject3).top);
          localCanvas.concat(paramMatrix);
          localObject3 = new Paint();
          ((Paint)localObject3).setFilterBitmap(paramBoolean);
          paramMatrix = (Matrix)localObject2;
          localObject1 = localObject3;
          if (paramInt1 != 0)
          {
            ((Paint)localObject3).setAntiAlias(true);
            paramMatrix = (Matrix)localObject2;
            localObject1 = localObject3;
          }
        }
        else
        {
          paramMatrix = ImageManager.getInstance().getBitmap(paramInt3, paramInt4, (Bitmap.Config)localObject1);
          localCanvas.setBitmap(paramMatrix.getBitmap());
          localObject1 = null;
        }
        localCanvas.drawBitmap(paramBitmapReference.getBitmap(), localRect, localRectF, (Paint)localObject1);
        try
        {
          localCanvas.setBitmap(null);
          return paramMatrix;
        }
        catch (Throwable paramBitmapReference)
        {
          paramBitmapReference.printStackTrace();
          localObject1 = ImageManagerEnv.getLogger();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("canvas.setBitmap(null) catch an exception:");
          ((StringBuilder)localObject2).append(paramBitmapReference.getMessage());
          ((ILog)localObject1).e("ScaleProcessor", new Object[] { ((StringBuilder)localObject2).toString() });
          return paramMatrix;
        }
      }
      throw new IllegalArgumentException("y + height must be <= bitmap.height()");
    }
    throw new IllegalArgumentException("x + width must be <= bitmap.width()");
  }
  
  /* Error */
  public static BitmapReference createScaledBitmap(BitmapReference paramBitmapReference, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 202
    //   2: monitorenter
    //   3: getstatic 204	com/tencent/component/media/image/processor/ScaleProcessor:sScaleMatrix	Landroid/graphics/Matrix;
    //   6: astore 7
    //   8: aconst_null
    //   9: putstatic 204	com/tencent/component/media/image/processor/ScaleProcessor:sScaleMatrix	Landroid/graphics/Matrix;
    //   12: ldc 202
    //   14: monitorexit
    //   15: aload 7
    //   17: astore 6
    //   19: aload 7
    //   21: ifnonnull +12 -> 33
    //   24: new 46	android/graphics/Matrix
    //   27: dup
    //   28: invokespecial 205	android/graphics/Matrix:<init>	()V
    //   31: astore 6
    //   33: aload_0
    //   34: invokevirtual 37	com/tencent/component/media/image/BitmapReference:getWidth	()I
    //   37: istore 4
    //   39: aload_0
    //   40: invokevirtual 40	com/tencent/component/media/image/BitmapReference:getHeight	()I
    //   43: istore 5
    //   45: aload 6
    //   47: iload_1
    //   48: i2f
    //   49: iload 4
    //   51: i2f
    //   52: fdiv
    //   53: iload_2
    //   54: i2f
    //   55: iload 5
    //   57: i2f
    //   58: fdiv
    //   59: invokevirtual 208	android/graphics/Matrix:setScale	(FF)V
    //   62: aload_0
    //   63: iconst_0
    //   64: iconst_0
    //   65: iload 4
    //   67: iload 5
    //   69: aload 6
    //   71: iload_3
    //   72: invokestatic 210	com/tencent/component/media/image/processor/ScaleProcessor:createBitmap	(Lcom/tencent/component/media/image/BitmapReference;IIIILandroid/graphics/Matrix;Z)Lcom/tencent/component/media/image/BitmapReference;
    //   75: astore_0
    //   76: ldc 202
    //   78: monitorenter
    //   79: getstatic 204	com/tencent/component/media/image/processor/ScaleProcessor:sScaleMatrix	Landroid/graphics/Matrix;
    //   82: ifnonnull +8 -> 90
    //   85: aload 6
    //   87: putstatic 204	com/tencent/component/media/image/processor/ScaleProcessor:sScaleMatrix	Landroid/graphics/Matrix;
    //   90: ldc 202
    //   92: monitorexit
    //   93: aload_0
    //   94: areturn
    //   95: astore_0
    //   96: ldc 202
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: ldc 202
    //   104: monitorexit
    //   105: aload_0
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramBitmapReference	BitmapReference
    //   0	107	1	paramInt1	int
    //   0	107	2	paramInt2	int
    //   0	107	3	paramBoolean	boolean
    //   37	29	4	i	int
    //   43	25	5	j	int
    //   17	69	6	localMatrix1	Matrix
    //   6	14	7	localMatrix2	Matrix
    // Exception table:
    //   from	to	target	type
    //   79	90	95	finally
    //   90	93	95	finally
    //   96	99	95	finally
    //   3	15	101	finally
    //   102	105	101	finally
  }
  
  @Public
  public static BitmapReference getScaledBitmap(BitmapReference paramBitmapReference, int paramInt1, int paramInt2)
  {
    return getScaledBitmap(paramBitmapReference, paramInt1, paramInt2, false);
  }
  
  @Public
  public static BitmapReference getScaledBitmap(BitmapReference paramBitmapReference, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    BitmapReference localBitmapReference1 = paramBitmapReference;
    BitmapReference localBitmapReference2;
    if (paramBitmapReference != null) {
      if (paramInt1 <= 0)
      {
        localBitmapReference1 = paramBitmapReference;
        if (paramInt2 <= 0) {}
      }
      else
      {
        if ((paramBitmapReference.getWidth() == paramInt1) && (paramBitmapReference.getHeight() == paramInt2)) {
          return paramBitmapReference;
        }
        int i;
        int j;
        if (paramInt1 <= 0)
        {
          if (paramBoolean)
          {
            i = paramBitmapReference.getWidth() * paramInt2 / paramBitmapReference.getHeight();
            j = paramInt2;
          }
          else
          {
            i = paramBitmapReference.getWidth();
            j = paramInt2;
          }
        }
        else
        {
          i = paramInt1;
          j = paramInt2;
          if (paramInt2 <= 0) {
            if (paramBoolean)
            {
              j = paramBitmapReference.getHeight() * paramInt1 / paramBitmapReference.getWidth();
              i = paramInt1;
            }
            else
            {
              j = paramBitmapReference.getHeight();
              i = paramInt1;
            }
          }
        }
        try
        {
          localBitmapReference1 = createScaledBitmap(paramBitmapReference, i, j, false);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          localBitmapReference2 = null;
        }
        if (localBitmapReference2 == null) {
          return paramBitmapReference;
        }
      }
    }
    return localBitmapReference2;
  }
  
  @Public
  public int getHeight()
  {
    int i = this.mHeight;
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  @Public
  public boolean getIsScaleInProportion()
  {
    return this.mIsScaleInProportion;
  }
  
  public int getType()
  {
    return 1;
  }
  
  @Public
  public int getWidth()
  {
    int i = this.mWidth;
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    if ((this.mWidth <= 0) && (this.mHeight <= 0)) {
      return paramDrawable;
    }
    BitmapReference localBitmapReference = null;
    if ((paramDrawable instanceof ImageDrawable)) {
      localBitmapReference = ((ImageDrawable)paramDrawable).getBitmapRef();
    } else if ((paramDrawable instanceof SpecifiedBitmapDrawable)) {
      localBitmapReference = ((SpecifiedBitmapDrawable)paramDrawable).getBitmapRef();
    } else if ((paramDrawable instanceof BitmapDrawable)) {
      localBitmapReference = BitmapReference.getBitmapReference(((BitmapDrawable)paramDrawable).getBitmap());
    }
    if (localBitmapReference == null) {
      return paramDrawable;
    }
    return new SpecifiedBitmapDrawable(getScaledBitmap(localBitmapReference, this.mWidth, this.mHeight, this.mIsScaleInProportion));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.ScaleProcessor
 * JD-Core Version:    0.7.0.1
 */