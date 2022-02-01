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
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.i("ViewPluginManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("transToLocalUrl transUrl:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("ViewPluginManager", 4, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager;
    ((ViewPluginManager)localObject1).d = HtmlOffline.a(((ViewPluginManager)localObject1).jdField_a_of_type_JavaLangString);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(OfflineEnvHelper.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString));
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.b);
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      Object localObject2 = new File(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.c);
      if (!this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString), "-1").equals(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.d)) {
        if (((File)localObject2).exists())
        {
          FileUtils.deleteDirectory(((File)localObject2).getAbsolutePath());
          this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString), HtmlOffline.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangString)).commit();
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
      localObject2 = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.b).getCanonicalPath();
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader((String)localObject1, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.c, (String)localObject2, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(this.jdField_a_of_type_AndroidContentContext, 0, (String)localObject1, null, null, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack != null)
      {
        this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack.loaded(paramInt, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager.2
 * JD-Core Version:    0.7.0.1
 */