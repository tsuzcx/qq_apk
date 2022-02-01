package com.google.zxing.client.android.wifi;

public final class WifiParsedResult
  extends ParsedResult
{
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  private final String c;
  
  public WifiParsedResult(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(ParsedResultType.WIFI);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    this.c = paramString3;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    a(this.jdField_a_of_type_JavaLangString, localStringBuilder);
    a(this.b, localStringBuilder);
    a(this.c, localStringBuilder);
    a(Boolean.toString(this.jdField_a_of_type_Boolean), localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.client.android.wifi.WifiParsedResult
 * JD-Core Version:    0.7.0.1
 */