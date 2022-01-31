import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoPtuResManager.1;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axef
{
  public static boolean a;
  
  public static int a(Context paramContext)
  {
    int i = 0;
    if (a()) {
      if (!a(paramContext)) {
        break label50;
      }
    }
    label50:
    for (i = 1;; i = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPtuResManager", 2, "getPtuResState " + i);
      }
      return i;
    }
  }
  
  public static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    int i = 0;
    String str = "new_qq_android_native_ptu_res_" + paramSVConfigItem.versionCode;
    if (paramSVConfigItem.name.equalsIgnoreCase(str))
    {
      if (paramSVConfigItem.versionCode < 70)
      {
        i = -2;
        VideoEnvironment.a("ShortVideoPtuResManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPendant=" + 62, null);
      }
      return i;
    }
    return -4;
  }
  
  public static String a()
  {
    return axlc.a(VideoEnvironment.a()) + "ptu_res";
  }
  
  private static String a(Context paramContext)
  {
    String str = b(paramContext);
    if (str != null) {}
    for (paramContext = str;; paramContext = "null")
    {
      VideoEnvironment.a("ShortVideoPtuResManager", "getPtuResPath:pathLog = " + paramContext, null);
      return str;
    }
  }
  
  private static void a()
  {
    ThreadManager.excute(new ShortVideoPtuResManager.1(), 64, null, false);
  }
  
  private static boolean a()
  {
    return axlc.c();
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext == null)
    {
      VideoEnvironment.a("ShortVideoPtuResManager", "isFilterSoExist:getPtuResPath soRootPath = null", null);
      return false;
    }
    if (!new File(paramContext).exists())
    {
      VideoEnvironment.a("ShortVideoPtuResManager", "isFilterSoExist:getPtuResPath soRootPath=" + paramContext + ",exists=false", null);
      return false;
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptu_short_video_mgr_sp", 4).edit();
    localEditor.putString("ptu_short_video_so_name_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.a("ShortVideoPtuResManager", "storeNewPendantUnzipPath commitValue=" + bool + ",pathName=" + paramString, null);
    return bool;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    String str = paramString.trim();
    VideoEnvironment.a("ShortVideoPtuResManager", "checkSignatureVersionIsOK signature=" + paramString, null);
    paramString = axet.a(str);
    int i = paramString.a();
    VideoEnvironment.a("ShortVideoPtuResManager", "checkSignatureVersionIsOK errCode=" + i + ",trimSignature=" + str, null);
    boolean bool1 = bool2;
    if (i == 0)
    {
      paramString = paramString.b().trim();
      VideoEnvironment.a("ShortVideoPtuResManager", "checkSignatureVersionIsOK versionValid=" + paramString, null);
      i = Integer.parseInt(paramString);
      VideoEnvironment.a("ShortVideoPtuResManager", "checkSignatureVersionIsOK version=" + i + ",limitVersion=" + paramInt, null);
      bool1 = bool2;
      if (i >= paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    bool1 = true;
    for (;;)
    {
      try
      {
        String str = a();
        str = str + File.separator + paramString1 + File.separator;
        File localFile = new File(str);
        if (localFile.exists())
        {
          if ((c().equals(paramString1)) && (b(str, "ptu_config_file")))
          {
            VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:[checkUnzipFileListSizeIsOK]success=true", null);
            bool1 = false;
            return bool1;
          }
          bbdj.a(str);
          VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:[deleteDirectory|already exists]unzipPath=" + str, null);
        }
        boolean bool4 = localFile.mkdirs();
        VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:[exists]mkOK=" + bool4, null);
        if (!localFile.exists())
        {
          VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:unzipFile.exists=false[error]", null);
          continue;
        }
        try
        {
          bbdj.a(paramString2, str, false);
          bool1 = b(str, "ptu_config_file");
          VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK success=" + bool1, null);
          if (!bool1) {
            break label434;
          }
          bool1 = axdc.a(str);
          VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:copyResFileToFinalDir copyOK=" + bool1, null);
          if (!bool1) {
            break;
          }
          bool4 = a(paramString1);
          VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK saveOK=" + bool4, null);
          bool1 = bool3;
          if (!bool4)
          {
            bool4 = a(paramString1);
            VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK[two]saveOK=" + bool4, null);
            bool1 = bool3;
            if (!bool4)
            {
              VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
              bool1 = a("ptu_config_file");
              VideoEnvironment.a("ShortVideoPtuResManager", "uncompressPtuZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + bool1 + ",signature=" + paramString1, null);
              bool1 = true;
            }
          }
          a();
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            continue;
            bool1 = true;
            continue;
            bool1 = true;
          }
        }
      }
      finally {}
      bool2 = bool1;
      bool1 = bool2;
      if (bool2)
      {
        bbdj.a(str);
        bool1 = bool2;
      }
    }
  }
  
  private static String b(Context paramContext)
  {
    paramContext = c();
    if (paramContext.equals("Ptu000_0"))
    {
      VideoEnvironment.a("ShortVideoPtuResManager", "getPtuResPath:pathVersion=Pendant000_0", null);
      return null;
    }
    return a() + File.separator + paramContext + File.separator;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    return axdc.b(paramString1, paramString2);
  }
  
  private static String c()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("ptu_short_video_mgr_sp", 4).getString("ptu_short_video_so_name_key", "Ptu000_0");
    boolean bool = a(str, 70);
    VideoEnvironment.a("ShortVideoPtuResManager", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Ptu000_0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axef
 * JD-Core Version:    0.7.0.1
 */