package c.t.m.g;

import android.location.Location;

public final class eu
  extends ew
{
  public final Location a;
  public final long b;
  public final int c;
  private final long d = 30000L;
  private final long e = 10000L;
  private int f;
  private int g;
  
  public eu(Location paramLocation, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLocation;
    this.b = paramLong;
    this.f = paramInt1;
    this.c = paramInt2;
    this.g = paramInt3;
  }
  
  public eu(eu parameu)
  {
    Location localLocation = parameu.a;
    if (localLocation == null) {
      localLocation = null;
    } else {
      localLocation = new Location(localLocation);
    }
    this.a = localLocation;
    this.b = parameu.b;
    this.f = parameu.f;
    this.c = parameu.c;
    this.g = parameu.g;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxGpsInfo [location=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", gpsTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", visbleSatelliteNum=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", usedSatelliteNum=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", gpsStatus=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.eu
 * JD-Core Version:    0.7.0.1
 */