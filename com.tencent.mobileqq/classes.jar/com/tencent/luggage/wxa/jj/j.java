package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public final class j
  implements Parcelable
{
  public static final Parcelable.Creator<j> CREATOR = new j.1();
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public String i;
  public String j;
  public String k;
  
  public j() {}
  
  private j(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public JSONObject a()
  {
    try
    {
      localObject1 = new JSONObject(this.c);
    }
    catch (Exception localException2)
    {
      Object localObject1;
      label15:
      JSONObject localJSONObject;
      Object localObject2;
      break label15;
    }
    localObject1 = this.c;
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.b);
      localJSONObject.put("extraData", localObject1);
      if (((this.a == 1) || (this.a == 3) || (this.a == 2)) && (!af.c(this.d))) {
        localJSONObject.put("privateExtraData", new JSONObject(this.d));
      }
      if ((this.a == 6) && (!af.c(this.e))) {
        localJSONObject.put("messageExtraData", new JSONObject(this.e));
      }
      if ((this.a == 7) && (!af.c(this.j))) {
        localJSONObject.put("openapiInvokeData", new JSONObject(this.j));
      }
      if ((this.a == 7) && (!af.c(this.k))) {
        localJSONObject.put("transitiveData", new JSONObject(this.k));
      }
    }
    catch (Exception localException1)
    {
      o.b("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", new Object[] { localException1 });
    }
    localObject2 = localJSONObject;
    if (localJSONObject.length() == 0) {
      localObject2 = null;
    }
    return localObject2;
  }
  
  void a(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.e = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
  }
  
  public void a(j paramj)
  {
    if (paramj == null) {
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramj.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    a(localParcel);
    localParcel.recycle();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandLaunchReferrer{launchScene=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extraData='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", agentId='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sourceType='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", businessType='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.j
 * JD-Core Version:    0.7.0.1
 */