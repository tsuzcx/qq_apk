package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;

public class ETFragment
{
  private int jdField_a_of_type_Int;
  private ETDecoration jdField_a_of_type_ComEtrumpMixlayoutETDecoration;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
  private ETParagraph jdField_a_of_type_ComEtrumpMixlayoutETParagraph;
  private QQText.EmoticonSpan jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  private int f;
  private int g;
  
  public ETFragment(QQText.EmoticonSpan paramEmoticonSpan)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan = paramEmoticonSpan;
    if (paramEmoticonSpan != null)
    {
      paramEmoticonSpan = paramEmoticonSpan.a().getBounds();
      this.jdField_a_of_type_Int = paramEmoticonSpan.width();
      this.b = paramEmoticonSpan.height();
    }
    this.d = 2;
  }
  
  public ETFragment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = -1;
    this.d = 0;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a() == null) || (this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0)) {
      return;
    }
    Paint.FontMetrics localFontMetrics = new Paint.FontMetrics();
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_getFontMetrics(localFontMetrics, this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a());
    this.e = ((int)Math.abs(localFontMetrics.ascent));
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramInt2 += this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan.a().getBounds().height();
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan.draw(paramCanvas, null, 0, 0, paramInt1, 0, paramInt2, paramInt2, paramPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2)
  {
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint();
    }
    localPaint.reset();
    localPaint.setColor(paramETFont.getColor());
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setTextSize(paramETFont.getSize());
    int i = (int)localPaint.getFontMetrics().ascent;
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2 - i, localPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramPaint == null) {
      paramPaint = new Paint();
    }
    for (;;)
    {
      paramPaint.reset();
      paramPaint.setColor(paramETFont.getColor());
      paramPaint.setStrokeWidth(paramETFont.getSize() / 24);
      paramInt2 = paramInt2 + paramInt3 - 2;
      paramInt3 = this.jdField_a_of_type_Int;
      paramCanvas.drawLine(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2, paramPaint);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ETParagraph a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph;
  }
  
  public QQText.EmoticonSpan a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan;
  }
  
  public String a(int paramInt)
  {
    if (this.d == 0)
    {
      this.f = paramInt;
      this.g = (this.jdField_a_of_type_JavaLangString.length() + paramInt);
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) || (paramBitmap == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph == null)) {}
    while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0) || (this.d != 0)) {
      return;
    }
    ETFont localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_drawText(this.jdField_a_of_type_JavaLangString, paramBitmap, paramInt1, paramInt2, localETFont);
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.a(this.f, this.g, paramBitmap, paramInt1, paramInt2, this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a());
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint;
    if ((paramCanvas != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph != null))
    {
      localPaint = new Paint();
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a() == true)
      {
        localPaint.setColor(this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.c());
        localPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRect(new Rect(paramInt1, paramInt2, this.jdField_a_of_type_Int + paramInt1, paramInt2 + paramInt3), localPaint);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan == null) {
        break label101;
      }
      a(paramCanvas, paramInt1, paramInt2 + paramInt3 - this.b, localPaint);
    }
    label101:
    ETFont localETFont;
    do
    {
      do
      {
        return;
        localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
      } while (localETFont == null);
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.b() == true) {
        a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2, paramInt3);
      }
    } while ((this.jdField_a_of_type_JavaLangString == null) || (this.d != 1));
    a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2);
  }
  
  public void a(ETDecoration paramETDecoration)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = paramETDecoration;
  }
  
  public void a(ETParagraph paramETParagraph)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph = paramETParagraph;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int e()
  {
    if (this.e < 0) {
      a();
    }
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETFragment
 * JD-Core Version:    0.7.0.1
 */