package com.tencent.mobileqq.app.face.bean;

import AvatarInfo.DestQQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QQHeadDetails
  implements Parcelable
{
  public static final Parcelable.Creator<QQHeadDetails> CREATOR = new QQHeadDetails.1();
  public int a;
  public String b;
  public long c;
  public byte d;
  public int e;
  
  private QQHeadDetails() {}
  
  public QQHeadDetails(int paramInt1, String paramString, long paramLong, byte paramByte, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramLong;
    this.d = paramByte;
    this.e = paramInt2;
  }
  
  public DestQQHeadInfo a()
  {
    if (this.a == 11) {
      return new DestQQHeadInfo(0L, this.c, this.b);
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.b);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label38:
      break label38;
    }
    return new DestQQHeadInfo(l1, this.c, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uinOrMobile:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",timestamp:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeByte(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.bean.QQHeadDetails
 * JD-Core Version:    0.7.0.1
 */