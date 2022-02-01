package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;

public class WadlResult
  implements Parcelable
{
  public static final Parcelable.Creator<WadlResult> CREATOR = new WadlResult.1();
  public WadlParams a;
  public int b;
  public String c = "";
  public int d;
  public long e;
  public long f;
  public String g;
  public long h;
  public long i;
  public int j;
  public int k;
  
  protected WadlResult(Parcel paramParcel)
  {
    this.a = ((WadlParams)paramParcel.readParcelable(WadlParams.class.getClassLoader()));
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readString();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
  }
  
  public WadlResult(WadlParams paramWadlParams)
  {
    if (paramWadlParams != null) {
      this.a = paramWadlParams;
    }
  }
  
  public boolean a()
  {
    WadlParams localWadlParams = this.a;
    boolean bool2 = false;
    if (localWadlParams != null) {
      bool1 = localWadlParams.b;
    } else {
      bool1 = false;
    }
    if ((!bool1) && (this.d == 9)) {
      this.d = 6;
    }
    if ((this.d == 6) && (!GameCenterUtil.a(this.g))) {
      this.d = 0;
    }
    boolean bool1 = bool2;
    if (this.d != 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WadlResult{wadlParams=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", event=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", taskId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", taskStatus=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", downloadFileSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", downloadFilePath='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", lastUpdateTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", errCode=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlResult
 * JD-Core Version:    0.7.0.1
 */