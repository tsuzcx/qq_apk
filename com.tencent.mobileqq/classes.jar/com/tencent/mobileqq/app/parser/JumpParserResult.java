package com.tencent.mobileqq.app.parser;

import java.util.HashMap;

public class JumpParserResult
{
  private static String a = "JumpParserResult";
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private HashMap<String, String> g;
  
  public JumpParserResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    paramString3 = paramString4;
    if (paramString4 == null) {
      paramString3 = "";
    }
    this.b = str;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString5;
    this.g = new HashMap();
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.b = str;
  }
  
  public void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = this.g;
    if (localHashMap == null) {
      return;
    }
    localHashMap.put(paramString1, paramString2);
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.c = str;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.d = str;
  }
  
  public HashMap<String, String> d()
  {
    return this.g;
  }
  
  public String e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpParserResult
 * JD-Core Version:    0.7.0.1
 */