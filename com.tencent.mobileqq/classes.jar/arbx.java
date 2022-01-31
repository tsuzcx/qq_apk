import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class arbx
  implements INetInfoHandler
{
  arbx(arbp paramarbp) {}
  
  public void onNetMobile2None()
  {
    arbp.c(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    arbp.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbx
 * JD-Core Version:    0.7.0.1
 */