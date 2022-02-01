package com.tencent.luggage.setting.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class WxaSettingActivity$a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new WxaSettingActivity.a.1();
  public boolean a;
  public boolean b;
  
  public WxaSettingActivity$a()
  {
    this.a = false;
    this.b = false;
  }
  
  protected WxaSettingActivity$a(Parcel paramParcel)
  {
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.b = bool1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte((byte)this.a);
    paramParcel.writeByte((byte)this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.a
 * JD-Core Version:    0.7.0.1
 */