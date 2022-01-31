import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class bflw
  implements INetInfoHandler
{
  bflw(bflv parambflv) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    bflv.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    bflv.a(this.a);
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflw
 * JD-Core Version:    0.7.0.1
 */