package com.tencent.gdtad.aditem;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

public class GdtHandler$Options
  implements Parcelable
{
  public static final Parcelable.Creator<Options> CREATOR = new GdtHandler.Options.1();
  public int a;
  public long a;
  public Rect a;
  public Bundle a;
  public GdtAd a;
  public String a;
  public JSONObject a;
  public boolean a;
  public int b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  private boolean h;
  
  public GdtHandler$Options()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.h = false;
    this.jdField_a_of_type_Long = 0L;
    this.f = false;
    this.g = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
  }
  
  protected GdtHandler$Options(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.h = false;
    this.jdField_a_of_type_Long = 0L;
    this.f = false;
    this.g = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    if (paramParcel == null)
    {
      GdtLog.d("GdtHandler", "Options(Parcel in) error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)paramParcel.readParcelable(GdtAd.class.getClassLoader()));
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    this.jdField_a_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle();
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramParcel.readString());
      return;
    }
    catch (Throwable paramParcel)
    {
      GdtLog.d("GdtHandler", "Options(Parcel in)", paramParcel);
    }
  }
  
  public boolean a()
  {
    GdtAd localGdtAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    return (localGdtAd != null) && (localGdtAd.isValid()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForImpression())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForClick())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForEffect())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForLandingPage()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null)
    {
      GdtLog.d("GdtHandler", "writeToParcel error");
      return;
    }
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, paramInt);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRect, paramInt);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
    String str;
    if ((this.jdField_a_of_type_OrgJsonJSONObject != null) && (!JSONObject.NULL.equals(this.jdField_a_of_type_OrgJsonJSONObject))) {
      str = this.jdField_a_of_type_OrgJsonJSONObject.toString();
    } else {
      str = null;
    }
    paramParcel.writeString(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.Options
 * JD-Core Version:    0.7.0.1
 */