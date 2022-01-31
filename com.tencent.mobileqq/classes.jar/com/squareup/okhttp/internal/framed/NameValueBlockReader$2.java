package com.squareup.okhttp.internal.framed;

import java.util.zip.Inflater;

class NameValueBlockReader$2
  extends Inflater
{
  NameValueBlockReader$2(NameValueBlockReader paramNameValueBlockReader) {}
  
  public int inflate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = super.inflate(paramArrayOfByte, paramInt1, paramInt2);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (needsDictionary())
      {
        setDictionary(Spdy3.DICTIONARY);
        i = super.inflate(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.NameValueBlockReader.2
 * JD-Core Version:    0.7.0.1
 */