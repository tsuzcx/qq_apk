package com.tencent.mobileqq.activity.photo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ImageInfo$1
  implements Parcelable.Creator<ImageInfo>
{
  public ImageInfo a(Parcel paramParcel)
  {
    ImageInfo localImageInfo = new ImageInfo();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.a = bool1;
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.b = bool1;
    localImageInfo.c = paramParcel.readString();
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.d = bool1;
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.e = bool1;
    localImageInfo.f = paramParcel.readString();
    localImageInfo.g = paramParcel.readString();
    localImageInfo.h = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.i = bool1;
    localImageInfo.j = paramParcel.readString();
    localImageInfo.k = paramParcel.readInt();
    localImageInfo.l = paramParcel.readString();
    localImageInfo.m = paramParcel.readInt();
    localImageInfo.n = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.o = bool1;
    localImageInfo.p = paramParcel.readLong();
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.r = bool1;
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.s = bool1;
    localImageInfo.t = paramParcel.readString();
    localImageInfo.u = paramParcel.readLong();
    localImageInfo.v = paramParcel.readString();
    localImageInfo.w = paramParcel.readLong();
    localImageInfo.x = paramParcel.readString();
    localImageInfo.z = paramParcel.readInt();
    localImageInfo.z = paramParcel.readInt();
    localImageInfo.B = paramParcel.readInt();
    localImageInfo.C = paramParcel.readString();
    localImageInfo.M = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localImageInfo.J = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localImageInfo.I = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    localImageInfo.R = bool1;
    localImageInfo.N = paramParcel.readLong();
    localImageInfo.O = paramParcel.readString();
    localImageInfo.P = paramParcel.readString();
    localImageInfo.Q = paramParcel.readString();
    localImageInfo.S = paramParcel.readInt();
    return localImageInfo;
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ImageInfo.1
 * JD-Core Version:    0.7.0.1
 */