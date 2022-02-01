package com.android.dx.io.instructions;

public abstract interface CodeCursor
{
  public abstract int baseAddressForCursor();
  
  public abstract int cursor();
  
  public abstract void setBaseAddress(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.CodeCursor
 * JD-Core Version:    0.7.0.1
 */