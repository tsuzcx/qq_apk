package com.android.dx.rop.type;

import com.android.dx.util.ToHuman;

public abstract interface TypeBearer
  extends ToHuman
{
  public abstract int getBasicFrameType();
  
  public abstract int getBasicType();
  
  public abstract TypeBearer getFrameType();
  
  public abstract Type getType();
  
  public abstract boolean isConstant();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.type.TypeBearer
 * JD-Core Version:    0.7.0.1
 */