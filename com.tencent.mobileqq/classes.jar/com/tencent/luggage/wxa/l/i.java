package com.tencent.luggage.wxa.l;

public final class i
{
  private static final String[] h = { "audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg" };
  private static final int[] i = { 44100, 48000, 32000 };
  private static final int[] j = { 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 };
  private static final int[] k = { 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 };
  private static final int[] l = { 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 };
  private static final int[] m = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 };
  private static final int[] n = { 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 };
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public static int a(int paramInt)
  {
    if ((paramInt & 0xFFE00000) != -2097152) {
      return -1;
    }
    int i4 = paramInt >>> 19 & 0x3;
    if (i4 == 1) {
      return -1;
    }
    int i3 = paramInt >>> 17 & 0x3;
    if (i3 == 0) {
      return -1;
    }
    int i6 = paramInt >>> 12 & 0xF;
    if (i6 != 0)
    {
      if (i6 == 15) {
        return -1;
      }
      int i1 = paramInt >>> 10 & 0x3;
      if (i1 == 3) {
        return -1;
      }
      int i2 = i[i1];
      if (i4 == 2)
      {
        i1 = i2 / 2;
      }
      else
      {
        i1 = i2;
        if (i4 == 0) {
          i1 = i2 / 4;
        }
      }
      int i5 = paramInt >>> 9 & 0x1;
      if (i3 == 3)
      {
        if (i4 == 3) {
          paramInt = j[(i6 - 1)];
        } else {
          paramInt = k[(i6 - 1)];
        }
        return (paramInt * 12000 / i1 + i5) * 4;
      }
      if (i4 == 3)
      {
        if (i3 == 2) {
          paramInt = l[(i6 - 1)];
        } else {
          paramInt = m[(i6 - 1)];
        }
      }
      else {
        paramInt = n[(i6 - 1)];
      }
      i2 = 144000;
      if (i4 == 3) {
        return paramInt * 144000 / i1 + i5;
      }
      if (i3 == 1) {
        i2 = 72000;
      }
      return i2 * paramInt / i1 + i5;
    }
    return -1;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
  }
  
  public static boolean a(int paramInt, i parami)
  {
    if ((paramInt & 0xFFE00000) != -2097152) {
      return false;
    }
    int i6 = paramInt >>> 19 & 0x3;
    if (i6 == 1) {
      return false;
    }
    int i7 = paramInt >>> 17 & 0x3;
    if (i7 == 0) {
      return false;
    }
    int i5 = paramInt >>> 12 & 0xF;
    if (i5 != 0)
    {
      if (i5 == 15) {
        return false;
      }
      int i1 = paramInt >>> 10 & 0x3;
      if (i1 == 3) {
        return false;
      }
      int i2 = i[i1];
      if (i6 == 2)
      {
        i1 = i2 / 2;
      }
      else
      {
        i1 = i2;
        if (i6 == 0) {
          i1 = i2 / 4;
        }
      }
      int i4 = paramInt >>> 9 & 0x1;
      i2 = 1152;
      int i3;
      if (i7 == 3)
      {
        if (i6 == 3) {
          i2 = j[(i5 - 1)];
        } else {
          i2 = k[(i5 - 1)];
        }
        i3 = (i2 * 12000 / i1 + i4) * 4;
        i4 = 384;
      }
      else
      {
        i3 = 144000;
        if (i6 == 3)
        {
          if (i7 == 2) {
            i2 = l[(i5 - 1)];
          } else {
            i2 = m[(i5 - 1)];
          }
          i3 = 144000 * i2 / i1 + i4;
          i4 = 1152;
        }
        else
        {
          i5 = n[(i5 - 1)];
          if (i7 == 1) {
            i2 = 576;
          }
          if (i7 == 1) {
            i3 = 72000;
          }
          i3 = i3 * i5 / i1 + i4;
          i4 = i2;
          i2 = i5;
        }
      }
      String str = h[(3 - i7)];
      if ((paramInt >> 6 & 0x3) == 3) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      parami.a(i6, str, i3, i1, paramInt, i2 * 1000, i4);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.l.i
 * JD-Core Version:    0.7.0.1
 */