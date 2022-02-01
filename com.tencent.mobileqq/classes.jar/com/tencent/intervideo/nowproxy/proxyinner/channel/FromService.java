package com.tencent.intervideo.nowproxy.proxyinner.channel;

import adjt;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FromService
  implements Parcelable
{
  public static final Parcelable.Creator<FromService> CREATOR = new adjt();
  public int a;
  public Bundle a;
  public int b;
  public int c;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.FromService
 * JD-Core Version:    0.7.0.1
 */