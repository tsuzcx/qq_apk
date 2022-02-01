package com.tencent.mobileqq.app.soso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.map.geolocation.TencentPoi;
import java.util.LinkedList;
import java.util.List;

public final class SosoInterface$SosoLocation
  implements Parcelable
{
  public static final Parcelable.Creator<SosoLocation> CREATOR = new SosoInterface.SosoLocation.1();
  public float accuracy;
  public String address;
  public double altitude;
  public String city;
  public String cityCode;
  public String district;
  public int fakeReason;
  public long locationTime;
  public double mLat02;
  public double mLat84;
  public double mLon02;
  public double mLon84;
  public String mProviderSource;
  public String mVerifyKey;
  public String name;
  public String nation;
  public List<TencentPoi> poi;
  public String province;
  public float speed;
  public String street;
  public String streetNo;
  public String town;
  public String village;
  
  public SosoInterface$SosoLocation() {}
  
  protected SosoInterface$SosoLocation(Parcel paramParcel)
  {
    this.mLat02 = paramParcel.readDouble();
    this.mLon02 = paramParcel.readDouble();
    this.mLat84 = paramParcel.readDouble();
    this.mLon84 = paramParcel.readDouble();
    this.altitude = paramParcel.readDouble();
    this.accuracy = paramParcel.readFloat();
    this.fakeReason = paramParcel.readInt();
    this.locationTime = paramParcel.readLong();
    this.speed = paramParcel.readFloat();
    this.name = paramParcel.readString();
    this.address = paramParcel.readString();
    this.nation = paramParcel.readString();
    this.province = paramParcel.readString();
    this.city = paramParcel.readString();
    this.cityCode = paramParcel.readString();
    this.district = paramParcel.readString();
    this.town = paramParcel.readString();
    this.village = paramParcel.readString();
    this.street = paramParcel.readString();
    this.streetNo = paramParcel.readString();
    this.mVerifyKey = paramParcel.readString();
    this.mProviderSource = paramParcel.readString();
  }
  
  public SosoLocation clone(int paramInt, boolean paramBoolean)
  {
    SosoLocation localSosoLocation = new SosoLocation();
    if (paramBoolean)
    {
      localSosoLocation.mLat02 = this.mLat02;
      localSosoLocation.mLon02 = this.mLon02;
      localSosoLocation.mLat84 = this.mLat84;
      localSosoLocation.mLon84 = this.mLon84;
    }
    localSosoLocation.speed = this.speed;
    localSosoLocation.altitude = this.altitude;
    localSosoLocation.accuracy = this.accuracy;
    localSosoLocation.mVerifyKey = this.mVerifyKey;
    localSosoLocation.fakeReason = this.fakeReason;
    localSosoLocation.locationTime = this.locationTime;
    localSosoLocation.mProviderSource = this.mProviderSource;
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4))
    {
      localSosoLocation.name = this.name;
      localSosoLocation.address = this.address;
    }
    if ((paramInt == 3) || (paramInt == 4))
    {
      localSosoLocation.nation = this.nation;
      localSosoLocation.province = this.province;
      localSosoLocation.city = this.city;
      localSosoLocation.cityCode = this.cityCode;
      localSosoLocation.district = this.district;
      localSosoLocation.town = this.town;
      localSosoLocation.village = this.village;
      localSosoLocation.street = this.street;
      localSosoLocation.streetNo = this.streetNo;
    }
    if (paramInt == 4)
    {
      LinkedList localLinkedList = new LinkedList();
      if ((this.poi != null) && (this.poi.size() > 0)) {
        localLinkedList.addAll(this.poi);
      }
      localSosoLocation.poi = localLinkedList;
    }
    return localSosoLocation;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.mLat02);
    paramParcel.writeDouble(this.mLon02);
    paramParcel.writeDouble(this.mLat84);
    paramParcel.writeDouble(this.mLon84);
    paramParcel.writeDouble(this.altitude);
    paramParcel.writeFloat(this.accuracy);
    paramParcel.writeInt(this.fakeReason);
    paramParcel.writeLong(this.locationTime);
    paramParcel.writeFloat(this.speed);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.address);
    paramParcel.writeString(this.nation);
    paramParcel.writeString(this.province);
    paramParcel.writeString(this.city);
    paramParcel.writeString(this.cityCode);
    paramParcel.writeString(this.district);
    paramParcel.writeString(this.town);
    paramParcel.writeString(this.village);
    paramParcel.writeString(this.street);
    paramParcel.writeString(this.streetNo);
    paramParcel.writeString(this.mVerifyKey);
    paramParcel.writeString(this.mProviderSource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation
 * JD-Core Version:    0.7.0.1
 */