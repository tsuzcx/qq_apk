import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.3;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import java.util.Properties;
import mqq.app.MobileQQ;

public class axen
  implements axeq
{
  public axen(ShortVideoResourceManager.3 param3) {}
  
  public void G_()
  {
    VideoEnvironment.a("QuicResDownload", "doUserDownloadQuicResourceAsync: [onNetWorkNone]", null);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.a("QuicResDownload", "doUserDownloadQuicResourceAsync: [onDownloadFinish]name=" + paramString1 + " filepath=" + paramString2, null);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == paramLong2) && (!QuicResDownload.a)) {
      QuicResDownload.a = true;
    }
    try
    {
      Properties localProperties = new Properties();
      localProperties.put("version", "8.3.0.4480");
      localProperties.put("appid", String.valueOf(AppSetting.a()));
      localProperties.put("release", String.valueOf(true));
      localProperties.put("name", paramString);
      axqn.a(this.a.a.getApplication().getApplicationContext()).reportKVEvent("msf_quic_resdown", localProperties);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axen
 * JD-Core Version:    0.7.0.1
 */