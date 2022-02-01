package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.classloader.ApkClassLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.exceptions.DynamicPluginLoaderLoadException;
import java.io.File;

class DynamicPluginLoaderLoader
{
  private final File a;
  private final String b;
  private final String c;
  private final String[] d;
  
  DynamicPluginLoaderLoader(String paramString1, File paramFile, String paramString2, String[] paramArrayOfString)
  {
    this.b = paramString1;
    this.a = paramFile;
    this.c = paramString2;
    this.d = paramArrayOfString;
  }
  
  final PluginLoader a()
  {
    if (this.a.exists())
    {
      if (this.a.canRead())
      {
        Object localObject1 = this.a.getParent();
        Object localObject2 = new StringBuilder("DynamicPluginLoader_");
        ((StringBuilder)localObject2).append(this.b);
        localObject1 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
        if ((((File)localObject1).exists()) && (!((File)localObject1).isDirectory()))
        {
          localObject2 = new StringBuilder("odexDir目标路径");
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          ((StringBuilder)localObject2).append("已被其他文件占用");
          throw new DynamicPluginLoaderLoadException(((StringBuilder)localObject2).toString());
        }
        if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdir()))
        {
          localObject2 = new StringBuilder("odexDir目标路径");
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          ((StringBuilder)localObject2).append("创建目录失败");
          throw new DynamicPluginLoaderLoadException(((StringBuilder)localObject2).toString());
        }
        localObject2 = this.a.getParent();
        StringBuilder localStringBuilder2 = new StringBuilder("DynamicPluginLoader_lib_");
        localStringBuilder2.append(this.b);
        localObject2 = new File((String)localObject2, localStringBuilder2.toString());
        if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
        {
          localObject1 = new StringBuilder("libDir目标路径");
          ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
          ((StringBuilder)localObject1).append("创建目录失败");
          throw new DynamicPluginLoaderLoadException(((StringBuilder)localObject1).toString());
        }
        localObject1 = new ApkClassLoader(this.a.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), DynamicPluginLoaderLoader.class.getClassLoader(), this.d);
        try
        {
          localObject1 = (PluginLoader)((ApkClassLoader)localObject1).a(PluginLoader.class, this.c);
          return localObject1;
        }
        catch (Exception localException)
        {
          throw new DynamicPluginLoaderLoadException(localException);
        }
      }
      localStringBuilder1 = new StringBuilder("文件");
      localStringBuilder1.append(this.a.getAbsolutePath());
      localStringBuilder1.append("不可读");
      throw new DynamicPluginLoaderLoadException(localStringBuilder1.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder("文件");
    localStringBuilder1.append(this.a.getAbsolutePath());
    localStringBuilder1.append("不存在");
    throw new DynamicPluginLoaderLoadException(localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginLoaderLoader
 * JD-Core Version:    0.7.0.1
 */