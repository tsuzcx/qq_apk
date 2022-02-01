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
    if (!this.e)
    {
      Object localObject1 = PluginRunningPath.getPluginOptDexDir(this.b, this.c, this.d);
      Object localObject2 = PluginRunningPath.getPluginNewLibDir(this.b, this.c, this.d);
      new DexClassLoader(this.a.getAbsolutePath(), (String)localObject1, (String)localObject2, this.b.getClassLoader());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getName());
      ((StringBuilder)localObject2).append(".preload");
      localObject1 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
      try
      {
        ((File)localObject1).createNewFile();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimplePluginManager.PluginPreloadTask
 * JD-Core Version:    0.7.0.1
 */