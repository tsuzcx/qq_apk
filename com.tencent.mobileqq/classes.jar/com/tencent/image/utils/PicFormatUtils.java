package com.tencent.image.utils;

import com.tencent.image.URLDrawable;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.FileInputStream;
import java.io.IOException;

public class PicFormatUtils
{
  public static final String TAG = "URLDrawable.PicFormatUtils";
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      Object localObject = new char[paramArrayOfByte.length * 2];
      int i = 0;
      try
      {
        while (i < paramArrayOfByte.length)
        {
          int k = paramArrayOfByte[i];
          int j = i * 2;
          localObject[(j + 1)] = digits[(k & 0xF)];
          k = (byte)(k >>> 4);
          localObject[(j + 0)] = digits[(k & 0xF)];
          i += 1;
        }
        return new String((char[])localObject);
      }
      catch (Exception paramArrayOfByte)
      {
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localObject = URLDrawable.depImp.mLog;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" === bytes2HexStr error === ");
          localStringBuilder.append(paramArrayOfByte.toString());
          ((ILog)localObject).d("HexUtil", 2, localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  public static String getTypeByStream(FileInputStream paramFileInputStream)
  {
    Object localObject = new byte[8];
    try
    {
      paramFileInputStream.read((byte[])localObject, 0, localObject.length);
    }
    catch (IOException paramFileInputStream)
    {
      paramFileInputStream.printStackTrace();
    }
    localObject = bytes2HexStr((byte[])localObject).toUpperCase();
    if (((String)localObject).contains("FFD8FF")) {
      return "jpg";
    }
    if (((String)localObject).contains("89504E470D0A1A0A")) {
      return "png";
    }
    if (((String)localObject).contains("47494638")) {
      return "gif";
    }
    if (((String)localObject).contains("49492A00")) {
      return "tif";
    }
    if (((String)localObject).contains("424D")) {
      return "bmp";
    }
    if (((String)localObject).contains("0A")) {
      return "pcx";
    }
    if ((!((String)localObject).contains("4D4D")) && (!((String)localObject).contains("4949")))
    {
      if (((String)localObject).contains("464F524D")) {
        return "iff";
      }
      if (((String)localObject).contains("52494646")) {
        return "ani";
      }
      if (((String)localObject).contains("0000020000")) {
        return "tga";
      }
      if (((String)localObject).contains("0000100000")) {
        return "rle";
      }
      if (((String)localObject).contains("0000010001002020")) {
        return "ico";
      }
      paramFileInputStream = (FileInputStream)localObject;
      if (((String)localObject).contains("0000020001002020")) {
        return "cur";
      }
    }
    else
    {
      paramFileInputStream = "tiff";
    }
    return paramFileInputStream;
  }
  
  public static boolean isJPEGImage(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      paramString = new FileInputStream(paramString);
      bool1 = bool2;
      bool2 = "jpg".equals(getTypeByStream(paramString));
      bool1 = bool2;
      paramString.close();
      return bool2;
    }
    catch (Exception paramString)
    {
      URLDrawable.depImp.mLog.e("URLDrawable.PicFormatUtils", 2, "isJPEGImage", paramString);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.utils.PicFormatUtils
 * JD-Core Version:    0.7.0.1
 */