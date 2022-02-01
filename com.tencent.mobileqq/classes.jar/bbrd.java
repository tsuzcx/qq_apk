import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.2;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import java.util.Properties;
import mqq.app.MobileQQ;

public class bbrd
  implements bbrg
{
  public bbrd(ShortVideoResourceManager.2 param2) {}
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.LogDownLoad("QuicResDownload", "doUserDownloadQuicResourceAsync: [onDownloadFinish]name=" + paramString1 + " filepath=" + paramString2, null);
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("QuicResDownload", "doUserDownloadQuicResourceAsync: [onNetWorkNone]", null);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == paramLong2) && (!QuicResDownload.a)) {
      QuicResDownload.a = true;
    }
    try
    {
      Properties localProperties = new Properties();
      localProperties.put("version", "8.4.8.4810");
      localProperties.put("appid", String.valueOf(AppSetting.a()));
      localProperties.put("release", String.valueOf(true));
      localProperties.put("name", paramString);
      bcdu.a(this.a.a.getApplication().getApplicationContext()).reportKVEvent("msf_quic_resdown", localProperties);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrd
 * JD-Core Version:    0.7.0.1
 */