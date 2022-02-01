package com.tencent.gathererga.core.internal.provider;

public final class ProviderMethodPriorityImpl$Builder
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private boolean d = true;
  private boolean e = true;
  
  public final Builder a()
  {
    this.a = 4;
    return this;
  }
  
  public final Builder a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public final Builder b()
  {
    this.a = 1;
    return this;
  }
  
  public final Builder b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public final Builder c()
  {
    this.b = 2;
    return this;
  }
  
  public final Builder d()
  {
    this.b = 1;
    return this;
  }
  
  public final Builder e()
  {
    this.c = 2;
    return this;
  }
  
  public final Builder f()
  {
    this.c = 1;
    return this;
  }
  
  public final ProviderMethodPriorityImpl g()
  {
    return new ProviderMethodPriorityImpl(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl.Builder
 * JD-Core Version:    0.7.0.1
 */