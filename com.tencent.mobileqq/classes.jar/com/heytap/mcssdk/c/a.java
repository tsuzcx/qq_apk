package com.heytap.mcssdk.c;

import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

public class a
  extends BaseMode
{
  private String a;
  private String b;
  private String c;
  private String d;
  private int e;
  private String f;
  private int g = -2;
  private String h;
  
  public static <T> String a(List<T> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append(paramList.next());
      localStringBuilder.append("&");
    }
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
  
  public int getType()
  {
    return 4105;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CallBackResult{, mRegisterID='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSdkVersion='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCommand=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContent='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAppPackage=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mResponseCode=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.c.a
 * JD-Core Version:    0.7.0.1
 */