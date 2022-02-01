package com.android.dx.io.instructions;

public abstract interface CodeInput
  extends CodeCursor
{
  public abstract boolean hasMore();
  
  public abstract int read();
  
  public abstract int readInt();
  
  public abstract long readLong();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.CodeInput
 * JD-Core Version:    0.7.0.1
 */