package com.tencent.device.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LightAppSettingInfo$1
  implements Parcelable.Creator<LightAppSettingInfo>
{
  public LightAppSettingInfo a(Parcel paramParcel)
  {
    LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
    localLightAppSettingInfo.a = paramParcel.readInt();
    localLightAppSettingInfo.b = paramParcel.readInt();
    localLightAppSettingInfo.c = paramParcel.readInt();
    localLightAppSettingInfo.d = paramParcel.readLong();
    localLightAppSettingInfo.e = paramParcel.readArrayList(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.f = paramParcel.readString();
    localLightAppSettingInfo.g = paramParcel.readString();
    localLightAppSettingInfo.h = paramParcel.readInt();
    localLightAppSettingInfo.i = paramParcel.readString();
    localLightAppSettingInfo.j = paramParcel.readString();
    localLightAppSettingInfo.k = paramParcel.readString();
    localLightAppSettingInfo.l = paramParcel.readString();
    localLightAppSettingInfo.m = paramParcel.readString();
    localLightAppSettingInfo.n = paramParcel.readInt();
    localLightAppSettingInfo.o = paramParcel.readHashMap(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.p = paramParcel.readString();
    return localLightAppSettingInfo;
  }
  
  public LightAppSettingInfo[] a(int paramInt)
  {
    return new LightAppSettingInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.utils.LightAppSettingInfo.1
 * JD-Core Version:    0.7.0.1
 */