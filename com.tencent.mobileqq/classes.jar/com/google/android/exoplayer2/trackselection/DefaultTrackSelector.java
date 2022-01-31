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
        paramInt1 = 0;
      }
      return paramInt1;
    }
    if (paramInt2 == -1) {
      return 1;
    }
    return paramInt1 - paramInt2;
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
    int k = 0;
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (j < paramTrackGroup.length)
    {
      localObject2 = paramTrackGroup.getFormat(j);
      int m = ((Format)localObject2).channelCount;
      int n = ((Format)localObject2).sampleRate;
      if (paramBoolean)
      {
        localObject2 = null;
        label58:
        localObject2 = new DefaultTrackSelector.AudioConfigurationTuple(m, n, (String)localObject2);
        if (!localHashSet.add(localObject2)) {
          break label198;
        }
        m = getAdaptiveAudioTrackCount(paramTrackGroup, paramArrayOfInt, (DefaultTrackSelector.AudioConfigurationTuple)localObject2);
        if (m <= i) {
          break label198;
        }
        i = m;
        localObject1 = localObject2;
      }
    }
    label198:
    for (;;)
    {
      j += 1;
      break;
      localObject2 = ((Format)localObject2).sampleMimeType;
      break label58;
      if (i > 1)
      {
        localObject2 = new int[i];
        j = 0;
        i = k;
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
  }
  
  private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      int k = ((Integer)paramList.get(j)).intValue();
      if (!isSupportedAdaptiveVideoTrack(paramTrackGroup.getFormat(k), paramString, paramArrayOfInt[k], paramInt1, paramInt2, paramInt3, paramInt4)) {
        break label77;
      }
      i += 1;
    }
    label77:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
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
    Object localObject = null;
    if (!paramBoolean1)
    {
      HashSet localHashSet = new HashSet();
      paramInt5 = 0;
      paramInt6 = 0;
      while (paramInt6 < localList.size())
      {
        String str = paramTrackGroup.getFormat(((Integer)localList.get(paramInt6)).intValue()).sampleMimeType;
        if (!localHashSet.add(str)) {
          break label186;
        }
        int i = getAdaptiveVideoTrackCountForMimeType(paramTrackGroup, paramArrayOfInt, paramInt1, str, paramInt2, paramInt3, paramInt4, localList);
        if (i <= paramInt5) {
          break label186;
        }
        localObject = str;
        paramInt5 = i;
        paramInt6 += 1;
      }
    }
    for (;;)
    {
      filterAdaptiveVideoTrackCountForMimeType(paramTrackGroup, paramArrayOfInt, paramInt1, localObject, paramInt2, paramInt3, paramInt4, localList);
      if (localList.size() < 2) {
        return NO_TRACKS;
      }
      return Util.toArray(localList);
      label186:
      break;
      localObject = null;
    }
  }
  
  private static Point getMaxVideoSizeInViewport(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = 1;
    int k = paramInt1;
    int j = paramInt2;
    int i;
    if (paramBoolean)
    {
      if (paramInt3 <= paramInt4) {
        break label77;
      }
      i = 1;
      if (paramInt1 <= paramInt2) {
        break label83;
      }
    }
    for (;;)
    {
      k = paramInt1;
      j = paramInt2;
      if (i != m)
      {
        j = paramInt1;
        k = paramInt2;
      }
      if (paramInt3 * j < paramInt4 * k) {
        break label89;
      }
      return new Point(k, Util.ceilDivide(k * paramInt4, paramInt3));
      label77:
      i = 0;
      break;
      label83:
      m = 0;
    }
    label89:
    return new Point(Util.ceilDivide(j * paramInt3, paramInt4), j);
  }
  
  private static List<Integer> getViewportFilteredTrackIndices(TrackGroup paramTrackGroup, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList(paramTrackGroup.length);
    int i = 0;
    while (i < paramTrackGroup.length)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    if ((paramInt1 == 2147483647) || (paramInt2 == 2147483647)) {
      return localArrayList;
    }
    i = 2147483647;
    if (j < paramTrackGroup.length)
    {
      Format localFormat = paramTrackGroup.getFormat(j);
      if ((localFormat.width <= 0) || (localFormat.height <= 0)) {
        break label254;
      }
      Point localPoint = getMaxVideoSizeInViewport(paramBoolean, paramInt1, paramInt2, localFormat.width, localFormat.height);
      int k = localFormat.width * localFormat.height;
      if ((localFormat.width < (int)(localPoint.x * 0.98F)) || (localFormat.height < (int)(localPoint.y * 0.98F)) || (k >= i)) {
        break label254;
      }
      i = k;
    }
    label254:
    for (;;)
    {
      j += 1;
      break;
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
      return localArrayList;
    }
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
    boolean bool;
    label33:
    int j;
    if (paramParameters.allowNonSeamlessAdaptiveness)
    {
      i = 24;
      if ((!paramParameters.allowMixedMimeAdaptiveness) || ((paramRendererCapabilities.supportsMixedMimeTypeAdaptation() & i) == 0)) {
        break label114;
      }
      bool = true;
      j = 0;
    }
    for (;;)
    {
      if (j >= paramTrackGroupArray.length) {
        break label129;
      }
      paramRendererCapabilities = paramTrackGroupArray.get(j);
      int[] arrayOfInt = getAdaptiveVideoTracksForGroup(paramRendererCapabilities, paramArrayOfInt[j], bool, i, paramParameters.maxVideoWidth, paramParameters.maxVideoHeight, paramParameters.maxVideoBitrate, paramParameters.viewportWidth, paramParameters.viewportHeight, paramParameters.viewportOrientationMayChange);
      if (arrayOfInt.length > 0)
      {
        return paramFactory.createTrackSelection(paramRendererCapabilities, arrayOfInt);
        i = 16;
        break;
        label114:
        bool = false;
        break label33;
      }
      j += 1;
    }
    label129:
    return null;
  }
  
  private static TrackSelection selectFixedVideoTrack(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters)
  {
    Object localObject = null;
    int j = 0;
    int n = 0;
    int i3 = -1;
    int i2 = -1;
    int i1 = 0;
    TrackGroup localTrackGroup;
    int[] arrayOfInt;
    int k;
    label63:
    Format localFormat;
    int i4;
    label178:
    int i;
    if (n < paramTrackGroupArray.length)
    {
      localTrackGroup = paramTrackGroupArray.get(n);
      List localList = getViewportFilteredTrackIndices(localTrackGroup, paramParameters.viewportWidth, paramParameters.viewportHeight, paramParameters.viewportOrientationMayChange);
      arrayOfInt = paramArrayOfInt[n];
      k = 0;
      if (k < localTrackGroup.length)
      {
        if (!isSupported(arrayOfInt[k], paramParameters.exceedRendererCapabilitiesIfNecessary)) {
          break label428;
        }
        localFormat = localTrackGroup.getFormat(k);
        if ((localList.contains(Integer.valueOf(k))) && ((localFormat.width == -1) || (localFormat.width <= paramParameters.maxVideoWidth)) && ((localFormat.height == -1) || (localFormat.height <= paramParameters.maxVideoHeight)) && ((localFormat.bitrate == -1) || (localFormat.bitrate <= paramParameters.maxVideoBitrate)))
        {
          i4 = 1;
          if ((i4 != 0) || (paramParameters.exceedVideoConstraintsIfNecessary)) {
            break label211;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      label193:
      k += 1;
      j = i;
      break label63;
      i4 = 0;
      break label178;
      label211:
      label218:
      boolean bool;
      int m;
      if (i4 != 0)
      {
        i = 2;
        bool = isSupported(arrayOfInt[k], false);
        m = i;
        if (bool) {
          m = i + 1000;
        }
        if (m <= i1) {
          break label319;
        }
        i = 1;
        label253:
        if (m == i1)
        {
          if (!paramParameters.forceLowestBitrate) {
            break label329;
          }
          if (compareFormatValues(localFormat.bitrate, i2) >= 0) {
            break label324;
          }
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          i2 = localFormat.bitrate;
          i3 = localFormat.getPixelCount();
          localObject = localTrackGroup;
          i = k;
          i1 = m;
          break label193;
          i = 1;
          break label218;
          label319:
          i = 0;
          break label253;
          label324:
          i = 0;
          continue;
          label329:
          i = localFormat.getPixelCount();
          if (i != i3) {
            i = compareFormatValues(i, i3);
          }
          for (;;)
          {
            if ((bool) && (i4 != 0))
            {
              if (i > 0)
              {
                i = 1;
                break;
                i = compareFormatValues(localFormat.bitrate, i2);
                continue;
              }
              i = 0;
              break;
            }
          }
          if (i < 0)
          {
            i = 1;
          }
          else
          {
            i = 0;
            continue;
            n += 1;
            break;
            if (localObject == null) {
              return null;
            }
            return new FixedTrackSelection(localObject, j);
          }
        }
      }
      label428:
      i = j;
    }
  }
  
  public DefaultTrackSelector.Parameters getParameters()
  {
    return (DefaultTrackSelector.Parameters)this.paramsReference.get();
  }
  
  protected TrackSelection selectAudioTrack(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters, TrackSelection.Factory paramFactory)
  {
    int k = -1;
    int m = -1;
    Object localObject = null;
    int i = 0;
    int j;
    if (i < paramTrackGroupArray.length)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.get(i);
      int[] arrayOfInt = paramArrayOfInt[i];
      j = 0;
      label38:
      if (j < localTrackGroup.length)
      {
        if (!isSupported(arrayOfInt[j], paramParameters.exceedRendererCapabilitiesIfNecessary)) {
          break label212;
        }
        DefaultTrackSelector.AudioTrackScore localAudioTrackScore = new DefaultTrackSelector.AudioTrackScore(localTrackGroup.getFormat(j), paramParameters, arrayOfInt[j]);
        if ((localObject != null) && (localAudioTrackScore.compareTo((DefaultTrackSelector.AudioTrackScore)localObject) <= 0)) {
          break label212;
        }
        localObject = localAudioTrackScore;
        m = j;
        k = i;
      }
    }
    for (;;)
    {
      int n = j + 1;
      j = m;
      m = k;
      k = j;
      j = n;
      break label38;
      i += 1;
      break;
      if (m == -1) {
        return null;
      }
      paramTrackGroupArray = paramTrackGroupArray.get(m);
      if ((!paramParameters.forceLowestBitrate) && (paramFactory != null))
      {
        paramArrayOfInt = getAdaptiveAudioTracks(paramTrackGroupArray, paramArrayOfInt[m], paramParameters.allowMixedMimeAdaptiveness);
        if (paramArrayOfInt.length > 0) {
          return paramFactory.createTrackSelection(paramTrackGroupArray, paramArrayOfInt);
        }
      }
      return new FixedTrackSelection(paramTrackGroupArray, k);
      label212:
      n = k;
      k = m;
      m = n;
    }
  }
  
  protected TrackSelection selectOtherTrack(int paramInt, TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters)
  {
    Object localObject = null;
    int i = 0;
    int j = 0;
    int n = 0;
    label37:
    int k;
    label78:
    int m;
    if (n < paramTrackGroupArray.length)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.get(n);
      int[] arrayOfInt = paramArrayOfInt[n];
      paramInt = 0;
      if (paramInt < localTrackGroup.length)
      {
        if (!isSupported(arrayOfInt[paramInt], paramParameters.exceedRendererCapabilitiesIfNecessary)) {
          break label174;
        }
        if ((localTrackGroup.getFormat(paramInt).selectionFlags & 0x1) != 0)
        {
          k = 1;
          if (k == 0) {
            break label140;
          }
          m = 2;
          label86:
          k = m;
          if (isSupported(arrayOfInt[paramInt], false)) {
            k = m + 1000;
          }
          if (k <= j) {
            break label174;
          }
          i = paramInt;
          localObject = localTrackGroup;
        }
      }
    }
    for (;;)
    {
      paramInt += 1;
      j = k;
      break label37;
      k = 0;
      break label78;
      label140:
      m = 1;
      break label86;
      n += 1;
      break;
      if (localObject == null) {
        return null;
      }
      return new FixedTrackSelection(localObject, i);
      label174:
      k = j;
    }
  }
  
  protected TrackSelection selectTextTrack(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters)
  {
    Object localObject = null;
    int k = 0;
    int n = 0;
    int i1 = 0;
    int j;
    label38:
    Format localFormat;
    int m;
    int i;
    if (n < paramTrackGroupArray.length)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.get(n);
      int[] arrayOfInt = paramArrayOfInt[n];
      j = 0;
      if (j < localTrackGroup.length)
      {
        if (!isSupported(arrayOfInt[j], paramParameters.exceedRendererCapabilitiesIfNecessary)) {
          break label321;
        }
        localFormat = localTrackGroup.getFormat(j);
        m = localFormat.selectionFlags & (paramParameters.disabledTextTrackSelectionFlags ^ 0xFFFFFFFF);
        if ((m & 0x1) != 0)
        {
          i = 1;
          label96:
          if ((m & 0x2) == 0) {
            break label223;
          }
          m = 1;
          label106:
          boolean bool = formatHasLanguage(localFormat, paramParameters.preferredTextLanguage);
          if ((!bool) && ((!paramParameters.selectUndeterminedTextLanguage) || (!formatHasNoLanguage(localFormat)))) {
            break label253;
          }
          if (i == 0) {
            break label229;
          }
          i = 8;
          label146:
          if (!bool) {
            break label247;
          }
          m = 1;
          label154:
          i = m + i;
          label161:
          m = i;
          if (isSupported(arrayOfInt[j], false)) {
            m = i + 1000;
          }
          if (m <= i1) {
            break label321;
          }
          localObject = localTrackGroup;
          i = j;
          i1 = m;
        }
      }
    }
    for (;;)
    {
      j += 1;
      k = i;
      break label38;
      i = 0;
      break label96;
      label223:
      m = 0;
      break label106;
      label229:
      if (m == 0)
      {
        i = 6;
        break label146;
      }
      i = 4;
      break label146;
      label247:
      m = 0;
      break label154;
      label253:
      if (i != 0)
      {
        i = 3;
        break label161;
      }
      if (m != 0)
      {
        if (formatHasLanguage(localFormat, paramParameters.preferredAudioLanguage))
        {
          i = 2;
          break label161;
        }
        i = 1;
        break label161;
        n += 1;
        break;
        if (localObject == null) {
          return null;
        }
        return new FixedTrackSelection(localObject, k);
      }
      label321:
      i = k;
    }
  }
  
  protected TrackSelection[] selectTracks(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray[] paramArrayOfTrackGroupArray, int[][][] paramArrayOfInt)
  {
    int i1 = paramArrayOfRendererCapabilities.length;
    TrackSelection[] arrayOfTrackSelection = new TrackSelection[i1];
    DefaultTrackSelector.Parameters localParameters = (DefaultTrackSelector.Parameters)this.paramsReference.get();
    int k = 0;
    int m = 0;
    int j = 0;
    int i;
    if (m < i1)
    {
      if (2 != paramArrayOfRendererCapabilities[m].getTrackType()) {
        break label422;
      }
      i = j;
      if (j == 0)
      {
        arrayOfTrackSelection[m] = selectVideoTrack(paramArrayOfRendererCapabilities[m], paramArrayOfTrackGroupArray[m], paramArrayOfInt[m], localParameters, this.adaptiveTrackSelectionFactory);
        if (arrayOfTrackSelection[m] != null) {
          i = 1;
        }
      }
      else
      {
        label99:
        if (paramArrayOfTrackGroupArray[m].length <= 0) {
          break label142;
        }
        j = 1;
        label112:
        j |= k;
      }
    }
    for (;;)
    {
      m += 1;
      k = j;
      j = i;
      break;
      i = 0;
      break label99;
      label142:
      j = 0;
      break label112;
      i = 0;
      j = 0;
      m = 0;
      if (m < i1)
      {
        switch (paramArrayOfRendererCapabilities[m].getTrackType())
        {
        default: 
          arrayOfTrackSelection[m] = selectOtherTrack(paramArrayOfRendererCapabilities[m].getTrackType(), paramArrayOfTrackGroupArray[m], paramArrayOfInt[m], localParameters);
        }
        int n;
        label305:
        label357:
        do
        {
          do
          {
            n = j;
            j = i;
            i = n;
            for (;;)
            {
              n = m + 1;
              m = j;
              j = i;
              i = m;
              m = n;
              break;
              n = i;
              i = j;
              j = n;
            }
          } while (i != 0);
          TrackGroupArray localTrackGroupArray = paramArrayOfTrackGroupArray[m];
          int[][] arrayOfInt = paramArrayOfInt[m];
          TrackSelection.Factory localFactory;
          if (k != 0)
          {
            localFactory = null;
            arrayOfTrackSelection[m] = selectAudioTrack(localTrackGroupArray, arrayOfInt, localParameters, localFactory);
            if (arrayOfTrackSelection[m] == null) {
              break label357;
            }
          }
          for (i = 1;; i = 0)
          {
            n = i;
            i = j;
            j = n;
            break;
            localFactory = this.adaptiveTrackSelectionFactory;
            break label305;
          }
        } while (j != 0);
        arrayOfTrackSelection[m] = selectTextTrack(paramArrayOfTrackGroupArray[m], paramArrayOfInt[m], localParameters);
        if (arrayOfTrackSelection[m] != null) {}
        for (j = 1;; j = 0)
        {
          n = i;
          i = j;
          j = n;
          break;
        }
      }
      return arrayOfTrackSelection;
      label422:
      i = j;
      j = k;
    }
  }
  
  protected TrackSelection selectVideoTrack(RendererCapabilities paramRendererCapabilities, TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, DefaultTrackSelector.Parameters paramParameters, TrackSelection.Factory paramFactory)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!paramParameters.forceLowestBitrate)
    {
      localObject1 = localObject2;
      if (paramFactory != null) {
        localObject1 = selectAdaptiveVideoTrack(paramRendererCapabilities, paramTrackGroupArray, paramArrayOfInt, paramParameters, paramFactory);
      }
    }
    paramRendererCapabilities = (RendererCapabilities)localObject1;
    if (localObject1 == null) {
      paramRendererCapabilities = selectFixedVideoTrack(paramTrackGroupArray, paramArrayOfInt, paramParameters);
    }
    return paramRendererCapabilities;
  }
  
  public void setParameters(DefaultTrackSelector.Parameters paramParameters)
  {
    Assertions.checkNotNull(paramParameters);
    if (!((DefaultTrackSelector.Parameters)this.paramsReference.getAndSet(paramParameters)).equals(paramParameters)) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector
 * JD-Core Version:    0.7.0.1
 */