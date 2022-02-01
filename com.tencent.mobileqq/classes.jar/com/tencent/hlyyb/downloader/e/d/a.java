package com.tencent.hlyyb.downloader.e.d;

public final class a
{
  private static int[] g = { b.c, b.b, b.f, b.e, b.j, b.d, b.h, b.i, b.g };
  private static int[] h = { b.f, b.c, b.e, b.d, b.j, b.b, b.h, b.i, b.g };
  public String a;
  public int b;
  public int c = 0;
  public boolean d = false;
  public String e = "";
  public boolean f = false;
  
  public a(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (paramBoolean) {
      arrayOfInt = g;
    } else {
      arrayOfInt = h;
    }
    int i = 0;
    int j = arrayOfInt[0];
    if (paramInt != 0) {
      while (i < arrayOfInt.length)
      {
        if ((paramInt == arrayOfInt[i]) && (i != arrayOfInt.length - 1)) {
          return arrayOfInt[(i + 1)];
        }
        i += 1;
      }
    }
    return j;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == b.c) || (paramInt == b.d) || (paramInt == b.e) || (paramInt == b.f) || (paramInt == b.h) || (paramInt == b.i) || (paramInt == b.j);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == b.c) || (paramInt == b.e) || (paramInt == b.f) || (paramInt == b.h) || (paramInt == b.j);
  }
  
  public final String toString()
  {
    boolean bool;
    if ((this.b != b.e) && (this.b != b.f) && (this.b != b.j) && (this.b != b.c) && (this.b != b.h)) {
      bool = false;
    } else {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b - 1);
    localStringBuilder.append(":");
    localStringBuilder.append(com.tencent.hlyyb.common.b.b.a(this.a, bool));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d.a
 * JD-Core Version:    0.7.0.1
 */