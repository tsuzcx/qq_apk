package com.tencent.aladdin.config.network;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;

class AladdinRequestHandler$ConfigResult
  implements Parcelable
{
  public static final Parcelable.Creator<ConfigResult> CREATOR = new AladdinRequestHandler.ConfigResult.1();
  private final int id;
  private final int retCode;
  private final int version;
  
  AladdinRequestHandler$ConfigResult(int paramInt1, int paramInt2, int paramInt3)
  {
    this.id = paramInt1;
    this.version = paramInt2;
    this.retCode = paramInt3;
  }
  
  AladdinRequestHandler$ConfigResult(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.version = paramParcel.readInt();
    this.retCode = paramParcel.readInt();
  }
  
  private int getId()
  {
    return this.id;
  }
  
  private int getRetCode()
  {
    return this.retCode;
  }
  
  private int getVersion()
  {
    return this.version;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    return "ConfigResult{id=" + this.id + ", version=" + this.version + ", retCode=" + this.retCode + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.retCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.network.AladdinRequestHandler.ConfigResult
 * JD-Core Version:    0.7.0.1
 */