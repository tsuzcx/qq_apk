package com.tencent.av.wtogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReqVideoAction
  implements Parcelable
{
  public static final Parcelable.Creator<ReqVideoAction> CREATOR = new ReqVideoAction.1();
  public long a;
  public int b;
  public long c;
  public float d;
  public int e;
  
  public ReqVideoAction(long paramLong, int paramInt, WTSyncPlayInfo paramWTSyncPlayInfo)
  {
    this.a = paramLong;
    this.b = paramInt;
    if (paramWTSyncPlayInfo != null)
    {
      this.c = paramWTSyncPlayInfo.b();
      this.d = paramWTSyncPlayInfo.c();
      this.e = paramWTSyncPlayInfo.a();
      return;
    }
    this.c = 0L;
    this.d = 1.0F;
    this.e = 0;
  }
  
  public ReqVideoAction(long paramLong, int paramInt, WTogetherPlayInfo paramWTogetherPlayInfo)
  {
    this.a = paramLong;
    this.b = paramInt;
    if (paramWTogetherPlayInfo != null)
    {
      this.c = paramWTogetherPlayInfo.d;
      this.d = paramWTogetherPlayInfo.e;
      this.e = paramWTogetherPlayInfo.c;
      return;
    }
    this.c = 0L;
    this.d = 1.0F;
    this.e = 0;
  }
  
  protected ReqVideoAction(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoAction{seq: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", action: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", curPlayTimeMs: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", curPlayRate: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", curPlayState: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.ReqVideoAction
 * JD-Core Version:    0.7.0.1
 */