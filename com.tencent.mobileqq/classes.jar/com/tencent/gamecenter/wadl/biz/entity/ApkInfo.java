package com.tencent.gamecenter.wadl.biz.entity;

public class ApkInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public ApkInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramString3;
    this.c = paramString4;
    this.e = paramString5;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" appId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",appName=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",pkgName=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",channel=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",defUrl=");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ApkInfo
 * JD-Core Version:    0.7.0.1
 */