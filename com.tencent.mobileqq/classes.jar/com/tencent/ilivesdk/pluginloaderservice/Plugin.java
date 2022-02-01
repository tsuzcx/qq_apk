package com.tencent.ilivesdk.pluginloaderservice;

import android.content.Context;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;

public class Plugin
  extends AbstractPlugin
  implements IPlugin
{
  private IPlugin m;
  
  public Context a(Context paramContext)
  {
    IPlugin localIPlugin = this.m;
    if ((localIPlugin != null) && (localIPlugin.l())) {
      return this.m.a(paramContext);
    }
    return super.a(paramContext);
  }
  
  public <T> T a(Class<T> paramClass, String paramString)
  {
    IPlugin localIPlugin = this.m;
    if ((localIPlugin != null) && (localIPlugin.l())) {
      return this.m.a(paramClass, paramString);
    }
    return super.a(paramClass, paramString);
  }
  
  public void a(IPlugin paramIPlugin)
  {
    if (paramIPlugin.l()) {
      this.m = paramIPlugin;
    }
  }
  
  public String[] j()
  {
    return this.i;
  }
  
  public boolean l()
  {
    IPlugin localIPlugin = this.m;
    return ((localIPlugin != null) && (localIPlugin.l())) || (this.b != null);
  }
  
  public String s()
  {
    return this.j;
  }
  
  public boolean t()
  {
    return this.k;
  }
  
  public Plugin u()
  {
    Plugin localPlugin = new Plugin();
    localPlugin.a = e();
    localPlugin.c = a();
    localPlugin.f = f();
    localPlugin.g = b();
    localPlugin.h = c();
    localPlugin.i = j();
    localPlugin.k = t();
    localPlugin.j = s();
    localPlugin.e = r();
    localPlugin.d = q();
    localPlugin.b = this.b;
    localPlugin.l = this.l;
    return localPlugin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.Plugin
 * JD-Core Version:    0.7.0.1
 */