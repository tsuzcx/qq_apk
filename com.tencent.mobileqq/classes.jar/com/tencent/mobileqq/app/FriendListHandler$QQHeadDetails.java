package com.tencent.mobileqq.app;

import AvatarInfo.DestQQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FriendListHandler$QQHeadDetails
  implements Parcelable
{
  public static final Parcelable.Creator<QQHeadDetails> CREATOR = new FriendListHandler.QQHeadDetails.1();
  public long headImgTimestamp;
  public byte level;
  public int sizeType;
  public String uinOrMobile;
  public int userType;
  
  private FriendListHandler$QQHeadDetails() {}
  
  public FriendListHandler$QQHeadDetails(int paramInt1, String paramString, long paramLong, byte paramByte, int paramInt2)
  {
    this.userType = paramInt1;
    this.uinOrMobile = paramString;
    this.headImgTimestamp = paramLong;
    this.level = paramByte;
    this.sizeType = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DestQQHeadInfo getDestQQHeadInfo()
  {
    long l1 = 0L;
    if (this.userType == 11) {
      return new DestQQHeadInfo(0L, this.headImgTimestamp, this.uinOrMobile);
    }
    try
    {
      long l2 = Long.parseLong(this.uinOrMobile);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label38:
      break label38;
    }
    return new DestQQHeadInfo(l1, this.headImgTimestamp, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uinOrMobile:").append(this.uinOrMobile).append(",timestamp:").append(this.headImgTimestamp).append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.userType);
    paramParcel.writeString(this.uinOrMobile);
    paramParcel.writeLong(this.headImgTimestamp);
    paramParcel.writeByte(this.level);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler.QQHeadDetails
 * JD-Core Version:    0.7.0.1
 */