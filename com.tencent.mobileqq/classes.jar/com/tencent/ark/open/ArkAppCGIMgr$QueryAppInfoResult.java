package com.tencent.ark.open;

public class ArkAppCGIMgr$QueryAppInfoResult
{
  public static final int RET_APP_NOT_EXIST = 5;
  public static final int RET_APP_OFFLINE = -5;
  public static final int RET_APP_VIEW_ERROR = -8;
  public static final int RET_COPY_APP_FAIL = -3;
  public static final int RET_FAIL_NETWORK = -2;
  public static final int RET_LOADLIB_FAIL = -6;
  public static final int RET_META_CONTAIN_INVALID_URL = -4;
  public static final int RET_OTHER_ERROR = -1;
  public static final int RET_SDK_VER_TOO_HIGH = 7;
  public static final int RET_SDK_VER_TOO_LOW = 6;
  public static final int RET_SUCCESS = 0;
  public static final int RET_TIMEOUT = -7;
  public ArkAppInfo.AppDownloadInfo info;
  public String msg;
  public int retCode;
  public int state;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.QueryAppInfoResult
 * JD-Core Version:    0.7.0.1
 */