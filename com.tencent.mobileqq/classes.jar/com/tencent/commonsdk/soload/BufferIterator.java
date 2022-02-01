package com.tencent.commonsdk.soload;

public abstract class BufferIterator
{
  public abstract int readInt();
  
  public abstract short readShort();
  
  public abstract void seek(int paramInt);
  
  public abstract void skip(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.soload.BufferIterator
 * JD-Core Version:    0.7.0.1
 */