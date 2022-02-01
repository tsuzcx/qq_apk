package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;

final class eq$a
{
  double a;
  double b;
  long c;
  int d;
  private double e;
  
  static a a(TencentLocation paramTencentLocation)
  {
    a locala = new a();
    locala.a = paramTencentLocation.getLatitude();
    locala.b = paramTencentLocation.getLongitude();
    locala.c = paramTencentLocation.getTime();
    locala.e = paramTencentLocation.getSpeed();
    boolean bool = TencentLocationUtils.isFromGps(paramTencentLocation);
    int i = 2;
    if (bool)
    {
      if (paramTencentLocation.getAccuracy() < 100.0F) {
        i = 3;
      }
      locala.d = i;
      return locala;
    }
    if (paramTencentLocation.getAccuracy() >= 500.0F) {
      i = 1;
    }
    locala.d = i;
    return locala;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.eq.a
 * JD-Core Version:    0.7.0.1
 */