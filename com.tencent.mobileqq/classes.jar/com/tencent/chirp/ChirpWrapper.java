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
  private static boolean b = false;
  private int a;
  
  public static boolean a()
  {
    if (b) {
      return true;
    }
    try
    {
      if (b) {
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
          b = true;
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
        b = false;
      }
      boolean bool = b;
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
  
  public String a(short[] paramArrayOfShort, int paramInt)
  {
    if (!b) {
      return null;
    }
    if ((decodeChirp(this.a, paramArrayOfShort, paramArrayOfShort.length) == 0) && (getDecodeStringLen(this.a) == paramInt)) {
      return getDecodeString(this.a);
    }
    return null;
  }
  
  public int b()
  {
    if (!b) {
      return -2;
    }
    try
    {
      this.a = createChirp();
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
  
  public Pair<Integer, short[]> b(String paramString)
  {
    if (!b) {
      return new Pair(Integer.valueOf(-2), null);
    }
    int i = encodeChirp(this.a, paramString, paramString.length());
    if (i != 0) {
      return new Pair(Integer.valueOf(i), null);
    }
    i = getAudioLength(this.a);
    paramString = new short[i];
    return new Pair(Integer.valueOf(getAudioSample(this.a, paramString, i)), paramString);
  }
  
  public void c()
  {
    try
    {
      releaseChirp(this.a);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.chirp.ChirpWrapper
 * JD-Core Version:    0.7.0.1
 */