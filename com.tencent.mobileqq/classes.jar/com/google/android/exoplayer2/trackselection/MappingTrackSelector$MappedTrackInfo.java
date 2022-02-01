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
    int m = this.trackGroups[paramInt1].get(paramInt2).length;
    int[] arrayOfInt = new int[m];
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = getTrackFormatSupport(paramInt1, paramInt2, i);
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
    }
    return getAdaptiveSupport(paramInt1, paramInt2, Arrays.copyOf(arrayOfInt, j));
  }
  
  public int getAdaptiveSupport(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int k = 0;
    Object localObject = null;
    boolean bool = false;
    int j = 0;
    int i = 16;
    while (k < paramArrayOfInt.length)
    {
      int m = paramArrayOfInt[k];
      String str = this.trackGroups[paramInt1].get(paramInt2).getFormat(m).sampleMimeType;
      if (j == 0) {
        localObject = str;
      } else {
        bool |= Util.areEqual(localObject, str) ^ true;
      }
      i = Math.min(i, this.formatSupport[paramInt1][paramInt2][k] & 0x18);
      k += 1;
      j += 1;
    }
    paramInt2 = i;
    if (bool) {
      paramInt2 = Math.min(i, this.mixedMimeTypeAdaptiveSupport[paramInt1]);
    }
    return paramInt2;
  }
  
  public int getRendererSupport(int paramInt)
  {
    int[][] arrayOfInt = this.formatSupport[paramInt];
    int i = 0;
    paramInt = 0;
    while (i < arrayOfInt.length)
    {
      int j = 0;
      while (j < arrayOfInt[i].length)
      {
        int k = arrayOfInt[i][j] & 0x7;
        if (k != 3)
        {
          if (k != 4) {
            k = 1;
          } else {
            return 3;
          }
        }
        else {
          k = 2;
        }
        paramInt = Math.max(paramInt, k);
        j += 1;
      }
      i += 1;
    }
    return paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo
 * JD-Core Version:    0.7.0.1
 */