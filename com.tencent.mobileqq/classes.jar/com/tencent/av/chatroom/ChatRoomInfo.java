package com.tencent.av.chatroom;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ChatRoomInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ChatRoomInfo> CREATOR = new ChatRoomInfo.1();
  public int a;
  public long b;
  public long c;
  public long d;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public long k = 0L;
  private int l = 0;
  
  public ChatRoomInfo(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramInt;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramLong3;
  }
  
  protected ChatRoomInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
  }
  
  public void a()
  {
    this.l += 1;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    return (this.a == paramInt) && (this.b == paramLong1) && (this.c == paramLong2) && (this.d == paramLong3);
  }
  
  public boolean b()
  {
    return this.l <= 3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ChatRoomInfo;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ChatRoomInfo)paramObject;
    bool1 = bool2;
    if (this.a == paramObject.a)
    {
      bool1 = bool2;
      if (this.b == paramObject.b)
      {
        bool1 = bool2;
        if (this.c == paramObject.c)
        {
          bool1 = bool2;
          if (this.d == paramObject.d) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("ChatRoomInfo{");
    localStringBuilder.append("type: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", roomID: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", id: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", createTime: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isFromSwitchTerminal: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", preRoomId: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomInfo
 * JD-Core Version:    0.7.0.1
 */