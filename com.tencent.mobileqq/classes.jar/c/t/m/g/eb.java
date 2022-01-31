package c.t.m.g;

import android.location.Location;

public final class eb
  extends ed
{
  public final Location a;
  public final long b;
  public final int c;
  private int d;
  private int e;
  
  public eb(Location paramLocation, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLocation;
    this.b = paramLong;
    this.d = paramInt1;
    this.c = paramInt2;
    this.e = paramInt3;
  }
  
  public eb(eb parameb)
  {
    if (parameb.a == null) {}
    for (Location localLocation = null;; localLocation = new Location(parameb.a))
    {
      this.a = localLocation;
      this.b = parameb.b;
      this.d = parameb.d;
      this.c = parameb.c;
      this.e = parameb.e;
      return;
    }
  }
  
  public final String toString()
  {
    return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.d + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.e + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.eb
 * JD-Core Version:    0.7.0.1
 */