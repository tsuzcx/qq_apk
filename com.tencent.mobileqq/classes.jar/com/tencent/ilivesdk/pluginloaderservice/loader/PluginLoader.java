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
  
  public PluginClassLoader a()
  {
    return new PluginClassLoader(this.a, getClass().getClassLoader(), a(this.a), 1);
  }
  
  protected String[] a()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.loader.PluginLoader
 * JD-Core Version:    0.7.0.1
 */