package com.tencent.mobileqq.app.soso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SosoInterface$SosoLbsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SosoLbsInfo> CREATOR = new SosoInterface.SosoLbsInfo.1();
  public SosoInterface.SosoAttribute mAttr;
  public ArrayList<SosoInterface.SosoCell> mCells = new ArrayList();
  public SosoInterface.SosoLocation mLocation;
  public long mSource;
  public String mVersion;
  public ArrayList<SosoInterface.SosoWifi> mWifis = new ArrayList();
  public String provider;
  public byte[] rawData;
  
  public SosoInterface$SosoLbsInfo() {}
  
  protected SosoInterface$SosoLbsInfo(Parcel paramParcel)
  {
    this.rawData = paramParcel.createByteArray();
    this.mVersion = paramParcel.readString();
    this.mSource = paramParcel.readLong();
    this.mAttr = ((SosoInterface.SosoAttribute)paramParcel.readParcelable(SosoInterface.SosoAttribute.class.getClassLoader()));
    this.mLocation = ((SosoInterface.SosoLocation)paramParcel.readParcelable(SosoInterface.SosoLocation.class.getClassLoader()));
    this.provider = paramParcel.readString();
    this.mCells = paramParcel.createTypedArrayList(SosoInterface.SosoCell.CREATOR);
    this.mWifis = paramParcel.createTypedArrayList(SosoInterface.SosoWifi.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.rawData);
    paramParcel.writeString(this.mVersion);
    paramParcel.writeLong(this.mSource);
    paramParcel.writeParcelable(this.mAttr, paramInt);
    paramParcel.writeParcelable(this.mLocation, paramInt);
    paramParcel.writeString(this.provider);
    paramParcel.writeTypedList(this.mCells);
    paramParcel.writeTypedList(this.mWifis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo
 * JD-Core Version:    0.7.0.1
 */