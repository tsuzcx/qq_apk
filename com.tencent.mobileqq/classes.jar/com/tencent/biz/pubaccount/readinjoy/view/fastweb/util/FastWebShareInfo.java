package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

public class FastWebShareInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String a(int paramInt)
  {
    if (paramInt == 72) {
      return this.d;
    }
    if (paramInt == 73) {
      return this.d;
    }
    if (paramInt == 2) {
      return this.d;
    }
    if (paramInt == 3) {
      return this.e;
    }
    if (paramInt == 12) {
      return this.a;
    }
    if (paramInt == 9) {
      return this.c;
    }
    if (paramInt == 10) {
      return this.b;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("weibo : ").append(this.a).append("\n");
    localStringBuilder.append("qq : ").append(this.d).append("\n");
    localStringBuilder.append("wx : ").append(this.c).append("\n");
    localStringBuilder.append("pyq : ").append(this.b).append("\n");
    localStringBuilder.append("qzone : ").append(this.e).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareInfo
 * JD-Core Version:    0.7.0.1
 */