package com.tencent.autotemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.filter.TAVAspectFillEffect;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect;
import com.tencent.autotemplate.model.TAVAdaptiveMovieClip;
import com.tencent.autotemplate.model.TAVAspectFillModel;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect.TAVEffectType;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectsModel;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.autotemplate.model.TAVPagAutomaticEffect;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.model.TAVVolumeAutomaticEffect;
import com.tencent.autotemplate.model.bean.MaterialLimits;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.autotemplate.transition.FaceTransition;
import com.tencent.autotemplate.transition.TransitionEffectModel;
import com.tencent.autotemplate.transition.TransitionHelper;
import com.tencent.autotemplate.utils.RandomUtil;
import com.tencent.autotemplate.utils.TemplateUtils;
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
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
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
import java.util.ArrayList;
import java.util.Collection;
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
  public static transient boolean isMapping = false;
  public TAVAspectFillModel aspectFillModel;
  @SerializedName("backgroundColor")
  private String backgroundColor;
  private transient boolean buildFromSegmentCache;
  private transient Context context;
  private transient StringBuilder debugInfo = new StringBuilder();
  protected transient List<TAVPagAutomaticEffect> effectModelList = new ArrayList();
  @SerializedName("effects")
  protected TAVEffectsModel effectsModel;
  private transient ExtraData extraData;
  private transient List<FaceTransition> faceTransitions;
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
  @SerializedName("material_limit")
  protected MaterialLimits materialLimits;
  @SerializedName("bgm")
  protected TAVAdaptiveMovieClip musicResource;
  private transient List<TAVSticker> overlayStickers = new ArrayList();
  @SerializedName("preDetect")
  protected List<String> preDetect;
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
  protected transient List<TransitionEffectModel> transitionEffectModels = new ArrayList();
  private transient TransitionHelper transitionHelper;
  protected transient List<TAVSticker> transitionStickers = new ArrayList();
  @SerializedName("transitions")
  protected List<TAVTransitionAutomaticEffect> transitions;
  @SerializedName("version")
  private String version;
  @SerializedName("volume")
  private float volume;
  @SerializedName("volumeEffects")
  private List<TAVVolumeAutomaticEffect> volumeEffects;
  
  private void addEffectToClip(TAVClip paramTAVClip, CGSize paramCGSize)
  {
    Object localObject;
    if ((!isRhythmTemplate()) && (((paramTAVClip.getResource() instanceof TAVImageResource)) || ((paramTAVClip.getResource() instanceof TAVImageTrackResource))))
    {
      localObject = imageMovieSticker(RandomUtil.RandomInt(1, 5));
      if ((localObject != null) && (((TAVMovieSticker)localObject).getSticker() != null))
      {
        ((TAVMovieSticker)localObject).setTimeRange(paramTAVClip.getTimeRange());
        this.filterStickers.add(((TAVMovieSticker)localObject).getSticker());
      }
    }
    if (isNeedDefaultBlurEffectNote(paramTAVClip, paramTAVClip.getVideoConfiguration()))
    {
      localObject = new ArrayList();
      TAVTimeRangeAspectFillEffect localTAVTimeRangeAspectFillEffect = new TAVTimeRangeAspectFillEffect(paramCGSize);
      ((List)localObject).add(localTAVTimeRangeAspectFillEffect);
      this.aspectFillModel = new TAVAspectFillModel();
      this.aspectFillModel.renderSize = paramCGSize;
      if (!TextUtils.isEmpty(this.backgroundColor))
      {
        localTAVTimeRangeAspectFillEffect.setBgCIColor(this.backgroundColor);
        this.aspectFillModel.backgroundColor = this.backgroundColor;
      }
      paramCGSize = paramTAVClip.getVideoConfiguration().getEffects();
      paramCGSize.addAll((Collection)localObject);
      paramTAVClip.getVideoConfiguration().setEffects(paramCGSize);
    }
  }
  
  private void addFilterSticker(TAVPagAutomaticEffect paramTAVPagAutomaticEffect, long paramLong)
  {
    if (paramTAVPagAutomaticEffect != null)
    {
      if (paramLong <= 0L) {
        return;
      }
      TAVMovieSticker localTAVMovieSticker = paramTAVPagAutomaticEffect.convertToMovieStickerWithDuraton((float)paramLong);
      if ((localTAVMovieSticker != null) && (localTAVMovieSticker.getSticker() != null)) {
        addEffect(localTAVMovieSticker, paramTAVPagAutomaticEffect, this.filterStickers);
      }
    }
  }
  
  private CIImage applyBackgroundEffect(CIImage paramCIImage, CGSize paramCGSize)
  {
    CIImage localCIImage = paramCIImage;
    if (paramCIImage != null)
    {
      if (paramCGSize == null) {
        return paramCIImage;
      }
      if ((paramCGSize != null) && (paramCGSize.equals(paramCIImage.getSize()))) {
        return paramCIImage;
      }
      localCIImage = paramCIImage.imageByCompositingOverImage(new CIImage(paramCGSize));
    }
    return localCIImage;
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
    Object localObject1 = this.musicResource;
    if (localObject1 != null)
    {
      ((TAVAdaptiveMovieClip)localObject1).setFileDir(this.templateDir);
      Object localObject2 = paramTAVComposition.getAudios();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      this.musicResource.setDuration(paramFloat);
      localObject2 = this.musicResource.convertToMovieClip();
      if (localObject2 != null) {
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
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (List)((Iterator)localObject1).next();
      if (!CollectionUtil.isEmptyList((List)localObject2))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          addEffectToClip((TAVClip)((Iterator)localObject2).next(), paramTAVComposition.getRenderSize());
        }
      }
    }
  }
  
  private TAVPagAutomaticEffect getClosingEffect()
  {
    Object localObject1 = this.effectsModel;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = ((TAVEffectsModel)localObject1).filterEffects;
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
    Object localObject1 = this.effectsModel;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = ((TAVEffectsModel)localObject1).filterEffects;
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
    if (TextUtils.isEmpty(this.imagePagAssetDir)) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.imagePagAssetDir);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(String.valueOf(paramInt));
    ((StringBuilder)localObject).append(".pag");
    localObject = new TAVMovieSticker(((StringBuilder)localObject).toString(), true);
    TAVSticker localTAVSticker = ((TAVMovieSticker)localObject).getSticker();
    if (localTAVSticker != null)
    {
      localTAVSticker.setScale(1.0F);
      localTAVSticker.setCenterY(0.5F);
      localTAVSticker.setCenterX(0.5F);
      return localObject;
    }
    return null;
  }
  
  private boolean isNeedDefaultBlurEffectNote(TAVClip paramTAVClip, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    return (paramTAVClip.getExtraTrackInfo("extra_frame_info") == null) && (paramTAVVideoConfiguration.getContentMode() != TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill) && (isAddBlurEffectNote());
  }
  
  private void setAllDirs(String paramString)
  {
    Object localObject = this.musicResource;
    if (localObject != null) {
      ((TAVAdaptiveMovieClip)localObject).setFileDir(paramString);
    }
    localObject = this.effectsModel;
    if (localObject != null) {
      ((TAVEffectsModel)localObject).setAllFileDir(paramString);
    }
    localObject = this.rhythmEffectsGroup;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.rhythmEffectsGroup.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TAVRhythmEffects)((Iterator)localObject).next()).setFileDir(paramString);
      }
    }
  }
  
  private boolean shouldApplyClosingCredits(@NonNull TAVMovie paramTAVMovie, float paramFloat)
  {
    if (paramFloat < 5000.0F) {
      return false;
    }
    if (paramTAVMovie.getClips() != null)
    {
      if (paramTAVMovie.getClips().size() == 0) {
        return false;
      }
      if ((paramTAVMovie.getClips().size() == 1) && (((TAVMovieClip)paramTAVMovie.getClips().get(0)).getResource().getType() == TAVMovieResource.TAVResourceType.TAVResourceTypePhoto)) {
        return false;
      }
      paramTAVMovie = getOpeningEffect();
      float f;
      if (paramTAVMovie == null) {
        f = 0.0F;
      } else {
        f = paramTAVMovie.getStickerDuration().getTimeSeconds();
      }
      paramTAVMovie = getClosingEffect();
      if (paramTAVMovie == null) {
        return false;
      }
      return (f + paramTAVMovie.getStickerDuration().getTimeSeconds()) * 1000.0F <= paramFloat;
    }
    return false;
  }
  
  private void videoEffectApplyToComposition(@NonNull TAVComposition paramTAVComposition, boolean paramBoolean, long paramLong)
  {
    if (CollectionUtil.isEmptyList(paramTAVComposition.getVideoChannels())) {
      return;
    }
    paramTAVComposition = this.effectsModel;
    Object localObject;
    if ((paramTAVComposition != null) && (!CollectionUtil.isEmptyList(paramTAVComposition.filterEffects)))
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
    paramTAVComposition = this.effectsModel;
    if ((paramTAVComposition != null) && (!CollectionUtil.isEmptyList(paramTAVComposition.overlayEffects)))
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
            localVolumeEdge.setStartVolume(f2 + (f3 - f4) * f1);
            localVolumeEdge.setEndVolume(f6 + (f7 - f8) * f5);
            paramTAVClip.getAudioConfiguration().addVolumeEdge(localVolumeEdge);
          }
        }
      }
    }
  }
  
  protected void addEffect(TAVMovieSticker paramTAVMovieSticker, TAVPagAutomaticEffect paramTAVPagAutomaticEffect, List<TAVSticker> paramList)
  {
    if (isMapping)
    {
      paramTAVPagAutomaticEffect.setStartOffset(paramTAVMovieSticker.getTimeRange().getStartUs() / 1000L);
      paramTAVPagAutomaticEffect.setDuration(paramTAVMovieSticker.getTimeRange().getDurationUs() / 1000L);
      this.effectModelList.add(paramTAVPagAutomaticEffect);
      return;
    }
    paramList.add(paramTAVMovieSticker.getSticker());
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
    this.transitionHelper = new TransitionHelper(this.transitions, getExtraData(), this.templateDir, this.transitionStickers, getFaceTransitions());
    this.transitionHelper.setTransitionEffectModels(this.transitionEffectModels);
    this.transitionHelper.setTransitionApplyType(this.transitionApplyType);
    if ((!isRhythmTemplate()) && (this.transitionHelper.needTransition(localTAVComposition))) {
      this.transitionHelper.applyTransitionToComposition(localTAVComposition);
    }
    TemplateUtils.reloadChannels(localTAVComposition);
    long l = TemplateUtils.calculateTotalTime(localTAVComposition).getTimeUs() / 1000L;
    effectApplyToClip(localTAVComposition);
    float f = (float)l;
    audioChannelsApplyEffect(localTAVComposition, f);
    bgmApplyEffectToComposition(localTAVComposition, f);
    videoEffectApplyToComposition(localTAVComposition, shouldApplyClosingCredits(paramTAVMovie, f), l);
    paramTAVMovie = this.filterStickers;
    f /= 1000.0F;
    addExtraFilterSticker(paramTAVMovie, new CMTime(f));
    addExtraOverlaySticker(this.overlayStickers, new CMTime(f));
    return localTAVComposition;
  }
  
  public TAVComposition buildBaseComposition(TAVMovie paramTAVMovie, List<TAVRhythmMovieSegment> paramList)
  {
    this.buildFromSegmentCache = true;
    parseToMovie(paramTAVMovie);
    paramList = buildCompositionFromSegments(paramTAVMovie, paramList);
    TemplateUtils.reloadChannels(paramList);
    long l = TemplateUtils.calculateTotalTime(paramList).getTimeUs() / 1000L;
    effectApplyToClip(paramList);
    float f = (float)l;
    audioChannelsApplyEffect(paramList, f);
    bgmApplyEffectToComposition(paramList, f);
    videoEffectApplyToComposition(paramList, shouldApplyClosingCredits(paramTAVMovie, f), l);
    paramTAVMovie = this.filterStickers;
    f /= 1000.0F;
    addExtraFilterSticker(paramTAVMovie, new CMTime(f));
    addExtraOverlaySticker(this.overlayStickers, new CMTime(f));
    return paramList;
  }
  
  public TAVComposition buildCompositionFromMovie(@NonNull TAVMovie paramTAVMovie)
  {
    clearDebugInfo();
    paramTAVMovie = buildBaseComposition(paramTAVMovie);
    TAVMovieFilterChainContext localTAVMovieFilterChainContext = new TAVMovieFilterChainContext();
    Object localObject = this.lutFilters;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
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
      if (!isMapping) {
        ((TAVAutomaticRenderContext)localObject).setEffectStickers(this.filterStickers);
      }
      ((TAVAutomaticRenderContext)localObject).readAllVideoTracks();
      localObject = new TAVOneClickFilmStickerEffect((TAVAutomaticRenderContext)localObject);
      ((TAVOneClickFilmStickerEffect)localObject).setFaceTransitions(this.faceTransitions);
      paramTAVMovie.setVideoMixEffect((TAVVideoMixEffect)localObject);
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
    boolean bool = paramTAVMovie.getTimeEffects().isEmpty();
    int i = 0;
    float f;
    if (!bool) {
      f = ((TAVMovieTimeEffect)paramTAVMovie.getTimeEffects().get(0)).getSpeed();
    } else {
      f = 1.0F;
    }
    TAVComposition localTAVComposition = new TAVComposition();
    localTAVComposition.setRenderSize(this.renderSize);
    localTAVComposition.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
    long l = 0L;
    ArrayList localArrayList = new ArrayList();
    while (i < paramTAVMovie.getClips().size())
    {
      TAVClip localTAVClip = ((TAVMovieClip)paramTAVMovie.getClips().get(i)).convertToClip();
      TAVRhythmTimeEffectUtils.covertTAVClipTimeScale(localTAVClip);
      if ((f != 1.0F) && (f > 0.0F))
      {
        TAVResource localTAVResource = localTAVClip.getResource();
        localTAVResource.setScaledDuration(localTAVResource.getSourceTimeRange().getDuration().divide(f));
      }
      localTAVClip.putExtraTrackInfo("trackIndex", Integer.valueOf(i));
      localTAVClip.setStartTime(new CMTime(l, 1000));
      localArrayList.add(localTAVClip);
      l = ((float)l + (float)localTAVClip.getDuration().getTimeUs() / 1000.0F);
      i += 1;
    }
    if (!localArrayList.isEmpty())
    {
      localTAVComposition.addAudioChannel(localArrayList);
      localTAVComposition.addVideoChannel(localArrayList);
    }
    return localTAVComposition;
  }
  
  public void clearDebugInfo()
  {
    StringBuilder localStringBuilder = this.debugInfo;
    localStringBuilder.delete(0, localStringBuilder.length());
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
      localArrayList.addAll(localArrayList.size(), this.overlayStickers);
    }
    return localArrayList;
  }
  
  public String getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public float getBgmVolume()
  {
    TAVAdaptiveMovieClip localTAVAdaptiveMovieClip = this.musicResource;
    if (localTAVAdaptiveMovieClip != null) {
      return localTAVAdaptiveMovieClip.getVolume();
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
  
  public List<TAVPagAutomaticEffect> getEffectModelList()
  {
    return this.effectModelList;
  }
  
  public TAVEffectsModel getEffectsModel()
  {
    return this.effectsModel;
  }
  
  public ExtraData getExtraData()
  {
    if (this.extraData == null) {
      this.extraData = new ExtraData();
    }
    return this.extraData;
  }
  
  public List<FaceTransition> getFaceTransitions()
  {
    if (this.faceTransitions == null) {
      this.faceTransitions = new ArrayList();
    }
    return this.faceTransitions;
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
  
  public boolean getIsMapping()
  {
    return isMapping;
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
  
  public MaterialLimits getMaterialLimits()
  {
    return this.materialLimits;
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
  
  public List<String> getPreDetect()
  {
    return this.preDetect;
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
  
  public List<TransitionEffectModel> getTransitionEffectModels()
  {
    return this.transitionEffectModels;
  }
  
  public List<TAVSticker> getTransitionStickers()
  {
    return this.transitionStickers;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public boolean isAddBlurEffectNote()
  {
    return ConfigType.a;
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
    if (paramTAVMovie != null)
    {
      if (CollectionUtil.isEmptyList(paramTAVMovie.getClips())) {
        return;
      }
      Iterator localIterator = paramTAVMovie.getClips().iterator();
      while (localIterator.hasNext())
      {
        TAVMovieClip localTAVMovieClip = (TAVMovieClip)localIterator.next();
        Object localObject = localTAVMovieClip.getResource();
        if (localObject != null)
        {
          int i = 0;
          TAVResource localTAVResource = ((TAVMovieResource)localObject).convertToResource();
          if ((localTAVResource instanceof TAVImageTrackResource)) {
            i = TAVBitmapUtils.readImagePreferRotation(((TAVImageTrackResource)localTAVResource).getPath());
          }
          float f1;
          float f2;
          if (i % 2 == 1)
          {
            f1 = ((TAVMovieResource)localObject).getNaturalSize().height;
            f2 = ((TAVMovieResource)localObject).getNaturalSize().width;
          }
          else
          {
            f1 = ((TAVMovieResource)localObject).getNaturalSize().width;
            f2 = ((TAVMovieResource)localObject).getNaturalSize().height;
          }
          float f4 = 0.0F;
          float f3 = f4;
          if (f1 > 0.0F)
          {
            f3 = f4;
            if (f2 > 0.0F)
            {
              f1 /= f2;
              f3 = f1;
              if (f1 <= this.fillScale)
              {
                localTAVMovieClip.getVideoConfiguration().setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
                f3 = f1;
              }
            }
          }
          if ((((TAVMovieResource)localObject).getType() == TAVMovieResource.TAVResourceType.TAVResourceTypePhoto) && ((localObject instanceof TAVMovieImageResource)))
          {
            localObject = (TAVMovieImageResource)localObject;
            if (f3 > this.fillScale)
            {
              localObject = ((TAVMovieImageResource)localObject).clone();
              ((TAVMovieImageResource)localObject).setImage(applyBackgroundEffect(((TAVMovieImageResource)localObject).getImage(), paramTAVMovie.getRenderSize()));
              localTAVMovieClip.setResource((TAVMovieResource)localObject);
            }
          }
        }
      }
    }
  }
  
  public void release()
  {
    Object localObject = this.lutFilters;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.lutFilters.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TAVMovieFilterProxy)((Iterator)localObject).next()).release();
      }
    }
  }
  
  public void setBgmVolume(float paramFloat)
  {
    TAVAdaptiveMovieClip localTAVAdaptiveMovieClip = this.musicResource;
    if (localTAVAdaptiveMovieClip != null)
    {
      localTAVAdaptiveMovieClip.setVolume(paramFloat);
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
  
  public void setIsAddBlurEffectNote(boolean paramBoolean)
  {
    ConfigType.a = paramBoolean;
  }
  
  public void setMapping(boolean paramBoolean)
  {
    isMapping = paramBoolean;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.TAVAutomaticTemplate
 * JD-Core Version:    0.7.0.1
 */