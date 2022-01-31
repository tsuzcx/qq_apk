package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import java.io.File;
import vlr;

public abstract class AIORichMediaData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new vlr();
  public int f;
  public long g;
  public long h;
  public long i;
  
  public static AIORichMediaData a(String paramString)
  {
    if (AIOImageData.class.getSimpleName().equals(paramString)) {
      return new AIOImageData();
    }
    if (AIOShortVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOShortVideoData();
    }
    if (AIODevLittleVideoData.class.getSimpleName().equals(paramString)) {
      return new AIODevLittleVideoData();
    }
    if (AIOFilePicData.class.getSimpleName().equals(paramString)) {
      return new AIOFilePicData();
    }
    if (AIOFileVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOFileVideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public abstract File a(int paramInt);
  
  public abstract String a(int paramInt);
  
  public void a(Parcel paramParcel)
  {
    this.g = paramParcel.readLong();
    this.f = paramParcel.readInt();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
  }
  
  public abstract boolean a(int paramInt);
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getClass().getSimpleName());
    paramParcel.writeLong(this.g);
    paramParcel.writeInt(this.f);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
 * JD-Core Version:    0.7.0.1
 */