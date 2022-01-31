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
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.formats = paramVarArgs;
      this.length = paramVarArgs.length;
      return;
    }
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
      paramObject = (TrackGroup)paramObject;
    } while ((this.length == paramObject.length) && (Arrays.equals(this.formats, paramObject.formats)));
    return false;
  }
  
  public Format getFormat(int paramInt)
  {
    return this.formats[paramInt];
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = (Arrays.hashCode(this.formats) + 527);
    }
    return this.hashCode;
  }
  
  public int indexOf(Format paramFormat)
  {
    int i = 0;
    while (i < this.formats.length)
    {
      if (paramFormat == this.formats[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.TrackGroup
 * JD-Core Version:    0.7.0.1
 */