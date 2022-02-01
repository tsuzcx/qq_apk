package com.tencent.facebeauty;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FaceParam$1
  implements Parcelable.Creator<FaceParam>
{
  public FaceParam createFromParcel(Parcel paramParcel)
  {
    return new FaceParam(paramParcel, null);
  }
  
  public FaceParam[] newArray(int paramInt)
  {
    return new FaceParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.facebeauty.FaceParam.1
 * JD-Core Version:    0.7.0.1
 */