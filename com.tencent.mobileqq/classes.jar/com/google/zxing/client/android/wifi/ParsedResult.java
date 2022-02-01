package com.google.zxing.client.android.wifi;

import android.text.TextUtils;

public abstract class ParsedResult
{
  private final ParsedResultType a;
  
  protected ParsedResult(ParsedResultType paramParsedResultType)
  {
    this.a = paramParsedResultType;
  }
  
  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append('\n');
      }
      paramStringBuilder.append(paramString);
    }
  }
  
  public abstract String a();
  
  public final String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.client.android.wifi.ParsedResult
 * JD-Core Version:    0.7.0.1
 */