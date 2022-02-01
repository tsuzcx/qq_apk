package com.tencent.hippy.qq.update.qarchive.tools.zip;

public abstract interface UnixStat
{
  public static final int DEFAULT_DIR_PERM = 493;
  public static final int DEFAULT_FILE_PERM = 420;
  public static final int DEFAULT_LINK_PERM = 511;
  public static final int DIR_FLAG = 16384;
  public static final int FILE_FLAG = 32768;
  public static final int LINK_FLAG = 40960;
  public static final int PERM_MASK = 4095;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.UnixStat
 * JD-Core Version:    0.7.0.1
 */