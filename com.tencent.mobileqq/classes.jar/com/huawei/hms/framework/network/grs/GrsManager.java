package com.huawei.hms.framework.network.grs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.BasePlugin;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import java.io.IOException;

public class GrsManager
  implements BasePlugin
{
  private static final int GRS_KEY_INDEX = 1;
  private static final int GRS_PATH_INDEX = 2;
  private static final String GRS_SCHEMA = "grs://";
  private static final int GRS_SERVICE_INDEX = 0;
  private static final int MAX_GRS_SPLIT = 3;
  private static final String SEPARATOR = "/";
  private static final String TAG = "GrsManager";
  @SuppressLint({"StaticFieldLeak"})
  private static volatile GrsManager instance;
  private GrsConfig grsConfig;
  private e grsInterceptor;
  
  public static GrsManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new GrsManager();
      }
      return instance;
    }
    finally {}
  }
  
  private String getServiceNameUrl(String paramString1, String paramString2)
  {
    return GrsApi.synGetGrsUrl(paramString1, paramString2);
  }
  
  public static boolean isGRSSchema(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("grs://"));
  }
  
  private String[] parseGRSSchema(String paramString)
  {
    return paramString.substring(paramString.toLowerCase().indexOf("grs://") + "grs://".length()).split("/", 3);
  }
  
  public PluginInterceptor getInterceptor()
  {
    if (this.grsInterceptor == null) {
      this.grsInterceptor = new e();
    }
    return this.grsInterceptor;
  }
  
  public boolean initGrs(Context paramContext, GrsConfig paramGrsConfig)
  {
    if ((this.grsConfig == null) || (!this.grsConfig.equal(paramGrsConfig)))
    {
      this.grsConfig = paramGrsConfig;
      paramGrsConfig = paramContext;
      if (paramContext != null) {
        paramGrsConfig = paramContext.getApplicationContext();
      }
      if (this.grsConfig == null) {
        break label58;
      }
    }
    label58:
    for (paramContext = this.grsConfig.getGrsBaseInfo(paramGrsConfig);; paramContext = null)
    {
      GrsApi.grsSdkInit(paramGrsConfig, paramContext);
      return true;
    }
  }
  
  protected String parseGrs(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith("/")) {
      str = paramString.substring(paramString.indexOf("grs://"), paramString.length() - 1);
    }
    String[] arrayOfString = parseGRSSchema(str);
    paramString = "";
    if (arrayOfString.length == 1) {
      paramString = getServiceNameUrl(arrayOfString[0], "ROOT");
    }
    while (TextUtils.isEmpty(paramString))
    {
      throw new IOException("can not get url, do grsUrl(serviceName or key) error?");
      if (arrayOfString.length >= 2) {
        paramString = getServiceNameUrl(arrayOfString[0], arrayOfString[1]);
      } else {
        Logger.i("GrsManager", "parseGrs params.length<1.");
      }
    }
    str = paramString;
    if (arrayOfString.length > 2)
    {
      if (paramString.endsWith("/")) {
        str = paramString + arrayOfString[2];
      }
    }
    else {
      return str;
    }
    return paramString + "/" + arrayOfString[2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsManager
 * JD-Core Version:    0.7.0.1
 */