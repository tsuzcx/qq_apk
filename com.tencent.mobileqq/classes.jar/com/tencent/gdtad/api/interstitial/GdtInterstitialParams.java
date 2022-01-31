package com.tencent.gdtad.api.interstitial;

import aanf;
import aaos;
import aase;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;

public class GdtInterstitialParams
  extends aanf
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialParams> CREATOR = new aaos();
  public int a;
  public GdtHandler.Options a;
  public boolean a;
  public int b = -2147483648;
  public int c = -2147483648;
  
  public GdtInterstitialParams()
  {
    this.jdField_a_of_type_Int = -2147483648;
  }
  
  public GdtInterstitialParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -2147483648;
    if (paramParcel == null)
    {
      aase.d("GdtInterstitialParams", "GdtInterstitialParams(Parcel in) error");
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
      aase.d("GdtInterstitialParams", "writeToParcel error");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialParams
 * JD-Core Version:    0.7.0.1
 */