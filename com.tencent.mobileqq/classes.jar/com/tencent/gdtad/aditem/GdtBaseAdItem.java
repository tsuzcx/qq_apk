package com.tencent.gdtad.aditem;

import acaj;
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
  public static final Parcelable.Creator<GdtBaseAdItem> CREATOR = new acaj();
  public Bundle a;
  public Class a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  private GdtBaseAdItem() {}
  
  public GdtBaseAdItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaLangClass = ((Class)paramParcel.readSerializable());
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.f = paramParcel.readString();
      this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle(getClass().getClassLoader());
      return;
      bool1 = false;
      break;
    }
  }
  
  public static GdtBaseAdItem a()
  {
    return new GdtBaseAdItem();
  }
  
  public static GdtBaseAdItem a(String paramString)
  {
    localGdtBaseAdItem = new GdtBaseAdItem();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      try
      {
        paramString = Class.forName(localJSONObject.optString("class"));
        localGdtBaseAdItem.d(localJSONObject.optString("packageName")).b(localJSONObject.optString("traceId")).f(localJSONObject.optString("invokeUrl")).e(localJSONObject.optString("appDownloadSchema")).c(localJSONObject.optString("productId")).a(paramString).g(localJSONObject.optString("urlForClick")).a("1".equals(localJSONObject.optString("autoDownload")));
        paramString = localJSONObject.optString("pkg_name");
        if (!TextUtils.isEmpty(paramString))
        {
          localGdtBaseAdItem.d(paramString);
          return localGdtBaseAdItem;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QZLog.w(paramString);
          paramString = null;
        }
      }
      return localGdtBaseAdItem;
    }
    catch (Exception paramString) {}
  }
  
  public GdtBaseAdItem a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public GdtBaseAdItem a(Class paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public GdtBaseAdItem a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public GdtBaseAdItem e(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public GdtBaseAdItem f(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public GdtBaseAdItem g(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String toString()
  {
    return "GdtBaseAdItem|" + this.jdField_a_of_type_JavaLangString + "\n" + this.jdField_b_of_type_JavaLangString + "\n" + this.c + "\n" + this.d + "\n" + this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeSerializable(this.jdField_a_of_type_JavaLangClass);
      if (!this.jdField_b_of_type_Boolean) {
        break label102;
      }
    }
    label102:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.f);
      paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtBaseAdItem
 * JD-Core Version:    0.7.0.1
 */