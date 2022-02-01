package com.android.dx.rop.cst;

public abstract interface ConstantPool
{
  public abstract Constant get(int paramInt);
  
  public abstract Constant get0Ok(int paramInt);
  
  public abstract Constant[] getEntries();
  
  public abstract Constant getOrNull(int paramInt);
  
  public abstract int size();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.ConstantPool
 * JD-Core Version:    0.7.0.1
 */