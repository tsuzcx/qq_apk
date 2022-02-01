package com.tencent.aelight.camera.ae.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.INTERNAL_FILES;
import com.tencent.aelight.camera.ae.AEPathBase.TMP;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.PendantVersionManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCClient;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import eipc.EIPCClient;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class AEResUtil
{
  public static final Map<String, AEResInfo> a = ;
  public static final String b = HardCodeUtil.a(2131906498);
  private static final Map<AEResInfo, String> c = q();
  private static final Map<AEResInfo, Integer> d = r();
  
  public static int a(int paramInt)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_ae_light_res_");
    localStringBuilder.append(paramInt);
    return localAECameraPrefsUtil.b(localStringBuilder.toString(), 0, 4);
  }
  
  public static int a(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial.needHandDetect()) && (!d(AEResInfo.LIGHT_RES_BUNDLE_HAND))) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (paramVideoMaterial.needDetectGender())
    {
      i = j;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_GENDER)) {
        i = j | 0x2;
      }
    }
    int j = i;
    if (paramVideoMaterial.needDetectCat())
    {
      j = i;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_CAT)) {
        j = i | 0x4;
      }
    }
    i = j;
    if (paramVideoMaterial.needRGBDepth())
    {
      i = j;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_DEPTH)) {
        i = j | 0x8;
      }
    }
    j = i;
    if (paramVideoMaterial.needHairSegment())
    {
      j = i;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR)) {
        j = i | 0x20;
      }
    }
    i = j;
    if (paramVideoMaterial.needSkySegment())
    {
      i = j;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY)) {
        i = j | 0x10;
      }
    }
    j = i;
    if (paramVideoMaterial.needAce3D())
    {
      j = i;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_ACE3D)) {
        j = i | 0x40;
      }
    }
    i = j;
    if (paramVideoMaterial.need3DMM())
    {
      i = j;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_3DMM)) {
        i = j | 0x80;
      }
    }
    j = i;
    if (paramVideoMaterial.needHeadSegment())
    {
      j = i;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD)) {
        j = i | 0x100;
      }
    }
    i = j;
    if (paramVideoMaterial.needBodyDetect())
    {
      i = j;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_BODY)) {
        i = j | 0x800;
      }
    }
    j = i;
    if (paramVideoMaterial.needEmotion())
    {
      j = i;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_EMOTION)) {
        j = i | 0x400;
      }
    }
    i = j;
    if (paramVideoMaterial.needGazeDetect())
    {
      i = j;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_GAZE)) {
        i = j | 0x2000;
      }
    }
    j = i;
    if (paramVideoMaterial.needBody3D())
    {
      j = i;
      if (!d(AEResInfo.LIGHT_RES_BUNDLE_BODY_3D)) {
        j = i | 0x4000;
      }
    }
    return j;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|verifyResource() lResMd5=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", filepath=");
    localStringBuilder.append(paramString3);
    AEQLog.a("AEResUtil", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString3))
    {
      AEQLog.d("AEResUtil", "[verifyResource] filePath :null");
      return -105;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      AEQLog.d("AEResUtil", "[verifyResource] lResMd5 :null");
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
      AEQLog.d("AEResUtil", paramString2.toString());
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
    AEQLog.a("AEResUtil", localStringBuilder.toString());
    if (paramString2.equalsIgnoreCase(paramString3)) {
      return 0;
    }
    AEQLog.d("AEResUtil", "[verifyResource] equalsIgnoreCase :false");
    return -108;
  }
  
  public static int a(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i = -103;
    int j;
    label163:
    do
    {
      ShortVideoResourceManager.SVConfigItem localSVConfigItem;
      do
      {
        do
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
        } while ((localSVConfigItem == null) || (TextUtils.isEmpty(localSVConfigItem.name)));
        localStringBuilder = null;
        AEResInfo[] arrayOfAEResInfo = AEResInfo.packageValues;
        k = arrayOfAEResInfo.length;
        j = 0;
        for (;;)
        {
          paramList = localStringBuilder;
          if (j >= k) {
            break;
          }
          paramList = arrayOfAEResInfo[j];
          if ((paramList != null) && (!TextUtils.isEmpty(paramList.resPrefix)) && (localSVConfigItem.name.startsWith(paramList.resPrefix))) {
            break;
          }
          j += 1;
        }
      } while (paramList == null);
      j = i;
      if (localSVConfigItem.versionCode == paramList.resVersion) {}
      try
      {
        k = Integer.parseInt(localSVConfigItem.name.substring(paramList.resPrefix.length()));
      }
      catch (Throwable localThrowable)
      {
        break label163;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkConfigUsable] String2int error :");
      localStringBuilder.append(localSVConfigItem.name);
      AEQLog.d("AEResUtil", localStringBuilder.toString());
      int k = 0;
      j = i;
      if (k >= paramList.resVersionLimit) {
        j = 0;
      }
      i = j;
    } while (j == 0);
    return j;
  }
  
  @NonNull
  public static String a(@NonNull AEResInfo paramAEResInfo)
  {
    if (!paramAEResInfo.isPackage) {
      return "";
    }
    return c();
  }
  
  public static String a(String paramString)
  {
    return ShortVideoResourceManager.a(paramString);
  }
  
  public static Map<AEResInfo, String> a()
  {
    return c;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_ae_light_res_");
    localStringBuilder.append(paramInt1);
    localAECameraPrefsUtil.a(localStringBuilder.toString(), paramInt2, 4);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    if (a(paramLong, 1))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载HAND");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_HAND.resPrefix);
    }
    if (a(paramLong, 2))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载GENDER");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_GENDER.resPrefix);
    }
    if (a(paramLong, 4096))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载AGE");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_AGE.resPrefix);
    }
    if (a(paramLong, 8192))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载GAZE");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_GAZE.resPrefix);
    }
    if (a(paramLong, 4))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载CAT");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_CAT.resPrefix);
    }
    if (a(paramLong, 8))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载DEPT");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_DEPTH.resPrefix);
    }
    if (a(paramLong, 32))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载HAIR");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR.resPrefix);
    }
    if (a(paramLong, 16))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载SKY");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY.resPrefix);
    }
    if (a(paramLong, 64))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载3D");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_ACE3D.resPrefix);
    }
    if (a(paramLong, 128))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载3DMM");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_3DMM.resPrefix);
    }
    if (a(paramLong, 256))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载HEAD");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD.resPrefix);
    }
    if (a(paramLong, 512))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载SCENE");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_SCENE.resPrefix);
    }
    if (a(paramLong, 2048))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载BODY");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_BODY.resPrefix);
    }
    if (a(paramLong, 1024))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载EMOTION");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_EMOTION.resPrefix);
    }
    if (a(paramLong, 16384))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载BODY 3D");
      a(paramContext, AEResInfo.LIGHT_RES_BUNDLE_BODY_3D.resPrefix);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!NetworkUtil.isWifiConnected(paramContext))
    {
      ThreadManager.getUIHandler().post(new AEResUtil.1(paramContext, paramString));
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("【tryDownloadLightAdditionBundle】wifi网络 : request download --> prefix:");
    paramContext.append(paramString);
    AEQLog.d("PreCheckAERes", paramContext.toString());
    c(paramString);
  }
  
  public static void a(AEResInfo paramAEResInfo, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramAEResInfo.resPrefix);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("下载完成 发送广播");
    localStringBuilder.append(paramAEResInfo.resPrefix);
    AEQLog.a("AEResUtil", localStringBuilder.toString());
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("ae_camera_res_downloadfinish_path", paramString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private static boolean a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("status:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" bundle:");
    localStringBuilder.append(paramInt);
    AEQLog.a("AEResUtil", localStringBuilder.toString());
    long l = paramInt;
    return (paramLong & l) == l;
  }
  
  public static boolean a(@NonNull String paramString, @NonNull AEResInfo paramAEResInfo)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAEResInfo.resPrefix);
    localStringBuilder.append(paramAEResInfo.resVersion);
    localStringBuilder.append("aeres_unzip_path_key");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), paramString, 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAEResInfo.resPrefix);
    localStringBuilder.append(paramAEResInfo.resVersion);
    localStringBuilder.append("aeres_unzip_path_key");
    if (paramString.equals(localAECameraPrefsUtil.b(localStringBuilder.toString(), "", 4)))
    {
      AEQLog.a("AEResUtil", "[saveAEResUnzipPath] success");
      return true;
    }
    AEQLog.d("AEResUtil", "[saveAEResUnzipPath] error");
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
      ((StringBuilder)localObject).append(AEPath.CAMERA.INTERNAL_FILES.b);
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(File.separator);
      int i = FileUtils.copyDirectory(paramString2, ((StringBuilder)localObject).toString(), false, true, true);
      paramString1 = new StringBuilder();
      paramString1.append("copyResFileToFinalDir errorcode:");
      paramString1.append(i);
      paramString1.append(", fromPath:");
      paramString1.append(paramString2);
      AEQLog.d("AEResUtil", paramString1.toString());
      return i == 0;
    }
    return false;
  }
  
  public static int b(List<AEResInfo> paramList)
  {
    int j = 0;
    int i = 0;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return 0;
      }
      paramList = paramList.iterator();
      for (;;)
      {
        j = i;
        if (!paramList.hasNext()) {
          break;
        }
        AEResInfo localAEResInfo = (AEResInfo)paramList.next();
        if (!d(localAEResInfo))
        {
          Object localObject = (Integer)d.get(localAEResInfo);
          if (localObject != null)
          {
            i |= ((Integer)localObject).intValue();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localAEResInfo.description);
            ((StringBuilder)localObject).append(" need download.");
            QLog.i("AEResUtil", 4, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    return j;
  }
  
  public static String b()
  {
    return AEPath.CAMERA.INTERNAL_FILES.a;
  }
  
  public static String b(@NonNull AEResInfo paramAEResInfo)
  {
    String str = g(paramAEResInfo);
    if (TextUtils.isEmpty(str))
    {
      AEQLog.d("AEResUtil", "[getAEResPath] pathVersion null");
      return null;
    }
    if (!PendantVersionManager.a(str, paramAEResInfo.resVersionLimit))
    {
      AEQLog.d("AEResUtil", "[getAEResPath] pathVersion is not > limitVersion");
      return null;
    }
    paramAEResInfo = new StringBuilder();
    paramAEResInfo.append(b());
    paramAEResInfo.append(str);
    paramAEResInfo.append(File.separator);
    return paramAEResInfo.toString();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (!NetworkUtil.isWifiConnected(paramContext))
    {
      ThreadManager.getUIHandler().post(new AEResUtil.2(paramContext, paramString));
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("【tryDownloadLightAdditionBundle】wifi网络 : request download --> prefix:");
    paramContext.append(paramString);
    AEQLog.d("PreCheckAERes", paramContext.toString());
    c(paramString);
  }
  
  public static boolean b(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.CAMERA.INTERNAL_FILES.b);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    paramString = localStringBuilder.toString();
    AECameraPrefsUtil.a().a("aeres_copy_final_path_key", paramString, 4);
    if (AECameraPrefsUtil.a().b("aeres_copy_final_path_key", AEPath.CAMERA.INTERNAL_FILES.b, 4).equals(paramString))
    {
      AEQLog.a("AEResUtil", "[saveAEResUnzipFinalPath] success");
      return true;
    }
    AEQLog.d("AEResUtil", "[saveAEResUnzipFinalPath] error");
    return false;
  }
  
  public static String c()
  {
    return p();
  }
  
  private static void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_RES_PREFIX", paramString);
    QIPCClientHelper.getInstance().getClient().callServer("AECameraGetInfoServer", "ACTION_DOWNLOAD_AE_RES", localBundle);
  }
  
  public static boolean c(@NonNull AEResInfo paramAEResInfo)
  {
    int i = a(paramAEResInfo.index);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[checkAEResVersionOK] packageVersion:");
    localStringBuilder.append(i);
    AEQLog.d("PreCheckAERes", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[checkAEResVersionOK] aeResInfo.resVersionLimit:");
    localStringBuilder.append(paramAEResInfo.resVersionLimit);
    AEQLog.d("PreCheckAERes", localStringBuilder.toString());
    return i >= paramAEResInfo.resVersionLimit;
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPathBase.TMP.a);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean d(AEResInfo paramAEResInfo)
  {
    int i = a(paramAEResInfo.index);
    int j = paramAEResInfo.resVersionLimit;
    boolean bool2 = false;
    if (i < j)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isAEResExist] savedVersion=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("aeResInfo=");
      ((StringBuilder)localObject).append(paramAEResInfo);
      AEQLog.d("AEResUtil", ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = c();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isAEResExist] soRootPath=null, aeResInfo=");
      ((StringBuilder)localObject).append(paramAEResInfo);
      AEQLog.d("AEResUtil", ((StringBuilder)localObject).toString());
      return false;
    }
    if (!new File((String)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isAEResExist] exists=false, aeResInfo=");
      ((StringBuilder)localObject).append(paramAEResInfo);
      AEQLog.d("AEResUtil", ((StringBuilder)localObject).toString());
      return false;
    }
    if (paramAEResInfo == AEResInfo.AE_RES_BASE_PACKAGE)
    {
      boolean bool1 = bool2;
      if (FeatureManager.Features.YT_COMMON.isSoReadyInDirectory((String)localObject))
      {
        bool1 = bool2;
        if (FeatureManager.Features.PTU_ALGO.isSoReadyInDirectory((String)localObject))
        {
          bool1 = bool2;
          if (FeatureManager.Features.PTU_TOOLS.isSoReadyInDirectory((String)localObject)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (paramAEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE) {
      return FeatureManager.Features.LIGHT_SDK.isSoReadyInDirectory((String)localObject);
    }
    if ((paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_HAND) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_GENDER) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_AGE) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_GAZE) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_CAT) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_DEPTH) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_ACE3D) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_3DMM) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_SCENE) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_BODY) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_BODY_3D) && (paramAEResInfo != AEResInfo.LIGHT_RES_BUNDLE_EMOTION)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append((String)c.get(paramAEResInfo));
    localObject = new File(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isAEResExist] exists=");
    localStringBuilder.append(((File)localObject).exists());
    localStringBuilder.append(", aeResInfo=");
    localStringBuilder.append(paramAEResInfo);
    AEQLog.a("AEResUtil", localStringBuilder.toString());
    return ((File)localObject).exists();
  }
  
  public static int e(AEResInfo paramAEResInfo)
  {
    int i;
    if (PtvFilterSoLoad.a())
    {
      if (d(paramAEResInfo)) {
        i = 1;
      } else {
        i = 2;
      }
    }
    else {
      i = 0;
    }
    paramAEResInfo = new StringBuilder();
    paramAEResInfo.append("getFilterSoState ");
    paramAEResInfo.append(i);
    AEQLog.a("AEResUtil", paramAEResInfo.toString());
    return i;
  }
  
  private static void e(@NonNull Context paramContext, String paramString)
  {
    paramContext = new Bundle();
    paramContext.putString("VALUE_MSG_LIGHT_BUNDLE_PREFIX", paramString);
    paramContext = VideoPlayIPCClient.a().a("CMD_QUERY_STATUS_PTU_RES", paramContext);
    int i;
    if (paramContext != null)
    {
      i = paramContext.getInt("VALUE_MSG_PTU_RES_STATUS");
      paramContext = new StringBuilder();
      paramContext.append("【showLightBundleDownloadDialog】query bundle file status: ");
      paramContext.append(i);
      AEQLog.a("PreCheckAERes", paramContext.toString());
    }
    else
    {
      i = 0;
    }
    if ((i != 0) && (c(AEResInfo.LIGHT_RES_BASE_PACKAGE)))
    {
      paramContext = new StringBuilder();
      paramContext.append("[showLightBundleDownloadDialog] is already downloading, prefix = ");
      paramContext.append(paramString);
      AEQLog.a("PreCheckAERes", paramContext.toString());
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("【showLightBundleDownloadDialog】dialog: choose sure, prefix = ");
    paramContext.append(paramString);
    AEQLog.a("PreCheckAERes", paramContext.toString());
    c(paramString);
  }
  
  public static boolean e()
  {
    return FeatureManager.isBasicFeaturesFunctionReady();
  }
  
  public static String f(@NonNull AEResInfo paramAEResInfo)
  {
    if (!d(paramAEResInfo))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLightBundleDir:");
      localStringBuilder.append(paramAEResInfo.resPrefix);
      localStringBuilder.append("资源不存在，返回空path");
      AEQLog.d("AEResUtil", localStringBuilder.toString());
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append((String)c.get(paramAEResInfo));
    return localStringBuilder.toString();
  }
  
  private static void f(@NonNull Context paramContext, String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("VALUE_MSG_LIGHT_BUNDLE_PREFIX", paramString);
    localObject = VideoPlayIPCClient.a().a("CMD_QUERY_STATUS_PTU_RES", (Bundle)localObject);
    int i;
    if (localObject != null)
    {
      i = ((Bundle)localObject).getInt("VALUE_MSG_PTU_RES_STATUS");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【showLightBundleDownloadDialog】query bundle file status: ");
      ((StringBuilder)localObject).append(i);
      AEQLog.a("PreCheckAERes", ((StringBuilder)localObject).toString());
    }
    else
    {
      i = 0;
    }
    if ((i != 0) && (c(AEResInfo.LIGHT_RES_BASE_PACKAGE)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[showLightBundleDownloadDialog] is already downloading, prefix = ");
      ((StringBuilder)localObject).append(paramString);
      AEQLog.a("PreCheckAERes", ((StringBuilder)localObject).toString());
      QQToast.makeText(paramContext, 2064187392, 1).show();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("【showLightBundleDownloadDialog】dialog: choose sure, prefix = ");
    paramContext.append(paramString);
    AEQLog.a("PreCheckAERes", paramContext.toString());
    c(paramString);
  }
  
  public static boolean f()
  {
    return (d(AEResInfo.AE_RES_BASE_PACKAGE)) && (d(AEResInfo.LIGHT_RES_BASE_PACKAGE));
  }
  
  private static String g(@NonNull AEResInfo paramAEResInfo)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAEResInfo.resPrefix);
    localStringBuilder.append(paramAEResInfo.resVersion);
    localStringBuilder.append("aeres_unzip_path_key");
    return localAECameraPrefsUtil.b(localStringBuilder.toString(), "", 4);
  }
  
  public static boolean g()
  {
    int i = e(AEResInfo.AE_RES_BASE_PACKAGE);
    boolean bool = true;
    if (i == 1)
    {
      if (e(AEResInfo.LIGHT_RES_BASE_PACKAGE) != 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean h()
  {
    return FeatureManager.Features.FACE_DETECT.isAllSoVersionOk();
  }
  
  public static boolean i()
  {
    try
    {
      if (!e()) {
        if (AEKitForQQ.a())
        {
          bool = FeatureManager.loadBasicFeatures();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("SoLoader.loadSvFilterSo success:");
          localStringBuilder.append(bool);
          AEQLog.d("AEResUtil", localStringBuilder.toString());
        }
        else
        {
          AEQLog.d("AEResUtil", "SoLoader.loadSvFilterSo success: false -> AEKitForQQ init failed");
        }
      }
      boolean bool = e();
      return bool;
    }
    finally {}
  }
  
  public static void j()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_RES_PREFIX", AEResInfo.AE_RES_BASE_PACKAGE.resPrefix);
    QIPCClientHelper.getInstance().getClient().callServer("AECameraGetInfoServer", "ACTION_DOWNLOAD_AE_RES", localBundle);
    localBundle = new Bundle();
    localBundle.putString("KEY_RES_PREFIX", AEResInfo.LIGHT_RES_BASE_PACKAGE.resPrefix);
    QIPCClientHelper.getInstance().getClient().callServer("AECameraGetInfoServer", "ACTION_DOWNLOAD_AE_RES", localBundle);
  }
  
  public static String k()
  {
    if (!d(AEResInfo.LIGHT_RES_BASE_PACKAGE))
    {
      AEQLog.d("AEResUtil", "[getLightAssetsDir]: LightBasePackage not exist, return empty path!");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("assets");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String l()
  {
    if (!d(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("assets");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("material");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video_empty");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("template.json");
    return localStringBuilder.toString();
  }
  
  public static String m()
  {
    if (!d(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("assets");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("material");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video_empty_segmentation");
    return localStringBuilder.toString();
  }
  
  public static String n()
  {
    if (!d(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("assets");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("models");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private static Map<String, AEResInfo> o()
  {
    HashMap localHashMap = new HashMap();
    AEResInfo[] arrayOfAEResInfo = AEResInfo.packageValues;
    int j = arrayOfAEResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEResInfo localAEResInfo = arrayOfAEResInfo[i];
      localHashMap.put(localAEResInfo.resPrefix, localAEResInfo);
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private static String p()
  {
    return AECameraPrefsUtil.a().b("aeres_copy_final_path_key", AEPath.CAMERA.INTERNAL_FILES.b, 4);
  }
  
  private static Map<AEResInfo, String> q()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("assets");
    ((StringBuilder)localObject1).append(File.separator);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("models");
    ((StringBuilder)localObject1).append(File.separator);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = AEResInfo.LIGHT_RES_BUNDLE_HAND;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightHandModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_GENDER;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightGenderModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_AGE;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightAgeModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_CAT;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightCatModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_DEPTH;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightDepthModel.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightSegmentHair.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("LightSegmentSky.bundle");
    localStringBuilder.append(File.separator);
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject3 = AEResInfo.LIGHT_RES_BUNDLE_ACE3D;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("ace3d");
    localHashMap.put(localObject3, localStringBuilder.toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_3DMM;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("AEKit3DMM.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightSegmentHead.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_SCENE;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightSceneClassify.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_BODY;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightBodyModel.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_EMOTION;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightEmotionModel.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_GAZE;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightGazeEstimate.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("high");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = AEResInfo.LIGHT_RES_BUNDLE_BODY_3D;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("LightBody3DModel.bundle");
    ((StringBuilder)localObject3).append(File.separator);
    localHashMap.put(localObject2, ((StringBuilder)localObject3).toString());
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private static Map<AEResInfo, Integer> r()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_HAND, Integer.valueOf(1));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_GENDER, Integer.valueOf(2));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_AGE, Integer.valueOf(4096));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_GAZE, Integer.valueOf(8192));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_CAT, Integer.valueOf(4));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_DEPTH, Integer.valueOf(8));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR, Integer.valueOf(32));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY, Integer.valueOf(16));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_ACE3D, Integer.valueOf(64));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_3DMM, Integer.valueOf(128));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD, Integer.valueOf(256));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_SCENE, Integer.valueOf(512));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_BODY, Integer.valueOf(2048));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_BODY_3D, Integer.valueOf(16384));
    localHashMap.put(AEResInfo.LIGHT_RES_BUNDLE_EMOTION, Integer.valueOf(1024));
    return Collections.unmodifiableMap(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResUtil
 * JD-Core Version:    0.7.0.1
 */