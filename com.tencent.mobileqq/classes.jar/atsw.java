import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class atsw
  implements INetInfoHandler
{
  atsw(atso paramatso) {}
  
  public void onNetMobile2None()
  {
    atso.c(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    atso.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsw
 * JD-Core Version:    0.7.0.1
 */