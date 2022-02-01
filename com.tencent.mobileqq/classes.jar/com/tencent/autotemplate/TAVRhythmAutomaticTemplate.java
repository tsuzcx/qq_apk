package com.tencent.autotemplate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect.TAVEffectType;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectsModel;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.autotemplate.model.TAVPagAutomaticEffect;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.model.rhythm.TAVEffectPoint;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.autotemplate.model.rhythm.TAVTimeAutomaticEffect;
import com.tencent.autotemplate.parse.RhythmDataBean;
import com.tencent.autotemplate.parse.RhythmDataBean.PackedEffectPoints;
import com.tencent.autotemplate.transition.FaceTransition;
import com.tencent.autotemplate.transition.RhythmTransitionHelper;
import com.tencent.autotemplate.transition.RhythmTransitionParams;
import com.tencent.autotemplate.transition.TransitionEffectModel;
import com.tencent.autotemplate.transition.TransitionEffectParam;
import com.tencent.autotemplate.transition.TransitionUtils;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.autotemplate.utils.TAVMovieClipEx;
import com.tencent.autotemplate.utils.TemplateUtils;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.taveffect.utils.RandomUtils;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.autotemplate.TAVRhythmMovieSegment;>;
import java.util.List<Lcom.tencent.autotemplate.utils.TAVMovieClipEx;>;

