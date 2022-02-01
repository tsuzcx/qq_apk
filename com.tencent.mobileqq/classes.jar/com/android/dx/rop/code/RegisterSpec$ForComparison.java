package com.android.dx.rop.code;

import com.android.dx.rop.type.TypeBearer;

class RegisterSpec$ForComparison
{
  private LocalItem local;
  private int reg;
  private TypeBearer type;
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RegisterSpec)) {
      return false;
    }
    return RegisterSpec.access$500((RegisterSpec)paramObject, this.reg, this.type, this.local);
  }
  
  public int hashCode()
  {
    return RegisterSpec.access$600(this.reg, this.type, this.local);
  }
  
  public void set(int paramInt, TypeBearer paramTypeBearer, LocalItem paramLocalItem)
  {
    this.reg = paramInt;
    this.type = paramTypeBearer;
    this.local = paramLocalItem;
  }
  
  public RegisterSpec toRegisterSpec()
  {
    return new RegisterSpec(this.reg, this.type, this.local, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.RegisterSpec.ForComparison
 * JD-Core Version:    0.7.0.1
 */