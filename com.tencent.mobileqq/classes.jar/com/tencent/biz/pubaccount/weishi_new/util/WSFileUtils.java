package com.tencent.biz.pubaccount.weishi_new.util;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.utils.FileUtils;

public class WSFileUtils
{
  public static <T extends JceStruct> T a(T paramT, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramT, FileUtils.a(paramString));
  }
  
  public static <T extends JceStruct> T a(T paramT, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
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
    return null;
  }
  
  public static boolean a(JceStruct paramJceStruct, String paramString)
  {
    if ((paramJceStruct == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramJceStruct = a(paramJceStruct);
    } while ((paramJceStruct == null) || (paramJceStruct.length <= 0));
    boolean bool = FileUtils.a(paramJceStruct, paramString, false);
    WSLog.d("WSFileUtils", "[WSFileUtils.java][saveDataToFile] path:" + paramString + ", writeSuccess:" + bool + ", bytesLength:" + paramJceStruct.length);
    return bool;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils
 * JD-Core Version:    0.7.0.1
 */