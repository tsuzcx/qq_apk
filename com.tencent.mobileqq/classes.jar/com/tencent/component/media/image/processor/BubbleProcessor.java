package com.tencent.component.media.image.processor;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

public class BubbleProcessor
  extends ImageProcessor
{
  private Bitmap mMask;
  
  public BubbleProcessor(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.mMask = paramBitmap;
      return;
    }
    throw new IllegalArgumentException("mask bitmap can not be null for BubbleProcessor");
  }
  
  public int getType()
  {
    return 6;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    Object localObject2 = ImageManagerEnv.g().drawableToBitmap(paramDrawable);
    Object localObject1 = paramDrawable;
    if (localObject2 != null) {
      if (this.mMask == null) {
        return paramDrawable;
      }
    }
    try
    {
      localObject1 = BitmapReference.getBitmapReference(Bitmap.createScaledBitmap(((BitmapReference)localObject2).getBitmap(), this.mMask.getWidth(), this.mMask.getHeight(), true));
    }
    catch (Exception localException)
    {
      label70:
      RectF localRectF;
      Paint localPaint;
      return paramDrawable;
    }
    try
    {
      paramDrawable = ImageManager.getInstance().getBitmap(((BitmapReference)localObject1).getWidth(), ((BitmapReference)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError paramDrawable)
    {
      break label70;
    }
    paramDrawable = BitmapReference.getBitmapReference(Bitmap.createBitmap(((BitmapReference)localObject1).getWidth(), ((BitmapReference)localObject1).getHeight(), Bitmap.Config.ARGB_4444));
    localObject2 = new Canvas(paramDrawable.getBitmap());
    localRectF = new RectF(0.0F, 0.0F, ((BitmapReference)localObject1).getWidth(), ((BitmapReference)localObject1).getHeight());
    localPaint = new Paint();
    localPaint.setAntiAlias(true);
    ((Canvas)localObject2).drawBitmap(this.mMask, null, localRectF, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject2).drawBitmap(((BitmapReference)localObject1).getBitmap(), null, localRectF, localPaint);
    localObject1 = new BitmapRefDrawable(paramDrawable);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.processor.BubbleProcessor
 * JD-Core Version:    0.7.0.1
 */