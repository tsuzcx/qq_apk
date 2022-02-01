package com.tencent.mobileqq.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShieldOperationItem$1
  implements Parcelable.Creator<ShieldOperationItem>
{
  public ShieldOperationItem a(Parcel paramParcel)
  {
    ShieldOperationItem localShieldOperationItem = new ShieldOperationItem();
    localShieldOperationItem.a = paramParcel.readInt();
    localShieldOperationItem.b = paramParcel.readInt();
    localShieldOperationItem.c = paramParcel.readInt();
    localShieldOperationItem.d = paramParcel.createLongArray();
    localShieldOperationItem.e = paramParcel.readInt();
    return localShieldOperationItem;
  }
  
  public ShieldOperationItem[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShieldOperationItem.1
 * JD-Core Version:    0.7.0.1
 */