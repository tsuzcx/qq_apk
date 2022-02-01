package com.tencent.luggage.wxa.iu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  implements Parcelable
{
  public static final Parcelable.Creator<q> CREATOR = new q.1();
  public JSONObject a;
  public JSONObject b;
  
  public q() {}
  
  private q(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  @Nullable
  public static q a(@Nullable JSONObject paramJSONObject1, @Nullable JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) && (paramJSONObject2 == null)) {
      return null;
    }
    q localq = new q();
    localq.a = ((JSONObject)a(paramJSONObject1, new JSONObject()));
    localq.b = ((JSONObject)a(paramJSONObject2, new JSONObject()));
    return localq;
  }
  
  private static <T> T a(T paramT1, T paramT2)
  {
    T ? = paramT1;
    if (paramT1 == null) {
      ? = paramT2;
    }
    return ?;
  }
  
  private void a(Parcel paramParcel)
  {
    try
    {
      this.a = new JSONObject(af.a(paramParcel.readString(), "{}"));
      this.b = new JSONObject(af.a(paramParcel.readString(), "{}"));
      return;
    }
    catch (JSONException paramParcel)
    {
      o.b("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", new Object[] { paramParcel });
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((JSONObject)localObject1).toString();
    }
    paramParcel.writeString((String)localObject1);
    localObject1 = this.b;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((JSONObject)localObject1).toString();
    }
    paramParcel.writeString((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.q
 * JD-Core Version:    0.7.0.1
 */