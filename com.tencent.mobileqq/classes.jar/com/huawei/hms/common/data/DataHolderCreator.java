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
    Bundle localBundle = null;
    int i = 0;
    int m = SafeParcelReader.validateObjectHeader(paramParcel);
    int j = 0;
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int k = 0;
    if ((i <= m) && (paramParcel.dataPosition() < m))
    {
      int n = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(n))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, n);
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfString = SafeParcelReader.createStringArray(paramParcel, n);
        continue;
        arrayOfCursorWindow = (CursorWindow[])SafeParcelReader.createTypedArray(paramParcel, n, CursorWindow.CREATOR);
        continue;
        j = SafeParcelReader.readInt(paramParcel, n);
        continue;
        localBundle = SafeParcelReader.createBundle(paramParcel, n);
        continue;
        k = SafeParcelReader.readInt(paramParcel, n);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, m);
    return new DataHolder(k, arrayOfString, arrayOfCursorWindow, j, localBundle);
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