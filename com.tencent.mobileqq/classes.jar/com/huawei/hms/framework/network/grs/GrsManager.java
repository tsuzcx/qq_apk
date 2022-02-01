package com.huawei.hms.framework.network.grs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.BasePlugin;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import java.io.IOException;
import java.util.Locale;

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
  private f grsInterceptor;
  
  public static GrsManager getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new GrsManager();
        }
      }
      finally {}
    }
    return instance;
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
    return StringUtils.substring(paramString, paramString.toLowerCase(Locale.ENGLISH).indexOf("grs://") + 6).split("/", 3);
  }
  
  public PluginInterceptor getInterceptor()
  {
    if (this.grsInterceptor == null) {
      this.grsInterceptor = new f();
    }
    return this.grsInterceptor;
  }
  
  public boolean initGrs(Context paramContext, GrsConfig paramGrsConfig)
  {
    GrsConfig localGrsConfig = this.grsConfig;
    if ((localGrsConfig == null) || (!localGrsConfig.equal(paramGrsConfig)))
    {
      this.grsConfig = paramGrsConfig;
      paramGrsConfig = null;
      if (paramContext != null) {
        paramContext = paramContext.getApplicationContext();
      } else {
        paramContext = null;
      }
      localGrsConfig = this.grsConfig;
      if (localGrsConfig != null) {
        paramGrsConfig = localGrsConfig.getGrsBaseInfo(paramContext);
      }
      GrsApi.grsSdkInit(paramContext, paramGrsConfig);
    }
    return true;
  }
  
  protected String parseGrs(String paramString)
  {
    Object localObject = paramString;
    if (paramString.endsWith("/")) {
      localObject = StringUtils.substring(paramString, paramString.indexOf("grs://"), paramString.length() - 1);
    }
    String[] arrayOfString = parseGRSSchema((String)localObject);
    if (arrayOfString.length == 1) {
      paramString = arrayOfString[0];
    }
    for (localObject = "ROOT";; localObject = arrayOfString[1])
    {
      paramString = getServiceNameUrl(paramString, (String)localObject);
      break label84;
      if (arrayOfString.length < 2) {
        break;
      }
      paramString = arrayOfString[0];
    }
    Logger.i("GrsManager", "parseGrs params.length<1.");
    paramString = "";
    label84:
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (arrayOfString.length > 2)
      {
        if (paramString.endsWith("/"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(arrayOfString[2]);
          return ((StringBuilder)localObject).toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(arrayOfString[2]);
        localObject = ((StringBuilder)localObject).toString();
      }
      return localObject;
    }
    paramString = new IOException("can not get url, do grsUrl(serviceName or key) error?");
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsManager
 * JD-Core Version:    0.7.0.1
 */