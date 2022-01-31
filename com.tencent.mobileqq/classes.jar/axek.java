import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;

public class axek
  implements INetInfoHandler
{
  public axek(ShortVideoResourceManager paramShortVideoResourceManager) {}
  
  public void onNetMobile2None()
  {
    ShortVideoResourceManager.a(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    ShortVideoResourceManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axek
 * JD-Core Version:    0.7.0.1
 */