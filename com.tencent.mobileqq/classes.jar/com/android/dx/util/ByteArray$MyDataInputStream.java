package com.android.dx.util;

import java.io.DataInputStream;

public class ByteArray$MyDataInputStream
  extends DataInputStream
{
  private final ByteArray.MyInputStream wrapped;
  
  public ByteArray$MyDataInputStream(ByteArray.MyInputStream paramMyInputStream)
  {
    super(paramMyInputStream);
    this.wrapped = paramMyInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.ByteArray.MyDataInputStream
 * JD-Core Version:    0.7.0.1
 */