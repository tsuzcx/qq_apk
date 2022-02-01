package com.tencent.biz.richframework.part.block.base;

import com.tencent.biz.richframework.config.RFWCommonConfig;

public class LoadInfo
{
  private volatile boolean a = true;
  private volatile int b = 4;
  private String c;
  private String d = null;
  private String e = null;
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean b()
  {
    return this.b != 4;
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      RFWCommonConfig.a(paramString);
    }
    this.e = paramString;
  }
  
  public boolean c()
  {
    return this.b == 1;
  }
  
  public boolean d()
  {
    return this.b == 2;
  }
  
  public boolean e()
  {
    return this.b == 3;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public String h()
  {
    if (this.e == null) {
      this.e = RFWCommonConfig.c();
    }
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadInfo{isFinish=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCurrentState=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mSAttachInfo='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRefreshAttachInfo='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.LoadInfo
 * JD-Core Version:    0.7.0.1
 */