package com.tencent.autotemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.filter.TAVAspectFillEffect;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect;
import com.tencent.autotemplate.model.TAVAdaptiveMovieClip;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect.TAVEffectType;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.autotemplate.model.TAVEffectsModel;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.autotemplate.model.TAVPagAutomaticEffect;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.model.TAVVolumeAutomaticEffect;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.autotemplate.utils.RandomUtil;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.component.TAVTimeEffect;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.CompositionUtils;
import com.tencent.tavkit.utils.TAVBitmapUtils;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.TAVTemplate;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.base.TAVMovieVideoConfiguration;
import com.tencent.tavmovie.filter.TAVMovieFilterChainContext;
import com.tencent.tavmovie.filter.TAVMovieFilterProxy;
import com.tencent.tavmovie.filter.TAVStickerOverlayEffect;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieResource.TAVResourceType;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVAutomaticTemplate
  implements TAVTemplate
{
  public static final int DEFAULT_IMAGE_EFFECT_COUNT = 4;
  public static final String DEFAULT_IMAGE_EFFECT_PAG_NAME = "pag/autotemplate";
  private static final boolean OPEN_FILTER_STICKERS = true;
  private static final boolean OPEN_LUT_FILTER = true;
  private static final boolean OPEN_OVERLAY_STICKERS = true;
  public static final String TAG = "TAVAutomaticTemplate";
  public static final int VIDEO_MIN_DURATION_FOR_HAS_CLOSING = 5000;
  @SerializedName("backgroundColor")
  private String backgroundColor;
  private transient boolean buildFromSegmentCache;
  private transient Context context;
  private transient StringBuilder debugInfo = new StringBuilder();
  @SerializedName("effects")
  protected TAVEffectsModel effectsModel;
  private transient String filePath;
  @SerializedName("fillScale")
  private float fillScale;
  private transient List<TAVSticker> filterStickers = new ArrayList();
  @SerializedName("fonts")
  private List<String> fontList;
  @SerializedName("imageDurations")
  private List<Long> imageDurations;
  private transient List<TAVMovieSticker> imageEffects = new ArrayList();
  private transient String imagePagAssetDir;
  protected transient List<TAVMovieFilterProxy> lutFilters = new ArrayList();
  @SerializedName("bgm")
  protected TAVAdaptiveMovieClip musicResource;
  private transient List<TAVSticker> overlayStickers = new ArrayList();
  protected transient CGSize renderSize;
  @SerializedName("rhythmEffectsGroup")
  protected List<TAVRhythmEffects> rhythmEffectsGroup;
  @SerializedName("secondEffectApplyType")
  protected int secondEffectApplyType;
  protected transient String templateDir;
  private transient String templateName;
  private transient List<TAVTimeEffect> timeEffects;
  @SerializedName("transThreshold")
  protected long transThreshold;
  @SerializedName("transitionApplyType")
  protected int transitionApplyType;
  protected transient List<TAVSticker> transitionStickers = new ArrayList();
  @SerializedName("transitions")
  protected List<TAVTransitionAutomaticEffect> transitions;
  @SerializedName("volume")
  private float volume;
  @SerializedName("volumeEffects")
  private List<TAVVolumeAutomaticEffect> volumeEffects;
  
  private void addFilterSticker(TAVPagAutomaticEffect paramTAVPagAutomaticEffect, long paramLong)
  {
    if ((paramTAVPagAutomaticEffect == null) || (paramLong <= 0L)) {}
    do
    {
      return;
      paramTAVPagAutomaticEffect = paramTAVPagAutomaticEffect.convertToMovieStickerWithDuraton((float)paramLong);
    } while ((paramTAVPagAutomaticEffect == null) || (paramTAVPagAutomaticEffect.getSticker() == null));
    this.filterStickers.add(paramTAVPagAutomaticEffect.getSticker());
  }
  
  private CIImage applyBackgroundEffect(CIImage paramCIImage, CGSize paramCGSize)
  {
    if ((paramCIImage == null) || (paramCGSize == null)) {}
    while ((paramCGSize != null) && (paramCGSize.equals(paramCIImage.getSize()))) {
      return paramCIImage;
    }
    return paramCIImage.imageByCompositingOverImage(new CIImage(paramCGSize));
  }
  
  private void audioChannelsApplyEffect(TAVComposition paramTAVComposition, float paramFloat)
  {
    paramTAVComposition = paramTAVComposition.getAudioChannels();
    if (paramTAVComposition != null)
    {
      paramTAVComposition = paramTAVComposition.iterator();
      while (paramTAVComposition.hasNext())
      {
        Object localObject1 = (List)paramTAVComposition.next();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (TAVTransitionableAudio)((Iterator)localObject1).next();
            if ((localObject2 != null) && ((localObject2 instanceof TAVClip)))
            {
              localObject2 = (TAVClip)localObject2;
              ((TAVClip)localObject2).getAudioConfiguration().setVolume(this.volume);
              volumeEffectApplyToClip(this.volumeEffects, (TAVClip)localObject2, paramFloat);
            }
          }
        }
      }
    }
  }
  
  private void bgmApplyEffectToComposition(TAVComposition paramTAVComposition, float paramFloat)
  {
    if (this.musicResource != null)
    {
      this.musicResource.setFileDir(this.templateDir);
      Object localObject2 = paramTAVComposition.getAudios();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      float f = paramFloat;
      while (f > 0.0F)
      {
        this.musicResource.setDuration(f);
        localObject2 = this.musicResource.convertToMovieClip();
        if (localObject2 == null) {
          break;
        }
        f -= (float)(((TAVMovieClip)localObject2).getResource().getTimeRange().getDurationUs() / 1000L);
        ((List)localObject1).add(((TAVMovieClip)localObject2).convertToClip());
      }
      paramTAVComposition.setAudios((List)localObject1);
      CompositionUtils.reloadAudioStartTimeWithTransitionableAudio((List)localObject1);
      paramTAVComposition = ((List)localObject1).iterator();
      while (paramTAVComposition.hasNext())
      {
        localObject1 = (TAVClip)paramTAVComposition.next();
        volumeEffectApplyToClip(this.musicResource.getVolumeEffects(), (TAVClip)localObject1, paramFloat);
      }
    }
  }
  
  private void changeVolumeEffects(float paramFloat, List<TAVVolumeAutomaticEffect> paramList)
  {
    if (!CollectionUtil.isEmptyList(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TAVVolumeAutomaticEffect localTAVVolumeAutomaticEffect = (TAVVolumeAutomaticEffect)paramList.next();
        if ((localTAVVolumeAutomaticEffect.getStartOffset() > -1.0F) && (localTAVVolumeAutomaticEffect.getEndOffset() > -1.0F))
        {
          localTAVVolumeAutomaticEffect.setStartVolume(paramFloat);
          localTAVVolumeAutomaticEffect.setEndVolume(paramFloat);
        }
        else if ((localTAVVolumeAutomaticEffect.getStartOffset() > -1.0F) && (localTAVVolumeAutomaticEffect.getEndOffset() == -1.0F))
        {
          localTAVVolumeAutomaticEffect.setEndVolume(paramFloat);
        }
        else if ((localTAVVolumeAutomaticEffect.getEndOffset() > -1.0F) && (localTAVVolumeAutomaticEffect.getStartOffset() == -1.0F))
        {
          localTAVVolumeAutomaticEffect.setStartVolume(paramFloat);
        }
      }
    }
  }
  
  private void effectApplyToClip(@NonNull TAVComposition paramTAVComposition)
  {
    Object localObject1 = paramTAVComposition.getVideoChannels();
    if (CollectionUtil.isEmptyList((List)localObject1)) {
      label12:
      return;
    } else {
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label12;
      }
      Object localObject2 = (List)((Iterator)localObject1).next();
      if (CollectionUtil.isEmptyList((List)localObject2)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TAVClip localTAVClip = (TAVClip)((Iterator)localObject2).next();
        ArrayList localArrayList = new ArrayList();
        Object localObject3 = new TAVTimeRangeAspectFillEffect(paramTAVComposition.getRenderSize());
        localArrayList.add(localObject3);
        if (!TextUtils.isEmpty(this.backgroundColor)) {
          ((TAVAspectFillEffect)localObject3).setBgCIColor(this.backgroundColor);
        }
        if ((!isRhythmTemplate()) && (((localTAVClip.getResource() instanceof TAVImageResource)) || ((localTAVClip.getResource() instanceof TAVImageTrackResource))))
        {
          localObject3 = imageMovieSticker(RandomUtil.RandomInt(1, 5));
          if ((localObject3 != null) && (((TAVMovieSticker)localObject3).getSticker() != null))
          {
            ((TAVMovieSticker)localObject3).setTimeRange(localTAVClip.getTimeRange());
            this.filterStickers.add(((TAVMovieSticker)localObject3).getSticker());
          }
        }
        localObject3 = localTAVClip.getVideoConfiguration().getEffects();
        ((List)localObject3).addAll(localArrayList);
        localTAVClip.getVideoConfiguration().setEffects((List)localObject3);
      }
    }
  }
  
  private TAVPagAutomaticEffect getClosingEffect()
  {
    if (this.effectsModel == null) {
      return null;
    }
    Object localObject1 = this.effectsModel.filterEffects;
    Object localObject2 = this.effectsModel.overlayEffects;
    if (CollectionUtil.isEmptyList((List)localObject1))
    {
      if (CollectionUtil.isEmptyList((List)localObject2)) {
        return null;
      }
      localObject1 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (TAVEffectAutomaticEffect)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (!((TAVEffectAutomaticEffect)localObject2).isClosingcredits()) || (((TAVEffectAutomaticEffect)localObject2).getEffectType() != TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG));
      return ((TAVEffectAutomaticEffect)localObject2).copyPAGEffectFrom();
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVEffectAutomaticEffect)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((TAVEffectAutomaticEffect)localObject2).isClosingcredits()) && (((TAVEffectAutomaticEffect)localObject2).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG)) {
        return ((TAVEffectAutomaticEffect)localObject2).copyPAGEffectFrom();
      }
    }
    return null;
  }
  
  private TAVPagAutomaticEffect getOpeningEffect()
  {
    if (this.effectsModel == null) {
      return null;
    }
    Object localObject1 = this.effectsModel.filterEffects;
    Object localObject2 = this.effectsModel.overlayEffects;
    if (CollectionUtil.isEmptyList((List)localObject1))
    {
      if (CollectionUtil.isEmptyList((List)localObject2)) {
        return null;
      }
      localObject1 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (TAVEffectAutomaticEffect)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (!((TAVEffectAutomaticEffect)localObject2).isOpeningCredits()) || (((TAVEffectAutomaticEffect)localObject2).getEffectType() != TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG));
      return ((TAVEffectAutomaticEffect)localObject2).copyPAGEffectFrom();
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVEffectAutomaticEffect)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((TAVEffectAutomaticEffect)localObject2).isOpeningCredits()) && (((TAVEffectAutomaticEffect)localObject2).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG)) {
        return ((TAVEffectAutomaticEffect)localObject2).copyPAGEffectFrom();
      }
    }
    return null;
  }
  
  private TAVMovieSticker imageMovieSticker(int paramInt)
  {
    if (TextUtils.isEmpty(this.imagePagAssetDir)) {}
    TAVMovieSticker localTAVMovieSticker;
    TAVSticker localTAVSticker;
    do
    {
      do
      {
        return null;
        localTAVMovieSticker = new TAVMovieSticker(this.imagePagAssetDir + "/" + String.valueOf(paramInt) + ".pag", true);
      } while (localTAVMovieSticker == null);
      localTAVSticker = localTAVMovieSticker.getSticker();
    } while (localTAVSticker == null);
    localTAVSticker.setScale(1.0F);
    localTAVSticker.setCenterY(0.5F);
    localTAVSticker.setCenterX(0.5F);
    return localTAVMovieSticker;
  }
  
  private void setAllDirs(String paramString)
  {
    if (this.musicResource != null) {
      this.musicResource.setFileDir(paramString);
    }
    if (this.effectsModel != null) {
      this.effectsModel.setAllFileDir(paramString);
    }
    if ((this.rhythmEffectsGroup != null) && (!this.rhythmEffectsGroup.isEmpty()))
    {
      Iterator localIterator = this.rhythmEffectsGroup.iterator();
      while (localIterator.hasNext()) {
        ((TAVRhythmEffects)localIterator.next()).setFileDir(paramString);
      }
    }
  }
  
  private boolean shouldApplyClosingCredits(@NonNull TAVMovie paramTAVMovie, float paramFloat)
  {
    if (paramFloat < 5000.0F) {
      return false;
    }
    if ((paramTAVMovie.getClips() == null) || (paramTAVMovie.getClips().size() == 0)) {
      return false;
    }
    if ((paramTAVMovie.getClips().size() == 1) && (((TAVMovieClip)paramTAVMovie.getClips().get(0)).getResource().getType() == TAVMovieResource.TAVResourceType.TAVResourceTypePhoto)) {
      return false;
    }
    paramTAVMovie = getOpeningEffect();
    if (paramTAVMovie == null) {}
    for (float f = 0.0F;; f = paramTAVMovie.getStickerDuration().getTimeSeconds())
    {
      paramTAVMovie = getClosingEffect();
      if (paramTAVMovie != null) {
        break;
      }
      return false;
    }
    return (f + paramTAVMovie.getStickerDuration().getTimeSeconds()) * 1000.0F <= paramFloat;
  }
  
  private void videoEffectApplyToComposition(@NonNull TAVComposition paramTAVComposition, boolean paramBoolean, long paramLong)
  {
    if (CollectionUtil.isEmptyList(paramTAVComposition.getVideoChannels())) {}
    for (;;)
    {
      return;
      Object localObject;
      if ((this.effectsModel != null) && (!CollectionUtil.isEmptyList(this.effectsModel.filterEffects)))
      {
        paramTAVComposition = this.effectsModel.filterEffects.iterator();
        while (paramTAVComposition.hasNext())
        {
          localObject = (TAVEffectAutomaticEffect)paramTAVComposition.next();
          if ((!isRhythmTemplate()) || ((((TAVEffectAutomaticEffect)localObject).getRhythmEffectType() != 1) && (((TAVEffectAutomaticEffect)localObject).getRhythmEffectType() != 2))) {
            if (((TAVEffectAutomaticEffect)localObject).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT)
            {
              localObject = ((TAVEffectAutomaticEffect)localObject).copyLUTEffectFrom();
              this.lutFilters.add(((TAVLUTAutomaticEffect)localObject).convertToMovieFilter());
            }
            else if (((TAVEffectAutomaticEffect)localObject).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG)
            {
              localObject = ((TAVEffectAutomaticEffect)localObject).copyPAGEffectFrom();
              if (((TAVPagAutomaticEffect)localObject).isOpeningCredits())
              {
                if (isOpeningEffectEnable()) {
                  addFilterSticker((TAVPagAutomaticEffect)localObject, paramLong);
                }
              }
              else if (((TAVPagAutomaticEffect)localObject).isClosingcredits())
              {
                if (paramBoolean) {
                  addFilterSticker((TAVPagAutomaticEffect)localObject, paramLong);
                }
              }
              else {
                addFilterSticker((TAVPagAutomaticEffect)localObject, paramLong);
              }
            }
          }
        }
      }
      if ((this.effectsModel != null) && (!CollectionUtil.isEmptyList(this.effectsModel.overlayEffects)))
      {
        paramTAVComposition = this.effectsModel.overlayEffects.iterator();
        while (paramTAVComposition.hasNext())
        {
          localObject = (TAVEffectAutomaticEffect)paramTAVComposition.next();
          if (((TAVEffectAutomaticEffect)localObject).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG)
          {
            localObject = ((TAVEffectAutomaticEffect)localObject).copyPAGEffectFrom().convertToMovieStickerWithDuraton((float)paramLong);
            if ((localObject != null) && (((TAVMovieSticker)localObject).getSticker() != null)) {
              this.overlayStickers.add(((TAVMovieSticker)localObject).getSticker());
            }
          }
        }
      }
    }
  }
  
  private void volumeEffectApplyToClip(List<TAVVolumeAutomaticEffect> paramList, TAVClip paramTAVClip, float paramFloat)
  {
    if ((!CollectionUtil.isEmptyList(paramList)) && (paramTAVClip != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TAVAudioConfiguration.VolumeEdge localVolumeEdge = ((TAVVolumeAutomaticEffect)paramList.next()).convertToAudioVolumeEdge(paramFloat);
        if (localVolumeEdge != null)
        {
          CMTimeRange localCMTimeRange = CMTimeRange.getIntersection(paramTAVClip.getTimeRange(), localVolumeEdge.getTimeRange());
          if (paramTAVClip.getTimeRange().containsTimeRange(localVolumeEdge.getTimeRange()))
          {
            paramTAVClip.getAudioConfiguration().addVolumeEdge(localVolumeEdge);
          }
          else if (!CMTimeRange.CMTimeRangeInvalid.equals(localCMTimeRange))
          {
            float f1 = localCMTimeRange.getStart().sub(localVolumeEdge.getTimeRange().getStart()).getTimeSeconds() / localVolumeEdge.getTimeRange().getDuration().getTimeSeconds();
            float f2 = localVolumeEdge.getStartVolume();
            float f3 = localVolumeEdge.getEndVolume();
            float f4 = localVolumeEdge.getStartVolume();
            float f5 = localCMTimeRange.getEnd().sub(localVolumeEdge.getTimeRange().getStart()).getTimeSeconds() / localVolumeEdge.getTimeRange().getDuration().getTimeSeconds();
            float f6 = localVolumeEdge.getStartVolume();
            float f7 = localVolumeEdge.getEndVolume();
            float f8 = localVolumeEdge.getStartVolume();
            localVolumeEdge.setTimeRange(new CMTimeRange(localCMTimeRange.getStart().sub(paramTAVClip.getStartTime()), localCMTimeRange.getDuration()));
            localVolumeEdge.setStartVolume(f1 * (f3 - f4) + f2);
            localVolumeEdge.setEndVolume(f5 * (f7 - f8) + f6);
            paramTAVClip.getAudioConfiguration().addVolumeEdge(localVolumeEdge);
          }
        }
      }
    }
  }
  
  public void addExtraFilterSticker(List<TAVSticker> paramList, CMTime paramCMTime) {}
  
  public void addExtraOverlaySticker(List<TAVSticker> paramList, CMTime paramCMTime) {}
  
  public void appendDebugInfo(String paramString)
  {
    this.debugInfo.append("\n");
    this.debugInfo.append("\n");
    this.debugInfo.append(paramString);
  }
  
  public void applyTimeEffectToComposition(TAVComposition paramTAVComposition) {}
  
  public TAVComposition buildBaseComposition(@NonNull TAVMovie paramTAVMovie)
  {
    this.buildFromSegmentCache = false;
    parseToMovie(paramTAVMovie);
    TAVComposition localTAVComposition = buildCompostion(paramTAVMovie);
    applyTimeEffectToComposition(localTAVComposition);
    if (!isRhythmTemplate()) {
      transitionApplyToComposition(localTAVComposition);
    }
    long l = calculateTotalTime(localTAVComposition).getTimeUs() / 1000L;
    effectApplyToClip(localTAVComposition);
    audioChannelsApplyEffect(localTAVComposition, (float)l);
    bgmApplyEffectToComposition(localTAVComposition, (float)l);
    videoEffectApplyToComposition(localTAVComposition, shouldApplyClosingCredits(paramTAVMovie, (float)l), l);
    addExtraFilterSticker(this.filterStickers, new CMTime((float)l / 1000.0F));
    addExtraOverlaySticker(this.overlayStickers, new CMTime((float)l / 1000.0F));
    return localTAVComposition;
  }
  
  public TAVComposition buildBaseComposition(TAVMovie paramTAVMovie, List<TAVRhythmMovieSegment> paramList)
  {
    this.buildFromSegmentCache = true;
    parseToMovie(paramTAVMovie);
    paramList = buildCompositionFromSegments(paramTAVMovie, paramList);
    long l = calculateTotalTime(paramList).getTimeUs() / 1000L;
    effectApplyToClip(paramList);
    audioChannelsApplyEffect(paramList, (float)l);
    bgmApplyEffectToComposition(paramList, (float)l);
    videoEffectApplyToComposition(paramList, shouldApplyClosingCredits(paramTAVMovie, (float)l), l);
    addExtraFilterSticker(this.filterStickers, new CMTime((float)l / 1000.0F));
    addExtraOverlaySticker(this.overlayStickers, new CMTime((float)l / 1000.0F));
    return paramList;
  }
  
  public TAVComposition buildCompositionFromMovie(@NonNull TAVMovie paramTAVMovie)
  {
    clearDebugInfo();
    paramTAVMovie = buildBaseComposition(paramTAVMovie);
    TAVMovieFilterChainContext localTAVMovieFilterChainContext = new TAVMovieFilterChainContext();
    Object localObject;
    if ((this.lutFilters != null) && (!this.lutFilters.isEmpty()))
    {
      localObject = this.lutFilters.iterator();
      while (((Iterator)localObject).hasNext()) {
        localTAVMovieFilterChainContext.addFilter((TAVMovieFilterProxy)((Iterator)localObject).next());
      }
    }
    if ((this.filterStickers.size() > 0) || (this.transitionStickers.size() > 0))
    {
      localObject = new TAVAutomaticRenderContext();
      ((TAVAutomaticRenderContext)localObject).setTransitionStickers(this.transitionStickers);
      ((TAVAutomaticRenderContext)localObject).setEffectStickers(this.filterStickers);
      ((TAVAutomaticRenderContext)localObject).readAllVideoTracks();
      paramTAVMovie.setVideoMixEffect(new TAVOneClickFilmStickerEffect((TAVAutomaticRenderContext)localObject));
    }
    if (this.overlayStickers.size() > 0)
    {
      localObject = new TAVAutomaticRenderContext();
      ((TAVStickerRenderContext)localObject).reloadStickers(this.overlayStickers);
      localTAVMovieFilterChainContext.addFilter(new TAVStickerOverlayEffect((TAVStickerRenderContext)localObject));
    }
    paramTAVMovie.setGlobalVideoEffect(localTAVMovieFilterChainContext);
    return paramTAVMovie;
  }
  
  public TAVComposition buildCompositionFromSegments(TAVMovie paramTAVMovie, List<TAVRhythmMovieSegment> paramList)
  {
    return null;
  }
  
  public TAVComposition buildCompostion(TAVMovie paramTAVMovie)
  {
    int i = 0;
    if (!paramTAVMovie.getTimeEffects().isEmpty()) {}
    for (float f1 = ((TAVMovieTimeEffect)paramTAVMovie.getTimeEffects().get(0)).getSpeed();; f1 = 1.0F)
    {
      TAVComposition localTAVComposition = new TAVComposition();
      localTAVComposition.setRenderSize(this.renderSize);
      localTAVComposition.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
      long l = 0L;
      ArrayList localArrayList = new ArrayList();
      while (i < paramTAVMovie.getClips().size())
      {
        TAVClip localTAVClip = ((TAVMovieClip)paramTAVMovie.getClips().get(i)).convertToClip();
        TAVRhythmTimeEffectUtils.covertTAVClipTimeScale(localTAVClip);
        if ((f1 != 1.0F) && (f1 > 0.0F))
        {
          TAVResource localTAVResource = localTAVClip.getResource();
          localTAVResource.setScaledDuration(localTAVResource.getSourceTimeRange().getDuration().divide(f1));
        }
        localTAVClip.putExtraTrackInfo("trackIndex", Integer.valueOf(i));
        localTAVClip.setStartTime(new CMTime(l));
        localArrayList.add(localTAVClip);
        float f2 = (float)l;
        l = ((float)localTAVClip.getDuration().getTimeUs() / 1000.0F + f2);
        i += 1;
      }
      if (!localArrayList.isEmpty())
      {
        localTAVComposition.addAudioChannel(localArrayList);
        localTAVComposition.addVideoChannel(localArrayList);
      }
      return localTAVComposition;
    }
  }
  
  public CMTime calculateTotalTime(TAVComposition paramTAVComposition)
  {
    Object localObject1 = paramTAVComposition.getVideoChannels();
    paramTAVComposition = CMTime.CMTimeZero;
    Iterator localIterator = ((List)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (List)localIterator.next();
      localObject1 = CMTime.CMTimeZero;
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localObject1 = ((CMTime)localObject1).add(((TAVClip)((Iterator)localObject2).next()).getResource().getScaledDuration());
      }
      if (!((CMTime)localObject1).bigThan(paramTAVComposition)) {
        break label101;
      }
      paramTAVComposition = (TAVComposition)localObject1;
    }
    label101:
    for (;;)
    {
      break;
      return paramTAVComposition;
    }
  }
  
  public void clearDebugInfo()
  {
    this.debugInfo.delete(0, this.debugInfo.length());
  }
  
  public void configMusic(String paramString1, String paramString2, float paramFloat)
  {
    if (this.musicResource == null) {
      this.musicResource = new TAVAdaptiveMovieClip();
    }
    this.musicResource.setFileName(paramString2);
    this.musicResource.setFileDir(paramString1);
    this.musicResource.setStartOffset(paramFloat);
  }
  
  public List<TAVMovieSegment> convertClips(List<TAVMovieClip> paramList)
  {
    if ((paramList != null) && (paramList.isEmpty())) {}
    return null;
  }
  
  public List<TAVSticker> getAllStickers()
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtil.isEmptyList(this.filterStickers)) {
      localArrayList.addAll(this.filterStickers);
    }
    if (!CollectionUtil.isEmptyList(this.overlayStickers)) {
      localArrayList.addAll(localArrayList.size(), this.filterStickers);
    }
    return localArrayList;
  }
  
  public String getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public float getBgmVolume()
  {
    if (this.musicResource != null) {
      return this.musicResource.getVolume();
    }
    return 0.0F;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public StringBuilder getDebugInfo()
  {
    return this.debugInfo;
  }
  
  public TAVEffectsModel getEffectsModel()
  {
    return this.effectsModel;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public List<TAVSticker> getFilterStickers()
  {
    return this.filterStickers;
  }
  
  public List<String> getFontList()
  {
    return this.fontList;
  }
  
  public List<TAVMovieSticker> getImageEffects()
  {
    return this.imageEffects;
  }
  
  public String getImagePagAssetDir()
  {
    return this.imagePagAssetDir;
  }
  
  public TAVLUTAutomaticEffect getLutEffect()
  {
    Object localObject = getEffectsModel();
    if ((localObject != null) && (!CollectionUtil.isEmptyList(((TAVEffectsModel)localObject).filterEffects)))
    {
      localObject = ((TAVEffectsModel)localObject).filterEffects.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVEffectAutomaticEffect localTAVEffectAutomaticEffect = (TAVEffectAutomaticEffect)((Iterator)localObject).next();
        if (((!isRhythmTemplate()) || ((localTAVEffectAutomaticEffect.getRhythmEffectType() != 1) && (localTAVEffectAutomaticEffect.getRhythmEffectType() != 2))) && (localTAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT)) {
          return localTAVEffectAutomaticEffect.copyLUTEffectFrom();
        }
      }
    }
    return null;
  }
  
  public List<TAVMovieFilterProxy> getLutFilter()
  {
    return this.lutFilters;
  }
  
  public List<TAVMovieClip> getMovieClips()
  {
    return null;
  }
  
  public TAVAdaptiveMovieClip getMusicResource()
  {
    return this.musicResource;
  }
  
  public List<TAVSticker> getOverlayStickers()
  {
    return this.overlayStickers;
  }
  
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public String getTemplateDir()
  {
    return this.templateDir;
  }
  
  public String getTemplateName()
  {
    return this.templateName;
  }
  
  public List<TAVTimeEffect> getTimeEffects()
  {
    return this.timeEffects;
  }
  
  public List<TAVSticker> getTransitionStickers()
  {
    return this.transitionStickers;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public boolean isOpeningEffectEnable()
  {
    return true;
  }
  
  public boolean isRhythmTemplate()
  {
    return false;
  }
  
  public void parseToMovie(@NonNull TAVMovie paramTAVMovie)
  {
    if ((paramTAVMovie == null) || (CollectionUtil.isEmptyList(paramTAVMovie.getClips()))) {
      return;
    }
    Iterator localIterator = paramTAVMovie.getClips().iterator();
    label26:
    TAVMovieClip localTAVMovieClip;
    Object localObject;
    TAVResource localTAVResource;
    while (localIterator.hasNext())
    {
      localTAVMovieClip = (TAVMovieClip)localIterator.next();
      localObject = localTAVMovieClip.getResource();
      if (localObject != null)
      {
        localTAVResource = ((TAVMovieResource)localObject).convertToResource();
        if (!(localTAVResource instanceof TAVImageTrackResource)) {
          break label246;
        }
      }
    }
    label114:
    label244:
    label246:
    for (int i = TAVBitmapUtils.readImagePreferRotation(((TAVImageTrackResource)localTAVResource).getPath());; i = 0)
    {
      float f2;
      float f1;
      if (i % 2 == 1)
      {
        f2 = ((TAVMovieResource)localObject).getNaturalSize().height;
        f1 = ((TAVMovieResource)localObject).getNaturalSize().width;
        if ((f2 <= 0.0F) || (f1 <= 0.0F)) {
          break label241;
        }
        f1 = f2 / f1;
        if (f1 <= this.fillScale) {
          localTAVMovieClip.getVideoConfiguration().setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
        }
      }
      for (;;)
      {
        if ((((TAVMovieResource)localObject).getType() != TAVMovieResource.TAVResourceType.TAVResourceTypePhoto) || (!(localObject instanceof TAVMovieImageResource))) {
          break label244;
        }
        localObject = (TAVMovieImageResource)localObject;
        if (f1 <= this.fillScale) {
          break label26;
        }
        localObject = ((TAVMovieImageResource)localObject).clone();
        ((TAVMovieImageResource)localObject).setImage(applyBackgroundEffect(((TAVMovieImageResource)localObject).getImage(), paramTAVMovie.getRenderSize()));
        localTAVMovieClip.setResource((TAVMovieResource)localObject);
        break label26;
        break;
        f2 = ((TAVMovieResource)localObject).getNaturalSize().width;
        f1 = ((TAVMovieResource)localObject).getNaturalSize().height;
        break label114;
        f1 = 0.0F;
      }
      break label26;
    }
  }
  
  public TAVSticker randomTransition()
  {
    Object localObject = (TAVTransitionAutomaticEffect)this.transitions.get((int)(Math.random() * this.transitions.size()));
    localObject = this.templateDir + File.separator + ((TAVTransitionAutomaticEffect)localObject).parameter.filePath;
    TAVMovieSticker localTAVMovieSticker = new TAVMovieSticker((String)localObject);
    if ((localTAVMovieSticker == null) || (localTAVMovieSticker.getSticker() == null)) {
      return null;
    }
    return new TAVMovieSticker((String)localObject).getSticker();
  }
  
  public void release()
  {
    if ((this.lutFilters != null) && (!this.lutFilters.isEmpty()))
    {
      Iterator localIterator = this.lutFilters.iterator();
      while (localIterator.hasNext()) {
        ((TAVMovieFilterProxy)localIterator.next()).release();
      }
    }
  }
  
  public void setBgmVolume(float paramFloat)
  {
    if (this.musicResource != null)
    {
      this.musicResource.setVolume(paramFloat);
      changeVolumeEffects(paramFloat, this.musicResource.getVolumeEffects());
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void setDebugInfo(StringBuilder paramStringBuilder)
  {
    this.debugInfo = paramStringBuilder;
  }
  
  public void setImagePagAssetDir(String paramString)
  {
    this.imagePagAssetDir = paramString;
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
  
  public void setTemplateDir(String paramString)
  {
    this.templateDir = paramString;
    setAllDirs(paramString);
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
    changeVolumeEffects(paramFloat, this.volumeEffects);
  }
  
  public void transitionApplyToComposition(TAVComposition paramTAVComposition)
  {
    long l1 = 0L;
    List localList = (List)paramTAVComposition.getVideoChannels().get(0);
    if ((localList == null) || (localList.size() <= 1)) {}
    for (;;)
    {
      return;
      if (!CollectionUtil.isEmptyList(this.transitions))
      {
        paramTAVComposition.getVideoChannels().clear();
        paramTAVComposition.getAudioChannels().clear();
        Object localObject1 = CMTime.CMTimeZero;
        Object localObject2 = null;
        ArrayList localArrayList2 = new ArrayList();
        int i = 0;
        if (i < localList.size())
        {
          TAVClip localTAVClip = (TAVClip)localList.get(i);
          ArrayList localArrayList1 = new ArrayList();
          TAVSticker localTAVSticker;
          if (i > 0)
          {
            localTAVSticker = randomTransition();
            if (localTAVSticker != null) {}
          }
          for (;;)
          {
            i += 1;
            break;
            long l2 = ((float)localTAVSticker.durationTime() / 1000.0F);
            CMTime localCMTime = new CMTime(l1 - l2, 1000);
            if (localCMTime.bigThan((CMTime)localObject1))
            {
              localArrayList1.add(new TAVClip(localCMTime));
              localTAVClip.setStartTime(localCMTime);
              localArrayList1.add(localTAVClip);
              l1 = l1 - l2 + localTAVClip.getDuration().getTimeUs() / 1000L;
              localTAVSticker.setTimeRange(new CMTimeRange(localCMTime, new CMTime(l2, 1000)));
              this.transitionStickers.add(localTAVSticker);
              localObject1 = localTAVSticker.getTimeRange().getEnd();
              localArrayList2.add(localArrayList1);
              localObject2 = localArrayList1;
            }
            for (;;)
            {
              break;
              ((List)localObject2).add(localTAVClip);
              l2 = localTAVClip.getDuration().getTimeUs() / 1000L;
              l1 += l2;
            }
            localArrayList1.add(localTAVClip);
            l1 += localTAVClip.getDuration().getTimeUs() / 1000L;
            localArrayList2.add(localArrayList1);
            localObject2 = localArrayList1;
          }
        }
        localObject1 = localArrayList2.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (List)((Iterator)localObject1).next();
          paramTAVComposition.addVideoChannel((List)localObject2);
          paramTAVComposition.addAudioChannel((List)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.TAVAutomaticTemplate
 * JD-Core Version:    0.7.0.1
 */