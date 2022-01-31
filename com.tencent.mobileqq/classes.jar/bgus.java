import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class bgus
  implements INetInfoHandler
{
  bgus(bgur parambgur) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    bgur.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    bgur.a(this.a);
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgus
 * JD-Core Version:    0.7.0.1
 */