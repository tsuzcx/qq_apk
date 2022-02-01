package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;

class SimplePluginManager$PluginPreloadTask
  implements Runnable
{
  private File a;
  private Context b;
  private String c;
  private String d;
  private boolean e;
  
  SimplePluginManager$PluginPreloadTask(Context paramContext, File paramFile, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.b = paramContext;
    this.a = paramFile;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramBoolean;
  }
  
  public void run()
  {
    Object localObject;
    if (!this.e)
    {
      localObject = PluginRunningPath.getPluginOptDexDir(this.b, this.c, this.d);
      String str = PluginRunningPath.getPluginNewLibDir(this.b, this.c, this.d);
      new DexClassLoader(this.a.getAbsolutePath(), (String)localObject, str, this.b.getClassLoader());
      localObject = new File((String)localObject, this.a.getName() + ".preload");
    }
    try
    {
      ((File)localObject).createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimplePluginManager.PluginPreloadTask
 * JD-Core Version:    0.7.0.1
 */