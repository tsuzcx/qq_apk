package com.tencent.autotemplate.transition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate.ApplyEffectType;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.extra.FaceInfo;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.autotemplate.utils.TAVMovieClipEx;
import com.tencent.autotemplate.utils.TavStickerUtils;
import com.tencent.autotemplate.utils.TemplateUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.tavkit.composition.TAVClip;>;

public class RhythmTransitionHelper
{
  private ExtraData extraData;
  private ArrayList<TAVTransitionAutomaticEffect> mTransitionAutomaticEffectList = new ArrayList();
  private ArrayList<Long> mTransitionDurationMsList = new ArrayList();
  private ArrayList<TransitionEffectParam> mTransitionEffectParams = new ArrayList();
  private TAVRhythmEffects rhythmEffects;
  public String templateDir;
  public long transThreshold;
  protected int transitionApplyType;
  
  public RhythmTransitionHelper(RhythmTransitionParams paramRhythmTransitionParams)
  {
    this.rhythmEffects = paramRhythmTransitionParams.rhythmEffects;
    this.transitionApplyType = paramRhythmTransitionParams.transitionApplyType;
    this.templateDir = paramRhythmTransitionParams.templateDir;
    this.extraData = paramRhythmTransitionParams.extraData;
    this.transThreshold = paramRhythmTransitionParams.transThreshold;
  }
  
  private void addExtraInfoToClip(TAVClip paramTAVClip)
  {
    Object localObject = TemplateUtils.getResourcePath(paramTAVClip.getResource());
    FaceInfo localFaceInfo = this.extraData.getFaceInfo((String)localObject);
    localObject = this.extraData.getFrameInfo((String)localObject);
    paramTAVClip.putExtraTrackInfo("extra_face_info", localFaceInfo);
    paramTAVClip.putExtraTrackInfo("extra_frame_info", localObject);
  }
  
  private void checkTransitonAvailable(List<TAVTransitionAutomaticEffect> paramList, List<TAVMovieClip> paramList1)
  {
    int i = 0;
    while (i < paramList.size())
    {
      TAVTransitionAutomaticEffect localTAVTransitionAutomaticEffect = (TAVTransitionAutomaticEffect)paramList.get(i);
      if (localTAVTransitionAutomaticEffect.isFaceTransition())
      {
        int j = i + 1;
        if (j < paramList1.size())
        {
          TAVMovieClip localTAVMovieClip1 = (TAVMovieClip)paramList1.get(i);
          TAVMovieClip localTAVMovieClip2 = (TAVMovieClip)paramList1.get(j);
          if (((!clipSupportFaceTransition(localTAVMovieClip1)) || (!clipSupportFaceTransition(localTAVMovieClip2))) && (!CollectionUtil.isEmptyList(localTAVTransitionAutomaticEffect.subTransitions)))
          {
            localTAVTransitionAutomaticEffect = getFaceTransitionSubTransition(localTAVTransitionAutomaticEffect.subTransitions);
            paramList.remove(i);
            paramList.add(i, localTAVTransitionAutomaticEffect);
          }
        }
      }
      i += 1;
    }
  }
  
