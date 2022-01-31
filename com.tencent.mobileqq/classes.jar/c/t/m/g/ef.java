package c.t.m.g;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

final class ef
  implements el
{
  public String a;
  public String b;
  public String c;
  public double d;
  public double e;
  public double f;
  public String g;
  public String h;
  
  static
  {
    new Parcelable.Creator() {};
  }
  
  public ef() {}
  
  public ef(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("name");
    this.b = paramJSONObject.optString("dtype");
    this.c = paramJSONObject.optString("addr");
    this.d = paramJSONObject.optDouble("pointx");
    this.e = paramJSONObject.optDouble("pointy");
    this.f = paramJSONObject.optDouble("dist");
    this.g = paramJSONObject.optString("direction");
    this.h = paramJSONObject.optString("tag");
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AddressData{");
    localStringBuilder.append("name=").append(this.a).append(",");
    localStringBuilder.append("dtype=").append(this.b).append(",");
    localStringBuilder.append("pointx=").append(this.d).append(",");
    localStringBuilder.append("pointy=").append(this.e).append(",");
    localStringBuilder.append("dist=").append(this.f).append(",");
    localStringBuilder.append("direction=").append(this.g).append(",");
    localStringBuilder.append("tag=").append(this.h).append(",");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeDouble(this.d);
    paramParcel.writeDouble(this.e);
    paramParcel.writeDouble(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ef
 * JD-Core Version:    0.7.0.1
 */