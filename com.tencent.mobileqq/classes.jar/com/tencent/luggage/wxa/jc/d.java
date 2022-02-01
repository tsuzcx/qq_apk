package com.tencent.luggage.wxa.jc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements Parcelable
{
  public static final Parcelable.Creator<d> CREATOR = new d.1();
  public int a;
  public a b;
  public JSONObject c;
  
  public d() {}
  
  public d(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    int i = this.a;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.b = ((a)paramParcel.readParcelable(d.class.getClassLoader()));
      return;
    }
    paramParcel = paramParcel.readString();
    try
    {
      this.c = new JSONObject(paramParcel);
      return;
    }
    catch (JSONException paramParcel)
    {
      o.a("DrawActionWrapper", paramParcel, "", new Object[0]);
    }
  }
  
  public String a()
  {
    int i = this.a;
    if (i != 1)
    {
      if (i != 2) {
        return "";
      }
      return this.b.a;
    }
    return this.c.optString("method");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("type %d ,method %s", new Object[] { Integer.valueOf(this.a), a() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    int i = this.a;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramParcel.writeParcelable(this.b, paramInt);
      return;
    }
    paramParcel.writeString(this.c.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.d
 * JD-Core Version:    0.7.0.1
 */