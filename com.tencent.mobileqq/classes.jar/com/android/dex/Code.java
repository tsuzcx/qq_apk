package com.android.dex;

public final class Code
{
  private final Code.CatchHandler[] catchHandlers;
  private final int debugInfoOffset;
  private final int insSize;
  private final short[] instructions;
  private final int outsSize;
  private final int registersSize;
  private final Code.Try[] tries;
  
  public Code(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort, Code.Try[] paramArrayOfTry, Code.CatchHandler[] paramArrayOfCatchHandler)
  {
    this.registersSize = paramInt1;
    this.insSize = paramInt2;
    this.outsSize = paramInt3;
    this.debugInfoOffset = paramInt4;
    this.instructions = paramArrayOfShort;
    this.tries = paramArrayOfTry;
    this.catchHandlers = paramArrayOfCatchHandler;
  }
  
  public Code.CatchHandler[] getCatchHandlers()
  {
    return this.catchHandlers;
  }
  
  public int getDebugInfoOffset()
  {
    return this.debugInfoOffset;
  }
  
  public int getInsSize()
  {
    return this.insSize;
  }
  
  public short[] getInstructions()
  {
    return this.instructions;
  }
  
  public int getOutsSize()
  {
    return this.outsSize;
  }
  
  public int getRegistersSize()
  {
    return this.registersSize;
  }
  
  public Code.Try[] getTries()
  {
    return this.tries;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Code
 * JD-Core Version:    0.7.0.1
 */