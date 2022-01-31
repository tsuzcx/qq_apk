package com.tencent.intervideo.nowproxy.proxyinner.channel;

import abps;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ToService
  implements Parcelable
{
  public static final Parcelable.Creator<ToService> CREATOR = new abps();
  public int a;
  public long a;
  public Bundle a;
  public String a;
  public int b;
  public int c;
  public int d;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.ToService
 * JD-Core Version:    0.7.0.1
 */