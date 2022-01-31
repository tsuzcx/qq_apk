import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class astz
  implements INetInfoHandler
{
  astw a;
  
  public astz(astw paramastw1, astw paramastw2)
  {
    this.a = paramastw2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onNetMobile2None()
  {
    astv.b("onNetMobile2None");
    if (this.a != null) {
      astw.c(this.a);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    astv.b("onNetMobile2Wifi");
    if (this.a != null) {
      astw.c(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    astv.b("onNetNone2Mobile");
    if (this.a != null) {
      astw.c(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    astv.b("onNetNone2Wifi");
    if (this.a != null) {
      astw.c(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    astv.b("onNetWifi2Mobile");
    if (this.a != null) {
      astw.c(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    astv.b("onNetWifi2None");
    if (this.a != null) {
      astw.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astz
 * JD-Core Version:    0.7.0.1
 */