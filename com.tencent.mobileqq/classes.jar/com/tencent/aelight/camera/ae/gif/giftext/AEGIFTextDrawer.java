package com.tencent.aelight.camera.ae.gif.giftext;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.font.AEFontManager;

public class AEGIFTextDrawer
{
  private TextPaint a = new TextPaint();
  private TextPaint b = new TextPaint();
  private int c = 0;
  private Rect d = new Rect();
  private String e = "";
  private Bitmap f;
  private Canvas g;
  private String h;
  private int i;
  private int j;
  
  public AEGIFTextDrawer(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.f = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.g = new Canvas(this.f);
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
  }
  
  private void a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    for (;;)
    {
      if ((localRect.width() + paramInt3 <= paramInt1 * 0.8F) && (localRect.height() + paramInt3 <= paramInt2 * 0.8F)) {
        return;
      }
      paramPaint.setTextSize(paramPaint.getTextSize() - 2.0F);
      paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
  }
  
  private void d()
  {
    Typeface localTypeface = AEFontManager.a().a(this.h);
    this.a.setTypeface(localTypeface);
    this.b.setTypeface(localTypeface);
  }
  
  public void a()
  {
    d();
    this.b.setTextSize(this.a.getTextSize());
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.c);
    this.a.setAntiAlias(true);
    this.b.setAntiAlias(true);
    Object localObject = this.a;
    String str = this.e;
    ((TextPaint)localObject).getTextBounds(str, 0, str.length(), this.d);
    float f1 = this.d.height();
    int k = this.e.indexOf("\r\n");
    float f2;
    if (k < 0)
    {
      if (TextUtils.isEmpty(this.e)) {
        return;
      }
      a(this.e, this.b, this.i, this.j, this.c);
      this.a.setTextSize(this.b.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.a.ascent()) - this.a.descent()) / 2.0F;
      localObject = this.g;
      str = this.e;
      a((Canvas)localObject, str, (this.i - this.b.measureText(str)) / 2.0F, (this.j - f1) / 2.0F + f2, this.b);
      localObject = this.g;
      str = this.e;
      a((Canvas)localObject, str, (this.i - this.a.measureText(str)) / 2.0F, (this.j - f1) / 2.0F + f2, this.a);
    }
    else
    {
      localObject = this.e.substring(0, k);
      str = this.e.substring(k + 2);
      a((String)localObject, this.b, this.i, this.j / 2, this.c);
      this.a.setTextSize(this.b.getTextSize());
      f1 /= 2.0F;
      f2 = (Math.abs(this.a.ascent()) - this.a.descent()) / 2.0F + f1;
      a(this.g, (String)localObject, (this.i - this.b.measureText((String)localObject)) / 2.0F, this.j * 0.25F - f1 + f2, this.b);
      a(this.g, (String)localObject, (this.i - this.a.measureText((String)localObject)) / 2.0F, this.j * 0.25F - f1 + f2, this.a);
      a(this.g, str, (this.i - this.b.measureText(str)) / 2.0F, this.j * 0.65F - f1 + f2, this.b);
      a(this.g, str, (this.i - this.a.measureText(str)) / 2.0F, this.j * 0.65F - f1 + f2, this.a);
    }
    this.g.drawBitmap(this.f, 0.0F, 0.0F, this.a);
  }
  
  public void a(float paramFloat)
  {
    this.a.setTextSize(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.e = paramString.trim();
    paramString = this.f;
    if (paramString != null) {
      paramString.eraseColor(0);
    }
  }
  
  public Bitmap b()
  {
    return this.f;
  }
  
  public void b(String paramString)
  {
    this.a.setColor(Color.parseColor(paramString));
  }
  
  public void c()
  {
    Bitmap localBitmap = this.f;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.f.recycle();
    }
  }
  
  public void c(String paramString)
  {
    this.b.setColor(Color.parseColor(paramString));
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextDrawer
 * JD-Core Version:    0.7.0.1
 */