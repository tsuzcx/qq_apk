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
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.utils.ImageManagerLog;

@Public
public class RoundCornerProcessor
  extends ImageProcessor
{
  private static final String TAG = "RoundCornerProcessor";
  private float mRadius = -1.0F;
  private float[] mRadiusArray;
  
  @Public
  public RoundCornerProcessor(float paramFloat)
  {
    setRadius(paramFloat);
  }
  
  @Public
  public RoundCornerProcessor(float[] paramArrayOfFloat)
  {
    setRadiusArray(paramArrayOfFloat);
  }
  
  public static BitmapReference getRoundedCornerBitmap(BitmapReference paramBitmapReference, float[] paramArrayOfFloat)
  {
    BitmapReference localBitmapReference2;
    try
    {
      BitmapReference localBitmapReference1 = ImageManager.getInstance().getBitmap(paramBitmapReference.getWidth(), paramBitmapReference.getHeight(), Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OOM,");
      ((StringBuilder)localObject).append(localOutOfMemoryError.toString());
      ImageManagerLog.e("RoundCornerProcessor", ((StringBuilder)localObject).toString());
      localBitmapReference2 = ImageManager.getInstance().getBitmap(paramBitmapReference.getWidth(), paramBitmapReference.getHeight(), Bitmap.Config.ARGB_4444);
    }
    Object localObject = new Canvas(localBitmapReference2.getBitmap());
    RectF localRectF = new RectF(0.0F, 0.0F, paramBitmapReference.getWidth(), paramBitmapReference.getHeight());
    Path localPath = new Path();
    Paint localPaint = new Paint();
    localPath.addRoundRect(localRectF, paramArrayOfFloat, Path.Direction.CW);
    localPaint.setAntiAlias(true);
    ((Canvas)localObject).drawPath(localPath, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject).drawBitmap(paramBitmapReference.getBitmap(), null, localRectF, localPaint);
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
    Drawable localDrawable = paramDrawable;
    if (this.mPreProcessor != null) {
      localDrawable = this.mPreProcessor.process(paramDrawable);
    }
    if (this.mRadiusArray == null) {
      return localDrawable;
    }
    paramDrawable = ImageManagerEnv.g().drawableToBitmap(localDrawable);
    if (paramDrawable == null) {
      return localDrawable;
    }
    paramDrawable = getRoundedCornerBitmap(paramDrawable, this.mRadiusArray);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.RoundCornerProcessor
 * JD-Core Version:    0.7.0.1
 */