package com.tencent.gathererga.tangram;

import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl;
import com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl.Builder;

public class TangramIDSetting
{
  private boolean a = true;
  private ProviderMethodPriority b = ProviderMethodPriorityImpl.g().a().d().e().g();
  private ProviderMethodPriority c = ProviderMethodPriorityImpl.g().b().g();
  private TangramIDSetting.Params d = null;
  
  public void a(ProviderMethodPriority paramProviderMethodPriority)
  {
    this.c = paramProviderMethodPriority;
  }
  
  public void a(TangramIDSetting.Params paramParams)
  {
    this.d = paramParams;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public ProviderMethodPriority b()
  {
    return this.c;
  }
  
  public void b(ProviderMethodPriority paramProviderMethodPriority)
  {
    this.b = paramProviderMethodPriority;
  }
  
  public ProviderMethodPriority c()
  {
    return this.b;
  }
  
  public TangramIDSetting.Params d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.tangram.TangramIDSetting
 * JD-Core Version:    0.7.0.1
 */