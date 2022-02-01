package com.tencent.aelight.camera.ae.gif.giftext;

import android.content.Context;
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
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.ae.font.AEFontManager;

public class AEGIFOutlineTextView
  extends View
{
  private TextPaint a = new TextPaint();
  private TextPaint b = new TextPaint();
  private int c = 0;
  private Rect d = new Rect();
  private String e = "";
  private Bitmap f;
  private Canvas g;
  private String h;
  private float i = 0.0F;
  private float j = 0.0F;
  private float k = 0.0F;
  private String l = "#00FFFFFF";
  private boolean m = false;
  private boolean n = true;
  
  public AEGIFOutlineTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEGIFOutlineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEGIFOutlineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    Typeface localTypeface = AEFontManager.a().a(this.h);
    this.a.setTypeface(localTypeface);
    this.b.setTypeface(localTypeface);
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
      if ((localRect.width() + paramInt3 <= paramInt1 * 1.0F) && (localRect.height() + paramInt3 <= paramInt2 * 1.0F)) {
        return;
      }
      paramPaint.setTextSize(paramPaint.getTextSize() - 2.0F);
      paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
  }
  
  public String getText()
  {
    return this.e;
  }
  
  public Bitmap getTextBitmap()
  {
    return this.f;
  }
  
  public float getTextSize()
  {
    return this.a.getTextSize();
  }
  
  public float getTextStrokeSize()
  {
    return this.a.getStrokeWidth();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a();
    this.b.setTextSize(this.a.getTextSize());
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.c);
    this.a.setAntiAlias(true);
    this.b.setAntiAlias(true);
    Object localObject = this.a;
    String str = this.e;
    ((TextPaint)localObject).getTextBounds(str, 0, str.length(), this.d);
    if (this.n) {
      this.a.setShadowLayer(this.i, this.j, this.k, Color.parseColor(this.l));
    } else {
      this.a.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    float f1 = this.d.height();
    int i1 = this.e.indexOf("\r\n");
    float f2;
    if (i1 < 0)
    {
      if (TextUtils.isEmpty(this.e)) {
        return;
      }
      a(this.e, this.b, getWidth(), getHeight(), this.c);
      this.a.setTextSize(this.b.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.a.ascent()) - this.a.descent()) / 2.0F;
      if (this.m) {
        a(this.g, this.e, (getWidth() - this.b.measureText(this.e)) / 2.0F, (getHeight() - f1) / 2.0F + f2, this.b);
      }
      a(this.g, this.e, (getWidth() - this.a.measureText(this.e)) / 2.0F, (getHeight() - f1) / 2.0F + f2, this.a);
    }
    else
    {
      localObject = this.e.substring(0, i1);
      str = this.e.substring(i1 + 2);
      a((String)localObject, this.b, getWidth(), getHeight() / 2, this.c);
      this.a.setTextSize(this.b.getTextSize());
      f1 /= 2.0F;
      f2 = f1 + (Math.abs(this.a.ascent()) - this.a.descent()) / 2.0F;
      if (this.m) {
        a(this.g, (String)localObject, (getWidth() - this.b.measureText((String)localObject)) / 2.0F, getHeight() * 0.35F - f1 + f2, this.b);
      }
      a(this.g, (String)localObject, (getWidth() - this.a.measureText((String)localObject)) / 2.0F, getHeight() * 0.35F - f1 + f2, this.a);
      if (this.m) {
        a(this.g, str, (getWidth() - this.b.measureText(str)) / 2.0F, getHeight() * 0.75F - f1 + f2, this.b);
      }
      a(this.g, str, (getWidth() - this.a.measureText(str)) / 2.0F, getHeight() * 0.75F - f1 + f2, this.a);
    }
    paramCanvas.drawBitmap(this.f, 0.0F, 0.0F, this.a);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      Bitmap localBitmap = this.f;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        this.f.recycle();
      }
      this.f = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      this.g = new Canvas(this.f);
    }
  }
  
  public void setFontId(String paramString)
  {
    this.h = paramString;
  }
  
  public void setOutlineColor(String paramString)
  {
    this.b.setColor(Color.parseColor(paramString));
  }
  
  public void setOutlineWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setShadow(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setShadowParam(float paramFloat1, float paramFloat2, float paramFloat3, String paramString)
  {
    this.i = paramFloat1;
    this.j = paramFloat2;
    this.k = paramFloat3;
    this.l = paramString;
  }
  
  public void setStroke(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.e = paramString.trim();
    paramString = this.f;
    if (paramString != null)
    {
      paramString.eraseColor(0);
      invalidate();
    }
  }
  
  public void setTextColor(String paramString)
  {
    this.a.setColor(Color.parseColor(paramString));
  }
  
  public void setTextSize(float paramFloat)
  {
    this.a.setTextSize(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView
 * JD-Core Version:    0.7.0.1
 */