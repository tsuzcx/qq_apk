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
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  public AEGIFTextDrawer(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
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
  
  private void c()
  {
    Typeface localTypeface = AEFontManager.a().a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(localTypeface);
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(localTypeface);
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    c();
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_AndroidTextTextPaint.getTextSize());
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    Object localObject = this.jdField_a_of_type_AndroidTextTextPaint;
    String str = this.jdField_a_of_type_JavaLangString;
    ((TextPaint)localObject).getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    float f1 = this.jdField_a_of_type_AndroidGraphicsRect.height();
    int i = this.jdField_a_of_type_JavaLangString.indexOf("\r\n");
    float f2;
    if (i < 0)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidTextTextPaint, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_AndroidTextTextPaint.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.ascent()) - this.jdField_a_of_type_AndroidTextTextPaint.descent()) / 2.0F;
      localObject = this.jdField_a_of_type_AndroidGraphicsCanvas;
      str = this.jdField_a_of_type_JavaLangString;
      a((Canvas)localObject, str, (this.jdField_b_of_type_Int - this.jdField_b_of_type_AndroidTextTextPaint.measureText(str)) / 2.0F, (this.c - f1) / 2.0F + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      localObject = this.jdField_a_of_type_AndroidGraphicsCanvas;
      str = this.jdField_a_of_type_JavaLangString;
      a((Canvas)localObject, str, (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)) / 2.0F, (this.c - f1) / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaLangString.substring(0, i);
      str = this.jdField_a_of_type_JavaLangString.substring(i + 2);
      a((String)localObject, this.jdField_b_of_type_AndroidTextTextPaint, this.jdField_b_of_type_Int, this.c / 2, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_AndroidTextTextPaint.getTextSize());
      f1 /= 2.0F;
      f2 = (Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.ascent()) - this.jdField_a_of_type_AndroidTextTextPaint.descent()) / 2.0F + f1;
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, (String)localObject, (this.jdField_b_of_type_Int - this.jdField_b_of_type_AndroidTextTextPaint.measureText((String)localObject)) / 2.0F, this.c * 0.25F - f1 + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, (String)localObject, (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject)) / 2.0F, this.c * 0.25F - f1 + f2, this.jdField_a_of_type_AndroidTextTextPaint);
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str, (this.jdField_b_of_type_Int - this.jdField_b_of_type_AndroidTextTextPaint.measureText(str)) / 2.0F, this.c * 0.65F - f1 + f2, this.jdField_b_of_type_AndroidTextTextPaint);
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, str, (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidTextTextPaint.measureText(str)) / 2.0F, this.c * 0.65F - f1 + f2, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString.trim();
    paramString = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (paramString != null) {
      paramString.eraseColor(0);
    }
  }
  
  public void b()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor(paramString));
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(Color.parseColor(paramString));
  }
  
  public void d(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextDrawer
 * JD-Core Version:    0.7.0.1
 */