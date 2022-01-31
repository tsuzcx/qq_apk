package com.tencent.mobileqq.activity.aio.photo;

import aeix;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import java.io.File;

public abstract class AIORichMediaData
  implements Parcelable
{
  public static final Parcelable.Creator<AIORichMediaData> CREATOR = new aeix();
  public int f;
  public long f;
  public int g;
  public long g;
  public long h;
  public long i;
  public boolean k;
  public boolean l;
  public boolean m;
  
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
    if (AIOLightVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOLightVideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public abstract File a(int paramInt);
  
  public abstract String a(int paramInt);
  
  public void a(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.jdField_f_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Long = paramParcel.readLong();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.k = bool1;
      if (paramParcel.readInt() != 1) {
        break label101;
      }
      bool1 = true;
      label75:
      this.l = bool1;
      if (paramParcel.readInt() != 1) {
        break label106;
      }
    }
    label101:
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.m = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label75;
    }
  }
  
  public abstract boolean a(int paramInt);
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeString(getClass().getSimpleName());
    paramParcel.writeLong(this.jdField_f_of_type_Long);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeLong(this.jdField_g_of_type_Long);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    if (this.k)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.l) {
        break label109;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.m) {
        break label114;
      }
    }
    label109:
    label114:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
 * JD-Core Version:    0.7.0.1
 */