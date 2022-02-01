package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class DownloadResult$Process
  implements Parcelable
{
  public static final Parcelable.Creator<Process> CREATOR = new DownloadResult.Process.1();
  public long duration;
  public long endTime;
  public long startTime;
  public long startTimestamp;
  public long totalDuration;
  
  DownloadResult$Process() {}
  
  public DownloadResult$Process(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.duration = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void reset()
  {
    this.startTime = 0L;
    this.endTime = 0L;
    this.duration = 0L;
  }
  
  public void setDuration(long paramLong1, long paramLong2)
  {
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.duration = (paramLong2 - paramLong1);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.duration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult.Process
 * JD-Core Version:    0.7.0.1
 */