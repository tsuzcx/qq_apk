package com.tencent.liteav.basic.util;

public enum g$a
{
  private final int value;
  
  private g$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a a(int paramInt)
  {
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.a() == paramInt) {
        return locala;
      }
      i += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.g.a
 * JD-Core Version:    0.7.0.1
 */