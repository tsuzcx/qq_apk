package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;

public final class ParcelableMMKV
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new ParcelableMMKV.1();
  private final String a;
  private int b = -1;
  private int c = -1;
  private String d = null;
  
  public ParcelableMMKV(MMKV paramMMKV)
  {
    this.a = paramMMKV.mmapID();
    this.b = paramMMKV.ashmemFD();
    this.c = paramMMKV.ashmemMetaFD();
    this.d = paramMMKV.cryptKey();
  }
  
  private ParcelableMMKV(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString2;
  }
  
  public MMKV a()
  {
    int i = this.b;
    if (i >= 0)
    {
      int j = this.c;
      if (j >= 0) {
        return MMKV.a(this.a, i, j, this.d);
      }
    }
    return null;
  }
  
  public int describeContents()
  {
    return 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(this.a);
      ParcelFileDescriptor localParcelFileDescriptor1 = ParcelFileDescriptor.fromFd(this.b);
      ParcelFileDescriptor localParcelFileDescriptor2 = ParcelFileDescriptor.fromFd(this.c);
      paramInt |= 0x1;
      localParcelFileDescriptor1.writeToParcel(paramParcel, paramInt);
      localParcelFileDescriptor2.writeToParcel(paramParcel, paramInt);
      if (this.d != null)
      {
        paramParcel.writeString(this.d);
        return;
      }
    }
    catch (IOException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mmkv.ParcelableMMKV
 * JD-Core Version:    0.7.0.1
 */