import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr.1;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class awed
{
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("QmcfConfig", 4).getString("art_res_sv_md5_version_soname_key", "artfilter000_0");
    boolean bool = awdu.a(str, 7);
    VideoEnvironment.a("ShortVideoArtResourceMgr", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "artfilter000_0";
  }
  
  private static void a()
  {
    ThreadManager.post(new ShortVideoArtResourceMgr.1(), 5, null, false);
  }
  
  static boolean a()
  {
    return awlw.b(VideoEnvironment.a());
  }
  
  static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    if (!awlw.f()) {
      return false;
    }
    int i = awkj.a();
    QmcfManager.getInstance().setCurrFrameType(i);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoArtResourceMgr", 2, String.format("supportFrameType[%s]", new Object[] { Integer.valueOf(i) }));
    }
    switch (i)
    {
    case -2: 
    case -1: 
    case 3: 
    default: 
    case 1: 
    case 2: 
    case 4: 
      for (;;)
      {
        return true;
        paramSVConfigItem.armv7a_url = paramSVConfigItem.extend1;
        paramSVConfigItem.armv7a_md5 = paramSVConfigItem.extend2;
        continue;
        paramSVConfigItem.armv7a_url = paramSVConfigItem.arm_url;
        paramSVConfigItem.armv7a_md5 = paramSVConfigItem.arm_md5;
        continue;
        paramSVConfigItem.armv7a_url = paramSVConfigItem.x86_url;
        paramSVConfigItem.armv7a_md5 = paramSVConfigItem.x86_md5;
      }
    }
    QmcfManager.getInstance().setQmcfMobileNotSupport(awkj.a);
    return false;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    paramQQAppInterface = b();
    paramQQAppInterface = paramQQAppInterface + paramString1 + File.separator;
    File localFile = new File(paramQQAppInterface);
    if (localFile.exists())
    {
      if ((a().equals(paramString1)) && (awdu.b(paramQQAppInterface, "artfilter_config_file")))
      {
        VideoEnvironment.a("ShortVideoArtResourceMgr", "uncompressPendantZip:[checkConfigFileListIsOK]success=true", null);
        return false;
      }
      bace.a(paramQQAppInterface);
      VideoEnvironment.a("ShortVideoArtResourceMgr", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + paramQQAppInterface, null);
    }
    boolean bool1 = localFile.mkdirs();
    VideoEnvironment.a("ShortVideoArtResourceMgr", "uncompressPendantZip:[exists]mkOK=" + bool1, null);
    try
    {
      bace.a(paramString2, paramQQAppInterface, false);
      bool1 = awdu.b(paramQQAppInterface, "artfilter_config_file");
      VideoEnvironment.a("ShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK success=" + bool1, null);
      if (bool1)
      {
        boolean bool3 = a(paramString1);
        VideoEnvironment.a("ShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK saveOK=" + bool3, null);
        bool1 = bool2;
        if (!bool3)
        {
          bool3 = a(paramString1);
          VideoEnvironment.a("ShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK[two]saveOK=" + bool3, null);
          bool1 = bool2;
          if (!bool3)
          {
            VideoEnvironment.a("ShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
            bool1 = a("artfilter000_0");
            VideoEnvironment.a("ShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + bool1 + ",signature=" + paramString1, null);
            bool1 = true;
          }
        }
        a();
        return bool1;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return true;
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("QmcfConfig", 4).edit();
    localEditor.putString("art_res_sv_md5_version_soname_key", paramString);
    return localEditor.commit();
  }
  
  public static String b()
  {
    String str = awlw.a(VideoEnvironment.a());
    return str + "art_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awed
 * JD-Core Version:    0.7.0.1
 */