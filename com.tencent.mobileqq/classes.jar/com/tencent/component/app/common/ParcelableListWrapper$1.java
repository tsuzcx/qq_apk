package com.tencent.component.app.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ParcelableListWrapper$1
  implements Parcelable.Creator<ParcelableListWrapper>
{
  public ParcelableListWrapper createFromParcel(Parcel paramParcel)
  {
    paramParcel = ParcelableListWrapper.readArrayList(paramParcel, getClass().getClassLoader());
    if (paramParcel != null) {
      return new ParcelableListWrapper(paramParcel);
    }
    return null;
  }
  
  public ParcelableListWrapper[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.app.common.ParcelableListWrapper.1
 * JD-Core Version:    0.7.0.1
 */