package com.tencent.gathererga.core.internal.provider;

import com.tencent.gathererga.core.ProviderMethodPriority;

public class ProviderMethodPriorityImpl
  implements ProviderMethodPriority
{
  private static ProviderMethodPriorityImpl f = new ProviderMethodPriorityImpl(4, 2, 1);
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private boolean d = true;
  private boolean e = true;
  
  private ProviderMethodPriorityImpl(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  private ProviderMethodPriorityImpl(ProviderMethodPriorityImpl.Builder paramBuilder)
  {
    this.a = ProviderMethodPriorityImpl.Builder.a(paramBuilder);
    this.b = ProviderMethodPriorityImpl.Builder.b(paramBuilder);
    this.c = ProviderMethodPriorityImpl.Builder.c(paramBuilder);
    this.d = ProviderMethodPriorityImpl.Builder.d(paramBuilder);
    this.e = ProviderMethodPriorityImpl.Builder.e(paramBuilder);
  }
  
  public static ProviderMethodPriorityImpl f()
  {
    return f;
  }
  
  public static ProviderMethodPriorityImpl.Builder g()
  {
    return new ProviderMethodPriorityImpl.Builder(null);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl
 * JD-Core Version:    0.7.0.1
 */