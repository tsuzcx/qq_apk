package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ToService$1
  implements Parcelable.Creator<ToService>
{
  public ToService a(Parcel paramParcel)
  {
    ToService localToService = new ToService();
    localToService.jdField_a_of_type_Int = paramParcel.readInt();
    localToService.b = paramParcel.readInt();
    localToService.c = paramParcel.readInt();
    localToService.d = paramParcel.readInt();
    localToService.jdField_a_of_type_Long = paramParcel.readLong();
    localToService.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localToService.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle();
    return localToService;
  }
  
  public ToService[] a(int paramInt)
  {
    return new ToService[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.ToService.1
 * JD-Core Version:    0.7.0.1
 */