package com.tencent.ilivesdk.pluginloaderservice;

import android.content.Context;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;

public class Plugin
  extends AbstractPlugin
  implements IPlugin
{
  private IPlugin a;
  
  public Context a(Context paramContext)
  {
    IPlugin localIPlugin = this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin;
    if ((localIPlugin != null) && (localIPlugin.a())) {
      return this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.a(paramContext);
    }
    return super.a(paramContext);
  }
  
  public Plugin a()
  {
    Plugin localPlugin = new Plugin();
    localPlugin.jdField_a_of_type_JavaLangString = c();
    localPlugin.jdField_b_of_type_JavaLangString = a();
    localPlugin.c = d();
    localPlugin.d = b();
    localPlugin.jdField_a_of_type_ArrayOfJavaLangString = a();
    localPlugin.jdField_b_of_type_ArrayOfJavaLangString = c();
    localPlugin.jdField_a_of_type_Boolean = b();
    localPlugin.e = m();
    localPlugin.jdField_b_of_type_Int = b();
    localPlugin.jdField_a_of_type_Int = a();
    localPlugin.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginClassLoader = this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginClassLoader;
    localPlugin.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInstallPluginConfig$PluginFileInfo = this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInstallPluginConfig$PluginFileInfo;
    return localPlugin;
  }
  
  public <T> T a(Class<T> paramClass, String paramString)
  {
    IPlugin localIPlugin = this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin;
    if ((localIPlugin != null) && (localIPlugin.a())) {
      return this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin.a(paramClass, paramString);
    }
    return super.a(paramClass, paramString);
  }
  
  public void a(IPlugin paramIPlugin)
  {
    if (paramIPlugin.a()) {
      this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin = paramIPlugin;
    }
  }
  
  public boolean a()
  {
    IPlugin localIPlugin = this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPlugin;
    return ((localIPlugin != null) && (localIPlugin.a())) || (this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginClassLoader != null);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String[] c()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public String m()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.Plugin
 * JD-Core Version:    0.7.0.1
 */