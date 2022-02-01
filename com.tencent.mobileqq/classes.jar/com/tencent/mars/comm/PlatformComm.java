package com.tencent.mars.comm;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class PlatformComm
{
  public static final int EMobile = 2;
  public static final int ENoNet = -1;
  public static final int EOtherNet = 3;
  public static final int EWifi = 1;
  private static final boolean IS_PROXY_ON = false;
  public static final int NETTYPE_2G = 3;
  public static final int NETTYPE_3G = 4;
  public static final int NETTYPE_4G = 5;
  public static final int NETTYPE_5G = 7;
  public static final int NETTYPE_NON = -1;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_UNKNOWN = 6;
  public static final int NETTYPE_WAP = 2;
  public static final int NETTYPE_WIFI = 1;
  private static final String TAG = "PlatformComm";
  private static Context context;
  public static PlatformComm.IReportCrash reportCrashImp;
  public static PlatformComm.IResetProcess resetprocessimp;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.comm.PlatformComm
 * JD-Core Version:    0.7.0.1
 */