public class TAVRhythmAutomaticTemplate
  extends TAVAutomaticTemplate
{
  public static final String BpmValueTrail = "BpmValueTrail";
  public static final String DefaultTrail = "DefalutTrail";
  public static final String DrumTrail = "DrumTrail";
  public static final String FastRhythmTrail = "FastRhythmTrail";
  public static final String HighlightValueTrail = "HighlightValueTrail";
  public static final long IMAGE_MIN_DURATION = 10000L;
  public static final String PuckingDrum = "PuckingDrum";
  private static final int SECONDS_MS = 1000;
  public static final String SlowRhythmTrail = "SlowRhythmTrail";
  public static final String StartValueTrail = "StartValueTrail";
  public static final String TAG = "TAVRhythmTemplate";
  public transient TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType adjustClipType = TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1;
  private transient List<TAVEffectPoint> bpmEffectPoints = new ArrayList();
  private transient List<TAVEffectPoint> drumEffectPoints = new ArrayList();
  private transient List<TAVEffectAutomaticEffect> highlightEffects = new ArrayList();
  private transient String highlightEffectsPath;
  private transient List<TAVEffectPoint> highlightPoints = new ArrayList();
  private transient boolean isRhythmTemplate;
  private transient List<TAVRhythmMovieSegment> mCorrectSegments = new ArrayList();
  private transient int mTransitionLoopIndex = 0;
  private transient CMTime maxDuration = new CMTime(2147483647L, 1000);
  private transient CMTime maxVideoDuration = new CMTime(60000L, 1000);
  private transient TAVMovie movie;
  private transient CMTime musicRealStart = CMTime.CMTimeZero;
  private transient int randomIndex;
  private transient TAVRhythmAutomaticTemplate.TAVRhythmRandomType randomType;
  private transient String rhythmEffectID;
  private transient TAVRhythmEffects rhythmEffects;
  private RhythmTransitionHelper rhythmTransitionHelper;
  public transient TAVRhythmAutomaticTemplate.TAVRhythmEffectType rhythmType = TAVRhythmAutomaticTemplate.TAVRhythmEffectType.TAVRhythmBPMChannel;
  private transient List<List<TAVEffectAutomaticEffect>> secondApplyEffects = new ArrayList();
  private transient List<Integer> secondApplyEffectsRandomIndices = new ArrayList();
  private transient List<TAVEffectPoint> secondEffectPoints = new ArrayList();
  public transient TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType secondEffectType = TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix;
  private transient List<List<TAVEffectAutomaticEffect>> secondEffects = new ArrayList();
  private transient String secondEffectsPath;
  private transient List<TAVRhythmMovieSegment> segments = new ArrayList();
  private transient boolean singleResource;
  private transient List<TAVEffectPoint> slowEffectPoints = new ArrayList();
  private transient CMTime start = CMTime.CMTimeZero;
  
  private void addOverLayTimeToClip(CMTime paramCMTime, TAVMovieResource paramTAVMovieResource)
  {
    CMTimeRange localCMTimeRange = paramTAVMovieResource.getTimeRange();
    if ((paramTAVMovieResource instanceof TAVMovieImageResource))
    {
      localCMTimeRange.setDuration(localCMTimeRange.getDuration().add(paramCMTime));
      paramTAVMovieResource.setDuration(localCMTimeRange.getDuration());
      return;
    }
    localCMTimeRange.setStart(localCMTimeRange.getStart().sub(paramCMTime));
    localCMTimeRange.setDuration(localCMTimeRange.getDuration().add(paramCMTime));
    paramTAVMovieResource.setDuration(localCMTimeRange.getDuration());
  }
  
  private void applyTimeEffectToEffectPoint(TAVComposition paramTAVComposition)
  {
    List localList = (List)paramTAVComposition.getVideoChannels().get(0);
    CMTime localCMTime = TemplateUtils.calculateTotalTime(paramTAVComposition);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.secondApplyEffects.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
      {
        Object localObject = (TAVEffectAutomaticEffect)localIterator2.next();
        if (((TAVEffectAutomaticEffect)localObject).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime)
        {
          localObject = ((TAVEffectAutomaticEffect)localObject).copyTimeEffectFrom();
          TAVMovieTimeEffect localTAVMovieTimeEffect = ((TAVTimeAutomaticEffect)localObject).convertToMovieTimeEffect(localCMTime.getTimeSeconds() * 1000.0F);
          localArrayList.add(localTAVMovieTimeEffect);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("add time effect to effect point at:");
          localStringBuilder.append(((TAVTimeAutomaticEffect)localObject).getStartOffset());
          localStringBuilder.append(" ,speed:");
          localStringBuilder.append(localTAVMovieTimeEffect.getSpeed());
          appendDebugInfo(localStringBuilder.toString());
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    if (this.singleResource) {
      localList = TAVRhythmTimeEffectUtils.applyTimeEffectsInPreviewTimeline(localList, localArrayList);
    } else {
      localList = TAVRhythmTimeEffectWithCutUtils.applyTimeEffectsInPreviewTimeline(localList, localArrayList, covertTAVEffectPointsToCMTimes(this.secondEffectPoints));
    }
    paramTAVComposition.getVideoChannels().remove(0);
    paramTAVComposition.getVideoChannels().add(0, localList);
  }
  
  private void applyTimeEffectToHighlightPoint(TAVComposition paramTAVComposition)
  {
    if (!this.singleResource) {
      return;
    }
    Iterator localIterator = this.highlightEffects.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (TAVEffectAutomaticEffect)localIterator.next();
      if ((localObject1 != null) && (((TAVEffectAutomaticEffect)localObject1).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime) && (!this.highlightPoints.isEmpty()))
      {
        Object localObject2 = ((TAVEffectAutomaticEffect)localObject1).copyTimeEffectFrom();
        localObject1 = (List)paramTAVComposition.getVideoChannels().get(0);
        long l = 0L;
        Object localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          CMTime localCMTime = ((TAVClip)((Iterator)localObject3).next()).getResource().getScaledDuration();
          l = ((float)l + localCMTime.getTimeSeconds() * 1000.0F);
        }
        float f1 = (float)((TAVEffectPoint)this.highlightPoints.get(0)).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F;
        ((TAVTimeAutomaticEffect)localObject2).setStartOffset(f1);
        float f2 = (float)l;
        ((TAVTimeAutomaticEffect)localObject2).setDuration(((f2 - f1) / ((TAVTimeAutomaticEffect)localObject2).getSpeed()));
        localObject2 = ((TAVTimeAutomaticEffect)localObject2).convertToMovieTimeEffect(f2);
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject2);
        localObject1 = TAVRhythmTimeEffectUtils.applyTimeEffectsInPreviewTimeline((List)localObject1, (List)localObject3);
        paramTAVComposition.getVideoChannels().remove(0);
        paramTAVComposition.getVideoChannels().add(0, localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("add time effect to hightlight at: ");
        ((StringBuilder)localObject1).append(f1);
        ((StringBuilder)localObject1).append(" ,speed:");
        ((StringBuilder)localObject1).append(((TAVMovieTimeEffect)localObject2).getSpeed());
        appendDebugInfo(((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void applyTransitionToSegment(TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect, TAVSticker paramTAVSticker, CMTime paramCMTime, long paramLong, int paramInt)
  {
    if (paramTAVTransitionAutomaticEffect.isFaceTransition())
    {
      paramTAVSticker = new CMTimeRange(paramCMTime, new CMTime(paramLong, 1000));
      paramCMTime = new FaceTransition();
      paramCMTime.timeRange = paramTAVSticker;
      paramCMTime.procMethod = paramTAVTransitionAutomaticEffect.getProcMethod();
      getFaceTransitions().add(paramCMTime);
      return;
    }
    TAVSticker localTAVSticker = paramTAVSticker;
    if (paramTAVSticker == null) {
      localTAVSticker = this.rhythmTransitionHelper.getTransitionSticker(paramTAVTransitionAutomaticEffect);
    }
    if (localTAVSticker != null)
    {
      TransitionEffectParam localTransitionEffectParam = TransitionUtils.getTransitionParams(localTAVSticker, paramTAVTransitionAutomaticEffect.effectId);
      if (isMapping) {
        paramTAVSticker = paramCMTime.add(localTransitionEffectParam.getOverlayTime()).sub(localTransitionEffectParam.getLeftTransitionTime());
      } else {
        paramTAVSticker = paramCMTime;
      }
      localTAVSticker.setTimeRange(new CMTimeRange(paramTAVSticker, CMTime.fromMs(paramLong)));
      paramTAVSticker = new TransitionEffectModel();
      paramTAVSticker.setEffectId(paramTAVTransitionAutomaticEffect.effectId);
      paramTAVSticker.setFilePath(localTAVSticker.getFilePath());
      paramTAVSticker.setStickerId(localTAVSticker.getStickerId());
      paramTAVSticker.setTransitionPosition(paramInt);
      paramTAVSticker.setLeftTransitionMs(localTransitionEffectParam.getLeftTransitionTime().getTimeUs() / 1000L);
      paramTAVSticker.setRightTransitionMs(localTransitionEffectParam.getRightTransitionTime().getTimeUs() / 1000L);
      paramTAVSticker.setOverlayTransitionMs(localTransitionEffectParam.getOverlayTime().getTimeUs() / 1000L);
      paramTAVSticker.setTimeRange(localTAVSticker.getTimeRange());
      this.transitionEffectModels.add(paramTAVSticker);
      if (TAVAutomaticTemplate.isMapping) {
        localTAVSticker.getExtraBundle().putString("key_extra_sticker_type", "sticker_video_transition");
      }
      this.transitionStickers.add(localTAVSticker);
      paramTAVTransitionAutomaticEffect = new StringBuilder();
      paramTAVTransitionAutomaticEffect.append("add transition sticker ");
      paramTAVTransitionAutomaticEffect.append(localTAVSticker.getFilePath());
      paramTAVTransitionAutomaticEffect.append(", start offset: ");
      paramTAVTransitionAutomaticEffect.append(paramCMTime);
      appendDebugInfo(paramTAVTransitionAutomaticEffect.toString());
    }
  }
  
  private List<TAVRhythmMovieSegment> buildSegmentsFromClips(List<TAVMovieClipEx> paramList)
  {
    Log.i("TAVRhythmTemplate", "buildSegmentsFromClips: ");
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = CMTime.CMTimeZero;
    Object localObject4 = CMTime.CMTimeZero;
    this.mTransitionLoopIndex = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    Object localObject3 = localObject1;
    int i = 0;
    paramList = (List<TAVMovieClipEx>)localObject4;
    while (localIterator.hasNext())
    {
      TAVMovieClipEx localTAVMovieClipEx = (TAVMovieClipEx)localIterator.next();
      CMTime localCMTime = localTAVMovieClipEx.getTavMovieClip().getResource().getTimeRange().getDuration();
      localObject4 = new TAVRhythmMovieSegment();
      ((TAVRhythmMovieSegment)localObject4).setTimeRange(new CMTimeRange(paramList, localCMTime));
      int j = i;
      if (!this.rhythmTransitionHelper.getTransitionDurationMsList().isEmpty())
      {
        if (TAVAutomaticTemplate.isMapping) {
          i = handleTransitionsForSegment(i, localTAVMovieClipEx, (TAVMovieClipEx)localObject1, paramList, (CMTime)localObject2, localCMTime, (TAVRhythmMovieSegment)localObject4, localObject3);
        } else {
          i = handleTransitionForSegment(i, localTAVMovieClipEx, (TAVMovieClipEx)localObject1, paramList, (CMTime)localObject2, localCMTime, (TAVRhythmMovieSegment)localObject4, localObject3);
        }
        j = i;
      }
      localObject1 = new ArrayList();
      ((List)localObject1).add(localTAVMovieClipEx.getTavMovieClip());
      ((TAVRhythmMovieSegment)localObject4).setTavMovieClips((List)localObject1);
      localArrayList.add(localObject4);
      paramList = paramList.add(localCMTime);
      localObject1 = localTAVMovieClipEx;
      localObject2 = localCMTime;
      localObject3 = localObject4;
      i = j;
    }
    fillSegmentTAVClip(localArrayList);
    fillSegmentTimeEffect(localArrayList);
    return localArrayList;
  }
  
  private void checkRhythmTransitionHelper()
  {
    if (this.rhythmTransitionHelper == null) {
      createRhythmTransitionHelper();
    }
  }
  
  private void clearLastPoints()
  {
    this.highlightPoints.clear();
    this.bpmEffectPoints.clear();
    this.slowEffectPoints.clear();
    this.drumEffectPoints.clear();
    this.secondEffectPoints.clear();
    this.segments.clear();
    this.mCorrectSegments.clear();
  }
  
  private void configMusic(String paramString, float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      configMusic("", paramString, this.start.getTimeSeconds() * 1000.0F);
      return;
    }
    configMusic("", paramString, paramFloat);
  }
  
  private void configMusicSecondEffects()
  {
    this.secondApplyEffects.clear();
    if (!this.singleResource) {
      return;
    }
    if (this.highlightPoints.isEmpty()) {
      return;
    }
    if ((!this.secondEffects.isEmpty()) && (!this.secondEffectPoints.isEmpty()))
    {
      Iterator localIterator = this.secondEffectPoints.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        long l = ((float)((TAVEffectPoint)localIterator.next()).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F);
        if ((l > 0L) && ((float)l < this.maxVideoDuration.getTimeSeconds() * 1000.0F))
        {
          ArrayList localArrayList = new ArrayList();
          Object localObject = null;
          if (this.secondEffectType == TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectSpeed)
          {
            localObject = getTimeEffectFromEffectsGroup(this.secondEffects, false);
          }
          else if (this.secondEffectType == TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectFreeze)
          {
            localObject = getTimeEffectFromEffectsGroup(this.secondEffects, true);
          }
          else if (this.secondEffectType == TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix)
          {
            int j;
            if (i < this.secondApplyEffectsRandomIndices.size()) {
              j = ((Integer)this.secondApplyEffectsRandomIndices.get(i)).intValue();
            } else {
              j = RandomUtils.randomInt(0, this.secondEffects.size());
            }
            localObject = (List)this.secondEffects.get(j);
          }
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TAVEffectAutomaticEffect localTAVEffectAutomaticEffect = ((TAVEffectAutomaticEffect)((Iterator)localObject).next()).copy();
            localTAVEffectAutomaticEffect.setStartOffset(l);
            localArrayList.add(localTAVEffectAutomaticEffect);
          }
          this.secondApplyEffects.add(localArrayList);
          i += 1;
        }
      }
    }
  }
  
  private void configSegments()
  {
    Object localObject2 = CMTime.CMTimeZero;
    CMTime localCMTime = this.maxVideoDuration;
    Object localObject1 = this.randomType;
    Object localObject3 = TAVRhythmAutomaticTemplate.TAVRhythmRandomType.TAVRhythmMultiPicSlow;
    int j = 0;
    int i;
    if (localObject1 == localObject3)
    {
      localObject1 = this.slowEffectPoints;
      i = 1;
    }
    else
    {
      localObject1 = this.drumEffectPoints;
      i = 0;
    }
    while (j < ((List)localObject1).size())
    {
      Object localObject4 = (TAVEffectPoint)((List)localObject1).get(j);
      if (!TextUtils.equals(((TAVEffectPoint)localObject4).getType(), "PuckingDrum"))
      {
        localObject3 = localObject2;
        if (i == 0) {}
      }
      else
      {
        localObject3 = new CMTime(((TAVEffectPoint)localObject4).getTime(), 1000);
        if (((CMTime)localObject2).bigThan(localCMTime)) {
          break;
        }
        if (((CMTime)localObject2).equals(localCMTime)) {
          return;
        }
        if (!((CMTime)localObject3).bigThan(this.musicRealStart))
        {
          localObject3 = localObject2;
        }
        else
        {
          localObject4 = ((CMTime)localObject3).sub(this.musicRealStart).sub((CMTime)localObject2);
          localObject3 = localObject4;
          if (((CMTime)localObject2).add((CMTime)localObject4).bigThan(localCMTime)) {
            localObject3 = localCMTime.sub((CMTime)localObject2);
          }
          localObject4 = new TAVRhythmMovieSegment();
          ((TAVRhythmMovieSegment)localObject4).setTimeRange(new CMTimeRange((CMTime)localObject2, (CMTime)localObject3));
          this.segments.add(localObject4);
          ArrayList localArrayList = new ArrayList();
          TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
          localTAVMovieTimeEffect.setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject3));
          localTAVMovieTimeEffect.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject3));
          localArrayList.add(localTAVMovieTimeEffect);
          ((TAVRhythmMovieSegment)localObject4).setTimeEffects(localArrayList);
          localObject3 = ((CMTime)localObject2).add((CMTime)localObject3);
        }
      }
      j += 1;
      localObject2 = localObject3;
    }
  }
  
  private void correctSegments(List<TAVRhythmMovieSegment> paramList)
  {
    this.mCorrectSegments.addAll(paramList);
    int i = 0;
    Object localObject1;
    while (i < this.mCorrectSegments.size())
    {
      paramList = (TAVRhythmMovieSegment)this.mCorrectSegments.get(i);
      paramList.setIndex(i);
      if (i == this.mCorrectSegments.size() - 1) {
        break;
      }
      localObject1 = this.mCorrectSegments;
      i += 1;
      TAVRhythmMovieSegment localTAVRhythmMovieSegment = (TAVRhythmMovieSegment)((List)localObject1).get(i);
      paramList = paramList.getTimeRange();
      localObject1 = paramList.getEnd();
      Object localObject2 = localTAVRhythmMovieSegment.getTimeRange();
      CMTime localCMTime = ((CMTimeRange)localObject2).getStart();
      localObject2 = ((CMTimeRange)localObject2).getEnd();
      if (paramList.containsTime(localCMTime))
      {
        paramList = (List<TAVRhythmMovieSegment>)localObject1;
        if (((CMTime)localObject1).bigThan((CMTime)localObject2)) {
          paramList = (List<TAVRhythmMovieSegment>)localObject2;
        }
        localTAVRhythmMovieSegment.setOverlapTimeRange(new CMTimeRange(localCMTime, paramList.sub(localCMTime)));
        localTAVRhythmMovieSegment.setCorrectStartTime(localCMTime.add(paramList.sub(localCMTime).divide(2.0F)));
      }
      else
      {
        localTAVRhythmMovieSegment.setCorrectStartTime(localCMTime);
      }
    }
    paramList = this.mCorrectSegments.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (TAVRhythmMovieSegment)paramList.next();
      if ((localObject1 != null) && (((TAVRhythmMovieSegment)localObject1).getTavMovieClips() != null) && (!((TAVRhythmMovieSegment)localObject1).getTavMovieClips().isEmpty()) && (((TAVRhythmMovieSegment)localObject1).getTavClips() != null) && (!((TAVRhythmMovieSegment)localObject1).getTavClips().isEmpty()) && ((((TAVRhythmMovieSegment)localObject1).getOverlapTimeRange() == null) || (!((TAVRhythmMovieSegment)localObject1).getTimeRange().getEnd().smallThan(((TAVRhythmMovieSegment)localObject1).getOverlapTimeRange().getEnd())))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        paramList.remove();
      }
    }
  }
  
  private void createRhythmTransitionHelper()
  {
    RhythmTransitionParams localRhythmTransitionParams = new RhythmTransitionParams();
    localRhythmTransitionParams.templateDir = this.templateDir;
    localRhythmTransitionParams.extraData = getExtraData();
    localRhythmTransitionParams.rhythmEffects = this.rhythmEffects;
    localRhythmTransitionParams.transitionApplyType = this.transitionApplyType;
    localRhythmTransitionParams.transThreshold = this.transThreshold;
    this.rhythmTransitionHelper = new RhythmTransitionHelper(localRhythmTransitionParams);
  }
  
  private void fillAllChannelPoints(RhythmDataBean paramRhythmDataBean)
  {
    paramRhythmDataBean = paramRhythmDataBean.allData.iterator();
    while (paramRhythmDataBean.hasNext())
    {
      Object localObject1 = (RhythmDataBean.PackedEffectPoints)paramRhythmDataBean.next();
      if ((localObject1 != null) && (((RhythmDataBean.PackedEffectPoints)localObject1).name != null) && (((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints != null))
      {
        Object localObject2 = ((RhythmDataBean.PackedEffectPoints)localObject1).name;
        int i = -1;
        switch (((String)localObject2).hashCode())
        {
        default: 
          break;
        case 820031028: 
          if (((String)localObject2).equals("BpmValueTrail")) {
            i = 2;
          }
          break;
        case -1142061521: 
          if (((String)localObject2).equals("SlowRhythmTrail")) {
            i = 3;
          }
          break;
        case -1358596873: 
          if (((String)localObject2).equals("StartValueTrail")) {
            i = 1;
          }
          break;
        case -1704423735: 
          if (((String)localObject2).equals("HighlightValueTrail")) {
            i = 0;
          }
          break;
        case -1870542368: 
          if (((String)localObject2).equals("DrumTrail")) {
            i = 4;
          }
          break;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 4)
                {
                  this.drumEffectPoints.addAll(((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints);
                  sortPoints(this.drumEffectPoints);
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("init DrumTrail, size:");
                  ((StringBuilder)localObject1).append(this.drumEffectPoints.size());
                  Log.i("TAVRhythmTemplate", ((StringBuilder)localObject1).toString());
                }
              }
              else
              {
                this.slowEffectPoints.addAll(((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints);
                sortPoints(this.slowEffectPoints);
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("init SlowRhythmTrail, size:");
                ((StringBuilder)localObject1).append(this.slowEffectPoints.size());
                Log.i("TAVRhythmTemplate", ((StringBuilder)localObject1).toString());
              }
            }
            else
            {
              this.bpmEffectPoints.addAll(((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints);
              sortPoints(this.bpmEffectPoints);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("init BpmValueTrail, size:");
              ((StringBuilder)localObject1).append(this.bpmEffectPoints.size());
              Log.i("TAVRhythmTemplate", ((StringBuilder)localObject1).toString());
            }
          }
          else if ((((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints != null) && (!((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints.isEmpty()))
          {
            this.start = new CMTime(((TAVEffectPoint)((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints.get(0)).getTime(), 1000);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("init start time:");
            ((StringBuilder)localObject2).append(this.start.getTimeSeconds() * 1000.0F);
            Log.i("TAVRhythmTemplate", ((StringBuilder)localObject2).toString());
            if (((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints.size() > 1)
            {
              long l = ((TAVEffectPoint)((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints.get(1)).getTime() - ((TAVEffectPoint)((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints.get(0)).getTime();
              if (l > 0L) {
                this.maxDuration = new CMTime(l, 1000);
              } else {
                this.maxDuration = new CMTime(-l, 1000);
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("init max duration:");
              ((StringBuilder)localObject1).append(this.maxDuration.getTimeSeconds() * 1000.0F);
              Log.i("TAVRhythmTemplate", ((StringBuilder)localObject1).toString());
            }
          }
        }
        else
        {
          this.highlightPoints.addAll(((RhythmDataBean.PackedEffectPoints)localObject1).effectPoints);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("init HighlightValueTrail, size:");
          ((StringBuilder)localObject1).append(this.highlightPoints.size());
          Log.i("TAVRhythmTemplate", ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  private void fillEffects()
  {
    if ((this.rhythmEffectsGroup != null) && (!this.rhythmEffectsGroup.isEmpty()))
    {
      this.rhythmEffects = ((TAVRhythmEffects)this.rhythmEffectsGroup.get(0));
      this.rhythmEffectID = this.rhythmEffects.getRhythmEffectID();
      Object localObject1 = this.rhythmEffects.getHighlightEffects();
      Object localObject2 = this.effectsModel.filterEffects;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        fillRealEffects((List)localObject1, this.highlightEffects);
      }
      Object localObject3;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TAVEffectAutomaticEffect)((Iterator)localObject2).next();
          if ((((TAVEffectAutomaticEffect)localObject3).getRhythmEffectType() == 1) || (((TAVEffectAutomaticEffect)localObject3).getRhythmEffectType() == 2)) {
            ((List)localObject1).add(localObject3);
          }
        }
        fillRealEffects((List)localObject1, this.highlightEffects);
      }
      localObject1 = this.highlightEffects.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TAVEffectAutomaticEffect)((Iterator)localObject1).next();
        if (((TAVEffectAutomaticEffect)localObject2).getRhythmEffectType() == 2) {
          ((TAVEffectAutomaticEffect)localObject2).setEndOffset(-1L);
        }
      }
      localObject1 = this.rhythmEffects.getSecondEffects();
      if ((this.rhythmEffects.getSecondEffects() != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (List)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
          {
            localObject3 = new ArrayList();
            fillRealEffects((List)localObject2, (List)localObject3);
            this.secondEffects.add(localObject3);
          }
        }
      }
    }
  }
  
  private void fillRandomType(TAVMovie paramTAVMovie)
  {
    paramTAVMovie = paramTAVMovie.getClips();
    if (this.singleResource)
    {
      if (this.rhythmType == TAVRhythmAutomaticTemplate.TAVRhythmEffectType.TAVRhythmSlowChannel)
      {
        this.randomType = TAVRhythmAutomaticTemplate.TAVRhythmRandomType.TAVRhythmSingleSlow;
        return;
      }
      this.randomType = TAVRhythmAutomaticTemplate.TAVRhythmRandomType.TAVRhythmSingleBPM;
      return;
    }
    if (TemplateUtils.isAllPhotoClip(paramTAVMovie))
    {
      if (this.adjustClipType == TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1)
      {
        this.randomType = TAVRhythmAutomaticTemplate.TAVRhythmRandomType.TAVRhythmMultiPicDrum;
        return;
      }
      this.randomType = TAVRhythmAutomaticTemplate.TAVRhythmRandomType.TAVRhythmMultiPicSlow;
      return;
    }
    if (this.adjustClipType == TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1)
    {
      this.randomType = TAVRhythmAutomaticTemplate.TAVRhythmRandomType.TAVRhythmMultiCutMode1;
      return;
    }
    this.randomType = TAVRhythmAutomaticTemplate.TAVRhythmRandomType.TAVRhythmMultiCutMode2;
  }
  
  private void fillRealEffects(List<TAVEffectAutomaticEffect> paramList1, List<TAVEffectAutomaticEffect> paramList2)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      TAVEffectAutomaticEffect localTAVEffectAutomaticEffect = (TAVEffectAutomaticEffect)paramList1.next();
      if (localTAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
        paramList2.add(localTAVEffectAutomaticEffect.copyPAGEffectFrom());
      } else if (localTAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
        paramList2.add(localTAVEffectAutomaticEffect.copyLUTEffectFrom());
      } else if (localTAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime) {
        paramList2.add(localTAVEffectAutomaticEffect.copyTimeEffectFrom());
      }
    }
  }
  
  private void fillSecondEffectPoints()
  {
    if (this.rhythmType == TAVRhythmAutomaticTemplate.TAVRhythmEffectType.TAVRhythmBPMChannel)
    {
      this.secondEffectPoints.addAll(this.bpmEffectPoints);
      return;
    }
    if (this.rhythmType == TAVRhythmAutomaticTemplate.TAVRhythmEffectType.TAVRhythmSlowChannel) {
      this.secondEffectPoints.addAll(this.slowEffectPoints);
    }
  }
  
  private void fillSegmentTAVClip(List<TAVRhythmMovieSegment> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVRhythmMovieSegment localTAVRhythmMovieSegment = (TAVRhythmMovieSegment)paramList.next();
      if (localTAVRhythmMovieSegment != null)
      {
        Object localObject = localTAVRhythmMovieSegment.getTavMovieClips();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TAVClip localTAVClip = ((TAVMovieClip)((Iterator)localObject).next()).convertToClip();
            localTAVClip.putExtraTrackInfo("trackIndex", Integer.valueOf(i));
            localArrayList.add(localTAVClip);
            i += 1;
          }
          localTAVRhythmMovieSegment.setTavClips(localArrayList);
        }
      }
    }
  }
  
  private void fillSegmentTimeEffect(List<TAVRhythmMovieSegment> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVRhythmMovieSegment localTAVRhythmMovieSegment = (TAVRhythmMovieSegment)paramList.next();
      CMTimeRange localCMTimeRange = localTAVRhythmMovieSegment.getTimeRange();
      ArrayList localArrayList = new ArrayList();
      TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
      localTAVMovieTimeEffect.setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, localCMTimeRange.getDuration()));
      localTAVMovieTimeEffect.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, localCMTimeRange.getDuration()));
      localArrayList.add(localTAVMovieTimeEffect);
      localTAVRhythmMovieSegment.setTimeEffects(localArrayList);
    }
  }
  
  private void getSecondEffectsIndex()
  {
    this.secondApplyEffectsRandomIndices.clear();
    if (!this.secondEffects.isEmpty())
    {
      if (this.secondEffectPoints.isEmpty()) {
        return;
      }
      int j = this.secondEffectApplyType;
      int k = TAVRhythmAutomaticTemplate.ApplyEffectType.SequenceApplyEffect.ordinal();
      int i = 0;
      long l;
      if (j == k) {
        while (i < this.secondEffectPoints.size())
        {
          l = ((float)((TAVEffectPoint)this.secondEffectPoints.get(i)).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F);
          if ((l > 0L) && ((float)l <= this.maxVideoDuration.getTimeSeconds() * 1000.0F) && (this.secondEffectType == TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix))
          {
            j = this.secondEffects.size();
            this.secondApplyEffectsRandomIndices.add(Integer.valueOf(i % j));
          }
          i += 1;
        }
      }
      Iterator localIterator;
      if (this.secondEffectApplyType == TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal())
      {
        localIterator = this.secondEffectPoints.iterator();
        while (localIterator.hasNext())
        {
          l = ((float)((TAVEffectPoint)localIterator.next()).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F);
          if ((l > 0L) && ((float)l <= this.maxVideoDuration.getTimeSeconds() * 1000.0F) && (this.secondEffectType == TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix))
          {
            i = RandomUtils.randomInt(0, this.secondEffects.size());
            this.secondApplyEffectsRandomIndices.add(Integer.valueOf(i));
          }
        }
      }
      if (this.secondEffectApplyType == TAVRhythmAutomaticTemplate.ApplyEffectType.DefaultApplyEffect.ordinal())
      {
        localIterator = this.secondEffectPoints.iterator();
        while (localIterator.hasNext())
        {
          l = ((float)((TAVEffectPoint)localIterator.next()).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F);
          if ((l > 0L) && ((float)l <= this.maxVideoDuration.getTimeSeconds() * 1000.0F) && (this.secondEffectType == TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix)) {
            this.secondApplyEffectsRandomIndices.add(Integer.valueOf(0));
          }
        }
      }
    }
  }
  
  @Nullable
  private List<List<TAVClip>> getTAVClipsFromSegments(List<TAVRhythmMovieSegment> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject1 = new ArrayList();
      paramList = paramList.iterator();
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject4;
      for (;;)
      {
        boolean bool = paramList.hasNext();
        int j = 0;
        if (!bool) {
          break;
        }
        localObject2 = (TAVRhythmMovieSegment)paramList.next();
        if (((List)localObject1).isEmpty())
        {
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject2);
          ((List)localObject1).add(localObject3);
        }
        else
        {
          localObject3 = ((List)localObject1).iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (List)((Iterator)localObject3).next();
          } while (((TAVRhythmMovieSegment)((List)localObject4).get(((List)localObject4).size() - 1)).getTimeRange().containsTime(((TAVRhythmMovieSegment)localObject2).getTimeRange().getStart()));
          ((List)localObject4).add(localObject2);
          i = 1;
          if (i == 0)
          {
            localObject3 = new ArrayList();
            ((List)localObject3).add(localObject2);
            ((List)localObject1).add(localObject3);
          }
        }
      }
      paramList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        localObject3 = new ArrayList();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject4 = (TAVRhythmMovieSegment)((List)localObject2).get(i);
          if (i == 0)
          {
            if (((TAVRhythmMovieSegment)localObject4).getTimeRange().getStart().bigThan(CMTime.CMTimeZero)) {
              ((List)localObject3).add(new TAVClip(new TAVEmptyResource(((TAVRhythmMovieSegment)((List)localObject2).get(0)).getTimeRange().getStart())));
            }
          }
          else
          {
            Object localObject5 = (TAVRhythmMovieSegment)((List)localObject2).get(i - 1);
            localObject5 = ((TAVRhythmMovieSegment)localObject4).getTimeRange().getStart().sub(((TAVRhythmMovieSegment)localObject5).getTimeRange().getEnd());
            if (((CMTime)localObject5).bigThan(CMTime.CMTimeZero)) {
              ((List)localObject3).add(new TAVClip(new TAVEmptyResource((CMTime)localObject5)));
            }
          }
          localObject4 = ((TAVRhythmMovieSegment)localObject4).getFullTavClips().iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((List)localObject3).add((TAVClip)((Iterator)localObject4).next());
          }
          i += 1;
        }
        paramList.add(localObject3);
      }
      return paramList;
    }
    return null;
  }
  
  private List<TAVEffectAutomaticEffect> getTimeEffectFromEffectsGroup(List<List<TAVEffectAutomaticEffect>> paramList, boolean paramBoolean)
  {
    List localList;
    TAVEffectAutomaticEffect localTAVEffectAutomaticEffect;
    do
    {
      paramList = paramList.iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        if (!paramList.hasNext()) {
          break;
        }
        localList = (List)paramList.next();
        localIterator = localList.iterator();
      }
      localTAVEffectAutomaticEffect = (TAVEffectAutomaticEffect)localIterator.next();
    } while ((localTAVEffectAutomaticEffect.getEffectType() != TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime) || ((paramBoolean) && (localTAVEffectAutomaticEffect.getSpeed() != 0.0F)));
    return localList;
    return null;
  }
  
  private void handleNormalTransition(int paramInt, @NonNull TAVMovieClipEx paramTAVMovieClipEx1, @Nullable TAVMovieClipEx paramTAVMovieClipEx2, @NonNull TAVRhythmMovieSegment paramTAVRhythmMovieSegment1, @NonNull TAVRhythmMovieSegment paramTAVRhythmMovieSegment2, long paramLong, TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect, TAVSticker paramTAVSticker)
  {
    CMTime localCMTime = paramTAVMovieClipEx2.getTransitionEffectParam().getOverlayTime().divide(2.0F);
    paramTAVMovieClipEx2 = paramTAVMovieClipEx2.getTavMovieClip().getResource();
    paramTAVMovieClipEx1 = paramTAVMovieClipEx1.getTavMovieClip().getResource();
    CMTimeRange localCMTimeRange = paramTAVMovieClipEx2.getTimeRange();
    localCMTimeRange.setDuration(localCMTimeRange.getDuration().add(localCMTime));
    paramTAVMovieClipEx2.setDuration(localCMTimeRange.getDuration());
    paramTAVMovieClipEx2 = paramTAVRhythmMovieSegment2.getTimeRange();
    paramTAVMovieClipEx2.setDuration(paramTAVMovieClipEx2.getDuration().add(localCMTime));
    paramTAVRhythmMovieSegment2.setTimeRange(paramTAVMovieClipEx2);
    addOverLayTimeToClip(localCMTime, paramTAVMovieClipEx1);
    paramTAVMovieClipEx1 = paramTAVRhythmMovieSegment1.getTimeRange();
    paramTAVMovieClipEx1.setDuration(paramTAVMovieClipEx1.getDuration().add(localCMTime));
    paramTAVMovieClipEx2 = paramTAVMovieClipEx1.getStart().sub(localCMTime);
    paramTAVMovieClipEx1.setStart(paramTAVMovieClipEx2);
    paramTAVRhythmMovieSegment1.setTimeRange(paramTAVMovieClipEx1);
    if (paramTAVTransitionAutomaticEffect != null) {
      applyTransitionToSegment(paramTAVTransitionAutomaticEffect, paramTAVSticker, paramTAVMovieClipEx2, paramLong, paramInt);
    }
  }
  
  @Deprecated
  private int handleTransitionForSegment(int paramInt, TAVMovieClipEx paramTAVMovieClipEx1, TAVMovieClipEx paramTAVMovieClipEx2, CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3, TAVRhythmMovieSegment paramTAVRhythmMovieSegment1, TAVRhythmMovieSegment paramTAVRhythmMovieSegment2)
  {
    int j = paramInt;
    long l2 = ((Long)this.rhythmTransitionHelper.getTransitionDurationMsList().get(j)).longValue();
    Object localObject2 = this.rhythmTransitionHelper.getTransitionEffect(j);
    boolean bool2 = needNormalTransition(paramTAVMovieClipEx1, paramTAVMovieClipEx2, paramCMTime1);
    Object localObject3 = null;
    long l1 = l2;
    Object localObject1 = localObject2;
    boolean bool1 = bool2;
    paramCMTime1 = localObject3;
    if (bool2)
    {
      l1 = l2;
      localObject1 = localObject2;
      bool1 = bool2;
      paramCMTime1 = localObject3;
      if (localObject2 != null)
      {
        l1 = l2;
        localObject1 = localObject2;
        bool1 = bool2;
        paramCMTime1 = localObject3;
        if (needFaceSubTransition((TAVTransitionAutomaticEffect)localObject2, paramTAVMovieClipEx1.getTavMovieClip(), paramTAVMovieClipEx2.getTavMovieClip()))
        {
          localObject1 = this.rhythmTransitionHelper.getFaceTransitionSubTransition(((TAVTransitionAutomaticEffect)localObject2).subTransitions);
          paramCMTime1 = this.rhythmTransitionHelper.getTransitionSticker((TAVTransitionAutomaticEffect)localObject1);
          l1 = paramCMTime1.durationTime() / 1000L;
          if (l1 > l2)
          {
            bool1 = false;
            l1 = l2;
            localObject1 = localObject2;
            paramCMTime1 = localObject3;
          }
          else
          {
            bool1 = bool2;
          }
        }
      }
    }
    localObject2 = new CMTime(l1 / 2L, 1000);
    int i = j;
    if (bool1)
    {
      i = j;
      if (this.rhythmTransitionHelper.isDurationEnoughForTransition(paramCMTime2, paramCMTime3, l1))
      {
        paramTAVMovieClipEx2 = paramTAVMovieClipEx2.getTavMovieClip().getResource();
        paramTAVMovieClipEx1 = paramTAVMovieClipEx1.getTavMovieClip().getResource();
        paramCMTime2 = paramTAVMovieClipEx2.getTimeRange();
        paramCMTime2.setDuration(paramCMTime2.getDuration().add((CMTime)localObject2));
        paramTAVMovieClipEx2.setDuration(paramTAVMovieClipEx2.getDuration().add((CMTime)localObject2));
        paramTAVMovieClipEx2 = paramTAVRhythmMovieSegment2.getTimeRange();
        paramTAVMovieClipEx2.setDuration(paramTAVMovieClipEx2.getDuration().add((CMTime)localObject2));
        paramTAVRhythmMovieSegment2.setTimeRange(paramTAVMovieClipEx2);
        paramTAVMovieClipEx2 = paramTAVMovieClipEx1.getTimeRange();
        if ((paramTAVMovieClipEx1 instanceof TAVMovieImageResource))
        {
          paramTAVMovieClipEx2.setDuration(paramTAVMovieClipEx2.getDuration().add((CMTime)localObject2));
          paramTAVMovieClipEx1.setDuration(paramTAVMovieClipEx1.getDuration().add((CMTime)localObject2));
        }
        else
        {
          paramTAVMovieClipEx2.setStart(paramTAVMovieClipEx2.getStart().sub((CMTime)localObject2));
          paramTAVMovieClipEx2.setDuration(paramTAVMovieClipEx2.getDuration().add((CMTime)localObject2));
          paramTAVMovieClipEx1.setDuration(paramTAVMovieClipEx1.getDuration().add((CMTime)localObject2));
        }
        paramTAVMovieClipEx1 = paramTAVRhythmMovieSegment1.getTimeRange();
        paramTAVMovieClipEx1.setDuration(paramTAVMovieClipEx1.getDuration().add((CMTime)localObject2));
        paramTAVMovieClipEx2 = paramTAVMovieClipEx1.getStart().sub((CMTime)localObject2);
        paramTAVMovieClipEx1.setStart(paramTAVMovieClipEx2);
        paramTAVRhythmMovieSegment1.setTimeRange(paramTAVMovieClipEx1);
        if (localObject1 != null) {
          applyTransitionToSegment((TAVTransitionAutomaticEffect)localObject1, paramCMTime1, paramTAVMovieClipEx2, l1, paramInt);
        }
        paramInt = j + 1;
        i = paramInt;
        if (paramInt >= this.rhythmTransitionHelper.getTransitionDurationMsList().size()) {
          i = 0;
        }
      }
    }
    return i;
  }
  
  private int handleTransitionsForSegment(int paramInt, @NonNull TAVMovieClipEx paramTAVMovieClipEx1, @Nullable TAVMovieClipEx paramTAVMovieClipEx2, @NonNull CMTime paramCMTime1, @NonNull CMTime paramCMTime2, @NonNull CMTime paramCMTime3, @NonNull TAVRhythmMovieSegment paramTAVRhythmMovieSegment1, @NonNull TAVRhythmMovieSegment paramTAVRhythmMovieSegment2)
  {
    long l1 = ((Long)this.rhythmTransitionHelper.getTransitionDurationMsList().get(paramInt)).longValue();
    Object localObject1 = this.rhythmTransitionHelper.getTransitionEffect(paramInt);
    boolean bool = needAddNormalTransition(paramTAVMovieClipEx1, paramTAVMovieClipEx2, paramCMTime1);
    if ((bool) && (localObject1 != null) && (needFaceSubTransition((TAVTransitionAutomaticEffect)localObject1, paramTAVMovieClipEx1.getTavMovieClip(), paramTAVMovieClipEx2.getTavMovieClip())))
    {
      localObject2 = this.rhythmTransitionHelper.getFaceTransitionSubTransition(((TAVTransitionAutomaticEffect)localObject1).subTransitions);
      paramCMTime1 = this.rhythmTransitionHelper.getTransitionSticker((TAVTransitionAutomaticEffect)localObject2);
      long l2 = paramCMTime1.durationTime() / 1000L;
      if (l2 > l1)
      {
        bool = false;
      }
      else
      {
        paramTAVMovieClipEx2.setTransitionEffectParam(TransitionUtils.getTransitionParams(paramCMTime1, ((TAVTransitionAutomaticEffect)localObject2).effectId));
        localObject1 = localObject2;
        l1 = l2;
        localObject2 = paramCMTime1;
        break label156;
      }
    }
    Object localObject2 = null;
    paramCMTime1 = (CMTime)localObject1;
    localObject1 = paramCMTime1;
    label156:
    int j = this.rhythmTransitionHelper.getTransitionDurationMsList().size();
    int i = paramInt;
    if (bool)
    {
      i = paramInt;
      if (this.rhythmTransitionHelper.isDurationEnoughForTransition(paramCMTime2, paramCMTime3, l1))
      {
        handleNormalTransition(paramInt + this.mTransitionLoopIndex * j, paramTAVMovieClipEx1, paramTAVMovieClipEx2, paramTAVRhythmMovieSegment1, paramTAVRhythmMovieSegment2, l1, (TAVTransitionAutomaticEffect)localObject1, (TAVSticker)localObject2);
        i = paramInt + 1;
        if (i >= j)
        {
          this.mTransitionLoopIndex += 1;
          return 0;
        }
      }
    }
    return i;
  }
  
  private boolean isNeedCycleFill(List<TAVMovieClip> paramList)
  {
    return TemplateUtils.isAllPhotoClip(paramList);
  }
  
  private boolean isPointInPuckingDrum(CMTime paramCMTime)
  {
    long l = paramCMTime.getTimeUs();
    paramCMTime = this.segments.iterator();
    while (paramCMTime.hasNext()) {
      if (Math.abs(l - ((TAVRhythmMovieSegment)paramCMTime.next()).getTimeRange().getStart().getTimeUs()) <= 1000L) {
        return true;
      }
    }
    paramCMTime = new StringBuilder();
    paramCMTime.append("clip start time: ");
    paramCMTime.append(l / 1000L);
    paramCMTime.append(", don't match puckingDrum point");
    appendDebugInfo(paramCMTime.toString());
    return false;
  }
  
  private void loadMusicEffectPointsWithRhythmDataBean(RhythmDataBean paramRhythmDataBean, String paramString, long paramLong)
  {
    clearLastPoints();
    if ((paramRhythmDataBean != null) && (paramRhythmDataBean.allData != null) && (!paramRhythmDataBean.allData.isEmpty()))
    {
      this.isRhythmTemplate = true;
      fillAllChannelPoints(paramRhythmDataBean);
      fillSecondEffectPoints();
      fillEffects();
      configMusic(paramString, (float)paramLong);
      getSecondEffectsIndex();
      return;
    }
    this.isRhythmTemplate = false;
    configMusic(paramString, (float)paramLong);
  }
  
  private boolean needAddNormalTransition(@NonNull TAVMovieClipEx paramTAVMovieClipEx1, @NonNull TAVMovieClipEx paramTAVMovieClipEx2, @NonNull CMTime paramCMTime)
  {
    if (paramTAVMovieClipEx2 == null) {
      return false;
    }
    if (!paramTAVMovieClipEx1.isLastReverse()) {
      return false;
    }
    if (!paramTAVMovieClipEx2.isCurrentReverse()) {
      return false;
    }
    return isPointInPuckingDrum(paramCMTime);
  }
  
  private boolean needFaceSubTransition(TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect, TAVMovieClip paramTAVMovieClip1, TAVMovieClip paramTAVMovieClip2)
  {
    return (paramTAVTransitionAutomaticEffect.isFaceTransition()) && ((!this.rhythmTransitionHelper.clipSupportFaceTransition(paramTAVMovieClip2)) || (!this.rhythmTransitionHelper.clipSupportFaceTransition(paramTAVMovieClip1))) && (!CollectionUtil.isEmptyList(paramTAVTransitionAutomaticEffect.subTransitions));
  }
  
  private boolean needNormalTransition(TAVMovieClipEx paramTAVMovieClipEx1, TAVMovieClipEx paramTAVMovieClipEx2, CMTime paramCMTime)
  {
    return (paramTAVMovieClipEx2 != null) && (isPointInPuckingDrum(paramCMTime)) && (paramTAVMovieClipEx1.isReverse()) && (paramTAVMovieClipEx2.isReverse());
  }
  
  private void randomRhythmChannleAndAdjustMode()
  {
    if (this.randomIndex % 2 == 0)
    {
      this.adjustClipType = TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1;
      this.rhythmType = TAVRhythmAutomaticTemplate.TAVRhythmEffectType.TAVRhythmSlowChannel;
      return;
    }
    this.adjustClipType = TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode2;
    this.rhythmType = TAVRhythmAutomaticTemplate.TAVRhythmEffectType.TAVRhythmBPMChannel;
  }
  
  private List<TAVMovieClipEx> separateClipsWithAdjust(List<TAVMovieClipEx> paramList)
  {
    Object localObject2 = this;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = CMTime.CMTimeZero;
    Object localObject7 = CMTime.CMTimeZero;
    Object localObject3 = ((TAVRhythmAutomaticTemplate)localObject2).segments.iterator();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("separateClipsWithAdjust maxDuration ");
    ((StringBuilder)localObject4).append(((TAVRhythmAutomaticTemplate)localObject2).maxDuration);
    Logger.d("TAVRhythmTemplate", ((StringBuilder)localObject4).toString());
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TAVRhythmMovieSegment)((Iterator)localObject3).next();
      if (localObject4 == null) {
        ((Iterator)localObject3).remove();
      } else {
        localObject1 = ((CMTime)localObject1).add(((TAVRhythmMovieSegment)localObject4).getTimeRange().getDuration());
      }
    }
    if (!((CMTime)localObject1).equalsTo(CMTime.CMTimeZero))
    {
      if (((CMTime)localObject1).smallThan(CMTime.CMTimeZero)) {
        return localArrayList;
      }
      Object localObject5 = localObject1;
      if (((CMTime)localObject1).bigThan(((TAVRhythmAutomaticTemplate)localObject2).maxDuration)) {
        localObject5 = ((TAVRhythmAutomaticTemplate)localObject2).maxDuration;
      }
      localObject1 = CMTime.CMTimeZero;
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((TAVMovieClipEx)((Iterator)localObject2).next()).getTavMovieClip();
        if ((localObject3 != null) && (((TAVMovieClip)localObject3).getResource() != null) && (((TAVMovieClip)localObject3).getResource().getTimeRange() != null))
        {
          if (!(((TAVMovieClip)localObject3).getResource() instanceof TAVMovieImageResource)) {
            localObject1 = ((CMTime)localObject1).add(((TAVMovieClip)localObject3).getResource().getTimeRange().getDuration());
          }
        }
        else {
          ((Iterator)localObject2).remove();
        }
      }
      if (!((CMTime)localObject1).equalsTo(CMTime.CMTimeZero))
      {
        if (((CMTime)localObject1).smallThan(CMTime.CMTimeZero)) {
          return localArrayList;
        }
        localObject2 = CMTime.CMTimeZero;
        int k = 0;
        int i = 0;
        Object localObject6 = localObject1;
        for (;;)
        {
          Object localObject9 = this;
          if (k >= paramList.size()) {
            break;
          }
          Object localObject11 = ((TAVMovieClipEx)paramList.get(k)).getTavMovieClip();
          if (i >= ((TAVRhythmAutomaticTemplate)localObject9).segments.size()) {
            break;
          }
          Object localObject8;
          if ((((TAVMovieClip)localObject11).getResource() instanceof TAVMovieImageResource))
          {
            localObject3 = ((TAVRhythmMovieSegment)((TAVRhythmAutomaticTemplate)localObject9).segments.get(i)).getMinOriginDuration();
            if (!((CMTime)localObject2).equalsTo(CMTime.CMTimeZero))
            {
              localObject1 = CMTime.CMTimeZero;
            }
            else
            {
              i += 1;
              localObject1 = localObject2;
              localObject2 = localObject3;
            }
            localObject3 = ((TAVMovieClip)localObject11).clone();
            localObject4 = ((TAVMovieClip)localObject3).getResource();
            localObject8 = ((TAVMovieResource)localObject4).getTimeRange();
            ((CMTimeRange)localObject8).setDuration((CMTime)localObject2);
            ((TAVMovieResource)localObject4).setTimeRange((CMTimeRange)localObject8);
            ((TAVMovieResource)localObject4).setDuration((CMTime)localObject2);
            localObject2 = ((TAVMovieClipEx)paramList.get(k)).clone();
            ((TAVMovieClipEx)localObject2).setTavMovieClip((TAVMovieClip)localObject3);
            localArrayList.add(localObject2);
            localObject4 = localObject7;
            localObject2 = localObject1;
          }
          else
          {
            localObject8 = ((TAVMovieClip)localObject11).getResource().getTimeRange().getDuration().clone();
            if (((CMTime)localObject8).equalsTo(CMTime.CMTimeZero))
            {
              localObject4 = localObject7;
            }
            else
            {
              localObject1 = ((CMTime)localObject8).multi((CMTime)localObject5).divide(localObject6);
              localObject4 = localObject1;
              if (((CMTime)localObject8).smallThan((CMTime)localObject1)) {
                localObject4 = localObject8;
              }
              Object localObject10 = CMTime.CMTimeZero;
              int j = i;
              localObject3 = localObject2;
              localObject1 = localObject10;
              if (!((CMTime)localObject2).equalsTo(CMTime.CMTimeZero))
              {
                localObject1 = ((CMTime)localObject10).add((CMTime)localObject2);
                localObject3 = CMTime.CMTimeZero;
                j = i;
              }
              for (;;)
              {
                i = j;
                if (j >= ((TAVRhythmAutomaticTemplate)localObject9).segments.size()) {
                  break label693;
                }
                localObject2 = (TAVRhythmMovieSegment)((TAVRhythmAutomaticTemplate)localObject9).segments.get(j);
                if (!((CMTime)localObject1).smallThan((CMTime)localObject4)) {
                  break;
                }
                localObject1 = ((CMTime)localObject1).add(((TAVRhythmMovieSegment)localObject2).getMinOriginDuration());
                j += 1;
              }
              i = j - 1;
              label693:
              j = i;
              if (i == ((TAVRhythmAutomaticTemplate)localObject9).segments.size()) {
                j = i - 1;
              }
              localObject10 = ((TAVMovieClip)localObject11).clone();
              localObject11 = ((TAVMovieClip)localObject10).getResource().getTimeRange();
              localObject2 = CMTime.CMTimeZero;
              if ((j >= 0) && (j < ((TAVRhythmAutomaticTemplate)localObject9).segments.size())) {
                localObject2 = ((TAVRhythmMovieSegment)((TAVRhythmAutomaticTemplate)localObject9).segments.get(j)).getMinOriginDuration();
              }
              if (((CMTime)localObject1).bigThan((CMTime)localObject4))
              {
                localObject9 = ((CMTime)localObject1).sub((CMTime)localObject2);
                if (((CMTime)localObject9).smallThan(CMTime.CMTimeZero))
                {
                  localObject9 = CMTime.CMTimeZero;
                  localObject2 = localObject1;
                  localObject1 = localObject9;
                }
                else
                {
                  localObject1 = localObject9;
                }
              }
              if (((CMTime)localObject1).equalsTo(CMTime.CMTimeZero))
              {
                i = j + 1;
                localObject2 = ((CMTime)localObject2).sub((CMTime)localObject4);
                ((CMTimeRange)localObject11).setDuration((CMTime)localObject4);
                ((TAVMovieClip)localObject10).getResource().setDuration((CMTime)localObject4);
                localObject4 = ((CMTime)localObject7).add(((CMTimeRange)localObject11).getDuration());
                ((TAVMovieClip)localObject10).getResource().setTimeRange((CMTimeRange)localObject11);
                localObject1 = ((TAVMovieClipEx)paramList.get(k)).clone();
                ((TAVMovieClipEx)localObject1).setTavMovieClip((TAVMovieClip)localObject10);
                localArrayList.add(localObject1);
              }
              else if (!((CMTime)localObject8).bigThan((CMTime)localObject1))
              {
                i = j;
                localObject4 = localObject7;
                localObject2 = localObject3;
                if (!((CMTime)localObject8).equalsTo((CMTime)localObject1)) {}
              }
              else
              {
                ((CMTimeRange)localObject11).setDuration((CMTime)localObject1);
                ((TAVMovieClip)localObject10).getResource().setDuration((CMTime)localObject1);
                localObject4 = ((CMTime)localObject7).add(((CMTimeRange)localObject11).getDuration());
                ((TAVMovieClip)localObject10).getResource().setTimeRange((CMTimeRange)localObject11);
                localObject1 = ((TAVMovieClipEx)paramList.get(k)).clone();
                ((TAVMovieClipEx)localObject1).setTavMovieClip((TAVMovieClip)localObject10);
                localArrayList.add(localObject1);
                localObject2 = localObject3;
                i = j;
              }
            }
          }
          k += 1;
          localObject7 = localObject4;
        }
        paramList = new StringBuilder();
        paramList.append("separateClipsWithAdjust fillTotalDuration ");
        paramList.append(localObject5);
        Logger.d("TAVRhythmTemplate", paramList.toString());
        paramList = new StringBuilder();
        paramList.append("separateClipsWithAdjust totalDuration ");
        paramList.append(localObject7);
        Logger.d("TAVRhythmTemplate", paramList.toString());
      }
    }
    return localArrayList;
  }
  
  private List<TAVMovieClipEx> separateClipsWithoutAdjust(List<TAVMovieClipEx> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject5 = CMTime.CMTimeZero;
    CMTime localCMTime1 = new CMTime(10000L, 1000);
    Object localObject2 = CMTime.CMTimeZero;
    int i = 0;
    int j = 0;
    int n = 0;
    while (i < paramList.size())
    {
      if (j >= this.segments.size()) {
        return localArrayList;
      }
      Object localObject4 = CMTime.CMTimeZero;
      Object localObject3 = ((TAVMovieClipEx)paramList.get(i)).getTavMovieClip();
      Object localObject1;
      Object localObject6;
      int m;
      if ((((TAVMovieClip)localObject3).getResource() instanceof TAVMovieImageResource))
      {
        if (!((CMTime)localObject2).equalsTo(CMTime.CMTimeZero))
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = ((TAVRhythmMovieSegment)this.segments.get(j)).getMinOriginDuration().clone();
          j += 1;
        }
        localObject3 = ((TAVMovieClip)localObject3).clone();
        localObject4 = ((TAVMovieClip)localObject3).getResource();
        localObject6 = ((TAVMovieResource)localObject4).getTimeRange();
        ((CMTimeRange)localObject6).setDuration((CMTime)localObject1);
        ((TAVMovieResource)localObject4).setTimeRange((CMTimeRange)localObject6);
        ((TAVMovieResource)localObject4).setDuration((CMTime)localObject1);
        localObject4 = ((TAVMovieClipEx)paramList.get(i)).clone();
        ((TAVMovieClipEx)localObject4).setTavMovieClip((TAVMovieClip)localObject3);
        localArrayList.add(localObject4);
        localObject4 = ((CMTime)localObject5).add((CMTime)localObject1);
        m = i;
        localObject1 = localObject2;
      }
      else
      {
        CMTime localCMTime2 = ((TAVMovieClip)localObject3).getResource().getTimeRange().getDuration();
        TAVMovieClip localTAVMovieClip = ((TAVMovieClip)localObject3).clone();
        CMTimeRange localCMTimeRange = localTAVMovieClip.getResource().getTimeRange();
        int k = j;
        localObject3 = localObject2;
        localObject1 = localObject4;
        if (!((CMTime)localObject2).equalsTo(CMTime.CMTimeZero))
        {
          localObject1 = ((CMTime)localObject4).add((CMTime)localObject2);
          localObject3 = CMTime.CMTimeZero;
          k = j;
        }
        for (;;)
        {
          j = k;
          if (k >= this.segments.size()) {
            break label381;
          }
          localObject2 = (TAVRhythmMovieSegment)this.segments.get(k);
          if (!((CMTime)localObject1).smallThan(localCMTime2)) {
            break;
          }
          localObject1 = ((CMTime)localObject1).add(((TAVRhythmMovieSegment)localObject2).getMinOriginDuration());
          k += 1;
        }
        j = k - 1;
        label381:
        k = j;
        if (j == this.segments.size()) {
          k = j - 1;
        }
        localObject2 = CMTime.CMTimeZero;
        localObject4 = localObject2;
        if (k >= 0)
        {
          localObject4 = localObject2;
          if (k < this.segments.size()) {
            localObject4 = ((TAVRhythmMovieSegment)this.segments.get(k)).getMinOriginDuration();
          }
        }
        if (((CMTime)localObject1).bigThan(localCMTime2))
        {
          localObject6 = ((CMTime)localObject1).sub((CMTime)localObject4);
          localObject2 = localObject6;
          if (((CMTime)localObject6).smallThan(CMTime.CMTimeZero))
          {
            localObject2 = CMTime.CMTimeZero;
            localObject4 = localObject1;
          }
        }
        else
        {
          localObject2 = localObject1;
        }
        if (((CMTime)localObject2).equalsTo(CMTime.CMTimeZero))
        {
          j = k + 1;
          localObject1 = ((CMTime)localObject4).sub(localCMTime2);
          localCMTimeRange.setDuration(localCMTime2);
          localTAVMovieClip.getResource().setDuration(localCMTime2);
          localTAVMovieClip.getResource().setTimeRange(localCMTimeRange);
          localObject2 = ((TAVMovieClipEx)paramList.get(i)).clone();
          ((TAVMovieClipEx)localObject2).setTavMovieClip(localTAVMovieClip);
          localArrayList.add(localObject2);
          m = i + 1;
          localObject4 = localObject5;
        }
        else if (!localCMTime2.bigThan((CMTime)localObject2))
        {
          m = i;
          j = k;
          localObject1 = localObject3;
          localObject4 = localObject5;
          if (!localCMTime2.equalsTo((CMTime)localObject2)) {}
        }
        else
        {
          localCMTimeRange.setDuration((CMTime)localObject2);
          localTAVMovieClip.getResource().setDuration((CMTime)localObject2);
          localTAVMovieClip.getResource().setTimeRange(localCMTimeRange);
          localObject1 = ((TAVMovieClipEx)paramList.get(i)).clone();
          ((TAVMovieClipEx)localObject1).setTavMovieClip(localTAVMovieClip);
          localArrayList.add(localObject1);
          m = i + 1;
          localObject4 = localObject5;
          localObject1 = localObject3;
          j = k;
        }
      }
      if (!paramBoolean)
      {
        i = m;
        localObject2 = localObject1;
        localObject5 = localObject4;
      }
      else
      {
        if ((n != 0) && (!((CMTime)localObject4).smallThan(localCMTime1))) {
          return localArrayList;
        }
        if ((((CMTime)localObject4).smallThan(localCMTime1)) && (m == paramList.size() - 1))
        {
          i = 0;
          n = 1;
          localObject2 = localObject1;
          localObject5 = localObject4;
        }
        else
        {
          i = m + 1;
          localObject2 = localObject1;
          localObject5 = localObject4;
        }
      }
    }
    return localArrayList;
  }
  
  private void sortPoints(List<TAVEffectPoint> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      Collections.sort(paramList, new TAVRhythmAutomaticTemplate.1(this));
    }
  }
  
  public void addExtraFilterSticker(List<TAVSticker> paramList, CMTime paramCMTime)
  {
    super.addExtraFilterSticker(paramList, paramCMTime);
    Object localObject1;
    Object localObject2;
    if ((!this.highlightPoints.isEmpty()) && (!this.highlightEffects.isEmpty()) && (this.singleResource))
    {
      long l = ((float)((TAVEffectPoint)this.highlightPoints.get(0)).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F);
      if ((l >= 0L) && ((float)l < paramCMTime.getTimeSeconds() * 1000.0F))
      {
        localIterator = this.highlightEffects.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (TAVEffectAutomaticEffect)localIterator.next();
          if (localObject1 != null) {
            if (((TAVEffectAutomaticEffect)localObject1).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG)
            {
              localObject1 = (TAVPagAutomaticEffect)localObject1;
              if (((TAVPagAutomaticEffect)localObject1).getRhythmEffectType() == 2) {
                ((TAVPagAutomaticEffect)localObject1).setEndOffset(-1L);
              }
              ((TAVPagAutomaticEffect)localObject1).setFileDir(this.highlightEffectsPath);
              ((TAVPagAutomaticEffect)localObject1).setStartOffset(l);
              localObject2 = ((TAVPagAutomaticEffect)localObject1).convertToMovieStickerWithDuraton(paramCMTime.getTimeSeconds() * 1000.0F);
              if ((localObject2 != null) && (((TAVMovieSticker)localObject2).getSticker() != null)) {
                addEffect((TAVMovieSticker)localObject2, (TAVPagAutomaticEffect)localObject1, paramList);
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("add highlight pag filter: ");
              ((StringBuilder)localObject2).append(((TAVPagAutomaticEffect)localObject1).getFilePath());
              ((StringBuilder)localObject2).append(", start offset: ");
              ((StringBuilder)localObject2).append(l);
              appendDebugInfo(((StringBuilder)localObject2).toString());
            }
            else if (((TAVEffectAutomaticEffect)localObject1).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT)
            {
              localObject1 = (TAVLUTAutomaticEffect)localObject1;
              ((TAVLUTAutomaticEffect)localObject1).setStartOffset(l);
              localObject2 = ((TAVLUTAutomaticEffect)localObject1).covertToMovieFilterWithDuraton(paramCMTime.getTimeSeconds() * 1000.0F);
              this.lutFilters.add(localObject2);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("add highlight lut filter: ");
              ((StringBuilder)localObject2).append(((TAVLUTAutomaticEffect)localObject1).getFilePath());
              ((StringBuilder)localObject2).append(", start offset: ");
              ((StringBuilder)localObject2).append(l);
              appendDebugInfo(((StringBuilder)localObject2).toString());
            }
          }
        }
      }
    }
    Iterator localIterator = this.secondApplyEffects.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = ((List)localIterator.next()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TAVEffectAutomaticEffect)((Iterator)localObject1).next();
        Object localObject3;
        if (((TAVEffectAutomaticEffect)localObject2).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG)
        {
          localObject2 = (TAVPagAutomaticEffect)localObject2;
          ((TAVPagAutomaticEffect)localObject2).setFileDir(this.secondEffectsPath);
          localObject3 = ((TAVPagAutomaticEffect)localObject2).convertToMovieStickerWithDuraton(paramCMTime.getTimeSeconds() * 1000.0F);
          if ((localObject3 != null) && (((TAVMovieSticker)localObject3).getSticker() != null)) {
            addEffect((TAVMovieSticker)localObject3, (TAVPagAutomaticEffect)localObject2, paramList);
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("add second effect pag filter: ");
          ((StringBuilder)localObject3).append(((TAVPagAutomaticEffect)localObject2).getFilePath());
          ((StringBuilder)localObject3).append(", start offset: ");
          ((StringBuilder)localObject3).append(((TAVPagAutomaticEffect)localObject2).getStartOffset());
          appendDebugInfo(((StringBuilder)localObject3).toString());
        }
        else if (((TAVEffectAutomaticEffect)localObject2).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT)
        {
          localObject2 = (TAVLUTAutomaticEffect)localObject2;
          localObject3 = ((TAVLUTAutomaticEffect)localObject2).covertToMovieFilterWithDuraton(paramCMTime.getTimeSeconds() * 1000.0F);
          this.lutFilters.add(localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("add second effect lut filter: ");
          ((StringBuilder)localObject3).append(((TAVLUTAutomaticEffect)localObject2).getFilePath());
          ((StringBuilder)localObject3).append(", start offset: ");
          ((StringBuilder)localObject3).append(((TAVLUTAutomaticEffect)localObject2).getStartOffset());
          appendDebugInfo(((StringBuilder)localObject3).toString());
        }
      }
    }
  }
  
  public void addExtraOverlaySticker(List<TAVSticker> paramList, CMTime paramCMTime)
  {
    super.addExtraOverlaySticker(paramList, paramCMTime);
  }
  
  public void applyTimeEffectToComposition(TAVComposition paramTAVComposition)
  {
    super.applyTimeEffectToComposition(paramTAVComposition);
    Object localObject;
    if ((!this.singleResource) && (this.segments.size() > 0))
    {
      localObject = TemplateUtils.checkVideoMaxDuration(convertClipsFromMovie(this.movie, this.adjustClipType), this.maxVideoDuration);
      if (localObject != null)
      {
        paramTAVComposition.getVideoChannels().clear();
        paramTAVComposition.getAudioChannels().clear();
        localObject = ((List)localObject).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        List localList = (List)((Iterator)localObject).next();
        paramTAVComposition.getVideoChannels().add(localList);
        paramTAVComposition.getAudioChannels().add(localList);
        continue;
        applyTimeEffectToHighlightPoint(paramTAVComposition);
        applyTimeEffectToEffectPoint(paramTAVComposition);
        localObject = TemplateUtils.checkVideoMaxDuration(paramTAVComposition, this.maxVideoDuration);
        if (localObject != null)
        {
          paramTAVComposition.getVideoChannels().clear();
          paramTAVComposition.getAudioChannels().clear();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localList = (List)((Iterator)localObject).next();
            paramTAVComposition.getVideoChannels().add(localList);
            paramTAVComposition.getAudioChannels().add(localList);
          }
        }
      }
    }
  }
  
  public TAVComposition buildCompositionFromSegments(TAVMovie paramTAVMovie, List<TAVRhythmMovieSegment> paramList)
  {
    Log.i("TAVRhythmTemplate", "buildCompositionFromSegments: ");
    TAVComposition localTAVComposition = new TAVComposition();
    localTAVComposition.setRenderSize(this.renderSize);
    localTAVComposition.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
    List localList = paramTAVMovie.getClips();
    paramTAVMovie = CMTime.CMTimeZero;
    this.transitionEffectModels.clear();
    int i = 0;
    while ((i < localList.size()) && (!this.rhythmTransitionHelper.getTransitionDurationMsList().isEmpty()))
    {
      Object localObject3 = (TAVMovieClip)localList.get(i);
      localObject1 = (TAVRhythmMovieSegment)paramList.get(i);
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(localObject3);
      ((TAVRhythmMovieSegment)localObject1).setTavMovieClips((List)localObject2);
      localObject2 = paramTAVMovie.add(((TAVMovieClip)localObject3).getResource().getTimeRange().getDuration());
      int k = i + 1;
      if (k < localList.size())
      {
        paramTAVMovie = (TAVRhythmMovieSegment)paramList.get(k);
        localObject1 = ((TAVRhythmMovieSegment)localObject1).getTimeRange();
        CMTime localCMTime1 = paramTAVMovie.getTimeRange().getStart();
        CMTime localCMTime2 = ((CMTimeRange)localObject1).getEnd();
        paramTAVMovie = (TAVMovieClip)localList.get(k);
        long l1 = ((Long)this.rhythmTransitionHelper.getTransitionDurationMsList().get(i)).longValue();
        localObject1 = this.rhythmTransitionHelper.getTransitionEffect(i);
        if (needFaceSubTransition((TAVTransitionAutomaticEffect)localObject1, (TAVMovieClip)localObject3, paramTAVMovie))
        {
          localObject3 = this.rhythmTransitionHelper.getFaceTransitionSubTransition(((TAVTransitionAutomaticEffect)localObject1).subTransitions);
          paramTAVMovie = this.rhythmTransitionHelper.getTransitionSticker((TAVTransitionAutomaticEffect)localObject3);
          long l2 = paramTAVMovie.durationTime() / 1000L;
          if (l2 > l1)
          {
            paramTAVMovie = null;
            j = 0;
            break label323;
          }
          localObject1 = localObject3;
          l1 = l2;
        }
        else
        {
          paramTAVMovie = null;
        }
        int j = 1;
        label323:
        if ((j != 0) && (localCMTime2.sub(localCMTime1).bigThan(new CMTime(l1 / 2L, 1000)))) {
          applyTransitionToSegment((TAVTransitionAutomaticEffect)localObject1, paramTAVMovie, localCMTime1, l1, i);
        }
      }
      i = k;
      paramTAVMovie = (TAVMovie)localObject2;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("buildCompositionFromSegments totalDuration ");
    ((StringBuilder)localObject1).append(paramTAVMovie.getTimeSeconds());
    Logger.d("TAVRhythmTemplate", ((StringBuilder)localObject1).toString());
    fillSegmentTAVClip(paramList);
    fillSegmentTimeEffect(paramList);
    correctSegments(paramList);
    paramTAVMovie = getTAVClipsFromSegments(this.mCorrectSegments);
    this.rhythmTransitionHelper.addExtraInfoToClip(paramTAVMovie, getFaceTransitions());
    if ((paramTAVMovie != null) && (!paramTAVMovie.isEmpty()))
    {
      paramTAVMovie = paramTAVMovie.iterator();
      while (paramTAVMovie.hasNext())
      {
        paramList = (List)paramTAVMovie.next();
        localTAVComposition.getVideoChannels().add(paramList);
        localTAVComposition.getAudioChannels().add(paramList);
      }
    }
    return localTAVComposition;
  }
  
  public void configMusic(String paramString1, String paramString2, float paramFloat)
  {
    super.configMusic(paramString1, paramString2, paramFloat);
    this.musicRealStart = new CMTime(paramFloat, 1000);
  }
  
  @Nullable
  public List<List<TAVClip>> convertClipsFromMovie(TAVMovie paramTAVMovie, TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType paramTAVRhythmAdjustClipType)
  {
    List localList = CloneUtil.cloneMovieClips(paramTAVMovie.getClips());
    paramTAVMovie = new ArrayList();
    if (CollectionUtil.isEmptyList(localList)) {
      return null;
    }
    int j = 0;
    int i = 0;
    while (i < localList.size())
    {
      paramTAVMovie.add(new TAVMovieClipEx((TAVMovieClip)localList.get(i)));
      i += 1;
    }
    this.rhythmTransitionHelper.reRandomTransitions(localList.size());
    if (TAVAutomaticTemplate.isMapping) {
      this.rhythmTransitionHelper.reserveClipTransitionsTime(paramTAVMovie);
    } else {
      this.rhythmTransitionHelper.reserveClipTransitionTime(paramTAVMovie);
    }
    if (isNeedCycleFill(localList))
    {
      paramTAVMovie = separateClipsWithoutAdjust(paramTAVMovie, true);
      this.rhythmTransitionHelper.reRandomTransitions(localList.size());
    }
    else if (paramTAVRhythmAdjustClipType == TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1)
    {
      paramTAVMovie = separateClipsWithAdjust(paramTAVMovie);
    }
    else
    {
      paramTAVMovie = separateClipsWithoutAdjust(paramTAVMovie, false);
    }
    correctSegments(buildSegmentsFromClips(paramTAVMovie));
    paramTAVMovie = getTAVClipsFromSegments(this.mCorrectSegments);
    this.rhythmTransitionHelper.addExtraInfoToClip(paramTAVMovie, getFaceTransitions());
    paramTAVRhythmAdjustClipType = new StringBuilder();
    paramTAVRhythmAdjustClipType.append("correct segments count: ");
    paramTAVRhythmAdjustClipType.append(this.mCorrectSegments.size());
    paramTAVRhythmAdjustClipType.append(", channel count: ");
    if (paramTAVMovie == null) {
      i = j;
    } else {
      i = paramTAVMovie.size();
    }
    paramTAVRhythmAdjustClipType.append(i);
    appendDebugInfo(paramTAVRhythmAdjustClipType.toString());
    return paramTAVMovie;
  }
  
  public List<CMTime> covertTAVEffectPointsToCMTimes(List<TAVEffectPoint> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new CMTime(((TAVEffectPoint)paramList.next()).getTime(), 1000).sub(this.musicRealStart));
      }
    }
    return localArrayList;
  }
  
  public List<TAVRhythmMovieSegment> getCorrectSegments()
  {
    return this.mCorrectSegments;
  }
  
  public TAVLUTAutomaticEffect getLutEffect()
  {
    if ((!this.highlightPoints.isEmpty()) && (!this.highlightEffects.isEmpty()) && (this.singleResource))
    {
      long l = ((float)((TAVEffectPoint)this.highlightPoints.get(0)).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F);
      if (l >= 0L)
      {
        Object localObject1 = this.highlightEffects.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TAVEffectAutomaticEffect)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((TAVEffectAutomaticEffect)localObject2).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT))
          {
            localObject1 = (TAVLUTAutomaticEffect)localObject2;
            ((TAVLUTAutomaticEffect)localObject1).setStartOffset(l);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("add highlight lut filter: ");
            ((StringBuilder)localObject2).append(((TAVLUTAutomaticEffect)localObject1).getFilePath());
            ((StringBuilder)localObject2).append(", start offset: ");
            ((StringBuilder)localObject2).append(l);
            appendDebugInfo(((StringBuilder)localObject2).toString());
            return localObject1;
          }
        }
      }
    }
    return super.getLutEffect();
  }
  
  public TAVRhythmAutomaticTemplate.TAVRhythmRandomType getRandomType()
  {
    return this.randomType;
  }
  
  public String getRhythmEffectID()
  {
    return this.rhythmEffectID;
  }
  
  public List<Integer> getSecondApplyEffectsRandomIndices()
  {
    return this.secondApplyEffectsRandomIndices;
  }
  
  public ArrayList<TAVTransitionAutomaticEffect> getTransitionApplyEffects()
  {
    return this.rhythmTransitionHelper.getTransitionAutomaticEffectList();
  }
  
  public boolean isOpeningEffectEnable()
  {
    if ((!this.highlightPoints.isEmpty()) && ((float)((TAVEffectPoint)this.highlightPoints.get(0)).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F < 3000.0F))
    {
      appendDebugInfo("OpeningEffect: false");
      return false;
    }
    appendDebugInfo("OpeningEffect: true");
    return true;
  }
  
  public boolean isRhythmTemplate()
  {
    return this.isRhythmTemplate;
  }
  
  public void parseMusicRhythm(Context paramContext, @NonNull String paramString1, @NonNull String paramString2, long paramLong, @Nullable List<Integer> paramList, int paramInt)
  {
    this.randomIndex = paramInt;
    this.secondApplyEffectsRandomIndices.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.secondApplyEffectsRandomIndices.addAll(paramList);
    }
    randomRhythmChannleAndAdjustMode();
    paramString1 = JsonUtils.parseRhythmTemplate(paramContext, paramString1);
    setContext(paramContext);
    loadMusicEffectPointsWithRhythmDataBean(paramString1, paramString2, paramLong);
    checkRhythmTransitionHelper();
  }
  
  public void parseToMovie(@NonNull TAVMovie paramTAVMovie)
  {
    super.parseToMovie(paramTAVMovie);
    this.movie = paramTAVMovie;
    if (paramTAVMovie.getClips().size() == 1) {
      this.singleResource = true;
    }
    fillRandomType(paramTAVMovie);
    configSegments();
    configMusicSecondEffects();
    checkRhythmTransitionHelper();
  }
  
  public void setMaxVideoDuration(long paramLong)
  {
    this.maxVideoDuration = new CMTime(paramLong, 1000);
  }
  
  public void setTemplateDir(String paramString)
  {
    super.setTemplateDir(paramString);
    this.highlightEffectsPath = paramString;
    this.secondEffectsPath = paramString;
  }
  
  public void setTransitionEffects(ArrayList<TAVTransitionAutomaticEffect> paramArrayList)
  {
    this.rhythmTransitionHelper.setTransitionAutomaticEffectList(paramArrayList);
    if (TAVAutomaticTemplate.isMapping)
    {
      this.rhythmTransitionHelper.computeTransitionTimes();
      return;
    }
    this.rhythmTransitionHelper.computeTransitionTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.TAVRhythmAutomaticTemplate
 * JD-Core Version:    0.7.0.1
 */