package com.tencent.device.JNICallCenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import pqx;

public class DataPoint
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new pqx();
  public static final int NAS_SUB_ISLOGIN = 1003;
  public static final int PID_ARK_MSG = 11010;
  public static final int PID_AUTH_REQUEST_StructMsg = 11008;
  public static final int PID_AudioMsg = 10003;
  public static final int PID_BLE_BgConnect = 11004;
  public static final int PID_COMMON_S2C_StructMsg = 11012;
  public static final int PID_DEVICE_REBOOT = 11002;
  public static final int PID_GROUPIMAGE = 10010;
  public static final int PID_GROUPPTT = 10011;
  public static final int PID_GROUPTEXT = 10008;
  public static final int PID_GROUPVIDEO = 10009;
  public static final int PID_LOCK_DEAL_TIP = 10115;
  public static final int PID_LOCK_OPEN = 10113;
  public static final int PID_LOCK_TIP = 10014;
  public static final int PID_MSG_PROXY = 11016;
  public static final int PID_NAS_ROUTER = 90004;
  public static final int PID_OPENSDK_AV = 700154;
  public static final int PID_PreAudioMsg = 10013;
  public static final int PID_PreSingleStructMsg = 10012;
  public static final int PID_RawTextMsg = 10007;
  public static final int PID_SMARTDEVICE = 11015;
  public static final int PID_SingleStructMsg = 10004;
  public static final int PID_SwitchDisconnect = 10102;
  public static final int PID_TextMsg = 10000;
  public static final int PID_WEB_LINK = 11005;
  public static final int PID_WEB_MUSIC = 11003;
  public static final int UINTYPE_DIN = 4;
  public static final int UINTYPE_MOBILE = 6;
  public static final int UINTYPE_QQ = 1;
  public static final int UINTYPE_TINYID = 5;
  public String mApiName;
  public long mDin;
  public String mErrMsg;
  public int mProperityId;
  public int mRetCode;
  public int mSendUinType;
  public String mSeq;
  public String mValue;
  public String mValueType;
  
  public DataPoint()
  {
    this.mSendUinType = 0;
    this.mProperityId = 0;
    this.mRetCode = 0;
  }
  
  public DataPoint(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4)
  {
    this.mDin = paramLong;
    this.mSendUinType = paramInt1;
    this.mApiName = paramString1;
    this.mProperityId = paramInt2;
    this.mValueType = paramString2;
    this.mValue = paramString3;
    this.mRetCode = paramInt3;
    this.mErrMsg = paramString4;
  }
  
  public DataPoint(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    this.mDin = paramLong;
    this.mSendUinType = paramInt1;
    this.mApiName = paramString1;
    this.mProperityId = paramInt2;
    this.mValueType = paramString2;
    this.mValue = paramString3;
    this.mRetCode = paramInt3;
    this.mErrMsg = paramString4;
    this.mSeq = paramString5;
  }
  
  public DataPoint(Parcel paramParcel)
  {
    this.mDin = paramParcel.readLong();
    this.mSendUinType = paramParcel.readInt();
    this.mApiName = paramParcel.readString();
    this.mProperityId = paramParcel.readInt();
    this.mValueType = paramParcel.readString();
    this.mValue = paramParcel.readString();
    this.mRetCode = paramParcel.readInt();
    this.mErrMsg = paramParcel.readString();
    this.mSeq = paramParcel.readString();
  }
  
  public DataPoint(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.mApiName = paramString1;
    this.mProperityId = paramInt;
    this.mValueType = paramString2;
    this.mValue = paramString3;
    this.mRetCode = 0;
    this.mDin = 0L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void init(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4)
  {
    this.mDin = paramLong;
    this.mSendUinType = paramInt1;
    this.mApiName = paramString1;
    this.mProperityId = paramInt2;
    this.mValueType = paramString2;
    this.mValue = paramString3;
    this.mRetCode = paramInt3;
    this.mErrMsg = paramString4;
  }
  
  public String toString()
  {
    return "[datapoint din=" + this.mDin + " id=" + this.mProperityId + " value=" + this.mValue;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mDin);
    paramParcel.writeInt(this.mSendUinType);
    paramParcel.writeString(this.mApiName);
    paramParcel.writeInt(this.mProperityId);
    paramParcel.writeString(this.mValueType);
    paramParcel.writeString(this.mValue);
    paramParcel.writeInt(this.mRetCode);
    paramParcel.writeString(this.mErrMsg);
    paramParcel.writeString(this.mSeq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.JNICallCenter.DataPoint
 * JD-Core Version:    0.7.0.1
 */