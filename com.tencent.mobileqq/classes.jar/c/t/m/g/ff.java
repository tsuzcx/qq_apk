package c.t.m.g;

import com.tencent.map.geolocation.TencentPoi;
import org.json.JSONException;
import org.json.JSONObject;

final class ff
  implements TencentPoi
{
  private String a;
  private String b;
  private String c;
  private double d;
  private String e;
  private double f;
  private double g;
  private String h;
  
  public ff(TencentPoi paramTencentPoi)
  {
    this.a = paramTencentPoi.getName();
    this.b = paramTencentPoi.getAddress();
    this.c = paramTencentPoi.getCatalog();
    this.d = paramTencentPoi.getDistance();
    this.e = paramTencentPoi.getUid();
    this.f = paramTencentPoi.getLatitude();
    this.g = paramTencentPoi.getLongitude();
    this.h = paramTencentPoi.getDirection();
  }
  
  public ff(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getString("name");
      this.b = paramJSONObject.getString("addr");
      this.c = paramJSONObject.getString("catalog");
      this.d = paramJSONObject.optDouble("dist");
      this.e = paramJSONObject.getString("uid");
      this.f = paramJSONObject.optDouble("latitude");
      this.g = paramJSONObject.optDouble("longitude");
      this.h = paramJSONObject.optString("direction", "");
      if (Double.isNaN(this.f)) {
        this.f = paramJSONObject.optDouble("pointy");
      }
      if (Double.isNaN(this.g)) {
        this.g = paramJSONObject.optDouble("pointx");
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw paramJSONObject;
    }
  }
  
  public final String getAddress()
  {
    return this.b;
  }
  
  public final String getCatalog()
  {
    return this.c;
  }
  
  public final String getDirection()
  {
    return this.h;
  }
  
  public final double getDistance()
  {
    return this.d;
  }
  
  public final double getLatitude()
  {
    return this.f;
  }
  
  public final double getLongitude()
  {
    return this.g;
  }
  
  public final String getName()
  {
    return this.a;
  }
  
  public final String getUid()
  {
    return this.e;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PoiData{");
    localStringBuilder.append("name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append("addr=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append("catalog=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append("dist=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append("latitude=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append("longitude=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",");
    localStringBuilder.append("direction=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ff
 * JD-Core Version:    0.7.0.1
 */