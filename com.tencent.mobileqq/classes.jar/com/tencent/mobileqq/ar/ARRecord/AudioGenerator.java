package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioGenerator
{
  BufferedInputStream a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f = 0;
  
  public AudioGenerator(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = new BufferedInputStream(new FileInputStream(paramString));
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = 0;
    paramInt1 = this.d;
    if (paramInt1 != 8)
    {
      if (paramInt1 == 16) {
        return;
      }
      throw new RuntimeException(String.format("bit deepth must be 8 or 16, current is %s", new Object[] { Integer.valueOf(paramInt1) }));
    }
  }
  
  public void a()
  {
    BufferedInputStream localBufferedInputStream = this.a;
    if (localBufferedInputStream != null) {
      try
      {
        localBufferedInputStream.close();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public byte[] a(long paramLong)
  {
    int i = (int)(paramLong * this.b / 1000L) * this.c * (this.d / 8);
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = new byte[i];
    i = this.a.read(arrayOfByte1, this.e, i);
    if (i != -1) {
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    }
    QLog.d("AudioGenerator", 4, String.format("read index:%s, len: %s", new Object[] { Integer.valueOf(this.f), Integer.valueOf(i) }));
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.AudioGenerator
 * JD-Core Version:    0.7.0.1
 */