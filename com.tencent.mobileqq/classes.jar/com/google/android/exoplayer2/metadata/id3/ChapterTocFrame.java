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
    int j = paramParcel.readByte();
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if (j != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.isRoot = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.isOrdered = bool1;
    this.children = paramParcel.createStringArray();
    j = paramParcel.readInt();
    this.subFrames = new Id3Frame[j];
    while (i < j)
    {
      this.subFrames[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ChapterTocFrame)paramObject;
      return (this.isRoot == paramObject.isRoot) && (this.isOrdered == paramObject.isOrdered) && (Util.areEqual(this.elementId, paramObject.elementId)) && (Arrays.equals(this.children, paramObject.children)) && (Arrays.equals(this.subFrames, paramObject.subFrames));
    }
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.elementId);
    paramParcel.writeByte((byte)this.isRoot);
    paramParcel.writeByte((byte)this.isOrdered);
    paramParcel.writeStringArray(this.children);
    paramParcel.writeInt(this.subFrames.length);
    Id3Frame[] arrayOfId3Frame = this.subFrames;
    int i = arrayOfId3Frame.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfId3Frame[paramInt], 0);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterTocFrame
 * JD-Core Version:    0.7.0.1
 */