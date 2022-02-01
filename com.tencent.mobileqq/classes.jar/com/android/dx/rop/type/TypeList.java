package com.android.dx.rop.type;

public abstract interface TypeList
{
  public abstract Type getType(int paramInt);
  
  public abstract int getWordCount();
  
  public abstract boolean isMutable();
  
  public abstract int size();
  
  public abstract TypeList withAddedType(Type paramType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.type.TypeList
 * JD-Core Version:    0.7.0.1
 */