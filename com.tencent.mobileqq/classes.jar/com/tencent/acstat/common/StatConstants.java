package com.tencent.acstat.common;

import java.io.File;

public class StatConstants
{
  public static String DATABASE_NAME = "tencent_analysis.db";
  public static final String LBS_CLEAR_URL = "/lbs/cleargeo/v1";
  public static final String LBS_FULL_URL = "http://120.198.203.182:80";
  public static final String LBS_REGISTER_URL = "/lbs/reginfo/v1";
  public static final String LBS_REQUEST_URL = "/lbs/neighbor/v1";
  public static final String LBS_SERVER = "120.198.203.182:80";
  public static final String LBS_SERVER_HOST = "120.198.203.182";
  public static final int LBS_SERVER_PORT = 80;
  public static final String LOG_TAG = "MtaSDK";
  public static final String MTA_COOPERATION_TAG = "";
  public static final String MTA_DB2SP_TAG = "tencent_mta_sp_";
  public static final String MTA_REPORT_FULL_URL = "http://pingma.qq.com:80/mstat/report";
  public static final String MTA_SERVER = "pingma.qq.com:80";
  public static final String MTA_SERVER_HOST = "pingma.qq.com";
  public static final int MTA_SERVER_PORT = 80;
  public static final String MTA_STAT_URL = "/mstat/report";
  public static final String MTA_STORAGE_PRE_TAG;
  public static final int SDK_ONLINE_CONFIG_TYPE = 1;
  public static final int STAT_DB_VERSION = 3;
  public static final int USER_ONLINE_CONFIG_TYPE = 2;
  public static final String VERSION = "2.4.2";
  public static final int XG_PRO_VERSION = 1;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder("tencent.mta");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("data");
    MTA_STORAGE_PRE_TAG = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.StatConstants
 * JD-Core Version:    0.7.0.1
 */