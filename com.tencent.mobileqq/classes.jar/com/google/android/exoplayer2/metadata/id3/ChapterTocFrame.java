package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterTocFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new ChapterTocFrame.1();
  public static final String ID = "CTOC";
  public final String[] children;
  public final String elementId;
  public final boolean isOrdered;
  public final boolean isRoot;
  private final Id3Frame[] subFrames;
  
  ChapterTocFrame(Parcel paramParcel)
  {
    super("CTOC");
    this.elementId = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.isRoot = bool1;
      if (paramParcel.readByte() == 0) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isOrdered = bool1;
      this.children = paramParcel.createStringArray();
      int j = paramParcel.readInt();
      this.subFrames = new Id3Frame[j];
      while (i < j)
      {
        this.subFrames[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
        i += 1;
      }
      bool1 = false;
      break;
    }
  }
  
  public ChapterTocFrame(String paramString, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CTOC");
    this.elementId = paramString;
    this.isRoot = paramBoolean1;
    this.isOrdered = paramBoolean2;
    this.children = paramArrayOfString;
    this.subFrames = paramArrayOfId3Frame;
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
      paramObject = (ChapterTocFrame)paramObject;
    } while ((this.isRoot == paramObject.isRoot) && (this.isOrdered == paramObject.isOrdered) && (Util.areEqual(this.elementId, paramObject.elementId)) && (Arrays.equals(this.children, paramObject.children)) && (Arrays.equals(this.subFrames, paramObject.subFrames)));
    return false;
  }
  
  public Id3Frame getSubFrame(int paramInt)
  {
    return this.subFrames[paramInt];
  }
  
  public int getSubFrameCount()
  {
    return this.subFrames.length;
  }
  
  public int hashCode()
  {
    int j = 1;
    int k = 0;
    int i;
    if (this.isRoot)
    {
      i = 1;
      if (!this.isOrdered) {
        break label56;
      }
    }
    for (;;)
    {
      if (this.elementId != null) {
        k = this.elementId.hashCode();
      }
      return ((i + 527) * 31 + j) * 31 + k;
      i = 0;
      break;
      label56:
      j = 0;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.elementId);
    if (this.isRoot)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.isOrdered) {
        break label95;
      }
    }
    label95:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeStringArray(this.children);
      paramParcel.writeInt(this.subFrames.length);
      Id3Frame[] arrayOfId3Frame = this.subFrames;
      i = arrayOfId3Frame.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramParcel.writeParcelable(arrayOfId3Frame[paramInt], 0);
        paramInt += 1;
      }
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterTocFrame
 * JD-Core Version:    0.7.0.1
 */