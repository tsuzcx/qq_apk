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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TextInformationFrame)paramObject;
    } while ((this.id.equals(paramObject.id)) && (Util.areEqual(this.description, paramObject.description)) && (Util.areEqual(this.value, paramObject.value)));
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.id.hashCode();
    if (this.description != null) {}
    for (int i = this.description.hashCode();; i = 0)
    {
      if (this.value != null) {
        j = this.value.hashCode();
      }
      return (i + (k + 527) * 31) * 31 + j;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.TextInformationFrame
 * JD-Core Version:    0.7.0.1
 */