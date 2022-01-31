package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import ysz;
import yuk;
import yxp;

public class GdtInterstitialParams
  extends ysz
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialParams> CREATOR = new yuk();
  public int a;
  public long a;
  public GdtHandler.Options a;
  public boolean a;
  public long b = -2147483648L;
  
  public GdtInterstitialParams()
  {
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_a_of_type_Long = -2147483648L;
  }
  
  public GdtInterstitialParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_a_of_type_Long = -2147483648L;
    if (paramParcel == null)
    {
      yxp.d("GdtInterstitialParams", "GdtInterstitialParams(Parcel in) error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = ((GdtHandler.Options)paramParcel.readParcelable(GdtHandler.Options.class.getClassLoader()));
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
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
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options != null) && (this.jdField_a_of_type_Int != -2147483648);
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
      yxp.d("GdtInterstitialParams", "writeToParcel error");
      return;
    }
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialParams
 * JD-Core Version:    0.7.0.1
 */