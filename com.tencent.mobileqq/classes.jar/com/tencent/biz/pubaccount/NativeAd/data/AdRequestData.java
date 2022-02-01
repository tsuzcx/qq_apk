package com.tencent.biz.pubaccount.NativeAd.data;

public class AdRequestData
{
  public int a;
  public int b;
  public int c;
  public long d;
  public boolean e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public boolean m = false;
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("materialId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ,repeatedReqFlag=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" kdPos=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",adPosID=");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.data.AdRequestData
 * JD-Core Version:    0.7.0.1
 */