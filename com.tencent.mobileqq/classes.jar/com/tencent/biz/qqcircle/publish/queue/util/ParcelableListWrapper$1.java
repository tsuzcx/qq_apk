package com.tencent.biz.qqcircle.publish.queue.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ParcelableListWrapper$1
  implements Parcelable.Creator<ParcelableListWrapper>
{
  public ParcelableListWrapper a(Parcel paramParcel)
  {
    paramParcel = ParcelableListWrapper.a(paramParcel, getClass().getClassLoader());
    if (paramParcel != null) {
      return new ParcelableListWrapper(paramParcel);
    }
    return null;
  }
  
  public ParcelableListWrapper[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.util.ParcelableListWrapper.1
 * JD-Core Version:    0.7.0.1
 */