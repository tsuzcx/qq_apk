package com.tencent.device.datadef;

import abgf;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ProductInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ProductInfo> CREATOR = new abgf();
  public static final int DeviceOSType_Android = 2;
  public static final int DeviceOSType_Linux = 1;
  public static final int DeviceOSType_RTOS = 3;
  public static final int RegType_Cross = 1;
  public static final int RegType_Direct = 0;
  public static final int SupportFuncType_All = 3;
  public static final int SupportFuncType_Pic = 1;
  public static final int SupportFuncType_Video = 2;
  public static final int SupportMainType_All = 15;
  public static final int SupportMainType_Audio = 2;
  public static final int SupportMainType_File = 8;
  public static final int SupportMainType_Func = 4;
  public static final int SupportMainType_Text = 1;
  public int bindType;
  public String deviceName;
  public int deviceOSType;
  public int deviceType;
  public String linkDescImg;
  public String linkStateDesc;
  public String linkStepDesc;
  public int productId;
  public int regType;
  public int supportFuncMsgType;
  public int supportMainMsgType;
  public int uConnectType;
  
  public ProductInfo() {}
  
  public ProductInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.productId = paramInt1;
    this.deviceType = paramInt2;
    this.bindType = paramInt3;
    this.supportMainMsgType = paramInt4;
    this.supportFuncMsgType = paramInt5;
    this.uConnectType = paramInt6;
    this.deviceOSType = paramInt7;
    this.regType = paramInt8;
  }
  
  public ProductInfo(Parcel paramParcel)
  {
    this.productId = paramParcel.readInt();
    this.deviceType = paramParcel.readInt();
    this.bindType = paramParcel.readInt();
    this.supportMainMsgType = paramParcel.readInt();
    this.supportFuncMsgType = paramParcel.readInt();
    this.deviceName = paramParcel.readString();
    this.uConnectType = paramParcel.readInt();
    this.deviceOSType = paramParcel.readInt();
    this.regType = paramParcel.readInt();
    this.linkStateDesc = paramParcel.readString();
    this.linkStepDesc = paramParcel.readString();
    this.linkDescImg = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isSupportFuncMsgType(int paramInt)
  {
    return (this.supportFuncMsgType & paramInt) == paramInt;
  }
  
  public boolean isSupportMainMsgType(int paramInt)
  {
    return (this.supportMainMsgType & paramInt) == paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.productId);
    paramParcel.writeInt(this.deviceType);
    paramParcel.writeInt(this.bindType);
    paramParcel.writeInt(this.supportMainMsgType);
    paramParcel.writeInt(this.supportFuncMsgType);
    paramParcel.writeString(this.deviceName);
    paramParcel.writeInt(this.uConnectType);
    paramParcel.writeInt(this.deviceOSType);
    paramParcel.writeInt(this.regType);
    paramParcel.writeString(this.linkStateDesc);
    paramParcel.writeString(this.linkStepDesc);
    paramParcel.writeSerializable(this.linkDescImg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.datadef.ProductInfo
 * JD-Core Version:    0.7.0.1
 */