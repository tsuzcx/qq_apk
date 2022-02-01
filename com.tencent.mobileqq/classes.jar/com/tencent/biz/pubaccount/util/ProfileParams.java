package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ProfileParams
  implements Parcelable
{
  public static final Parcelable.Creator<ProfileParams> CREATOR = new ProfileParams.1();
  int jdField_a_of_type_Int;
  ProfileParams.CurLoginUsr jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
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
    ProfileParams.CurLoginUsr localCurLoginUsr = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr;
    if (localCurLoginUsr != null) {
      return localCurLoginUsr.jdField_a_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProfileParams
 * JD-Core Version:    0.7.0.1
 */