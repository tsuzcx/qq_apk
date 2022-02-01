package com.tencent.luggage.wxa.ae;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;
import com.tencent.luggage.wxa.ad.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class a$a
{
  private final List<CharacterStyle> a = new ArrayList();
  private final List<a.a.a> b = new ArrayList();
  private final List<SpannableString> c = new LinkedList();
  private final SpannableStringBuilder d = new SpannableStringBuilder();
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public a$a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void a(char paramChar)
  {
    this.d.append(paramChar);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    this.e = 15;
    this.f = 0;
    this.g = 0;
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = -1;
  }
  
  public void a(CharacterStyle paramCharacterStyle)
  {
    this.a.add(paramCharacterStyle);
  }
  
  public void a(CharacterStyle paramCharacterStyle, int paramInt)
  {
    this.b.add(new a.a.a(paramCharacterStyle, this.d.length(), paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j = this.d.length();
      return;
    }
    if (this.j != -1)
    {
      this.d.setSpan(new UnderlineSpan(), this.j, this.d.length(), 33);
      this.j = -1;
    }
  }
  
  public boolean a()
  {
    return (this.a.isEmpty()) && (this.b.isEmpty()) && (this.c.isEmpty()) && (this.d.length() == 0);
  }
  
  public void b()
  {
    int k = this.d.length();
    if (k > 0) {
      this.d.delete(k - 1, k);
    }
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void d()
  {
    this.c.add(e());
    this.d.clear();
    this.a.clear();
    this.b.clear();
    this.j = -1;
    int k = Math.min(this.i, this.e);
    while (this.c.size() >= k) {
      this.c.remove(0);
    }
  }
  
  public SpannableString e()
  {
    int n = this.d.length();
    int i1 = 0;
    int m = 0;
    int k;
    for (;;)
    {
      k = i1;
      if (m >= this.a.size()) {
        break;
      }
      this.d.setSpan(this.a.get(m), 0, n, 33);
      m += 1;
    }
    while (k < this.b.size())
    {
      a.a.a locala = (a.a.a)this.b.get(k);
      if (k < this.b.size() - locala.c) {
        m = ((a.a.a)this.b.get(locala.c + k)).b;
      } else {
        m = n;
      }
      this.d.setSpan(locala.a, locala.b, m, 33);
      k += 1;
    }
    if (this.j != -1) {
      this.d.setSpan(new UnderlineSpan(), this.j, n, 33);
    }
    return new SpannableString(this.d);
  }
  
  public a f()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int k = 0;
    while (k < this.c.size())
    {
      localSpannableStringBuilder.append((CharSequence)this.c.get(k));
      localSpannableStringBuilder.append('\n');
      k += 1;
    }
    localSpannableStringBuilder.append(e());
    if (localSpannableStringBuilder.length() == 0) {
      return null;
    }
    k = this.f + this.g;
    int m = 32 - k - localSpannableStringBuilder.length();
    int n = k - m;
    float f1;
    if ((this.h == 2) && (Math.abs(n) < 3))
    {
      f1 = 0.5F;
      k = 1;
    }
    else if ((this.h == 2) && (n > 0))
    {
      f1 = (32 - m) / 32.0F * 0.8F + 0.1F;
      k = 2;
    }
    else
    {
      f1 = k / 32.0F * 0.8F + 0.1F;
      k = 0;
    }
    if (this.h != 1)
    {
      m = this.e;
      if (m <= 7)
      {
        n = 0;
        break label217;
      }
    }
    m = this.e - 15 - 2;
    n = 2;
    label217:
    return new a(localSpannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, m, 1, n, f1, k, 1.4E-45F);
  }
  
  public String toString()
  {
    return this.d.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ae.a.a
 * JD-Core Version:    0.7.0.1
 */