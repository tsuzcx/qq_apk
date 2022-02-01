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
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  private boolean h = false;
  
  public GdtHandler$Options()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
  }
  
  protected GdtHandler$Options(Parcel paramParcel)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    if (paramParcel == null)
    {
      GdtLog.d("GdtHandler", "Options(Parcel in) error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)paramParcel.readParcelable(GdtAd.class.getClassLoader()));
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label305;
      }
      bool1 = true;
      label145:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label310;
      }
      bool1 = true;
      label159:
      this.c = bool1;
      if (paramParcel.readByte() == 0) {
        break label315;
      }
      bool1 = true;
      label173:
      this.d = bool1;
      if (paramParcel.readByte() == 0) {
        break label320;
      }
      bool1 = true;
      label187:
      this.e = bool1;
      this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label325;
      }
      bool1 = true;
      label217:
      this.h = bool1;
      this.jdField_a_of_type_Long = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label330;
      }
      bool1 = true;
      label239:
      this.f = bool1;
      if (paramParcel.readByte() == 0) {
        break label335;
      }
    }
    label305:
    label310:
    label315:
    label320:
    label325:
    label330:
    label335:
    for (boolean bool1 = bool2;; bool1 = false)
    {
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
        return;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label145;
      bool1 = false;
      break label159;
      bool1 = false;
      break label173;
      bool1 = false;
      break label187;
      bool1 = false;
      break label217;
      bool1 = false;
      break label239;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isValid()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForImpression())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForClick())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForEffect())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForLandingPage()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    if (paramParcel == null)
    {
      GdtLog.d("GdtHandler", "writeToParcel error");
      return;
    }
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, paramInt);
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label235;
      }
      i = 1;
      label64:
      paramParcel.writeByte((byte)i);
      if (!this.c) {
        break label240;
      }
      i = 1;
      label79:
      paramParcel.writeByte((byte)i);
      if (!this.d) {
        break label245;
      }
      i = 1;
      label94:
      paramParcel.writeByte((byte)i);
      if (!this.e) {
        break label250;
      }
      i = 1;
      label109:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRect, paramInt);
      if (!this.h) {
        break label255;
      }
      paramInt = 1;
      label133:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      if (!this.f) {
        break label260;
      }
      paramInt = 1;
      label156:
      paramParcel.writeByte((byte)paramInt);
      if (!this.g) {
        break label265;
      }
      paramInt = j;
      label172:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
      if ((this.jdField_a_of_type_OrgJsonJSONObject == null) || (JSONObject.NULL.equals(this.jdField_a_of_type_OrgJsonJSONObject))) {
        break label270;
      }
    }
    label260:
    label265:
    label270:
    for (String str = this.jdField_a_of_type_OrgJsonJSONObject.toString();; str = null)
    {
      paramParcel.writeString(str);
      return;
      i = 0;
      break;
      label235:
      i = 0;
      break label64;
      label240:
      i = 0;
      break label79;
      label245:
      i = 0;
      break label94;
      label250:
      i = 0;
      break label109;
      label255:
      paramInt = 0;
      break label133;
      paramInt = 0;
      break label156;
      paramInt = 0;
      break label172;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.Options
 * JD-Core Version:    0.7.0.1
 */