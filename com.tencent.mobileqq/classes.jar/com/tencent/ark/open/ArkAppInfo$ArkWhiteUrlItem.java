package com.tencent.ark.open;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArkAppInfo$ArkWhiteUrlItem
  implements Parcelable
{
  public static final Parcelable.Creator<ArkWhiteUrlItem> CREATOR = new ArkAppInfo.ArkWhiteUrlItem.1();
  public String ruleDomain;
  public String rulePath;
  
  public ArkAppInfo$ArkWhiteUrlItem() {}
  
  protected ArkAppInfo$ArkWhiteUrlItem(Parcel paramParcel)
  {
    this.ruleDomain = paramParcel.readString();
    this.rulePath = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return this.ruleDomain + this.rulePath;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ruleDomain);
    paramParcel.writeString(this.rulePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppInfo.ArkWhiteUrlItem
 * JD-Core Version:    0.7.0.1
 */