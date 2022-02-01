package com.tencent.component.media.image.processor;

import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;

@Public
public class AdvRoundCornerProcessor
  extends ImageProcessor
{
  private static final String TAG = "AdvRoundCornerProcessor";
  private float mRadius = -1.0F;
  private float[] mRadiusArray;
  private int requestedHeight = 0;
  private int requestedWidth = 0;
  
  @Public
  public AdvRoundCornerProcessor(float paramFloat)
  {
    setRadius(paramFloat);
  }
  
  @Public
  public AdvRoundCornerProcessor(float[] paramArrayOfFloat)
  {
    setRadiusArray(paramArrayOfFloat);
  }
  
  @Public
  public AdvRoundCornerProcessor(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    setRadiusArray(paramArrayOfFloat);
    this.requestedWidth = paramInt1;
    this.requestedHeight = paramInt2;
  }
  
  public static BitmapReference getRoundedCornerBitmap(BitmapReference paramBitmapReference, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f1 = paramBitmapReference.getWidth();
    float f2 = paramBitmapReference.getHeight();
    float f3 = paramInt2;
    float f4 = paramInt1;
    if (f3 * f1 > f2 * f4) {
      paramInt2 = (int)(f2 / f1 * f4 + 0.5F);
    }
    BitmapReference localBitmapReference2;
    try
    {
      BitmapReference localBitmapReference1 = ImageManager.getInstance().getBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject1 = ImageManagerEnv.getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OOM,");
      ((StringBuilder)localObject2).append(localOutOfMemoryError.toString());
      ((ILog)localObject1).e("AdvRoundCornerProcessor", new Object[] { ((StringBuilder)localObject2).toString() });
      localBitmapReference2 = ImageManager.getInstance().getBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
    }
    Object localObject1 = new Canvas(localBitmapReference2.getBitmap());
    Object localObject2 = new RectF(0.0F, 0.0F, f4, paramInt2);
    Path localPath = new Path();
    Paint localPaint = new Paint();
    localPath.addRoundRect((RectF)localObject2, paramArrayOfFloat, Path.Direction.CW);
    localPaint.setAntiAlias(true);
    ((Canvas)localObject1).drawPath(localPath, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject1).drawBitmap(paramBitmapReference.getBitmap(), null, (RectF)localObject2, localPaint);
    return localBitmapReference2;
  }
  
  @Public
  public float getRadius()
  {
    float f = this.mRadius;
    if (f > 0.0F) {
      return f;
    }
    return 0.0F;
  }
  
  @Public
  public float[] getRadiusArray()
  {
    return this.mRadiusArray;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    if (this.mRadiusArray == null) {
      return paramDrawable;
    }
    BitmapReference localBitmapReference = ImageManagerEnv.g().drawableToBitmap(paramDrawable);
    if (localBitmapReference == null) {
      return paramDrawable;
    }
    paramDrawable = getRoundedCornerBitmap(localBitmapReference, this.mRadiusArray, this.requestedWidth, this.requestedHeight);
    if (paramDrawable == null) {
      return null;
    }
    return new SpecifiedBitmapDrawable(paramDrawable);
  }
  
  @Public
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    this.mRadiusArray = new float[8];
    int i = 0;
    for (;;)
    {
      float[] arrayOfFloat = this.mRadiusArray;
      if (i >= arrayOfFloat.length) {
        break;
      }
      arrayOfFloat[i] = paramFloat;
      i += 1;
    }
  }
  
  @Public
  public void setRadiusArray(float[] paramArrayOfFloat)
  {
    this.mRadiusArray = paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.processor.AdvRoundCornerProcessor
 * JD-Core Version:    0.7.0.1
 */