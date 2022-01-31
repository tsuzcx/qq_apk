package com.tencent.mobileqq.activity;

import aehb;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TroopMemberListActivity$TroopAdmin
  implements Parcelable
{
  public static final Parcelable.Creator<TroopAdmin> CREATOR = new aehb();
  public String a;
  public short a;
  public String b;
  public String c;
  
  public TroopMemberListActivity$TroopAdmin() {}
  
  private TroopMemberListActivity$TroopAdmin(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Short = ((short)paramParcel.readInt());
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopAdmin))
    {
      paramObject = (TroopAdmin)paramObject;
      if (this.jdField_a_of_type_JavaLangString != null) {
        return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Short);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.TroopAdmin
 * JD-Core Version:    0.7.0.1
 */