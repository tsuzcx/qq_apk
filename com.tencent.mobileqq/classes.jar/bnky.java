import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.initializer.Face3DLibInitializer;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import dov.com.qq.im.ae.download.AEResUtil.1;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bnky
{
  public static final String a = anvx.a(2131708184);
  
  public static int a(int paramInt)
  {
    return bnqu.a().a("key_ae_res_" + paramInt, 0, 4);
  }
  
  public static int a(bnkt parambnkt)
  {
    int i;
    if (bdee.a()) {
      if (b(parambnkt)) {
        i = 1;
      }
    }
    for (;;)
    {
      bnrh.a("AEResUtil", "getFilterSoState " + i);
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    bnrh.a("AEResUtil", paramString1 + "|verifyResource() lResMd5=" + paramString2 + ", filepath=" + paramString3);
    if (TextUtils.isEmpty(paramString3))
    {
      bnrh.d("AEResUtil", "[verifyResource] filePath :null");
      return -105;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      bnrh.d("AEResUtil", "[verifyResource] lResMd5 :null");
      return -106;
    }
    File localFile = new File(paramString3);
    if (!localFile.exists())
    {
      bnrh.d("AEResUtil", paramString1 + "|verifyResource() file[" + paramString3 + "] not exist..");
      return -107;
    }
    Object localObject = null;
    try
    {
      paramString3 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString3));
      bnrh.a("AEResUtil", paramString1 + "|verifyResource()  lResMd5=" + paramString2 + ",md5=" + paramString3);
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
          paramString3 = bkvq.a(localFile);
        }
        catch (Exception paramString3)
        {
          paramString3.printStackTrace();
          paramString3 = localObject;
        }
      }
      bnrh.d("AEResUtil", "[verifyResource] equalsIgnoreCase :false");
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
    } while ((!localSVConfigItem.name.startsWith(bnkt.jdField_b_of_type_Bnkt.jdField_b_of_type_JavaLangString)) || (localSVConfigItem.versionCode != bnkt.jdField_b_of_type_Bnkt.jdField_c_of_type_Int));
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localSVConfigItem.name.substring(bnkt.jdField_b_of_type_Bnkt.jdField_b_of_type_JavaLangString.length())).intValue();
        if (i < bnkt.jdField_b_of_type_Bnkt.jdField_b_of_type_Int) {
          break;
        }
        i = 0;
        if (i != 0)
        {
          bnrh.d("AEResUtil", "[checkConfigUsable] status:" + i);
          return i;
        }
      }
      catch (Exception localException2)
      {
        bnrh.d("AEResUtil", "[checkConfigUsable] String2int error :" + localSVConfigItem.name);
        i = 0;
        continue;
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject = (ShortVideoResourceManager.SVConfigItem)paramList.next();
          if ((!((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(bnkt.jdField_c_of_type_Bnkt.jdField_b_of_type_JavaLangString)) || (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode != bnkt.jdField_c_of_type_Bnkt.jdField_c_of_type_Int)) {
            continue;
          }
          try
          {
            i = Integer.valueOf(((ShortVideoResourceManager.SVConfigItem)localObject).name.substring(bnkt.jdField_c_of_type_Bnkt.jdField_b_of_type_JavaLangString.length())).intValue();
            if (i < bnkt.jdField_c_of_type_Bnkt.jdField_b_of_type_Int) {
              continue;
            }
            return 0;
          }
          catch (Exception localException1)
          {
            bnrh.d("AEResUtil", "[checkConfigUsable] String2int error :" + ((ShortVideoResourceManager.SVConfigItem)localObject).name);
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
    return bmwl.a;
  }
  
  @NonNull
  public static String a(@NonNull bnkt parambnkt)
  {
    if (!parambnkt.jdField_a_of_type_Boolean) {
      return "";
    }
    if ((bnkt.jdField_b_of_type_Bnkt.jdField_b_of_type_JavaLangString.equals(parambnkt.jdField_b_of_type_JavaLangString)) || (bnkt.jdField_c_of_type_Bnkt.jdField_b_of_type_JavaLangString.equals(parambnkt.jdField_b_of_type_JavaLangString))) {
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
    bddh.a().a("CMD_DOWNLOAD_PTU_ADDITIONAL_RES", new Bundle());
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    bnqu.a().a("key_ae_res_" + paramInt1, paramInt2, 4);
  }
  
  public static void a(Context paramContext)
  {
    if (!NetworkUtil.isWifiConnected(paramContext)) {
      ThreadManager.getUIHandler().post(new AEResUtil.1(paramContext));
    }
    for (;;)
    {
      bnrh.d("AEResUtil", "【Camera is in Prepareing】tryDownloadAEResAdditionPackage");
      return;
      bnrh.d("AEResUtil", "【Camera is in Prepareing wifi】prepare to download");
      a();
    }
  }
  
  public static void a(bnkt parambnkt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(parambnkt.jdField_b_of_type_JavaLangString);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("ae_camera_res_downloadfinish_path", paramString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static boolean a()
  {
    return FeatureManager.isBasicFeaturesFunctionReady();
  }
  
  public static boolean a(@NonNull bnkt parambnkt)
  {
    int i = a(parambnkt.jdField_a_of_type_Int);
    bnrh.d("AEResUtil", "[checkAEResVersionOK] packageVersion:" + i);
    bnrh.d("AEResUtil", "[checkAEResVersionOK] aeResInfo.resVersionLimit:" + parambnkt.jdField_b_of_type_Int);
    return i >= parambnkt.jdField_b_of_type_Int;
  }
  
  public static boolean a(@NonNull String paramString)
  {
    paramString = bmwl.jdField_b_of_type_JavaLangString + paramString + File.separator;
    bnqu.a().a("aeres_copy_final_path_key", paramString, 4);
    if (bnqu.a().a("aeres_copy_final_path_key", bmwl.jdField_b_of_type_JavaLangString, 4).equals(paramString))
    {
      bnrh.a("AEResUtil", "[saveAEResUnzipFinalPath] success");
      return true;
    }
    bnrh.d("AEResUtil", "[saveAEResUnzipFinalPath] error");
    return false;
  }
  
  public static boolean a(@NonNull String paramString, @NonNull bnkt parambnkt)
  {
    bnqu.a().a(parambnkt.jdField_b_of_type_JavaLangString + parambnkt.jdField_c_of_type_Int + "aeres_unzip_path_key", paramString, 4);
    if (paramString.equals(bnqu.a().a(parambnkt.jdField_b_of_type_JavaLangString + parambnkt.jdField_c_of_type_Int + "aeres_unzip_path_key", "", 4)))
    {
      bnrh.a("AEResUtil", "[saveAEResUnzipPath] success");
      return true;
    }
    bnrh.d("AEResUtil", "[saveAEResUnzipPath] error");
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
      i = FileUtils.copyDirectory(paramString2, bmwl.jdField_b_of_type_JavaLangString + paramString1 + File.separator, false, true, true);
      bnrh.d("AEResUtil", "copyResFileToFinalDir errorcode:" + i + ", fromPath:" + paramString2);
    } while (i == 0);
    return false;
  }
  
  public static String b()
  {
    return d();
  }
  
  public static String b(@NonNull bnkt parambnkt)
  {
    String str = c(parambnkt);
    if (TextUtils.isEmpty(str))
    {
      bnrh.d("AEResUtil", "[getAEResPath] pathVersion null");
      return null;
    }
    if (!bcwn.a(str, parambnkt.jdField_b_of_type_Int))
    {
      bnrh.d("AEResUtil", "[getAEResPath] pathVersion is not > limitVersion");
      return null;
    }
    return a() + str + File.separator;
  }
  
  public static void b()
  {
    bddh.a().a("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
  }
  
  public static boolean b()
  {
    return FeatureManager.Features.FACE_DETECT.isAllSoVersionOk();
  }
  
  public static boolean b(bnkt parambnkt)
  {
    String str = b(parambnkt);
    if (str == null)
    {
      bnrh.d("AEResUtil", "[isAEBaseResExist] soRootPath == null");
      return false;
    }
    if (!new File(str).exists())
    {
      bnrh.d("AEResUtil", "[isAEBaseResExist] exists = false");
      return false;
    }
    if (parambnkt.jdField_a_of_type_Int == bnkt.jdField_b_of_type_Bnkt.jdField_a_of_type_Int) {
      return FeatureManager.isBasicFeaturesReadyInDir(str);
    }
    return true;
  }
  
  public static String c()
  {
    return bmwy.a + File.separator;
  }
  
  private static String c(@NonNull bnkt parambnkt)
  {
    return bnqu.a().a(parambnkt.jdField_b_of_type_JavaLangString + parambnkt.jdField_c_of_type_Int + "aeres_unzip_path_key", "", 4);
  }
  
  private static void c(@NonNull Context paramContext)
  {
    Bundle localBundle = bddh.a().a("CMD_QUERY_STATUS_PTU_RES", new Bundle());
    int i = 0;
    if (localBundle != null) {
      i = localBundle.getInt("VALUE_MSG_PTU_RES_STATUS");
    }
    if ((i == 0) || (!a(bnkt.jdField_c_of_type_Bnkt)))
    {
      bhdj.a(paramContext, 230).setMessage(a).setPositiveButton(paramContext.getString(2131693764), new bnla()).setNegativeButton(paramContext.getString(2131693760), new bnkz()).show();
      return;
    }
    bnrh.a("AEResUtil", "[showDialog] is downloading");
    QQToast.a(paramContext, 2131689668, 1).a();
  }
  
  public static boolean c()
  {
    try
    {
      if (!a())
      {
        bmwb.a();
        bool = FeatureManager.loadBasicFeatures();
        bnrh.d("AEResUtil", "SoLoader.loadSvFilterSo success:" + bool);
      }
      boolean bool = a();
      return bool;
    }
    finally {}
  }
  
  public static boolean c(@NonNull bnkt parambnkt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (parambnkt.jdField_a_of_type_Int == bnkt.jdField_b_of_type_Bnkt.jdField_a_of_type_Int) {
      bool1 = b(parambnkt);
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (parambnkt.jdField_a_of_type_Int != bnkt.jdField_c_of_type_Bnkt.jdField_a_of_type_Int);
        parambnkt = b(parambnkt);
        if (parambnkt == null)
        {
          bnrh.d("AEResUtil", "[isAEBaseResExist] soRootPath == null");
          return false;
        }
        if (!new File(parambnkt).exists())
        {
          bnrh.d("AEResUtil", "[isAEBaseResExist] exists = false");
          return false;
        }
        bool1 = bool2;
      } while (!FeatureManager.Features.ACE_3D_ENGINE.isSoReadyInDirectory(parambnkt));
      bool1 = bool2;
    } while (!FeatureManager.Features.FACE_3D_LIB.isSoReadyInDirectory(parambnkt));
    return true;
  }
  
  private static String d()
  {
    return bnqu.a().a("aeres_copy_final_path_key", bmwl.jdField_b_of_type_JavaLangString, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnky
 * JD-Core Version:    0.7.0.1
 */