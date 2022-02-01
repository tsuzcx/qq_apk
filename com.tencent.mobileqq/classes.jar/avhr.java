import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class avhr
  implements INetInfoHandler
{
  avhr(avhp paramavhp) {}
  
  public void onNetMobile2None()
  {
    avhp.a(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    avhp.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhr
 * JD-Core Version:    0.7.0.1
 */