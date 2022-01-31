import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class aqje
  implements INetInfoHandler
{
  aqjb a;
  
  public aqje(aqjb paramaqjb1, aqjb paramaqjb2)
  {
    this.a = paramaqjb2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    aqja.b("onNetMobile2None");
    if (this.a != null) {
      aqjb.c(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    aqja.b("onNetMobile2Wifi");
    if (this.a != null) {
      aqjb.c(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    aqja.b("onNetNone2Mobile");
    if (this.a != null) {
      aqjb.c(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    aqja.b("onNetNone2Wifi");
    if (this.a != null) {
      aqjb.c(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    aqja.b("onNetWifi2Mobile");
    if (this.a != null) {
      aqjb.c(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    aqja.b("onNetWifi2None");
    if (this.a != null) {
      aqjb.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqje
 * JD-Core Version:    0.7.0.1
 */