package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import txy;

public class ProfileParams
  implements Parcelable
{
  public static final Parcelable.Creator<ProfileParams> CREATOR = new txy();
  public int a;
  public ProfileParams.CurLoginUsr a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ProfileParams.CurLoginUsr a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProfileParams
 * JD-Core Version:    0.7.0.1
 */