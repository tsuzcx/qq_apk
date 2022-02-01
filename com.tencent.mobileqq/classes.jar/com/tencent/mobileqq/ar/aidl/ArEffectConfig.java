package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import java.util.ArrayList;

public class ArEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<ArEffectConfig> CREATOR = new ArEffectConfig.1();
  public int a;
  public ArrayList<String> b = new ArrayList();
  public ArrayList<String> c = new ArrayList();
  public ArrayList<String> d = new ArrayList();
  public ArrayList<String> e = new ArrayList();
  public int f = 80;
  public int g = 80;
  public int h = 80;
  public int i = 30;
  public int j = 30;
  public int k = 30;
  public int l = 30;
  public ArrayList<ArDefaultSetting> m = new ArrayList();
  
  public ArEffectConfig() {}
  
  public ArEffectConfig(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    paramParcel.readList(this.b, String.class.getClassLoader());
    paramParcel.readList(this.c, String.class.getClassLoader());
    paramParcel.readList(this.d, String.class.getClassLoader());
    paramParcel.readList(this.e, String.class.getClassLoader());
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    paramParcel.readList(this.m, ArDefaultSetting.class.getClassLoader());
  }
  
  public static ArEffectConfig a()
  {
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArEffectConfig{");
    localStringBuffer.append("version=");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", toplevelModel=");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", toplevelGPU=");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", blacklistModel=");
    localStringBuffer.append(this.d);
    localStringBuffer.append(", blacklistGPU=");
    localStringBuffer.append(this.e);
    localStringBuffer.append(", topModelStandard=");
    localStringBuffer.append(this.f);
    localStringBuffer.append(", removeShadowLevel=");
    localStringBuffer.append(this.g);
    localStringBuffer.append(", adjustBone=");
    localStringBuffer.append(this.h);
    localStringBuffer.append(", traceQuality2=");
    localStringBuffer.append(this.i);
    localStringBuffer.append(", traceQuality3=");
    localStringBuffer.append(this.j);
    localStringBuffer.append(", traceQuality4=");
    localStringBuffer.append(this.k);
    localStringBuffer.append(", traceQuality5=");
    localStringBuffer.append(this.l);
    localStringBuffer.append(", defaultSettings=");
    localStringBuffer.append(this.m);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeList(this.b);
    paramParcel.writeList(this.c);
    paramParcel.writeList(this.d);
    paramParcel.writeList(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeList(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArEffectConfig
 * JD-Core Version:    0.7.0.1
 */