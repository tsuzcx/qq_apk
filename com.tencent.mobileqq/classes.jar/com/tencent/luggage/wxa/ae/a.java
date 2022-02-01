package com.tencent.luggage.wxa.ae;

import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.luggage.wxa.ad.h;
import com.tencent.luggage.wxa.ao.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends d
{
  private static final int[] a = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] b = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] c = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] d = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] e = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] f = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] g = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final m h = new m();
  private final int i;
  private final int j;
  private final LinkedList<a.a> k = new LinkedList();
  private a.a l = new a.a(0, 4);
  private List<com.tencent.luggage.wxa.ad.a> m;
  private List<com.tencent.luggage.wxa.ad.a> n;
  private int o;
  private int p;
  private boolean q;
  private byte r;
  private byte s;
  
  public a(String paramString, int paramInt)
  {
    int i1;
    if ("application/x-mp4-cea-608".equals(paramString)) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    this.i = i1;
    if ((paramInt != 3) && (paramInt != 4)) {
      this.j = 1;
    } else {
      this.j = 2;
    }
    a(0);
    j();
  }
  
  private void a(byte paramByte)
  {
    boolean bool;
    if ((paramByte & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.l.a(bool);
    paramByte = paramByte >> 1 & 0xF;
    if (paramByte == 7)
    {
      this.l.a(new StyleSpan(2), 2);
      this.l.a(new ForegroundColorSpan(-1), 1);
      return;
    }
    this.l.a(new ForegroundColorSpan(c[paramByte]), 1);
  }
  
  private void a(int paramInt)
  {
    int i1 = this.o;
    if (i1 == paramInt) {
      return;
    }
    this.o = paramInt;
    j();
    if ((i1 == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.m = null;
    }
  }
  
  private boolean a(byte paramByte1, byte paramByte2)
  {
    boolean bool = g(paramByte1);
    if (bool)
    {
      if ((this.q) && (this.r == paramByte1) && (this.s == paramByte2))
      {
        this.q = false;
        return true;
      }
      this.q = true;
      this.r = paramByte1;
      this.s = paramByte2;
    }
    if (c(paramByte1, paramByte2))
    {
      a(paramByte2);
      return bool;
    }
    if (d(paramByte1, paramByte2))
    {
      b(paramByte1, paramByte2);
      return bool;
    }
    if (e(paramByte1, paramByte2))
    {
      this.l.c(paramByte2 - 32);
      return bool;
    }
    if (f(paramByte1, paramByte2)) {
      b(paramByte2);
    }
    return bool;
  }
  
  private void b(byte paramByte)
  {
    if (paramByte != 32)
    {
      if (paramByte != 41)
      {
        switch (paramByte)
        {
        default: 
          int i1 = this.o;
          if (i1 == 0) {
            return;
          }
          if (paramByte != 33) {
            switch (paramByte)
            {
            default: 
              return;
            case 47: 
              this.m = i();
              j();
              return;
            case 46: 
              j();
              return;
            case 45: 
              if ((i1 != 1) || (this.l.a())) {
                break;
              }
              this.l.d();
              return;
            case 44: 
              this.m = null;
              if ((i1 != 1) && (i1 != 3)) {
                break;
              }
              j();
              return;
            }
          } else {
            this.l.b();
          }
          return;
        case 39: 
          this.p = 4;
          a(1);
          return;
        case 38: 
          this.p = 3;
          a(1);
          return;
        }
        this.p = 2;
        a(1);
        return;
      }
      a(3);
      return;
    }
    a(2);
  }
  
  private void b(byte paramByte1, byte paramByte2)
  {
    int i2 = a[(paramByte1 & 0x7)];
    if ((paramByte2 & 0x20) != 0) {
      paramByte1 = 1;
    } else {
      paramByte1 = 0;
    }
    int i1 = i2;
    if (paramByte1 != 0) {
      i1 = i2 + 1;
    }
    if (i1 != this.l.c())
    {
      if ((this.o != 1) && (!this.l.a()))
      {
        this.l = new a.a(this.o, this.p);
        this.k.add(this.l);
      }
      this.l.a(i1);
    }
    if ((paramByte2 & 0x1) == 1) {
      this.l.a(new UnderlineSpan());
    }
    paramByte1 = paramByte2 >> 1 & 0xF;
    if (paramByte1 <= 7)
    {
      if (paramByte1 == 7)
      {
        this.l.a(new StyleSpan(2));
        this.l.a(new ForegroundColorSpan(-1));
        return;
      }
      this.l.a(new ForegroundColorSpan(c[paramByte1]));
      return;
    }
    this.l.b(b[(paramByte1 & 0x7)]);
  }
  
  private static char c(byte paramByte)
  {
    return (char)d[((paramByte & 0x7F) - 32)];
  }
  
  private static boolean c(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 17) && ((paramByte2 & 0xF0) == 32);
  }
  
  private static char d(byte paramByte)
  {
    return (char)e[(paramByte & 0xF)];
  }
  
  private static boolean d(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF0) == 16) && ((paramByte2 & 0xC0) == 64);
  }
  
  private static char e(byte paramByte)
  {
    return (char)f[(paramByte & 0x1F)];
  }
  
  private static boolean e(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 23) && (paramByte2 >= 33) && (paramByte2 <= 35);
  }
  
  private static char f(byte paramByte)
  {
    return (char)g[(paramByte & 0x1F)];
  }
  
  private static boolean f(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 20) && ((paramByte2 & 0xF0) == 32);
  }
  
  private static boolean g(byte paramByte)
  {
    return (paramByte & 0xF0) == 16;
  }
  
  private List<com.tencent.luggage.wxa.ad.a> i()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.k.size())
    {
      com.tencent.luggage.wxa.ad.a locala = ((a.a)this.k.get(i1)).f();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  private void j()
  {
    this.l.a(this.o, this.p);
    this.k.clear();
    this.k.add(this.l);
  }
  
  protected void a(h paramh)
  {
    this.h.a(paramh.b.array(), paramh.b.limit());
    int i3 = 0;
    boolean bool2;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      int i4;
      int i1;
      int i2;
      do
      {
        i4 = this.h.b();
        int i5 = this.i;
        if (i4 < i5) {
          break;
        }
        if (i5 == 2) {
          i4 = -4;
        } else {
          i4 = (byte)this.h.g();
        }
        i1 = (byte)(this.h.g() & 0x7F);
        i2 = (byte)(this.h.g() & 0x7F);
      } while (((i4 & 0x6) != 4) || ((this.j == 1) && ((i4 & 0x1) != 0)) || ((this.j == 2) && ((i4 & 0x1) != 1)) || ((i1 == 0) && (i2 == 0)));
      if (((i1 & 0xF7) == 17) && ((i2 & 0xF0) == 48))
      {
        this.l.a(d(i2));
        bool2 = bool1;
      }
      else if (((i1 & 0xF6) == 18) && ((i2 & 0xE0) == 32))
      {
        this.l.b();
        if ((i1 & 0x1) == 0)
        {
          this.l.a(e(i2));
          bool2 = bool1;
        }
        else
        {
          this.l.a(f(i2));
          bool2 = bool1;
        }
      }
      else if ((i1 & 0xE0) == 0)
      {
        bool2 = a(i1, i2);
      }
      else
      {
        this.l.a(c(i1));
        bool2 = bool1;
        if ((i2 & 0xE0) != 0)
        {
          this.l.a(c(i2));
          bool2 = bool1;
        }
      }
      i3 = 1;
    }
    if (i3 != 0)
    {
      if (!bool1) {
        this.q = false;
      }
      i3 = this.o;
      if ((i3 == 1) || (i3 == 3)) {
        this.m = i();
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.m = null;
    this.n = null;
    a(0);
    j();
    this.p = 4;
    this.q = false;
    this.r = 0;
    this.s = 0;
  }
  
  public void d() {}
  
  protected boolean e()
  {
    return this.m != this.n;
  }
  
  protected com.tencent.luggage.wxa.ad.d f()
  {
    List localList = this.m;
    this.n = localList;
    return new f(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ae.a
 * JD-Core Version:    0.7.0.1
 */