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
    if (paramInt < 30)
    {
      d = 0.0D;
    }
    else if (paramInt <= 16383)
    {
      d = paramInt;
      Double.isNaN(d);
      d = 64.0D * ((d - 30.0D) / 12737.0D);
    }
    return (int)d;
  }
  
  public static int calculateVolumn(byte[] paramArrayOfByte, int paramInt)
  {
    return calculateVolumn(calculateSum(paramArrayOfByte, paramInt));
  }
  
  public static void saveFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()));
    ((StringBuilder)localObject).append("/wxvoicerecord/");
    String str = ((StringBuilder)localObject).toString();
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new Date();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format((Date)localObject)));
    if (paramBoolean) {
      localObject = "_success";
    } else {
      localObject = "_fail";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    localObject = new File(str, localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      try
      {
        ((File)localObject).createNewFile();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = null;
    try
    {
      localObject = new FileOutputStream((File)localObject);
      paramString = (String)localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    if (paramString == null) {
      return;
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.util.Common
 * JD-Core Version:    0.7.0.1
 */