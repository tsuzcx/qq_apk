package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BarrageInfo$Sender
  implements Parcelable
{
  public static final Parcelable.Creator<Sender> CREATOR = new BarrageInfo.Sender.1();
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  public BarrageInfo$Sender() {}
  
  protected BarrageInfo$Sender(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "Sender{avatarUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.b + '\'' + ", avatarIconUrl='" + this.c + '\'' + ", isAuthor='" + this.jdField_a_of_type_Boolean + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo.Sender
 * JD-Core Version:    0.7.0.1
 */