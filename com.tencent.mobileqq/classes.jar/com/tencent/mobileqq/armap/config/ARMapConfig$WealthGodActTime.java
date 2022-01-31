package com.tencent.mobileqq.armap.config;

import ablx;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.message.MessageCache;
import java.io.Serializable;

public class ARMapConfig$WealthGodActTime
  implements Parcelable, Serializable, Comparable
{
  public static final Parcelable.Creator CREATOR = new ablx();
  public static final int STATUS_END = 0;
  public static final int STATUS_ING = 2;
  public static final int STATUS_NO_BEGIN = 1;
  public long beginTime;
  public long endTime;
  
  public ARMapConfig$WealthGodActTime() {}
  
  public ARMapConfig$WealthGodActTime(Parcel paramParcel)
  {
    this.beginTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
  }
  
  public int compareTo(WealthGodActTime paramWealthGodActTime)
  {
    int i = getStatus();
    int j = paramWealthGodActTime.getStatus();
    if (i == j)
    {
      if (i == 0) {
        return (int)(this.endTime - paramWealthGodActTime.endTime);
      }
      if (i == 2) {
        return (int)(this.endTime - paramWealthGodActTime.endTime);
      }
      return (int)(paramWealthGodActTime.beginTime - this.beginTime);
    }
    return i - j;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getStatus()
  {
    long l = MessageCache.a() * 1000L;
    if (l > this.endTime) {
      return 0;
    }
    if ((l > this.beginTime) && (l < this.endTime)) {
      return 2;
    }
    return 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("WealthGodActTime::");
    localStringBuilder.append(",beginTime:").append(this.beginTime).append(",endTime:").append(this.endTime).append(",status:").append(getStatus());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.beginTime);
    paramParcel.writeLong(this.endTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodActTime
 * JD-Core Version:    0.7.0.1
 */