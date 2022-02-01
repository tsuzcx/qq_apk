package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class MappingTrackSelector$MappedTrackInfo
{
  public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
  public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
  public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
  public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
  private final int[][][] formatSupport;
  public final int length;
  private final int[] mixedMimeTypeAdaptiveSupport;
  private final int[] rendererTrackTypes;
  private final TrackGroupArray[] trackGroups;
  private final TrackGroupArray unassociatedTrackGroups;
  
  MappingTrackSelector$MappedTrackInfo(int[] paramArrayOfInt1, TrackGroupArray[] paramArrayOfTrackGroupArray, int[] paramArrayOfInt2, int[][][] paramArrayOfInt, TrackGroupArray paramTrackGroupArray)
  {
    this.rendererTrackTypes = paramArrayOfInt1;
    this.trackGroups = paramArrayOfTrackGroupArray;
    this.formatSupport = paramArrayOfInt;
    this.mixedMimeTypeAdaptiveSupport = paramArrayOfInt2;
    this.unassociatedTrackGroups = paramTrackGroupArray;
    this.length = paramArrayOfTrackGroupArray.length;
  }
  
  public int getAdaptiveSupport(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    int m = this.trackGroups[paramInt1].get(paramInt2).length;
    int[] arrayOfInt = new int[m];
    int i = 0;
    while (i < m)
    {
      int n = getTrackFormatSupport(paramInt1, paramInt2, i);
      int k;
      if (n != 4)
      {
        k = j;
        if (paramBoolean)
        {
          k = j;
          if (n != 3) {}
        }
      }
      else
      {
        arrayOfInt[j] = i;
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return getAdaptiveSupport(paramInt1, paramInt2, Arrays.copyOf(arrayOfInt, j));
  }
  
  public int getAdaptiveSupport(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Object localObject = null;
    int m = 0;
    int j = 0;
    int i = 16;
    int k = 0;
    while (m < paramArrayOfInt.length)
    {
      int n = paramArrayOfInt[m];
      String str = this.trackGroups[paramInt1].get(paramInt2).getFormat(n).sampleMimeType;
      if (k == 0)
      {
        localObject = str;
        i = Math.min(i, this.formatSupport[paramInt1][paramInt2][m] & 0x18);
        m += 1;
        k += 1;
      }
      else
      {
        if (!Util.areEqual(localObject, str)) {}
        for (n = 1;; n = 0)
        {
          j = n | j;
          break;
        }
      }
    }
    paramInt2 = i;
    if (j != 0) {
      paramInt2 = Math.min(i, this.mixedMimeTypeAdaptiveSupport[paramInt1]);
    }
    return paramInt2;
  }
  
  public int getRendererSupport(int paramInt)
  {
    int[][] arrayOfInt = this.formatSupport[paramInt];
    int i = 0;
    paramInt = 0;
    for (;;)
    {
      int j = paramInt;
      if (i < arrayOfInt.length)
      {
        j = 0;
        if (j >= arrayOfInt[i].length) {
          break label91;
        }
        switch (arrayOfInt[i][j] & 0x7)
        {
        }
      }
      for (int k = 1;; k = 2)
      {
        paramInt = Math.max(paramInt, k);
        j += 1;
        break;
        j = 3;
        return j;
      }
      label91:
      i += 1;
    }
  }
  
  public int getTrackFormatSupport(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.formatSupport[paramInt1][paramInt2][paramInt3] & 0x7;
  }
  
  public TrackGroupArray getTrackGroups(int paramInt)
  {
    return this.trackGroups[paramInt];
  }
  
  public int getTrackTypeRendererSupport(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.length; j = k)
    {
      k = j;
      if (this.rendererTrackTypes[i] == paramInt) {
        k = Math.max(j, getRendererSupport(i));
      }
      i += 1;
    }
    return j;
  }
  
  public TrackGroupArray getUnassociatedTrackGroups()
  {
    return this.unassociatedTrackGroups;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo
 * JD-Core Version:    0.7.0.1
 */