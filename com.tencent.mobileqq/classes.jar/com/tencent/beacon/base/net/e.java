package com.tencent.beacon.base.net;

public final class e
{
  public String a;
  public String b;
  public int c;
  public String d;
  public Throwable e;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramString3;
  }
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, Throwable paramThrowable)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramString3;
    this.e = paramThrowable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetFailure{requestType='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", attaCode='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", responseCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", exception=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.e
 * JD-Core Version:    0.7.0.1
 */