  private void reverseMovieTrackResource(@NonNull TAVMovieClipEx paramTAVMovieClipEx1, @Nullable TAVMovieClipEx paramTAVMovieClipEx2, int paramInt, @NonNull TAVMovieResource paramTAVMovieResource)
  {
    CMTimeRange localCMTimeRange = paramTAVMovieResource.getTimeRange();
    Object localObject1 = (TransitionEffectParam)this.mTransitionEffectParams.get(paramInt);
    CMTime localCMTime1 = ((TransitionEffectParam)localObject1).getLeftTransitionTime();
    localObject1 = ((TransitionEffectParam)localObject1).getOverlayTime().divide(2.0F);
    if (paramInt == 0)
    {
      if (localCMTimeRange.getDuration().bigThan(localCMTime1))
      {
        localCMTimeRange.setDuration(localCMTimeRange.getDuration().sub((CMTime)localObject1));
        paramTAVMovieResource.setTimeRange(localCMTimeRange);
        paramTAVMovieClipEx1.setCurrentReverse(true);
      }
    }
    else
    {
      if (paramTAVMovieClipEx2 == null) {
        return;
      }
      Object localObject2 = paramTAVMovieClipEx2.getTransitionEffectParam();
      CMTime localCMTime2 = ((TransitionEffectParam)localObject2).getOverlayTime().divide(2);
      if (paramTAVMovieClipEx2.isCurrentReverse())
      {
        if (paramTAVMovieClipEx1.getTavMovieClip().getResource().getTimeRange().getDuration().bigThan(((TransitionEffectParam)localObject2).getRightTransitionTime()))
        {
          paramTAVMovieClipEx2 = localCMTimeRange.getStart().add(localCMTime2);
          localCMTime2 = localCMTimeRange.getDuration().sub(localCMTime2);
          localCMTimeRange.setStart(paramTAVMovieClipEx2);
          localCMTimeRange.setDuration(localCMTime2);
          paramTAVMovieResource.setTimeRange(localCMTimeRange);
          paramTAVMovieClipEx1.setLastReverse(true);
        }
        else
        {
          localObject2 = localCMTimeRange.getStart().sub(localCMTime2);
          localCMTime2 = localCMTimeRange.getDuration().add(localCMTime2);
          localCMTimeRange.setStart((CMTime)localObject2);
          localCMTimeRange.setDuration(localCMTime2);
          paramTAVMovieClipEx2.getTavMovieClip().getResource().setTimeRange(localCMTimeRange);
          paramTAVMovieClipEx2.setCurrentReverse(false);
          paramTAVMovieClipEx1.setLastReverse(false);
        }
      }
      else {
        paramTAVMovieClipEx1.setLastReverse(false);
      }
      if (localCMTimeRange.getDuration().bigThan(localCMTime1))
      {
        localCMTimeRange.setDuration(localCMTimeRange.getDuration().sub((CMTime)localObject1));
        paramTAVMovieResource.setTimeRange(localCMTimeRange);
        paramTAVMovieClipEx1.setCurrentReverse(true);
        return;
      }
      paramTAVMovieClipEx1.setCurrentReverse(false);
    }
  }
  
