package com.tencent.hippy.qq.api;

public abstract interface UpdateRetCode
{
  public static final int FAILED_GETCONFIG = -2;
  public static final int FAILED_LOADBUNDLE = -4;
  public static final int FAILED_LOADBUNDLE_FILE_NOT_EXIST = -7;
  public static final int FAILED_LOADBUNDLE_MAX_FAILED = -5;
  public static final int FAILED_LOADBUNDLE_UNZIP_FAILED = -6;
  public static final int FAILED_MD5 = -3;
  public static final int FAILED_UNZIP = -1;
  public static final int SUCC = 0;
  public static final int SUCC_FILE_EXIST = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.UpdateRetCode
 * JD-Core Version:    0.7.0.1
 */