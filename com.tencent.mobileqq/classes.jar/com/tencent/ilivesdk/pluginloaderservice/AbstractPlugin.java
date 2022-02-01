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
  protected int a;
  protected PluginConfig.PluginFileInfo a;
  protected IPluginClassLoader a;
  protected String a;
  private HashMap<String, Object> a;
  protected boolean a;
  protected String[] a;
  protected int b;
  protected String b;
  protected String[] b;
  protected String c;
  protected String d;
  protected String e;
  
  public AbstractPlugin()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private <T> T a(String paramString)
  {
    int i = 0;
    if ((c() == null) || (c().length == 0)) {
      LogUtil.b("Plugin", "loadInstanceClass: instance classes is empty.", new Object[0]);
    }
    for (;;)
    {
      return null;
      String[] arrayOfString = c();
      int j = arrayOfString.length;
      while (i < j)
      {
        if (paramString.equals(arrayOfString[i])) {
          return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        }
        i += 1;
      }
    }
  }
  
  private <T> void a(String paramString, T paramT)
  {
    if ((c() == null) || (c().length == 0)) {}
    for (;;)
    {
      return;
      String[] arrayOfString = c();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(arrayOfString[i]))
        {
          LogUtil.b("Plugin", "addClassToInstanceMap: instance classes[%s].", new Object[] { paramString });
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramT);
          return;
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Context a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return new PluginContextWrapper(paramContext.getApplicationContext(), e(), (ClassLoader)this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginClassLoader);
  }
  
  public <T> T a(Class<T> paramClass, String paramString)
  {
    if ((paramClass == null) || (paramString == null))
    {
      LogUtil.b("Plugin", "loadClass: cls is null or className is null", new Object[0]);
      return null;
    }
    Object localObject = a(paramString);
    if (localObject != null)
    {
      LogUtil.b("Plugin", "loadClass: load instance class %s success.", new Object[] { paramString });
      return localObject;
    }
    paramClass = this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginClassLoader.a(paramClass, paramString);
    a(paramString, paramClass);
    return paramClass;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(PluginConfig.PluginFileInfo paramPluginFileInfo)
  {
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInstallPluginConfig$PluginFileInfo = paramPluginFileInfo;
  }
  
  public void a(IPluginClassLoader paramIPluginClassLoader)
  {
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginClassLoader = paramIPluginClassLoader;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIPluginClassLoader != null;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String[] b()
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInstallPluginConfig$PluginFileInfo == null) {
      return new String[0];
    }
    return this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInstallPluginConfig$PluginFileInfo.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String[] c()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.c + "/" + this.jdField_a_of_type_JavaLangString + ".apk";
  }
  
  public String f()
  {
    return this.c + "/dex";
  }
  
  public String g()
  {
    return this.c + "/libs";
  }
  
  public final String h()
  {
    return "UN-" + this.jdField_a_of_type_JavaLangString;
  }
  
  public String i()
  {
    return this.c + "/copiedfile";
  }
  
  public String j()
  {
    return this.c + "/config.json";
  }
  
  public String k()
  {
    long l2 = 0L;
    Object localObject1 = new File(e());
    File localFile = new File(g());
    Object localObject2 = new File(j());
    StringBuilder localStringBuilder = new StringBuilder().append(c()).append(b());
    if (((File)localObject2).exists())
    {
      l1 = ((File)localObject2).lastModified();
      localStringBuilder = localStringBuilder.append(l1);
      if (!((File)localObject2).exists()) {
        break label208;
      }
      l1 = ((File)localObject2).length();
      label100:
      localObject2 = localStringBuilder.append(l1);
      if (!((File)localObject1).exists()) {
        break label213;
      }
      l1 = ((File)localObject1).lastModified();
      label122:
      localObject2 = ((StringBuilder)localObject2).append(l1);
      if (!((File)localObject1).exists()) {
        break label218;
      }
      l1 = ((File)localObject1).length();
      label144:
      localObject1 = ((StringBuilder)localObject2).append(l1);
      if (!localFile.exists()) {
        break label223;
      }
    }
    label208:
    label213:
    label218:
    label223:
    for (long l1 = localFile.lastModified();; l1 = 0L)
    {
      localObject1 = ((StringBuilder)localObject1).append(l1);
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
      return MD5Utils.toMD5(l1);
      l1 = 0L;
      break;
      l1 = 0L;
      break label100;
      l1 = 0L;
      break label122;
      l1 = 0L;
      break label144;
    }
  }
  
  public String l()
  {
    long l2 = 0L;
    Object localObject1 = new File(e());
    File localFile = new File(g());
    Object localObject2 = new File(j());
    StringBuilder localStringBuilder = new StringBuilder().append(c()).append(b()).append(a());
    if (((File)localObject2).exists())
    {
      l1 = ((File)localObject2).lastModified();
      localStringBuilder = localStringBuilder.append(l1);
      if (!((File)localObject2).exists()) {
        break label215;
      }
      l1 = ((File)localObject2).length();
      label107:
      localObject2 = localStringBuilder.append(l1);
      if (!((File)localObject1).exists()) {
        break label220;
      }
      l1 = ((File)localObject1).lastModified();
      label129:
      localObject2 = ((StringBuilder)localObject2).append(l1);
      if (!((File)localObject1).exists()) {
        break label225;
      }
      l1 = ((File)localObject1).length();
      label151:
      localObject1 = ((StringBuilder)localObject2).append(l1);
      if (!localFile.exists()) {
        break label230;
      }
    }
    label215:
    label220:
    label225:
    label230:
    for (long l1 = localFile.lastModified();; l1 = 0L)
    {
      localObject1 = ((StringBuilder)localObject1).append(l1);
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
      return MD5Utils.toMD5(l1);
      l1 = 0L;
      break;
      l1 = 0L;
      break label107;
      l1 = 0L;
      break label129;
      l1 = 0L;
      break label151;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.AbstractPlugin
 * JD-Core Version:    0.7.0.1
 */