package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import org.json.JSONException;

public final class ff$a
{
  public String a;
  public ff b;
  public int c;
  public String d = "network";
  public String e = "network";
  private Location f;
  
  public final a a(Location paramLocation)
  {
    this.f = new Location(paramLocation);
    return this;
  }
  
  public final ff a()
  {
    if (this.a != null) {}
    for (;;)
    {
      try
      {
        ff localff1 = new ff(this.a, (byte)0);
        ff.a(ff.c(ff.b(ff.b(localff1, this.c), this.d), this.e), this.f);
        TencentExtraKeys.setRawGps(localff1, this.f);
        return localff1;
      }
      catch (JSONException localJSONException)
      {
        return ff.a;
      }
      ff localff2 = ff.c(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ff.a
 * JD-Core Version:    0.7.0.1
 */