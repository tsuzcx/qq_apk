package com.tencent.gamecenter.wadl.api.impl;

import android.content.Context;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import mqq.app.AppRuntime;

public class QQGameCommApiImpl
  implements IQQGameCommApi
{
  private static final String CLASS_NAME_APPRUNTIME = "com.tencent.gamecenter.wadl.base.WadlPluginRuntime";
  private static final String PLUGIN_NAME = "qqwadl.apk";
  public static final String TAG = "Wadl_QQGameCommApiImpl";
  
  public AppRuntime createAppRuntime(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createAppRuntime application=");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(",processName=");
    localStringBuilder.append(paramString);
    QLog.d("Wadl_QQGameCommApiImpl", 1, localStringBuilder.toString());
    if (paramContext != null) {
      if (paramString == null) {
        return null;
      }
    }
    try
    {
      try
      {
        paramString = Class.forName("com.tencent.gamecenter.wadl.base.WadlPluginRuntime");
        paramContext = paramString;
      }
      catch (Exception paramContext)
      {
        break label142;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      label69:
      break label69;
    }
    paramString = PluginStatic.getOrCreateClassLoader(paramContext, "qqwadl.apk");
    paramContext = paramString.loadClass("com.tencent.gamecenter.wadl.base.WadlPluginRuntime");
    BasicClassTypeUtil.setClassLoader(true, paramString);
    if (paramContext == null)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Wadl_QQGameCommApiImpl", 2, "*createAppRuntime load class fail");
        return null;
      }
    }
    else
    {
      paramContext = paramContext.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof AppRuntime)))
      {
        paramContext = (AppRuntime)paramContext;
        return paramContext;
        label142:
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("*createAppRuntime exception:");
          paramString.append(paramContext.toString());
          QLog.e("Wadl_QQGameCommApiImpl", 2, paramString.toString());
        }
      }
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameCommApiImpl
 * JD-Core Version:    0.7.0.1
 */