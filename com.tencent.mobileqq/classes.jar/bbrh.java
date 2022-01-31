import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class bbrh
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    bbrg.a();
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    bbrg.a();
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrh
 * JD-Core Version:    0.7.0.1
 */