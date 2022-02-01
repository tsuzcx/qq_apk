package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;

class ParcelableMMKV$1
  implements Parcelable.Creator<ParcelableMMKV>
{
  public ParcelableMMKV a(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    ParcelFileDescriptor localParcelFileDescriptor1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel);
    ParcelFileDescriptor localParcelFileDescriptor2 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel);
    paramParcel = paramParcel.readString();
    if ((localParcelFileDescriptor1 != null) && (localParcelFileDescriptor2 != null)) {
      return new ParcelableMMKV(str, localParcelFileDescriptor1.detachFd(), localParcelFileDescriptor2.detachFd(), paramParcel, null);
    }
    return null;
  }
  
  public ParcelableMMKV[] a(int paramInt)
  {
    return new ParcelableMMKV[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mmkv.ParcelableMMKV.1
 * JD-Core Version:    0.7.0.1
 */