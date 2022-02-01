package com.tencent.autotemplate;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVRhythmTimeEffectUtils
{
  public static List<TAVClip> applyTimeEffectsInPreviewTimeline(List<TAVClip> paramList, List<TAVMovieTimeEffect> paramList1)
  {
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return paramList;
    }
    Object localObject1 = fillTimeEffectsAndRemoveOverlap(paramList1);
    CMTime localCMTime = calculateClipTotalDuration(paramList);
    ArrayList localArrayList = new ArrayList();
    paramList1 = CMTime.CMTimeZero;
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVMovieTimeEffect)((Iterator)localObject1).next();
      if ((!paramList1.bigThan(localCMTime)) && (!paramList1.equals(localCMTime))) {}
    }
    else
    {
      if (paramList1.smallThan(localCMTime)) {
        localArrayList.addAll(getTAVClipsByTimeEffect(paramList, paramList1, localCMTime.sub(paramList1), localCMTime.sub(paramList1), 1.0F));
      }
      return localArrayList;
    }
    CMTimeRange localCMTimeRange = ((TAVMovieTimeEffect)localObject2).getTimeRange();
    float f = ((TAVMovieTimeEffect)localObject2).getSpeed();
    if (f > 0.0F)
    {
      localObject2 = localCMTimeRange.getDuration().multi(f);
      localArrayList.addAll(getTAVClipsByTimeEffect(paramList, paramList1, (CMTime)localObject2, localCMTimeRange.getDuration(), f));
      paramList1 = paramList1.add((CMTime)localObject2);
    }
    for (;;)
    {
      break;
      if (f == 0.0F)
      {
        localArrayList.addAll(getTAVClipsByTimeEffect(paramList, paramList1, new CMTime(33L, 1000), localCMTimeRange.getDuration(), f));
        paramList1 = paramList1.add(new CMTime(33L, 1000));
      }
    }
  }
  
  private static CMTime calculateClipTotalDuration(List<TAVClip> paramList)
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    Iterator localIterator = paramList.iterator();
    for (paramList = localCMTime; localIterator.hasNext(); paramList = paramList.add(((TAVClip)localIterator.next()).getResource().getScaledDuration())) {}
    return paramList;
  }
  
  public static void covertTAVClipTimeScale(TAVClip paramTAVClip)
  {
    CMTimeRange localCMTimeRange = paramTAVClip.getResource().getSourceTimeRange();
    CMTime localCMTime1 = paramTAVClip.getResource().getScaledDuration();
    CMTime localCMTime2 = paramTAVClip.getResource().getDuration();
    paramTAVClip.getResource().setDuration(new CMTime((localCMTime2.getTimeSeconds() * 1000.0F), 1000));
    paramTAVClip.getResource().setScaledDuration(new CMTime((localCMTime1.getTimeSeconds() * 1000.0F), 1000));
    paramTAVClip.getResource().setSourceTimeRange(new CMTimeRange(new CMTime((localCMTimeRange.getStart().getTimeSeconds() * 1000.0F), 1000), new CMTime((localCMTimeRange.getDuration().getTimeSeconds() * 1000.0F), 1000)));
  }
  
  private static List<TAVMovieTimeEffect> fillTimeEffectsAndRemoveOverlap(List<TAVMovieTimeEffect> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = CMTime.CMTimeZero;
    int i = 0;
    if (i < paramList.size())
    {
      TAVMovieTimeEffect localTAVMovieTimeEffect = (TAVMovieTimeEffect)paramList.get(i);
      CMTimeRange localCMTimeRange = localTAVMovieTimeEffect.getTimeRange();
      Object localObject1;
      if (localCMTimeRange.getStart().bigThan((CMTime)localObject2))
      {
        localArrayList.add(getNormalSpeedTimeEffect((CMTime)localObject2, localCMTimeRange.getStart().sub((CMTime)localObject2)));
        localArrayList.add(localTAVMovieTimeEffect);
        localObject1 = localCMTimeRange.getEnd();
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        localObject1 = localObject2;
        if (localCMTimeRange.getStart().equalsTo((CMTime)localObject2))
        {
          localArrayList.add(localTAVMovieTimeEffect);
          localObject1 = localCMTimeRange.getEnd();
        }
      }
    }
    return localArrayList;
  }
  
  private static TAVClip getCutClip(TAVClip paramTAVClip, CMTime paramCMTime1, CMTime paramCMTime2)
  {
    paramTAVClip = paramTAVClip.clone();
    CMTimeRange localCMTimeRange = paramTAVClip.getResource().getSourceTimeRange();
    CMTime localCMTime2 = localCMTimeRange.getDuration();
    CMTime localCMTime1 = paramTAVClip.getResource().getScaledDuration();
    float f1 = localCMTime2.getTimeSeconds() / localCMTime1.getTimeSeconds();
    if ((paramCMTime1.add(paramCMTime2).smallThan(localCMTime1)) || (paramCMTime1.add(paramCMTime2).equals(localCMTime1)))
    {
      f2 = paramCMTime2.getTimeSeconds();
      paramCMTime1 = new CMTimeRange(localCMTimeRange.getStart().add(paramCMTime1.multi(f1)), new CMTime((f2 * f1 * 1000.0F), 1000));
      paramTAVClip.getResource().setSourceTimeRange(paramCMTime1);
      paramTAVClip.getResource().setScaledDuration(paramCMTime2);
      return paramTAVClip;
    }
    float f2 = localCMTime1.sub(paramCMTime1).getTimeSeconds();
    paramCMTime2 = new CMTimeRange(localCMTimeRange.getStart().add(paramCMTime1.multi(f1)), new CMTime((f2 * f1 * 1000.0F), 1000));
    paramTAVClip.getResource().setSourceTimeRange(paramCMTime2);
    paramTAVClip.getResource().setScaledDuration(localCMTime1.sub(paramCMTime1));
    return paramTAVClip;
  }
  
  private static TAVMovieTimeEffect getNormalSpeedTimeEffect(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
    localTAVMovieTimeEffect.setTimeRange(new CMTimeRange(paramCMTime1, paramCMTime2));
    return localTAVMovieTimeEffect;
  }
  
  private static List<TAVClip> getTAVClipsByTimeEffect(List<TAVClip> paramList, CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3, float paramFloat)
  {
    CMTime localCMTime1 = CMTime.CMTimeZero;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = localCMTime1;
    while (localIterator.hasNext())
    {
      Object localObject2 = (TAVClip)localIterator.next();
      CMTime localCMTime2 = ((TAVClip)localObject2).getResource().getScaledDuration();
      Object localObject1;
      if (!paramList.smallThan(paramCMTime1))
      {
        localObject1 = paramCMTime1;
        localCMTime1 = paramCMTime2;
        if (!paramList.equals(paramCMTime1)) {}
      }
      else
      {
        localObject1 = paramCMTime1;
        localCMTime1 = paramCMTime2;
        if (paramList.add(localCMTime2).bigThan(paramCMTime1))
        {
          localObject1 = getCutClip((TAVClip)localObject2, paramCMTime1.sub(paramList), paramCMTime2);
          localCMTime1 = ((TAVClip)localObject1).getResource().getScaledDuration();
          if (paramFloat == 0.0F) {
            break label204;
          }
          localObject2 = localCMTime1.divide(paramFloat);
          ((TAVClip)localObject1).getResource().setScaledDuration((CMTime)localObject2);
          localArrayList.add(localObject1);
          if (!paramCMTime2.sub(localCMTime1).bigThan(CMTime.CMTimeZero)) {
            break;
          }
          localObject1 = paramCMTime1.add(localCMTime1);
          localCMTime1 = paramCMTime2.sub(localCMTime1);
        }
      }
      paramList = paramList.add(localCMTime2);
      paramCMTime1 = (CMTime)localObject1;
      paramCMTime2 = localCMTime1;
      continue;
      label204:
      ((TAVClip)localObject1).getResource().setScaledDuration(paramCMTime3);
      localArrayList.add(localObject1);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.TAVRhythmTimeEffectUtils
 * JD-Core Version:    0.7.0.1
 */