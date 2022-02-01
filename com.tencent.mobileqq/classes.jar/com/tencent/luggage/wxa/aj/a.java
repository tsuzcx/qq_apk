package com.tencent.luggage.wxa.aj;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.tencent.luggage.wxa.ad.d;
import com.tencent.luggage.wxa.ad.f;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import java.nio.charset.Charset;
import java.util.List;

public final class a
  extends com.tencent.luggage.wxa.ad.b
{
  private static final int a = x.f("styl");
  private static final int b = x.f("tbox");
  private final m c = new m();
  private boolean d;
  private int e;
  private int f;
  private String g;
  private float h;
  private int i;
  
  public a(List<byte[]> paramList)
  {
    super("Tx3gDecoder");
    a(paramList);
  }
  
  private static String a(m paramm)
  {
    boolean bool;
    if (paramm.b() >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    int j = paramm.h();
    if (j == 0) {
      return "";
    }
    if (paramm.b() >= 2)
    {
      int k = paramm.f();
      if ((k == 65279) || (k == 65534)) {
        return paramm.a(j, Charset.forName("UTF-16"));
      }
    }
    return paramm.a(j, Charset.forName("UTF-8"));
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != paramInt2)
    {
      int k = paramInt5 | 0x21;
      int j = 1;
      if ((paramInt1 & 0x1) != 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      if ((paramInt1 & 0x2) != 0) {
        paramInt5 = 1;
      } else {
        paramInt5 = 0;
      }
      if (paramInt2 != 0)
      {
        if (paramInt5 != 0) {
          paramSpannableStringBuilder.setSpan(new StyleSpan(3), paramInt3, paramInt4, k);
        } else {
          paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramInt3, paramInt4, k);
        }
      }
      else if (paramInt5 != 0) {
        paramSpannableStringBuilder.setSpan(new StyleSpan(2), paramInt3, paramInt4, k);
      }
      if ((paramInt1 & 0x4) != 0) {
        paramInt1 = j;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt3, paramInt4, k);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt5 == 0)) {
        paramSpannableStringBuilder.setSpan(new StyleSpan(0), paramInt3, paramInt4, k);
      }
    }
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString1 != paramString2) {
      paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramString1), paramInt1, paramInt2, paramInt3 | 0x21);
    }
  }
  
  private void a(m paramm, SpannableStringBuilder paramSpannableStringBuilder)
  {
    boolean bool;
    if (paramm.b() >= 12) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    int j = paramm.h();
    int k = paramm.h();
    paramm.d(2);
    int m = paramm.g();
    paramm.d(1);
    int n = paramm.n();
    a(paramSpannableStringBuilder, m, this.e, j, k, 0);
    b(paramSpannableStringBuilder, n, this.f, j, k, 0);
  }
  
  private void a(List<byte[]> paramList)
  {
    String str = "sans-serif";
    boolean bool = false;
    if ((paramList != null) && (paramList.size() == 1) && ((((byte[])paramList.get(0)).length == 48) || (((byte[])paramList.get(0)).length == 53)))
    {
      byte[] arrayOfByte = (byte[])paramList.get(0);
      this.e = arrayOfByte[24];
      this.f = ((arrayOfByte[26] & 0xFF) << 24 | (arrayOfByte[27] & 0xFF) << 16 | (arrayOfByte[28] & 0xFF) << 8 | arrayOfByte[29] & 0xFF);
      paramList = str;
      if ("Serif".equals(new String(arrayOfByte, 43, arrayOfByte.length - 43))) {
        paramList = "serif";
      }
      this.g = paramList;
      this.i = (arrayOfByte[25] * 20);
      if ((arrayOfByte[0] & 0x20) != 0) {
        bool = true;
      }
      this.d = bool;
      if (this.d)
      {
        int j = arrayOfByte[10];
        this.h = ((arrayOfByte[11] & 0xFF | (j & 0xFF) << 8) / this.i);
        this.h = x.a(this.h, 0.0F, 0.95F);
        return;
      }
      this.h = 0.85F;
      return;
    }
    this.e = 0;
    this.f = -1;
    this.g = "sans-serif";
    this.d = false;
    this.h = 0.85F;
  }
  
  private static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new f("Unexpected subtitle format.");
  }
  
  private static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != paramInt2) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt1 >>> 8 | (paramInt1 & 0xFF) << 24), paramInt3, paramInt4, paramInt5 | 0x21);
    }
  }
  
  protected d a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.c.a(paramArrayOfByte, paramInt);
    paramArrayOfByte = a(this.c);
    if (paramArrayOfByte.isEmpty()) {
      return b.a;
    }
    paramArrayOfByte = new SpannableStringBuilder(paramArrayOfByte);
    a(paramArrayOfByte, this.e, 0, 0, paramArrayOfByte.length(), 16711680);
    b(paramArrayOfByte, this.f, -1, 0, paramArrayOfByte.length(), 16711680);
    a(paramArrayOfByte, this.g, "sans-serif", 0, paramArrayOfByte.length(), 16711680);
    float f2;
    for (float f1 = this.h; this.c.b() >= 8; f1 = f2)
    {
      int j = this.c.d();
      int k = this.c.n();
      int m = this.c.n();
      int n = a;
      boolean bool = true;
      paramBoolean = true;
      paramInt = 0;
      if (m == n)
      {
        if (this.c.b() < 2) {
          paramBoolean = false;
        }
        a(paramBoolean);
        m = this.c.h();
        for (;;)
        {
          f2 = f1;
          if (paramInt >= m) {
            break;
          }
          a(this.c, paramArrayOfByte);
          paramInt += 1;
        }
      }
      f2 = f1;
      if (m == b)
      {
        f2 = f1;
        if (this.d)
        {
          if (this.c.b() >= 2) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
          a(paramBoolean);
          f2 = x.a(this.c.h() / this.i, 0.0F, 0.95F);
        }
      }
      this.c.c(j + k);
    }
    return new b(new com.tencent.luggage.wxa.ad.a(paramArrayOfByte, null, f1, 0, 0, 1.4E-45F, -2147483648, 1.4E-45F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aj.a
 * JD-Core Version:    0.7.0.1
 */