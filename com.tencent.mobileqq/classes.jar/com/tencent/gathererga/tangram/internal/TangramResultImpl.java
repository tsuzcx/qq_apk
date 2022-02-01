package com.tencent.gathererga.tangram.internal;

import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.tangram.TangramResult;

public class TangramResultImpl
  implements TangramResult
{
  private long a = -2147483648L;
  private long b = -1L;
  private boolean c = false;
  private Object d = null;
  private String e = null;
  private int f = -1;
  
  public TangramResultImpl(ProviderResult paramProviderResult, String paramString)
  {
    if (paramProviderResult != null)
    {
      this.a = paramProviderResult.a();
      this.c = paramProviderResult.c();
      this.f = paramProviderResult.d();
      if (this.f == 2)
      {
        if ((paramProviderResult.b() instanceof String)) {
          this.e = ((String)paramProviderResult.b());
        }
        this.d = null;
      }
      else
      {
        this.e = paramString;
        this.d = paramProviderResult.b();
      }
      this.b = paramProviderResult.e();
    }
  }
  
  public long a()
  {
    return this.b;
  }
  
  public long b()
  {
    return this.a;
  }
  
  public Object c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.tangram.internal.TangramResultImpl
 * JD-Core Version:    0.7.0.1
 */