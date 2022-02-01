package com.tencent.mobileqq.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShieldOperationItem
  implements Parcelable
{
  public static final Parcelable.Creator<ShieldOperationItem> CREATOR = new ShieldOperationItem.1();
  public int a;
  public int b;
  public int c = 0;
  public long[] d;
  public int e = 0;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("--->>DUMP_ShieldOperationItem<<---");
    localStringBuilder.append(",");
    localStringBuilder.append("opType:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",source_id:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",source_sub_id:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(this.e);
    localStringBuilder.append(",uinList:");
    long[] arrayOfLong = this.d;
    if (arrayOfLong != null) {
      localStringBuilder.append(arrayOfLong.toString());
    } else {
      localStringBuilder.append("null.");
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeLongArray(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShieldOperationItem
 * JD-Core Version:    0.7.0.1
 */