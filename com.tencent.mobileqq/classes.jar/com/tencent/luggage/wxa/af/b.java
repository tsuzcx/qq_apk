package com.tencent.luggage.wxa.af;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.luggage.wxa.ad.a;
import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.ao.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final byte[] a = { 0, 7, 8, 15 };
  private static final byte[] b = { 0, 119, -120, -1 };
  private static final byte[] c = { 0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1 };
  private final Paint d = new Paint();
  private final Paint e;
  private final Canvas f;
  private final b.b g;
  private final b.a h;
  private final b.h i;
  private Bitmap j;
  
  public b(int paramInt1, int paramInt2)
  {
    this.d.setStyle(Paint.Style.FILL_AND_STROKE);
    this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.d.setPathEffect(null);
    this.e = new Paint();
    this.e.setStyle(Paint.Style.FILL);
    this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
    this.e.setPathEffect(null);
    this.f = new Canvas();
    this.g = new b.b(719, 575, 0, 719, 0, 575);
    this.h = new b.a(0, b(), c(), d());
    this.i = new b.h(paramInt1, paramInt2);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int a(l paraml, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int k = 0;
    int n = paramInt1;
    for (paramInt1 = k;; paramInt1 = k)
    {
      k = paraml.c(2);
      int i1;
      int m;
      if (k != 0)
      {
        i1 = paramInt1;
        m = 1;
        paramInt1 = k;
        k = i1;
      }
      else
      {
        if (paraml.e())
        {
          m = paraml.c(3) + 3;
          k = paraml.c(2);
        }
        for (;;)
        {
          i1 = paramInt1;
          paramInt1 = k;
          k = i1;
          break label187;
          if (paraml.e())
          {
            k = 0;
            break;
          }
          k = paraml.c(2);
          if (k == 0) {
            break label179;
          }
          if (k == 1) {
            break label168;
          }
          if (k != 2)
          {
            if (k != 3)
            {
              k = paramInt1;
              paramInt1 = 0;
              m = 0;
              break label187;
            }
            m = paraml.c(8) + 29;
            k = paraml.c(2);
          }
          else
          {
            m = paraml.c(4) + 12;
            k = paraml.c(2);
          }
        }
        label168:
        k = paramInt1;
        paramInt1 = 0;
        m = 2;
        break label187;
        label179:
        paramInt1 = 0;
        m = 0;
        k = 1;
      }
      label187:
      if ((m != 0) && (paramPaint != null))
      {
        i1 = paramInt1;
        if (paramArrayOfByte != null) {
          i1 = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[i1]);
        paramCanvas.drawRect(n, paramInt2, n + m, paramInt2 + 1, paramPaint);
      }
      n += m;
      if (k != 0) {
        return n;
      }
    }
  }
  
  private static b.b a(l paraml)
  {
    paraml.b(4);
    boolean bool = paraml.e();
    paraml.b(3);
    int i2 = paraml.c(16);
    int i3 = paraml.c(16);
    int n;
    int k;
    int m;
    int i1;
    if (bool)
    {
      n = paraml.c(16);
      k = paraml.c(16);
      m = paraml.c(16);
      i1 = paraml.c(16);
    }
    else
    {
      k = i2;
      i1 = i3;
      n = 0;
      m = 0;
    }
    return new b.b(i2, i3, n, k, m, i1);
  }
  
  private static b.d a(l paraml, int paramInt)
  {
    int k = paraml.c(8);
    int m = paraml.c(4);
    int n = paraml.c(2);
    paraml.b(2);
    paramInt -= 2;
    SparseArray localSparseArray = new SparseArray();
    while (paramInt > 0)
    {
      int i1 = paraml.c(8);
      paraml.b(8);
      int i2 = paraml.c(16);
      int i3 = paraml.c(16);
      paramInt -= 6;
      localSparseArray.put(i1, new b.e(i2, i3));
    }
    return new b.d(k, m, n, localSparseArray);
  }
  
  private static void a(b.c paramc, b.a parama, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramInt1 == 3) {
      parama = parama.d;
    } else if (paramInt1 == 2) {
      parama = parama.c;
    } else {
      parama = parama.b;
    }
    a(paramc.c, parama, paramInt1, paramInt2, paramInt3, paramPaint, paramCanvas);
    a(paramc.d, parama, paramInt1, paramInt2, paramInt3 + 1, paramPaint, paramCanvas);
  }
  
  private static void a(l paraml, b.h paramh)
  {
    int k = paraml.c(8);
    int m = paraml.c(16);
    int n = paraml.c(16);
    int i1 = paraml.c();
    if (n * 8 > paraml.a())
    {
      Log.w("DvbParser", "Data field length exceeds limit");
      paraml.b(paraml.a());
      return;
    }
    Object localObject1;
    Object localObject2;
    switch (k)
    {
    default: 
      break;
    case 20: 
      if (m == paramh.a) {
        paramh.h = a(paraml);
      }
      break;
    case 19: 
      if (m == paramh.a)
      {
        localObject1 = b(paraml);
        paramh.e.put(((b.c)localObject1).a, localObject1);
      }
      else if (m == paramh.b)
      {
        localObject1 = b(paraml);
        paramh.g.put(((b.c)localObject1).a, localObject1);
      }
      break;
    case 18: 
      if (m == paramh.a)
      {
        localObject1 = c(paraml, n);
        paramh.d.put(((b.a)localObject1).a, localObject1);
      }
      else if (m == paramh.b)
      {
        localObject1 = c(paraml, n);
        paramh.f.put(((b.a)localObject1).a, localObject1);
      }
      break;
    case 17: 
      localObject1 = paramh.i;
      if ((m == paramh.a) && (localObject1 != null))
      {
        localObject2 = b(paraml, n);
        if (((b.d)localObject1).c == 0) {
          ((b.f)localObject2).a((b.f)paramh.c.get(((b.f)localObject2).a));
        }
        paramh.c.put(((b.f)localObject2).a, localObject2);
      }
      break;
    case 16: 
      if (m == paramh.a)
      {
        localObject1 = paramh.i;
        localObject2 = a(paraml, n);
        if (((b.d)localObject2).c != 0)
        {
          paramh.i = ((b.d)localObject2);
          paramh.c.clear();
          paramh.d.clear();
          paramh.e.clear();
        }
        else if ((localObject1 != null) && (((b.d)localObject1).b != ((b.d)localObject2).b))
        {
          paramh.i = ((b.d)localObject2);
        }
      }
      break;
    }
    paraml.d(i1 + n - paraml.c());
  }
  
  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    l locall = new l(paramArrayOfByte);
    int m = paramInt2;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    int k = paramInt3;
    paramInt3 = m;
    while (locall.a() != 0)
    {
      m = locall.c(8);
      if (m != 240)
      {
        switch (m)
        {
        default: 
          switch (m)
          {
          default: 
            break;
          case 34: 
            paramArrayOfByte = a(16, 8, locall);
            break;
          case 33: 
            paramArrayOfByte = a(4, 8, locall);
            arrayOfByte2 = paramArrayOfByte;
            break;
          case 32: 
            arrayOfByte1 = a(4, 4, locall);
          }
          break;
        case 18: 
          paramInt3 = c(locall, paramArrayOfInt, null, paramInt3, k, paramPaint, paramCanvas);
        case 17: 
        case 16: 
          for (;;)
          {
            break;
            if (paramInt1 == 3) {
              paramArrayOfByte = c;
            } else {
              paramArrayOfByte = null;
            }
            paramInt3 = b(locall, paramArrayOfInt, paramArrayOfByte, paramInt3, k, paramPaint, paramCanvas);
            locall.f();
            continue;
            if (paramInt1 == 3) {
              if (arrayOfByte2 == null) {
                paramArrayOfByte = b;
              } else {
                paramArrayOfByte = arrayOfByte2;
              }
            }
            for (;;)
            {
              break;
              if (paramInt1 == 2)
              {
                if (arrayOfByte1 == null) {
                  paramArrayOfByte = a;
                } else {
                  paramArrayOfByte = arrayOfByte1;
                }
              }
              else {
                paramArrayOfByte = null;
              }
            }
            paramInt3 = a(locall, paramArrayOfInt, paramArrayOfByte, paramInt3, k, paramPaint, paramCanvas);
            locall.f();
          }
        }
      }
      else
      {
        k += 2;
        paramInt3 = paramInt2;
      }
    }
  }
  
  private static byte[] a(int paramInt1, int paramInt2, l paraml)
  {
    byte[] arrayOfByte = new byte[paramInt1];
    int k = 0;
    while (k < paramInt1)
    {
      arrayOfByte[k] = ((byte)paraml.c(paramInt2));
      k += 1;
    }
    return arrayOfByte;
  }
  
  private static int b(l paraml, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int k = 0;
    int n = paramInt1;
    for (paramInt1 = k;; paramInt1 = k)
    {
      k = paraml.c(4);
      if (k != 0) {}
      int i1;
      int m;
      for (;;)
      {
        i1 = paramInt1;
        m = 1;
        paramInt1 = k;
        k = i1;
        break;
        if (!paraml.e())
        {
          m = paraml.c(3);
          if (m != 0)
          {
            k = paramInt1;
            m += 2;
            paramInt1 = 0;
            break;
          }
          paramInt1 = 0;
          m = 0;
          k = 1;
          break;
        }
        if (!paraml.e())
        {
          m = paraml.c(2) + 4;
          k = paraml.c(4);
        }
        for (;;)
        {
          i1 = paramInt1;
          paramInt1 = k;
          k = i1;
          break label216;
          k = paraml.c(2);
          if (k == 0) {
            break label210;
          }
          if (k == 1) {
            break;
          }
          if (k != 2)
          {
            if (k != 3)
            {
              k = paramInt1;
              paramInt1 = 0;
              m = 0;
              break label216;
            }
            m = paraml.c(8) + 25;
            k = paraml.c(4);
          }
          else
          {
            m = paraml.c(4) + 9;
            k = paraml.c(4);
          }
        }
        k = paramInt1;
        paramInt1 = 0;
        m = 2;
        break;
        label210:
        k = 0;
      }
      label216:
      if ((m != 0) && (paramPaint != null))
      {
        i1 = paramInt1;
        if (paramArrayOfByte != null) {
          i1 = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[i1]);
        paramCanvas.drawRect(n, paramInt2, n + m, paramInt2 + 1, paramPaint);
      }
      n += m;
      if (k != 0) {
        return n;
      }
    }
  }
  
  private static b.c b(l paraml)
  {
    int k = paraml.c(16);
    paraml.b(4);
    int m = paraml.c(2);
    boolean bool = paraml.e();
    paraml.b(1);
    Object localObject2 = null;
    Object localObject1 = null;
    if (m == 1)
    {
      paraml.b(paraml.c(8) * 16);
    }
    else if (m == 0)
    {
      m = paraml.c(16);
      int n = paraml.c(16);
      if (m > 0)
      {
        localObject1 = new byte[m];
        paraml.a((byte[])localObject1, 0, m);
      }
      localObject2 = localObject1;
      if (n > 0)
      {
        localObject2 = new byte[n];
        paraml.a((byte[])localObject2, 0, n);
        paraml = (l)localObject2;
        break label125;
      }
    }
    paraml = (l)localObject2;
    localObject1 = localObject2;
    label125:
    return new b.c(k, bool, (byte[])localObject1, paraml);
  }
  
  private static b.f b(l paraml, int paramInt)
  {
    int i2 = paraml.c(8);
    paraml.b(4);
    boolean bool = paraml.e();
    paraml.b(3);
    int i3 = paraml.c(16);
    int i4 = paraml.c(16);
    int i5 = paraml.c(3);
    int i6 = paraml.c(3);
    paraml.b(2);
    int i7 = paraml.c(8);
    int i8 = paraml.c(8);
    int i9 = paraml.c(4);
    int k = paraml.c(2);
    paraml.b(2);
    paramInt -= 10;
    SparseArray localSparseArray = new SparseArray();
    while (paramInt > 0)
    {
      int i10 = paraml.c(16);
      int i11 = paraml.c(2);
      int i12 = paraml.c(2);
      int i13 = paraml.c(12);
      paraml.b(4);
      int i14 = paraml.c(12);
      paramInt -= 6;
      int m;
      int n;
      if ((i11 != 1) && (i11 != 2))
      {
        m = 0;
        n = 0;
      }
      else
      {
        m = paraml.c(8);
        n = paraml.c(8);
        int i1 = paramInt - 2;
        paramInt = m;
        m = paramInt;
        paramInt = i1;
      }
      localSparseArray.put(i10, new b.g(i11, i12, i13, i14, m, n));
    }
    return new b.f(i2, bool, i3, i4, i5, i6, i7, i8, i9, k, localSparseArray);
  }
  
  private static int[] b()
  {
    return new int[] { 0, -1, -16777216, -8421505 };
  }
  
  private static int c(l paraml, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int k = 0;
    int n = paramInt1;
    for (paramInt1 = k;; paramInt1 = k)
    {
      int m = paraml.c(8);
      int i1;
      if (m != 0)
      {
        k = paramInt1;
        paramInt1 = m;
        m = 1;
      }
      else if (!paraml.e())
      {
        m = paraml.c(7);
        if (m != 0)
        {
          k = paramInt1;
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = 0;
          m = 0;
          k = 1;
        }
      }
      else
      {
        m = paraml.c(7);
        i1 = paraml.c(8);
        k = paramInt1;
        paramInt1 = i1;
      }
      if ((m != 0) && (paramPaint != null))
      {
        i1 = paramInt1;
        if (paramArrayOfByte != null) {
          i1 = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[i1]);
        paramCanvas.drawRect(n, paramInt2, n + m, paramInt2 + 1, paramPaint);
      }
      n += m;
      if (k != 0) {
        return n;
      }
    }
  }
  
  private static b.a c(l paraml, int paramInt)
  {
    int i1 = paraml.c(8);
    paraml.b(8);
    paramInt -= 2;
    int[] arrayOfInt2 = b();
    int[] arrayOfInt3 = c();
    int[] arrayOfInt4 = d();
    while (paramInt > 0)
    {
      int i3 = paraml.c(8);
      int k = paraml.c(8);
      paramInt -= 2;
      int[] arrayOfInt1;
      if ((k & 0x80) != 0) {
        arrayOfInt1 = arrayOfInt2;
      } else if ((k & 0x40) != 0) {
        arrayOfInt1 = arrayOfInt3;
      } else {
        arrayOfInt1 = arrayOfInt4;
      }
      if ((k & 0x1) != 0)
      {
        i2 = paraml.c(8);
        n = paraml.c(8);
        m = paraml.c(8);
        k = paraml.c(8);
        paramInt -= 4;
      }
      else
      {
        i2 = paraml.c(6);
        n = paraml.c(4);
        m = paraml.c(4) << 4;
        k = paraml.c(2);
        paramInt -= 2;
        k <<= 6;
        i2 <<= 2;
        n <<= 4;
      }
      if (i2 == 0)
      {
        n = 0;
        m = 0;
        k = 255;
      }
      k = (byte)(255 - (k & 0xFF));
      double d1 = i2;
      double d2 = n - 128;
      Double.isNaN(d2);
      Double.isNaN(d1);
      int n = (int)(d1 + 1.402D * d2);
      double d3 = m - 128;
      Double.isNaN(d3);
      Double.isNaN(d1);
      Double.isNaN(d2);
      int m = (int)(d1 - 0.34414D * d3 - d2 * 0.71414D);
      Double.isNaN(d3);
      Double.isNaN(d1);
      int i2 = (int)(d1 + d3 * 1.772D);
      arrayOfInt1[i3] = a(k, x.a(n, 0, 255), x.a(m, 0, 255), x.a(i2, 0, 255));
    }
    return new b.a(i1, arrayOfInt2, arrayOfInt3, arrayOfInt4);
  }
  
  private static int[] c()
  {
    int[] arrayOfInt = new int[16];
    arrayOfInt[0] = 0;
    int k = 1;
    while (k < arrayOfInt.length)
    {
      int m;
      int n;
      int i1;
      if (k < 8)
      {
        if ((k & 0x1) != 0) {
          m = 255;
        } else {
          m = 0;
        }
        if ((k & 0x2) != 0) {
          n = 255;
        } else {
          n = 0;
        }
        if ((k & 0x4) != 0) {
          i1 = 255;
        } else {
          i1 = 0;
        }
        arrayOfInt[k] = a(255, m, n, i1);
      }
      else
      {
        i1 = 127;
        if ((k & 0x1) != 0) {
          m = 127;
        } else {
          m = 0;
        }
        if ((k & 0x2) != 0) {
          n = 127;
        } else {
          n = 0;
        }
        if ((k & 0x4) == 0) {
          i1 = 0;
        }
        arrayOfInt[k] = a(255, m, n, i1);
      }
      k += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] d()
  {
    int[] arrayOfInt = new int[256];
    arrayOfInt[0] = 0;
    int m = 0;
    while (m < arrayOfInt.length)
    {
      int i1 = 255;
      int k;
      int n;
      if (m < 8)
      {
        if ((m & 0x1) != 0) {
          k = 255;
        } else {
          k = 0;
        }
        if ((m & 0x2) != 0) {
          n = 255;
        } else {
          n = 0;
        }
        if ((m & 0x4) == 0) {
          i1 = 0;
        }
        arrayOfInt[m] = a(63, k, n, i1);
      }
      else
      {
        i1 = m & 0x88;
        n = 170;
        k = 85;
        int i2;
        int i3;
        int i4;
        if (i1 != 0)
        {
          if (i1 != 8)
          {
            n = 43;
            if (i1 != 128)
            {
              if (i1 == 136)
              {
                if ((m & 0x1) != 0) {
                  i1 = 43;
                } else {
                  i1 = 0;
                }
                if ((m & 0x10) != 0) {
                  i2 = 85;
                } else {
                  i2 = 0;
                }
                if ((m & 0x2) != 0) {
                  i3 = 43;
                } else {
                  i3 = 0;
                }
                if ((m & 0x20) != 0) {
                  i4 = 85;
                } else {
                  i4 = 0;
                }
                if ((m & 0x4) == 0) {
                  n = 0;
                }
                if ((m & 0x40) == 0) {
                  k = 0;
                }
                arrayOfInt[m] = a(255, i1 + i2, i3 + i4, n + k);
              }
            }
            else
            {
              if ((m & 0x1) != 0) {
                i1 = 43;
              } else {
                i1 = 0;
              }
              if ((m & 0x10) != 0) {
                i2 = 85;
              } else {
                i2 = 0;
              }
              if ((m & 0x2) != 0) {
                i3 = 43;
              } else {
                i3 = 0;
              }
              if ((m & 0x20) != 0) {
                i4 = 85;
              } else {
                i4 = 0;
              }
              if ((m & 0x4) == 0) {
                n = 0;
              }
              if ((m & 0x40) == 0) {
                k = 0;
              }
              arrayOfInt[m] = a(255, i1 + 127 + i2, i3 + 127 + i4, n + 127 + k);
            }
          }
          else
          {
            if ((m & 0x1) != 0) {
              i1 = 85;
            } else {
              i1 = 0;
            }
            if ((m & 0x10) != 0) {
              i2 = 170;
            } else {
              i2 = 0;
            }
            if ((m & 0x2) != 0) {
              i3 = 85;
            } else {
              i3 = 0;
            }
            if ((m & 0x20) != 0) {
              i4 = 170;
            } else {
              i4 = 0;
            }
            if ((m & 0x4) == 0) {
              k = 0;
            }
            if ((m & 0x40) == 0) {
              n = 0;
            }
            arrayOfInt[m] = a(127, i1 + i2, i3 + i4, k + n);
          }
        }
        else
        {
          if ((m & 0x1) != 0) {
            i1 = 85;
          } else {
            i1 = 0;
          }
          if ((m & 0x10) != 0) {
            i2 = 170;
          } else {
            i2 = 0;
          }
          if ((m & 0x2) != 0) {
            i3 = 85;
          } else {
            i3 = 0;
          }
          if ((m & 0x20) != 0) {
            i4 = 170;
          } else {
            i4 = 0;
          }
          if ((m & 0x4) == 0) {
            k = 0;
          }
          if ((m & 0x40) == 0) {
            n = 0;
          }
          arrayOfInt[m] = a(255, i1 + i2, i3 + i4, k + n);
        }
      }
      m += 1;
    }
    return arrayOfInt;
  }
  
  public List<a> a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new l(paramArrayOfByte, paramInt);
    while ((paramArrayOfByte.a() >= 48) && (paramArrayOfByte.c(8) == 15)) {
      a(paramArrayOfByte, this.i);
    }
    if (this.i.i == null) {
      return Collections.emptyList();
    }
    b.b localb;
    if (this.i.h != null) {
      localb = this.i.h;
    } else {
      localb = this.g;
    }
    if ((this.j == null) || (localb.a + 1 != this.j.getWidth()) || (localb.b + 1 != this.j.getHeight()))
    {
      this.j = Bitmap.createBitmap(localb.a + 1, localb.b + 1, Bitmap.Config.ARGB_8888);
      this.f.setBitmap(this.j);
    }
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = this.i.i.d;
    int k = 0;
    while (k < localSparseArray.size())
    {
      paramArrayOfByte = (b.e)localSparseArray.valueAt(k);
      paramInt = localSparseArray.keyAt(k);
      b.f localf = (b.f)this.i.c.get(paramInt);
      int m = paramArrayOfByte.a + localb.c;
      int n = paramArrayOfByte.b + localb.e;
      paramInt = Math.min(localf.c + m, localb.d);
      int i1 = Math.min(localf.d + n, localb.f);
      paramArrayOfByte = this.f;
      float f1 = m;
      float f2 = n;
      paramArrayOfByte.clipRect(f1, f2, paramInt, i1, Region.Op.REPLACE);
      Object localObject = (b.a)this.i.d.get(localf.g);
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null)
      {
        localObject = (b.a)this.i.f.get(localf.g);
        paramArrayOfByte = (byte[])localObject;
        if (localObject == null) {
          paramArrayOfByte = this.h;
        }
      }
      localObject = localf.k;
      paramInt = 0;
      while (paramInt < ((SparseArray)localObject).size())
      {
        i1 = ((SparseArray)localObject).keyAt(paramInt);
        b.g localg = (b.g)((SparseArray)localObject).valueAt(paramInt);
        b.c localc = (b.c)this.i.e.get(i1);
        if (localc == null) {
          localc = (b.c)this.i.g.get(i1);
        }
        if (localc != null)
        {
          Paint localPaint;
          if (localc.b) {
            localPaint = null;
          } else {
            localPaint = this.d;
          }
          a(localc, paramArrayOfByte, localf.f, localg.c + m, n + localg.d, localPaint, this.f);
        }
        paramInt += 1;
      }
      if (localf.b)
      {
        if (localf.f == 3) {
          paramInt = paramArrayOfByte.d[localf.h];
        } else if (localf.f == 2) {
          paramInt = paramArrayOfByte.c[localf.i];
        } else {
          paramInt = paramArrayOfByte.b[localf.j];
        }
        this.e.setColor(paramInt);
        this.f.drawRect(f1, f2, localf.c + m, localf.d + n, this.e);
      }
      localArrayList.add(new a(Bitmap.createBitmap(this.j, m, n, localf.c, localf.d), f1 / localb.a, 0, f2 / localb.b, 0, localf.c / localb.a, localf.d / localb.b));
      this.f.drawColor(0, PorterDuff.Mode.CLEAR);
      k += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.i.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.af.b
 * JD-Core Version:    0.7.0.1
 */