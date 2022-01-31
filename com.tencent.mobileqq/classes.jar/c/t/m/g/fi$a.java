package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import org.json.JSONException;

public final class fi$a
{
  public String a;
  public fi b;
  public int c;
  public String d = "network";
  public String e = "network";
  private Location f;
  
  public final a a(Location paramLocation)
  {
    this.f = new Location(paramLocation);
    return this;
  }
  
  public final fi a()
  {
    if (this.a != null) {}
    for (;;)
    {
      try
      {
        fi localfi1 = new fi(this.a, (byte)0);
        fi.a(fi.c(fi.b(fi.b(localfi1, this.c), this.d), this.e), this.f);
        TencentExtraKeys.setRawGps(localfi1, this.f);
        return localfi1;
      }
      catch (JSONException localJSONException)
      {
        return fi.a;
      }
      fi localfi2 = fi.c(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.fi.a
 * JD-Core Version:    0.7.0.1
 */