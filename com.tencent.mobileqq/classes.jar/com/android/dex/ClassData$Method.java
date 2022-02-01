package com.android.dex;

public class ClassData$Method
{
  private final int accessFlags;
  private final int codeOffset;
  private final int methodIndex;
  
  public ClassData$Method(int paramInt1, int paramInt2, int paramInt3)
  {
    this.methodIndex = paramInt1;
    this.accessFlags = paramInt2;
    this.codeOffset = paramInt3;
  }
  
  public int getAccessFlags()
  {
    return this.accessFlags;
  }
  
  public int getCodeOffset()
  {
    return this.codeOffset;
  }
  
  public int getMethodIndex()
  {
    return this.methodIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.ClassData.Method
 * JD-Core Version:    0.7.0.1
 */