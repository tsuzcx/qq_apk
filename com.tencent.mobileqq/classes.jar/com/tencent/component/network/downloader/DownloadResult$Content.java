package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class DownloadResult$Content
  implements Parcelable
{
  public static final Parcelable.Creator<Content> CREATOR = new DownloadResult.Content.1();
  public String clientip;
  public Object content;
  public String encoding;
  public boolean isGzip;
  public String lastModified;
  public long length;
  public String md5;
  public boolean noCache;
  public long realsize;
  public String redirectUrl;
  public int retCode;
  public long size;
  public String type;
  
  DownloadResult$Content() {}
  
  public DownloadResult$Content(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.type = paramParcel.readString();
    this.encoding = paramParcel.readString();
    this.length = paramParcel.readLong();
    this.size = paramParcel.readLong();
    this.realsize = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.noCache = bool;
      this.clientip = paramParcel.readString();
      this.lastModified = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void reset()
  {
    this.type = null;
    this.encoding = null;
    this.length = 0L;
    this.size = 0L;
    this.realsize = -1L;
    this.noCache = false;
    this.content = null;
    this.clientip = null;
    this.lastModified = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.encoding);
    paramParcel.writeLong(this.length);
    paramParcel.writeLong(this.size);
    paramParcel.writeLong(this.realsize);
    if (this.noCache) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.clientip);
      paramParcel.writeString(this.lastModified);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult.Content
 * JD-Core Version:    0.7.0.1
 */