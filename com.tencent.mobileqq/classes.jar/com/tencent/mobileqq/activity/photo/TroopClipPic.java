package com.tencent.mobileqq.activity.photo;

import akgp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class TroopClipPic
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<TroopClipPic> CREATOR = new akgp();
  public String clipInfo;
  public String id;
  public long ts;
  public int type = 0;
  
  public TroopClipPic() {}
  
  public TroopClipPic(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.clipInfo = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.ts = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(this.id).append(" type=").append(this.type).append(" clip=").append(this.clipInfo);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.clipInfo);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.ts);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopClipPic
 * JD-Core Version:    0.7.0.1
 */