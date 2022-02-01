package com.tencent.hippy.qq.update.tool.v;

public class VersionConfiguration
{
  public static final int BUFFER_SIZE = 32768;
  public static byte[] BYTE_4 = new byte[4];
  public static byte[] BYTE_8 = new byte[8];
  public static byte[] BYTE_BUFFER = new byte[32768];
  public static final int COMPRESS_LEVEL = 3;
  public static int CURRENT_VERSION = 1;
  public static final String ENCODE = "utf-8";
  
  public static boolean isQBDAvalible(int paramInt)
  {
    return paramInt <= CURRENT_VERSION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.v.VersionConfiguration
 * JD-Core Version:    0.7.0.1
 */