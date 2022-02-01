package com.tencent.biz.qqcircle.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;

public class DrawUtils
{
  public static Paint a;
  private static final Rect b = new Rect();
  private static final TextPaint c = new TextPaint();
  private static final Map<Float, Float> d = new HashMap();
  private static final Map<Float, Float> e = new HashMap();
  private static final Map<Float, Float> f = new HashMap();
  
  static
  {
    a = new Paint();
    a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public static void a(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.DrawUtils
 * JD-Core Version:    0.7.0.1
 */