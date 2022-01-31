import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import java.io.File;

public class azab
{
  public static azac a(String paramString)
  {
    return new azac(paramString);
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_mgr_sp", 4).getString("sv_md5_version_soname_key", "d000_1");
  }
  
  public static String a(File paramFile)
  {
    return bdcs.a(paramFile);
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      VideoEnvironment.a("ShortVideoSoManager:computeMd5[MD5.getFileMd5]md5=" + str1, null);
      String str3;
      if (str1 != null)
      {
        str3 = str1;
        if (!"".equals(str1)) {}
      }
      else
      {
        str3 = b(paramString);
      }
      return str3;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        VideoEnvironment.a("ShortVideoSoManager:computeMd5[MD5.getFileMd5] ", localUnsatisfiedLinkError);
        String str2 = b(paramString);
      }
    }
  }
  
  public static final String a(String paramString1, String paramString2)
  {
    return paramString1 + '_' + paramString2;
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_mgr_sp", 4).edit();
    localEditor.putString("sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.a("ShortVideoSoManager.storeSoNewVersion saveAVCodecOK=" + bool, null);
    return bool;
  }
  
  static String b(String paramString)
  {
    try
    {
      paramString = bhli.a(new File(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      VideoEnvironment.a("ShortVideoSoManager:computeMd5[getFileMD5String]", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azab
 * JD-Core Version:    0.7.0.1
 */