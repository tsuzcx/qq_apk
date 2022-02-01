package com.tencent.kwstudio.office.preview;

import android.content.Context;
import com.tencent.kwstudio.office.base.IGlobal;
import com.tencent.kwstudio.office.base.ILog;

public abstract interface IHostInterface
{
  public static final String APP_ID_4_MQQ_ANDROID = "1001";
  public static final String CONFIG_KEY_DOCS_FONT_INFO = "docs_font_info";
  public static final String CONFIG_KEY_DOCS_PLUGIN_INFO = "docs_plugin_info";
  public static final String CONFIG_KEY_FACADE_PLUGIN_ENTRY_CLASS = "facade_plugin_entry_class";
  public static final String CONFIG_KEY_FACADE_PLUGIN_MD5 = "facade_plugin_md5";
  public static final String CONFIG_KEY_FACADE_PLUGIN_NAME = "facade_plugin_name";
  public static final String CONFIG_KEY_FACADE_PLUGIN_NAME_PREFIX = "facade_plugin_name_prefix";
  public static final String CONFIG_KEY_FACADE_PLUGIN_URL = "facade_plugin_url";
  public static final String CONFIG_KEY_GLOBAL_REQUIRED_RES_INFO = "global_required_res_info";
  public static final String CONFIG_KEY_PRE_LOAD_INFO = "pre_load_info";
  public static final String CONFIG_KEY_SHEETS_PLUGIN_INFO = "sheets_plugin_info";
  public static final String CONFIG_KEY_SLIDES_PLUGIN_INFO = "slides_plugin_info";
  public static final String CONFIG_KEY_SLIDES_RES_INFO = "slides_res_info";
  
  public abstract void commitPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract IGlobal createGlobal();
  
  public abstract ILog createLog();
  
  public abstract Object createRecyclerView(Context paramContext);
  
  public abstract Object createWebView(Context paramContext, IHostInterface.IWebClient paramIWebClient);
  
  public abstract void downloadResource(String paramString1, String paramString2, String paramString3, IHostInterface.IDownloadListener paramIDownloadListener);
  
  public abstract String getAppId();
  
  public abstract String getConfig(String paramString);
  
  public abstract String getUserId();
  
  public abstract void queryPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2, IHostInterface.IPreferencesCallback paramIPreferencesCallback);
  
  public abstract void reportEvent(String paramString1, int paramInt, String paramString2);
  
  public abstract void sendHttpRequest(String paramString1, boolean paramBoolean, String paramString2, IHostInterface.IHttpListener paramIHttpListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.IHostInterface
 * JD-Core Version:    0.7.0.1
 */