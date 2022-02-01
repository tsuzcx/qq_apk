package com.qq.wx.voice.embedqqegg.util;

import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common
{
  public static int calculateSum(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return j;
      }
      j += Math.abs((short)((paramArrayOfByte[(i + 1)] & 0xFF) << 8 | paramArrayOfByte[i] & 0xFF)) / (paramInt / 2);
      i += 2;
    }
  }
  
  public static int calculateVolumn(int paramInt)
  {
    double d = 64.0D;
    if (paramInt < 30) {
      d = 0.0D;
    }
    for (;;)
    {
      return (int)d;
      if (paramInt <= 16383) {
        d = 64.0D * ((paramInt - 30.0D) / 12737.0D);
      }
    }
  }
  
  public static int calculateVolumn(byte[] paramArrayOfByte, int paramInt)
  {
    return calculateVolumn(calculateSum(paramArrayOfByte, paramInt));
  }
  
  public static void saveFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      String str = Environment.getExternalStorageDirectory().getPath() + "/wxvoicerecord/";
      Object localObject = new File(str);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new Date();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format((Date)localObject)));
      if (paramBoolean)
      {
        localObject = "_success";
        label93:
        paramString = new File(str, (String)localObject + "." + paramString);
        if (paramString.exists()) {}
      }
      try
      {
        paramString.createNewFile();
      }
      catch (IOException localIOException)
      {
        try
        {
          for (;;)
          {
            paramString = new FileOutputStream(paramString);
            if (paramString == null) {
              break;
            }
            try
            {
              paramString.write(paramArrayOfByte, 0, paramArrayOfByte.length);
              paramString.close();
              return;
            }
            catch (IOException paramArrayOfByte)
            {
              paramArrayOfByte.printStackTrace();
              return;
            }
            localObject = "_fail";
            break label93;
            localIOException = localIOException;
            localIOException.printStackTrace();
          }
        }
        catch (FileNotFoundException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.util.Common
 * JD-Core Version:    0.7.0.1
 */