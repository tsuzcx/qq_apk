package com.android.dx.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class TwoColumnOutput
{
  private final StringBuffer leftBuf;
  private final IndentingWriter leftColumn;
  private final int leftWidth;
  private final Writer out;
  private final StringBuffer rightBuf;
  private final IndentingWriter rightColumn;
  
  public TwoColumnOutput(OutputStream paramOutputStream, int paramInt1, int paramInt2, String paramString)
  {
    this(new OutputStreamWriter(paramOutputStream), paramInt1, paramInt2, paramString);
  }
  
  public TwoColumnOutput(Writer paramWriter, int paramInt1, int paramInt2, String paramString)
  {
    if (paramWriter == null) {
      throw new NullPointerException("out == null");
    }
    if (paramInt1 < 1) {
      throw new IllegalArgumentException("leftWidth < 1");
    }
    if (paramInt2 < 1) {
      throw new IllegalArgumentException("rightWidth < 1");
    }
    if (paramString == null) {
      throw new NullPointerException("spacer == null");
    }
    StringWriter localStringWriter1 = new StringWriter(1000);
    StringWriter localStringWriter2 = new StringWriter(1000);
    this.out = paramWriter;
    this.leftWidth = paramInt1;
    this.leftBuf = localStringWriter1.getBuffer();
    this.rightBuf = localStringWriter2.getBuffer();
    this.leftColumn = new IndentingWriter(localStringWriter1, paramInt1);
    this.rightColumn = new IndentingWriter(localStringWriter2, paramInt2, paramString);
  }
  
  private static void appendNewlineIfNecessary(StringBuffer paramStringBuffer, Writer paramWriter)
  {
    int i = paramStringBuffer.length();
    if ((i != 0) && (paramStringBuffer.charAt(i - 1) != '\n')) {
      paramWriter.write(10);
    }
  }
  
  private void flushLeft()
  {
    appendNewlineIfNecessary(this.leftBuf, this.leftColumn);
    while (this.leftBuf.length() != 0)
    {
      this.rightColumn.write(10);
      outputFullLines();
    }
  }
  
  private void flushRight()
  {
    appendNewlineIfNecessary(this.rightBuf, this.rightColumn);
    while (this.rightBuf.length() != 0)
    {
      this.leftColumn.write(10);
      outputFullLines();
    }
  }
  
  private void outputFullLines()
  {
    for (;;)
    {
      int i = this.leftBuf.indexOf("\n");
      if (i < 0) {}
      int j;
      do
      {
        return;
        j = this.rightBuf.indexOf("\n");
      } while (j < 0);
      if (i != 0) {
        this.out.write(this.leftBuf.substring(0, i));
      }
      if (j != 0)
      {
        writeSpaces(this.out, this.leftWidth - i);
        this.out.write(this.rightBuf.substring(0, j));
      }
      this.out.write(10);
      this.leftBuf.delete(0, i + 1);
      this.rightBuf.delete(0, j + 1);
    }
  }
  
  public static String toString(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    StringWriter localStringWriter = new StringWriter((paramString1.length() + paramString3.length()) * 3);
    paramString2 = new TwoColumnOutput(localStringWriter, paramInt1, paramInt2, paramString2);
    try
    {
      paramString2.getLeft().write(paramString1);
      paramString2.getRight().write(paramString3);
      paramString2.flush();
      return localStringWriter.toString();
    }
    catch (IOException paramString1)
    {
      throw new RuntimeException("shouldn't happen", paramString1);
    }
  }
  
  private static void writeSpaces(Writer paramWriter, int paramInt)
  {
    while (paramInt > 0)
    {
      paramWriter.write(32);
      paramInt -= 1;
    }
  }
  
  public void flush()
  {
    try
    {
      appendNewlineIfNecessary(this.leftBuf, this.leftColumn);
      appendNewlineIfNecessary(this.rightBuf, this.rightColumn);
      outputFullLines();
      flushLeft();
      flushRight();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public Writer getLeft()
  {
    return this.leftColumn;
  }
  
  public Writer getRight()
  {
    return this.rightColumn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.TwoColumnOutput
 * JD-Core Version:    0.7.0.1
 */