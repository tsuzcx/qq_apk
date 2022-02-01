package com.huawei.hms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class DataHolderCreator
  implements Parcelable.Creator<DataHolder>
{
  public final DataHolder createFromParcel(Parcel paramParcel)
  {
    int m = SafeParcelReader.validateObjectHeader(paramParcel);
    int k = 0;
    String[] arrayOfString = null;
    Object localObject1 = arrayOfString;
    Object localObject2 = localObject1;
    int j = 0;
    int i = 0;
    while ((k <= m) && (paramParcel.dataPosition() < m))
    {
      k += 1;
      int n = SafeParcelReader.readHeader(paramParcel);
      int i1 = SafeParcelReader.getFieldId(n);
      if (i1 != 1000)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 4) {
                SafeParcelReader.skipUnknownField(paramParcel, n);
              } else {
                localObject2 = SafeParcelReader.createBundle(paramParcel, n);
              }
            }
            else {
              i = SafeParcelReader.readInt(paramParcel, n);
            }
          }
          else {
            localObject1 = (CursorWindow[])SafeParcelReader.createTypedArray(paramParcel, n, CursorWindow.CREATOR);
          }
        }
        else {
          arrayOfString = SafeParcelReader.createStringArray(paramParcel, n);
        }
      }
      else {
        j = SafeParcelReader.readInt(paramParcel, n);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, m);
    return new DataHolder(j, arrayOfString, (CursorWindow[])localObject1, i, (Bundle)localObject2);
  }
  
  public final DataHolder[] newArray(int paramInt)
  {
    return new DataHolder[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.data.DataHolderCreator
 * JD-Core Version:    0.7.0.1
 */