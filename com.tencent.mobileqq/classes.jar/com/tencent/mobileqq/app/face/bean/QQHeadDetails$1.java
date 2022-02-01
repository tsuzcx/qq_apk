package com.tencent.mobileqq.app.face.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QQHeadDetails$1
  implements Parcelable.Creator<QQHeadDetails>
{
  public QQHeadDetails a(Parcel paramParcel)
  {
    QQHeadDetails localQQHeadDetails = new QQHeadDetails(null);
    localQQHeadDetails.a = paramParcel.readInt();
    localQQHeadDetails.b = paramParcel.readString();
    localQQHeadDetails.c = paramParcel.readLong();
    localQQHeadDetails.d = paramParcel.readByte();
    return localQQHeadDetails;
  }
  
  public QQHeadDetails[] a(int paramInt)
  {
    return new QQHeadDetails[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.bean.QQHeadDetails.1
 * JD-Core Version:    0.7.0.1
 */