package com.tencent.ilivesdk.pluginloaderservice;

import android.content.Context;
import com.tencent.falco.utils.MD5Utils;
import com.tencent.ilivesdk.pluginloaderservice.install.PluginConfig.PluginFileInfo;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginClassLoader;
import com.tencent.ilivesdk.pluginloaderservice.loader.PluginContextWrapper;
import com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil;
import java.io.File;
import java.util.HashMap;

public abstract class AbstractPlugin
  implements IPlugin
{
  protected String a;
  protected IPluginClassLoader b;
  protected String c;
  protected int d;
  protected int e;
  protected String f;
  protected String g;
  protected String[] h;
  protected String[] i;
  protected String j;
  protected boolean k;
  protected PluginConfig.PluginFileInfo l;
  private HashMap<String, Object> m = new HashMap();
  
  private <T> T a(String paramString)
  {
    String[] arrayOfString = j();
    int n = 0;
    if ((arrayOfString != null) && (j().length != 0))
    {
      arrayOfString = j();
      int i1 = arrayOfString.length;
      while (n < i1)
      {
        if (paramString.equals(arrayOfString[n])) {
          return this.m.get(paramString);
        }
        n += 1;
      }
      return null;
    }
    LogUtil.b("Plugin", "loadInstanceClass: instance classes is empty.", new Object[0]);
    return null;
  }
  
  private <T> void a(String paramString, T paramT)
  {
    if (j() != null)
    {
      if (j().length == 0) {
        return;
      }
      String[] arrayOfString = j();
      int i1 = arrayOfString.length;
      int n = 0;
      while (n < i1)
      {
        if (paramString.equals(arrayOfString[n]))
        {
          LogUtil.b("Plugin", "addClassToInstanceMap: instance classes[%s].", new Object[] { paramString });
          this.m.put(paramString, paramT);
          return;
        }
        n += 1;
      }
    }
  }
  
  public Context a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return new PluginContextWrapper(paramContext.getApplicationContext(), g(), (ClassLoader)this.b);
  }
  
  public <T> T a(Class<T> paramClass, String paramString)
  {
    if ((paramClass != null) && (paramString != null))
    {
      Object localObject = a(paramString);
      if (localObject != null)
      {
        LogUtil.b("Plugin", "loadClass: load instance class %s success.", new Object[] { paramString });
        return localObject;
      }
      paramClass = this.b.a(paramClass, paramString);
      a(paramString, paramClass);
      return paramClass;
    }
    LogUtil.b("Plugin", "loadClass: cls is null or className is null", new Object[0]);
    return null;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(PluginConfig.PluginFileInfo paramPluginFileInfo)
  {
    this.l = paramPluginFileInfo;
  }
  
  public void a(IPluginClassLoader paramIPluginClassLoader)
  {
    this.b = paramIPluginClassLoader;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public String[] c()
  {
    return this.h;
  }
  
  public String[] d()
  {
    PluginConfig.PluginFileInfo localPluginFileInfo = this.l;
    if (localPluginFileInfo == null) {
      return new String[0];
    }
    return localPluginFileInfo.d;
  }
  
  public String e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("/");
    localStringBuilder.append(this.a);
    localStringBuilder.append(".apk");
    return localStringBuilder.toString();
  }
  
  public String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("/dex");
    return localStringBuilder.toString();
  }
  
  public String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("/libs");
    return localStringBuilder.toString();
  }
  
  public String[] j()
  {
    return this.i;
  }
  
  public final String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UN-");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  public boolean l()
  {
    return this.b != null;
  }
  
  public String m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("/copiedfile");
    return localStringBuilder.toString();
  }
  
  public String n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("/config.json");
    return localStringBuilder.toString();
  }
  
  public String o()
  {
    File localFile1 = new File(g());
    File localFile2 = new File(i());
    File localFile3 = new File(n());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append(r());
    boolean bool = localFile3.exists();
    long l2 = 0L;
    if (bool) {
      l1 = localFile3.lastModified();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    if (localFile3.exists()) {
      l1 = localFile3.length();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    if (localFile1.exists()) {
      l1 = localFile1.lastModified();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    if (localFile1.exists()) {
      l1 = localFile1.length();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    if (localFile2.exists()) {
      l1 = localFile2.lastModified();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    long l1 = l2;
    if (localFile2.exists()) {
      l1 = localFile2.length();
    }
    localStringBuilder.append(l1);
    return MD5Utils.toMD5(localStringBuilder.toString());
  }
  
  public String p()
  {
    File localFile1 = new File(g());
    File localFile2 = new File(i());
    File localFile3 = new File(n());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append(r());
    localStringBuilder.append(q());
    boolean bool = localFile3.exists();
    long l2 = 0L;
    if (bool) {
      l1 = localFile3.lastModified();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    if (localFile3.exists()) {
      l1 = localFile3.length();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    if (localFile1.exists()) {
      l1 = localFile1.lastModified();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    if (localFile1.exists()) {
      l1 = localFile1.length();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    if (localFile2.exists()) {
      l1 = localFile2.lastModified();
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    long l1 = l2;
    if (localFile2.exists()) {
      l1 = localFile2.length();
    }
    localStringBuilder.append(l1);
    return MD5Utils.toMD5(localStringBuilder.toString());
  }
  
  public int q()
  {
    return this.d;
  }
  
  public int r()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.AbstractPlugin
 * JD-Core Version:    0.7.0.1
 */