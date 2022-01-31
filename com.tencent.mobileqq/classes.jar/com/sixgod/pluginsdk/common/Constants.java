package com.sixgod.pluginsdk.common;

import android.os.Build.VERSION;

public class Constants
{
  public static final int ANDROID_VERSION = Build.VERSION.SDK_INT;
  public static final String CRASH_ACTION = "com.sixgod.plugin.crash";
  public static final boolean DEBUG = false;
  public static final Boolean DEBUG_LOG = Boolean.valueOf(true);
  public static final String KEY_APK_PATH = "apk_name";
  public static final String KEY_BID = "bid";
  public static final String KEY_CLASS_NAME = "className";
  public static final String KEY_CRASH_EX = "ex";
  public static final String KEY_ERROR_CODE = "errorcode";
  public static final String KEY_ERROR_MSG = "errormsg";
  public static final String KEY_EXP_PROCESS_NAME = "expPName";
  public static final String KEY_FLAG_RESOURCES = "resourceFlag";
  public static final String KEY_INIT_WORK = "init_work";
  public static final String KEY_INNER_INTENT = "plugin_intent";
  public static final String KEY_IS_LAUNCHER_ACTIVITY = "is_launcher_activity";
  public static final String KEY_IS_MAIN = "is_main";
  public static final String KEY_IS_SPECIAL_ACTIVITY = "is_special_activity";
  public static final String KEY_LAUNCH_CALLBACK_ACTION = "callback";
  public static final String KEY_LAUNCH_WORK = "launch_work";
  public static final String KEY_LOAD_PARAMS = "plugin_load_params";
  public static final String KEY_LOAD_PLUGIN_TRY_IDX = "load_plugin_retry_idx";
  public static final String KEY_NEED_LIBS = "neddLibs";
  public static final String KEY_PKG_NAME = "packageName";
  public static final String KEY_PLUGIN_ID = "plugin_id";
  public static final String KEY_PROCESS_NAME = "processName";
  public static final String KEY_SPECIAL_TYPE = "special_type";
  public static final String KEY_THREAD_ID = "threadId";
  public static final String KEY_THREAD_NAME = "threadName";
  public static final String KEY_USE_ACTIONBAR = "use_actionbar";
  public static final int MAX_RETRY_TIME = 2;
  public static final String SP_PLUGIN_ZIP_VERSION = "sp_plugin_zip_version";
  public static final String TAG = "SixGod_PluginSdk";
  public static final String TAG_REPORT = "SixGod_PluginSdk.report";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.common.Constants
 * JD-Core Version:    0.7.0.1
 */