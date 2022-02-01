package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.Progress;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;

class SimplePluginManager$GetPluginTask
  implements Progress, Callable<InstalledPlugin>
{
  private TargetDownloadInfo a;
  private boolean b;
  private volatile ProgressFuture<File> c;
  private volatile int d = 0;
  
  SimplePluginManager$GetPluginTask(SimplePluginManager paramSimplePluginManager, TargetDownloadInfo paramTargetDownloadInfo, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.a = paramTargetDownloadInfo;
  }
  
  private InstalledPlugin a()
  {
    Object localObject3 = SimplePluginManager.a(this.e).a();
    a(10);
    Object localObject2 = new ArrayList();
    if (localObject3 == null) {
      localObject2 = MinFileUtils.b(SimplePluginManager.b(this.e).a);
    }
    a(10);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (this.a != null)
      {
        Iterator localIterator = ((List)localObject2).iterator();
        do
        {
          localObject1 = localObject3;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (File)localIterator.next();
        } while ((SimplePluginManager.a(this.e).b((File)localObject1)) || (!((File)localObject1).getName().equals(this.a.hash)));
      }
    }
    try
    {
      localObject1 = SimplePluginManager.a(this.e).c((File)localObject1);
    }
    catch (IOException|JSONException localIOException1)
    {
      label141:
      label211:
      break label141;
    }
    a(5);
    localObject1 = localObject3;
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        localObject3 = localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (File)((Iterator)localObject2).next();
        if (!SimplePluginManager.a(this.e).b((File)localObject3)) {}
        try
        {
          localObject3 = SimplePluginManager.a(this.e).c((File)localObject3);
        }
        catch (IOException|JSONException localIOException2)
        {
          break label211;
        }
        a(5);
      }
    }
    this.d = 100;
    if (localObject3 != null) {
      return localObject3;
    }
    localObject1 = new Exception("找不到本地插件");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private void a(int paramInt)
  {
    this.d += paramInt;
  }
  
  private InstalledPlugin b()
  {
    Object localObject2 = SimplePluginManager.a.get(this.a.hash);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Object();
      SimplePluginManager.a.put(this.a.hash, localObject1);
    }
    label93:
    try
    {
      localObject2 = SimplePluginManager.b(this.e);
      localObject4 = this.a.hash;
      localObject4 = new File(((TargetManager)localObject2).a, (String)localObject4);
    }
    finally {}
    try
    {
      localObject2 = SimplePluginManager.a(this.e).c((File)localObject4);
    }
    catch (Exception localException)
    {
      break label93;
    }
    if (((File)localObject4).exists()) {
      ((File)localObject4).delete();
    }
    Object localObject5 = SimplePluginManager.b(this.e);
    localObject2 = this.a.hash;
    localObject5 = ((TargetManager)localObject5).b;
    StringBuilder localStringBuilder = new StringBuilder("downloading.");
    localStringBuilder.append((String)localObject2);
    localObject2 = new File((File)localObject5, localStringBuilder.toString());
    localObject2 = SimplePluginManager.c(this.e).download(this.a, (File)localObject4, (File)localObject2);
    a(5);
    this.c = ((ProgressFuture)localObject2);
    Object localObject4 = (File)((ProgressFuture)localObject2).get();
    a(5);
    localObject2 = SimplePluginManager.a(this.e).c((File)localObject4);
    ((File)localObject4).delete();
    a(5);
    ((File)localObject4).delete();
    this.d = 100;
    return localObject2;
  }
  
  public double getProgress()
  {
    double d1;
    if (this.c != null)
    {
      d1 = this.d;
      double d2 = 100 - this.d;
      double d3 = this.c.getProgress();
      Double.isNaN(d2);
      Double.isNaN(d1);
      d1 += d2 * d3;
    }
    for (;;)
    {
      return d1 / 100.0D;
      d1 = this.d;
      Double.isNaN(d1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimplePluginManager.GetPluginTask
 * JD-Core Version:    0.7.0.1
 */