package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;

public final class CommentFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<CommentFrame> CREATOR = new CommentFrame.1();
  public static final String ID = "COMM";
  public final String description;
  public final String language;
  public final String text;
  
  CommentFrame(Parcel paramParcel)
  {
    super("COMM");
    this.language = paramParcel.readString();
    this.description = paramParcel.readString();
    this.text = paramParcel.readString();
  }
  
  public CommentFrame(String paramString1, String paramString2, String paramString3)
  {
    super("COMM");
    this.language = paramString1;
    this.description = paramString2;
    this.text = paramString3;
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
      paramObject = (CommentFrame)paramObject;
      return (Util.areEqual(this.description, paramObject.description)) && (Util.areEqual(this.language, paramObject.language)) && (Util.areEqual(this.text, paramObject.text));
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.language;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.description;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.text;
    if (str != null) {
      k = str.hashCode();
    }
    return ((527 + i) * 31 + j) * 31 + k;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.language);
    paramParcel.writeString(this.text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.CommentFrame
 * JD-Core Version:    0.7.0.1
 */