package com.tencent.autotemplate;

import android.util.Log;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.tavmovie.base.TAVMovieTimeEffect;>;

public class TAVRhythmTimeEffectWithCutUtils
{
  public static List<TAVClip> applyTimeEffectsInPreviewTimeline(List<TAVClip> paramList, List<TAVMovieTimeEffect> paramList1, List<CMTime> paramList2)
  {
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return paramList;
    }
    List localList = fillTimeEffectsAndRemoveOverlap(paramList1, paramList2);
    paramList1 = calculateClipTotalDuration(paramList);
    ArrayList localArrayList1 = new ArrayList(paramList);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = CMTime.CMTimeZero;
    Iterator localIterator = localList.iterator();
    TAVMovieTimeEffect localTAVMovieTimeEffect;
    if (localIterator.hasNext())
    {
      localTAVMovieTimeEffect = (TAVMovieTimeEffect)localIterator.next();
      if ((!((CMTime)localObject1).bigThan(paramList1)) && (!((CMTime)localObject1).equals(paramList1))) {}
    }
    else
    {
      if (((CMTime)localObject1).smallThan(paramList1)) {
        localArrayList2.addAll(getTAVClipsByTimeEffect(localArrayList1, (CMTime)localObject1, paramList1.sub((CMTime)localObject1), ((TAVMovieTimeEffect)localList.get(localList.size() - 1)).getTimeRange().getEnd(), paramList1.sub((CMTime)localObject1), 1.0F, paramList2));
      }
      return localArrayList2;
    }
    Object localObject2 = localTAVMovieTimeEffect.getTimeRange();
    float f = localTAVMovieTimeEffect.getSpeed();
    if (f > 0.0F)
    {
      paramList1 = ((CMTimeRange)localObject2).getDuration().multi(f);
      localArrayList2.addAll(getTAVClipsByTimeEffect(localArrayList1, (CMTime)localObject1, paramList1, ((CMTimeRange)localObject2).getStart(), ((CMTimeRange)localObject2).getDuration(), f, paramList2));
      paramList1 = ((CMTime)localObject1).add(paramList1);
    }
    for (;;)
    {
      localObject2 = calculateClipTotalDuration(paramList);
      localObject1 = paramList1;
      paramList1 = (List<TAVMovieTimeEffect>)localObject2;
      break;
      paramList1 = (List<TAVMovieTimeEffect>)localObject1;
      if (f == 0.0F)
      {
        localArrayList2.addAll(getTAVClipsByTimeEffect(localArrayList1, (CMTime)localObject1, new CMTime(33L, 1000), ((CMTimeRange)localObject2).getStart(), ((CMTimeRange)localObject2).getDuration(), f, paramList2));
        paramList1 = ((CMTime)localObject1).add(new CMTime(33L, 1000));
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
  
  private static List<TAVMovieTimeEffect> fillTimeEffectsAndRemoveOverlap(List<TAVMovieTimeEffect> paramList, List<CMTime> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = CMTime.CMTimeZero;
    Object localObject3 = ((TAVMovieTimeEffect)paramList.get(paramList.size() - 1)).getTimeRange().getEnd();
    Object localObject4 = new CMTime(2147483647L, 1000);
    Object localObject1;
    if (((CMTime)localObject3).smallThan((CMTime)localObject4))
    {
      localObject1 = new TAVMovieTimeEffect();
      localObject3 = new CMTimeRange((CMTime)localObject3, ((CMTime)localObject4).sub((CMTime)localObject3));
      ((TAVMovieTimeEffect)localObject1).setTimeRange((CMTimeRange)localObject3);
      ((TAVMovieTimeEffect)localObject1).setSourceTimeRange((CMTimeRange)localObject3);
      paramList.add(localObject1);
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject3 = (TAVMovieTimeEffect)paramList.get(i);
      localObject4 = ((TAVMovieTimeEffect)localObject3).getTimeRange();
      if (((CMTimeRange)localObject4).getStart().bigThan((CMTime)localObject2))
      {
        localObject1 = getPointsInTimeRange(paramList1, new CMTimeRange((CMTime)localObject2, ((CMTimeRange)localObject4).getStart().sub((CMTime)localObject2)));
        localArrayList.addAll(getNormalSpeedTimeEffects((CMTime)localObject2, ((CMTimeRange)localObject4).getStart().sub((CMTime)localObject2), (List)localObject1));
        localArrayList.add(localObject3);
        localObject1 = ((CMTimeRange)localObject4).getEnd();
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        localObject1 = localObject2;
        if (((CMTimeRange)localObject4).getStart().equalsTo((CMTime)localObject2))
        {
          localArrayList.add(localObject3);
          localObject1 = ((CMTimeRange)localObject4).getEnd();
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
  
  private static List<TAVMovieTimeEffect> getNormalSpeedTimeEffects(CMTime paramCMTime1, CMTime paramCMTime2, List<CMTime> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.isEmpty())
    {
      paramList = new TAVMovieTimeEffect();
      paramList.setTimeRange(new CMTimeRange(paramCMTime1, paramCMTime2));
      localArrayList.add(paramList);
    }
    for (;;)
    {
      return localArrayList;
      int i = 0;
      CMTime localCMTime;
      for (Object localObject = paramCMTime1; i < paramList.size(); localObject = localCMTime)
      {
        localCMTime = (CMTime)paramList.get(i);
        TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
        localTAVMovieTimeEffect.setTimeRange(new CMTimeRange((CMTime)localObject, localCMTime.sub((CMTime)localObject)));
        localArrayList.add(localTAVMovieTimeEffect);
        if (i == paramList.size() - 1)
        {
          localObject = new TAVMovieTimeEffect();
          ((TAVMovieTimeEffect)localObject).setTimeRange(new CMTimeRange(localCMTime, paramCMTime1.add(paramCMTime2).sub(localCMTime)));
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
  }
  
  private static List<CMTime> getPointsInTimeRange(List<CMTime> paramList, CMTimeRange paramCMTimeRange)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CMTime localCMTime = (CMTime)paramList.next();
      if ((localCMTime.bigThan(paramCMTimeRange.getStart())) && (localCMTime.smallThan(paramCMTimeRange.getEnd()))) {
        localArrayList.add(localCMTime);
      }
    }
    return localArrayList;
  }
  
  private static List<TAVClip> getTAVClipsByTimeEffect(List<TAVClip> paramList, CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3, CMTime paramCMTime4, float paramFloat, List<CMTime> paramList1)
  {
    CMTime localCMTime2 = CMTime.CMTimeZero;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    CMTime localCMTime1 = CMTime.CMTimeZero;
    int i = j;
    if (paramList1 != null)
    {
      i = j;
      if (paramList1.contains(paramCMTime3))
      {
        j = 1;
        int k = paramList1.indexOf(paramCMTime3) + 1;
        i = j;
        if (k > 0)
        {
          i = j;
          if (k < paramList1.size())
          {
            localCMTime1 = (CMTime)paramList1.get(k);
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      j = 0;
      if (j < paramList.size())
      {
        Object localObject = (TAVClip)paramList.get(j);
        CMTime localCMTime3 = ((TAVClip)localObject).getResource().getScaledDuration();
        if (!localCMTime2.smallThan(paramCMTime1))
        {
          paramList1 = paramCMTime1;
          paramCMTime3 = paramCMTime2;
          if (!localCMTime2.equals(paramCMTime1)) {}
        }
        else
        {
          paramList1 = paramCMTime1;
          paramCMTime3 = paramCMTime2;
          if (localCMTime2.add(localCMTime3).bigThan(paramCMTime1)) {
            if ((i != 0) && (localCMTime2.smallThan(paramCMTime1)) && (localCMTime2.add(localCMTime3).smallThan(localCMTime1)))
            {
              paramList1 = paramCMTime1.sub(localCMTime2);
              paramCMTime3 = getCutClip((TAVClip)localObject, CMTime.CMTimeZero, paramList1);
              paramList.add(paramList.indexOf(localObject), paramCMTime3);
              paramList.remove(localObject);
              paramCMTime3 = localCMTime2.add(paramCMTime3.getResource().getScaledDuration());
              Log.d("TAVRhythmTemplate", "cut clip at time" + paramCMTime1.getTimeSeconds() + ", cutclip index" + j + ", cut dur " + paramList1.getTimeSeconds());
              paramList1 = paramCMTime1;
              paramCMTime1 = paramCMTime3;
            }
          }
        }
        for (;;)
        {
          j += 1;
          localCMTime2 = paramCMTime1;
          paramCMTime1 = paramList1;
          break;
          paramList1 = getCutClip((TAVClip)localObject, paramCMTime1.sub(localCMTime2), paramCMTime2);
          paramCMTime3 = paramList1.getResource().getScaledDuration();
          if (paramFloat == 0.0F) {
            break label436;
          }
          localObject = paramCMTime3.divide(paramFloat);
          paramList1.getResource().setScaledDuration((CMTime)localObject);
          localArrayList.add(paramList1);
          if (!paramCMTime2.sub(paramCMTime3).bigThan(CMTime.CMTimeZero)) {
            break label456;
          }
          paramList1 = paramCMTime1.add(paramCMTime3);
          paramCMTime3 = paramCMTime2.sub(paramCMTime3);
          paramCMTime1 = localCMTime2.add(localCMTime3);
          paramCMTime2 = paramCMTime3;
        }
        label436:
        paramList1.getResource().setScaledDuration(paramCMTime4);
        localArrayList.add(paramList1);
      }
      label456:
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.TAVRhythmTimeEffectWithCutUtils
 * JD-Core Version:    0.7.0.1
 */