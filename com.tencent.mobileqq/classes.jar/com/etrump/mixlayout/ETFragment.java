package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.api.IETFont;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontAdapter;

public class ETFragment
{
  private ETParagraph a;
  private String b;
  private CharacterStyle c;
  private int d = -1;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i = -1;
  private int j = 0;
  private int k = 0;
  
  public ETFragment(CharacterStyle paramCharacterStyle, int paramInt)
  {
    this.c = paramCharacterStyle;
    this.e = ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getSpanWidth(paramCharacterStyle);
    this.f = ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getSpanHeight(paramCharacterStyle);
    this.d = paramInt;
    this.h = 2;
  }
  
  public ETFragment(String paramString)
  {
    this.b = paramString;
    this.g = -1;
    this.h = 0;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).systemDrawSpan(paramCanvas, paramInt1, paramInt2, paramPaint, this.c, c());
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
    int m = (int)localPaint.getFontMetrics().ascent;
    paramCanvas.drawText(this.b, paramInt1, paramInt2 - m, localPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint();
    }
    localPaint.reset();
    localPaint.setColor(paramETFont.getColor());
    localPaint.setStrokeWidth(paramETFont.getSize() / 12);
    int m = this.e;
    float f1 = paramInt1;
    float f2 = paramInt2 + paramInt3 - 3;
    paramCanvas.drawLine(f1, f2, m + paramInt1, f2, localPaint);
  }
  
  private void b(ETEngine paramETEngine)
  {
    ETFont localETFont = this.a.g();
    if ((localETFont != null) && (paramETEngine != null))
    {
      Object localObject = this.b;
      if ((localObject != null) && (((String)localObject).length() != 0))
      {
        localObject = new Paint.FontMetrics();
        paramETEngine.native_getFontMetrics((Paint.FontMetrics)localObject, localETFont);
        this.i = ((int)Math.abs(((Paint.FontMetrics)localObject).descent));
        return;
      }
      this.i = 0;
      return;
    }
    this.i = 0;
  }
  
  public int a(ETEngine paramETEngine)
  {
    if (this.i < 0) {
      b(paramETEngine);
    }
    return this.i;
  }
  
  public String a()
  {
    if (this.h == 0) {
      return this.b;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (this.h == 0)
    {
      this.j = paramInt;
      this.k = (paramInt + this.b.length());
      return;
    }
    this.j = 0;
    this.k = 0;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCanvas != null) && (this.a != null))
    {
      Paint localPaint = new Paint();
      if (this.a.d() == true)
      {
        localPaint.setColor(this.a.e());
        localPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRect(new Rect(paramInt1, paramInt2, this.e + paramInt1, paramInt2 + paramInt3), localPaint);
      }
      if (this.c != null)
      {
        a(paramCanvas, paramInt1, paramInt2 + paramInt3 - this.f, localPaint);
        return;
      }
      ETFont localETFont = this.a.g();
      if (localETFont == null) {
        return;
      }
      if (this.a.f() == true) {
        a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2, paramInt3);
      }
      if ((this.b != null) && (this.h == 1)) {
        a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, int paramInt1, int paramInt2)
  {
    if ((paramETEngine != null) && (paramBitmap != null))
    {
      if (this.a == null) {
        return;
      }
      Object localObject = this.b;
      if (localObject != null)
      {
        if (((String)localObject).length() == 0) {
          return;
        }
        if (this.h == 0)
        {
          localObject = this.a.g();
          if (paramETDecoration == null)
          {
            paramETEngine.native_drawText(this.b, paramBitmap, paramInt1, paramInt2, (ETFont)localObject);
            return;
          }
          if (1 == paramETDecoration.getDecorationType()) {
            paramETDecoration.drawFrameText(this.j, this.k, paramBitmap, paramInt1, paramInt2, (IETFont)localObject);
          }
        }
      }
    }
  }
  
  public void a(ETParagraph paramETParagraph)
  {
    this.a = paramETParagraph;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public ETTextRange[] a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = this.h;
    int n = 0;
    if ((2 != m) && (1 != m))
    {
      Object localObject2 = this.a.g();
      Object localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(((ETFont)localObject2).getSize());
      int i1 = this.b.length();
      localObject1 = new int[i1];
      paramETEngine.native_getTextWidths(this.b, (ETFont)localObject2, (Paint)localObject3, (int[])localObject1);
      paramETEngine = new ETTextRange[i1];
      m = paramInt1;
      paramInt1 = n;
      while (paramInt1 < i1)
      {
        n = localObject1[paramInt1] + m;
        localObject2 = new Rect(m, paramInt2, n, paramInt2 + paramInt3);
        localObject3 = new ETTextRange();
        ((ETTextRange)localObject3).b = paramInt4;
        ((ETTextRange)localObject3).a = String.valueOf(this.b.charAt(paramInt1));
        ((ETTextRange)localObject3).c = ((Rect)localObject2);
        paramETEngine[paramInt1] = localObject3;
        paramInt1 += 1;
        m = n;
      }
      return paramETEngine;
    }
    paramETEngine = new Rect(paramInt1, paramInt2, this.e + paramInt1, paramInt3 + paramInt2);
    Object localObject1 = new ETTextRange();
    ((ETTextRange)localObject1).a = this.b;
    ((ETTextRange)localObject1).c = paramETEngine;
    ((ETTextRange)localObject1).b = paramInt4;
    return new ETTextRange[] { localObject1 };
  }
  
  public String b()
  {
    if (1 == this.h) {
      return this.b;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCanvas != null) && (this.a != null))
    {
      Paint localPaint = new Paint();
      if (this.c != null) {
        return;
      }
      ETFont localETFont = this.a.g();
      if (localETFont == null) {
        return;
      }
      if (this.a.f() == true) {
        a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  public int c()
  {
    ETFont localETFont = this.a.g();
    if (localETFont != null) {
      return localETFont.getSize();
    }
    return 16;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public void e(int paramInt)
  {
    this.h = paramInt;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public ETParagraph h()
  {
    return this.a;
  }
  
  public CharacterStyle i()
  {
    if (((IETFontAdapter)QRoute.api(IETFontAdapter.class)).isInstanceOfEmoticonSpan(this.c)) {
      return this.c;
    }
    return null;
  }
  
  public CharacterStyle j()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETFragment
 * JD-Core Version:    0.7.0.1
 */