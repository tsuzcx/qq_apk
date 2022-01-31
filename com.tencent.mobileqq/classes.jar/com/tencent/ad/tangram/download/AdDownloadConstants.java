package com.tencent.ad.tangram.download;

import android.support.annotation.Keep;

@Keep
public final class AdDownloadConstants
{
  public static final int ACTION_DOWNLOAD = 2;
  public static final int DOWNLOAD_TYPE_DOWNLOADSDK = 0;
  public static String KEY = "big_brother_source_key";
  public static String KEY_REF_ID;
  public static String PARAM_ACTIONCODE;
  public static String PARAM_APPNAME;
  public static String PARAM_AUTO_DOWNLOAD;
  public static String PARAM_AUTO_INSTALL;
  public static String PARAM_BLOCK_NOTIFY;
  public static String PARAM_IS_APK;
  public static String PARAM_IS_AUTOINSTALL_BY_SDK;
  public static String PARAM_NOTIFYKEY;
  public static String PARAM_PATCH_UPDATE;
  public static String PARAM_SHOW_NETWORK_DIALOG;
  public static String PARAM_SHOW_NOTIFICATION;
  public static String PARAM_SNG_APPID;
  public static String PARAM_TASK_APK_ID;
  public static String PARAM_TASK_APPID;
  public static String PARAM_TASK_PACKNAME;
  public static String PARAM_TASK_VERSION;
  public static String PARAM_TICKET = "ticket";
  public static String PARAM_TO_PAGETYPE;
  public static String PARAM_URL;
  public static String PARAM_VIA;
  public static String PARAM_WORDING;
  public static String PARAM_WOWNLOAD_TYPE;
  public static String SRC_AD = "biz_src_ads";
  
  static
  {
    PARAM_SNG_APPID = "appId";
    PARAM_TASK_APPID = "taskAppId";
    PARAM_TASK_APK_ID = "taskApkId";
    PARAM_TASK_VERSION = "versionCode";
    PARAM_TASK_PACKNAME = "packageName";
    PARAM_AUTO_DOWNLOAD = "autoDownload";
    PARAM_AUTO_INSTALL = "autoInstall";
    PARAM_VIA = "via";
    PARAM_URL = "url";
    PARAM_ACTIONCODE = "actionCode";
    PARAM_APPNAME = "appName";
    PARAM_NOTIFYKEY = "notifyKey";
    PARAM_TO_PAGETYPE = "topagetype";
    PARAM_PATCH_UPDATE = "ispatchupdate";
    PARAM_WORDING = "wording";
    PARAM_WOWNLOAD_TYPE = "downloadType";
    PARAM_BLOCK_NOTIFY = "bolckNotify";
    PARAM_SHOW_NOTIFICATION = "sdkShowNotification";
    PARAM_IS_APK = "isApk";
    PARAM_SHOW_NETWORK_DIALOG = "showNetworkDialog";
    PARAM_IS_AUTOINSTALL_BY_SDK = "isAutoInstallBySdk";
    KEY_REF_ID = "big_brother_ref_source_key";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.download.AdDownloadConstants
 * JD-Core Version:    0.7.0.1
 */