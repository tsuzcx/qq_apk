package com.tencent.autotemplate;

import android.content.Context;
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
import com.tencent.autotemplate.utils.JsonUtils;
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
import java.util.List<Lcom.tencent.tavmovie.base.TAVMovieClip;>;

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
          appendDebugInfo("add time effect to effect point at:" + ((TAVTimeAutomaticEffect)localObject).getStartOffset() + " ,speed:" + localTAVMovieTimeEffect.getSpeed());
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    if (this.singleResource) {}
    for (localList = TAVRhythmTimeEffectUtils.applyTimeEffectsInPreviewTimeline(localList, localArrayList);; localList = TAVRhythmTimeEffectWithCutUtils.applyTimeEffectsInPreviewTimeline(localList, localArrayList, covertTAVEffectPointsToCMTimes(this.secondEffectPoints)))
    {
      paramTAVComposition.getVideoChannels().remove(0);
      paramTAVComposition.getVideoChannels().add(0, localList);
      return;
    }
  }
  
  private void applyTimeEffectToHighlightPoint(TAVComposition paramTAVComposition)
  {
    if (!this.singleResource) {}
    for (;;)
    {
      return;
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
            f = (float)l;
            l = (localCMTime.getTimeSeconds() * 1000.0F + f);
          }
          float f = (float)((TAVEffectPoint)this.highlightPoints.get(0)).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F;
          ((TAVTimeAutomaticEffect)localObject2).setStartOffset(f);
          ((TAVTimeAutomaticEffect)localObject2).setDuration((((float)l - f) / ((TAVTimeAutomaticEffect)localObject2).getSpeed()));
          localObject2 = ((TAVTimeAutomaticEffect)localObject2).convertToMovieTimeEffect((float)l);
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(localObject2);
          localObject1 = TAVRhythmTimeEffectUtils.applyTimeEffectsInPreviewTimeline((List)localObject1, (List)localObject3);
          paramTAVComposition.getVideoChannels().remove(0);
          paramTAVComposition.getVideoChannels().add(0, localObject1);
          appendDebugInfo("add time effect to hightlight at: " + f + " ,speed:" + ((TAVMovieTimeEffect)localObject2).getSpeed());
        }
      }
    }
  }
  
  private void applyTransitonToSegment(TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect, TAVSticker paramTAVSticker, CMTime paramCMTime, long paramLong)
  {
    if (paramTAVTransitionAutomaticEffect.isFaceTransition())
    {
      paramTAVSticker = new CMTimeRange(paramCMTime, new CMTime(paramLong, 1000));
      paramCMTime = new FaceTransition();
      paramCMTime.timeRange = paramTAVSticker;
      paramCMTime.procMethod = paramTAVTransitionAutomaticEffect.getProcMethod();
      getFaceTransitions().add(paramCMTime);
    }
    TAVSticker localTAVSticker;
    do
    {
      return;
      localTAVSticker = paramTAVSticker;
      if (paramTAVSticker == null) {
        localTAVSticker = this.rhythmTransitionHelper.getTransitionSticker(paramTAVTransitionAutomaticEffect);
      }
    } while (localTAVSticker == null);
    localTAVSticker.setTimeRange(new CMTimeRange(paramCMTime, new CMTime(paramLong, 1000)));
    this.transitionStickers.add(localTAVSticker);
    appendDebugInfo("add transition sticker " + localTAVSticker.getFilePath() + ", start offset: " + paramCMTime);
  }
  
  private List<TAVRhythmMovieSegment> buildSegmentsFromClips(List<TAVMovieClip> paramList)
  {
    Log.i("TAVRhythmTemplate", "buildSegmentsFromClips: ");
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = CMTime.CMTimeZero;
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Iterator localIterator = paramList.iterator();
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    TAVMovieClip localTAVMovieClip;
    if (localIterator.hasNext())
    {
      localTAVMovieClip = (TAVMovieClip)localIterator.next();
      if (!this.rhythmTransitionHelper.getTransitionDurationMsList().isEmpty()) {}
    }
    else
    {
      fillSegmentTAVClip(localArrayList);
      fillSegmentTimeEffect(localArrayList);
      return localArrayList;
    }
    CMTime localCMTime2 = localTAVMovieClip.getResource().getTimeRange().getDuration();
    TAVRhythmMovieSegment localTAVRhythmMovieSegment = new TAVRhythmMovieSegment();
    localTAVRhythmMovieSegment.setTimeRange(new CMTimeRange(localCMTime1, localCMTime2));
    long l1 = ((Long)this.rhythmTransitionHelper.getTransitionDurationMsList().get(j)).longValue();
    paramList = this.rhythmTransitionHelper.getTransitionEffect(j);
    Object localObject4 = null;
    boolean bool = needNormalTransition(localTAVMovieClip, (TAVMovieClip)localObject2, localCMTime1);
    Object localObject5;
    Object localObject6;
    long l2;
    if ((bool) && (needFaceSubTransition(paramList, localTAVMovieClip, (TAVMovieClip)localObject2)))
    {
      localObject5 = this.rhythmTransitionHelper.getFaceTransitionSubTransition(paramList.subTransitions);
      localObject6 = this.rhythmTransitionHelper.getTransitionSticker((TAVTransitionAutomaticEffect)localObject5);
      l2 = ((TAVSticker)localObject6).durationTime() / 1000L;
      if (l2 > l1) {
        bool = false;
      }
    }
    for (;;)
    {
      label238:
      localObject5 = new CMTime(l1 / 2L, 1000);
      int i = j;
      if (bool)
      {
        i = j;
        if (this.rhythmTransitionHelper.isDurationEnoughForTransition((CMTime)localObject3, localCMTime2, l1))
        {
          localObject3 = ((TAVMovieClip)localObject2).getResource();
          localObject2 = localTAVMovieClip.getResource();
          localObject6 = ((TAVMovieResource)localObject3).getTimeRange();
          ((CMTimeRange)localObject6).setDuration(((CMTimeRange)localObject6).getDuration().add((CMTime)localObject5));
          ((TAVMovieResource)localObject3).setDuration(((TAVMovieResource)localObject3).getDuration().add((CMTime)localObject5));
          localObject3 = ((TAVRhythmMovieSegment)localObject1).getTimeRange();
          ((CMTimeRange)localObject3).setDuration(((CMTimeRange)localObject3).getDuration().add((CMTime)localObject5));
          ((TAVRhythmMovieSegment)localObject1).setTimeRange((CMTimeRange)localObject3);
          localObject1 = ((TAVMovieResource)localObject2).getTimeRange();
          if ((localObject2 instanceof TAVMovieImageResource))
          {
            ((CMTimeRange)localObject1).setDuration(((CMTimeRange)localObject1).getDuration().add((CMTime)localObject5));
            ((TAVMovieResource)localObject2).setDuration(((TAVMovieResource)localObject2).getDuration().add((CMTime)localObject5));
            label406:
            localObject1 = localTAVRhythmMovieSegment.getTimeRange();
            ((CMTimeRange)localObject1).setDuration(((CMTimeRange)localObject1).getDuration().add((CMTime)localObject5));
            localObject2 = ((CMTimeRange)localObject1).getStart().sub((CMTime)localObject5);
            ((CMTimeRange)localObject1).setStart((CMTime)localObject2);
            localTAVRhythmMovieSegment.setTimeRange((CMTimeRange)localObject1);
            applyTransitonToSegment(paramList, (TAVSticker)localObject4, (CMTime)localObject2, l1);
            j += 1;
            i = j;
            if (j < this.rhythmTransitionHelper.getTransitionDurationMsList().size()) {
              break label608;
            }
            i = 0;
          }
        }
      }
      label608:
      for (;;)
      {
        paramList = new ArrayList();
        paramList.add(localTAVMovieClip);
        localTAVRhythmMovieSegment.setTavMovieClips(paramList);
        localArrayList.add(localTAVRhythmMovieSegment);
        localCMTime1 = localCMTime1.add(localCMTime2);
        localObject1 = localTAVRhythmMovieSegment;
        localObject2 = localTAVMovieClip;
        localObject3 = localCMTime2;
        j = i;
        break;
        localObject4 = localObject6;
        paramList = (List<TAVMovieClip>)localObject5;
        l1 = l2;
        break label238;
        ((CMTimeRange)localObject1).setStart(((CMTimeRange)localObject1).getStart().sub((CMTime)localObject5));
        ((CMTimeRange)localObject1).setDuration(((CMTimeRange)localObject1).getDuration().add((CMTime)localObject5));
        ((TAVMovieResource)localObject2).setDuration(((TAVMovieResource)localObject2).getDuration().add((CMTime)localObject5));
        break label406;
      }
    }
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
    if (!this.singleResource) {}
    while ((this.highlightPoints.isEmpty()) || (this.secondEffects.isEmpty()) || (this.secondEffectPoints.isEmpty())) {
      return;
    }
    Iterator localIterator = this.secondEffectPoints.iterator();
    int i = 0;
    label66:
    if (localIterator.hasNext())
    {
      long l = ((float)((TAVEffectPoint)localIterator.next()).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F);
      if ((l <= 0L) || ((float)l >= this.maxVideoDuration.getTimeSeconds() * 1000.0F)) {
        break label329;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject = null;
      if (this.secondEffectType == TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectSpeed) {
        localObject = getTimeEffectFromEffectsGroup(this.secondEffects, false);
      }
      do
      {
        for (;;)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TAVEffectAutomaticEffect localTAVEffectAutomaticEffect = ((TAVEffectAutomaticEffect)((Iterator)localObject).next()).copy();
            localTAVEffectAutomaticEffect.setStartOffset(l);
            localArrayList.add(localTAVEffectAutomaticEffect);
          }
          if (this.secondEffectType != TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectFreeze) {
            break;
          }
          localObject = getTimeEffectFromEffectsGroup(this.secondEffects, true);
        }
      } while (this.secondEffectType != TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix);
      if (i < this.secondApplyEffectsRandomIndices.size()) {}
      for (int j = ((Integer)this.secondApplyEffectsRandomIndices.get(i)).intValue();; j = RandomUtils.randomInt(0, this.secondEffects.size()))
      {
        localObject = (List)this.secondEffects.get(j);
        break;
      }
      this.secondApplyEffects.add(localArrayList);
      i += 1;
    }
    label329:
    for (;;)
    {
      break label66;
      break;
    }
  }
  
  private void configSegments()
  {
    int j = 0;
    CMTime localCMTime1 = CMTime.CMTimeZero;
    CMTime localCMTime2 = this.maxVideoDuration;
    List localList;
    int i;
    if (this.randomType == TAVRhythmAutomaticTemplate.TAVRhythmRandomType.TAVRhythmMultiPicSlow)
    {
      localList = this.slowEffectPoints;
      i = 0;
      j = 1;
    }
    for (;;)
    {
      if (i < localList.size())
      {
        localObject1 = (TAVEffectPoint)localList.get(i);
        if ((!TextUtils.equals(((TAVEffectPoint)localObject1).getType(), "PuckingDrum")) && (j == 0)) {
          break label299;
        }
        localObject1 = new CMTime(((TAVEffectPoint)localObject1).getTime(), 1000);
        if ((!localCMTime1.bigThan(localCMTime2)) && (!localCMTime1.equals(localCMTime2))) {}
      }
      else
      {
        return;
        localList = this.drumEffectPoints;
        i = 0;
        continue;
      }
      if (((CMTime)localObject1).bigThan(this.musicRealStart)) {
        break;
      }
      i += 1;
    }
    Object localObject2 = ((CMTime)localObject1).sub(this.musicRealStart).sub(localCMTime1);
    Object localObject1 = localObject2;
    if (localCMTime1.add((CMTime)localObject2).bigThan(localCMTime2)) {
      localObject1 = localCMTime2.sub(localCMTime1);
    }
    localObject2 = new TAVRhythmMovieSegment();
    ((TAVRhythmMovieSegment)localObject2).setTimeRange(new CMTimeRange(localCMTime1, (CMTime)localObject1));
    this.segments.add(localObject2);
    ArrayList localArrayList = new ArrayList();
    TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
    localTAVMovieTimeEffect.setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject1));
    localTAVMovieTimeEffect.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject1));
    localArrayList.add(localTAVMovieTimeEffect);
    ((TAVRhythmMovieSegment)localObject2).setTimeEffects(localArrayList);
    localCMTime1 = localCMTime1.add((CMTime)localObject1);
    label299:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  private void correctSegments(List<TAVRhythmMovieSegment> paramList)
  {
    this.mCorrectSegments.addAll(paramList);
    int i = 0;
    if (i < this.mCorrectSegments.size())
    {
      paramList = (TAVRhythmMovieSegment)this.mCorrectSegments.get(i);
      paramList.setIndex(i);
      if (i != this.mCorrectSegments.size() - 1) {}
    }
    else
    {
      paramList = this.mCorrectSegments.iterator();
    }
    label302:
    for (;;)
    {
      label70:
      if (!paramList.hasNext()) {
        return;
      }
      Object localObject = (TAVRhythmMovieSegment)paramList.next();
      if ((localObject == null) || (((TAVRhythmMovieSegment)localObject).getTavMovieClips() == null) || (((TAVRhythmMovieSegment)localObject).getTavMovieClips().isEmpty()) || (((TAVRhythmMovieSegment)localObject).getTavClips() == null) || (((TAVRhythmMovieSegment)localObject).getTavClips().isEmpty()) || ((((TAVRhythmMovieSegment)localObject).getOverlapTimeRange() != null) && (((TAVRhythmMovieSegment)localObject).getTimeRange().getEnd().smallThan(((TAVRhythmMovieSegment)localObject).getOverlapTimeRange().getEnd())))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label302;
        }
        paramList.remove();
        break label70;
        TAVRhythmMovieSegment localTAVRhythmMovieSegment = (TAVRhythmMovieSegment)this.mCorrectSegments.get(i + 1);
        CMTimeRange localCMTimeRange = paramList.getTimeRange();
        paramList = localCMTimeRange.getEnd();
        localObject = localTAVRhythmMovieSegment.getTimeRange();
        CMTime localCMTime = ((CMTimeRange)localObject).getStart();
        localObject = ((CMTimeRange)localObject).getEnd();
        if (localCMTimeRange.containsTime(localCMTime)) {
          if (paramList.bigThan((CMTime)localObject))
          {
            paramList = (List<TAVRhythmMovieSegment>)localObject;
            label239:
            localTAVRhythmMovieSegment.setOverlapTimeRange(new CMTimeRange(localCMTime, paramList.sub(localCMTime)));
            localTAVRhythmMovieSegment.setCorrectStartTime(localCMTime.add(paramList.sub(localCMTime).divide(2.0F)));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          break label239;
          localTAVRhythmMovieSegment.setCorrectStartTime(localCMTime);
        }
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
      RhythmDataBean.PackedEffectPoints localPackedEffectPoints = (RhythmDataBean.PackedEffectPoints)paramRhythmDataBean.next();
      if ((localPackedEffectPoints != null) && (localPackedEffectPoints.name != null) && (localPackedEffectPoints.effectPoints != null))
      {
        String str = localPackedEffectPoints.name;
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            this.highlightPoints.addAll(localPackedEffectPoints.effectPoints);
            Log.i("TAVRhythmTemplate", "init HighlightValueTrail, size:" + this.highlightPoints.size());
            break;
            if (str.equals("HighlightValueTrail"))
            {
              i = 0;
              continue;
              if (str.equals("StartValueTrail"))
              {
                i = 1;
                continue;
                if (str.equals("BpmValueTrail"))
                {
                  i = 2;
                  continue;
                  if (str.equals("SlowRhythmTrail"))
                  {
                    i = 3;
                    continue;
                    if (str.equals("DrumTrail")) {
                      i = 4;
                    }
                  }
                }
              }
            }
            break;
          }
        }
        if ((localPackedEffectPoints.effectPoints != null) && (!localPackedEffectPoints.effectPoints.isEmpty()))
        {
          this.start = new CMTime(((TAVEffectPoint)localPackedEffectPoints.effectPoints.get(0)).getTime(), 1000);
          Log.i("TAVRhythmTemplate", "init start time:" + this.start.getTimeSeconds() * 1000.0F);
          if (localPackedEffectPoints.effectPoints.size() > 1)
          {
            long l = ((TAVEffectPoint)localPackedEffectPoints.effectPoints.get(1)).getTime() - ((TAVEffectPoint)localPackedEffectPoints.effectPoints.get(0)).getTime();
            if (l > 0L) {}
            for (this.maxDuration = new CMTime(l, 1000);; this.maxDuration = new CMTime(-l, 1000))
            {
              Log.i("TAVRhythmTemplate", "init max duration:" + this.maxDuration.getTimeSeconds() * 1000.0F);
              break;
            }
            this.bpmEffectPoints.addAll(localPackedEffectPoints.effectPoints);
            sortPoints(this.bpmEffectPoints);
            Log.i("TAVRhythmTemplate", "init BpmValueTrail, size:" + this.bpmEffectPoints.size());
            continue;
            this.slowEffectPoints.addAll(localPackedEffectPoints.effectPoints);
            sortPoints(this.slowEffectPoints);
            Log.i("TAVRhythmTemplate", "init SlowRhythmTrail, size:" + this.slowEffectPoints.size());
            continue;
            this.drumEffectPoints.addAll(localPackedEffectPoints.effectPoints);
            sortPoints(this.drumEffectPoints);
            Log.i("TAVRhythmTemplate", "init DrumTrail, size:" + this.drumEffectPoints.size());
          }
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
    if (this.rhythmType == TAVRhythmAutomaticTemplate.TAVRhythmEffectType.TAVRhythmBPMChannel) {
      this.secondEffectPoints.addAll(this.bpmEffectPoints);
    }
    while (this.rhythmType != TAVRhythmAutomaticTemplate.TAVRhythmEffectType.TAVRhythmSlowChannel) {
      return;
    }
    this.secondEffectPoints.addAll(this.slowEffectPoints);
  }
  
  private void fillSegmentTAVClip(List<TAVRhythmMovieSegment> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      int i = 0;
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
    int i = 0;
    this.secondApplyEffectsRandomIndices.clear();
    if ((this.secondEffects.isEmpty()) || (this.secondEffectPoints.isEmpty())) {}
    for (;;)
    {
      return;
      label49:
      long l;
      if (this.secondEffectApplyType == TAVRhythmAutomaticTemplate.ApplyEffectType.SequenceApplyEffect.ordinal())
      {
        if (i < this.secondEffectPoints.size())
        {
          l = ((float)((TAVEffectPoint)this.secondEffectPoints.get(i)).getTime() - this.musicRealStart.getTimeSeconds() * 1000.0F);
          if ((l > 0L) && ((float)l <= this.maxVideoDuration.getTimeSeconds() * 1000.0F)) {
            break label121;
          }
        }
        for (;;)
        {
          i += 1;
          break label49;
          break;
          label121:
          if (this.secondEffectType == TAVRhythmAutomaticTemplate.TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix)
          {
            int j = this.secondEffects.size();
            this.secondApplyEffectsRandomIndices.add(Integer.valueOf(i % j));
          }
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
      else if (this.secondEffectApplyType == TAVRhythmAutomaticTemplate.ApplyEffectType.DefaultApplyEffect.ordinal())
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
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    label474:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (paramList.hasNext())
      {
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
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (List)((Iterator)localObject3).next();
            if (!((TAVRhythmMovieSegment)((List)localObject4).get(((List)localObject4).size() - 1)).getTimeRange().containsTime(((TAVRhythmMovieSegment)localObject2).getTimeRange().getStart())) {
              ((List)localObject4).add(localObject2);
            }
          }
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label474;
          }
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject2);
          ((List)localObject1).add(localObject3);
          break;
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
              if (i == 0) {
                if (((TAVRhythmMovieSegment)localObject4).getTimeRange().getStart().bigThan(CMTime.CMTimeZero)) {
                  ((List)localObject3).add(new TAVClip(new TAVEmptyResource(((TAVRhythmMovieSegment)((List)localObject2).get(0)).getTimeRange().getStart())));
                }
              }
              for (;;)
              {
                localObject4 = ((TAVRhythmMovieSegment)localObject4).getFullTavClips().iterator();
                while (((Iterator)localObject4).hasNext()) {
                  ((List)localObject3).add((TAVClip)((Iterator)localObject4).next());
                }
                Object localObject5 = (TAVRhythmMovieSegment)((List)localObject2).get(i - 1);
                localObject5 = ((TAVRhythmMovieSegment)localObject4).getTimeRange().getStart().sub(((TAVRhythmMovieSegment)localObject5).getTimeRange().getEnd());
                if (((CMTime)localObject5).bigThan(CMTime.CMTimeZero)) {
                  ((List)localObject3).add(new TAVClip(new TAVEmptyResource((CMTime)localObject5)));
                }
              }
              i += 1;
            }
            paramList.add(localObject3);
          }
          return paramList;
        }
      }
    }
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
    appendDebugInfo("clip start time: " + l / 1000L + ", don't match puckingDrum point");
    return false;
  }
  
  private void loadMusicEffectPointsWithRhythmDataBean(RhythmDataBean paramRhythmDataBean, String paramString, long paramLong)
  {
    clearLastPoints();
    if ((paramRhythmDataBean == null) || (paramRhythmDataBean.allData == null) || (paramRhythmDataBean.allData.isEmpty()))
    {
      this.isRhythmTemplate = false;
      configMusic(paramString, (float)paramLong);
      return;
    }
    this.isRhythmTemplate = true;
    fillAllChannelPoints(paramRhythmDataBean);
    fillSecondEffectPoints();
    fillEffects();
    configMusic(paramString, (float)paramLong);
    getSecondEffectsIndex();
  }
  
  private boolean needFaceSubTransition(TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect, TAVMovieClip paramTAVMovieClip1, TAVMovieClip paramTAVMovieClip2)
  {
    return (paramTAVTransitionAutomaticEffect.isFaceTransition()) && ((!this.rhythmTransitionHelper.clipSupportFaceTransition(paramTAVMovieClip2)) || (!this.rhythmTransitionHelper.clipSupportFaceTransition(paramTAVMovieClip1))) && (!CollectionUtil.isEmptyList(paramTAVTransitionAutomaticEffect.subTransitions));
  }
  
  private boolean needNormalTransition(TAVMovieClip paramTAVMovieClip1, TAVMovieClip paramTAVMovieClip2, CMTime paramCMTime)
  {
    return (paramTAVMovieClip2 != null) && (isPointInPuckingDrum(paramCMTime)) && (this.rhythmTransitionHelper.isClipReserveTransitionDuration(paramTAVMovieClip2)) && (this.rhythmTransitionHelper.isClipReserveTransitionDuration(paramTAVMovieClip1));
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
  
  private List<TAVMovieClip> separateClipsWithAdjust(List<TAVMovieClip> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = CMTime.CMTimeZero;
    Object localObject2 = CMTime.CMTimeZero;
    Object localObject3 = this.segments.iterator();
    Logger.d("TAVRhythmTemplate", "separateClipsWithAdjust maxDuration " + this.maxDuration);
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TAVRhythmMovieSegment)((Iterator)localObject3).next();
      if (localObject4 == null) {
        ((Iterator)localObject3).remove();
      }
      for (;;)
      {
        break;
        localObject1 = ((CMTime)localObject1).add(((TAVRhythmMovieSegment)localObject4).getTimeRange().getDuration());
      }
    }
    if ((((CMTime)localObject1).equalsTo(CMTime.CMTimeZero)) || (((CMTime)localObject1).smallThan(CMTime.CMTimeZero))) {
      return localArrayList;
    }
    if (((CMTime)localObject1).bigThan(this.maxDuration)) {}
    for (Object localObject4 = this.maxDuration;; localObject4 = localObject1)
    {
      CMTime localCMTime1 = CMTime.CMTimeZero;
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (TAVMovieClip)((Iterator)localObject1).next();
        if ((localObject3 == null) || (((TAVMovieClip)localObject3).getResource() == null) || (((TAVMovieClip)localObject3).getResource().getTimeRange() == null)) {
          ((Iterator)localObject1).remove();
        } else if (!(((TAVMovieClip)localObject3).getResource() instanceof TAVMovieImageResource)) {
          localCMTime1 = localCMTime1.add(((TAVMovieClip)localObject3).getResource().getTimeRange().getDuration());
        }
      }
      if ((localCMTime1.equalsTo(CMTime.CMTimeZero)) || (localCMTime1.smallThan(CMTime.CMTimeZero))) {
        return localArrayList;
      }
      localObject1 = CMTime.CMTimeZero;
      int i = 0;
      int k = 0;
      Object localObject7;
      if (k < paramList.size())
      {
        localObject7 = (TAVMovieClip)paramList.get(k);
        if (i < this.segments.size()) {}
      }
      else
      {
        Logger.d("TAVRhythmTemplate", "separateClipsWithAdjust fillTotalDuration " + localObject4);
        Logger.d("TAVRhythmTemplate", "separateClipsWithAdjust totalDuration " + localObject2);
        return localArrayList;
      }
      label437:
      Object localObject6;
      if ((((TAVMovieClip)localObject7).getResource() instanceof TAVMovieImageResource))
      {
        localObject3 = ((TAVRhythmMovieSegment)this.segments.get(i)).getMinOriginDuration();
        if (!((CMTime)localObject1).equalsTo(CMTime.CMTimeZero))
        {
          localObject5 = CMTime.CMTimeZero;
          localObject3 = localObject1;
          localObject1 = localObject5;
          localObject5 = ((TAVMovieClip)localObject7).clone();
          localObject6 = ((TAVMovieClip)localObject5).getResource();
          localObject7 = ((TAVMovieResource)localObject6).getTimeRange();
          ((CMTimeRange)localObject7).setDuration((CMTime)localObject3);
          ((TAVMovieResource)localObject6).setTimeRange((CMTimeRange)localObject7);
          ((TAVMovieResource)localObject6).setDuration((CMTime)localObject3);
          localArrayList.add(localObject5);
        }
      }
      CMTime localCMTime2;
      do
      {
        k += 1;
        break;
        i += 1;
        break label437;
        localCMTime2 = ((TAVMovieClip)localObject7).getResource().getTimeRange().getDuration().clone();
      } while (localCMTime2.equalsTo(CMTime.CMTimeZero));
      Object localObject5 = localCMTime2.multi((CMTime)localObject4).divide(localCMTime1);
      if (localCMTime2.smallThan((CMTime)localObject5)) {
        localObject5 = localCMTime2;
      }
      for (;;)
      {
        localObject6 = CMTime.CMTimeZero;
        if (!((CMTime)localObject1).equalsTo(CMTime.CMTimeZero))
        {
          localObject1 = ((CMTime)localObject6).add((CMTime)localObject1);
          localObject3 = CMTime.CMTimeZero;
        }
        for (;;)
        {
          int j = i;
          if (i < this.segments.size())
          {
            localObject6 = (TAVRhythmMovieSegment)this.segments.get(i);
            if (((CMTime)localObject1).smallThan((CMTime)localObject5))
            {
              localObject1 = ((CMTime)localObject1).add(((TAVRhythmMovieSegment)localObject6).getMinOriginDuration());
              i += 1;
            }
            else
            {
              j = i - 1;
            }
          }
          else
          {
            i = j;
            if (j == this.segments.size()) {
              i = j - 1;
            }
            TAVMovieClip localTAVMovieClip = ((TAVMovieClip)localObject7).clone();
            CMTimeRange localCMTimeRange = localTAVMovieClip.getResource().getTimeRange();
            localObject7 = CMTime.CMTimeZero;
            localObject6 = localObject7;
            if (i >= 0)
            {
              localObject6 = localObject7;
              if (i < this.segments.size()) {
                localObject6 = ((TAVRhythmMovieSegment)this.segments.get(i)).getMinOriginDuration();
              }
            }
            localObject7 = localObject1;
            if (((CMTime)localObject1).bigThan((CMTime)localObject5)) {
              localObject7 = ((CMTime)localObject1).sub((CMTime)localObject6);
            }
            if (((CMTime)localObject7).equalsTo(CMTime.CMTimeZero))
            {
              localObject1 = ((CMTime)localObject6).sub((CMTime)localObject5);
              localCMTimeRange.setDuration((CMTime)localObject5);
              localTAVMovieClip.getResource().setDuration((CMTime)localObject5);
              localObject2 = ((CMTime)localObject2).add(localCMTimeRange.getDuration());
              localTAVMovieClip.getResource().setTimeRange(localCMTimeRange);
              localArrayList.add(localTAVMovieClip);
              i += 1;
              break;
            }
            if (!localCMTime2.bigThan((CMTime)localObject7))
            {
              localObject1 = localObject2;
              if (!localCMTime2.equalsTo((CMTime)localObject7)) {}
            }
            else
            {
              localCMTimeRange.setDuration((CMTime)localObject7);
              localTAVMovieClip.getResource().setDuration((CMTime)localObject7);
              localObject1 = ((CMTime)localObject2).add(localCMTimeRange.getDuration());
              localTAVMovieClip.getResource().setTimeRange(localCMTimeRange);
              localArrayList.add(localTAVMovieClip);
            }
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            localObject3 = localObject1;
            localObject1 = localObject6;
          }
        }
      }
    }
  }
  
  private List<TAVMovieClip> separateClipsWithoutAdjust(List<TAVMovieClip> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = CMTime.CMTimeZero;
    CMTime localCMTime = new CMTime(10000L, 1000);
    Object localObject2 = CMTime.CMTimeZero;
    int i = 0;
    int j = 0;
    int k = 0;
    if ((i >= paramList.size()) || (j >= this.segments.size())) {
      label66:
      return localArrayList;
    }
    Object localObject5 = CMTime.CMTimeZero;
    Object localObject4 = (TAVMovieClip)paramList.get(i);
    Object localObject3;
    label112:
    Object localObject6;
    int m;
    if ((((TAVMovieClip)localObject4).getResource() instanceof TAVMovieImageResource)) {
      if (!((CMTime)localObject2).equalsTo(CMTime.CMTimeZero))
      {
        localObject3 = localObject2;
        localObject4 = ((TAVMovieClip)localObject4).clone();
        localObject5 = ((TAVMovieClip)localObject4).getResource();
        localObject6 = ((TAVMovieResource)localObject5).getTimeRange();
        ((CMTimeRange)localObject6).setDuration((CMTime)localObject3);
        ((TAVMovieResource)localObject5).setTimeRange((CMTimeRange)localObject6);
        ((TAVMovieResource)localObject5).setDuration((CMTime)localObject3);
        localArrayList.add(localObject4);
        localObject3 = ((CMTime)localObject1).add((CMTime)localObject3);
        localObject1 = localObject2;
        m = i;
        i = j;
        localObject2 = localObject3;
        j = m;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        m = j;
        localObject3 = localObject2;
        localObject2 = localObject1;
        j = i;
        i = m;
        localObject1 = localObject3;
        break;
        localObject3 = ((TAVRhythmMovieSegment)this.segments.get(j)).getMinOriginDuration().clone();
        j += 1;
        break label112;
        localObject6 = ((TAVMovieClip)localObject4).getResource().getTimeRange().getDuration();
        TAVMovieClip localTAVMovieClip = ((TAVMovieClip)localObject4).clone();
        CMTimeRange localCMTimeRange = localTAVMovieClip.getResource().getTimeRange();
        localObject4 = localObject5;
        localObject3 = localObject2;
        m = j;
        if (!((CMTime)localObject2).equalsTo(CMTime.CMTimeZero))
        {
          localObject4 = ((CMTime)localObject5).add((CMTime)localObject2);
          localObject3 = CMTime.CMTimeZero;
          m = j;
        }
        for (;;)
        {
          n = m;
          if (m >= this.segments.size()) {
            break label393;
          }
          localObject2 = (TAVRhythmMovieSegment)this.segments.get(m);
          if (!((CMTime)localObject4).smallThan((CMTime)localObject6)) {
            break;
          }
          localObject4 = ((CMTime)localObject4).add(((TAVRhythmMovieSegment)localObject2).getMinOriginDuration());
          m += 1;
        }
        int n = m - 1;
        label393:
        j = n;
        if (n == this.segments.size()) {
          j = n - 1;
        }
        localObject5 = CMTime.CMTimeZero;
        localObject2 = localObject5;
        if (j >= 0)
        {
          localObject2 = localObject5;
          if (j < this.segments.size()) {
            localObject2 = ((TAVRhythmMovieSegment)this.segments.get(j)).getMinOriginDuration();
          }
        }
        localObject5 = localObject4;
        if (((CMTime)localObject4).bigThan((CMTime)localObject6)) {
          localObject5 = ((CMTime)localObject4).sub((CMTime)localObject2);
        }
        if (((CMTime)localObject5).equalsTo(CMTime.CMTimeZero))
        {
          localObject2 = ((CMTime)localObject2).sub((CMTime)localObject6);
          localCMTimeRange.setDuration((CMTime)localObject6);
          localTAVMovieClip.getResource().setDuration((CMTime)localObject6);
          localTAVMovieClip.getResource().setTimeRange(localCMTimeRange);
          localArrayList.add(localTAVMovieClip);
          i += 1;
          m = j + 1;
          localObject3 = localObject1;
          j = i;
          localObject1 = localObject2;
          i = m;
          localObject2 = localObject3;
          continue;
        }
        if ((!((CMTime)localObject6).bigThan((CMTime)localObject5)) && (!((CMTime)localObject6).equalsTo((CMTime)localObject5))) {
          break label749;
        }
        localCMTimeRange.setDuration((CMTime)localObject5);
        localTAVMovieClip.getResource().setDuration((CMTime)localObject5);
        localTAVMovieClip.getResource().setTimeRange(localCMTimeRange);
        localArrayList.add(localTAVMovieClip);
        m = i + 1;
        i = j;
        localObject2 = localObject1;
        j = m;
        localObject1 = localObject3;
        continue;
      }
      if ((k != 0) && (!((CMTime)localObject2).smallThan(localCMTime))) {
        break label66;
      }
      if ((((CMTime)localObject2).smallThan(localCMTime)) && (j == paramList.size() - 1))
      {
        k = 0;
        j = 1;
      }
      for (;;)
      {
        m = k;
        localObject3 = localObject2;
        k = j;
        localObject2 = localObject1;
        j = i;
        i = m;
        localObject1 = localObject3;
        break;
        m = j + 1;
        j = k;
        k = m;
      }
      label749:
      m = j;
      localObject2 = localObject1;
      j = i;
      localObject1 = localObject3;
      i = m;
    }
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
              appendDebugInfo("add highlight pag filter: " + ((TAVPagAutomaticEffect)localObject1).getFilePath() + ", start offset: " + l);
            }
            else if (((TAVEffectAutomaticEffect)localObject1).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT)
            {
              localObject1 = (TAVLUTAutomaticEffect)localObject1;
              ((TAVLUTAutomaticEffect)localObject1).setStartOffset(l);
              localObject2 = ((TAVLUTAutomaticEffect)localObject1).covertToMovieFilterWithDuraton(paramCMTime.getTimeSeconds() * 1000.0F);
              this.lutFilters.add(localObject2);
              appendDebugInfo("add highlight lut filter: " + ((TAVLUTAutomaticEffect)localObject1).getFilePath() + ", start offset: " + l);
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
          appendDebugInfo("add second effect pag filter: " + ((TAVPagAutomaticEffect)localObject2).getFilePath() + ", start offset: " + ((TAVPagAutomaticEffect)localObject2).getStartOffset());
        }
        else if (((TAVEffectAutomaticEffect)localObject2).getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT)
        {
          localObject2 = (TAVLUTAutomaticEffect)localObject2;
          localObject3 = ((TAVLUTAutomaticEffect)localObject2).covertToMovieFilterWithDuraton(paramCMTime.getTimeSeconds() * 1000.0F);
          this.lutFilters.add(localObject3);
          appendDebugInfo("add second effect lut filter: " + ((TAVLUTAutomaticEffect)localObject2).getFilePath() + ", start offset: " + ((TAVLUTAutomaticEffect)localObject2).getStartOffset());
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
    int j = 0;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    long l1;
    long l2;
    if ((j >= localList.size()) || (this.rhythmTransitionHelper.getTransitionDurationMsList().isEmpty()))
    {
      Logger.d("TAVRhythmTemplate", "buildCompositionFromSegments totalDuration " + paramTAVMovie.getTimeSeconds());
      fillSegmentTAVClip(paramList);
      fillSegmentTimeEffect(paramList);
      correctSegments(paramList);
      paramTAVMovie = getTAVClipsFromSegments(this.mCorrectSegments);
      this.rhythmTransitionHelper.addExtraInfoToClip(paramTAVMovie, getFaceTransitions());
      if ((paramTAVMovie != null) && (!paramTAVMovie.isEmpty())) {
        paramTAVMovie = paramTAVMovie.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramTAVMovie.hasNext())
        {
          paramList = (List)paramTAVMovie.next();
          localTAVComposition.getVideoChannels().add(paramList);
          localTAVComposition.getAudioChannels().add(paramList);
          continue;
          localObject1 = (TAVMovieClip)localList.get(j);
          localObject3 = (TAVRhythmMovieSegment)paramList.get(j);
          localObject2 = new ArrayList();
          ((List)localObject2).add(localObject1);
          ((TAVRhythmMovieSegment)localObject3).setTavMovieClips((List)localObject2);
          localObject2 = paramTAVMovie.add(((TAVMovieClip)localObject1).getResource().getTimeRange().getDuration());
          i = j + 1;
          if (i < localList.size())
          {
            paramTAVMovie = (TAVRhythmMovieSegment)paramList.get(i);
            localObject3 = ((TAVRhythmMovieSegment)localObject3).getTimeRange();
            localCMTime1 = paramTAVMovie.getTimeRange().getStart();
            localCMTime2 = ((CMTimeRange)localObject3).getEnd();
            localObject3 = (TAVMovieClip)localList.get(i);
            l1 = ((Long)this.rhythmTransitionHelper.getTransitionDurationMsList().get(j)).longValue();
            paramTAVMovie = this.rhythmTransitionHelper.getTransitionEffect(j);
            if (!needFaceSubTransition(paramTAVMovie, (TAVMovieClip)localObject1, (TAVMovieClip)localObject3)) {
              break label497;
            }
            localObject3 = this.rhythmTransitionHelper.getFaceTransitionSubTransition(paramTAVMovie.subTransitions);
            localObject1 = this.rhythmTransitionHelper.getTransitionSticker((TAVTransitionAutomaticEffect)localObject3);
            l2 = ((TAVSticker)localObject1).durationTime() / 1000L;
            if (l2 <= l1) {
              break label482;
            }
            i = 0;
            localObject1 = null;
          }
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (localCMTime2.sub(localCMTime1).bigThan(new CMTime(l1 / 2L, 1000)))) {
        applyTransitonToSegment(paramTAVMovie, (TAVSticker)localObject1, localCMTime1, l1);
      }
      j += 1;
      paramTAVMovie = (TAVMovie)localObject2;
      break;
      label482:
      l1 = l2;
      i = 1;
      paramTAVMovie = (TAVMovie)localObject3;
      continue;
      return localTAVComposition;
      label497:
      i = 1;
      localObject1 = null;
    }
  }
  
  public void configMusic(String paramString1, String paramString2, float paramFloat)
  {
    super.configMusic(paramString1, paramString2, paramFloat);
    this.musicRealStart = new CMTime(paramFloat, 1000);
  }
  
  public List<List<TAVClip>> convertClipsFromMovie(TAVMovie paramTAVMovie, TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType paramTAVRhythmAdjustClipType)
  {
    paramTAVMovie = CloneUtil.cloneMovieClips(paramTAVMovie.getClips());
    this.rhythmTransitionHelper.reRandomTransitions(paramTAVMovie);
    this.rhythmTransitionHelper.reserveClipTransitionTime(paramTAVMovie);
    if (isNeedCycleFill(paramTAVMovie))
    {
      paramTAVMovie = separateClipsWithoutAdjust(paramTAVMovie, true);
      this.rhythmTransitionHelper.reRandomTransitions(paramTAVMovie);
      correctSegments(buildSegmentsFromClips(paramTAVMovie));
      paramTAVMovie = getTAVClipsFromSegments(this.mCorrectSegments);
      this.rhythmTransitionHelper.addExtraInfoToClip(paramTAVMovie, getFaceTransitions());
      paramTAVRhythmAdjustClipType = new StringBuilder().append("correct segments count: ").append(this.mCorrectSegments.size()).append(", channel count: ");
      if (paramTAVMovie != null) {
        break label155;
      }
    }
    label155:
    for (int i = 0;; i = paramTAVMovie.size())
    {
      appendDebugInfo(i);
      return paramTAVMovie;
      if (paramTAVRhythmAdjustClipType == TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1)
      {
        paramTAVMovie = separateClipsWithAdjust(paramTAVMovie);
        break;
      }
      paramTAVMovie = separateClipsWithoutAdjust(paramTAVMovie, false);
      break;
    }
  }
  
  public List<CMTime> covertTAVEffectPointsToCMTimes(List<TAVEffectPoint> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new CMTime(((TAVEffectPoint)paramList.next()).getTime(), 1000).sub(this.musicRealStart));
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
        Object localObject = this.highlightEffects.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TAVEffectAutomaticEffect localTAVEffectAutomaticEffect = (TAVEffectAutomaticEffect)((Iterator)localObject).next();
          if ((localTAVEffectAutomaticEffect != null) && (localTAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT))
          {
            localObject = (TAVLUTAutomaticEffect)localTAVEffectAutomaticEffect;
            ((TAVLUTAutomaticEffect)localObject).setStartOffset(l);
            appendDebugInfo("add highlight lut filter: " + ((TAVLUTAutomaticEffect)localObject).getFilePath() + ", start offset: " + l);
            return localObject;
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
    this.rhythmTransitionHelper.computeTransitionTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.TAVRhythmAutomaticTemplate
 * JD-Core Version:    0.7.0.1
 */