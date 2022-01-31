package com.tencent.mobileqq.armap.wealthgod;

import abbk;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARMapLoadingActivity$LoadingTimeStamp
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new abbk();
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public long p;
  
  public ARMapLoadingActivity$LoadingTimeStamp() {}
  
  public ARMapLoadingActivity$LoadingTimeStamp(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readLong();
    this.l = paramParcel.readLong();
    this.m = paramParcel.readLong();
    this.n = paramParcel.readLong();
    this.o = paramParcel.readLong();
    this.p = paramParcel.readLong();
  }
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mLoadingBeginTime=").append(this.a).append(",mLoadingEndTime=").append(this.b).append(",mLocationBeginTime=").append(this.c).append(",mLocationEndTime=").append(this.d).append(",mRequestInfoBeginTime=").append(this.e).append(",mRequestInfoEndTime=").append(this.f).append(",mResCheckBeginTime=").append(this.g).append(",mResCheckEndTime=").append(this.h).append(",mSoCheckBeginTime=").append(this.i).append(",mSoCheckEndTime=").append(this.j).append(",mStartThreadBeginTime=").append(this.k).append(",mStartThreadEndTime=").append(this.l).append(",mLaunchARMapBeginTime=").append(this.m).append(",mLaunchARMapEndTime=").append(this.n).append(",mLoadMapBeginTime=").append(this.o).append(",mLoadMapEndTime=").append(this.p);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeLong(this.j);
    paramParcel.writeLong(this.k);
    paramParcel.writeLong(this.l);
    paramParcel.writeLong(this.m);
    paramParcel.writeLong(this.n);
    paramParcel.writeLong(this.o);
    paramParcel.writeLong(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity.LoadingTimeStamp
 * JD-Core Version:    0.7.0.1
 */