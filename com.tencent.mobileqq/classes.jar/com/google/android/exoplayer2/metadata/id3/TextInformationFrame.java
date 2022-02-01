package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;

public final class TextInformationFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<TextInformationFrame> CREATOR = new TextInformationFrame.1();
  public final String description;
  public final String value;
  
  TextInformationFrame(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.description = paramParcel.readString();
    this.value = paramParcel.readString();
  }
  
  public TextInformationFrame(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.description = paramString2;
    this.value = paramString3;
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
      paramObject = (TextInformationFrame)paramObject;
      return (this.id.equals(paramObject.id)) && (Util.areEqual(this.description, paramObject.description)) && (Util.areEqual(this.value, paramObject.value));
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
    str = this.value;
    if (str != null) {
      j = str.hashCode();
    }
    return ((527 + k) * 31 + i) * 31 + j;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.TextInformationFrame
 * JD-Core Version:    0.7.0.1
 */