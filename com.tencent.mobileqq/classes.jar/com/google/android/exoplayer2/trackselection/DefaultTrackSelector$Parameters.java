package com.google.android.exoplayer2.trackselection;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Util;

public final class DefaultTrackSelector$Parameters
{
  public static final Parameters DEFAULT = new Parameters();
  public final boolean allowMixedMimeAdaptiveness;
  public final boolean allowNonSeamlessAdaptiveness;
  public final int disabledTextTrackSelectionFlags;
  public final boolean exceedRendererCapabilitiesIfNecessary;
  public final boolean exceedVideoConstraintsIfNecessary;
  public final boolean forceLowestBitrate;
  public final int maxVideoBitrate;
  public final int maxVideoHeight;
  public final int maxVideoWidth;
  public final String preferredAudioLanguage;
  public final String preferredTextLanguage;
  public final boolean selectUndeterminedTextLanguage;
  public final int viewportHeight;
  public final boolean viewportOrientationMayChange;
  public final int viewportWidth;
  
  private DefaultTrackSelector$Parameters()
  {
    this(null, null, false, 0, false, false, true, 2147483647, 2147483647, 2147483647, true, true, 2147483647, 2147483647, true);
  }
  
  private DefaultTrackSelector$Parameters(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean5, boolean paramBoolean6, int paramInt5, int paramInt6, boolean paramBoolean7)
  {
    this.preferredAudioLanguage = Util.normalizeLanguageCode(paramString1);
    this.preferredTextLanguage = Util.normalizeLanguageCode(paramString2);
    this.selectUndeterminedTextLanguage = paramBoolean1;
    this.disabledTextTrackSelectionFlags = paramInt1;
    this.forceLowestBitrate = paramBoolean2;
    this.allowMixedMimeAdaptiveness = paramBoolean3;
    this.allowNonSeamlessAdaptiveness = paramBoolean4;
    this.maxVideoWidth = paramInt2;
    this.maxVideoHeight = paramInt3;
    this.maxVideoBitrate = paramInt4;
    this.exceedVideoConstraintsIfNecessary = paramBoolean5;
    this.exceedRendererCapabilitiesIfNecessary = paramBoolean6;
    this.viewportWidth = paramInt5;
    this.viewportHeight = paramInt6;
    this.viewportOrientationMayChange = paramBoolean7;
  }
  
  public DefaultTrackSelector.ParametersBuilder buildUpon()
  {
    return new DefaultTrackSelector.ParametersBuilder(this, null);
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
      paramObject = (Parameters)paramObject;
    } while ((this.selectUndeterminedTextLanguage == paramObject.selectUndeterminedTextLanguage) && (this.disabledTextTrackSelectionFlags == paramObject.disabledTextTrackSelectionFlags) && (this.forceLowestBitrate == paramObject.forceLowestBitrate) && (this.allowMixedMimeAdaptiveness == paramObject.allowMixedMimeAdaptiveness) && (this.allowNonSeamlessAdaptiveness == paramObject.allowNonSeamlessAdaptiveness) && (this.maxVideoWidth == paramObject.maxVideoWidth) && (this.maxVideoHeight == paramObject.maxVideoHeight) && (this.exceedVideoConstraintsIfNecessary == paramObject.exceedVideoConstraintsIfNecessary) && (this.exceedRendererCapabilitiesIfNecessary == paramObject.exceedRendererCapabilitiesIfNecessary) && (this.viewportOrientationMayChange == paramObject.viewportOrientationMayChange) && (this.viewportWidth == paramObject.viewportWidth) && (this.viewportHeight == paramObject.viewportHeight) && (this.maxVideoBitrate == paramObject.maxVideoBitrate) && (TextUtils.equals(this.preferredAudioLanguage, paramObject.preferredAudioLanguage)) && (TextUtils.equals(this.preferredTextLanguage, paramObject.preferredTextLanguage)));
    return false;
  }
  
  public int hashCode()
  {
    int i2 = 1;
    int i;
    int i3;
    int j;
    label27:
    int k;
    label36:
    int m;
    label46:
    int i4;
    int i5;
    int n;
    label68:
    int i1;
    if (this.selectUndeterminedTextLanguage)
    {
      i = 1;
      i3 = this.disabledTextTrackSelectionFlags;
      if (!this.forceLowestBitrate) {
        break label190;
      }
      j = 1;
      if (!this.allowMixedMimeAdaptiveness) {
        break label195;
      }
      k = 1;
      if (!this.allowNonSeamlessAdaptiveness) {
        break label200;
      }
      m = 1;
      i4 = this.maxVideoWidth;
      i5 = this.maxVideoHeight;
      if (!this.exceedVideoConstraintsIfNecessary) {
        break label206;
      }
      n = 1;
      if (!this.exceedRendererCapabilitiesIfNecessary) {
        break label212;
      }
      i1 = 1;
      label78:
      if (!this.viewportOrientationMayChange) {
        break label218;
      }
    }
    for (;;)
    {
      return ((((((i1 + (n + (((m + (k + (j + (i * 31 + i3) * 31) * 31) * 31) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + i2) * 31 + this.viewportWidth) * 31 + this.viewportHeight) * 31 + this.maxVideoBitrate) * 31 + this.preferredAudioLanguage.hashCode()) * 31 + this.preferredTextLanguage.hashCode();
      i = 0;
      break;
      label190:
      j = 0;
      break label27;
      label195:
      k = 0;
      break label36;
      label200:
      m = 0;
      break label46;
      label206:
      n = 0;
      break label68;
      label212:
      i1 = 0;
      break label78;
      label218:
      i2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters
 * JD-Core Version:    0.7.0.1
 */