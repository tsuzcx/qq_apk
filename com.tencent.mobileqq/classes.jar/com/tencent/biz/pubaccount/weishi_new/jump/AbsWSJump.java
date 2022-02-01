package com.tencent.biz.pubaccount.weishi_new.jump;

import java.lang.ref.WeakReference;

public abstract class AbsWSJump
{
  private WeakReference<IWSStSchemaJumpFactor> a;
  
  public AbsWSJump(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    this.a = new WeakReference(paramIWSStSchemaJumpFactor);
  }
  
  public boolean a()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return false;
    }
    return a((IWSStSchemaJumpFactor)this.a.get());
  }
  
  public abstract boolean a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.AbsWSJump
 * JD-Core Version:    0.7.0.1
 */