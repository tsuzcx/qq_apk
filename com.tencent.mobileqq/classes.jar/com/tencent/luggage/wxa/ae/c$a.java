package com.tencent.luggage.wxa.ae;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.luggage.wxa.ao.a;
import java.util.LinkedList;
import java.util.List;

final class c$a
{
  public static final int a = a(2, 2, 2, 0);
  public static final int b = a(0, 0, 0, 0);
  public static final int c = a(0, 0, 0, 3);
  private static final int[] d = { 0, 0, 0, 0, 0, 2, 0 };
  private static final int[] e = { 0, 0, 0, 0, 0, 0, 2 };
  private static final int[] f = { 3, 3, 3, 3, 3, 3, 1 };
  private static final boolean[] g = { 0, 0, 0, 1, 1, 1, 0 };
  private static final int[] h;
  private static final int[] i;
  private static final int[] j;
  private static final int[] k;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private final List<SpannableString> l = new LinkedList();
  private final SpannableStringBuilder m = new SpannableStringBuilder();
  private boolean n;
  private boolean o;
  private int p;
  private boolean q;
  private int r;
  private int s;
  private int t;
  private int u;
  private boolean v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    int i1 = b;
    int i2 = c;
    h = new int[] { i1, i2, i1, i1, i2, i1, i1 };
    i = new int[] { 0, 1, 2, 3, 4, 3, 4 };
    j = new int[] { 0, 0, 0, 0, 0, 3, 3 };
    k = new int[] { i1, i1, i1, i1, i1, i2, i2 };
  }
  
  public c$a()
  {
    b();
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    a.a(paramInt1, 0, 4);
    a.a(paramInt2, 0, 4);
    a.a(paramInt3, 0, 4);
    a.a(paramInt4, 0, 4);
    if ((paramInt4 != 0) && (paramInt4 != 1))
    {
      if (paramInt4 == 2) {
        break label62;
      }
      if (paramInt4 == 3) {}
    }
    else
    {
      paramInt4 = 255;
      break label65;
    }
    paramInt4 = 0;
    break label65;
    label62:
    paramInt4 = 127;
    label65:
    if (paramInt1 > 1) {
      paramInt1 = 255;
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 > 1) {
      paramInt2 = 255;
    } else {
      paramInt2 = 0;
    }
    if (paramInt3 > 1) {
      i1 = 255;
    }
    return Color.argb(paramInt4, paramInt1, paramInt2, i1);
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3, 0);
  }
  
  public void a(char paramChar)
  {
    if (paramChar == '\n')
    {
      this.l.add(g());
      this.m.clear();
      if (this.A != -1) {
        this.A = 0;
      }
      if (this.B != -1) {
        this.B = 0;
      }
      if (this.C != -1) {
        this.C = 0;
      }
      if (this.E != -1) {
        this.E = 0;
      }
      while (((this.v) && (this.l.size() >= this.u)) || (this.l.size() >= 15)) {
        this.l.remove(0);
      }
    }
    this.m.append(paramChar);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.G != paramInt1) {
      a('\n');
    }
    this.G = paramInt1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.C != -1)
    {
      paramInt3 = this.D;
      if (paramInt3 != paramInt1) {
        this.m.setSpan(new ForegroundColorSpan(paramInt3), this.C, this.m.length(), 33);
      }
    }
    if (paramInt1 != a)
    {
      this.C = this.m.length();
      this.D = paramInt1;
    }
    if (this.E != -1)
    {
      paramInt1 = this.F;
      if (paramInt1 != paramInt2) {
        this.m.setSpan(new BackgroundColorSpan(paramInt1), this.E, this.m.length(), 33);
      }
    }
    if (paramInt2 != b)
    {
      this.E = this.m.length();
      this.F = paramInt2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    if (this.A != -1)
    {
      if (!paramBoolean1)
      {
        this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
        this.A = -1;
      }
    }
    else if (paramBoolean1) {
      this.A = this.m.length();
    }
    if (this.B != -1)
    {
      if (!paramBoolean2)
      {
        this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
        this.B = -1;
      }
    }
    else if (paramBoolean2) {
      this.B = this.m.length();
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.z = paramInt1;
    this.w = paramInt6;
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, boolean paramBoolean4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.n = true;
    this.o = paramBoolean1;
    this.v = paramBoolean2;
    this.p = paramInt1;
    this.q = paramBoolean4;
    this.r = paramInt2;
    this.s = paramInt3;
    this.t = paramInt6;
    paramInt1 = this.u;
    paramInt2 = paramInt4 + 1;
    if (paramInt1 != paramInt2)
    {
      this.u = paramInt2;
      while (((paramBoolean2) && (this.l.size() >= this.u)) || (this.l.size() >= 15)) {
        this.l.remove(0);
      }
    }
    if ((paramInt7 != 0) && (this.x != paramInt7))
    {
      this.x = paramInt7;
      paramInt1 = paramInt7 - 1;
      a(h[paramInt1], c, g[paramInt1], 0, e[paramInt1], f[paramInt1], d[paramInt1]);
    }
    if ((paramInt8 != 0) && (this.y != paramInt8))
    {
      this.y = paramInt8;
      paramInt1 = paramInt8 - 1;
      a(0, 1, 1, false, false, j[paramInt1], i[paramInt1]);
      a(a, k[paramInt1], b);
    }
  }
  
  public boolean a()
  {
    return (!d()) || ((this.l.isEmpty()) && (this.m.length() == 0));
  }
  
  public void b()
  {
    c();
    this.n = false;
    this.o = false;
    this.p = 4;
    this.q = false;
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.u = 15;
    this.v = true;
    this.w = 0;
    this.x = 0;
    this.y = 0;
    int i1 = b;
    this.z = i1;
    this.D = a;
    this.F = i1;
  }
  
  public void c()
  {
    this.l.clear();
    this.m.clear();
    this.A = -1;
    this.B = -1;
    this.C = -1;
    this.E = -1;
    this.G = 0;
  }
  
  public boolean d()
  {
    return this.n;
  }
  
  public boolean e()
  {
    return this.o;
  }
  
  public void f()
  {
    int i1 = this.m.length();
    if (i1 > 0) {
      this.m.delete(i1 - 1, i1);
    }
  }
  
  public SpannableString g()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.m);
    int i1 = localSpannableStringBuilder.length();
    if (i1 > 0)
    {
      if (this.A != -1) {
        localSpannableStringBuilder.setSpan(new StyleSpan(2), this.A, i1, 33);
      }
      if (this.B != -1) {
        localSpannableStringBuilder.setSpan(new UnderlineSpan(), this.B, i1, 33);
      }
      if (this.C != -1) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, i1, 33);
      }
      if (this.E != -1) {
        localSpannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, i1, 33);
      }
    }
    return new SpannableString(localSpannableStringBuilder);
  }
  
  public b h()
  {
    if (a()) {
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    boolean bool = false;
    int i1 = 0;
    while (i1 < this.l.size())
    {
      localSpannableStringBuilder.append((CharSequence)this.l.get(i1));
      localSpannableStringBuilder.append('\n');
      i1 += 1;
    }
    localSpannableStringBuilder.append(g());
    i1 = this.w;
    if (i1 != 0) {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unexpected justification value: ");
            ((StringBuilder)localObject).append(this.w);
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = Layout.Alignment.ALIGN_CENTER;
          break label168;
        }
      }
      else
      {
        localObject = Layout.Alignment.ALIGN_OPPOSITE;
        break label168;
      }
    }
    Object localObject = Layout.Alignment.ALIGN_NORMAL;
    label168:
    float f1;
    float f2;
    if (this.q)
    {
      f1 = this.s / 99.0F;
      f2 = this.r / 99.0F;
    }
    else
    {
      f1 = this.s / 209.0F;
      f2 = this.r / 74.0F;
    }
    i1 = this.t;
    if (i1 % 3 == 0) {
      i1 = 0;
    } else if (i1 % 3 == 1) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    int i2 = this.t;
    if (i2 / 3 == 0) {
      i2 = 0;
    } else if (i2 / 3 == 1) {
      i2 = 1;
    } else {
      i2 = 2;
    }
    if (this.z != b) {
      bool = true;
    }
    return new b(localSpannableStringBuilder, (Layout.Alignment)localObject, f2 * 0.9F + 0.05F, 0, i1, f1 * 0.9F + 0.05F, i2, 1.4E-45F, bool, this.z, this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ae.c.a
 * JD-Core Version:    0.7.0.1
 */