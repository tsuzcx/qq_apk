package com.google.android.exoplayer2.trackselection;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector
  extends MappingTrackSelector
{
  private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98F;
  private static final int[] NO_TRACKS = new int[0];
  private static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
  private final TrackSelection.Factory adaptiveTrackSelectionFactory;
  private final AtomicReference<DefaultTrackSelector.Parameters> paramsReference;
  
  public DefaultTrackSelector()
  {
    this((TrackSelection.Factory)null);
  }
  
  public DefaultTrackSelector(TrackSelection.Factory paramFactory)
  {
    this.adaptiveTrackSelectionFactory = paramFactory;
    this.paramsReference = new AtomicReference(DefaultTrackSelector.Parameters.DEFAULT);
  }
  
  public DefaultTrackSelector(BandwidthMeter paramBandwidthMeter)
  {
    this(new AdaptiveTrackSelection.Factory(paramBandwidthMeter));
  }
  
  private static int compareFormatValues(int paramInt1, int paramInt2)
  {
    int i = -1;
    if (paramInt1 == -1)
    {
      paramInt1 = i;
      if (paramInt2 == -1) {
        return 0;
      }
    }
    else
    {
      if (paramInt2 == -1) {
        return 1;
      }
      paramInt1 -= paramInt2;
    }
    return paramInt1;
  }
  
  private static int compareInts(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt2 > paramInt1) {
      return -1;
    }
    return 0;
  }
  
  private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (!isSupportedAdaptiveVideoTrack(paramTrackGroup.getFormat(j), paramString, paramArrayOfInt[j], paramInt1, paramInt2, paramInt3, paramInt4)) {
        paramList.remove(i);
      }
      i -= 1;
    }
  }
  
  protected static boolean formatHasLanguage(Format paramFormat, String paramString)
  {
    return (paramString != null) && (TextUtils.equals(paramString, Util.normalizeLanguageCode(paramFormat.language)));
  }
  
  protected static boolean formatHasNoLanguage(Format paramFormat)
  {
    return (TextUtils.isEmpty(paramFormat.language)) || (formatHasLanguage(paramFormat, "und"));
  }
  
  private static int getAdaptiveAudioTrackCount(TrackGroup paramTrackGroup, int[] paramArrayOfInt, DefaultTrackSelector.AudioConfigurationTuple paramAudioConfigurationTuple)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramTrackGroup.length; j = k)
    {
      k = j;
      if (isSupportedAdaptiveAudioTrack(paramTrackGroup.getFormat(i), paramArrayOfInt[i], paramAudioConfigurationTuple)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  private static int[] getAdaptiveAudioTracks(TrackGroup paramTrackGroup, int[] paramArrayOfInt, boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet();
    int m = 0;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject2;
    int k;
    while (i < paramTrackGroup.length)
    {
      localObject2 = paramTrackGroup.getFormat(i);
      k = ((Format)localObject2).channelCount;
      int n = ((Format)localObject2).sampleRate;
      if (paramBoolean) {
        localObject2 = null;
      } else {
        localObject2 = ((Format)localObject2).sampleMimeType;
      }
      DefaultTrackSelector.AudioConfigurationTuple localAudioConfigurationTuple = new DefaultTrackSelector.AudioConfigurationTuple(k, n, (String)localObject2);
      k = j;
      localObject2 = localObject1;
      if (localHashSet.add(localAudioConfigurationTuple))
      {
        n = getAdaptiveAudioTrackCount(paramTrackGroup, paramArrayOfInt, localAudioConfigurationTuple);
        k = j;
        localObject2 = localObject1;
        if (n > j)
        {
          k = n;
          localObject2 = localAudioConfigurationTuple;
        }
      }
      i += 1;
      j = k;
      localObject1 = localObject2;
    }
    if (j > 1)
    {
      localObject2 = new int[j];
      j = 0;
      i = m;
      while (i < paramTrackGroup.length)
      {
        k = j;
        if (isSupportedAdaptiveAudioTrack(paramTrackGroup.getFormat(i), paramArrayOfInt[i], localObject1))
        {
          localObject2[j] = i;
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      return localObject2;
    }
    return NO_TRACKS;
  }
  
  private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramList.size(); j = k)
    {
      int m = ((Integer)paramList.get(i)).intValue();
      k = j;
      if (isSupportedAdaptiveVideoTrack(paramTrackGroup.getFormat(m), paramString, paramArrayOfInt[m], paramInt1, paramInt2, paramInt3, paramInt4)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  private static int[] getAdaptiveVideoTracksForGroup(TrackGroup paramTrackGroup, int[] paramArrayOfInt, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2)
  {
    if (paramTrackGroup.length < 2) {
      return NO_TRACKS;
    }
    List localList = getViewportFilteredTrackIndices(paramTrackGroup, paramInt5, paramInt6, paramBoolean2);
    if (localList.size() < 2) {
      return NO_TRACKS;
    }
    Object localObject1;
    if (!paramBoolean1)
    {
      HashSet localHashSet = new HashSet();
      localObject1 = null;
      paramInt5 = 0;
      int i;
      for (paramInt6 = 0; paramInt5 < localList.size(); paramInt6 = i)
      {
        String str = paramTrackGroup.getFormat(((Integer)localList.get(paramInt5)).intValue()).sampleMimeType;
        Object localObject2 = localObject1;
        i = paramInt6;
        if (localHashSet.add(str))
        {
          int j = getAdaptiveVideoTrackCountForMimeType(paramTrackGroup, paramArrayOfInt, paramInt1, str, paramInt2, paramInt3, paramInt4, localList);
          localObject2 = localObject1;
          i = paramInt6;
          if (j > paramInt6)
          {
            i = j;
            localObject2 = str;
          }
        }
        paramInt5 += 1;
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    filterAdaptiveVideoTrackCountForMimeType(paramTrackGroup, paramArrayOfInt, paramInt1, localObject1, paramInt2, paramInt3, paramInt4, localList);
    if (localList.size() < 2) {
      return NO_TRACKS;
    }
    return Util.toArray(localList);
  }
  
  private static Point getMaxVideoSizeInViewport(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      j = 1;
      if (paramInt3 > paramInt4) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramInt1 <= paramInt2) {
        j = 0;
      }
      if (i != j) {}
    }
    else
    {
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    int i = paramInt3 * paramInt1;
    int j = paramInt4 * paramInt2;
    if (i >= j) {
      return new Point(paramInt2, Util.ceilDivide(j, paramInt3));
    }
    return new Point(Util.ceilDivide(i, paramInt4), paramInt1);
  }
  
  private static List<Integer> getViewportFilteredTrackIndices(TrackGroup paramTrackGroup, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramTrackGroup.length);
    int j = 0;
    int i = 0;
    while (i < paramTrackGroup.length)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    if (paramInt1 != 2147483647)
    {
      if (paramInt2 == 2147483647) {
        return localArrayList;
      }
      int k;
      for (i = 2147483647; j < paramTrackGroup.length; i = k)
      {
        Format localFormat = paramTrackGroup.getFormat(j);
        k = i;
        if (localFormat.width > 0)
        {
          k = i;
          if (localFormat.height > 0)
          {
            Point localPoint = getMaxVideoSizeInViewport(paramBoolean, paramInt1, paramInt2, localFormat.width, localFormat.height);
            int m = localFormat.width * localFormat.height;
            k = i;
            if (localFormat.width >= (int)(localPoint.x * 0.98F))
            {
              k = i;
              if (localFormat.height >= (int)(localPoint.y * 0.98F))
              {
                k = i;
                if (m < i) {
                  k = m;
                }
              }
            }
          }
        }
        j += 1;
      }
      if (i != 2147483647)
      {
        paramInt1 = localArrayList.size() - 1;
        while (paramInt1 >= 0)
        {
          paramInt2 = paramTrackGroup.getFormat(((Integer)localArrayList.get(paramInt1)).intValue()).getPixelCount();
          if ((paramInt2 == -1) || (paramInt2 > i)) {
            localArrayList.remove(paramInt1);
          }
          paramInt1 -= 1;
        }
      }
    }
    return localArrayList;
  }
  
  protected static boolean isSupported(int paramInt, boolean paramBoolean)
  {
    paramInt &= 0x7;
    return (paramInt == 4) || ((paramBoolean) && (paramInt == 3));
  }
  
  private static boolean isSupportedAdaptiveAudioTrack(Format paramFormat, int paramInt, DefaultTrackSelector.AudioConfigurationTuple paramAudioConfigurationTuple)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isSupported(paramInt, false))
    {
      bool1 = bool2;
      if (paramFormat.channelCount == paramAudioConfigurationTuple.channelCount)
      {
        bool1 = bool2;
        if (paramFormat.sampleRate == paramAudioConfigurationTuple.sampleRate) {
          if (paramAudioConfigurationTuple.mimeType != null)
          {
            bool1 = bool2;
            if (!TextUtils.equals(paramAudioConfigurationTuple.mimeType, paramFormat.sampleMimeType)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean isSupportedAdaptiveVideoTrack(Format paramFormat, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isSupported(paramInt1, false))
    {
      bool1 = bool2;
      if ((paramInt1 & paramInt2) != 0) {
        if (paramString != null)
        {
          bool1 = bool2;
          if (!Util.areEqual(paramFormat.sampleMimeType, paramString)) {}
        }
        else if (paramFormat.width != -1)
        {
          bool1 = bool2;
          if (paramFormat.width > paramInt3) {}
        }
        else if (paramFormat.height != -1)
        {
          bool1 = bool2;
          if (paramFormat.height > paramInt4) {}
        }
        else if (paramFormat.bitrate != -1)
        {
          bool1 = bool2;
          if (paramFormat.bitrate > paramInt5) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static TrackSelection selectAdaptiveVideoTrack(RendererCapabilities paramRendererCapabilities, TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters, TrackSelection.Factory paramFactory)
  {
    int i;
    if (paramParameters.allowNonSeamlessAdaptiveness) {
      i = 24;
    } else {
      i = 16;
    }
    boolean bool;
    if ((paramParameters.allowMixedMimeAdaptiveness) && ((paramRendererCapabilities.supportsMixedMimeTypeAdaptation() & i) != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    int j = 0;
    while (j < paramTrackGroupArray.length)
    {
      paramRendererCapabilities = paramTrackGroupArray.get(j);
      int[] arrayOfInt = getAdaptiveVideoTracksForGroup(paramRendererCapabilities, paramArrayOfInt[j], bool, i, paramParameters.maxVideoWidth, paramParameters.maxVideoHeight, paramParameters.maxVideoBitrate, paramParameters.viewportWidth, paramParameters.viewportHeight, paramParameters.viewportOrientationMayChange);
      if (arrayOfInt.length > 0) {
        return paramFactory.createTrackSelection(paramRendererCapabilities, arrayOfInt);
      }
      j += 1;
    }
    return null;
  }
  
  private static TrackSelection selectFixedVideoTrack(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters)
  {
    int i3 = 0;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    int k = -1;
    int i1;
    for (int m = -1;; m = i1)
    {
      Object localObject2 = paramTrackGroupArray;
      if (i3 >= ((TrackGroupArray)localObject2).length) {
        break;
      }
      TrackGroup localTrackGroup = ((TrackGroupArray)localObject2).get(i3);
      List localList = getViewportFilteredTrackIndices(localTrackGroup, paramParameters.viewportWidth, paramParameters.viewportHeight, paramParameters.viewportOrientationMayChange);
      int[] arrayOfInt = paramArrayOfInt[i3];
      int n = j;
      i1 = i;
      int i2 = 0;
      i = m;
      j = k;
      m = n;
      n = i1;
      k = i2;
      while (k < localTrackGroup.length)
      {
        localObject2 = localObject1;
        int i7 = n;
        int i6 = m;
        int i5 = j;
        int i4 = i;
        if (isSupported(arrayOfInt[k], paramParameters.exceedRendererCapabilitiesIfNecessary))
        {
          Format localFormat = localTrackGroup.getFormat(k);
          if ((localList.contains(Integer.valueOf(k))) && ((localFormat.width == -1) || (localFormat.width <= paramParameters.maxVideoWidth)) && ((localFormat.height == -1) || (localFormat.height <= paramParameters.maxVideoHeight)) && ((localFormat.bitrate == -1) || (localFormat.bitrate <= paramParameters.maxVideoBitrate))) {
            i4 = 1;
          } else {
            i4 = 0;
          }
          if ((i4 == 0) && (!paramParameters.exceedVideoConstraintsIfNecessary))
          {
            localObject2 = localObject1;
            i7 = n;
            i6 = m;
            i5 = j;
            i4 = i;
          }
          else
          {
            if (i4 != 0) {
              i2 = 2;
            } else {
              i2 = 1;
            }
            boolean bool = isSupported(arrayOfInt[k], false);
            i1 = i2;
            if (bool) {
              i1 = i2 + 1000;
            }
            if (i1 > m) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (i1 == m)
            {
              if (paramParameters.forceLowestBitrate) {
                if (compareFormatValues(localFormat.bitrate, i) >= 0) {}
              }
              for (;;)
              {
                i2 = 1;
                break;
                do
                {
                  do
                  {
                    i2 = 0;
                    break label426;
                    i2 = localFormat.getPixelCount();
                    if (i2 != j) {
                      i2 = compareFormatValues(i2, j);
                    } else {
                      i2 = compareFormatValues(localFormat.bitrate, i);
                    }
                    if ((!bool) || (i4 == 0)) {
                      break;
                    }
                  } while (i2 <= 0);
                  break;
                } while (i2 >= 0);
              }
            }
            label426:
            localObject2 = localObject1;
            i7 = n;
            i6 = m;
            i5 = j;
            i4 = i;
            if (i2 != 0)
            {
              i4 = localFormat.bitrate;
              i5 = localFormat.getPixelCount();
              i7 = k;
              localObject2 = localTrackGroup;
              i6 = i1;
            }
          }
        }
        k += 1;
        localObject1 = localObject2;
        n = i7;
        m = i6;
        j = i5;
        i = i4;
      }
      i3 += 1;
      k = j;
      i1 = i;
      i = n;
      j = m;
    }
    if (localObject1 == null) {
      return null;
    }
    return new FixedTrackSelection(localObject1, i);
  }
  
  public DefaultTrackSelector.Parameters getParameters()
  {
    return (DefaultTrackSelector.Parameters)this.paramsReference.get();
  }
  
  protected TrackSelection selectAudioTrack(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters, TrackSelection.Factory paramFactory)
  {
    Object localObject1 = null;
    int i = 0;
    int j = -1;
    int k = -1;
    while (i < paramTrackGroupArray.length)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.get(i);
      int[] arrayOfInt = paramArrayOfInt[i];
      int m = j;
      int n = 0;
      j = k;
      k = n;
      while (k < localTrackGroup.length)
      {
        int i1 = m;
        Object localObject2 = localObject1;
        n = j;
        if (isSupported(arrayOfInt[k], paramParameters.exceedRendererCapabilitiesIfNecessary))
        {
          DefaultTrackSelector.AudioTrackScore localAudioTrackScore = new DefaultTrackSelector.AudioTrackScore(localTrackGroup.getFormat(k), paramParameters, arrayOfInt[k]);
          if (localObject1 != null)
          {
            i1 = m;
            localObject2 = localObject1;
            n = j;
            if (localAudioTrackScore.compareTo((DefaultTrackSelector.AudioTrackScore)localObject1) <= 0) {}
          }
          else
          {
            i1 = i;
            n = k;
            localObject2 = localAudioTrackScore;
          }
        }
        k += 1;
        m = i1;
        localObject1 = localObject2;
        j = n;
      }
      i += 1;
      k = j;
      j = m;
    }
    if (j == -1) {
      return null;
    }
    paramTrackGroupArray = paramTrackGroupArray.get(j);
    if ((!paramParameters.forceLowestBitrate) && (paramFactory != null))
    {
      paramArrayOfInt = getAdaptiveAudioTracks(paramTrackGroupArray, paramArrayOfInt[j], paramParameters.allowMixedMimeAdaptiveness);
      if (paramArrayOfInt.length > 0) {
        return paramFactory.createTrackSelection(paramTrackGroupArray, paramArrayOfInt);
      }
    }
    return new FixedTrackSelection(paramTrackGroupArray, k);
  }
  
  protected TrackSelection selectOtherTrack(int paramInt, TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters)
  {
    Object localObject1 = null;
    int n = 0;
    paramInt = 0;
    int i = 0;
    while (n < paramTrackGroupArray.length)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.get(n);
      int[] arrayOfInt = paramArrayOfInt[n];
      int j = paramInt;
      int k = 0;
      paramInt = i;
      i = k;
      while (i < localTrackGroup.length)
      {
        Object localObject2 = localObject1;
        int i1 = j;
        int m = paramInt;
        if (isSupported(arrayOfInt[i], paramParameters.exceedRendererCapabilitiesIfNecessary))
        {
          k = localTrackGroup.getFormat(i).selectionFlags;
          m = 1;
          if ((k & 0x1) != 0) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0) {
            m = 2;
          }
          k = m;
          if (isSupported(arrayOfInt[i], false)) {
            k = m + 1000;
          }
          localObject2 = localObject1;
          i1 = j;
          m = paramInt;
          if (k > paramInt)
          {
            i1 = i;
            localObject2 = localTrackGroup;
            m = k;
          }
        }
        i += 1;
        localObject1 = localObject2;
        j = i1;
        paramInt = m;
      }
      n += 1;
      i = paramInt;
      paramInt = j;
    }
    if (localObject1 == null) {
      return null;
    }
    return new FixedTrackSelection(localObject1, paramInt);
  }
  
  protected TrackSelection selectTextTrack(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected TrackSelection[] selectTracks(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray[] paramArrayOfTrackGroupArray, int[][][] paramArrayOfInt)
  {
    int i2 = paramArrayOfRendererCapabilities.length;
    TrackSelection[] arrayOfTrackSelection = new TrackSelection[i2];
    DefaultTrackSelector.Parameters localParameters = (DefaultTrackSelector.Parameters)this.paramsReference.get();
    int j = 0;
    int m = 0;
    int i;
    for (int k = 0;; k = n)
    {
      i1 = 1;
      if (m >= i2) {
        break;
      }
      i = j;
      n = k;
      if (2 == paramArrayOfRendererCapabilities[m].getTrackType())
      {
        i = j;
        if (j == 0)
        {
          arrayOfTrackSelection[m] = selectVideoTrack(paramArrayOfRendererCapabilities[m], paramArrayOfTrackGroupArray[m], paramArrayOfInt[m], localParameters, this.adaptiveTrackSelectionFactory);
          if (arrayOfTrackSelection[m] != null) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramArrayOfTrackGroupArray[m].length > 0) {
          j = i1;
        } else {
          j = 0;
        }
        n = k | j;
      }
      m += 1;
      j = i;
    }
    m = 0;
    int i1 = 0;
    for (int n = 0; m < i2; n = j)
    {
      int i3 = paramArrayOfRendererCapabilities[m].getTrackType();
      if (i3 != 1)
      {
        i = i1;
        j = n;
        if (i3 != 2) {
          if (i3 != 3)
          {
            arrayOfTrackSelection[m] = selectOtherTrack(paramArrayOfRendererCapabilities[m].getTrackType(), paramArrayOfTrackGroupArray[m], paramArrayOfInt[m], localParameters);
            i = i1;
            j = n;
          }
          else
          {
            i = i1;
            j = n;
            if (n == 0)
            {
              arrayOfTrackSelection[m] = selectTextTrack(paramArrayOfTrackGroupArray[m], paramArrayOfInt[m], localParameters);
              if (arrayOfTrackSelection[m] != null)
              {
                j = 1;
                i = i1;
              }
              else
              {
                j = 0;
                i = i1;
              }
            }
          }
        }
      }
      else
      {
        i = i1;
        j = n;
        if (i1 == 0)
        {
          TrackGroupArray localTrackGroupArray = paramArrayOfTrackGroupArray[m];
          int[][] arrayOfInt = paramArrayOfInt[m];
          TrackSelection.Factory localFactory;
          if (k != 0) {
            localFactory = null;
          } else {
            localFactory = this.adaptiveTrackSelectionFactory;
          }
          arrayOfTrackSelection[m] = selectAudioTrack(localTrackGroupArray, arrayOfInt, localParameters, localFactory);
          if (arrayOfTrackSelection[m] != null)
          {
            i = 1;
            j = n;
          }
          else
          {
            i = 0;
            j = n;
          }
        }
      }
      m += 1;
      i1 = i;
    }
    return arrayOfTrackSelection;
  }
  
  protected TrackSelection selectVideoTrack(RendererCapabilities paramRendererCapabilities, TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters, TrackSelection.Factory paramFactory)
  {
    if ((!paramParameters.forceLowestBitrate) && (paramFactory != null)) {
      paramRendererCapabilities = selectAdaptiveVideoTrack(paramRendererCapabilities, paramTrackGroupArray, paramArrayOfInt, paramParameters, paramFactory);
    } else {
      paramRendererCapabilities = null;
    }
    paramFactory = paramRendererCapabilities;
    if (paramRendererCapabilities == null) {
      paramFactory = selectFixedVideoTrack(paramTrackGroupArray, paramArrayOfInt, paramParameters);
    }
    return paramFactory;
  }
  
  public void setParameters(DefaultTrackSelector.Parameters paramParameters)
  {
    Assertions.checkNotNull(paramParameters);
    if (!((DefaultTrackSelector.Parameters)this.paramsReference.getAndSet(paramParameters)).equals(paramParameters)) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector
 * JD-Core Version:    0.7.0.1
 */