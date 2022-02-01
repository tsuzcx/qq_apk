package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@API
public class SimplePluginManager
  implements PluginManager
{
  public static final Map<String, Object> a = new HashMap();
  private static final File i = new File("/data/local/tmp");
  private final File b;
  private final File c;
  private final Downloader d;
  private final VersionChecker e;
  private final TargetManager f;
  private final UnpackManager g;
  private final ExecutorService h = Executors.newSingleThreadExecutor();
  private File j;
  
  public SimplePluginManager(File paramFile, Downloader paramDownloader, VersionChecker paramVersionChecker, String paramString)
  {
    this.b = paramFile;
    this.c = new File(this.b, "PluginManager_" + paramString);
    this.f = new TargetManager(this.c);
    if ((this.c.exists()) && (!this.c.isDirectory())) {
      throw new IllegalArgumentException(this.c.getAbsolutePath() + "已存在且不是目录");
    }
    this.g = new UnpackManager(this.c);
    this.d = paramDownloader;
    this.e = paramVersionChecker;
  }
  
  private boolean a(String paramString)
  {
    this.j = new File(i, paramString + ".zip");
    return this.j.exists();
  }
  
  @API
  public List<InstalledPlugin> getCachedLatestPlugin(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramString)) {}
    for (paramString = new SimplePluginManager.GetTestPluginTask(this, false);; paramString = new SimplePluginManager.GetPluginTask(this, null, true))
    {
      paramString = this.h.submit(paramString);
      try
      {
        localArrayList.add((InstalledPlugin)paramString.get());
        return localArrayList;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  @API
  public VersionChecker getVersionChecker()
  {
    return this.e;
  }
  
  @API
  public ProgressFuture preloadApk(Context paramContext, InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    paramContext = new SimplePluginManager.PluginPreloadTask(paramContext, paramInstalledPlugin.pluginFile, paramInstalledPlugin.pluginPackageName, paramInstalledPlugin.pluginVersionForPluginLoaderManage, paramBoolean);
    return new ProgressFutureImpl(this.h.submit(paramContext), null);
  }
  
  @API
  public List<ProgressFuture<InstalledPlugin>> updatePlugin(String paramString1, TargetDownloadInfo paramTargetDownloadInfo, String paramString2)
  {
    paramString2 = new ArrayList();
    if (a(paramString1))
    {
      paramString1 = new SimplePluginManager.GetTestPluginTask(this, true);
      paramString2.add(new ProgressFutureImpl(this.h.submit(paramString1), paramString1));
      return paramString2;
    }
    paramString1 = new SimplePluginManager.GetPluginTask(this, paramTargetDownloadInfo, false);
    paramString2.add(new ProgressFutureImpl(this.h.submit(paramString1), paramString1));
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimplePluginManager
 * JD-Core Version:    0.7.0.1
 */