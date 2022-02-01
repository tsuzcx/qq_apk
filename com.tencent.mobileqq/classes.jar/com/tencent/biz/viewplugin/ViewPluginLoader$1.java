package com.tencent.biz.viewplugin;

import aazg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmg;
import bhte;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import nko;

public class ViewPluginLoader$1
  implements Runnable
{
  public void run()
  {
    String str;
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      str = aazg.a(this.this$0) + this.this$0.b;
      if (!new File(str).exists())
      {
        this.a.notifyUI(3, true, Integer.valueOf(1));
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new File(this.this$0.c);
        if (!this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getString("sp_key_version_prefix" + this.this$0.b, "-1").equals(this.this$0.d))
        {
          if (!((File)localObject3).exists()) {
            continue;
          }
          bgmg.a(((File)localObject3).getAbsolutePath());
          this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("sp_key_version_prefix" + this.this$0.b, nko.a(this.this$0.jdField_a_of_type_JavaLangString)).commit();
          ((File)localObject3).mkdirs();
        }
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        localObject3 = PluginUtils.getPluginLibPath(BaseApplicationImpl.getContext(), this.this$0.b).getCanonicalPath();
        if (this.this$0.jdField_a_of_type_JavaLangClassLoader == null) {
          this.this$0.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader(str, this.this$0.c, (String)localObject3, BaseApplicationImpl.getContext().getClassLoader());
        }
        this.this$0.e = str;
        if (QLog.isColorLevel()) {
          QLog.i("ViewPluginLoader", 2, "load werewolves local plugin success,path = " + str);
        }
        this.this$0.jdField_a_of_type_Boolean = true;
        this.a.notifyUI(3, true, Integer.valueOf(0));
      }
      catch (Exception localException)
      {
        Object localObject3;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ViewPluginLoader", 2, "load error msg = " + localException.getMessage(), localException);
        this.a.notifyUI(3, true, Integer.valueOf(3));
        continue;
      }
      return;
      localObject2 = finally;
      throw localObject2;
      ((File)localObject3).mkdirs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.1
 * JD-Core Version:    0.7.0.1
 */