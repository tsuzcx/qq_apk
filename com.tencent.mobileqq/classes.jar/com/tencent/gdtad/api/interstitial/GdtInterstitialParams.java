package com.tencent.gdtad.api.interstitial;

import ablb;
import abmo;
import abrl;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import org.json.JSONObject;

public class GdtInterstitialParams
  extends ablb
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialParams> CREATOR = new abmo();
  public int a;
  public GdtHandler.Options a;
  public JSONObject a;
  public boolean a;
  public int b = -2147483648;
  public int c = -2147483648;
  public int d = -2147483648;
  
  public GdtInterstitialParams()
  {
    this.jdField_a_of_type_Int = -2147483648;
  }
  
  public GdtInterstitialParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -2147483648;
    if (paramParcel == null)
    {
      abrl.d("GdtInterstitialParams", "GdtInterstitialParams(Parcel in) error");
      return;
    }
    String str = paramParcel.readString();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = ((GdtHandler.Options)paramParcel.readParcelable(GdtHandler.Options.class.getClassLoader()));
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.b = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        AdLog.e("GdtInterstitialParams", "GdtInterstitialParams(Parcel in)", localThrowable);
        continue;
        boolean bool = false;
      }
    }
  }
  
  public String a()
  {
    if (!a()) {}
    while ((this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a == null) || (!this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a.isValid())) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a.getTraceId();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options != null) && (this.jdField_a_of_type_Int != -2147483648) && (this.b != -2147483648);
  }
  
  public boolean b()
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
      abrl.d("GdtInterstitialParams", "writeToParcel error");
      return;
    }
    String str;
    if ((this.jdField_a_of_type_OrgJsonJSONObject != null) && (!JSONObject.NULL.equals(this.jdField_a_of_type_OrgJsonJSONObject)))
    {
      str = this.jdField_a_of_type_OrgJsonJSONObject.toString();
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options, paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.b);
      if (!this.jdField_a_of_type_Boolean) {
        break label91;
      }
    }
    label91:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      str = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialParams
 * JD-Core Version:    0.7.0.1
 */