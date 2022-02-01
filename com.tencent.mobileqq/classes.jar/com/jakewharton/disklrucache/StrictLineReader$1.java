package com.jakewharton.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader$1
  extends ByteArrayOutputStream
{
  StrictLineReader$1(StrictLineReader paramStrictLineReader, int paramInt)
  {
    super(paramInt);
  }
  
  public String toString()
  {
    int i;
    if ((this.count > 0) && (this.buf[(this.count - 1)] == 13)) {
      i = this.count - 1;
    } else {
      i = this.count;
    }
    try
    {
      String str = new String(this.buf, 0, i, StrictLineReader.access$000(this.this$0).name());
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jakewharton.disklrucache.StrictLineReader.1
 * JD-Core Version:    0.7.0.1
 */