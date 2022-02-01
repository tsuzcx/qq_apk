package com.tencent.mobileqq.activity.selectmember;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public class ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator<ResultRecord> CREATOR = new ResultRecord.1();
  public String gameLevelIcon;
  public String groupUin;
  public boolean isNewTroop;
  public long lastChooseTime;
  public String name;
  public String phone;
  public int type;
  public String uin;
  public int uinType = -1;
  
  public ResultRecord() {}
  
  private ResultRecord(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.name = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.groupUin = paramParcel.readString();
    this.phone = paramParcel.readString();
    this.lastChooseTime = paramParcel.readLong();
    this.uinType = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isNewTroop = bool;
      this.gameLevelIcon = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public ResultRecord(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    init(paramString1, paramString2, paramInt, paramString3, paramString4);
  }
  
  public static ResultRecord copyResultRecord(ResultRecord paramResultRecord)
  {
    ResultRecord localResultRecord = null;
    if (paramResultRecord != null)
    {
      localResultRecord = new ResultRecord();
      localResultRecord.uin = paramResultRecord.uin;
      localResultRecord.name = paramResultRecord.name;
      localResultRecord.type = paramResultRecord.type;
      localResultRecord.groupUin = paramResultRecord.groupUin;
      localResultRecord.phone = paramResultRecord.phone;
      localResultRecord.uinType = paramResultRecord.uinType;
      localResultRecord.isNewTroop = paramResultRecord.isNewTroop;
      localResultRecord.gameLevelIcon = paramResultRecord.gameLevelIcon;
    }
    return localResultRecord;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ResultRecord))
    {
      paramObject = (ResultRecord)paramObject;
      if ((paramObject.uin.equals(this.uin)) && (paramObject.type == this.type) && (((!TextUtils.isEmpty(this.phone)) && (!TextUtils.isEmpty(paramObject.phone)) && (this.phone.equals(paramObject.phone))) || ((TextUtils.isEmpty(this.phone)) && (TextUtils.isEmpty(paramObject.phone))))) {
        return true;
      }
    }
    return false;
  }
  
  public int getUinType()
  {
    if ((this.uinType == -1) && (this.type == 4)) {
      return 1006;
    }
    return this.uinType;
  }
  
  public void init(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.uin = paramString1;
    this.name = paramString2;
    this.uinType = paramInt;
    this.groupUin = paramString3;
    this.phone = paramString4;
    this.lastChooseTime = 0L;
    this.isNewTroop = false;
    this.gameLevelIcon = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin:").append(this.uin);
    localStringBuilder.append(", name:").append(this.name);
    localStringBuilder.append(", type:").append(this.type);
    localStringBuilder.append(", groupUin:").append(this.groupUin);
    localStringBuilder.append(", uinType:").append(this.uinType);
    localStringBuilder.append(", phone:").append(this.phone).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.groupUin);
    paramParcel.writeString(this.phone);
    paramParcel.writeLong(this.lastChooseTime);
    paramParcel.writeInt(this.uinType);
    if (this.isNewTroop) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.gameLevelIcon);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ResultRecord
 * JD-Core Version:    0.7.0.1
 */