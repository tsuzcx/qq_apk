package com.tencent.biz.viewplugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;

class ViewPluginLoader$1
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(ViewPluginLoader.a(this.this$0));
      ((StringBuilder)localObject2).append(this.this$0.b);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject2).exists())
      {
        this.a.notifyUI(3, true, Integer.valueOf(1));
        return;
      }
      try
      {
        localObject4 = new File(this.this$0.c);
        Object localObject5 = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_key_version_prefix");
        localStringBuilder.append(this.this$0.b);
        if (!((SharedPreferences)localObject5).getString(localStringBuilder.toString(), "-1").equals(this.this$0.d)) {
          if (((File)localObject4).exists())
          {
            FileUtils.deleteDirectory(((File)localObject4).getAbsolutePath());
            localObject5 = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.edit();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("sp_key_version_prefix");
            localStringBuilder.append(this.this$0.b);
            ((SharedPreferences.Editor)localObject5).putString(localStringBuilder.toString(), HtmlOffline.a(this.this$0.jdField_a_of_type_JavaLangString)).commit();
            ((File)localObject4).mkdirs();
          }
          else
          {
            ((File)localObject4).mkdirs();
          }
        }
        if (!((File)localObject4).exists()) {
          ((File)localObject4).mkdirs();
        }
        localObject4 = PluginUtils.getPluginLibPath(BaseApplicationImpl.getContext(), this.this$0.b).getCanonicalPath();
        if (this.this$0.jdField_a_of_type_JavaLangClassLoader == null) {
          this.this$0.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader((String)localObject2, this.this$0.c, (String)localObject4, BaseApplicationImpl.getContext().getClassLoader());
        }
        this.this$0.e = ((String)localObject2);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("load werewolves local plugin success,path = ");
          ((StringBuilder)localObject4).append((String)localObject2);
          QLog.i("ViewPluginLoader", 2, ((StringBuilder)localObject4).toString());
        }
        this.this$0.jdField_a_of_type_Boolean = true;
        this.a.notifyUI(3, true, Integer.valueOf(0));
      }
      catch (Exception localException)
      {
        Object localObject4;
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("load error msg = ");
          ((StringBuilder)localObject4).append(localException.getMessage());
          QLog.e("ViewPluginLoader", 2, ((StringBuilder)localObject4).toString(), localException);
        }
        this.a.notifyUI(3, true, Integer.valueOf(3));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.1
 * JD-Core Version:    0.7.0.1
 */