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
      if ((localTAVTransitionAutomaticEffect.isFaceTransition()) && (i + 1 < paramList1.size()))
      {
        TAVMovieClip localTAVMovieClip1 = (TAVMovieClip)paramList1.get(i);
        TAVMovieClip localTAVMovieClip2 = (TAVMovieClip)paramList1.get(i + 1);
        if (((!clipSupportFaceTransition(localTAVMovieClip1)) || (!clipSupportFaceTransition(localTAVMovieClip2))) && (!CollectionUtil.isEmptyList(localTAVTransitionAutomaticEffect.subTransitions)))
        {
          localTAVTransitionAutomaticEffect = getFaceTransitionSubTransition(localTAVTransitionAutomaticEffect.subTransitions);
          paramList.remove(i);
          paramList.add(i, localTAVTransitionAutomaticEffect);
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
    if (paramInt == 0) {
      if (localCMTimeRange.getDuration().bigThan(localCMTime1))
      {
        localCMTimeRange.setDuration(localCMTimeRange.getDuration().sub((CMTime)localObject1));
        paramTAVMovieResource.setTimeRange(localCMTimeRange);
        paramTAVMovieClipEx1.setCurrentReverse(true);
      }
    }
    while (paramTAVMovieClipEx2 == null) {
      return;
    }
    Object localObject2 = paramTAVMovieClipEx2.getTransitionEffectParam();
    CMTime localCMTime2 = ((TransitionEffectParam)localObject2).getOverlayTime().divide(2);
    if (paramTAVMovieClipEx2.isCurrentReverse()) {
      if (paramTAVMovieClipEx1.getTavMovieClip().getResource().getTimeRange().getDuration().bigThan(((TransitionEffectParam)localObject2).getRightTransitionTime()))
      {
        paramTAVMovieClipEx2 = localCMTimeRange.getStart().add(localCMTime2);
        localCMTime2 = localCMTimeRange.getDuration().sub(localCMTime2);
        localCMTimeRange.setStart(paramTAVMovieClipEx2);
        localCMTimeRange.setDuration(localCMTime2);
        paramTAVMovieResource.setTimeRange(localCMTimeRange);
        paramTAVMovieClipEx1.setLastReverse(true);
      }
    }
    while (localCMTimeRange.getDuration().bigThan(localCMTime1))
    {
      localCMTimeRange.setDuration(localCMTimeRange.getDuration().sub((CMTime)localObject1));
      paramTAVMovieResource.setTimeRange(localCMTimeRange);
      paramTAVMovieClipEx1.setCurrentReverse(true);
      return;
      localObject2 = localCMTimeRange.getStart().sub(localCMTime2);
      localCMTime2 = localCMTimeRange.getDuration().add(localCMTime2);
      localCMTimeRange.setStart((CMTime)localObject2);
      localCMTimeRange.setDuration(localCMTime2);
      paramTAVMovieClipEx2.getTavMovieClip().getResource().setTimeRange(localCMTimeRange);
      paramTAVMovieClipEx2.setCurrentReverse(false);
      paramTAVMovieClipEx1.setLastReverse(false);
      continue;
      paramTAVMovieClipEx1.setLastReverse(false);
    }
    paramTAVMovieClipEx1.setCurrentReverse(false);
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
    if ((this.mTransitionAutomaticEffectList != null) && (!this.mTransitionAutomaticEffectList.isEmpty()))
    {
      int i = 0;
      if (i < this.mTransitionAutomaticEffectList.size())
      {
        Object localObject = (TAVTransitionAutomaticEffect)this.mTransitionAutomaticEffectList.get(i);
        if (((TAVTransitionAutomaticEffect)localObject).isFaceTransition())
        {
          long l = ((TAVTransitionAutomaticEffect)localObject).getDuration();
          this.mTransitionDurationMsList.add(Long.valueOf(l));
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = new TAVMovieSticker(this.templateDir + File.separator + ((TAVTransitionAutomaticEffect)localObject).parameter.filePath);
          if ((localObject != null) && (((TAVMovieSticker)localObject).getSticker() != null))
          {
            localObject = ((TAVMovieSticker)localObject).getSticker();
            this.mTransitionDurationMsList.add(Long.valueOf(((float)((TAVSticker)localObject).durationTime() / 1000.0F)));
          }
        }
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
    label27:
    TAVTransitionAutomaticEffect localTAVTransitionAutomaticEffect;
    Object localObject;
    if (i < this.mTransitionAutomaticEffectList.size())
    {
      localTAVTransitionAutomaticEffect = (TAVTransitionAutomaticEffect)this.mTransitionAutomaticEffectList.get(i);
      if (!localTAVTransitionAutomaticEffect.isFaceTransition()) {
        break label108;
      }
      long l = localTAVTransitionAutomaticEffect.getDuration();
      this.mTransitionDurationMsList.add(Long.valueOf(l));
      localObject = CMTime.fromMs(l);
      this.mTransitionEffectParams.add(TransitionUtils.getFaceTransitionParam((CMTime)localObject, localTAVTransitionAutomaticEffect.effectId));
    }
    for (;;)
    {
      i += 1;
      break label27;
      break;
      label108:
      localObject = TavStickerUtils.createSticker(this.templateDir + File.separator + localTAVTransitionAutomaticEffect.parameter.filePath, false);
      if (localObject != null) {
        this.mTransitionDurationMsList.add(Long.valueOf(((TAVSticker)localObject).durationTime() / 1000L));
      }
      this.mTransitionEffectParams.add(TransitionUtils.getTransitionParams((TAVSticker)localObject, localTAVTransitionAutomaticEffect.effectId));
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
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal() == this.transitionApplyType) {
      return (TAVTransitionAutomaticEffect)paramList.get((int)(Math.random() * paramList.size()));
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
    if ((this.mTransitionAutomaticEffectList == null) || (this.mTransitionAutomaticEffectList.isEmpty())) {
      return null;
    }
    int i = paramInt;
    if (paramInt >= this.mTransitionAutomaticEffectList.size()) {
      i = paramInt % this.mTransitionAutomaticEffectList.size();
    }
    return (TAVTransitionAutomaticEffect)this.mTransitionAutomaticEffectList.get(i);
  }
  
  public TAVSticker getTransitionSticker(TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect)
  {
    TAVSticker localTAVSticker = TavStickerUtils.createSticker(this.templateDir + File.separator + paramTAVTransitionAutomaticEffect.parameter.filePath, false);
    if (localTAVSticker == null) {
      return null;
    }
    localTAVSticker.setStickerId(paramTAVTransitionAutomaticEffect.effectId);
    return localTAVSticker;
  }
  
  public boolean isDurationEnoughForTransition(CMTime paramCMTime1, CMTime paramCMTime2, long paramLong)
  {
    long l1 = paramCMTime1.getTimeUs() / 1000L;
    long l2 = paramCMTime2.getTimeUs() / 1000L;
    return (l1 > this.transThreshold) && (l2 > this.transThreshold) && (l1 > paramLong) && (l2 > paramLong);
  }
  
  public ArrayList<TAVTransitionAutomaticEffect> randomTransitionEffects(int paramInt)
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
    } while ((localObject == null) || (((List)localObject).isEmpty()));
    ArrayList localArrayList = new ArrayList();
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.DefaultApplyEffect.ordinal() == this.transitionApplyType)
    {
      localObject = (TAVTransitionAutomaticEffect)((List)localObject).get(0);
      while (i < paramInt)
      {
        localArrayList.add(localObject);
        i += 1;
      }
    }
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal() == this.transitionApplyType)
    {
      i = j;
      while (i < paramInt)
      {
        localArrayList.add((TAVTransitionAutomaticEffect)((List)localObject).get((int)(Math.random() * ((List)localObject).size())));
        i += 1;
      }
    }
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.SequenceApplyEffect.ordinal() == this.transitionApplyType)
    {
      i = k;
      while (i < paramInt)
      {
        localArrayList.add((TAVTransitionAutomaticEffect)((List)localObject).get(i % ((List)localObject).size()));
        i += 1;
      }
    }
    return localArrayList;
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
    paramList = paramList.iterator();
    int i = 0;
    label20:
    TAVMovieClipEx localTAVMovieClipEx;
    TAVMovieResource localTAVMovieResource;
    if (paramList.hasNext())
    {
      localTAVMovieClipEx = (TAVMovieClipEx)paramList.next();
      localTAVMovieResource = localTAVMovieClipEx.getTavMovieClip().getResource();
      if (!(localTAVMovieResource instanceof TAVMovieTrackResource)) {
        break label181;
      }
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
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label181:
      if ((localTAVMovieResource instanceof TAVMovieImageResource)) {
        localTAVMovieClipEx.setReverse(true);
      }
    }
  }
  
  public void reserveClipTransitionsTime(List<TAVMovieClipEx> paramList)
  {
    if (this.mTransitionDurationMsList.isEmpty()) {
      return;
    }
    TAVMovieClipEx localTAVMovieClipEx1 = null;
    int i = 0;
    label15:
    TAVMovieClipEx localTAVMovieClipEx2;
    TAVMovieResource localTAVMovieResource;
    if (i < paramList.size())
    {
      localTAVMovieClipEx2 = (TAVMovieClipEx)paramList.get(i);
      localTAVMovieClipEx2.setTransitionEffectParam((TransitionEffectParam)this.mTransitionEffectParams.get(i));
      localTAVMovieResource = localTAVMovieClipEx2.getTavMovieClip().getResource();
      if (i <= 0) {
        break label128;
      }
      localTAVMovieClipEx1 = (TAVMovieClipEx)paramList.get(i - 1);
    }
    label128:
    for (;;)
    {
      if ((localTAVMovieResource instanceof TAVMovieTrackResource)) {
        reverseMovieTrackResource(localTAVMovieClipEx2, localTAVMovieClipEx1, i, localTAVMovieResource);
      }
      for (;;)
      {
        i += 1;
        break label15;
        break;
        if ((localTAVMovieResource instanceof TAVMovieImageResource))
        {
          localTAVMovieClipEx2.setLastReverse(true);
          localTAVMovieClipEx2.setCurrentReverse(true);
        }
      }
    }
  }
  
  public void setTransitionAutomaticEffectList(ArrayList<TAVTransitionAutomaticEffect> paramArrayList)
  {
    this.mTransitionAutomaticEffectList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.transition.RhythmTransitionHelper
 * JD-Core Version:    0.7.0.1
 */