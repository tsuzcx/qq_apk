package com.tencent.device.JNICallCenter;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DataPoint$1
  implements Parcelable.Creator<DataPoint>
{
  public DataPoint a(Parcel paramParcel)
  {
    DataPoint localDataPoint = new DataPoint();
    localDataPoint.mDin = paramParcel.readLong();
    localDataPoint.mSendUinType = paramParcel.readInt();
    localDataPoint.mApiName = paramParcel.readString();
    localDataPoint.mProperityId = paramParcel.readInt();
    localDataPoint.mValueType = paramParcel.readString();
    localDataPoint.mValue = paramParcel.readString();
    localDataPoint.mRetCode = paramParcel.readInt();
    localDataPoint.mErrMsg = paramParcel.readString();
    localDataPoint.mSeq = paramParcel.readString();
    return localDataPoint;
  }
  
  public DataPoint[] a(int paramInt)
  {
    return new DataPoint[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.JNICallCenter.DataPoint.1
 * JD-Core Version:    0.7.0.1
 */