package com.tencent.aekit.openrender.internal;

import java.util.List;

public abstract class AEChainI
{
  protected boolean mIsApplied = false;
  
  public List<String> AI()
  {
    return null;
  }
  
  public void apply() {}
  
  public final void applyChain()
  {
    apply();
    this.mIsApplied = true;
  }
  
  public void clear() {}
  
  public String filterName()
  {
    return getClass().getName();
  }
  
  public boolean isApplied()
  {
    return this.mIsApplied;
  }
  
  public abstract Frame render(Frame paramFrame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.AEChainI
 * JD-Core Version:    0.7.0.1
 */