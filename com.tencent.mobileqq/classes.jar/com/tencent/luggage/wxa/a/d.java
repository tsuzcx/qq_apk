package com.tencent.luggage.wxa.a;

class d
{
  private int a;
  private long b;
  
  d(long paramLong, int paramInt)
  {
    this.b = paramLong;
    this.a = paramInt;
  }
  
  static d a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return null;
    }
    long l = 0L;
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString.charAt(i);
      if ((j >= 48) && (j <= 57))
      {
        l = l * 16L + (j - 48);
      }
      else
      {
        if ((j >= 65) && (j <= 70))
        {
          l *= 16L;
          j -= 65;
        }
        for (;;)
        {
          l = l + j + 10L;
          break;
          if ((j < 97) || (j > 102)) {
            break label150;
          }
          l *= 16L;
          j -= 97;
        }
      }
      if (l > 4294967295L) {
        return null;
      }
      i += 1;
    }
    label150:
    if (i == paramInt1) {
      return null;
    }
    return new d(l, i);
  }
  
  static d a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 >= paramInt2) {
      return null;
    }
    int k = 0;
    int m = 0;
    int j = k;
    int i = paramInt1;
    if (paramBoolean)
    {
      i = paramString.charAt(paramInt1);
      j = m;
      if (i != 43)
      {
        if (i != 45)
        {
          j = k;
          i = paramInt1;
        }
        else
        {
          j = 1;
        }
      }
      else {
        i = paramInt1 + 1;
      }
    }
    long l1 = 0L;
    paramInt1 = i;
    while (paramInt1 < paramInt2)
    {
      k = paramString.charAt(paramInt1);
      if ((k < 48) || (k > 57)) {
        break;
      }
      long l2;
      if (j != 0)
      {
        l2 = l1 * 10L - (k - 48);
        l1 = l2;
        if (l2 < -2147483648L) {
          return null;
        }
      }
      else
      {
        l2 = l1 * 10L + (k - 48);
        l1 = l2;
        if (l2 > 2147483647L) {
          return null;
        }
      }
      paramInt1 += 1;
    }
    if (paramInt1 == i) {
      return null;
    }
    return new d(l1, paramInt1);
  }
  
  int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return (int)this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.d
 * JD-Core Version:    0.7.0.1
 */