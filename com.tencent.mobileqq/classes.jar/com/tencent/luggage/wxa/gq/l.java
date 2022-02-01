package com.tencent.luggage.wxa.gq;

import androidx.annotation.NonNull;

public class l
  implements Comparable<l>, Runnable
{
  private static int a = 1000;
  protected String b = "";
  protected final int c;
  protected long d;
  
  public l(String paramString, int paramInt)
  {
    this.b = paramString;
    this.d = System.currentTimeMillis();
    this.c = paramInt;
  }
  
  public int a(@NonNull l paraml)
  {
    int k = (int)(Math.abs(System.currentTimeMillis() - this.d) / a);
    int j = this.c;
    int i = j;
    if (k > 0) {
      i = j + k;
    }
    return paraml.c - i;
  }
  
  public void b() {}
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.l
 * JD-Core Version:    0.7.0.1
 */