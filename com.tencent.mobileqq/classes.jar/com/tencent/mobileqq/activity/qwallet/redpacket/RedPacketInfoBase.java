package com.tencent.mobileqq.activity.qwallet.redpacket;

import ahde;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class RedPacketInfoBase
  implements Parcelable
{
  public static final Parcelable.Creator<RedPacketInfoBase> CREATOR = new ahde();
  public static final String ICON_DEF = "icon_def";
  public static final String ICON_DRAW = "icon_draw";
  public static final String ICON_EMOJI = "icon_emoji";
  public static final String ICON_KSONG = "icon_ksong";
  public static final String ICON_SP = "icon_sp";
  public static final String ICON_TXT = "icon_txt";
  public static final String ICON_VIDEO = "icon_video";
  public static final String ICON_VOICE = "icon_voice";
  public AnimationView.AnimationInfo animInfo;
  public Bundle attribute = new Bundle();
  public String background;
  public int bigAnimId;
  public int channel = -1;
  public Bitmap corner;
  public Bitmap icon;
  public boolean isCache;
  public int isHideTitle;
  public String resPath;
  public int skinId;
  public int skinType;
  public AnimationView.AnimationInfo specailBackgroundAnimInfo;
  public Bitmap specialBackground;
  public String templateId;
  public String title;
  public int type;
  
  public RedPacketInfoBase() {}
  
  public RedPacketInfoBase(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.skinType = paramParcel.readInt();
    this.skinId = paramParcel.readInt();
    this.channel = paramParcel.readInt();
    this.bigAnimId = paramParcel.readInt();
    this.templateId = paramParcel.readString();
    this.corner = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.icon = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.specialBackground = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.title = paramParcel.readString();
    this.isHideTitle = paramParcel.readInt();
    this.resPath = paramParcel.readString();
    this.attribute = paramParcel.readBundle();
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isCache = bool;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.skinType);
    paramParcel.writeInt(this.skinId);
    paramParcel.writeInt(this.channel);
    paramParcel.writeInt(this.bigAnimId);
    paramParcel.writeString(this.templateId);
    paramParcel.writeParcelable(this.corner, paramInt);
    paramParcel.writeParcelable(this.icon, paramInt);
    paramParcel.writeParcelable(this.specialBackground, paramInt);
    paramParcel.writeString(this.title);
    paramParcel.writeInt(this.isHideTitle);
    paramParcel.writeString(this.resPath);
    paramParcel.writeBundle(this.attribute);
    if (this.isCache) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase
 * JD-Core Version:    0.7.0.1
 */