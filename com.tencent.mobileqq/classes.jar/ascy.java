import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class ascy
  implements INetInfoHandler
{
  private ascy(NearbyAppInterface paramNearbyAppInterface) {}
  
  public void onNetMobile2None()
  {
    if (NearbyAppInterface.i(this.a) != null) {
      NearbyAppInterface.j(this.a).onNetMobile2None();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (NearbyAppInterface.g(this.a) != null) {
      NearbyAppInterface.h(this.a).onNetMobile2Wifi(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (NearbyAppInterface.a(this.a) != null) {
      NearbyAppInterface.b(this.a).onNetNone2Mobile(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (NearbyAppInterface.e(this.a) != null) {
      NearbyAppInterface.f(this.a).onNetNone2Wifi(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (NearbyAppInterface.c(this.a) != null) {
      NearbyAppInterface.d(this.a).onNetWifi2Mobile(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    if (NearbyAppInterface.k(this.a) != null) {
      NearbyAppInterface.l(this.a).onNetWifi2None();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ascy
 * JD-Core Version:    0.7.0.1
 */