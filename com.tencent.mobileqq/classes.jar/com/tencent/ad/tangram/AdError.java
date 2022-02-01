package com.tencent.ad.tangram;

import android.support.annotation.Keep;

@Keep
public final class AdError
{
  public static final int ERROR_ABI_UNSUPPORTED = 9;
  public static final int ERROR_APP_INSTALLED = 19;
  public static final int ERROR_APP_NOT_INSTLLED = 12;
  public static final int ERROR_APP_PREORDER_QQREMINDER_RESCHEDULE_TOO_FREQUENTLY = 221;
  public static final int ERROR_APP_PREORDER_QQREMINDER_SWITCH_ON_TOO_FREQUENTLY = 220;
  public static final int ERROR_ARK_INVALID_VIEW = 207;
  public static final int ERROR_ARK_NOT_PUBLISHED = 209;
  public static final int ERROR_ARK_UPDATE = 208;
  public static final int ERROR_BROWSER_UNSUPPORTED = 301;
  public static final int ERROR_CANVAS_UNSUPPORTED = 302;
  public static final int ERROR_CHARSET_UNSUPPORTED = 11;
  public static final int ERROR_CRASH = 15;
  public static final int ERROR_DEVICE_UNSUPPORTED = 10;
  public static final int ERROR_EXTERNAL_STORAGE_STATE = 213;
  public static final int ERROR_GET_LAUNCH_INTENT_FOR_PACKAGE = 203;
  public static final int ERROR_HALF_SCREEN_PAGE_UNSUPPORTED = 306;
  public static final int ERROR_INTERNAL = 1;
  public static final int ERROR_INVALID_PARAMS = 4;
  public static final int ERROR_LOAD_LIBRARY = 6;
  public static final int ERROR_LOCK = 18;
  public static final int ERROR_NETWORK = 3;
  public static final int ERROR_NETWORK_ON_MAIN_THREAD = 8;
  public static final int ERROR_NOT_EXISTS = 16;
  public static final int ERROR_NO_CACHE = 7;
  public static final int ERROR_NO_CANVAS_JSON = 104;
  public static final int ERROR_NO_FILL = 101;
  public static final int ERROR_NO_OFFLINE = 105;
  public static final int ERROR_NO_SETTINGS = 106;
  public static final int ERROR_PROCESS = 20;
  public static final int ERROR_QQ_MINI_PROGRAM_UNSUPPORTED = 304;
  public static final int ERROR_RESOLVE_ACTIVITY = 204;
  public static final int ERROR_SERVER = 5;
  public static final int ERROR_START_ACTIVITY = 202;
  public static final int ERROR_SUCCESS = 0;
  public static final int ERROR_TAIDSDK_GET_ID = 206;
  public static final int ERROR_TAIDSDK_INIT = 205;
  public static final int ERROR_TIMEOUT = 13;
  public static final int ERROR_TOO_FREQUENTLY = 2;
  public static final int ERROR_UNSUPPORTED_VERSION = 14;
  public static final int ERROR_URI_PARSE = 201;
  public static final int ERROR_VIDEO_CEILING_UNSUPPORTED = 303;
  public static final int ERROR_VIDEO_SPLICE_UNSUPPORTED = 305;
  public static final int ERROR_WITHOUT_PERMISSION = 17;
  private int errorCode = -2147483648;
  private Throwable throwable;
  
  public AdError(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public AdError(int paramInt, Throwable paramThrowable)
  {
    this.errorCode = paramInt;
    this.throwable = paramThrowable;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public boolean isSuccess()
  {
    return getErrorCode() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.AdError
 * JD-Core Version:    0.7.0.1
 */