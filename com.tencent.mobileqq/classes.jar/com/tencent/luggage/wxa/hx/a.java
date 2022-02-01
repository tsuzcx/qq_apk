package com.tencent.luggage.wxa.hx;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.RequiresApi;
import com.tencent.luggage.wxa.qz.o;

public class a
{
  private static b a = new b(3);
  private static final SpannableString b = new SpannableString("");
  private CharSequence c = null;
  private CharSequence d = null;
  private int e = 0;
  private int f = 0;
  private TextPaint g = null;
  private int h = 0;
  private Layout.Alignment i = Layout.Alignment.ALIGN_NORMAL;
  private int j = 51;
  private TextUtils.TruncateAt k = null;
  private int l = -1;
  private int m = 2147483647;
  private TextDirectionHeuristic n = null;
  private float o = 0.0F;
  private float p = 1.0F;
  private boolean q = false;
  private int r = -1;
  private int s = -1;
  private InputFilter.LengthFilter t = null;
  
  @RequiresApi(api=23)
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      return StaticLayout.Builder.obtain(paramCharSequence, this.e, this.f, this.g, this.h).setAlignment(this.i).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.o, this.p).setIncludePad(this.q).setEllipsize(this.k).setEllipsizedWidth(paramInt1).setBreakStrategy(paramInt2).setMaxLines(2147483647).build();
    }
    if (paramBoolean) {
      return new StaticLayout(paramCharSequence, this.e, this.f, this.g, this.h, this.i, this.p, this.o, this.q, this.k, paramInt1);
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      if (this.n == null) {
        this.n = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      }
      return com.tencent.luggage.wxa.hy.a.a(paramCharSequence, this.e, this.f, this.g, this.h, this.i, this.n, this.p, this.o, this.q, this.k, paramInt1, this.m);
    }
    return com.tencent.luggage.wxa.hy.a.a(paramCharSequence, this.e, this.f, this.g, this.h, this.i, this.p, this.o, this.q, this.k, paramInt1, this.m);
  }
  
  public static a a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    a locala = c();
    locala.d = paramCharSequence;
    locala.e = 0;
    locala.f = paramCharSequence.length();
    locala.g = paramTextPaint;
    locala.h = paramInt;
    return locala;
  }
  
  private static a c()
  {
    a locala2 = a.a();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    return locala1;
  }
  
  private void d()
  {
    if (this.i == Layout.Alignment.ALIGN_NORMAL)
    {
      int i1 = this.j & 0x800007;
      if (i1 != 1)
      {
        if (i1 != 3)
        {
          if (i1 != 5)
          {
            if (i1 == 8388611) {
              break label61;
            }
            if (i1 != 8388613)
            {
              this.i = Layout.Alignment.ALIGN_NORMAL;
              return;
            }
          }
          this.i = Layout.Alignment.ALIGN_OPPOSITE;
          return;
        }
        label61:
        this.i = Layout.Alignment.ALIGN_NORMAL;
        return;
      }
      this.i = Layout.Alignment.ALIGN_CENTER;
    }
  }
  
  public a a(int paramInt)
  {
    if (paramInt >= 0) {
      this.m = paramInt;
    }
    return this;
  }
  
  public a a(TextUtils.TruncateAt paramTruncateAt)
  {
    if (paramTruncateAt != null) {
      this.k = paramTruncateAt;
    }
    return this;
  }
  
  public a a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return this;
    }
    this.d = paramCharSequence;
    this.e = 0;
    this.f = paramCharSequence.length();
    return this;
  }
  
  public void a()
  {
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 0;
    this.g = new TextPaint();
    this.h = 0;
    this.i = Layout.Alignment.ALIGN_NORMAL;
    this.j = 51;
    this.k = null;
    this.l = 0;
    this.m = 2147483647;
    this.n = null;
    this.o = 0.0F;
    this.p = 1.0F;
    this.q = false;
    this.r = 0;
    this.t = null;
    this.s = -1;
  }
  
  public a b(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  @TargetApi(18)
  public c b()
  {
    int i1;
    int i2;
    if (this.k != null)
    {
      i1 = this.l;
      i2 = i1;
      if (i1 > 0) {}
    }
    else
    {
      i2 = this.h;
    }
    if ((this.k == null) && (this.m == 1)) {
      this.k = TextUtils.TruncateAt.END;
    }
    Object localObject1;
    Object localObject3;
    if (this.r > 0)
    {
      localObject1 = this.t;
      if (localObject1 != null)
      {
        localObject3 = this.d;
        localObject1 = ((InputFilter.LengthFilter)localObject1).filter((CharSequence)localObject3, 0, ((CharSequence)localObject3).length(), b, 0, 0);
        if (localObject1 != null)
        {
          this.d = ((CharSequence)localObject1);
          if (this.f > this.d.length()) {
            this.f = this.d.length();
          }
        }
      }
    }
    if (d.a)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("StaticLayoutWrapper build ");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(this.h);
      o.d("StaticTextView.StaticLayoutBuilder", ((StringBuilder)localObject1).toString());
    }
    d();
    this.g.setAntiAlias(true);
    if ((this.n == null) || ((com.tencent.luggage.wxa.hg.c.a(18)) && (this.n == TextDirectionHeuristics.FIRSTSTRONG_LTR)))
    {
      i1 = this.m;
      if ((i1 == 2147483647) || (i1 == -1)) {}
    }
    else
    {
      bool = false;
      break label257;
    }
    boolean bool = true;
    try
    {
      label257:
      localObject1 = a(this.d, bool, i2, this.s);
    }
    catch (Exception localException1)
    {
      o.d("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", new Object[] { localException1.getMessage() });
      localObject3 = null;
      i1 = 0;
    }
    Object localObject2 = localObject3;
    int i3;
    if (i1 < 3)
    {
      i3 = i1;
      localObject2 = localObject3;
    }
    for (;;)
    {
      try
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.d);
        i3 = i1;
        localObject2 = localObject3;
        MetricAffectingSpan[] arrayOfMetricAffectingSpan = (MetricAffectingSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MetricAffectingSpan.class);
        if (arrayOfMetricAffectingSpan == null) {
          break label653;
        }
        i3 = i1;
        localObject2 = localObject3;
        if (arrayOfMetricAffectingSpan.length <= 0) {
          break label653;
        }
        i3 = i1;
        localObject2 = localObject3;
        localSpannableStringBuilder.insert(localSpannableStringBuilder.getSpanStart(arrayOfMetricAffectingSpan[0]) - 1, " ");
        i1 += 1;
        i3 = i1;
        localObject2 = localObject3;
        this.d = localSpannableStringBuilder;
        i3 = i1;
        localObject2 = localObject3;
        localObject3 = a(this.d, bool, i2, this.s);
        i3 = i1;
        localObject2 = localObject3;
        o.d("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", new Object[] { Integer.valueOf(i1) });
        localObject2 = localObject3;
      }
      catch (Exception localException2)
      {
        o.d("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", new Object[] { localException2.getMessage(), Integer.valueOf(i3) });
        i1 = i3;
        localObject4 = localObject2;
      }
      break;
      Object localObject4 = localObject2;
      if (localObject2 == null)
      {
        this.d = this.d.toString();
        localObject4 = a(this.d, bool, i2, this.s);
      }
      localObject2 = new c((StaticLayout)localObject4);
      ((c)localObject2).b(this.c);
      ((c)localObject2).a(this.d);
      ((c)localObject2).b(this.r);
      ((c)localObject2).a(this.m);
      ((c)localObject2).a(this.i);
      ((c)localObject2).a(this.k);
      ((c)localObject2).a(this.g);
      ((c)localObject2).c(this.j);
      ((c)localObject2).d(this.s);
      a.a(this);
      return localObject2;
      label653:
      i1 = 100;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hx.a
 * JD-Core Version:    0.7.0.1
 */