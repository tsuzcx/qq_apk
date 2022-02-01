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
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ViewPluginManager", 4, "transToLocalUrl transUrl:" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.d = HtmlOffline.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString);
    String str = OfflineEnvHelper.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString + "/" + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.b;
    try
    {
      Object localObject = new File(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.c);
      if (!this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString), "-1").equals(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.d))
      {
        if (!((File)localObject).exists()) {
          break label379;
        }
        FileUtils.a(((File)localObject).getAbsolutePath());
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString), HtmlOffline.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString)).commit();
        ((File)localObject).mkdirs();
      }
      for (;;)
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.b).getCanonicalPath();
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader(str, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.c, (String)localObject, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(this.jdField_a_of_type_AndroidContentContext, 0, str, null, null, this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack.loaded(paramInt, paramString);
        return;
        label379:
        ((File)localObject).mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginManager", 2, "create classloader failed:" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager.2
 * JD-Core Version:    0.7.0.1
 */