package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file;

import android.content.Context;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import cooperation.readinjoy.ReadInJoyHelper;

public class AssetFileManager
{
  private static String jdField_a_of_type_JavaLangString = Environment.getDataDirectory() + "/data/" + BaseApplicationImpl.sApplication.getBaseContext().getPackageName();
  private static boolean jdField_a_of_type_Boolean = a();
  
  private static boolean a()
  {
    return AppSetting.jdField_a_of_type_JavaLangString.equals(ReadInJoyHelper.a("COPY_ASSET_VERSION", "", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.file.AssetFileManager
 * JD-Core Version:    0.7.0.1
 */