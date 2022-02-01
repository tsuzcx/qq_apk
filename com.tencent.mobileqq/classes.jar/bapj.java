import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import java.io.File;

public class bapj
{
  public static boolean a(int paramInt, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramInt == 11022003) && (paramVideoPlayParam.mIsLocal) && (!TextUtils.isEmpty(paramVideoPlayParam.mVideoPath)))
    {
      Object localObject = (arbn)aran.a().a(537);
      if ((localObject != null) && (((arbn)localObject).e)) {
        try
        {
          localObject = new File(paramVideoPlayParam.mVideoPath);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.d("VideoPlatformUtils", 0, "autoDelBadCache, delete file , path = " + paramVideoPlayParam.mVideoPath);
            }
            return true;
          }
        }
        catch (Exception paramVideoPlayParam)
        {
          QLog.e("VideoPlatformUtils", 1, "autoDelBadCache error.", paramVideoPlayParam);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapj
 * JD-Core Version:    0.7.0.1
 */