import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class bkzd
{
  private static final String[] a = { "art_res_cache" };
  private static final String[] b = { "libimage_filter_common.so", "libimage_filter_gpu.so", "libpitu_tools.so", "libimage_filter_cpu.so", "libalgo_youtu_jni.so", "libformat_convert.so" };
  
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("pendant_short_video_mgr_sp", 4).getString("pendant_sv_md5_version_soname_key", "Pendant000_0");
    boolean bool = a(str, 2);
    VideoEnvironment.a("PendantVersionManager", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "Pendant000_0";
  }
  
  static boolean a(String paramString, int paramInt)
  {
    String str = paramString.trim();
    VideoEnvironment.a("PendantVersionManager", "checkSignatureVersionIsOK signature=" + paramString, null);
    paramString = blag.a(str);
    int i = paramString.a();
    VideoEnvironment.a("PendantVersionManager", "checkSignatureVersionIsOK errCode=" + i + ",trimSignature=" + str, null);
    if (i == 0)
    {
      paramString = paramString.a().trim();
      VideoEnvironment.a("PendantVersionManager", "checkSignatureVersionIsOK versionValid=" + paramString, null);
      i = Integer.parseInt(paramString);
      VideoEnvironment.a("PendantVersionManager", "checkSignatureVersionIsOK version=" + i + ",limitVersion=" + paramInt, null);
      if (i >= paramInt) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < a.length)
      {
        if (paramString.equals(a[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzd
 * JD-Core Version:    0.7.0.1
 */