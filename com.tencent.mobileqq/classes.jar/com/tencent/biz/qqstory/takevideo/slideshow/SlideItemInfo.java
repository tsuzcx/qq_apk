package com.tencent.biz.qqstory.takevideo.slideshow;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import java.net.URL;

public class SlideItemInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SlideItemInfo> CREATOR = new SlideItemInfo.1();
  public LocalMediaInfo a;
  public StoryAlbum b;
  public int c = -1;
  public String d;
  public int e;
  public String f;
  public URL g;
  public long h;
  public long i = 0L;
  public long j = 0L;
  public String k;
  public String l;
  public boolean m;
  public int n;
  public int o;
  public int p;
  public int q;
  public String r = "LinearBlur";
  public boolean s;
  public boolean t;
  
  protected SlideItemInfo(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.s = false;
    this.t = false;
    this.a = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.m = bool1;
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.r = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.s = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.t = bool1;
  }
  
  public SlideItemInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    this.s = false;
    this.t = false;
    try
    {
      this.a = paramLocalMediaInfo;
      this.f = paramLocalMediaInfo.path;
      this.e = QAlbumUtil.getMediaType(paramLocalMediaInfo);
      if (!TextUtils.isEmpty(paramLocalMediaInfo.mTransId)) {
        this.r = paramLocalMediaInfo.mTransId;
      }
      if (!TextUtils.isEmpty(paramLocalMediaInfo.mTextStr)) {
        this.d = paramLocalMediaInfo.mTextStr;
      }
      this.c = paramLocalMediaInfo.mTextId;
      int i1 = this.e;
      if (i1 != 0)
      {
        if (i1 != 1) {
          return;
        }
        if (paramLocalMediaInfo.isSystemMeidaStore == true) {
          this.g = QAlbumUtil.generateAlbumThumbURL(paramLocalMediaInfo, "VIDEO");
        } else {
          this.g = QAlbumUtil.generateAlbumThumbURL(paramLocalMediaInfo, "APP_VIDEO");
        }
        this.h = paramLocalMediaInfo.mDuration;
        if (this.j == 0L) {
          this.j = this.h;
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(paramLocalMediaInfo.path);
        this.g = QAlbumUtil.generateAlbumThumbURL(paramLocalMediaInfo);
        this.h = 2000L;
        this.j = this.h;
        return;
      }
    }
    catch (Exception paramLocalMediaInfo)
    {
      paramLocalMediaInfo.printStackTrace();
    }
  }
  
  public long a()
  {
    if (this.i <= 0L) {
      this.i = 0L;
    }
    long l1 = this.j;
    if ((l1 <= 0L) || (l1 >= this.h)) {
      this.j = this.h;
    }
    l1 = this.j;
    long l2 = this.i;
    if (l1 <= l2) {
      return this.h;
    }
    return l1 - l2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SlideItemInfo))
    {
      paramObject = (SlideItemInfo)paramObject;
      return TextUtils.equals(this.f, paramObject.f);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeLong(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeByte((byte)this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeByte((byte)this.s);
    paramParcel.writeByte((byte)this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo
 * JD-Core Version:    0.7.0.1
 */