package com.qq.ac.sdk.e;

import com.qq.ac.sdk.listener.BaseInfoListener;
import java.util.Map;

public final class b
{
  private String a;
  private int b;
  private b.a c = new b.a();
  private b.a d = new b.a();
  private BaseInfoListener e;
  
  public final b a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public final b a(BaseInfoListener paramBaseInfoListener)
  {
    this.e = paramBaseInfoListener;
    return this;
  }
  
  public final b a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public final b a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
    return this;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final b b(String paramString1, String paramString2)
  {
    this.d.a(paramString1, paramString2);
    return this;
  }
  
  public final Map<String, String> b()
  {
    return this.c.a;
  }
  
  public final Map<String, String> c()
  {
    return this.d.a;
  }
  
  public final BaseInfoListener d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */