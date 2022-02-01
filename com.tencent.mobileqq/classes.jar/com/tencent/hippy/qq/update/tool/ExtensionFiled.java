package com.tencent.hippy.qq.update.tool;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

public class ExtensionFiled
  extends QIO
{
  public static String DEFAULT_KEY_ENCODE = "encode";
  public static String DEFAULT_KEY_UNCOMPRESS = "uncompress";
  public static final String DEFAULT_VALUE_ENCODE = "utf-8";
  public static final int HEADER_EX = 1;
  public static final int HEADER_NO_EX = 0;
  public String key;
  public String value;
  
  public void md5Ex(MessageDigest paramMessageDigest)
  {
    md5String(paramMessageDigest, this.key);
    md5String(paramMessageDigest, this.value);
  }
  
  public void readEx(InputStream paramInputStream)
  {
    this.key = readString(paramInputStream);
    this.value = readString(paramInputStream);
  }
  
  public void setEx(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public void writeEx(OutputStream paramOutputStream)
  {
    writeString(paramOutputStream, this.key);
    writeString(paramOutputStream, this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.ExtensionFiled
 * JD-Core Version:    0.7.0.1
 */