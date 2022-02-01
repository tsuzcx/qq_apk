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
    String[] arrayOfString = c();
    int i = 0;
    if ((arrayOfString != null) && (c().length != 0))
    {
      arrayOfString = c();
      int j = arrayOfString.length;
      while (i < j)
      {
        if (paramString.equals(arrayOfString[i])) {
          return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        }
        i += 1;
      }
      return null;
    }
    LogUtil.b("Plugin", "loadInstanceClass: instance classes is empty.", new Object[0]);
    return null;
  }
  
  private <T> void a(String paramString, T paramT)
  {
    if (c() != null)
    {
      if (c().length == 0) {
        return;
      }
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
    if ((paramClass != null) && (paramString != null))
    {
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
    LogUtil.b("Plugin", "loadClass: cls is null or className is null", new Object[0]);
    return null;
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
    PluginConfig.PluginFileInfo localPluginFileInfo = this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInstallPluginConfig$PluginFileInfo;
    if (localPluginFileInfo == null) {
      return new String[0];
    }
    return localPluginFileInfo.jdField_b_of_type_ArrayOfJavaLangString;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(".apk");
    return localStringBuilder.toString();
  }
  
  public String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/dex");
    return localStringBuilder.toString();
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/libs");
    return localStringBuilder.toString();
  }
  
  public final String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UN-");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/copiedfile");
    return localStringBuilder.toString();
  }
  
  public String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/config.json");
    return localStringBuilder.toString();
  }
  
  public String k()
  {
    File localFile1 = new File(e());
    File localFile2 = new File(g());
    File localFile3 = new File(j());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(b());
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
  
  public String l()
  {
    File localFile1 = new File(e());
    File localFile2 = new File(g());
    File localFile3 = new File(j());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(b());
    localStringBuilder.append(a());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.AbstractPlugin
 * JD-Core Version:    0.7.0.1
 */