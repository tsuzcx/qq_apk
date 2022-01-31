package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

public class ImageTools
{
  public static final int BLURBORDER_RADIUS = 2;
  public static final int SMOOTHBORDER_RADIUS = 11;
  
  public static void formatAlphaBitmap(Bitmap paramBitmap)
  {
    PaintSelection.FormatAlphaBitmap(paramBitmap);
  }
  
  public static boolean hasAlphaBitmap(Bitmap paramBitmap)
  {
    return PaintSelection.HasAlphaBitmap(paramBitmap);
  }
  
  public static void processBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    PaintSelection.ProcessBitmap(paramBitmap1, paramBitmap2);
  }
  
  public static void reverseBitmapAlpha(Bitmap paramBitmap)
  {
    PaintSelection.reverseBitmapAlpha(paramBitmap);
  }
  
  public static Bitmap toColorRedscale(Bitmap paramBitmap)
  {
    try
    {
      int i = paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      ColorMatrix localColorMatrix = new ColorMatrix();
      localColorMatrix.set(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 70.0F, 0.0F, 1.0F, 0.0F, 0.0F, -30.0F, 0.0F, 0.0F, 1.0F, 0.0F, -30.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
      localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      return localBitmap;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap toGrayscale(Bitmap paramBitmap)
  {
    int i = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  public static Bitmap toGrayscale(Bitmap paramBitmap, int paramInt)
  {
    return toRoundCorner(toGrayscale(paramBitmap), paramInt);
  }
  
  public static Bitmap toRoundCorner(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    float f = paramInt;
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static BitmapDrawable toRoundCorner(BitmapDrawable paramBitmapDrawable, int paramInt)
  {
    return new BitmapDrawable(toRoundCorner(paramBitmapDrawable.getBitmap(), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ImageTools
 * JD-Core Version:    0.7.0.1
 */