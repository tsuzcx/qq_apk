package com.tencent.autotemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect.TAVEffectType;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.autotemplate.model.TAVEffectsModel;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.autotemplate.model.TAVPagAutomaticEffect;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.model.rhythm.TAVEffectPoint;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.autotemplate.model.rhythm.TAVTimeAutomaticEffect;
import com.tencent.autotemplate.parse.RhythmDataBean;
import com.tencent.autotemplate.parse.RhythmDataBean.PackedEffectPoints;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
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
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavsticker.model.TAVSticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.autotemplate.TAVRhythmMovieSegment;>;
import java.util.List<Lcom.tencent.tavmovie.base.TAVMovieClip;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
  private transient HashMap<String, Boolean> clipReserves = new HashMap();
  private transient List<TAVEffectPoint> drumEffectPoints = new ArrayList();
  private transient List<TAVEffectAutomaticEffect> highlightEffects = new ArrayList();
  private transient String highlightEffectsPath;
  private transient List<TAVEffectPoint> highlightPoints = new ArrayList();
  private transient boolean isRhythmTemplate;
  private transient List<TAVRhythmMovieSegment> mCorrectSegments = new ArrayList();
  private transient ArrayList<TAVTransitionAutomaticEffect> mTransitionAutomaticEffectList = new ArrayList();
  private transient ArrayList<Long> mTransitionDurationMsList = new ArrayList();
  private transient CMTime maxDuration = new CMTime(2147483647L, 1000);
  private transient CMTime maxVideoDuration = new CMTime(60000L, 1000);
  private transient TAVMovie movie;
  private transient CMTime musicRealStart = CMTime.CMTimeZero;
  private transient int randomIndex;
  private transient TAVRhythmAutomaticTemplate.TAVRhythmRandomType randomType;
  private transient String rhythmEffectID;
  private transient TAVRhythmEffects rhythmEffects;
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
    CMTime localCMTime = calculateTotalTime(paramTAVComposition);
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
  
  private List<TAVRhythmMovieSegment> buildSegmentsFromClips(List<TAVMovieClip> paramList)
  {
    Log.i("TAVRhythmTemplate", "buildSegmentsFromClips: ");
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = CMTime.CMTimeZero;
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Iterator localIterator = paramList.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    paramList = localCMTime1;
    int j = 0;
    TAVMovieClip localTAVMovieClip;
    if (localIterator.hasNext())
    {
      localTAVMovieClip = (TAVMovieClip)localIterator.next();
      if (!this.mTransitionDurationMsList.isEmpty()) {}
    }
    else
    {
      fillSegmentTAVClip(localArrayList);
      fillSegmentTimeEffect(localArrayList);
      return localArrayList;
    }
    localCMTime1 = localTAVMovieClip.getResource().getTimeRange().getDuration();
    TAVRhythmMovieSegment localTAVRhythmMovieSegment = new TAVRhythmMovieSegment();
    localTAVRhythmMovieSegment.setTimeRange(new CMTimeRange(paramList, localCMTime1));
    long l = ((Long)this.mTransitionDurationMsList.get(j)).longValue();
    CMTime localCMTime2 = new CMTime(l / 2L, 1000);
    int i = j;
    if (localObject2 != null)
    {
      i = j;
      if (isPointInPuckingDrum(paramList))
      {
        i = j;
        if (isDurationEnoughForTransition((CMTime)localObject3, localCMTime1, l))
        {
          i = j;
          if (isClipReserveTransitionDuration((TAVMovieClip)localObject2))
          {
            i = j;
            if (isClipReserveTransitionDuration(localTAVMovieClip))
            {
              localObject3 = ((TAVMovieClip)localObject2).getResource();
              localObject2 = localTAVMovieClip.getResource();
              CMTimeRange localCMTimeRange = ((TAVMovieResource)localObject3).getTimeRange();
              localCMTimeRange.setDuration(localCMTimeRange.getDuration().add(localCMTime2));
              ((TAVMovieResource)localObject3).setDuration(((TAVMovieResource)localObject3).getDuration().add(localCMTime2));
              localObject3 = ((TAVRhythmMovieSegment)localObject1).getTimeRange();
              ((CMTimeRange)localObject3).setDuration(((CMTimeRange)localObject3).getDuration().add(localCMTime2));
              ((TAVRhythmMovieSegment)localObject1).setTimeRange((CMTimeRange)localObject3);
              localObject1 = ((TAVMovieResource)localObject2).getTimeRange();
              if ((localObject2 instanceof TAVMovieImageResource))
              {
                ((CMTimeRange)localObject1).setDuration(((CMTimeRange)localObject1).getDuration().add(localCMTime2));
                ((TAVMovieResource)localObject2).setDuration(((TAVMovieResource)localObject2).getDuration().add(localCMTime2));
                label344:
                localObject1 = localTAVRhythmMovieSegment.getTimeRange();
                ((CMTimeRange)localObject1).setDuration(((CMTimeRange)localObject1).getDuration().add(localCMTime2));
                localObject2 = ((CMTimeRange)localObject1).getStart().sub(localCMTime2);
                ((CMTimeRange)localObject1).setStart((CMTime)localObject2);
                localTAVRhythmMovieSegment.setTimeRange((CMTimeRange)localObject1);
                localObject1 = getTransitionSticker(j);
                if (localObject1 != null)
                {
                  ((TAVSticker)localObject1).setTimeRange(new CMTimeRange((CMTime)localObject2, new CMTime(l, 1000)));
                  this.transitionStickers.add(localObject1);
                  appendDebugInfo("add transition sticker " + ((TAVSticker)localObject1).getFilePath() + ", start offset: " + localObject2);
                }
                j += 1;
                i = j;
                if (j < this.mTransitionDurationMsList.size()) {
                  break label609;
                }
                i = 0;
              }
            }
          }
        }
      }
    }
    label609:
    for (;;)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(localTAVMovieClip);
      localTAVRhythmMovieSegment.setTavMovieClips((List)localObject1);
      localArrayList.add(localTAVRhythmMovieSegment);
      paramList = paramList.add(localCMTime1);
      localObject1 = localTAVRhythmMovieSegment;
      localObject2 = localTAVMovieClip;
      localObject3 = localCMTime1;
      j = i;
      break;
      ((CMTimeRange)localObject1).setStart(((CMTimeRange)localObject1).getStart().sub(localCMTime2));
      ((CMTimeRange)localObject1).setDuration(((CMTimeRange)localObject1).getDuration().add(localCMTime2));
      ((TAVMovieResource)localObject2).setDuration(((TAVMovieResource)localObject2).getDuration().add(localCMTime2));
      break label344;
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
  
  private void computeTransitionTime()
  {
    this.mTransitionDurationMsList.clear();
    if ((this.mTransitionAutomaticEffectList != null) && (!this.mTransitionAutomaticEffectList.isEmpty()))
    {
      int i = 0;
      while (i < this.mTransitionAutomaticEffectList.size())
      {
        Object localObject = new TAVMovieSticker(this.templateDir + File.separator + ((TAVTransitionAutomaticEffect)this.mTransitionAutomaticEffectList.get(i)).parameter.filePath);
        if ((localObject != null) && (((TAVMovieSticker)localObject).getSticker() != null))
        {
          localObject = ((TAVMovieSticker)localObject).getSticker();
          this.mTransitionDurationMsList.add(Long.valueOf(((float)((TAVSticker)localObject).durationTime() / 1000.0F)));
        }
        i += 1;
      }
    }
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
  
  private void cutClip(TAVClip paramTAVClip, CMTime paramCMTime)
  {
    CMTimeRange localCMTimeRange = paramTAVClip.getResource().getSourceTimeRange();
    CMTime localCMTime1 = localCMTimeRange.getDuration();
    CMTime localCMTime2 = paramTAVClip.getResource().getScaledDuration();
    float f = localCMTime1.getTimeSeconds() / localCMTime2.getTimeSeconds();
    paramCMTime = localCMTime2.sub(paramCMTime);
    localCMTime1 = new CMTime((f * paramCMTime.getTimeSeconds() * 1000.0F), 1000);
    localCMTimeRange = new CMTimeRange(localCMTimeRange.getStart(), localCMTime1);
    paramTAVClip.getResource().setSourceTimeRange(localCMTimeRange);
    paramTAVClip.getResource().setDuration(localCMTime1);
    paramTAVClip.getResource().setScaledDuration(paramCMTime);
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
    if (isAllPhotoClip(paramTAVMovie))
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
  
  private String getTAVMovieClipFilePath(TAVMovieClip paramTAVMovieClip)
  {
    if (paramTAVMovieClip == null) {
      return null;
    }
    paramTAVMovieClip = paramTAVMovieClip.getResource();
    if ((paramTAVMovieClip instanceof TAVMovieTrackResource)) {
      return ((TAVMovieTrackResource)paramTAVMovieClip).getFilePath();
    }
    if ((paramTAVMovieClip instanceof TAVMovieImageResource)) {
      return ((TAVMovieImageResource)paramTAVMovieClip).getFilePath();
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
  
  private boolean isAllPhotoClip(List<TAVMovieClip> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TAVMovieClip localTAVMovieClip = (TAVMovieClip)paramList.next();
        if ((localTAVMovieClip != null) && (!(localTAVMovieClip.getResource() instanceof TAVMovieImageResource))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean isClipReserveTransitionDuration(TAVMovieClip paramTAVMovieClip)
  {
    String str = getTAVMovieClipFilePath(paramTAVMovieClip);
    if ((paramTAVMovieClip.getResource() instanceof TAVMovieImageResource)) {
      return true;
    }
    if (this.clipReserves.containsKey(str)) {
      return ((Boolean)this.clipReserves.get(str)).booleanValue();
    }
    return false;
  }
  
  private boolean isDurationEnoughForTransition(CMTime paramCMTime1, CMTime paramCMTime2, long paramLong)
  {
    long l1 = paramCMTime1.getTimeUs() / 1000L;
    long l2 = paramCMTime2.getTimeUs() / 1000L;
    appendDebugInfo("lastClip duration: " + paramCMTime1 + ", curClip duration: " + paramCMTime2);
    return (l1 > this.transThreshold) && (l2 > this.transThreshold) && (l1 > paramLong) && (l2 > paramLong);
  }
  
  private boolean isNeedCycleFill(List<TAVMovieClip> paramList)
  {
    return isAllPhotoClip(paramList);
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
  
  private List<TAVMovieClip> mergeClips(List<TAVMovieClip> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<TAVMovieClip>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (TAVMovieClip)localIterator.next();
      if ((paramList != null) && (TextUtils.equals(getTAVMovieClipFilePath((TAVMovieClip)localObject), getTAVMovieClipFilePath(paramList))))
      {
        CMTimeRange localCMTimeRange = paramList.getResource().getTimeRange();
        localObject = ((TAVMovieClip)localObject).getResource().getTimeRange();
        localCMTimeRange.setDuration(localCMTimeRange.getDuration().add(((CMTimeRange)localObject).getDuration()));
        paramList.getResource().setTimeRange(localCMTimeRange);
        paramList.getResource().setDuration(localCMTimeRange.getDuration());
      }
      for (;;)
      {
        break;
        localArrayList.add(localObject);
        paramList = (List<TAVMovieClip>)localObject;
      }
    }
    return localArrayList;
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
  
  private void reserveClipTransitionTime(List<TAVMovieClip> paramList)
  {
    this.mTransitionAutomaticEffectList = randomTransitionEffects(paramList);
    computeTransitionTime();
    if (this.mTransitionDurationMsList.isEmpty()) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TAVMovieClip localTAVMovieClip = (TAVMovieClip)paramList.next();
        TAVMovieResource localTAVMovieResource = localTAVMovieClip.getResource();
        if ((localTAVMovieResource instanceof TAVMovieTrackResource))
        {
          CMTimeRange localCMTimeRange = localTAVMovieResource.getTimeRange();
          long l1 = ((Long)this.mTransitionDurationMsList.get(i)).longValue();
          if (localCMTimeRange.getDuration().getTimeUs() / 1000L > l1)
          {
            long l2 = l1 / 2L;
            CMTime localCMTime1 = localCMTimeRange.getStart().add(new CMTime(l2, 1000));
            CMTime localCMTime2 = localCMTimeRange.getDuration().sub(new CMTime(l1, 1000));
            localCMTimeRange.setStart(localCMTime1);
            localCMTimeRange.setDuration(localCMTime2);
            localTAVMovieResource.setTimeRange(localCMTimeRange);
            this.clipReserves.put(getTAVMovieClipFilePath(localTAVMovieClip), Boolean.valueOf(true));
          }
        }
        i += 1;
      }
    }
  }
  
  private List<TAVMovieClip> separateClipsWithAdjust(List<TAVMovieClip> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(16);
    CMTime localCMTime = CMTime.CMTimeZero;
    Object localObject1 = this.segments.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVRhythmMovieSegment)((Iterator)localObject1).next();
      if (localObject2 == null) {
        ((Iterator)localObject1).remove();
      }
      for (;;)
      {
        break;
        localCMTime = localCMTime.add(((TAVRhythmMovieSegment)localObject2).getTimeRange().getDuration());
      }
    }
    if ((localCMTime.equalsTo(CMTime.CMTimeZero)) || (localCMTime.smallThan(CMTime.CMTimeZero))) {
      return localArrayList;
    }
    localObject1 = localCMTime;
    if (localCMTime.bigThan(this.maxDuration)) {
      localObject1 = this.maxDuration;
    }
    localCMTime = CMTime.CMTimeZero;
    Object localObject2 = paramList.iterator();
    Object localObject3;
    label227:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TAVMovieClip)((Iterator)localObject2).next();
      if ((localObject3 == null) || (((TAVMovieClip)localObject3).getResource() == null) || (((TAVMovieClip)localObject3).getResource().getTimeRange() == null)) {
        ((Iterator)localObject2).remove();
      }
      for (;;)
      {
        break;
        if ((((TAVMovieClip)localObject3).getResource() instanceof TAVMovieImageResource)) {
          break label227;
        }
        localCMTime = localCMTime.add(((TAVMovieClip)localObject3).getResource().getTimeRange().getDuration());
      }
    }
    if ((localCMTime.equalsTo(CMTime.CMTimeZero)) || (localCMTime.smallThan(CMTime.CMTimeZero))) {
      return localArrayList;
    }
    Object localObject4 = paramList.iterator();
    TAVMovieClip localTAVMovieClip;
    while (((Iterator)localObject4).hasNext())
    {
      localTAVMovieClip = (TAVMovieClip)((Iterator)localObject4).next();
      if (!(localTAVMovieClip.getResource() instanceof TAVMovieImageResource))
      {
        localObject2 = localTAVMovieClip.getResource().getTimeRange().getDuration();
        localObject3 = ((CMTime)localObject2).multi((CMTime)localObject1).divide(localCMTime);
        if (((CMTime)localObject2).bigThan((CMTime)localObject3)) {
          break label809;
        }
      }
    }
    for (;;)
    {
      localConcurrentHashMap.put(((TAVMovieTrackResource)localTAVMovieClip.getResource()).getFilePath(), localObject2);
      break;
      int i = 0;
      if ((i >= this.segments.size()) || (paramList.isEmpty())) {
        return localArrayList;
      }
      localCMTime = ((TAVRhythmMovieSegment)this.segments.get(i)).getMinOriginDuration().clone();
      label525:
      label806:
      label807:
      for (;;)
      {
        if ((localCMTime.getTimeUs() > 0L) && (!paramList.isEmpty()))
        {
          localObject2 = (TAVMovieClip)paramList.remove(0);
          if ((((TAVMovieClip)localObject2).getResource() instanceof TAVMovieImageResource))
          {
            localObject1 = ((TAVMovieClip)localObject2).clone();
            localObject2 = ((TAVMovieClip)localObject1).getResource();
            localObject3 = ((TAVMovieResource)localObject2).getTimeRange();
            ((CMTimeRange)localObject3).setDuration(localCMTime);
            ((TAVMovieResource)localObject2).setTimeRange((CMTimeRange)localObject3);
            ((TAVMovieResource)localObject2).setDuration(localCMTime);
            localArrayList.add(localObject1);
            localCMTime = CMTime.CMTimeZero;
            label495:
            continue;
          }
          localObject3 = ((TAVMovieClip)localObject2).getResource().getTimeRange().getDuration();
          localObject1 = CMTime.CMTimeZero;
          localObject4 = localArrayList.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localTAVMovieClip = (TAVMovieClip)((Iterator)localObject4).next();
            if (!TextUtils.equals(getTAVMovieClipFilePath(localTAVMovieClip), getTAVMovieClipFilePath((TAVMovieClip)localObject2))) {
              break label806;
            }
            localObject1 = ((CMTime)localObject1).add(localTAVMovieClip.getResource().getTimeRange().getDuration());
          }
        }
        for (;;)
        {
          break label525;
          if ((!((CMTime)localObject1).smallThan((CMTime)localConcurrentHashMap.get(((TAVMovieTrackResource)((TAVMovieClip)localObject2).getResource()).getFilePath()))) || (!((CMTime)localObject3).bigThan(CMTime.CMTimeZero))) {
            break label807;
          }
          if ((((CMTime)localObject1).equalsTo(CMTime.CMTimeZero)) || (!((CMTime)localObject3).smallThan(localCMTime)))
          {
            localObject1 = ((TAVMovieClip)localObject2).clone();
            localObject4 = ((TAVMovieClip)localObject1).getResource().getTimeRange();
            if (((CMTime)localObject3).bigThan(localCMTime))
            {
              ((CMTimeRange)localObject4).setDuration(localCMTime);
              ((TAVMovieClip)localObject1).getResource().setDuration(localCMTime);
            }
            for (;;)
            {
              ((TAVMovieClip)localObject1).getResource().setTimeRange((CMTimeRange)localObject4);
              localArrayList.add(localObject1);
              localObject1 = ((CMTime)localObject3).sub(localCMTime);
              if (((CMTime)localObject1).bigThan(CMTime.CMTimeZero))
              {
                localObject4 = ((TAVMovieClip)localObject2).getResource().getTimeRange();
                ((CMTimeRange)localObject4).setStart(((CMTimeRange)localObject4).getStart().add(localCMTime));
                ((CMTimeRange)localObject4).setDuration((CMTime)localObject1);
                paramList.add(0, localObject2);
              }
              localCMTime = localCMTime.sub((CMTime)localObject3);
              break;
              ((CMTimeRange)localObject4).setDuration((CMTime)localObject3);
              ((TAVMovieClip)localObject1).getResource().setDuration((CMTime)localObject3);
            }
            i += 1;
            break;
          }
          break label495;
        }
      }
      label809:
      localObject2 = localObject3;
    }
  }
  
  private List<TAVMovieClip> separateClipsWithoutAdjust(List<TAVMovieClip> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = CMTime.CMTimeZero;
    int i = 0;
    if ((i >= this.segments.size()) || (paramList.isEmpty())) {
      return localArrayList1;
    }
    Object localObject3 = ((TAVRhythmMovieSegment)this.segments.get(i)).getMinOriginDuration().clone();
    Object localObject2 = localObject1;
    localObject1 = localObject3;
    Object localObject4;
    Object localObject5;
    label282:
    Object localObject6;
    for (;;)
    {
      if ((((CMTime)localObject1).getTimeUs() > 0L) && (!paramList.isEmpty()))
      {
        localObject4 = (TAVMovieClip)paramList.remove(0);
        if (paramBoolean) {
          localArrayList2.add(localObject4);
        }
        if ((((TAVMovieClip)localObject4).getResource() instanceof TAVMovieImageResource))
        {
          localObject3 = ((TAVMovieClip)localObject4).clone();
          localObject4 = ((TAVMovieClip)localObject3).getResource();
          localObject5 = ((TAVMovieResource)localObject4).getTimeRange();
          ((CMTimeRange)localObject5).setDuration((CMTime)localObject1);
          ((TAVMovieResource)localObject4).setTimeRange((CMTimeRange)localObject5);
          ((TAVMovieResource)localObject4).setDuration((CMTime)localObject1);
          localArrayList1.add(localObject3);
          localObject3 = ((CMTime)localObject2).add((CMTime)localObject1);
          localObject4 = CMTime.CMTimeZero;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (paramBoolean)
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (paramList.isEmpty())
            {
              localObject1 = localObject4;
              localObject2 = localObject3;
              if (((CMTime)localObject3).smallThan(new CMTime(10000L, 1000)))
              {
                paramList.add(localArrayList2.remove(0));
                localObject2 = localObject3;
                localObject1 = localObject4;
              }
            }
          }
        }
        else
        {
          localObject5 = ((TAVMovieClip)localObject4).getResource().getTimeRange().getDuration();
          localObject3 = CMTime.CMTimeZero;
          localObject6 = localArrayList1.iterator();
          label312:
          if (((Iterator)localObject6).hasNext())
          {
            TAVMovieClip localTAVMovieClip = (TAVMovieClip)((Iterator)localObject6).next();
            if (!TextUtils.equals(getTAVMovieClipFilePath(localTAVMovieClip), getTAVMovieClipFilePath((TAVMovieClip)localObject4))) {
              break label577;
            }
            localObject3 = ((CMTime)localObject3).add(localTAVMovieClip.getResource().getTimeRange().getDuration());
          }
        }
      }
    }
    label577:
    for (;;)
    {
      break label312;
      if ((((CMTime)localObject3).equalsTo(CMTime.CMTimeZero)) || (!((CMTime)localObject5).smallThan((CMTime)localObject1)))
      {
        localObject3 = ((TAVMovieClip)localObject4).clone();
        localObject6 = ((TAVMovieClip)localObject3).getResource().getTimeRange();
        if (((CMTime)localObject5).bigThan((CMTime)localObject1))
        {
          ((CMTimeRange)localObject6).setDuration((CMTime)localObject1);
          ((TAVMovieClip)localObject3).getResource().setDuration((CMTime)localObject1);
        }
        for (;;)
        {
          ((TAVMovieClip)localObject3).getResource().setTimeRange((CMTimeRange)localObject6);
          localArrayList1.add(localObject3);
          localObject2 = ((CMTime)localObject2).add(((CMTimeRange)localObject6).getDuration());
          localObject3 = ((CMTime)localObject5).sub((CMTime)localObject1);
          if (((CMTime)localObject3).bigThan(CMTime.CMTimeZero))
          {
            localObject6 = ((TAVMovieClip)localObject4).getResource().getTimeRange();
            ((CMTimeRange)localObject6).setStart(((CMTimeRange)localObject6).getStart().add((CMTime)localObject1));
            ((CMTimeRange)localObject6).setDuration((CMTime)localObject3);
            paramList.add(0, localObject4);
          }
          localObject1 = ((CMTime)localObject1).sub((CMTime)localObject5);
          break;
          ((CMTimeRange)localObject6).setDuration((CMTime)localObject5);
          ((TAVMovieClip)localObject3).getResource().setDuration((CMTime)localObject5);
        }
        i += 1;
        localObject1 = localObject2;
        break;
      }
      break label282;
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
                paramList.add(((TAVMovieSticker)localObject2).getSticker());
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
            paramList.add(((TAVMovieSticker)localObject3).getSticker());
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
      localObject = checkVideoMaxDuration(convertClipsFromMovie(this.movie, this.adjustClipType));
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
        localObject = checkVideoMaxDuration(paramTAVComposition);
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
    paramTAVMovie = paramTAVMovie.getClips();
    int i = 0;
    for (;;)
    {
      if ((i >= paramTAVMovie.size()) || (this.mTransitionDurationMsList.isEmpty()))
      {
        fillSegmentTAVClip(paramList);
        fillSegmentTimeEffect(paramList);
        correctSegments(paramList);
        paramTAVMovie = getTAVClipsFromSegments(this.mCorrectSegments);
        if ((paramTAVMovie == null) || (paramTAVMovie.isEmpty())) {
          break;
        }
        paramTAVMovie = paramTAVMovie.iterator();
        while (paramTAVMovie.hasNext())
        {
          paramList = (List)paramTAVMovie.next();
          localTAVComposition.getVideoChannels().add(paramList);
          localTAVComposition.getAudioChannels().add(paramList);
        }
      }
      Object localObject2 = (TAVMovieClip)paramTAVMovie.get(i);
      Object localObject1 = (TAVRhythmMovieSegment)paramList.get(i);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      ((TAVRhythmMovieSegment)localObject1).setTavMovieClips(localArrayList);
      int j = i + 1;
      if (j < paramTAVMovie.size())
      {
        localObject2 = (TAVRhythmMovieSegment)paramList.get(j);
        localObject1 = ((TAVRhythmMovieSegment)localObject1).getTimeRange();
        localObject2 = ((TAVRhythmMovieSegment)localObject2).getTimeRange().getStart();
        if (((CMTimeRange)localObject1).getEnd().sub((CMTime)localObject2).bigThan(new CMTime(((Long)this.mTransitionDurationMsList.get(i)).longValue() / 2L, 1000)))
        {
          localObject1 = getTransitionSticker(i);
          if (localObject1 != null)
          {
            ((TAVSticker)localObject1).setTimeRange(new CMTimeRange((CMTime)localObject2, new CMTime(((Long)this.mTransitionDurationMsList.get(i)).longValue(), 1000)));
            this.transitionStickers.add(localObject1);
            appendDebugInfo("add transition sticker " + ((TAVSticker)localObject1).getFilePath() + ", start offset: " + localObject2);
          }
        }
      }
      i += 1;
    }
    return localTAVComposition;
  }
  
  public List<List<TAVClip>> checkVideoMaxDuration(TAVComposition paramTAVComposition)
  {
    if (paramTAVComposition == null) {}
    do
    {
      return null;
      localObject1 = paramTAVComposition.getVideoChannels();
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    paramTAVComposition = new ArrayList();
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (List)((Iterator)localObject1).next();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add((TAVClip)((Iterator)localObject2).next());
      }
      paramTAVComposition.add(localArrayList);
    }
    return checkVideoMaxDuration(paramTAVComposition);
  }
  
  public List<List<TAVClip>> checkVideoMaxDuration(List<List<TAVClip>> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      paramList = CMTime.CMTimeZero;
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVClip localTAVClip = (TAVClip)((Iterator)localObject).next();
        CMTime localCMTime = paramList.add(localTAVClip.getResource().getScaledDuration());
        if ((localCMTime.smallThan(this.maxVideoDuration)) || (localCMTime.equalsTo(this.maxVideoDuration)))
        {
          localArrayList2.add(localTAVClip);
          paramList = paramList.add(localTAVClip.getResource().getScaledDuration());
        }
        else
        {
          paramList = localCMTime.sub(this.maxVideoDuration);
          if (localTAVClip.getResource().getScaledDuration().bigThan(paramList))
          {
            cutClip(localTAVClip, paramList);
            localArrayList2.add(localTAVClip);
          }
        }
      }
      localArrayList1.add(localArrayList2);
    }
    return localArrayList1;
  }
  
  public void configMusic(String paramString1, String paramString2, float paramFloat)
  {
    super.configMusic(paramString1, paramString2, paramFloat);
    this.musicRealStart = new CMTime(paramFloat, 1000);
  }
  
  public List<List<TAVClip>> convertClipsFromMovie(TAVMovie paramTAVMovie, TAVRhythmAutomaticTemplate.TAVRhythmAdjustClipType paramTAVRhythmAdjustClipType)
  {
    paramTAVMovie = CloneUtil.cloneMovieClips(paramTAVMovie.getClips());
    reserveClipTransitionTime(paramTAVMovie);
    if (isNeedCycleFill(paramTAVMovie))
    {
      paramTAVMovie = separateClipsWithoutAdjust(paramTAVMovie, true);
      this.mTransitionAutomaticEffectList = randomTransitionEffects(paramTAVMovie);
      computeTransitionTime();
      correctSegments(buildSegmentsFromClips(mergeClips(paramTAVMovie)));
      paramTAVMovie = getTAVClipsFromSegments(this.mCorrectSegments);
      paramTAVRhythmAdjustClipType = new StringBuilder().append("correct segments count: ").append(this.mCorrectSegments.size()).append(", channel count: ");
      if (paramTAVMovie != null) {
        break label141;
      }
    }
    label141:
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
    return this.mTransitionAutomaticEffectList;
  }
  
  @Nullable
  public TAVSticker getTransitionSticker(int paramInt)
  {
    if ((this.mTransitionAutomaticEffectList == null) || (this.mTransitionAutomaticEffectList.isEmpty())) {
      return null;
    }
    int i = paramInt;
    if (paramInt >= this.mTransitionAutomaticEffectList.size()) {
      i = paramInt % this.mTransitionAutomaticEffectList.size();
    }
    TAVMovieSticker localTAVMovieSticker = new TAVMovieSticker(this.templateDir + File.separator + ((TAVTransitionAutomaticEffect)this.mTransitionAutomaticEffectList.get(i)).parameter.filePath);
    if (localTAVMovieSticker == null) {
      return null;
    }
    return localTAVMovieSticker.getSticker();
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
  
  public void parseMusicRhythm(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, long paramLong, @Nullable List<Integer> paramList, int paramInt)
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
  }
  
  public ArrayList<TAVTransitionAutomaticEffect> randomTransitionEffects(List<TAVMovieClip> paramList)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    if (this.rhythmEffects == null) {}
    Object localObject;
    do
    {
      return null;
      localObject = this.rhythmEffects.getTransitions();
    } while ((localObject == null) || (((List)localObject).isEmpty()) || (paramList.isEmpty()) || (paramList == null));
    int m = paramList.size();
    paramList = new ArrayList();
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.DefaultApplyEffect.ordinal() == this.transitionApplyType)
    {
      localObject = (TAVTransitionAutomaticEffect)((List)localObject).get(0);
      while (i < m)
      {
        paramList.add(localObject);
        i += 1;
      }
    }
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal() == this.transitionApplyType)
    {
      i = j;
      while (i < m)
      {
        paramList.add((TAVTransitionAutomaticEffect)((List)localObject).get((int)(Math.random() * ((List)localObject).size())));
        i += 1;
      }
    }
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.SequenceApplyEffect.ordinal() == this.transitionApplyType)
    {
      i = k;
      while (i < m)
      {
        paramList.add((TAVTransitionAutomaticEffect)((List)localObject).get(i % ((List)localObject).size()));
        i += 1;
      }
    }
    return paramList;
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
    this.mTransitionAutomaticEffectList = paramArrayList;
    computeTransitionTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.TAVRhythmAutomaticTemplate
 * JD-Core Version:    0.7.0.1
 */