import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import dov.com.qq.im.ae.download.AEResUtil.1;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bnpy
{
  public static final String a = anni.a(2131707496);
  
  public static int a(int paramInt)
  {
    return bnyp.a().a("key_ae_res_" + paramInt, 0, 4);
  }
  
  public static int a(bnpt parambnpt)
  {
    int i;
    if (bcls.a()) {
      if (b(parambnpt)) {
        i = 1;
      }
    }
    for (;;)
    {
      bnzb.a("AEResUtil", "getFilterSoState " + i);
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    bnzb.a("AEResUtil", paramString1 + "|verifyResource() lResMd5=" + paramString2 + ", filepath=" + paramString3);
    if (TextUtils.isEmpty(paramString3))
    {
      bnzb.d("AEResUtil", "[verifyResource] filePath :null");
      return -105;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      bnzb.d("AEResUtil", "[verifyResource] lResMd5 :null");
      return -106;
    }
    File localFile = new File(paramString3);
    if (!localFile.exists())
    {
      bnzb.d("AEResUtil", paramString1 + "|verifyResource() file[" + paramString3 + "] not exist..");
      return -107;
    }
    Object localObject = null;
    try
    {
      paramString3 = bgmj.a(MD5.getFileMd5(paramString3));
      bnzb.a("AEResUtil", paramString1 + "|verifyResource()  lResMd5=" + paramString2 + ",md5=" + paramString3);
      if (paramString2.equalsIgnoreCase(paramString3)) {
        return 0;
      }
    }
    catch (UnsatisfiedLinkError paramString3)
    {
      for (;;)
      {
        try
        {
          paramString3 = bkcx.a(localFile);
        }
        catch (Exception paramString3)
        {
          paramString3.printStackTrace();
          paramString3 = localObject;
        }
      }
      bnzb.d("AEResUtil", "[verifyResource] equalsIgnoreCase :false");
    }
    return -108;
  }
  
  public static int a(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    Object localObject = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)((Iterator)localObject).next();
    } while ((!localSVConfigItem.name.startsWith(bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString)) || (localSVConfigItem.versionCode != bnpt.jdField_b_of_type_Bnpt.jdField_c_of_type_Int));
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localSVConfigItem.name.substring(bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString.length())).intValue();
        if (i < bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_Int) {
          break;
        }
        i = 0;
        if (i != 0)
        {
          bnzb.d("AEResUtil", "[checkConfigUsable] status:" + i);
          return i;
        }
      }
      catch (Exception localException2)
      {
        bnzb.d("AEResUtil", "[checkConfigUsable] String2int error :" + localSVConfigItem.name);
        i = 0;
        continue;
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject = (ShortVideoResourceManager.SVConfigItem)paramList.next();
          if ((!((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(bnpt.jdField_c_of_type_Bnpt.jdField_b_of_type_JavaLangString)) || (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode != bnpt.jdField_c_of_type_Bnpt.jdField_c_of_type_Int)) {
            continue;
          }
          try
          {
            i = Integer.valueOf(((ShortVideoResourceManager.SVConfigItem)localObject).name.substring(bnpt.jdField_c_of_type_Bnpt.jdField_b_of_type_JavaLangString.length())).intValue();
            if (i < bnpt.jdField_c_of_type_Bnpt.jdField_b_of_type_Int) {
              continue;
            }
            return 0;
          }
          catch (Exception localException1)
          {
            bnzb.d("AEResUtil", "[checkConfigUsable] String2int error :" + ((ShortVideoResourceManager.SVConfigItem)localObject).name);
            i = 0;
            continue;
          }
        }
        return -103;
      }
      int i = -103;
    }
  }
  
  public static String a()
  {
    return bndn.a;
  }
  
  @NonNull
  public static String a(@NonNull bnpt parambnpt)
  {
    if (!parambnpt.jdField_a_of_type_Boolean) {
      return "";
    }
    if ((bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString.equals(parambnpt.jdField_b_of_type_JavaLangString)) || (bnpt.jdField_c_of_type_Bnpt.jdField_b_of_type_JavaLangString.equals(parambnpt.jdField_b_of_type_JavaLangString))) {
      return b();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    return ShortVideoResourceManager.a(paramString);
  }
  
  public static void a()
  {
    bckr.a().a("CMD_DOWNLOAD_PTU_ADDITIONAL_RES", new Bundle());
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    bnyp.a().a("key_ae_res_" + paramInt1, paramInt2, 4);
  }
  
  public static void a(Context paramContext)
  {
    if (!bgnt.h(paramContext)) {
      ThreadManager.getUIHandler().post(new AEResUtil.1(paramContext));
    }
    for (;;)
    {
      bnzb.d("AEResUtil", "【Camera is in Prepareing】tryDownloadAEResAdditionPackage");
      return;
      bnzb.d("AEResUtil", "【Camera is in Prepareing wifi】prepare to download");
      a();
    }
  }
  
  public static void a(bnpt parambnpt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(parambnpt.jdField_b_of_type_JavaLangString);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("ae_camera_res_downloadfinish_path", paramString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static boolean a()
  {
    return FeatureManager.isBasicFeaturesFunctionReady();
  }
  
  public static boolean a(@NonNull bnpt parambnpt)
  {
    int i = a(parambnpt.jdField_a_of_type_Int);
    bnzb.d("AEResUtil", "[checkAEResVersionOK] packageVersion:" + i);
    bnzb.d("AEResUtil", "[checkAEResVersionOK] aeResInfo.resVersionLimit:" + parambnpt.jdField_b_of_type_Int);
    return i >= parambnpt.jdField_b_of_type_Int;
  }
  
  public static boolean a(@NonNull String paramString)
  {
    paramString = bndn.jdField_b_of_type_JavaLangString + paramString + File.separator;
    bnyp.a().a("aeres_copy_final_path_key", paramString, 4);
    if (bnyp.a().a("aeres_copy_final_path_key", bndn.jdField_b_of_type_JavaLangString, 4).equals(paramString))
    {
      bnzb.a("AEResUtil", "[saveAEResUnzipFinalPath] success");
      return true;
    }
    bnzb.d("AEResUtil", "[saveAEResUnzipFinalPath] error");
    return false;
  }
  
  public static boolean a(@NonNull String paramString, @NonNull bnpt parambnpt)
  {
    bnyp.a().a(parambnpt.jdField_b_of_type_JavaLangString + parambnpt.jdField_c_of_type_Int + "aeres_unzip_path_key", paramString, 4);
    if (paramString.equals(bnyp.a().a(parambnpt.jdField_b_of_type_JavaLangString + parambnpt.jdField_c_of_type_Int + "aeres_unzip_path_key", "", 4)))
    {
      bnzb.a("AEResUtil", "[saveAEResUnzipPath] success");
      return true;
    }
    bnzb.d("AEResUtil", "[saveAEResUnzipPath] error");
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    File localFile = new File(paramString2);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      bool = false;
    }
    int i;
    do
    {
      return bool;
      i = bgmg.a(paramString2, bndn.jdField_b_of_type_JavaLangString + paramString1 + File.separator, false, true, true);
      bnzb.d("AEResUtil", "copyResFileToFinalDir errorcode:" + i + ", fromPath:" + paramString2);
    } while (i == 0);
    return false;
  }
  
  public static String b()
  {
    return d();
  }
  
  public static String b(@NonNull bnpt parambnpt)
  {
    String str = c(parambnpt);
    if (TextUtils.isEmpty(str))
    {
      bnzb.d("AEResUtil", "[getAEResPath] pathVersion null");
      return null;
    }
    if (!bcdq.a(str, parambnpt.jdField_b_of_type_Int))
    {
      bnzb.d("AEResUtil", "[getAEResPath] pathVersion is not > limitVersion");
      return null;
    }
    return a() + str + File.separator;
  }
  
  public static void b()
  {
    bckr.a().a("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
  }
  
  public static boolean b()
  {
    return FeatureManager.Features.FACE_DETECT.isAllSoVersionOk();
  }
  
  public static boolean b(bnpt parambnpt)
  {
    String str = b(parambnpt);
    if (str == null)
    {
      bnzb.d("AEResUtil", "[isAEBaseResExist] soRootPath == null");
      return false;
    }
    if (!new File(str).exists())
    {
      bnzb.d("AEResUtil", "[isAEBaseResExist] exists = false");
      return false;
    }
    if (parambnpt.jdField_a_of_type_Int == bnpt.jdField_b_of_type_Bnpt.jdField_a_of_type_Int) {
      return FeatureManager.isBasicFeaturesReadyInDir(str);
    }
    return true;
  }
  
  public static String c()
  {
    return bndw.a + File.separator;
  }
  
  private static String c(@NonNull bnpt parambnpt)
  {
    return bnyp.a().a(parambnpt.jdField_b_of_type_JavaLangString + parambnpt.jdField_c_of_type_Int + "aeres_unzip_path_key", "", 4);
  }
  
  private static void c(@NonNull Context paramContext)
  {
    Bundle localBundle = bckr.a().a("CMD_QUERY_STATUS_PTU_RES", new Bundle());
    int i = 0;
    if (localBundle != null) {
      i = localBundle.getInt("VALUE_MSG_PTU_RES_STATUS");
    }
    if ((i == 0) || (!a(bnpt.jdField_c_of_type_Bnpt)))
    {
      bglp.a(paramContext, 230).setMessage(a).setPositiveButton(paramContext.getString(2131693473), new bnqa()).setNegativeButton(paramContext.getString(2131693469), new bnpz()).show();
      return;
    }
    bnzb.a("AEResUtil", "[showDialog] is downloading");
    QQToast.a(paramContext, 2131689667, 1).a();
  }
  
  public static boolean c()
  {
    try
    {
      if (!a())
      {
        bndd.a();
        bool = FeatureManager.loadBasicFeatures();
        bnzb.d("AEResUtil", "SoLoader.loadSvFilterSo success:" + bool);
      }
      boolean bool = a();
      return bool;
    }
    finally {}
  }
  
  private static String d()
  {
    return bnyp.a().a("aeres_copy_final_path_key", bndn.jdField_b_of_type_JavaLangString, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpy
 * JD-Core Version:    0.7.0.1
 */