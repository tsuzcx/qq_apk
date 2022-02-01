package com.tencent.mobileqq.ark.module;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.api.scheme.AppSchemeHandler;
import com.tencent.mobileqq.ark.api.scheme.MiniAppSchemeHandler;
import com.tencent.mobileqq.ark.api.scheme.MiniAppSchemeInterceptor;
import com.tencent.mobileqq.ark.api.scheme.QQSchemeHandler;
import com.tencent.mobileqq.ark.api.scheme.QzoneSchemeHandler;
import com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class ArkAppSchemeCenter
{
  @ConfigInject(configPath="Business/qqark-impl/src/main/resources/Inject_ArkAppSchemeCenter.yml", version=1)
  protected static final HashMap<String, Class<? extends SchemeHandler>> a = new HashMap();
  @ConfigInject(configPath="Business/qqark-impl/src/main/resources/Inject_ArkAppSchemeCenter.yml", version=1)
  protected static final ArrayList<Class<? extends SchemeInterceptor>> b;
  
  static
  {
    a.put("miniapp", MiniAppSchemeHandler.class);
    a.put("mqzone", QzoneSchemeHandler.class);
    a.put("app", AppSchemeHandler.class);
    a.put("tel", TelSchemeHandler.class);
    a.put("qq", QQSchemeHandler.class);
    b = new ArrayList();
    b.add(MiniAppSchemeInterceptor.class);
  }
  
  public static boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "";
    }
    paramString2 = new StringBuilder();
    paramString2.append("navigate url: ");
    paramString2.append(paramString1);
    QLog.i("ArkApp.SchemeCenter", 1, paramString2.toString());
    paramString2 = paramString1.split(":");
    if (paramString2.length <= 1) {
      return false;
    }
    Object localObject1 = b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Class localClass = (Class)((Iterator)localObject1).next();
      try
      {
        boolean bool = ((SchemeInterceptor)localClass.newInstance()).a(paramString1, str, paramJSONObject);
        if (bool) {
          return true;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("interceptor exception, ");
        localStringBuilder.append(localException.toString());
        QLog.i("ArkApp.SchemeCenter", 1, localStringBuilder.toString());
      }
    }
    Object localObject2 = paramString2[0];
    paramString2 = (Class)a.get(localObject2);
    if (paramString2 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("scheme handler not found for ");
      paramString1.append(localObject2);
      QLog.i("ArkApp.SchemeCenter", 1, paramString1.toString());
      return false;
    }
    try
    {
      localObject1 = (SchemeHandler)paramString2.newInstance();
      paramString2 = paramString1.substring(localObject2.length() + 1);
      paramString1 = paramString2;
      if (paramString2.startsWith("//")) {
        paramString1 = paramString2.substring(2);
      }
      ((SchemeHandler)localObject1).a(paramString1, str, paramJSONObject, paramLong, paramString3);
      return true;
    }
    catch (Exception paramString1)
    {
      label279:
      break label279;
    }
    paramString1 = new StringBuilder();
    paramString1.append("create scheme handler fail + ");
    paramString1.append(paramString2.toString());
    QLog.i("ArkApp.SchemeCenter", 1, paramString1.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppSchemeCenter
 * JD-Core Version:    0.7.0.1
 */