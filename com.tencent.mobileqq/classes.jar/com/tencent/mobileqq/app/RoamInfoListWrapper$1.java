package com.tencent.mobileqq.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

final class RoamInfoListWrapper$1
  implements Parcelable.Creator<RoamInfoListWrapper>
{
  public RoamInfoListWrapper a(Parcel paramParcel)
  {
    RoamInfoListWrapper localRoamInfoListWrapper = new RoamInfoListWrapper();
    localRoamInfoListWrapper.a = paramParcel.readArrayList(ArrayList.class.getClassLoader());
    return localRoamInfoListWrapper;
  }
  
  public RoamInfoListWrapper[] a(int paramInt)
  {
    return new RoamInfoListWrapper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RoamInfoListWrapper.1
 * JD-Core Version:    0.7.0.1
 */