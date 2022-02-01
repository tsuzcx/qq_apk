package com.tencent.mobileqq.applets.data;

public class AppletItem$Builder
{
  private long a;
  private String b;
  private String c;
  private int d;
  private int e;
  private String f;
  
  public Builder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public AppletItem a()
  {
    return new AppletItem(this.a, this.b, this.c, this.d, this.e, this.f, null);
  }
  
  public Builder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.data.AppletItem.Builder
 * JD-Core Version:    0.7.0.1
 */