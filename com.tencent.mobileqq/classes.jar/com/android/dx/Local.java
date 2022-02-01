package com.android.dx;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;

public final class Local<T>
{
  private final Code code;
  private int reg = -1;
  private RegisterSpec spec;
  final TypeId<T> type;
  
  private Local(Code paramCode, TypeId<T> paramTypeId)
  {
    this.code = paramCode;
    this.type = paramTypeId;
  }
  
  static <T> Local<T> get(Code paramCode, TypeId<T> paramTypeId)
  {
    return new Local(paramCode, paramTypeId);
  }
  
  public TypeId getType()
  {
    return this.type;
  }
  
  int initialize(int paramInt)
  {
    this.reg = paramInt;
    this.spec = RegisterSpec.make(paramInt, this.type.ropType);
    return size();
  }
  
  int size()
  {
    return this.type.ropType.getCategory();
  }
  
  RegisterSpec spec()
  {
    if (this.spec == null)
    {
      this.code.initializeLocals();
      if (this.spec == null) {
        throw new AssertionError();
      }
    }
    return this.spec;
  }
  
  public String toString()
  {
    return "v" + this.reg + "(" + this.type + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.Local
 * JD-Core Version:    0.7.0.1
 */