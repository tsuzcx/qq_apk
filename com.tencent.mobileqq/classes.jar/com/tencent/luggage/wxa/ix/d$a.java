package com.tencent.luggage.wxa.ix;

import androidx.annotation.NonNull;

 enum d$a
{
  private final int m;
  private final boolean n;
  
  private d$a(int paramInt)
  {
    this(paramInt, false);
  }
  
  private d$a(int paramInt, boolean paramBoolean)
  {
    this.m = paramInt;
    this.n = paramBoolean;
  }
  
  @NonNull
  static a a(int paramInt)
  {
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      if (locala.a() == paramInt) {
        return locala;
      }
      i1 += 1;
    }
    return a;
  }
  
  int a()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d.a
 * JD-Core Version:    0.7.0.1
 */