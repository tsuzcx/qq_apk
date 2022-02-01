package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.GdtAdParams;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

public class GdtInterstitialParams
  extends GdtAdParams
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialParams> CREATOR = new GdtInterstitialParams.1();
  public int a;
  public GdtHandler.Options a;
  public JSONObject a;
  public boolean a;
  int b;
  int c;
  
  public GdtInterstitialParams()
  {
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_a_of_type_Boolean = false;
    this.b = -2147483648;
    this.c = -2147483648;
  }
  
  protected GdtInterstitialParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -2147483648;
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.b = -2147483648;
    this.c = -2147483648;
    if (paramParcel == null)
    {
      GdtLog.d("GdtInterstitialParams", "GdtInterstitialParams(Parcel in) error");
      return;
    }
    String str = paramParcel.readString();
    if (!TextUtils.isEmpty(str)) {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("GdtInterstitialParams", "GdtInterstitialParams(Parcel in)", localThrowable);
      }
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = ((GdtHandler.Options)paramParcel.readParcelable(GdtHandler.Options.class.getClassLoader()));
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  String a()
  {
    if ((!a()) || (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a == null) || (!this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a.isValid())) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a.getTraceId();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options != null) && (this.jdField_a_of_type_Int != -2147483648);
  }
  
  boolean b()
  {
    return (a()) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null)
    {
      GdtLog.d("GdtInterstitialParams", "writeToParcel error");
      return;
    }
    String str;
    if ((this.jdField_a_of_type_OrgJsonJSONObject != null) && (!JSONObject.NULL.equals(this.jdField_a_of_type_OrgJsonJSONObject))) {
      str = this.jdField_a_of_type_OrgJsonJSONObject.toString();
    } else {
      str = null;
    }
    paramParcel.writeString(str);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialParams
 * JD-Core Version:    0.7.0.1
 */