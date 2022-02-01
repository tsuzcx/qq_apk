package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;
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
    Object localObject = this.a;
    if (localObject != null) {}
    try
    {
      localObject = new fi((String)localObject, (byte)0);
    }
    catch (JSONException localJSONException)
    {
      label22:
      break label22;
    }
    return fi.a;
    localObject = fi.c(this.b);
    fi.a(fi.c(fi.b(fi.b((fi)localObject, this.c), this.d), this.e), this.f);
    TencentExtraKeys.setRawGps((TencentLocation)localObject, this.f);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fi.a
 * JD-Core Version:    0.7.0.1
 */