package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;

public final class UrlLinkFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new UrlLinkFrame.1();
  public final String description;
  public final String url;
  
  UrlLinkFrame(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.description = paramParcel.readString();
    this.url = paramParcel.readString();
  }
  
  public UrlLinkFrame(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.description = paramString2;
    this.url = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (UrlLinkFrame)paramObject;
      return (this.id.equals(paramObject.id)) && (Util.areEqual(this.description, paramObject.description)) && (Util.areEqual(this.url, paramObject.url));
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = this.id.hashCode();
    String str = this.description;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.url;
    if (str != null) {
      j = str.hashCode();
    }
    return ((527 + k) * 31 + i) * 31 + j;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.UrlLinkFrame
 * JD-Core Version:    0.7.0.1
 */