package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import lwl;

public class AVRedPacketConfig$ExpressionInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ExpressionInfo> CREATOR = new lwl();
  public int coolValue;
  public int id;
  public int perfectValue;
  
  public AVRedPacketConfig$ExpressionInfo() {}
  
  public AVRedPacketConfig$ExpressionInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.coolValue = paramParcel.readInt();
    this.perfectValue = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ExpressionInfo{id=" + this.id + ", coolValue=" + this.coolValue + ", perfectValue=" + this.perfectValue + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.coolValue);
    paramParcel.writeInt(this.perfectValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.service.AVRedPacketConfig.ExpressionInfo
 * JD-Core Version:    0.7.0.1
 */