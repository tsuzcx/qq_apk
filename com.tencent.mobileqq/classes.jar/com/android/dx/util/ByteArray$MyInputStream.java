package com.android.dx.util;

import java.io.InputStream;

public class ByteArray$MyInputStream
  extends InputStream
{
  private int cursor = 0;
  private int mark = 0;
  
  public ByteArray$MyInputStream(ByteArray paramByteArray) {}
  
  public int available()
  {
    return ByteArray.access$000(this.this$0) - this.cursor;
  }
  
  public void mark(int paramInt)
  {
    this.mark = this.cursor;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (this.cursor >= ByteArray.access$000(this.this$0)) {
      return -1;
    }
    int i = ByteArray.access$100(this.this$0, this.cursor);
    this.cursor += 1;
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 + paramInt2 > paramArrayOfByte.length) {
      i = paramArrayOfByte.length - paramInt1;
    }
    int j = ByteArray.access$000(this.this$0) - this.cursor;
    paramInt2 = i;
    if (i > j) {
      paramInt2 = j;
    }
    System.arraycopy(ByteArray.access$200(this.this$0), this.cursor + ByteArray.access$300(this.this$0), paramArrayOfByte, paramInt1, paramInt2);
    this.cursor += paramInt2;
    return paramInt2;
  }
  
  public void reset()
  {
    this.cursor = this.mark;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.ByteArray.MyInputStream
 * JD-Core Version:    0.7.0.1
 */