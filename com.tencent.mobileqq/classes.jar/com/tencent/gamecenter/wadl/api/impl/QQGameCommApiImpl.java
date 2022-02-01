package com.tencent.gamecenter.wadl.api.impl;

import android.content.Context;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
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
  
  public void reportGameShare(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    WadlReportBuilder localWadlReportBuilder1 = new WadlReportBuilder();
    WadlReportBuilder localWadlReportBuilder2 = localWadlReportBuilder1.a("dc00087").h("1044");
    Object localObject;
    if (paramInt1 == 0) {
      localObject = "208076";
    } else {
      localObject = "208077";
    }
    localWadlReportBuilder2.c((String)localObject).b(paramString1).d("104005").e("5").f("122").a(2, String.valueOf(paramInt2)).a(3, paramString2).a(6, paramString4).a(35, "0").a(46, paramString3).a(45, String.valueOf(paramInt3));
    localWadlReportBuilder1.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportGameShare actionType=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",msgType=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",sessionType=");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",gameappId=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",tagName=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",messageExt=");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(",title=");
      ((StringBuilder)localObject).append(paramString4);
      QLog.d("Wadl_QQGameCommApiImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameCommApiImpl
 * JD-Core Version:    0.7.0.1
 */