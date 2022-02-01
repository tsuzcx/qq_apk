package com.tencent.device.datadef;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ProductNetLinkInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ProductNetLinkInfo> CREATOR = new ProductNetLinkInfo.1();
  public String linkResetVoiceDesc;
  public int productId;
  public String stopSoundWaveDesc1;
  public String stopSoundWaveDesc2;
  public String volumeUpContentDesc;
  public String volumeUpDescImg;
  public String volumeUpTitleDesc;
  public String volumeUpVoiceDesc;
  
  public ProductNetLinkInfo() {}
  
  public ProductNetLinkInfo(int paramInt)
  {
    this.productId = paramInt;
  }
  
  protected ProductNetLinkInfo(Parcel paramParcel)
  {
    this.productId = paramParcel.readInt();
    this.linkResetVoiceDesc = paramParcel.readString();
    this.volumeUpTitleDesc = paramParcel.readString();
    this.volumeUpContentDesc = paramParcel.readString();
    this.volumeUpDescImg = paramParcel.readString();
    this.volumeUpVoiceDesc = paramParcel.readString();
    this.stopSoundWaveDesc1 = paramParcel.readString();
    this.stopSoundWaveDesc2 = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.productId);
    paramParcel.writeSerializable(this.linkResetVoiceDesc);
    paramParcel.writeString(this.volumeUpTitleDesc);
    paramParcel.writeString(this.volumeUpContentDesc);
    paramParcel.writeSerializable(this.volumeUpDescImg);
    paramParcel.writeSerializable(this.volumeUpVoiceDesc);
    paramParcel.writeString(this.stopSoundWaveDesc1);
    paramParcel.writeString(this.stopSoundWaveDesc2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.datadef.ProductNetLinkInfo
 * JD-Core Version:    0.7.0.1
 */