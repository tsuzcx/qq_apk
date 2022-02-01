package com.tencent.aelight.camera.ae.download.old;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class AEOldResUtil
{
  public static final String a = HardCodeUtil.a(2131708717);
  
  public static int a(int paramInt)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_ae_res_");
    localStringBuilder.append(paramInt);
    return localAECameraPrefsUtil.a(localStringBuilder.toString(), 0, 4);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|verifyResource() lResMd5=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", filepath=");
    localStringBuilder.append(paramString3);
    AEQLog.a("AEOldResUtil", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString3))
    {
      AEQLog.d("AEOldResUtil", "[verifyResource] filePath :null");
      return -105;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      AEQLog.d("AEOldResUtil", "[verifyResource] lResMd5 :null");
      return -106;
    }
    File localFile = new File(paramString3);
    if (!localFile.exists())
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("|verifyResource() file[");
      paramString2.append(paramString3);
      paramString2.append("] not exist..");
      AEQLog.d("AEOldResUtil", paramString2.toString());
      return -107;
    }
    localStringBuilder = null;
    for (;;)
    {
      try
      {
        paramString3 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString3));
      }
      catch (UnsatisfiedLinkError paramString3)
      {
        continue;
      }
      try
      {
        paramString3 = MD5FileUtil.a(localFile);
      }
      catch (Exception paramString3)
      {
        paramString3.printStackTrace();
        paramString3 = localStringBuilder;
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|verifyResource()  lResMd5=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",md5=");
    localStringBuilder.append(paramString3);
    AEQLog.a("AEOldResUtil", localStringBuilder.toString());
    if (paramString2.equalsIgnoreCase(paramString3)) {
      return 0;
    }
    AEQLog.d("AEOldResUtil", "[verifyResource] equalsIgnoreCase :false");
    return -108;
  }
  
  public static int a(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    paramList = paramList.iterator();
    int j;
    label89:
    do
    {
      AEOldShortVideoResManager.SVConfigItem localSVConfigItem;
      do
      {
        boolean bool = paramList.hasNext();
        j = 0;
        if (!bool) {
          break;
        }
        localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)paramList.next();
      } while ((!localSVConfigItem.name.startsWith(AEOldResInfo.jdField_b_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo.jdField_b_of_type_JavaLangString)) || (localSVConfigItem.versionCode != AEOldResInfo.jdField_b_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo.c));
      try
      {
        i = Integer.valueOf(localSVConfigItem.name.substring(AEOldResInfo.jdField_b_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo.jdField_b_of_type_JavaLangString.length())).intValue();
      }
      catch (Exception localException)
      {
        int i;
        StringBuilder localStringBuilder;
        break label89;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkConfigUsable] String2int error :");
      localStringBuilder.append(localSVConfigItem.name);
      AEQLog.d("AEOldResUtil", localStringBuilder.toString());
      i = 0;
    } while (i < AEOldResInfo.jdField_b_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo.jdField_b_of_type_Int);
    i = j;
    break label147;
    i = -103;
    label147:
    if (i != 0)
    {
      paramList = new StringBuilder();
      paramList.append("[checkConfigUsable] status:");
      paramList.append(i);
      AEQLog.d("AEOldResUtil", paramList.toString());
      return i;
    }
    return -103;
  }
  
  public static String a()
  {
    return AEOldPath.CAMERA.INTERNAL_FILES.a;
  }
  
  @NonNull
  public static String a(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    if (!paramAEOldResInfo.a) {
      return "";
    }
    if (AEOldResInfo.jdField_b_of_type_ComTencentAelightCameraDownloadOldApiAEOldResInfo.jdField_b_of_type_JavaLangString.equals(paramAEOldResInfo.jdField_b_of_type_JavaLangString)) {
      return b();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    return AEOldShortVideoResManager.a(paramString);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_ae_res_");
    localStringBuilder.append(paramInt1);
    localAECameraPrefsUtil.a(localStringBuilder.toString(), paramInt2, 4);
  }
  
  public static void a(AEOldResInfo paramAEOldResInfo, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramAEOldResInfo.jdField_b_of_type_JavaLangString);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("ae_camera_res_downloadfinish_path", paramString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static boolean a(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEOldPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    paramString = localStringBuilder.toString();
    AECameraPrefsUtil.a().a("aeres_copy_old_final_path_key", paramString, 4);
    if (AECameraPrefsUtil.a().a("aeres_copy_old_final_path_key", AEOldPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString, 4).equals(paramString))
    {
      AEQLog.a("AEOldResUtil", "[saveAEResUnzipFinalPath] success");
      return true;
    }
    AEQLog.d("AEOldResUtil", "[saveAEResUnzipFinalPath] error");
    return false;
  }
  
  public static boolean a(@NonNull String paramString, @NonNull AEOldResInfo paramAEOldResInfo)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAEOldResInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(paramAEOldResInfo.c);
    localStringBuilder.append("aeres_unzip_old_path_key");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), paramString, 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAEOldResInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(paramAEOldResInfo.c);
    localStringBuilder.append("aeres_unzip_old_path_key");
    if (paramString.equals(localAECameraPrefsUtil.a(localStringBuilder.toString(), "", 4)))
    {
      AEQLog.a("AEOldResUtil", "[saveAEResUnzipPath] success");
      return true;
    }
    AEQLog.d("AEOldResUtil", "[saveAEResUnzipPath] error");
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString2);
    if (((File)localObject).exists())
    {
      if (!((File)localObject).isDirectory()) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AEOldPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(File.separator);
      int i = FileUtils.copyDirectory(paramString2, ((StringBuilder)localObject).toString(), false, true, true);
      paramString1 = new StringBuilder();
      paramString1.append("copyResFileToFinalDir errorcode:");
      paramString1.append(i);
      paramString1.append(", fromPath:");
      paramString1.append(paramString2);
      AEQLog.d("AEOldResUtil", paramString1.toString());
      return i == 0;
    }
    return false;
  }
  
  public static String b()
  {
    return d();
  }
  
  @NonNull
  public static String b(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    if (!paramAEOldResInfo.a) {
      return "";
    }
    return b();
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEOldPathBase.TMP.a);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String c(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    String str = d(paramAEOldResInfo);
    if (TextUtils.isEmpty(str))
    {
      AEQLog.d("AEOldResUtil", "[getAEResPath] pathVersion null");
      return null;
    }
    if (!AEOldPendantVersionManager.a(str, paramAEOldResInfo.jdField_b_of_type_Int))
    {
      AEQLog.d("AEOldResUtil", "[getAEResPath] pathVersion is not > limitVersion");
      return null;
    }
    paramAEOldResInfo = new StringBuilder();
    paramAEOldResInfo.append(a());
    paramAEOldResInfo.append(str);
    paramAEOldResInfo.append(File.separator);
    return paramAEOldResInfo.toString();
  }
  
  private static String d()
  {
    return AECameraPrefsUtil.a().a("aeres_copy_old_final_path_key", AEOldPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString, 4);
  }
  
  private static String d(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAEOldResInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(paramAEOldResInfo.c);
    localStringBuilder.append("aeres_unzip_old_path_key");
    return localAECameraPrefsUtil.a(localStringBuilder.toString(), "", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldResUtil
 * JD-Core Version:    0.7.0.1
 */