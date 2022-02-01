package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.style.CharacterStyle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontAdapter;

public class ETFragment
{
  private int jdField_a_of_type_Int = -1;
  private CharacterStyle jdField_a_of_type_AndroidTextStyleCharacterStyle;
  private ETParagraph jdField_a_of_type_ComEtrumpMixlayoutETParagraph;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f = -1;
  private int g = 0;
  private int h = 0;
  
  public ETFragment(CharacterStyle paramCharacterStyle, int paramInt)
  {
    this.jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
    this.b = ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getSpanWidth(paramCharacterStyle);
    this.c = ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getSpanHeight(paramCharacterStyle);
    this.jdField_a_of_type_Int = paramInt;
    this.e = 2;
  }
  
  public ETFragment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = -1;
    this.e = 0;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).systemDrawSpan(paramCanvas, paramInt1, paramInt2, paramPaint, this.jdField_a_of_type_AndroidTextStyleCharacterStyle, a());
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
      paramPaint.setStrokeWidth(paramETFont.getSize() / 12);
      paramInt2 = paramInt2 + paramInt3 - 3;
      paramInt3 = this.b;
      paramCanvas.drawLine(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2, paramPaint);
      return;
    }
  }
  
  private void a(ETEngine paramETEngine)
  {
    ETFont localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
    if ((localETFont == null) || (paramETEngine == null))
    {
      this.f = 0;
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0))
    {
      this.f = 0;
      return;
    }
    Paint.FontMetrics localFontMetrics = new Paint.FontMetrics();
    paramETEngine.native_getFontMetrics(localFontMetrics, localETFont);
    this.f = ((int)Math.abs(localFontMetrics.descent));
  }
  
  public int a()
  {
    ETFont localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
    if (localETFont != null) {
      return localETFont.getSize();
    }
    return 16;
  }
  
  public int a(ETEngine paramETEngine)
  {
    if (this.f < 0) {
      a(paramETEngine);
    }
    return this.f;
  }
  
  public CharacterStyle a()
  {
    if (((IETFontAdapter)QRoute.api(IETFontAdapter.class)).isInstanceOfEmoticonSpan(this.jdField_a_of_type_AndroidTextStyleCharacterStyle)) {
      return this.jdField_a_of_type_AndroidTextStyleCharacterStyle;
    }
    return null;
  }
  
  public ETParagraph a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph;
  }
  
  public String a()
  {
    if (this.e == 0) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (this.e == 0)
    {
      this.g = paramInt;
      this.h = (this.jdField_a_of_type_JavaLangString.length() + paramInt);
      return;
    }
    this.g = 0;
    this.h = 0;
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
        paramCanvas.drawRect(new Rect(paramInt1, paramInt2, this.b + paramInt1, paramInt2 + paramInt3), localPaint);
      }
      if (this.jdField_a_of_type_AndroidTextStyleCharacterStyle == null) {
        break label101;
      }
      a(paramCanvas, paramInt1, paramInt2 + paramInt3 - this.c, localPaint);
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
    } while ((this.jdField_a_of_type_JavaLangString == null) || (this.e != 1));
    a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2);
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, int paramInt1, int paramInt2)
  {
    if ((paramETEngine == null) || (paramBitmap == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph == null)) {}
    ETFont localETFont;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0) || (this.e != 0));
      localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
      if (paramETDecoration == null)
      {
        paramETEngine.native_drawText(this.jdField_a_of_type_JavaLangString, paramBitmap, paramInt1, paramInt2, localETFont);
        return;
      }
    } while (1 != paramETDecoration.getDecorationType());
    paramETDecoration.drawFrameText(this.g, this.h, paramBitmap, paramInt1, paramInt2, localETFont);
  }
  
  public void a(ETParagraph paramETParagraph)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph = paramETParagraph;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public ETTextRange[] a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    if ((2 == this.e) || (1 == this.e))
    {
      paramETEngine = new Rect(paramInt1, paramInt2, this.b + paramInt1, paramInt2 + paramInt3);
      localObject1 = new ETTextRange();
      ((ETTextRange)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((ETTextRange)localObject1).jdField_a_of_type_AndroidGraphicsRect = paramETEngine;
      ((ETTextRange)localObject1).jdField_a_of_type_Int = paramInt4;
      paramETEngine = new ETTextRange[1];
      paramETEngine[0] = localObject1;
      return paramETEngine;
    }
    Object localObject1 = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
    Object localObject2 = new Paint();
    ((Paint)localObject2).setTextSize(((ETFont)localObject1).getSize());
    int k = this.jdField_a_of_type_JavaLangString.length();
    int[] arrayOfInt = new int[k];
    paramETEngine.native_getTextWidths(this.jdField_a_of_type_JavaLangString, (ETFont)localObject1, (Paint)localObject2, arrayOfInt);
    localObject1 = new ETTextRange[k];
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      paramETEngine = (ETEngine)localObject1;
      if (paramInt1 >= k) {
        break;
      }
      j = arrayOfInt[paramInt1] + i;
      paramETEngine = new Rect(i, paramInt2, j, paramInt2 + paramInt3);
      localObject2 = new ETTextRange();
      ((ETTextRange)localObject2).jdField_a_of_type_Int = paramInt4;
      ((ETTextRange)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_JavaLangString.charAt(paramInt1));
      ((ETTextRange)localObject2).jdField_a_of_type_AndroidGraphicsRect = paramETEngine;
      localObject1[paramInt1] = localObject2;
      paramInt1 += 1;
      i = j;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CharacterStyle b()
  {
    return this.jdField_a_of_type_AndroidTextStyleCharacterStyle;
  }
  
  public String b()
  {
    if (1 == this.e) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint;
    if ((paramCanvas != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph != null))
    {
      localPaint = new Paint();
      if (this.jdField_a_of_type_AndroidTextStyleCharacterStyle == null) {
        break label28;
      }
    }
    label28:
    ETFont localETFont;
    do
    {
      return;
      localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.a();
    } while ((localETFont == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETParagraph.b() != true));
    a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2, paramInt3);
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETFragment
 * JD-Core Version:    0.7.0.1
 */