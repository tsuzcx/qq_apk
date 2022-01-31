package com.tencent.component.media.image.processor;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

public class MarkProcessor
  extends ImageProcessor
{
  private Bitmap mMarker;
  private float mPercent;
  private int mType;
  
  public MarkProcessor(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    this.mMarker = paramBitmap;
    this.mType = paramInt;
    this.mPercent = paramFloat;
  }
  
  public int getType()
  {
    return 7;
  }
  
  @TargetApi(12)
  public Drawable process(Drawable paramDrawable)
  {
    BitmapReference localBitmapReference2 = ImageManagerEnv.g().drawableToBitmap(paramDrawable);
    if (localBitmapReference2 == null) {
      return paramDrawable;
    }
    try
    {
      localBitmapReference1 = ImageManager.getInstance().getBitmap(localBitmapReference2.getWidth(), localBitmapReference2.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmapReference1.getBitmap());
      RectF localRectF = new RectF(0.0F, 0.0F, localBitmapReference2.getWidth(), localBitmapReference2.getHeight());
      f1 = localBitmapReference2.getWidth();
      f1 = this.mPercent * f1;
      f2 = localBitmapReference2.getHeight();
      f2 = this.mPercent * f2;
      switch (this.mType)
      {
      default: 
        paramDrawable = null;
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localCanvas.drawBitmap(localBitmapReference2.getBitmap(), null, localRectF, localPaint);
        localCanvas.drawBitmap(this.mMarker, null, paramDrawable, localPaint);
        return new BitmapRefDrawable(localBitmapReference1);
      }
    }
    catch (OutOfMemoryError paramDrawable)
    {
      for (;;)
      {
        float f1;
        float f2;
        BitmapReference localBitmapReference1 = ImageManager.getInstance().getBitmap(localBitmapReference2.getWidth(), localBitmapReference2.getHeight(), Bitmap.Config.ARGB_4444);
        continue;
        paramDrawable = new RectF(0.0F, 0.0F, f1, f2);
        continue;
        paramDrawable = new RectF(localBitmapReference2.getWidth() - f1, 0.0F, localBitmapReference2.getWidth(), f2);
        continue;
        paramDrawable = new RectF(0.0F, localBitmapReference2.getHeight() - f2, f1, localBitmapReference2.getHeight());
        continue;
        paramDrawable = new RectF(localBitmapReference2.getWidth() - f1, localBitmapReference2.getHeight() - f2, localBitmapReference2.getWidth(), localBitmapReference2.getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.MarkProcessor
 * JD-Core Version:    0.7.0.1
 */