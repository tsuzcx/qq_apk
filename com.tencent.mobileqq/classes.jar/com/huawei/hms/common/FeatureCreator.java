package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class FeatureCreator
  implements Parcelable.Creator<Feature>
{
  public final Feature createFromParcel(Parcel paramParcel)
  {
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    int j = 0;
    String str = null;
    long l = -1L;
    int i = 0;
    while ((j <= k) && (paramParcel.dataPosition() < k))
    {
      j += 1;
      int m = SafeParcelReader.readHeader(paramParcel);
      int n = SafeParcelReader.getFieldId(m);
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3) {
            SafeParcelReader.skipUnknownField(paramParcel, m);
          } else {
            l = SafeParcelReader.readLong(paramParcel, m);
          }
        }
        else {
          i = SafeParcelReader.readInt(paramParcel, m);
        }
      }
      else {
        str = SafeParcelReader.createString(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    return new Feature(str, i, l);
  }
  
  public final Feature[] newArray(int paramInt)
  {
    return new Feature[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.FeatureCreator
 * JD-Core Version:    0.7.0.1
 */