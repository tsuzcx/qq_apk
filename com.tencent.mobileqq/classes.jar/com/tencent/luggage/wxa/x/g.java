package com.tencent.luggage.wxa.x;

import android.util.Log;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class g
  implements com.tencent.luggage.wxa.v.b
{
  public static final int a = x.f("ID3");
  private final g.a b;
  
  public g()
  {
    this(null);
  }
  
  public g(g.a parama)
  {
    this.b = parama;
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = b(paramArrayOfByte, paramInt1);
    if (paramInt2 != 0)
    {
      paramInt1 = i;
      if (paramInt2 == 3) {
        return i;
      }
      while (paramInt1 < paramArrayOfByte.length - 1)
      {
        if ((paramInt1 % 2 == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 0)) {
          return paramInt1;
        }
        paramInt1 = b(paramArrayOfByte, paramInt1 + 1);
      }
      return paramArrayOfByte.length;
    }
    return i;
  }
  
  private static a a(m paramm, int paramInt1, int paramInt2)
  {
    int i = paramm.g();
    String str = a(i);
    paramInt1 -= 1;
    byte[] arrayOfByte = new byte[paramInt1];
    paramm.a(arrayOfByte, 0, paramInt1);
    Object localObject;
    if (paramInt2 == 2)
    {
      paramm = new StringBuilder();
      paramm.append("image/");
      paramm.append(x.d(new String(arrayOfByte, 0, 3, "ISO-8859-1")));
      localObject = paramm.toString();
      paramm = (m)localObject;
      if (((String)localObject).equals("image/jpg")) {
        paramm = "image/jpeg";
      }
      paramInt1 = 2;
    }
    else
    {
      paramInt1 = b(arrayOfByte, 0);
      paramm = x.d(new String(arrayOfByte, 0, paramInt1, "ISO-8859-1"));
      if (paramm.indexOf('/') == -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("image/");
        ((StringBuilder)localObject).append(paramm);
        paramm = ((StringBuilder)localObject).toString();
      }
    }
    paramInt2 = arrayOfByte[(paramInt1 + 1)];
    paramInt1 += 2;
    int j = a(arrayOfByte, paramInt1, i);
    return new a(paramm, new String(arrayOfByte, paramInt1, j - paramInt1, str), paramInt2 & 0xFF, b(arrayOfByte, j + b(i), arrayOfByte.length));
  }
  
  private static c a(m paramm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, g.a parama)
  {
    int i = paramm.d();
    int j = b(paramm.a, i);
    String str = new String(paramm.a, i, j - i, "ISO-8859-1");
    paramm.c(j + 1);
    j = paramm.n();
    int k = paramm.n();
    long l1 = paramm.l();
    if (l1 == 4294967295L) {
      l1 = -1L;
    }
    long l2 = paramm.l();
    if (l2 == 4294967295L) {
      l2 = -1L;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramm.d() < i + paramInt1)
    {
      h localh = a(paramInt2, paramm, paramBoolean, paramInt3, parama);
      if (localh != null) {
        localArrayList.add(localh);
      }
    }
    paramm = new h[localArrayList.size()];
    localArrayList.toArray(paramm);
    return new c(str, j, k, l1, l2, paramm);
  }
  
  private static g.b a(m paramm)
  {
    if (paramm.b() < 10)
    {
      Log.w("Id3Decoder", "Data too short to be an ID3 tag");
      return null;
    }
    int i = paramm.k();
    if (i != a)
    {
      paramm = new StringBuilder();
      paramm.append("Unexpected first three bytes of ID3 tag header: ");
      paramm.append(i);
      Log.w("Id3Decoder", paramm.toString());
      return null;
    }
    int m = paramm.g();
    boolean bool = true;
    paramm.d(1);
    int n = paramm.g();
    int k = paramm.s();
    int j;
    if (m == 2)
    {
      if ((n & 0x40) != 0) {
        j = 1;
      } else {
        j = 0;
      }
      i = k;
      if (j != 0)
      {
        Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
        return null;
      }
    }
    else if (m == 3)
    {
      if ((n & 0x40) != 0) {
        j = 1;
      } else {
        j = 0;
      }
      i = k;
      if (j != 0)
      {
        i = paramm.n();
        paramm.d(i);
        i = k - (i + 4);
      }
    }
    else
    {
      if (m != 4) {
        break label275;
      }
      if ((n & 0x40) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      j = k;
      if (i != 0)
      {
        i = paramm.s();
        paramm.d(i - 4);
        j = k - i;
      }
      if ((n & 0x10) != 0) {
        k = 1;
      } else {
        k = 0;
      }
      i = j;
      if (k != 0) {
        i = j - 10;
      }
    }
    if ((m >= 4) || ((n & 0x80) == 0)) {
      bool = false;
    }
    return new g.b(m, bool, i);
    label275:
    paramm = new StringBuilder();
    paramm.append("Skipped ID3 tag with unsupported majorVersion=");
    paramm.append(m);
    Log.w("Id3Decoder", paramm.toString());
    return null;
  }
  
  private static h a(int paramInt1, m paramm, boolean paramBoolean, int paramInt2, g.a parama)
  {
    i5 = paramm.g();
    i6 = paramm.g();
    i7 = paramm.g();
    if (paramInt1 >= 3) {
      i1 = paramm.g();
    } else {
      i1 = 0;
    }
    int j;
    int i;
    if (paramInt1 == 4)
    {
      j = paramm.t();
      i = j;
      if (!paramBoolean) {
        i = (j >> 24 & 0xFF) << 21 | j & 0xFF | (j >> 8 & 0xFF) << 7 | (j >> 16 & 0xFF) << 14;
      }
    }
    int i2;
    for (;;)
    {
      i2 = i;
      break;
      if (paramInt1 == 3) {
        i = paramm.t();
      } else {
        i = paramm.k();
      }
    }
    if (paramInt1 >= 3) {
      i = paramm.h();
    } else {
      i = 0;
    }
    if ((i5 == 0) && (i6 == 0) && (i7 == 0) && (i1 == 0) && (i2 == 0) && (i == 0))
    {
      paramm.c(paramm.c());
      return null;
    }
    int i4 = paramm.d() + i2;
    if (i4 > paramm.c())
    {
      Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
      paramm.c(paramm.c());
      return null;
    }
    if ((parama != null) && (!parama.a(paramInt1, i5, i6, i7, i1)))
    {
      paramm.c(i4);
      return null;
    }
    int n = i;
    int m;
    int k;
    int i3;
    if (paramInt1 == 3)
    {
      if ((n & 0x80) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((n & 0x40) != 0) {
        m = 1;
      } else {
        m = 0;
      }
      if ((n & 0x20) != 0) {
        k = 1;
      } else {
        k = 0;
      }
      n = i;
      i3 = 0;
      j = i;
      i = i3;
    }
    else if (paramInt1 == 4)
    {
      if ((n & 0x40) != 0) {
        j = 1;
      } else {
        j = 0;
      }
      if ((n & 0x8) != 0) {
        k = 1;
      } else {
        k = 0;
      }
      if ((n & 0x4) != 0) {
        m = 1;
      } else {
        m = 0;
      }
      if ((n & 0x2) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((n & 0x1) != 0) {
        n = 1;
      } else {
        n = 0;
      }
      i3 = n;
      n = k;
      k = j;
      j = i3;
    }
    else
    {
      k = 0;
      j = 0;
      m = 0;
      i = 0;
      n = 0;
    }
    if ((n == 0) && (m == 0))
    {
      m = i2;
      if (k != 0)
      {
        m = i2 - 1;
        paramm.d(1);
      }
      k = m;
      if (j != 0)
      {
        k = m - 4;
        paramm.d(4);
      }
      j = k;
      if (i != 0) {
        j = f(paramm, k);
      }
      if ((i5 != 84) || (i6 != 88) || (i7 != 88) || ((paramInt1 != 2) && (i1 != 88))) {}
    }
    try
    {
      parama = a(paramm, j);
    }
    catch (UnsupportedEncodingException parama)
    {
      label822:
      StringBuilder localStringBuilder;
      label898:
      break label898;
    }
    finally
    {
      for (;;)
      {
        continue;
        if ((i5 == 87) && (i6 == 88) && (i7 == 88)) {
          if (paramInt1 != 2) {
            if (i1 == 88)
            {
              continue;
              if ((i5 != 71) || (i6 != 69) || (i7 != 79) || ((i1 != 66) && (paramInt1 != 2))) {
                if (paramInt1 == 2 ? (i5 != 80) && (i6 != 73) && (i7 != 67) : (i5 != 65) || (i6 != 80) || (i7 != 73) || (i1 != 67)) {
                  if ((i5 == 67) && (i6 == 79) && (i7 == 77)) {
                    if (i1 != 77) {
                      if (paramInt1 != 2) {}
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (i5 == 84)
    {
      parama = a(paramm, j, a(paramInt1, i5, i6, i7, i1));
      break label822;
      parama = b(paramm, j);
      break label822;
      if (i5 == 87)
      {
        parama = b(paramm, j, a(paramInt1, i5, i6, i7, i1));
      }
      else
      {
        if ((i5 != 80) || (i6 != 82) || (i7 != 73) || (i1 != 86)) {
          break label985;
        }
        parama = c(paramm, j);
        break label822;
        parama = d(paramm, j);
        break label822;
        parama = a(paramm, j, paramInt1);
        break label822;
        parama = e(paramm, j);
        break label822;
        if ((i5 == 67) && (i6 == 72) && (i7 == 65) && (i1 == 80)) {
          parama = a(paramm, j, paramInt1, paramBoolean, paramInt2, parama);
        } else if ((i5 == 67) && (i6 == 84) && (i7 == 79) && (i1 == 67)) {
          parama = b(paramm, j, paramInt1, paramBoolean, paramInt2, parama);
        } else {
          parama = c(paramm, j, a(paramInt1, i5, i6, i7, i1));
        }
      }
      if (parama == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to decode frame: id=");
        localStringBuilder.append(a(paramInt1, i5, i6, i7, i1));
        localStringBuilder.append(", frameSize=");
        localStringBuilder.append(j);
        Log.w("Id3Decoder", localStringBuilder.toString());
      }
      paramm.c(i4);
      return parama;
      Log.w("Id3Decoder", "Unsupported character encoding");
      paramm.c(i4);
      return null;
      paramm.c(i4);
      throw parama;
      Log.w("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
      paramm.c(i4);
      return null;
    }
  }
  
  private static j a(m paramm, int paramInt)
  {
    if (paramInt < 1) {
      return null;
    }
    int i = paramm.g();
    String str2 = a(i);
    paramInt -= 1;
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    paramInt = a(arrayOfByte, 0, i);
    String str1 = new String(arrayOfByte, 0, paramInt, str2);
    paramInt += b(i);
    if (paramInt < arrayOfByte.length) {
      paramm = new String(arrayOfByte, paramInt, a(arrayOfByte, paramInt, i) - paramInt, str2);
    } else {
      paramm = "";
    }
    return new j("TXXX", str1, paramm);
  }
  
  private static j a(m paramm, int paramInt, String paramString)
  {
    if (paramInt < 1) {
      return null;
    }
    int i = paramm.g();
    String str = a(i);
    paramInt -= 1;
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    return new j(paramString, null, new String(arrayOfByte, 0, a(arrayOfByte, 0, i), str));
  }
  
  private static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "ISO-8859-1";
          }
          return "UTF-8";
        }
        return "UTF-16BE";
      }
      return "UTF-16";
    }
    return "ISO-8859-1";
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 == 2) {
      return String.format(Locale.US, "%c%c%c", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    }
    return String.format(Locale.US, "%c%c%c%c", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
  }
  
  private static boolean a(m paramm, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int n = paramm.d();
    try
    {
      for (;;)
      {
        int i = paramm.b();
        int m = 1;
        if (i < paramInt2) {
          break;
        }
        long l1;
        if (paramInt1 >= 3)
        {
          i = paramm.n();
          l1 = paramm.l();
          k = paramm.h();
        }
        else
        {
          i = paramm.k();
          j = paramm.k();
          l1 = j;
          k = 0;
        }
        if ((i == 0) && (l1 == 0L) && (k == 0))
        {
          paramm.c(n);
          return true;
        }
        long l2 = l1;
        if (paramInt1 == 4)
        {
          l2 = l1;
          if (!paramBoolean)
          {
            if ((0x808080 & l1) != 0L)
            {
              paramm.c(n);
              return false;
            }
            l2 = (l1 >> 24 & 0xFF) << 21 | l1 & 0xFF | (l1 >> 8 & 0xFF) << 7 | (l1 >> 16 & 0xFF) << 14;
          }
        }
        if (paramInt1 == 4)
        {
          if ((k & 0x40) != 0) {
            j = 1;
          } else {
            j = 0;
          }
          i = j;
          if ((k & 0x1) == 0) {}
        }
        else
        {
          for (;;)
          {
            k = 1;
            i = j;
            j = k;
            break label266;
            if (paramInt1 != 3) {
              break;
            }
            if ((k & 0x20) != 0) {
              j = 1;
            } else {
              j = 0;
            }
            i = j;
            if ((k & 0x80) == 0) {
              break label263;
            }
          }
          i = 0;
        }
        label263:
        int j = 0;
        label266:
        if (i != 0) {
          i = m;
        } else {
          i = 0;
        }
        int k = i;
        if (j != 0) {
          k = i + 4;
        }
        if (l2 < k)
        {
          paramm.c(n);
          return false;
        }
        i = paramm.b();
        if (i < l2)
        {
          paramm.c(n);
          return false;
        }
        i = (int)l2;
        paramm.d(i);
      }
      paramm.c(n);
      return true;
    }
    finally
    {
      paramm.c(n);
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private static int b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 3)) {
      return 2;
    }
    return 1;
  }
  
  private static int b(byte[] paramArrayOfByte, int paramInt)
  {
    while (paramInt < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[paramInt] == 0) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramArrayOfByte.length;
  }
  
  private static d b(m paramm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, g.a parama)
  {
    int j = paramm.d();
    int i = b(paramm.a, j);
    String str = new String(paramm.a, j, i - j, "ISO-8859-1");
    paramm.c(i + 1);
    int k = paramm.g();
    i = 0;
    boolean bool1;
    if ((k & 0x2) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((k & 0x1) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    k = paramm.g();
    String[] arrayOfString = new String[k];
    while (i < k)
    {
      int m = paramm.d();
      int n = b(paramm.a, m);
      arrayOfString[i] = new String(paramm.a, m, n - m, "ISO-8859-1");
      paramm.c(n + 1);
      i += 1;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramm.d() < j + paramInt1)
    {
      h localh = a(paramInt2, paramm, paramBoolean, paramInt3, parama);
      if (localh != null) {
        localArrayList.add(localh);
      }
    }
    paramm = new h[localArrayList.size()];
    localArrayList.toArray(paramm);
    return new d(str, bool1, bool2, arrayOfString, paramm);
  }
  
  private static k b(m paramm, int paramInt)
  {
    if (paramInt < 1) {
      return null;
    }
    int i = paramm.g();
    String str = a(i);
    paramInt -= 1;
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    paramInt = a(arrayOfByte, 0, i);
    str = new String(arrayOfByte, 0, paramInt, str);
    paramInt += b(i);
    if (paramInt < arrayOfByte.length) {
      paramm = new String(arrayOfByte, paramInt, b(arrayOfByte, paramInt) - paramInt, "ISO-8859-1");
    } else {
      paramm = "";
    }
    return new k("WXXX", str, paramm);
  }
  
  private static k b(m paramm, int paramInt, String paramString)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    return new k(paramString, null, new String(arrayOfByte, 0, b(arrayOfByte, 0), "ISO-8859-1"));
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1) {
      return new byte[0];
    }
    return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static b c(m paramm, int paramInt, String paramString)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    return new b(paramString, arrayOfByte);
  }
  
  private static i c(m paramm, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    paramInt = b(arrayOfByte, 0);
    return new i(new String(arrayOfByte, 0, paramInt, "ISO-8859-1"), b(arrayOfByte, paramInt + 1, arrayOfByte.length));
  }
  
  private static f d(m paramm, int paramInt)
  {
    int i = paramm.g();
    String str1 = a(i);
    paramInt -= 1;
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    paramInt = b(arrayOfByte, 0);
    paramm = new String(arrayOfByte, 0, paramInt, "ISO-8859-1");
    paramInt += 1;
    int j = a(arrayOfByte, paramInt, i);
    String str2 = new String(arrayOfByte, paramInt, j - paramInt, str1);
    paramInt = j + b(i);
    j = a(arrayOfByte, paramInt, i);
    return new f(paramm, str2, new String(arrayOfByte, paramInt, j - paramInt, str1), b(arrayOfByte, j + b(i), arrayOfByte.length));
  }
  
  private static e e(m paramm, int paramInt)
  {
    if (paramInt < 4) {
      return null;
    }
    int i = paramm.g();
    String str2 = a(i);
    Object localObject = new byte[3];
    paramm.a((byte[])localObject, 0, 3);
    localObject = new String((byte[])localObject, 0, 3);
    paramInt -= 4;
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    paramInt = a(arrayOfByte, 0, i);
    String str1 = new String(arrayOfByte, 0, paramInt, str2);
    paramInt += b(i);
    if (paramInt < arrayOfByte.length) {
      paramm = new String(arrayOfByte, paramInt, a(arrayOfByte, paramInt, i) - paramInt, str2);
    } else {
      paramm = "";
    }
    return new e((String)localObject, str1, paramm);
  }
  
  private static int f(m paramm, int paramInt)
  {
    byte[] arrayOfByte = paramm.a;
    int j = paramm.d();
    for (;;)
    {
      int k = j + 1;
      if (k >= paramInt) {
        break;
      }
      int i = paramInt;
      if ((arrayOfByte[j] & 0xFF) == 255)
      {
        i = paramInt;
        if (arrayOfByte[k] == 0)
        {
          System.arraycopy(arrayOfByte, j + 2, arrayOfByte, k, paramInt - j - 2);
          i = paramInt - 1;
        }
      }
      j = k;
      paramInt = i;
    }
    return paramInt;
  }
  
  public com.tencent.luggage.wxa.v.a a(com.tencent.luggage.wxa.v.e parame)
  {
    parame = parame.b;
    return a(parame.array(), parame.limit());
  }
  
  public com.tencent.luggage.wxa.v.a a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new ArrayList();
    m localm = new m(paramArrayOfByte, paramInt);
    paramArrayOfByte = a(localm);
    if (paramArrayOfByte == null) {
      return null;
    }
    int j = localm.d();
    if (g.b.a(paramArrayOfByte) == 2) {
      paramInt = 6;
    } else {
      paramInt = 10;
    }
    int i = g.b.b(paramArrayOfByte);
    if (g.b.c(paramArrayOfByte)) {
      i = f(localm, g.b.b(paramArrayOfByte));
    }
    localm.b(j + i);
    i = g.b.a(paramArrayOfByte);
    boolean bool = false;
    if (!a(localm, i, paramInt, false)) {
      if ((g.b.a(paramArrayOfByte) == 4) && (a(localm, 4, paramInt, true)))
      {
        bool = true;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to validate ID3 tag with majorVersion=");
        ((StringBuilder)localObject).append(g.b.a(paramArrayOfByte));
        Log.w("Id3Decoder", ((StringBuilder)localObject).toString());
        return null;
      }
    }
    while (localm.b() >= paramInt)
    {
      h localh = a(g.b.a(paramArrayOfByte), localm, bool, paramInt, this.b);
      if (localh != null) {
        ((List)localObject).add(localh);
      }
    }
    return new com.tencent.luggage.wxa.v.a((List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.g
 * JD-Core Version:    0.7.0.1
 */