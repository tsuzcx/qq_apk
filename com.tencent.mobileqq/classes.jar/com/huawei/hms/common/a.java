package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class a
  implements Parcelable.Creator<Feature>
{
  public final Feature a(Parcel paramParcel)
  {
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    int j = 0;
    int i = 0;
    String str = null;
    long l = -1L;
    while ((j <= k) && (paramParcel.dataPosition() < k))
    {
      j += 1;
      int m = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(m))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, m);
        break;
      case 1: 
        str = SafeParcelReader.createString(paramParcel, m);
        break;
      case 2: 
        i = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 3: 
        l = SafeParcelReader.readLong(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    return new Feature(str, i, l);
  }
  
  public final Feature[] a(int paramInt)
  {
    return new Feature[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.a
 * JD-Core Version:    0.7.0.1
 */