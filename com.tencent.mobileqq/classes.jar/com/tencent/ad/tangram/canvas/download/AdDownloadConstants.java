package com.tencent.ad.tangram.canvas.download;

import android.support.annotation.Keep;

@Keep
public final class AdDownloadConstants
{
  public static final int ACTION_CANCEL = 10;
  public static final int ACTION_DOWNLOAD = 2;
  public static final int ACTION_INSTALL = 5;
  public static final int ACTION_LANDINGPAGE_APP_DATA_FAILED = 37;
  public static final int ACTION_LANDINGPAGE_APP_DATA_SUCCESS = 36;
  public static final int ACTION_MOBILEAPP_AD_APP_DOWN_PAUSED = 238;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_ALREADY_DOWNLOAD = 270;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_AUTO_CREATE_DOWNLOAD = 269;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_CONTINUE_DOWNLOAD = 271;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_FINISH_DOWNLOAD = 274;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_MATCH = 275;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_NOT_MATCH = 276;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_MANUAL_CREATE_DOWNLOAD = 268;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_NEW_DOWNLOAD = 272;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_PAUSE_DOWNLOAD = 273;
  public static final int ACTION_PAUSE = 3;
  public static final int ACTION_UPDATE = 12;
  public static final int CONFIG_ONLY_SDK = 0;
  public static final String DOWNLOAD_SOURCE_AD = "biz_src_ads";
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
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.AdDownloadConstants
 * JD-Core Version:    0.7.0.1
 */