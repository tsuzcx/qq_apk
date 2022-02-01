package com.tencent.chirp;

import android.util.Pair;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

public class ChirpWrapper
{
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int;
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    try
    {
      if (jdField_a_of_type_Boolean) {
        return true;
      }
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(MobileQQ.getContext().getFilesDir().getParent());
        ((StringBuilder)localObject1).append("/chirp/");
        ((StringBuilder)localObject1).append("libQChirp.so");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (new File((String)localObject1).exists())
        {
          System.load((String)localObject1);
          jdField_a_of_type_Boolean = true;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ChirpWrapper", 2, "so not exist");
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChirpWrapper", 2, "loadLibrary error", localException);
        }
        jdField_a_of_type_Boolean = false;
      }
      boolean bool = jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    String str2 = null;
    String str1 = str2;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      str1 = str2;
      localStringBuilder.append(MobileQQ.getContext().getFilesDir().getParent());
      str1 = str2;
      localStringBuilder.append("/chirp");
      str1 = str2;
      str2 = localStringBuilder.toString();
      str1 = str2;
      FileUtils.uncompressZip(paramString, str2, false);
      return true;
    }
    catch (IOException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpWrapper", 2, "unzipSo error", paramString);
      }
      try
      {
        paramString = new StringBuilder();
        paramString.append(str1);
        paramString.append("/");
        paramString.append("libQChirp.so");
        new File(paramString.toString()).delete();
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChirpWrapper", 2, "delete error", paramString);
        }
      }
      return false;
      label143:
      throw paramString;
    }
    finally
    {
      break label143;
    }
  }
  
  private static native int createChirp();
  
  private static native int decodeChirp(int paramInt1, short[] paramArrayOfShort, int paramInt2);
  
  private static native int encodeChirp(int paramInt1, String paramString, int paramInt2);
  
  private static native int getAudioLength(int paramInt);
  
  private static native int getAudioSample(int paramInt1, short[] paramArrayOfShort, int paramInt2);
  
  private static native String getDecodeString(int paramInt);
  
  private static native int getDecodeStringLen(int paramInt);
  
  private static native int releaseChirp(int paramInt);
  
  public int a()
  {
    if (!jdField_a_of_type_Boolean) {
      return -2;
    }
    try
    {
      this.jdField_a_of_type_Int = createChirp();
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpWrapper", 2, "", localException);
      }
    }
    return -1;
  }
  
  public Pair<Integer, short[]> a(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {
      return new Pair(Integer.valueOf(-2), null);
    }
    int i = encodeChirp(this.jdField_a_of_type_Int, paramString, paramString.length());
    if (i != 0) {
      return new Pair(Integer.valueOf(i), null);
    }
    i = getAudioLength(this.jdField_a_of_type_Int);
    paramString = new short[i];
    return new Pair(Integer.valueOf(getAudioSample(this.jdField_a_of_type_Int, paramString, i)), paramString);
  }
  
  public String a(short[] paramArrayOfShort, int paramInt)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    if ((decodeChirp(this.jdField_a_of_type_Int, paramArrayOfShort, paramArrayOfShort.length) == 0) && (getDecodeStringLen(this.jdField_a_of_type_Int) == paramInt)) {
      return getDecodeString(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      releaseChirp(this.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.chirp.ChirpWrapper
 * JD-Core Version:    0.7.0.1
 */