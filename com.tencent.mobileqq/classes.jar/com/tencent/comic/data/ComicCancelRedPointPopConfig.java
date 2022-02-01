package com.tencent.comic.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComicCancelRedPointPopConfig
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ComicCancelRedPointPopConfig> CREATOR = new ComicCancelRedPointPopConfig.1();
  public static final int SWITCH_OFF = 0;
  public static final int SWITCH_ON = 1;
  public int dayCount = 1;
  public int enableLocalCache = 1;
  public int ignoreInteractiveControll = 0;
  public int ignoreRedDot = 0;
  public List<ComicCancelRedPointPopItemData> list = new ArrayList();
  public int popSwitch = 0;
  
  public ComicCancelRedPointPopConfig() {}
  
  public ComicCancelRedPointPopConfig(Parcel paramParcel)
  {
    this.popSwitch = paramParcel.readInt();
    this.list = paramParcel.createTypedArrayList(ComicCancelRedPointPopItemData.CREATOR);
    this.enableLocalCache = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.popSwitch);
    paramParcel.writeTypedList(this.list);
    paramParcel.writeInt(this.enableLocalCache);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.data.ComicCancelRedPointPopConfig
 * JD-Core Version:    0.7.0.1
 */