package com.google.android.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class MappingTrackSelector
  extends TrackSelector
{
  private MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
  private final SparseBooleanArray rendererDisabledFlags = new SparseBooleanArray();
  private final SparseArray<Map<TrackGroupArray, MappingTrackSelector.SelectionOverride>> selectionOverrides = new SparseArray();
  private int tunnelingAudioSessionId = 0;
  
  private boolean[] determineEnabledRenderers(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackSelection[] paramArrayOfTrackSelection)
  {
    boolean[] arrayOfBoolean = new boolean[paramArrayOfTrackSelection.length];
    int i = 0;
    while (i < arrayOfBoolean.length)
    {
      int j;
      if ((!this.rendererDisabledFlags.get(i)) && ((paramArrayOfRendererCapabilities[i].getTrackType() == 5) || (paramArrayOfTrackSelection[i] != null))) {
        j = 1;
      } else {
        j = 0;
      }
      arrayOfBoolean[i] = j;
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  private static int findRenderer(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroup paramTrackGroup)
  {
    int j = paramArrayOfRendererCapabilities.length;
    int i = 0;
    int m;
    for (int k = 0; i < paramArrayOfRendererCapabilities.length; k = m)
    {
      RendererCapabilities localRendererCapabilities = paramArrayOfRendererCapabilities[i];
      m = j;
      int n = 0;
      j = k;
      k = m;
      m = n;
      while (m < paramTrackGroup.length)
      {
        int i1 = localRendererCapabilities.supportsFormat(paramTrackGroup.getFormat(m)) & 0x7;
        n = j;
        if (i1 > j)
        {
          if (i1 == 4) {
            return i;
          }
          k = i;
          n = i1;
        }
        m += 1;
        j = n;
      }
      i += 1;
      m = j;
      j = k;
    }
    return j;
  }
  
  private static int[] getFormatSupport(RendererCapabilities paramRendererCapabilities, TrackGroup paramTrackGroup)
  {
    int[] arrayOfInt = new int[paramTrackGroup.length];
    int i = 0;
    while (i < paramTrackGroup.length)
    {
      arrayOfInt[i] = paramRendererCapabilities.supportsFormat(paramTrackGroup.getFormat(i));
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] getMixedMimeTypeAdaptationSupport(RendererCapabilities[] paramArrayOfRendererCapabilities)
  {
    int[] arrayOfInt = new int[paramArrayOfRendererCapabilities.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = paramArrayOfRendererCapabilities[i].supportsMixedMimeTypeAdaptation();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static void maybeConfigureRenderersForTunneling(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray[] paramArrayOfTrackGroupArray, int[][][] paramArrayOfInt, RendererConfiguration[] paramArrayOfRendererConfiguration, TrackSelection[] paramArrayOfTrackSelection, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    int i1 = 0;
    int i = 0;
    int k = -1;
    int n;
    for (int j = -1; i < paramArrayOfRendererCapabilities.length; j = n)
    {
      int i2 = paramArrayOfRendererCapabilities[i].getTrackType();
      TrackSelection localTrackSelection = paramArrayOfTrackSelection[i];
      if (i2 != 1)
      {
        m = k;
        n = j;
        if (i2 != 2) {}
      }
      else
      {
        m = k;
        n = j;
        if (localTrackSelection != null)
        {
          m = k;
          n = j;
          if (rendererSupportsTunneling(paramArrayOfInt[i], paramArrayOfTrackGroupArray[i], localTrackSelection))
          {
            if (i2 == 1)
            {
              if (j == -1)
              {
                n = i;
                m = k;
                break label146;
              }
            }
            else {
              if (k == -1) {
                break label138;
              }
            }
            i = 0;
            break label166;
            label138:
            m = i;
            n = j;
          }
        }
      }
      label146:
      i += 1;
      k = m;
    }
    i = 1;
    label166:
    int m = i1;
    if (j != -1)
    {
      m = i1;
      if (k != -1) {
        m = 1;
      }
    }
    if ((i & m) != 0)
    {
      paramArrayOfRendererCapabilities = new RendererConfiguration(paramInt);
      paramArrayOfRendererConfiguration[j] = paramArrayOfRendererCapabilities;
      paramArrayOfRendererConfiguration[k] = paramArrayOfRendererCapabilities;
    }
  }
  
  private static boolean rendererSupportsTunneling(int[][] paramArrayOfInt, TrackGroupArray paramTrackGroupArray, TrackSelection paramTrackSelection)
  {
    if (paramTrackSelection == null) {
      return false;
    }
    int j = paramTrackGroupArray.indexOf(paramTrackSelection.getTrackGroup());
    int i = 0;
    while (i < paramTrackSelection.length())
    {
      if ((paramArrayOfInt[j][paramTrackSelection.getIndexInTrackGroup(i)] & 0x20) != 32) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final void clearSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    if (localMap != null)
    {
      if (!localMap.containsKey(paramTrackGroupArray)) {
        return;
      }
      localMap.remove(paramTrackGroupArray);
      if (localMap.isEmpty()) {
        this.selectionOverrides.remove(paramInt);
      }
      invalidate();
    }
  }
  
  public final void clearSelectionOverrides()
  {
    if (this.selectionOverrides.size() == 0) {
      return;
    }
    this.selectionOverrides.clear();
    invalidate();
  }
  
  public final void clearSelectionOverrides(int paramInt)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return;
      }
      this.selectionOverrides.remove(paramInt);
      invalidate();
    }
  }
  
  public final MappingTrackSelector.MappedTrackInfo getCurrentMappedTrackInfo()
  {
    return this.currentMappedTrackInfo;
  }
  
  public final boolean getRendererDisabled(int paramInt)
  {
    return this.rendererDisabledFlags.get(paramInt);
  }
  
  public final MappingTrackSelector.SelectionOverride getSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    if (localMap != null) {
      return (MappingTrackSelector.SelectionOverride)localMap.get(paramTrackGroupArray);
    }
    return null;
  }
  
  public final boolean hasSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    return (localMap != null) && (localMap.containsKey(paramTrackGroupArray));
  }
  
  public final void onSelectionActivated(Object paramObject)
  {
    this.currentMappedTrackInfo = ((MappingTrackSelector.MappedTrackInfo)paramObject);
  }
  
  public final TrackSelectorResult selectTracks(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray paramTrackGroupArray)
  {
    Object localObject4 = new int[paramArrayOfRendererCapabilities.length + 1];
    Object localObject6 = new TrackGroup[paramArrayOfRendererCapabilities.length + 1][];
    int[][][] arrayOfInt = new int[paramArrayOfRendererCapabilities.length + 1][][];
    int j = 0;
    int i = 0;
    while (i < localObject6.length)
    {
      localObject6[i] = new TrackGroup[paramTrackGroupArray.length];
      arrayOfInt[i] = new int[paramTrackGroupArray.length][];
      i += 1;
    }
    Object localObject3 = getMixedMimeTypeAdaptationSupport(paramArrayOfRendererCapabilities);
    i = 0;
    int k;
    Object localObject1;
    while (i < paramTrackGroupArray.length)
    {
      localObject2 = paramTrackGroupArray.get(i);
      k = findRenderer(paramArrayOfRendererCapabilities, (TrackGroup)localObject2);
      if (k == paramArrayOfRendererCapabilities.length) {
        localObject1 = new int[((TrackGroup)localObject2).length];
      } else {
        localObject1 = getFormatSupport(paramArrayOfRendererCapabilities[k], (TrackGroup)localObject2);
      }
      int m = localObject4[k];
      localObject6[k][m] = localObject2;
      arrayOfInt[k][m] = localObject1;
      localObject4[k] += 1;
      i += 1;
    }
    Object localObject2 = new TrackGroupArray[paramArrayOfRendererCapabilities.length];
    Object localObject5 = new int[paramArrayOfRendererCapabilities.length];
    i = 0;
    while (i < paramArrayOfRendererCapabilities.length)
    {
      k = localObject4[i];
      localObject2[i] = new TrackGroupArray((TrackGroup[])Arrays.copyOf(localObject6[i], k));
      arrayOfInt[i] = ((int[][])Arrays.copyOf(arrayOfInt[i], k));
      localObject5[i] = paramArrayOfRendererCapabilities[i].getTrackType();
      i += 1;
    }
    i = localObject4[paramArrayOfRendererCapabilities.length];
    localObject6 = new TrackGroupArray((TrackGroup[])Arrays.copyOf(localObject6[paramArrayOfRendererCapabilities.length], i));
    localObject4 = selectTracks(paramArrayOfRendererCapabilities, (TrackGroupArray[])localObject2, arrayOfInt);
    i = 0;
    for (;;)
    {
      k = paramArrayOfRendererCapabilities.length;
      localObject1 = null;
      if (i >= k) {
        break;
      }
      if (this.rendererDisabledFlags.get(i))
      {
        localObject4[i] = null;
      }
      else
      {
        localObject7 = localObject2[i];
        if (hasSelectionOverride(i, (TrackGroupArray)localObject7))
        {
          MappingTrackSelector.SelectionOverride localSelectionOverride = (MappingTrackSelector.SelectionOverride)((Map)this.selectionOverrides.get(i)).get(localObject7);
          if (localSelectionOverride != null) {
            localObject1 = localSelectionOverride.createTrackSelection((TrackGroupArray)localObject7);
          }
          localObject4[i] = localObject1;
        }
      }
      i += 1;
    }
    Object localObject7 = determineEnabledRenderers(paramArrayOfRendererCapabilities, (TrackSelection[])localObject4);
    localObject3 = new MappingTrackSelector.MappedTrackInfo((int[])localObject5, (TrackGroupArray[])localObject2, (int[])localObject3, arrayOfInt, (TrackGroupArray)localObject6);
    localObject5 = new RendererConfiguration[paramArrayOfRendererCapabilities.length];
    i = j;
    while (i < paramArrayOfRendererCapabilities.length)
    {
      if (localObject7[i] != 0) {
        localObject1 = RendererConfiguration.DEFAULT;
      } else {
        localObject1 = null;
      }
      localObject5[i] = localObject1;
      i += 1;
    }
    maybeConfigureRenderersForTunneling(paramArrayOfRendererCapabilities, (TrackGroupArray[])localObject2, arrayOfInt, (RendererConfiguration[])localObject5, (TrackSelection[])localObject4, this.tunnelingAudioSessionId);
    return new TrackSelectorResult(paramTrackGroupArray, (boolean[])localObject7, new TrackSelectionArray((TrackSelection[])localObject4), localObject3, (RendererConfiguration[])localObject5);
  }
  
  protected abstract TrackSelection[] selectTracks(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray[] paramArrayOfTrackGroupArray, int[][][] paramArrayOfInt);
  
  public final void setRendererDisabled(int paramInt, boolean paramBoolean)
  {
    if (this.rendererDisabledFlags.get(paramInt) == paramBoolean) {
      return;
    }
    this.rendererDisabledFlags.put(paramInt, paramBoolean);
    invalidate();
  }
  
  public final void setSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray, MappingTrackSelector.SelectionOverride paramSelectionOverride)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.selectionOverrides.put(paramInt, localObject);
    }
    if ((((Map)localObject).containsKey(paramTrackGroupArray)) && (Util.areEqual(((Map)localObject).get(paramTrackGroupArray), paramSelectionOverride))) {
      return;
    }
    ((Map)localObject).put(paramTrackGroupArray, paramSelectionOverride);
    invalidate();
  }
  
  public void setTunnelingAudioSessionId(int paramInt)
  {
    if (this.tunnelingAudioSessionId != paramInt)
    {
      this.tunnelingAudioSessionId = paramInt;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.MappingTrackSelector
 * JD-Core Version:    0.7.0.1
 */