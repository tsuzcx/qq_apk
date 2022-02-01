package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Random;

public class PerLineFontBitmapsInfo
{
  public TextPaint a = new TextPaint();
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public ArrayList<FontBitmapInfo> g;
  public int h = 0;
  
  public PerLineFontBitmapsInfo(int paramInt1, int paramInt2, Typeface paramTypeface, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
    }
    this.a.setDither(true);
    this.a.setTextSize(paramInt1);
    this.a.setColor(paramInt2);
    this.a.setTypeface(paramTypeface);
    this.b = paramInt3;
    this.c = paramInt4;
    this.d = paramInt5;
    this.e = paramInt6;
  }
  
  public static int a()
  {
    Random localRandom = new Random();
    return localRandom.nextInt(5) * 100 + localRandom.nextInt(9) * 10 + localRandom.nextInt(9);
  }
  
  public static PerLineFontBitmapsInfo a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, AnimStateTypeEvaluator paramAnimStateTypeEvaluator)
  {
    paramTypeface = new PerLineFontBitmapsInfo(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.h = 1;
    paramTypeface.a(paramCharSequence, paramAnimStateTypeEvaluator);
    return paramTypeface;
  }
  
  public static void a(int paramInt, Paint paramPaint)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramInt == 255)
      {
        paramPaint.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
        return;
      }
      paramPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
    }
  }
  
  public void a(CharSequence paramCharSequence, AnimStateTypeEvaluator paramAnimStateTypeEvaluator)
  {
    a(paramCharSequence, paramAnimStateTypeEvaluator, 0);
  }
  
  public void a(CharSequence paramCharSequence, AnimStateTypeEvaluator paramAnimStateTypeEvaluator, int paramInt)
  {
    this.f = ((int)this.a.measureText(paramCharSequence, 0, paramCharSequence.length()));
    if (paramInt != 0)
    {
      j = this.f;
      if (paramInt > j)
      {
        j = (paramInt - j) / (paramCharSequence.length() - 1);
        break label57;
      }
    }
    int j = 0;
    label57:
    this.g = new ArrayList();
    int k = 0;
    paramInt = 0;
    while (k < paramCharSequence.length())
    {
      int i = paramCharSequence.charAt(k);
      if (i == 32)
      {
        paramInt += (int)this.a.measureText("0", 0, 1);
      }
      else
      {
        FontBitmapInfo localFontBitmapInfo = new FontBitmapInfo();
        String str = new String(new char[] { i });
        int m = (int)this.a.measureText(str, 0, str.length());
        Object localObject = this.a.getFontMetrics();
        float f1 = ((Paint.FontMetrics)localObject).bottom;
        float f2 = ((Paint.FontMetrics)localObject).top;
        float f3 = Math.abs(((Paint.FontMetrics)localObject).ascent);
        localObject = Bitmap.createBitmap(m, (int)(f1 - f2), Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawText(str, 0.0F, f3, this.a);
        if (this.h == 0) {
          localFontBitmapInfo.c = paramAnimStateTypeEvaluator.a("", this.d + a(), this.e, 0, 255, new LinearInterpolator());
        } else {
          localFontBitmapInfo.c = paramAnimStateTypeEvaluator.a("", this.d + this.e * k / paramCharSequence.length(), this.e, 0, 255, new LinearInterpolator());
        }
        localFontBitmapInfo.a = ((Bitmap)localObject);
        if (k == 0)
        {
          localFontBitmapInfo.b = paramInt;
          m = localFontBitmapInfo.a.getWidth();
        }
        else
        {
          localFontBitmapInfo.b = (paramInt + j);
          m = localFontBitmapInfo.a.getWidth() + j;
        }
        paramInt += m;
        this.g.add(localFontBitmapInfo);
      }
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.PerLineFontBitmapsInfo
 * JD-Core Version:    0.7.0.1
 */