package com.android.dx.util;

import java.io.FilterWriter;
import java.io.Writer;

public final class IndentingWriter
  extends FilterWriter
{
  private boolean collectingIndent;
  private int column;
  private int indent;
  private final int maxIndent;
  private final String prefix;
  private final int width;
  
  public IndentingWriter(Writer paramWriter, int paramInt)
  {
    this(paramWriter, paramInt, "");
  }
  
  public IndentingWriter(Writer paramWriter, int paramInt, String paramString)
  {
    super(paramWriter);
    if (paramWriter == null) {
      throw new NullPointerException("out == null");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("width < 0");
    }
    if (paramString == null) {
      throw new NullPointerException("prefix == null");
    }
    if (paramInt != 0) {}
    for (int i = paramInt;; i = 2147483647)
    {
      this.width = i;
      this.maxIndent = (paramInt >> 1);
      paramWriter = paramString;
      if (paramString.length() == 0) {
        paramWriter = null;
      }
      this.prefix = paramWriter;
      bol();
      return;
    }
  }
  
  private void bol()
  {
    this.column = 0;
    if (this.maxIndent != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.collectingIndent = bool;
      this.indent = 0;
      return;
    }
  }
  
  public void write(int paramInt)
  {
    int i = 0;
    synchronized (this.lock)
    {
      if (this.collectingIndent)
      {
        if (paramInt != 32) {
          break label143;
        }
        this.indent += 1;
        if (this.indent >= this.maxIndent)
        {
          this.indent = this.maxIndent;
          this.collectingIndent = false;
        }
      }
      if ((this.column == this.width) && (paramInt != 10))
      {
        this.out.write(10);
        this.column = 0;
      }
      if (this.column != 0) {
        break label166;
      }
      if (this.prefix != null) {
        this.out.write(this.prefix);
      }
      if (this.collectingIndent) {
        break label166;
      }
      while (i < this.indent)
      {
        this.out.write(32);
        i += 1;
      }
      label143:
      this.collectingIndent = false;
    }
    this.column = this.indent;
    label166:
    this.out.write(paramInt);
    if (paramInt == 10) {
      bol();
    }
    for (;;)
    {
      return;
      this.column += 1;
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    localObject = this.lock;
    for (;;)
    {
      if (paramInt2 > 0) {}
      try
      {
        write(paramString.charAt(paramInt1));
        paramInt1 += 1;
        paramInt2 -= 1;
      }
      finally {}
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    localObject = this.lock;
    for (;;)
    {
      if (paramInt2 > 0) {}
      try
      {
        write(paramArrayOfChar[paramInt1]);
        paramInt1 += 1;
        paramInt2 -= 1;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.IndentingWriter
 * JD-Core Version:    0.7.0.1
 */