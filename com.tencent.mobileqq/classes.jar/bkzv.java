import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.io.File;

public class bkzv
{
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("QmcfConfig", 4).getString("art_res_sv_md5_version_soname_key", "artfilter000_0");
    boolean bool = bkzd.a(str, 6);
    VideoEnvironment.a("ShortVideoArtResourceMgr", "getCurrentPendantUnzipPath success=" + bool + ",md5Version=" + str, null);
    if (bool) {
      return str;
    }
    return "artfilter000_0";
  }
  
  public static String b()
  {
    String str = axle.a(VideoEnvironment.a());
    return str + "art_res_cache" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzv
 * JD-Core Version:    0.7.0.1
 */