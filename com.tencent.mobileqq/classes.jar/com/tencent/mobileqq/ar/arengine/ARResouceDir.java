package com.tencent.mobileqq.ar.arengine;

import android.annotation.TargetApi;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ARResouceDir
{
  public static String a()
  {
    Object localObject;
    if (a())
    {
      localObject = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARResouceDir", 2, "no_sdcard");
      }
      float f = FileUtils.getAvailableInnernalMemorySize();
      if ((f < 15728640.0F) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("inner memory avail may not enough : ");
        ((StringBuilder)localObject).append(f);
        QLog.i("AREngine_ARResouceDir", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initArResourceFilePath rootPath:=");
    localStringBuilder.append((String)localObject);
    QLog.d("AREngine_ARResouceDir", 1, localStringBuilder.toString());
    return localObject;
  }
  
  public static String a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d);
    localStringBuilder.append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.d);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("ar_cloud_transfer/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static void a(@NonNull String paramString)
  {
    try
    {
      boolean bool = FileUtils.fileExists(paramString);
      if (!bool) {
        try
        {
          FileUtils.createFile(paramString);
        }
        catch (IOException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARResouceDir", 2, "createFileIfNotExits", paramString);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  @TargetApi(18)
  public static boolean a()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return false;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("ar_relationship/");
    return localStringBuilder.toString();
  }
  
  public static String b(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      localObject = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d);
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      paramArCloudConfigInfo = localStringBuilder.toString();
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get3DModelUnzipDir error ");
      ((StringBuilder)localObject).append(paramArCloudConfigInfo.getMessage());
      QLog.i("AREngine_ARResouceDir", 2, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public static String c(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      localObject = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.a;
      String str = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d);
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      paramArCloudConfigInfo = localStringBuilder.toString();
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get3DModelLuaFilePath error ");
      ((StringBuilder)localObject).append(paramArCloudConfigInfo.getMessage());
      QLog.i("AREngine_ARResouceDir", 2, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public static String d(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource == null) {
        return "";
      }
      localObject = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.a;
      if (TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.c)) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d);
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.c);
      paramArCloudConfigInfo = localStringBuilder.toString();
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get3DModelMusicFilePath error ");
      ((StringBuilder)localObject).append(paramArCloudConfigInfo.getMessage());
      QLog.i("AREngine_ARResouceDir", 2, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public static String e(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d);
      localStringBuilder.append(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).c);
      localStringBuilder.append("_model.zip");
      paramArCloudConfigInfo = localStringBuilder.toString();
      return paramArCloudConfigInfo;
    }
    catch (Exception paramArCloudConfigInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoFilePath error ");
      localStringBuilder.append(paramArCloudConfigInfo.getMessage());
      QLog.i("AREngine_ARResouceDir", 2, localStringBuilder.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResouceDir
 * JD-Core Version:    0.7.0.1
 */