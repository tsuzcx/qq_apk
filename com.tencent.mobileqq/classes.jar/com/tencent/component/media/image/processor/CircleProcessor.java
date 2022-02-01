package com.tencent.component.media.image.processor;

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
import android.os.Build.VERSION;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

public class CircleProcessor
  extends ImageProcessor
{
  public int getType()
  {
    return 8;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    BitmapReference localBitmapReference = ImageManagerEnv.g().drawableToBitmap(paramDrawable);
    if (localBitmapReference == null) {
      return paramDrawable;
    }
    int i = Math.max(localBitmapReference.getWidth(), localBitmapReference.getHeight());
    try
    {
      paramDrawable = ImageManager.getInstance().getBitmap(i, i, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError paramDrawable)
    {
      label45:
      Canvas localCanvas;
      float f;
      RectF localRectF;
      Path localPath;
      Paint localPaint;
      break label45;
    }
    paramDrawable = BitmapReference.getBitmapReference(Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444));
    if (Build.VERSION.SDK_INT >= 12) {
      paramDrawable.getBitmap().setHasAlpha(true);
    }
    localCanvas = new Canvas(paramDrawable.getBitmap());
    f = i;
    localRectF = new RectF(0.0F, 0.0F, f, f);
    localPath = new Path();
    localPaint = new Paint();
    i = Math.min(localCanvas.getWidth(), localCanvas.getHeight());
    localPath.addCircle(localCanvas.getWidth() / 2, localCanvas.getHeight() / 2, i / 2, Path.Direction.CW);
    localPaint.setAntiAlias(true);
    localCanvas.drawPath(localPath, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(localBitmapReference.getBitmap(), null, localRectF, localPaint);
    localBitmapReference.release();
    return new BitmapRefDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.processor.CircleProcessor
 * JD-Core Version:    0.7.0.1
 */