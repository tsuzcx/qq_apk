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
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = com.tencent.hlyyb.common.b.b.b(paramString))
    {
      this.c = paramString;
      return;
    }
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.c.b
 * JD-Core Version:    0.7.0.1
 */