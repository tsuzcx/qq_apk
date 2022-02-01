package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioGenerator
{
  private int jdField_a_of_type_Int;
  BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  private int b;
  private int c;
  private int d;
  private int e = 0;
  
  public AudioGenerator(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaIoBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString));
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = 0;
    paramInt1 = this.c;
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
    BufferedInputStream localBufferedInputStream = this.jdField_a_of_type_JavaIoBufferedInputStream;
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
    int i = (int)(paramLong * this.jdField_a_of_type_Int / 1000L) * this.b * (this.c / 8);
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = new byte[i];
    i = this.jdField_a_of_type_JavaIoBufferedInputStream.read(arrayOfByte1, this.d, i);
    if (i != -1) {
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    }
    QLog.d("AudioGenerator", 4, String.format("read index:%s, len: %s", new Object[] { Integer.valueOf(this.e), Integer.valueOf(i) }));
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.AudioGenerator
 * JD-Core Version:    0.7.0.1
 */