package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class i
  extends PushPreferences
{
  public static final String TAG = "i";
  public Context b;
  
  public i(Context paramContext)
  {
    super(paramContext, "push_client_self_info");
    this.b = paramContext;
  }
  
  public static i a(Context paramContext)
  {
    return new i(paramContext);
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = PushEncrypter.decrypter(this.b, getString(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSecureData");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e(str, localStringBuilder.toString());
    }
    return "";
  }
  
  public void a()
  {
    Object localObject = getAll();
    if (!((Map)localObject).isEmpty())
    {
      if (((Map)localObject).keySet().isEmpty()) {
        return;
      }
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((!"push_kit_auto_init_enabled".equals(str)) && (!"_proxy_init".equals(str))) {
          removeKey(str);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    try
    {
      boolean bool = saveString(paramString1, PushEncrypter.encrypter(this.b, paramString2));
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSecureData");
      localStringBuilder.append(paramString1.getMessage());
      HMSLog.e(paramString2, localStringBuilder.toString());
    }
    return false;
  }
  
  public String b(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return a("token_info_v2");
      }
      paramString = a(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSecureData");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e(str, localStringBuilder.toString());
    }
    return "";
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool) {
        return a("token_info_v2", paramString2);
      }
      bool = a(paramString1, paramString2);
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSecureData");
      localStringBuilder.append(paramString1.getMessage());
      HMSLog.e(paramString2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return removeKey("token_info_v2");
      }
      bool = removeKey(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeToken");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e(str, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.i
 * JD-Core Version:    0.7.0.1
 */