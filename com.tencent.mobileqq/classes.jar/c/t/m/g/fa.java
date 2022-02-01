package c.t.m.g;

import android.os.Parcel;
import org.json.JSONObject;

final class fa
  implements fh
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
    new fa.1();
  }
  
  public fa() {}
  
  public fa(JSONObject paramJSONObject)
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
    localStringBuilder.append("name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append("dtype=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append("pointx=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append("pointy=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append("dist=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append("direction=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",");
    localStringBuilder.append("tag=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fa
 * JD-Core Version:    0.7.0.1
 */