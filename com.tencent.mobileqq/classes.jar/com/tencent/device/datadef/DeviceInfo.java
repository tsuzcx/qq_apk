package com.tencent.device.datadef;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DeviceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DeviceInfo> CREATOR = new DeviceInfo.1();
  public static final double MULTIVIDEOVER = 1.4D;
  public int SSOBid_Platform = 0;
  public String SSOBid_Version = "";
  public String appSecret = "";
  public long din = 0L;
  public String displayName = "";
  public int isAdmin = 0;
  public String name = "";
  public String netAPN = "";
  public String netAddress = "";
  public String netDetail = "";
  public int netType = 0;
  public String osPlatform = "";
  public String osVersion = "";
  public int productId = 0;
  public int productType = 0;
  public int productVer = 0;
  public String remark = "";
  public String serialNum = "";
  public short status = 0;
  public String type = "";
  public short userStatus = 0;
  
  public DeviceInfo() {}
  
  public DeviceInfo(Parcel paramParcel)
  {
    this.osPlatform = paramParcel.readString();
    this.osVersion = paramParcel.readString();
    this.netType = paramParcel.readInt();
    this.netDetail = paramParcel.readString();
    this.netAddress = paramParcel.readString();
    this.netAPN = paramParcel.readString();
    this.name = paramParcel.readString();
    this.remark = paramParcel.readString();
    this.type = paramParcel.readString();
    this.serialNum = paramParcel.readString();
    this.productId = paramParcel.readInt();
    this.appSecret = paramParcel.readString();
    this.din = paramParcel.readLong();
    this.isAdmin = paramParcel.readInt();
    this.status = ((short)paramParcel.readInt());
    this.userStatus = ((short)paramParcel.readInt());
    this.productType = paramParcel.readInt();
    this.displayName = paramParcel.readString();
    this.productVer = paramParcel.readInt();
    this.SSOBid_Platform = paramParcel.readInt();
    this.SSOBid_Version = paramParcel.readString();
  }
  
  public DeviceInfo(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, long paramLong, int paramInt3, short paramShort1, short paramShort2, int paramInt4, int paramInt5, int paramInt6, String paramString11)
  {
    this.osPlatform = paramString1;
    this.osVersion = paramString2;
    this.netType = paramInt1;
    this.netDetail = paramString3;
    this.netAddress = paramString4;
    this.netAPN = paramString5;
    this.name = paramString6;
    this.remark = paramString7;
    this.type = paramString8;
    this.serialNum = paramString9;
    this.productId = paramInt2;
    this.appSecret = paramString10;
    this.din = paramLong;
    this.isAdmin = paramInt3;
    this.status = paramShort1;
    this.userStatus = paramShort2;
    this.productType = paramInt4;
    this.productVer = paramInt5;
    this.SSOBid_Platform = paramInt6;
    this.SSOBid_Version = paramString11;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.osPlatform);
    paramParcel.writeString(this.osVersion);
    paramParcel.writeInt(this.netType);
    paramParcel.writeString(this.netDetail);
    paramParcel.writeString(this.netAddress);
    paramParcel.writeString(this.netAPN);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.remark);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.serialNum);
    paramParcel.writeInt(this.productId);
    paramParcel.writeString(this.appSecret);
    paramParcel.writeLong(this.din);
    paramParcel.writeInt(this.isAdmin);
    paramParcel.writeInt(this.status);
    paramParcel.writeInt(this.userStatus);
    paramParcel.writeInt(this.productType);
    paramParcel.writeString(this.displayName);
    paramParcel.writeInt(this.productVer);
    paramParcel.writeInt(this.SSOBid_Platform);
    paramParcel.writeString(this.SSOBid_Version);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.datadef.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */