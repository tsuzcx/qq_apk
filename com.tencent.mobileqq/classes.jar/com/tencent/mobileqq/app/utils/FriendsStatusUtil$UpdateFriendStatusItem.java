package com.tencent.mobileqq.app.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import java.util.Arrays;

public class FriendsStatusUtil$UpdateFriendStatusItem
  implements Parcelable
{
  public static final Parcelable.Creator<UpdateFriendStatusItem> CREATOR = new FriendsStatusUtil.UpdateFriendStatusItem.1();
  public String a = null;
  public int b = 0;
  public int c = -1;
  public long d = -1L;
  private byte[] e = null;
  
  protected FriendsStatusUtil$UpdateFriendStatusItem(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    byte[] arrayOfByte = this.e;
    if (arrayOfByte != null) {
      paramParcel.readByteArray(arrayOfByte);
    }
  }
  
  public FriendsStatusUtil$UpdateFriendStatusItem(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public FriendsStatusUtil$UpdateFriendStatusItem(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.a = paramString;
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = paramLong;
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.e = new byte[4];
      byte[] arrayOfByte = this.e;
      arrayOfByte[0] = ((byte)(int)(paramLong >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(int)(paramLong >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(int)(paramLong >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(int)(paramLong & 0xFF));
      return;
    }
    if (paramLong == 0L)
    {
      this.e = new byte[0];
      return;
    }
    this.e = null;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.e;
  }
  
  public long b()
  {
    byte[] arrayOfByte = this.e;
    long l = -1L;
    if (arrayOfByte == null) {
      return -1L;
    }
    if (arrayOfByte.length == 0) {
      return 0L;
    }
    if (arrayOfByte.length == 4) {
      return MessageHandlerUtils.a(arrayOfByte);
    }
    if (arrayOfByte.length == 8) {
      l = MessageHandlerUtils.a(Arrays.copyOfRange(arrayOfByte, 0, 4));
    }
    return l;
  }
  
  public void b(long paramLong)
  {
    this.e = new byte[8];
    if (paramLong > 0L)
    {
      byte[] arrayOfByte = this.e;
      arrayOfByte[0] = ((byte)(int)(paramLong >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(int)(paramLong >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(int)(paramLong >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(int)(paramLong & 0xFF));
      arrayOfByte[4] = -1;
      arrayOfByte[5] = -1;
      arrayOfByte[6] = -1;
      arrayOfByte[7] = -1;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      this.e = new byte[8];
    }
    this.e = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("item:serType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" sns_type=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" serviceTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" identify=");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    byte[] arrayOfByte = this.e;
    if (arrayOfByte != null) {
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem
 * JD-Core Version:    0.7.0.1
 */