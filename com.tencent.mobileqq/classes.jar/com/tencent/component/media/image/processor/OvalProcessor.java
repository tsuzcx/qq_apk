package com.tencent.component.media.image.processor;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
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
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

public class OvalProcessor
  extends ImageProcessor
{
  public int getType()
  {
    return 3;
  }
  
  @TargetApi(12)
  public Drawable process(Drawable paramDrawable)
  {
    BitmapReference localBitmapReference = ImageManagerEnv.g().drawableToBitmap(paramDrawable);
    if (localBitmapReference == null) {
      return paramDrawable;
    }
    try
    {
      paramDrawable = ImageManager.getInstance().getBitmap(localBitmapReference.getWidth(), localBitmapReference.getHeight(), Bitmap.Config.ARGB_8888);
      paramDrawable.getBitmap().setHasAlpha(true);
      Canvas localCanvas = new Canvas(paramDrawable.getBitmap());
      RectF localRectF = new RectF(0.0F, 0.0F, localBitmapReference.getWidth(), localBitmapReference.getHeight());
      Path localPath = new Path();
      Paint localPaint = new Paint();
      localPath.addOval(localRectF, Path.Direction.CW);
      localPaint.setAntiAlias(true);
      localCanvas.drawPath(localPath, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(localBitmapReference.getBitmap(), null, localRectF, localPaint);
      localBitmapReference.release();
      return new BitmapRefDrawable(paramDrawable);
    }
    catch (OutOfMemoryError paramDrawable)
    {
      for (;;)
      {
        paramDrawable = BitmapReference.getBitmapReference(Bitmap.createBitmap(localBitmapReference.getWidth(), localBitmapReference.getHeight(), Bitmap.Config.ARGB_4444));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.OvalProcessor
 * JD-Core Version:    0.7.0.1
 */