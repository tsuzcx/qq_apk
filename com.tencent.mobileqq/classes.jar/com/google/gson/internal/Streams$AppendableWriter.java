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
    this.currentWrite.chars = paramArrayOfChar;
    this.appendable.append(this.currentWrite, paramInt1, paramInt1 + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.Streams.AppendableWriter
 * JD-Core Version:    0.7.0.1
 */