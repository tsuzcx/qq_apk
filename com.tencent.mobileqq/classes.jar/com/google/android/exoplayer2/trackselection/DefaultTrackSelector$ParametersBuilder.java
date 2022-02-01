package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import com.google.android.exoplayer2.util.Util;

public final class DefaultTrackSelector$ParametersBuilder
{
  private boolean allowMixedMimeAdaptiveness;
  private boolean allowNonSeamlessAdaptiveness;
  private int disabledTextTrackSelectionFlags;
  private boolean exceedRendererCapabilitiesIfNecessary;
  private boolean exceedVideoConstraintsIfNecessary;
  private boolean forceLowestBitrate;
  private int maxVideoBitrate;
  private int maxVideoHeight;
  private int maxVideoWidth;
  private String preferredAudioLanguage;
  private String preferredTextLanguage;
  private boolean selectUndeterminedTextLanguage;
  private int viewportHeight;
  private boolean viewportOrientationMayChange;
  private int viewportWidth;
  
  public DefaultTrackSelector$ParametersBuilder()
  {
    this(DefaultTrackSelector.Parameters.DEFAULT);
  }
  
  private DefaultTrackSelector$ParametersBuilder(DefaultTrackSelector.Parameters paramParameters)
  {
    this.preferredAudioLanguage = paramParameters.preferredAudioLanguage;
    this.preferredTextLanguage = paramParameters.preferredTextLanguage;
    this.selectUndeterminedTextLanguage = paramParameters.selectUndeterminedTextLanguage;
    this.disabledTextTrackSelectionFlags = paramParameters.disabledTextTrackSelectionFlags;
    this.forceLowestBitrate = paramParameters.forceLowestBitrate;
    this.allowMixedMimeAdaptiveness = paramParameters.allowMixedMimeAdaptiveness;
    this.allowNonSeamlessAdaptiveness = paramParameters.allowNonSeamlessAdaptiveness;
    this.maxVideoWidth = paramParameters.maxVideoWidth;
    this.maxVideoHeight = paramParameters.maxVideoHeight;
    this.maxVideoBitrate = paramParameters.maxVideoBitrate;
    this.exceedVideoConstraintsIfNecessary = paramParameters.exceedVideoConstraintsIfNecessary;
    this.exceedRendererCapabilitiesIfNecessary = paramParameters.exceedRendererCapabilitiesIfNecessary;
    this.viewportWidth = paramParameters.viewportWidth;
    this.viewportHeight = paramParameters.viewportHeight;
    this.viewportOrientationMayChange = paramParameters.viewportOrientationMayChange;
  }
  
  public DefaultTrackSelector.Parameters build()
  {
    return new DefaultTrackSelector.Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange, null);
  }
  
  public ParametersBuilder clearVideoSizeConstraints()
  {
    return setMaxVideoSize(2147483647, 2147483647);
  }
  
  public ParametersBuilder clearViewportSizeConstraints()
  {
    return setViewportSize(2147483647, 2147483647, true);
  }
  
  public ParametersBuilder setAllowMixedMimeAdaptiveness(boolean paramBoolean)
  {
    this.allowMixedMimeAdaptiveness = paramBoolean;
    return this;
  }
  
  public ParametersBuilder setAllowNonSeamlessAdaptiveness(boolean paramBoolean)
  {
    this.allowNonSeamlessAdaptiveness = paramBoolean;
    return this;
  }
  
  public ParametersBuilder setDisabledTextTrackSelectionFlags(int paramInt)
  {
    this.disabledTextTrackSelectionFlags = paramInt;
    return this;
  }
  
  public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean paramBoolean)
  {
    this.exceedRendererCapabilitiesIfNecessary = paramBoolean;
    return this;
  }
  
  public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean paramBoolean)
  {
    this.exceedVideoConstraintsIfNecessary = paramBoolean;
    return this;
  }
  
  public ParametersBuilder setForceLowestBitrate(boolean paramBoolean)
  {
    this.forceLowestBitrate = paramBoolean;
    return this;
  }
  
  public ParametersBuilder setMaxVideoBitrate(int paramInt)
  {
    this.maxVideoBitrate = paramInt;
    return this;
  }
  
  public ParametersBuilder setMaxVideoSize(int paramInt1, int paramInt2)
  {
    this.maxVideoWidth = paramInt1;
    this.maxVideoHeight = paramInt2;
    return this;
  }
  
  public ParametersBuilder setMaxVideoSizeSd()
  {
    return setMaxVideoSize(1279, 719);
  }
  
  public ParametersBuilder setPreferredAudioLanguage(String paramString)
  {
    this.preferredAudioLanguage = paramString;
    return this;
  }
  
  public ParametersBuilder setPreferredTextLanguage(String paramString)
  {
    this.preferredTextLanguage = paramString;
    return this;
  }
  
  public ParametersBuilder setSelectUndeterminedTextLanguage(boolean paramBoolean)
  {
    this.selectUndeterminedTextLanguage = paramBoolean;
    return this;
  }
  
  public ParametersBuilder setViewportSize(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.viewportWidth = paramInt1;
    this.viewportHeight = paramInt2;
    this.viewportOrientationMayChange = paramBoolean;
    return this;
  }
  
  public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context paramContext, boolean paramBoolean)
  {
    paramContext = Util.getPhysicalDisplaySize(paramContext);
    return setViewportSize(paramContext.x, paramContext.y, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder
 * JD-Core Version:    0.7.0.1
 */