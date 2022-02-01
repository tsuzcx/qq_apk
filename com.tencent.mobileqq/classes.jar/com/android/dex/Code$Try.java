package com.android.dex;

public class Code$Try
{
  final int catchHandlerIndex;
  final int instructionCount;
  final int startAddress;
  
  Code$Try(int paramInt1, int paramInt2, int paramInt3)
  {
    this.startAddress = paramInt1;
    this.instructionCount = paramInt2;
    this.catchHandlerIndex = paramInt3;
  }
  
  public int getCatchHandlerIndex()
  {
    return this.catchHandlerIndex;
  }
  
  public int getInstructionCount()
  {
    return this.instructionCount;
  }
  
  public int getStartAddress()
  {
    return this.startAddress;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Code.Try
 * JD-Core Version:    0.7.0.1
 */