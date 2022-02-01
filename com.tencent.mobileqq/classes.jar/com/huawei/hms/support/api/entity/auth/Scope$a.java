package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Scope$a
  implements Parcelable.Creator<Scope>
{
  public Scope createFromParcel(Parcel paramParcel)
  {
    return new Scope(paramParcel);
  }
  
  public Scope[] newArray(int paramInt)
  {
    return new Scope[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.auth.Scope.a
 * JD-Core Version:    0.7.0.1
 */