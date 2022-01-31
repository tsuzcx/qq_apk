import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.Properties;

public class bngw
{
  private static int a = 10000;
  
  public static void a(String paramString, Properties paramProperties)
  {
    Properties localProperties = paramProperties;
    if (paramProperties == null) {
      localProperties = new Properties();
    }
    localProperties.setProperty("shortvideo_business_type", "" + a);
    azqh.a(VideoEnvironment.a()).reportKVEvent(paramString, localProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngw
 * JD-Core Version:    0.7.0.1
 */