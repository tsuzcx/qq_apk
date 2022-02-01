package com.tencent.luggage.wxa.km;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable.Creator;

final class f$1
  implements Parcelable.Creator<f>
{
  public f a(Parcel paramParcel)
  {
    f.a locala = new f.a();
    if (paramParcel.readInt() == 1) {
      locala.a(paramParcel.readString());
    }
    if (paramParcel.readInt() == 1) {
      locala.b(paramParcel.readString());
    }
    Object localObject;
    if (paramParcel.readInt() == 1)
    {
      localObject = (ParcelUuid)paramParcel.readParcelable(ParcelUuid.class.getClassLoader());
      locala.a((ParcelUuid)localObject);
      if (paramParcel.readInt() == 1) {
        locala.a((ParcelUuid)localObject, (ParcelUuid)paramParcel.readParcelable(ParcelUuid.class.getClassLoader()));
      }
    }
    byte[] arrayOfByte1;
    if (paramParcel.readInt() == 1)
    {
      localObject = (ParcelUuid)paramParcel.readParcelable(ParcelUuid.class.getClassLoader());
      if (paramParcel.readInt() == 1)
      {
        arrayOfByte1 = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte1);
        if (paramParcel.readInt() == 0)
        {
          locala.a((ParcelUuid)localObject, arrayOfByte1);
        }
        else
        {
          byte[] arrayOfByte2 = new byte[paramParcel.readInt()];
          paramParcel.readByteArray(arrayOfByte2);
          locala.a((ParcelUuid)localObject, arrayOfByte1, arrayOfByte2);
        }
      }
    }
    int i = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      localObject = new byte[paramParcel.readInt()];
      paramParcel.readByteArray((byte[])localObject);
      if (paramParcel.readInt() == 0)
      {
        locala.a(i, (byte[])localObject);
      }
      else
      {
        arrayOfByte1 = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte1);
        locala.a(i, (byte[])localObject, arrayOfByte1);
      }
    }
    return locala.a();
  }
  
  public f[] a(int paramInt)
  {
    return new f[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.f.1
 * JD-Core Version:    0.7.0.1
 */