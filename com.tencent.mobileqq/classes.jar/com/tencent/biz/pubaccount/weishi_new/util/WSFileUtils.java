package com.tencent.biz.pubaccount.weishi_new.util;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.utils.FileUtils;

public class WSFileUtils
{
  public static <T extends JceStruct> T a(T paramT, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf8");
        paramT.readFrom(paramArrayOfByte);
        return paramT;
      }
      catch (Exception paramT)
      {
        paramT.printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean a(JceStruct paramJceStruct, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJceStruct != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramJceStruct = a(paramJceStruct);
      bool1 = bool2;
      if (paramJceStruct != null)
      {
        if (paramJceStruct.length <= 0) {
          return false;
        }
        bool1 = FileUtils.writeFile(paramJceStruct, paramString, false);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSFileUtils.java][saveDataToFile] path:");
        localStringBuilder.append(paramString);
        WSLog.a("WSFileUtils", localStringBuilder.toString());
        paramString = new StringBuilder();
        paramString.append("[WSFileUtils.java][saveDataToFile] writeSuccess:");
        paramString.append(bool1);
        paramString.append(", bytesLength:");
        paramString.append(paramJceStruct.length);
        WSLog.d("WSFileUtils", paramString.toString());
      }
    }
    return bool1;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    if (paramJceStruct != null) {
      try
      {
        JceOutputStream localJceOutputStream = new JceOutputStream();
        localJceOutputStream.setServerEncoding("utf8");
        paramJceStruct.writeTo(localJceOutputStream);
        paramJceStruct = localJceOutputStream.toByteArray();
        return paramJceStruct;
      }
      catch (Exception paramJceStruct)
      {
        paramJceStruct.printStackTrace();
      }
    }
    return null;
  }
  
  public static <T extends JceStruct> T b(T paramT, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramT, FileUtils.readFile(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils
 * JD-Core Version:    0.7.0.1
 */