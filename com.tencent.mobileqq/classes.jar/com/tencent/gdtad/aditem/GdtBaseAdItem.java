package com.tencent.gdtad.aditem;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import org.json.JSONObject;

public class GdtBaseAdItem
  implements Parcelable
{
  public static final Parcelable.Creator<GdtBaseAdItem> CREATOR = new GdtBaseAdItem.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public boolean f;
  public Class g;
  public boolean h;
  public String i;
  public Bundle j;
  
  private GdtBaseAdItem()
  {
    this.h = false;
  }
  
  protected GdtBaseAdItem(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.h = false;
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    this.g = ((Class)paramParcel.readSerializable());
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.h = bool1;
    this.i = paramParcel.readString();
    this.j = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public static GdtBaseAdItem a()
  {
    return new GdtBaseAdItem();
  }
  
  public static GdtBaseAdItem a(String paramString)
  {
    GdtBaseAdItem localGdtBaseAdItem = new GdtBaseAdItem();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = null;
      try
      {
        Class localClass = Class.forName(localJSONObject.optString("class"));
        paramString = localClass;
      }
      catch (Exception localException)
      {
        QZLog.w(localException);
      }
      localGdtBaseAdItem.d(localJSONObject.optString("packageName")).b(localJSONObject.optString("traceId")).f(localJSONObject.optString("invokeUrl")).e(localJSONObject.optString("appDownloadSchema")).c(localJSONObject.optString("productId")).a(paramString).g(localJSONObject.optString("urlForClick")).a("1".equals(localJSONObject.optString("autoDownload")));
      paramString = localJSONObject.optString("pkg_name");
      if (!TextUtils.isEmpty(paramString)) {
        localGdtBaseAdItem.d(paramString);
      }
      return localGdtBaseAdItem;
    }
    catch (Exception paramString) {}
    return localGdtBaseAdItem;
  }
  
  public GdtBaseAdItem a(Bundle paramBundle)
  {
    this.j = paramBundle;
    return this;
  }
  
  public GdtBaseAdItem a(Class paramClass)
  {
    this.g = paramClass;
    return this;
  }
  
  public GdtBaseAdItem a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public GdtBaseAdItem b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public GdtBaseAdItem c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public GdtBaseAdItem d(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public GdtBaseAdItem e(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public GdtBaseAdItem f(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public GdtBaseAdItem g(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GdtBaseAdItem|");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeSerializable(this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeBundle(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtBaseAdItem
 * JD-Core Version:    0.7.0.1
 */