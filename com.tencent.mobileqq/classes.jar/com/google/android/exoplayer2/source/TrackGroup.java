package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class TrackGroup
{
  private final Format[] formats;
  private int hashCode;
  public final int length;
  
  public TrackGroup(Format... paramVarArgs)
  {
    boolean bool;
    if (paramVarArgs.length > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.formats = paramVarArgs;
    this.length = paramVarArgs.length;
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
      paramObject = (TrackGroup)paramObject;
      return (this.length == paramObject.length) && (Arrays.equals(this.formats, paramObject.formats));
    }
    return false;
  }
  
  public Format getFormat(int paramInt)
  {
    return this.formats[paramInt];
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = (527 + Arrays.hashCode(this.formats));
    }
    return this.hashCode;
  }
  
  public int indexOf(Format paramFormat)
  {
    int i = 0;
    for (;;)
    {
      Format[] arrayOfFormat = this.formats;
      if (i >= arrayOfFormat.length) {
        break;
      }
      if (paramFormat == arrayOfFormat[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.TrackGroup
 * JD-Core Version:    0.7.0.1
 */