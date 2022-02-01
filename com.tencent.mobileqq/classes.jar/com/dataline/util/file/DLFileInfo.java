package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DLFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DLFileInfo> CREATOR = new DLFileInfo.1();
  public long a;
  public int b;
  public String c;
  public String d;
  public long e;
  
  public DLFileInfo() {}
  
  private DLFileInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.file.DLFileInfo
 * JD-Core Version:    0.7.0.1
 */