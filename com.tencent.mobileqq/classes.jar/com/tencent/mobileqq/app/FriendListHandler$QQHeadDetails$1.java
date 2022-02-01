package com.tencent.mobileqq.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FriendListHandler$QQHeadDetails$1
  implements Parcelable.Creator<FriendListHandler.QQHeadDetails>
{
  public FriendListHandler.QQHeadDetails createFromParcel(Parcel paramParcel)
  {
    FriendListHandler.QQHeadDetails localQQHeadDetails = new FriendListHandler.QQHeadDetails(null);
    localQQHeadDetails.userType = paramParcel.readInt();
    localQQHeadDetails.uinOrMobile = paramParcel.readString();
    localQQHeadDetails.headImgTimestamp = paramParcel.readLong();
    localQQHeadDetails.level = paramParcel.readByte();
    return localQQHeadDetails;
  }
  
  public FriendListHandler.QQHeadDetails[] newArray(int paramInt)
  {
    return new FriendListHandler.QQHeadDetails[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler.QQHeadDetails.1
 * JD-Core Version:    0.7.0.1
 */