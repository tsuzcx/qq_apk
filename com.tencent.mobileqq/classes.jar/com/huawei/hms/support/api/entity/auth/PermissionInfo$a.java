package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PermissionInfo$a
  implements Parcelable.Creator<PermissionInfo>
{
  public PermissionInfo createFromParcel(Parcel paramParcel)
  {
    return new PermissionInfo(paramParcel);
  }
  
  public PermissionInfo[] newArray(int paramInt)
  {
    return new PermissionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.auth.PermissionInfo.a
 * JD-Core Version:    0.7.0.1
 */