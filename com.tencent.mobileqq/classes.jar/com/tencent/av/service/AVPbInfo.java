package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.avcore.jni.data.AVCorePbInfo;
import lvu;

public class AVPbInfo
  extends AVCorePbInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AVPbInfo> CREATOR = new lvu();
  
  public AVPbInfo() {}
  
  public AVPbInfo(Parcel paramParcel)
  {
    this.bindId = paramParcel.readString();
    this.bindIdType = paramParcel.readInt();
    this.phoneNum = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bindId);
    paramParcel.writeInt(this.bindIdType);
    paramParcel.writeString(this.phoneNum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.service.AVPbInfo
 * JD-Core Version:    0.7.0.1
 */