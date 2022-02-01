package com.tencent.avgame.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UserInfo$1
  implements Parcelable.Creator<UserInfo>
{
  public UserInfo a(Parcel paramParcel)
  {
    return new UserInfo(paramParcel);
  }
  
  public UserInfo[] a(int paramInt)
  {
    return new UserInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.UserInfo.1
 * JD-Core Version:    0.7.0.1
 */