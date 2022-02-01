package com.tencent.biz.viewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;

class ViewPluginManager$2
  implements AsyncCallBack
{
  ViewPluginManager$2(ViewPluginManager paramViewPluginManager, long paramLong, Context paramContext, boolean paramBoolean, AsyncCallBack paramAsyncCallBack) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("transToLocalUrl loadMode:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", time:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.a);
      QLog.i("ViewPluginManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("transToLocalUrl transUrl:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("ViewPluginManager", 4, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.e;
    ((ViewPluginManager)localObject1).i = HtmlOffline.d(((ViewPluginManager)localObject1).c);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(OfflineEnvHelper.b(this.e.c));
    ((StringBuilder)localObject1).append(this.e.c);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(this.e.d);
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      Object localObject2 = new File(this.e.g);
      if (!this.e.h.getString(this.e.c(this.e.c), "-1").equals(this.e.i)) {
        if (((File)localObject2).exists())
        {
          FileUtils.deleteDirectory(((File)localObject2).getAbsolutePath());
          this.e.h.edit().putString(this.e.c(this.e.c), HtmlOffline.d(this.e.c)).commit();
          ((File)localObject2).mkdirs();
        }
        else
        {
          ((File)localObject2).mkdirs();
        }
      }
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = PluginUtils.getPluginLibPath(this.b, this.e.d).getCanonicalPath();
      this.e.b = new DexClassLoader((String)localObject1, this.e.g, (String)localObject2, this.b.getClassLoader());
      this.e.a = new ViewPluginContext(this.b, 0, (String)localObject1, null, null, this.c);
      if (this.d != null)
      {
        this.d.loaded(paramInt, paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create classloader failed:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.d("ViewPluginManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager.2
 * JD-Core Version:    0.7.0.1
 */