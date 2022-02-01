package com.google.zxing.client.android.wifi;

public final class WifiParsedResult
  extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;
  private final boolean d;
  
  public WifiParsedResult(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(ParsedResultType.WIFI);
    this.a = paramString2;
    this.b = paramString1;
    this.c = paramString3;
    this.d = paramBoolean;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    a(this.a, localStringBuilder);
    a(this.b, localStringBuilder);
    a(this.c, localStringBuilder);
    a(Boolean.toString(this.d), localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.client.android.wifi.WifiParsedResult
 * JD-Core Version:    0.7.0.1
 */