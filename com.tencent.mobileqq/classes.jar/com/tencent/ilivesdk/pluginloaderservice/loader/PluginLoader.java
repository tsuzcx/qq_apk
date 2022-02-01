package com.tencent.ilivesdk.pluginloaderservice.loader;

import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoader;

public class PluginLoader
  extends AbstractPluginLoader
  implements IPluginLoader
{
  private IPlugin a;
  
  public PluginLoader(IPlugin paramIPlugin)
  {
    this.a = paramIPlugin;
  }
  
  protected String[] b()
  {
    return this.a.d();
  }
  
  public PluginClassLoader c()
  {
    return new PluginClassLoader(this.a, getClass().getClassLoader(), a(this.a), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.loader.PluginLoader
 * JD-Core Version:    0.7.0.1
 */