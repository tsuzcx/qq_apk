package com.tencent.ilivesdk.pluginloaderservice;

import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;

final class PluginManger$2
  implements Callable<IPlugin>
{
  PluginManger$2(String paramString, Plugin paramPlugin) {}
  
  public IPlugin a()
  {
    Object localObject1 = String.format("install: start install plugin[%s]", new Object[] { this.jdField_a_of_type_JavaLangString });
    LogUtil.b("PluginManger", (String)localObject1, new Object[0]);
    DataReport.g((String)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentIlivesdkPluginloaderservicePlugin.a();
    Object localObject3;
    Object localObject2;
    try
    {
      localObject3 = PluginManger.a((IPlugin)localObject1);
      if (localObject3 == null)
      {
        localObject1 = String.format("install; download plugin[%s] fail.", new Object[] { this.jdField_a_of_type_JavaLangString });
        DataReport.h((String)localObject1);
        LogUtil.a("PluginManger", (String)localObject1, new Object[0]);
        return null;
      }
    }
    catch (IOException localIOException1)
    {
      localObject2 = String.format("install; download plugin[%s] exception: %s", new Object[] { this.jdField_a_of_type_JavaLangString, localIOException1.getMessage() });
      DataReport.h((String)localObject2);
      LogUtil.c("PluginManger", (String)localObject2, new Object[0]);
      return null;
    }
    DataReport.i(String.format("install; download plugin[%s] Success.", new Object[] { this.jdField_a_of_type_JavaLangString }));
    String str2;
    try
    {
      localObject2 = PluginManger.a((IPlugin)localObject2, (File)localObject3);
      if (localObject2 == null)
      {
        localObject2 = String.format("install; install plugin[%s] fail.", new Object[] { this.jdField_a_of_type_JavaLangString });
        DataReport.j((String)localObject2);
        LogUtil.c("PluginManger", (String)localObject2, new Object[0]);
        return null;
      }
    }
    catch (IOException localIOException2)
    {
      String str1 = String.format("install; install plugin[%s] exception: %s", new Object[] { this.jdField_a_of_type_JavaLangString, localIOException2.getMessage() });
      DataReport.j(str1);
      LogUtil.c("PluginManger", str1, new Object[0]);
      return null;
    }
    catch (JSONException localJSONException)
    {
      str2 = String.format("install; install plugin[%s] exception: %s", new Object[] { this.jdField_a_of_type_JavaLangString, localJSONException.getMessage() });
      DataReport.j(str2);
      LogUtil.c("PluginManger", str2, new Object[0]);
      return null;
    }
    DataReport.l(String.format("install; install plugin[%s] success.", new Object[] { this.jdField_a_of_type_JavaLangString }));
    str2.a(PluginManger.a(str2));
    if (str2.a())
    {
      localObject3 = String.format("install; install plugin[%s] success.", new Object[] { this.jdField_a_of_type_JavaLangString });
      DataReport.q((String)localObject3);
      LogUtil.b("PluginManger", (String)localObject3, new Object[0]);
    }
    for (;;)
    {
      return str2;
      localObject3 = String.format("install; install plugin[%s] fail.", new Object[] { this.jdField_a_of_type_JavaLangString });
      DataReport.k((String)localObject3);
      LogUtil.b("PluginManger", (String)localObject3, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginManger.2
 * JD-Core Version:    0.7.0.1
 */