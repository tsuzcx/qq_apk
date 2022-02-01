package com.tencent.ilivesdk.pluginloaderservice;

import com.tencent.ilivesdk.pluginloaderservice.interfaces.ClassLoaderListener;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IGetInstallPlugins;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.util.List;

class PluginLoaderService$1
  implements IGetInstallPlugins
{
  PluginLoaderService$1(PluginLoaderService paramPluginLoaderService, Class paramClass, String paramString, ClassLoaderListener paramClassLoaderListener) {}
  
  public void a(List<IPlugin> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      PluginLoaderService.a(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderservicePluginLoaderService, null, this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesClassLoaderListener);
      paramList = String.format("load: the to install plugin is empty. classname[%s]", new Object[] { this.jdField_a_of_type_JavaLangString });
      DataReport.d(paramList);
      LogUtil.b("PluginLoaderService", paramList, new Object[0]);
      return;
    }
    DataReport.e(String.format("get plugin[%s] success", new Object[] { this.jdField_a_of_type_JavaLangString }));
    PluginLoaderService.a(this.jdField_a_of_type_ComTencentIlivesdkPluginloaderservicePluginLoaderService).addAll(paramList);
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderservicePluginLoaderService.a(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesClassLoaderListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginLoaderService.1
 * JD-Core Version:    0.7.0.1
 */