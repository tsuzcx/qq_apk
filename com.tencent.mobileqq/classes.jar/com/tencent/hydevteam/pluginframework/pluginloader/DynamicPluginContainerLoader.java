package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginloader.exceptions.PluginContainerLoadException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;

@API
public class DynamicPluginContainerLoader
{
  private static Field a()
  {
    ClassLoader localClassLoader1 = Thread.currentThread().getContextClassLoader();
    ClassLoader localClassLoader2 = localClassLoader1.getParent();
    Field[] arrayOfField = ClassLoader.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      try
      {
        boolean bool = localField.isAccessible();
        localField.setAccessible(true);
        Object localObject = localField.get(localClassLoader1);
        localField.setAccessible(bool);
        if (localObject == localClassLoader2) {
          return localField;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label73:
        break label73;
      }
      i += 1;
    }
    return null;
  }
  
  private static void a(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    Field localField = a();
    if (localField != null)
    {
      localField.setAccessible(true);
      localField.set(paramClassLoader1, paramClassLoader2);
      return;
    }
    throw new Exception("在ClassLoader.class中没找到类型为ClassLoader的parent域");
  }
  
  private static void a(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new AssertionError();
  }
  
  @API
  public void load(InstalledPlugin paramInstalledPlugin)
  {
    if ((paramInstalledPlugin instanceof UseDynamicPluginLoaderInstalledPlugin)) {
      try
      {
        a(((UseDynamicPluginLoaderInstalledPlugin)paramInstalledPlugin).dynamicPluginLoaderVersion);
        a(((UseDynamicPluginLoaderInstalledPlugin)paramInstalledPlugin).dynamicPluginContainerFile);
        localObject1 = (UseDynamicPluginLoaderInstalledPlugin)paramInstalledPlugin;
        paramInstalledPlugin = Thread.currentThread().getContextClassLoader();
      }
      catch (AssertionError paramInstalledPlugin)
      {
        Object localObject2;
        label68:
        label99:
        File localFile1;
        File localFile2;
        StringBuilder localStringBuilder;
        throw new PluginContainerLoadException("检查启动插件参数时发生错误", paramInstalledPlugin);
      }
    }
    try
    {
      localObject2 = new StringBuilder("com.tencent.hydevteam.pluginframework.plugincontainer.version.");
      ((StringBuilder)localObject2).append(((UseDynamicPluginLoaderInstalledPlugin)localObject1).dynamicPluginContainerVersion);
      paramInstalledPlugin.loadClass(((StringBuilder)localObject2).toString());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      break label68;
    }
    try
    {
      localObject2 = paramInstalledPlugin.loadClass("com.tencent.hydevteam.pluginframework.plugincontainer.DelegateProviderHolder").getClassLoader().getParent();
      try
      {
        a(paramInstalledPlugin, (ClassLoader)localObject2);
      }
      catch (Exception localException)
      {
        throw new PluginContainerLoadException(localException);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label99;
    }
    localFile1 = ((UseDynamicPluginLoaderInstalledPlugin)localObject1).dynamicPluginContainerFile;
    Object localObject1 = ((UseDynamicPluginLoaderInstalledPlugin)localObject1).dynamicPluginLoaderVersion;
    localFile2 = localFile1.getParentFile();
    localStringBuilder = new StringBuilder("plugin_container_odex_");
    localStringBuilder.append((String)localObject1);
    localObject1 = new File(localFile2, localStringBuilder.toString());
    ((File)localObject1).mkdirs();
    try
    {
      a(paramInstalledPlugin, new DexClassLoader(localFile1.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), null, paramInstalledPlugin.getParent()));
      return;
    }
    catch (Exception paramInstalledPlugin)
    {
      throw new PluginContainerLoadException(paramInstalledPlugin);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInstalledPlugin);
    ((StringBuilder)localObject1).append("不是一个");
    ((StringBuilder)localObject1).append(UseDynamicPluginLoaderInstalledPlugin.class);
    throw new PluginContainerLoadException(((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginContainerLoader
 * JD-Core Version:    0.7.0.1
 */