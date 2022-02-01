package com.tencent.autotemplate.utils;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.CompositionUtils;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TemplateUtils
{
  public static CMTime calculateTotalTime(TAVComposition paramTAVComposition)
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
        break label96;
      }
      paramTAVComposition = (TAVComposition)localObject1;
    }
    label96:
    for (;;)
    {
      break;
      return paramTAVComposition;
    }
  }
  
  public static List<List<TAVClip>> checkVideoMaxDuration(TAVComposition paramTAVComposition, CMTime paramCMTime)
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
    return checkVideoMaxDuration(paramTAVComposition, paramCMTime);
  }
  
  public static List<List<TAVClip>> checkVideoMaxDuration(List<List<TAVClip>> paramList, CMTime paramCMTime)
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
        if ((localCMTime.smallThan(paramCMTime)) || (localCMTime.equalsTo(paramCMTime)))
        {
          localArrayList2.add(localTAVClip);
          paramList = paramList.add(localTAVClip.getResource().getScaledDuration());
        }
        else
        {
          paramList = localCMTime.sub(paramCMTime);
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
  
  public static void cutClip(TAVClip paramTAVClip, CMTime paramCMTime)
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
  
  public static String getResourcePath(TAVResource paramTAVResource)
  {
    if ((paramTAVResource instanceof TAVImageTrackResource)) {
      return ((TAVImageTrackResource)paramTAVResource).getPath();
    }
    if ((paramTAVResource instanceof TAVAssetTrackResource)) {
      return ((TAVAssetTrackResource)paramTAVResource).getAsset().getSourcePath();
    }
    return null;
  }
  
  public static String getTAVMovieClipFilePath(TAVMovieClip paramTAVMovieClip)
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
  
  public static boolean isAllPhotoClip(List<TAVMovieClip> paramList)
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
  
  public static void reloadChannels(TAVComposition paramTAVComposition)
  {
    Iterator localIterator = paramTAVComposition.getVideoChannels().iterator();
    while (localIterator.hasNext()) {
      CompositionUtils.reloadVideoStartTimeWithTransitionableVideo((List)localIterator.next());
    }
    paramTAVComposition = paramTAVComposition.getAudioChannels().iterator();
    while (paramTAVComposition.hasNext()) {
      CompositionUtils.reloadAudioStartTimeWithTransitionableAudio((List)paramTAVComposition.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.utils.TemplateUtils
 * JD-Core Version:    0.7.0.1
 */