  public void addExtraInfoToClip(List<List<TAVClip>> paramList, List<FaceTransition> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtil.isEmptyList(paramList1))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext()) {
        localArrayList.addAll(getClipsFromChannels(paramList, ((FaceTransition)paramList1.next()).timeRange));
      }
    }
    paramList = localArrayList.iterator();
    while (paramList.hasNext()) {
      addExtraInfoToClip((TAVClip)paramList.next());
    }
  }
  
  public boolean clipSupportFaceTransition(TAVMovieClip paramTAVMovieClip)
  {
    Object localObject = TemplateUtils.getTAVMovieClipFilePath(paramTAVMovieClip);
    paramTAVMovieClip = this.extraData.getFaceInfo((String)localObject);
    localObject = this.extraData.getFrameInfo((String)localObject);
    return (paramTAVMovieClip != null) && (localObject != null);
  }
  
  @Deprecated
  public void computeTransitionTime()
  {
    this.mTransitionDurationMsList.clear();
    Object localObject = this.mTransitionAutomaticEffectList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      int i = 0;
      while (i < this.mTransitionAutomaticEffectList.size())
      {
        localObject = (TAVTransitionAutomaticEffect)this.mTransitionAutomaticEffectList.get(i);
        if (((TAVTransitionAutomaticEffect)localObject).isFaceTransition())
        {
          long l = ((TAVTransitionAutomaticEffect)localObject).getDuration();
          this.mTransitionDurationMsList.add(Long.valueOf(l));
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.templateDir);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(((TAVTransitionAutomaticEffect)localObject).parameter.filePath);
          localObject = new TAVMovieSticker(localStringBuilder.toString());
          if (((TAVMovieSticker)localObject).getSticker() != null)
          {
            localObject = ((TAVMovieSticker)localObject).getSticker();
            this.mTransitionDurationMsList.add(Long.valueOf(((float)((TAVSticker)localObject).durationTime() / 1000.0F)));
          }
        }
        i += 1;
      }
    }
  }
  
  public void computeTransitionTimes()
  {
    this.mTransitionDurationMsList.clear();
    this.mTransitionEffectParams.clear();
    if (CollectionUtil.isEmptyList(this.mTransitionAutomaticEffectList)) {
      return;
    }
    int i = 0;
    while (i < this.mTransitionAutomaticEffectList.size())
    {
      TAVTransitionAutomaticEffect localTAVTransitionAutomaticEffect = (TAVTransitionAutomaticEffect)this.mTransitionAutomaticEffectList.get(i);
      Object localObject;
      if (localTAVTransitionAutomaticEffect.isFaceTransition())
      {
        long l = localTAVTransitionAutomaticEffect.getDuration();
        this.mTransitionDurationMsList.add(Long.valueOf(l));
        localObject = CMTime.fromMs(l);
        this.mTransitionEffectParams.add(TransitionUtils.getFaceTransitionParam((CMTime)localObject, localTAVTransitionAutomaticEffect.effectId));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.templateDir);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(localTAVTransitionAutomaticEffect.parameter.filePath);
        localObject = TavStickerUtils.createSticker(((StringBuilder)localObject).toString(), false);
        if (localObject != null) {
          this.mTransitionDurationMsList.add(Long.valueOf(((TAVSticker)localObject).durationTime() / 1000L));
        }
        this.mTransitionEffectParams.add(TransitionUtils.getTransitionParams((TAVSticker)localObject, localTAVTransitionAutomaticEffect.effectId));
      }
      i += 1;
    }
  }
  
  public List<TAVClip> getClipsFromChannel(List<TAVClip> paramList, CMTimeRange paramCMTimeRange)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtil.isEmptyList(paramList))
    {
      Object localObject = CMTime.CMTimeZero;
      Iterator localIterator = paramList.iterator();
      CMTime localCMTime;
      for (paramList = (List<TAVClip>)localObject; localIterator.hasNext(); paramList = paramList.add(localCMTime))
      {
        localObject = (TAVClip)localIterator.next();
        localCMTime = ((TAVClip)localObject).getDuration();
        if (Math.max(paramList.getTimeUs(), paramCMTimeRange.getStart().getTimeUs()) <= Math.min(paramList.add(localCMTime).getTimeUs(), paramCMTimeRange.getEnd().getTimeUs())) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public List<TAVClip> getClipsFromChannels(List<List<TAVClip>> paramList, CMTimeRange paramCMTimeRange)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtil.isEmptyList(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.addAll(getClipsFromChannel((List)paramList.next(), paramCMTimeRange));
      }
    }
    return localArrayList;
  }
  
  public TAVTransitionAutomaticEffect getFaceTransitionSubTransition(List<TAVTransitionAutomaticEffect> paramList)
  {
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal() == this.transitionApplyType)
    {
      double d1 = Math.random();
      double d2 = paramList.size();
      Double.isNaN(d2);
      return (TAVTransitionAutomaticEffect)paramList.get((int)(d1 * d2));
    }
    return (TAVTransitionAutomaticEffect)paramList.get(0);
  }
  
  public ArrayList<TAVTransitionAutomaticEffect> getTransitionAutomaticEffectList()
  {
    return this.mTransitionAutomaticEffectList;
  }
  
  public ArrayList<Long> getTransitionDurationMsList()
  {
    return this.mTransitionDurationMsList;
  }
  
  @Nullable
  public TAVTransitionAutomaticEffect getTransitionEffect(int paramInt)
  {
    ArrayList localArrayList = this.mTransitionAutomaticEffectList;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      int i = paramInt;
      if (paramInt >= this.mTransitionAutomaticEffectList.size()) {
        i = paramInt % this.mTransitionAutomaticEffectList.size();
      }
      return (TAVTransitionAutomaticEffect)this.mTransitionAutomaticEffectList.get(i);
    }
    return null;
  }
  
  public TAVSticker getTransitionSticker(TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.templateDir);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramTAVTransitionAutomaticEffect.parameter.filePath);
    localObject = TavStickerUtils.createSticker(((StringBuilder)localObject).toString(), false);
    if (localObject == null) {
      return null;
    }
    ((TAVSticker)localObject).setStickerId(paramTAVTransitionAutomaticEffect.effectId);
    return localObject;
  }
  
  public boolean isDurationEnoughForTransition(CMTime paramCMTime1, CMTime paramCMTime2, long paramLong)
  {
    long l1 = paramCMTime1.getTimeUs() / 1000L;
    long l2 = paramCMTime2.getTimeUs() / 1000L;
    long l3 = this.transThreshold;
    return (l1 > l3) && (l2 > l3) && (l1 > paramLong) && (l2 > paramLong);
  }
  
  public ArrayList<TAVTransitionAutomaticEffect> randomTransitionEffects(int paramInt)
  {
    Object localObject2 = this.rhythmEffects;
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    Object localObject3 = ((TAVRhythmEffects)localObject2).getTransitions();
    if (localObject3 != null)
    {
      if (((List)localObject3).isEmpty()) {
        return null;
      }
      localObject2 = new ArrayList();
      int m = TAVRhythmAutomaticTemplate.ApplyEffectType.DefaultApplyEffect.ordinal();
      int n = this.transitionApplyType;
      int j = 0;
      int k = 0;
      int i = 0;
      if (m == n)
      {
        localObject3 = (TAVTransitionAutomaticEffect)((List)localObject3).get(0);
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= paramInt) {
            break;
          }
          ((ArrayList)localObject2).add(localObject3);
          i += 1;
        }
      }
      if (TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal() == this.transitionApplyType)
      {
        i = j;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= paramInt) {
            break;
          }
          double d1 = Math.random();
          double d2 = ((List)localObject3).size();
          Double.isNaN(d2);
          ((ArrayList)localObject2).add((TAVTransitionAutomaticEffect)((List)localObject3).get((int)(d1 * d2)));
          i += 1;
        }
      }
      localObject1 = localObject2;
      if (TAVRhythmAutomaticTemplate.ApplyEffectType.SequenceApplyEffect.ordinal() == this.transitionApplyType)
      {
        i = k;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= paramInt) {
            break;
          }
          ((ArrayList)localObject2).add((TAVTransitionAutomaticEffect)((List)localObject3).get(i % ((List)localObject3).size()));
          i += 1;
        }
      }
    }
    return localObject1;
  }
  
  public void reRandomTransitions(int paramInt)
  {
    this.mTransitionAutomaticEffectList = randomTransitionEffects(paramInt);
    if (TAVAutomaticTemplate.isMapping)
    {
      computeTransitionTimes();
      return;
    }
    computeTransitionTime();
  }
  
  @Deprecated
  public void reserveClipTransitionTime(List<TAVMovieClipEx> paramList)
  {
    if (this.mTransitionDurationMsList.isEmpty()) {
      return;
    }
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVMovieClipEx localTAVMovieClipEx = (TAVMovieClipEx)paramList.next();
      TAVMovieResource localTAVMovieResource = localTAVMovieClipEx.getTavMovieClip().getResource();
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
          localTAVMovieClipEx.setReverse(true);
        }
      }
      else if ((localTAVMovieResource instanceof TAVMovieImageResource))
      {
        localTAVMovieClipEx.setReverse(true);
      }
      i += 1;
    }
  }
  
  public void reserveClipTransitionsTime(List<TAVMovieClipEx> paramList)
  {
    if (this.mTransitionDurationMsList.isEmpty()) {
      return;
    }
    TAVMovieClipEx localTAVMovieClipEx1 = null;
    int i = 0;
    while (i < paramList.size())
    {
      TAVMovieClipEx localTAVMovieClipEx2 = (TAVMovieClipEx)paramList.get(i);
      localTAVMovieClipEx2.setTransitionEffectParam((TransitionEffectParam)this.mTransitionEffectParams.get(i));
      TAVMovieResource localTAVMovieResource = localTAVMovieClipEx2.getTavMovieClip().getResource();
      if (i > 0) {
        localTAVMovieClipEx1 = (TAVMovieClipEx)paramList.get(i - 1);
      }
      if ((localTAVMovieResource instanceof TAVMovieTrackResource))
      {
        reverseMovieTrackResource(localTAVMovieClipEx2, localTAVMovieClipEx1, i, localTAVMovieResource);
      }
      else if ((localTAVMovieResource instanceof TAVMovieImageResource))
      {
        localTAVMovieClipEx2.setLastReverse(true);
        localTAVMovieClipEx2.setCurrentReverse(true);
      }
      i += 1;
    }
  }
  
  public void setTransitionAutomaticEffectList(ArrayList<TAVTransitionAutomaticEffect> paramArrayList)
  {
    this.mTransitionAutomaticEffectList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.transition.RhythmTransitionHelper
 * JD-Core Version:    0.7.0.1
 */