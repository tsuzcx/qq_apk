package com.android.dx.util;

public class MutabilityControl
{
  private boolean mutable;
  
  public MutabilityControl()
  {
    this.mutable = true;
  }
  
  public MutabilityControl(boolean paramBoolean)
  {
    this.mutable = paramBoolean;
  }
  
  public final boolean isImmutable()
  {
    return !this.mutable;
  }
  
  public final boolean isMutable()
  {
    return this.mutable;
  }
  
  public void setImmutable()
  {
    this.mutable = false;
  }
  
  public final void throwIfImmutable()
  {
    if (!this.mutable) {
      throw new MutabilityException("immutable instance");
    }
  }
  
  public final void throwIfMutable()
  {
    if (this.mutable) {
      throw new MutabilityException("mutable instance");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.MutabilityControl
 * JD-Core Version:    0.7.0.1
 */