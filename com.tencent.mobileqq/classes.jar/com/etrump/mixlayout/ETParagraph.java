package com.etrump.mixlayout;

import android.text.style.CharacterStyle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontAdapter;
import java.util.ArrayList;

public class ETParagraph
{
  public boolean a;
  private String b;
  private CharacterStyle c;
  private int d;
  private boolean e;
  private int f;
  private int g;
  private int h;
  private boolean i;
  private boolean j;
  private ETFont k;
  private ArrayList<ETFragment> l = new ArrayList(16);
  private int m;
  private int n;
  private int o;
  
  public ETParagraph(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.c = paramCharacterStyle;
    this.f = paramInt2;
    this.g = paramInt3;
    this.e = paramBoolean;
    this.d = paramInt1;
  }
  
  public ETParagraph(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    this.b = paramString;
    this.f = paramInt1;
    this.g = paramInt2;
    this.k = paramETFont;
    this.j = paramBoolean;
  }
  
  private int a(CharacterStyle paramCharacterStyle)
  {
    return ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getSpanWidth(paramCharacterStyle);
  }
  
  private int a(ETEngine paramETEngine, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return 0;
      }
      long l1 = paramETEngine.native_textLayoutLock(paramString, this.n, 1073741823, this.o, 0, this.k);
      int i2 = paramETEngine.native_textLayoutLineTotal(l1);
      if (i2 < 1)
      {
        paramETEngine.native_textLayoutUnlock(l1);
        return 0;
      }
      if (paramETEngine.native_textLayoutHasPreLine(l1) == true)
      {
        localObject = new ETFragment("");
        ((ETFragment)localObject).d(this.m);
        ((ETFragment)localObject).e(0);
        ((ETFragment)localObject).a(this);
        this.l.add(localObject);
        this.o = 0;
        this.m += 1;
      }
      Object localObject = new ETFragment[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        localObject[i1] = new ETFragment("");
        i1 += 1;
      }
      i1 = 0;
      while (i1 < i2)
      {
        int i3 = paramETEngine.native_textLayoutLineRangeFrom(l1, i1);
        int i4 = paramETEngine.native_textLayoutLineRangeTo(l1, i1);
        int i5 = paramETEngine.native_textLayoutLineWidth(l1, i1);
        int i6 = paramETEngine.native_textLayoutLineHeight(l1, i1);
        localObject[i1].a(paramString.substring(i3, i4));
        localObject[i1].b(i5);
        localObject[i1].c(i6);
        localObject[i1].d(this.m + i1);
        localObject[i1].e(0);
        localObject[i1].a(this);
        this.l.add(localObject[i1]);
        i1 += 1;
      }
      if (paramString.substring(paramString.length() - 1).equals("\n"))
      {
        paramString = new ETFragment("");
        paramString.d(this.m + i2);
        paramString.e(0);
        paramString.a(this);
        this.l.add(paramString);
        this.o = 0;
        i1 = i2 + 1;
      }
      else if (i2 == 1)
      {
        this.o += localObject[0].e();
        i1 = i2;
      }
      else
      {
        this.o = localObject[(i2 - 1)].e();
        i1 = i2;
      }
      this.m += i1 - 1;
      paramETEngine.native_textLayoutUnlock(l1);
      return i1;
    }
    return 0;
  }
  
  private void a(CharacterStyle paramCharacterStyle, int paramInt)
  {
    if (paramCharacterStyle == null) {
      return;
    }
    int i1 = a(paramCharacterStyle);
    if (this.e == true)
    {
      if (this.o != 0)
      {
        this.o = i1;
        this.m += 1;
      }
    }
    else
    {
      int i2 = this.o;
      if (i2 == 0)
      {
        this.o = i1;
      }
      else if (this.n < i1 + i2)
      {
        this.o = i1;
        this.m += 1;
      }
      else
      {
        this.o = (i2 + i1);
      }
    }
    paramCharacterStyle = new ETFragment(paramCharacterStyle, paramInt);
    paramCharacterStyle.d(this.m);
    paramCharacterStyle.a(this);
    this.l.add(paramCharacterStyle);
    if ((this.e == true) && (this.o != 0))
    {
      this.o = 0;
      this.m += 1;
    }
  }
  
  private void a(ETEngine paramETEngine)
  {
    int i5 = this.b.length();
    int i3 = -1;
    int i1 = 0;
    while (i1 < i5)
    {
      if (Character.isHighSurrogate(this.b.charAt(i1)))
      {
        i2 = i1 + 1;
        if ((i2 < i5) && (Character.isLowSurrogate(this.b.charAt(i2))))
        {
          a(paramETEngine, this.b.substring(i3 + 1, i1));
          b(paramETEngine, this.b.substring(i1, i1 + 2));
          i4 = i2;
          break label137;
        }
      }
      int i2 = i3;
      int i4 = i1;
      if (i1 + 1 == i5)
      {
        a(paramETEngine, this.b.substring(i3 + 1, i5));
        i2 = i5;
        i4 = i1;
      }
      label137:
      i1 = i4 + 1;
      i3 = i2;
    }
  }
  
  private void b(ETEngine paramETEngine)
  {
    int i5 = this.b.length();
    int i3 = -1;
    int i1 = 0;
    while (i1 < i5)
    {
      char c1 = this.b.charAt(i1);
      int i2;
      int i4;
      if (Character.isHighSurrogate(c1))
      {
        i2 = i1 + 1;
        if ((i2 < i5) && (Character.isLowSurrogate(this.b.charAt(i2))))
        {
          a(paramETEngine, this.b.substring(i3 + 1, i1));
          b(paramETEngine, this.b.substring(i1, i1 + 2));
          i4 = i2;
          break label193;
        }
      }
      if (!paramETEngine.native_isPaintableChar(c1, this.k))
      {
        a(paramETEngine, this.b.substring(i3 + 1, i1));
        b(paramETEngine, String.valueOf(c1));
        i2 = i1;
        i4 = i1;
      }
      else
      {
        i2 = i3;
        i4 = i1;
        if (i1 + 1 == i5)
        {
          a(paramETEngine, this.b.substring(i3 + 1, i5));
          i2 = i5;
          i4 = i1;
        }
      }
      label193:
      i1 = i4 + 1;
      i3 = i2;
    }
  }
  
  private void b(ETEngine paramETEngine, String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i1 = paramETEngine.sysMeasureText(paramString, this.k.getSize(), 0, 0, 0, 0, 0, 0, 0);
    int i2 = paramETEngine.sysFontHeight(paramString, this.k.getSize(), 0, 0, 0, 0, 0, 0, 0);
    int i3 = this.n;
    int i4 = this.o;
    if (i3 < i1 + i4)
    {
      this.o = i1;
      this.m += 1;
    }
    else
    {
      this.o = (i4 + i1);
    }
    paramETEngine = new ETFragment(paramString);
    paramETEngine.b(i1);
    paramETEngine.c(i2);
    paramETEngine.d(this.m);
    paramETEngine.e(1);
    paramETEngine.a(this);
    this.l.add(paramETEngine);
  }
  
  public int a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3)
  {
    this.l.clear();
    this.m = paramInt3;
    this.n = paramInt1;
    this.o = paramInt2;
    CharacterStyle localCharacterStyle = this.c;
    if (localCharacterStyle != null)
    {
      a(localCharacterStyle, this.d);
      return this.m;
    }
    if ((paramETEngine != null) && (this.b != null))
    {
      if (ETEngine.getInstance().isEnableCallbackDrawing()) {
        a(paramETEngine);
      } else {
        b(paramETEngine);
      }
      return this.m;
    }
    return this.m;
  }
  
  public ArrayList<ETFragment> a()
  {
    return this.l;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  protected int b()
  {
    return this.o;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  public int e()
  {
    return this.h;
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  public ETFont g()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETParagraph
 * JD-Core Version:    0.7.0.1
 */