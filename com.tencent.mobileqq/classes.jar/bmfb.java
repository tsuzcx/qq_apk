import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class bmfb
  implements INetInfoHandler
{
  bmfb(bmfa parambmfa) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    bmfa.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    bmfa.a(this.a);
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfb
 * JD-Core Version:    0.7.0.1
 */