package com.tencent.falco.base.libapi.downloader;

public abstract interface IDownLoaderErrorCode
{
  public static final int ERROR_DOWNLOAD_DELETE = -5009;
  public static final int ERROR_DOWNLOAD_PAUSE = -5010;
  public static final int ERROR_DOWNLOAD_RESUME = -5011;
  public static final int ERROR_FILE_NOT_EXIST = -5006;
  public static final int ERROR_NETWORK = -5004;
  public static final int ERROR_NOPROCESS_CALLBAK = -5020;
  public static final int ERROR_NOSTART = -5003;
  public static final int ERROR_NO_SPACE = -5008;
  public static final int ERROR_PARAM = -5000;
  public static final int ERROR_RENAME_FAIL = -5007;
  public static final int ERROR_RESUME = -5002;
  public static final int ERROR_START = -5001;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.downloader.IDownLoaderErrorCode
 * JD-Core Version:    0.7.0.1
 */