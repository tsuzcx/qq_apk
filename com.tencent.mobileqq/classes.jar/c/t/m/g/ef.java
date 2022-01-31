package c.t.m.g;

import android.location.Location;

public final class ef
  extends eh
{
  public final Location a;
  public final long b;
  public final int c;
  private final long d = 30000L;
  private final long e = 10000L;
  private int f;
  private int g;
  
  public ef(Location paramLocation, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLocation;
    this.b = paramLong;
    this.f = paramInt1;
    this.c = paramInt2;
    this.g = paramInt3;
  }
  
  public ef(ef paramef)
  {
    if (paramef.a == null) {}
    for (Location localLocation = null;; localLocation = new Location(paramef.a))
    {
      this.a = localLocation;
      this.b = paramef.b;
      this.f = paramef.f;
      this.c = paramef.c;
      this.g = paramef.g;
      return;
    }
  }
  
  public final String toString()
  {
    return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.f + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.g + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ef
 * JD-Core Version:    0.7.0.1
 */