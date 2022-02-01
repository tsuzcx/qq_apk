package com.tencent.common.danmaku.util;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.WindowConfig;
import java.util.HashMap;
import java.util.Map;

public class DrawUtils
{
  public static Paint a;
  public static Paint b;
  private static final Rect c = new Rect();
  private static final TextPaint d = new TextPaint();
  private static final Map<Float, Float> e = new HashMap();
  private static final Map<Float, Float> f = new HashMap();
  private static final Map<Float, Float> g = new HashMap();
  private static int h;
  
  static
  {
    a = new Paint();
    a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public static float a(float paramFloat)
  {
    d.setTextSize(paramFloat);
    Float localFloat = (Float)e.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = d.getFontMetrics();
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent + ((Paint.FontMetrics)localObject).leading);
      e.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  public static float a(float paramFloat, String paramString)
  {
    d.setTextSize(paramFloat);
    return a(d, paramString);
  }
  
  public static float a(Paint paramPaint, String paramString)
  {
    return paramPaint.measureText(paramString);
  }
  
  public static float a(WindowConfig paramWindowConfig)
  {
    return a(paramWindowConfig.m()) + DanmakuContext.a().d() * 2 + paramWindowConfig.n() * 2.0F + paramWindowConfig.o() * 2.0F;
  }
  
  public static void a(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public static void a(Canvas paramCanvas, String paramString)
  {
    if (b == null)
    {
      b = new Paint();
      b.setColor(-256);
      Object localObject = DanmakuDependImp.a().b().b().getDisplayMetrics();
      b.setTextSize(((DisplayMetrics)localObject).density * 12.5F);
      localObject = b.getFontMetrics();
      h = (int)Math.ceil(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
    }
    paramCanvas.drawText(paramString, 10.0F, paramCanvas.getHeight() - h, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.util.DrawUtils
 * JD-Core Version:    0.7.0.1
 */