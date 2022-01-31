package com.tencent.hlyyb.downloader.e.c;

import android.text.TextUtils;

public final class b
{
  private long a;
  private int b;
  private String c;
  
  public b(long paramLong, int paramInt, String paramString)
  {
    this.a = paramLong;
    this.b = paramInt;
    if (TextUtils.isEmpty(paramString))
    {
      this.c = "";
      return;
    }
    this.c = com.tencent.hlyyb.common.b.b.b(paramString);
  }
  
  public final String a()
  {
    return this.a + "," + this.b + "," + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.c.b
 * JD-Core Version:    0.7.0.1
 */