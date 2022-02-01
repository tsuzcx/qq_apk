package com.tencent.biz.qqstory.takevideo.tools.audio;

import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;

public class BGMEffectAsset
  extends AudioAsset
{
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int g;
  private int h;
  
  public void a()
  {
    try
    {
      super.a();
      this.jdField_a_of_type_Boolean = false;
      notifyAll();
      System.gc();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @RequiresApi(api=16)
  public byte[] a(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = null;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BGMEffectAsset", 2, "onLoopData , startTime : " + paramInt1 + "  endTime : " + paramInt2);
      }
      long l = SystemClock.elapsedRealtime();
      int i = this.h;
      if (paramInt1 != i) {}
      while (paramInt2 <= paramInt1) {
        return arrayOfByte1;
      }
      paramInt1 = this.d * this.f * this.e / 1000 * (paramInt2 - paramInt1);
      if (paramInt1 > this.jdField_a_of_type_ArrayOfByte.length) {
        paramInt1 = this.jdField_a_of_type_ArrayOfByte.length;
      }
      for (;;)
      {
        arrayOfByte1 = new byte[paramInt1];
        System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte1, 0, paramInt1);
        byte[] arrayOfByte2 = new byte[this.jdField_a_of_type_ArrayOfByte.length - paramInt1];
        System.arraycopy(this.jdField_a_of_type_ArrayOfByte, paramInt1, arrayOfByte2, 0, arrayOfByte2.length);
        this.jdField_a_of_type_ArrayOfByte = arrayOfByte2;
        this.h = paramInt2;
        if (QLog.isColorLevel()) {
          QLog.d("BGMEffectAsset", 2, "onLoopData  mCachedData.length : " + this.jdField_a_of_type_ArrayOfByte.length + " handle data cost time : " + (SystemClock.elapsedRealtime() - l));
        }
        notifyAll();
        break;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.BGMEffectAsset
 * JD-Core Version:    0.7.0.1
 */