package com.tencent.gathererga.core;

import com.tencent.gathererga.core.internal.IBase;

public abstract interface TuringProvider
  extends IBase
{
  public abstract ProviderResult getAIDTicket(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getTAIDTicket(ProviderMethodPriority paramProviderMethodPriority);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.TuringProvider
 * JD-Core Version:    0.7.0.1
 */