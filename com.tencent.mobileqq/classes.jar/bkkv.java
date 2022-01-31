import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class bkkv
  implements INetInfoHandler
{
  bkkv(bkks parambkks) {}
  
  public void onNetMobile2None()
  {
    this.a.a(false, false);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.a(true, true);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.a.a(false, true);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.a(true, true);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.a(false, true);
  }
  
  public void onNetWifi2None()
  {
    this.a.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkv
 * JD-Core Version:    0.7.0.1
 */