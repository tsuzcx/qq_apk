package com.tencent.mobileqq.activity.home;

public class TabData
{
  public int a;
  public int b;
  public boolean c;
  public int d;
  public int e;
  public String f;
  public byte[] g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TabData{mTabId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mTabStatus=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mFirstShow=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mPushFrom=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mPushType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mTabBusinessType='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.TabData
 * JD-Core Version:    0.7.0.1
 */