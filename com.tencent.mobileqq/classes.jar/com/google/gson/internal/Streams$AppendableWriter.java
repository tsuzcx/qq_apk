package com.google.gson.internal;

import java.io.Writer;

final class Streams$AppendableWriter
  extends Writer
{
  private final Appendable appendable;
  private final Streams.AppendableWriter.CurrentWrite currentWrite = new Streams.AppendableWriter.CurrentWrite();
  
  Streams$AppendableWriter(Appendable paramAppendable)
  {
    this.appendable = paramAppendable;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public void write(int paramInt)
  {
    this.appendable.append((char)paramInt);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Streams.AppendableWriter.CurrentWrite localCurrentWrite = this.currentWrite;
    localCurrentWrite.chars = paramArrayOfChar;
    this.appendable.append(localCurrentWrite, paramInt1, paramInt2 + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.Streams.AppendableWriter
 * JD-Core Version:    0.7.0.1
 */