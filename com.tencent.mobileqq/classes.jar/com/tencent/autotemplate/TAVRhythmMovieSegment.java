package com.tencent.autotemplate;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVRhythmMovieSegment
  extends TAVMovieSegment
  implements Serializable, Comparable<TAVRhythmMovieSegment>
{
  private static final String TAG = "RhythmMovieSegment";
  private CMTime mCorrectStartTime = null;
  private CMTime mEndingTime;
  private int mIndex;
  private boolean mNeedCentered = true;
  private CMTimeRange mOverlapTimeRange;
  private float mVolume = 0.0F;
  
  public int compareTo(@NonNull TAVRhythmMovieSegment paramTAVRhythmMovieSegment)
  {
    if (getTimeRange().getStart().smallThan(paramTAVRhythmMovieSegment.getTimeRange().getStart())) {
      return -1;
    }
    if (getTimeRange().getStart().equalsTo(paramTAVRhythmMovieSegment.getTimeRange().getStart())) {
      return 0;
    }
    if (getTimeRange().getStart().bigThan(paramTAVRhythmMovieSegment.getTimeRange().getStart())) {
      return 1;
    }
    return 0;
  }
  
  public CMTime getCorrectStartTime()
  {
    CMTime localCMTime = this.mCorrectStartTime;
    if (localCMTime != null) {
      return localCMTime;
    }
    return getTimeRange().getStart();
  }
  
  public List<TAVClip> getFullTavClips()
  {
    CMTime localCMTime = this.mEndingTime;
    if ((localCMTime != null) && (localCMTime.bigThan(CMTime.CMTimeZero)))
    {
      if (this.tavClips == null) {
        this.tavClips = new ArrayList();
      }
      this.tavClips.add(new TAVClip(new TAVEmptyResource(this.mEndingTime)));
    }
    return this.tavClips;
  }
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  public CMTime getMinOriginDuration()
  {
    Object localObject = separateSegmentByTimeEffects();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (TAVMovieTimeEffect)((List)localObject).get(((List)localObject).size() - 1);
      if ((localObject != null) && (((TAVMovieTimeEffect)localObject).getSourceTimeRange() != null)) {
        return ((TAVMovieTimeEffect)localObject).getSourceTimeRange().getEnd();
      }
    }
    return CMTime.CMTimeZero;
  }
  
  public CMTimeRange getOverlapTimeRange()
  {
    return this.mOverlapTimeRange;
  }
  
  public CMTime getPlayDuration()
  {
    return CMTime.CMTimeZero;
  }
  
  public CMTime getSourceDuration()
  {
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Object localObject = separateSegmentByTimeEffects();
    CMTime localCMTime2 = localCMTime1;
    if (localObject != null)
    {
      localCMTime2 = localCMTime1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          localCMTime2 = localCMTime1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localCMTime1 = localCMTime1.add(((TAVMovieTimeEffect)((Iterator)localObject).next()).getSourceTimeRange().getDuration());
        }
      }
    }
    return localCMTime2;
  }
  
  public List<TAVClip> getTavClips()
  {
    if ((this.tavClips != null) && (!this.tavClips.isEmpty()))
    {
      if (this.mTimeRange != null)
      {
        CMTime localCMTime = this.mTimeRange.getStart();
        if (localCMTime.bigThan(CMTime.CMTimeZero))
        {
          List localList = CloneUtil.cloneTAVClips(this.tavClips);
          Object localObject = localList;
          if (localList == null) {
            localObject = new ArrayList();
          }
          ((List)localObject).add(0, new TAVClip(new TAVEmptyResource(localCMTime)));
          return localObject;
        }
      }
      return this.tavClips;
    }
    return this.tavClips;
  }
  
  public List<TAVClip> getUseTavClips()
  {
    return this.tavClips;
  }
  
  public float getVolume()
  {
    return this.mVolume;
  }
  
  boolean isNeedCentered()
  {
    return this.mNeedCentered;
  }
  
  public void release()
  {
    if (this.tavMovieClips != null)
    {
      Iterator localIterator = this.tavMovieClips.iterator();
      while (localIterator.hasNext())
      {
        TAVMovieClip localTAVMovieClip = (TAVMovieClip)localIterator.next();
        if (localTAVMovieClip != null) {
          localTAVMovieClip.release();
        }
      }
    }
  }
  
  public List<TAVMovieTimeEffect> separateSegmentByTimeEffects()
  {
    Object localObject3 = this.mTimeEffects;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localObject3 != null)
    {
      if (this.mTimeEffects.isEmpty()) {
        return null;
      }
      Object localObject4 = TAVMovieTimeEffectUtil.getNoOverlapTimeEffects(CloneUtil.cloneMovieTimeEffects(this.mTimeEffects));
      localObject2 = localObject1;
      if (localObject4 != null)
      {
        if (((List)localObject4).isEmpty()) {
          return null;
        }
        localObject3 = new ArrayList();
        localObject2 = CMTime.CMTimeZero;
        localObject1 = localObject2;
        if (this.mTimeEffects != null)
        {
          localObject1 = localObject2;
          if (!this.mTimeEffects.isEmpty()) {
            localObject1 = ((TAVMovieTimeEffect)this.mTimeEffects.get(0)).getTimeRange().getStart();
          }
        }
        localObject4 = ((List)localObject4).iterator();
        for (;;)
        {
          localObject2 = localObject3;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject2 = (TAVMovieTimeEffect)((Iterator)localObject4).next();
          CMTime localCMTime = ((TAVMovieTimeEffect)localObject2).getTimeRange().getStart().sub((CMTime)localObject1);
          if (localCMTime.getTimeUs() > 0L)
          {
            TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
            localTAVMovieTimeEffect.setTimeRange(new CMTimeRange((CMTime)localObject1, localCMTime));
            ((List)localObject3).add(localTAVMovieTimeEffect);
          }
          ((List)localObject3).add(localObject2);
          localObject1 = ((TAVMovieTimeEffect)localObject2).getTimeRange().getEnd();
        }
      }
    }
    return localObject2;
  }
  
  public void setCorrectStartTime(CMTime paramCMTime)
  {
    this.mCorrectStartTime = paramCMTime;
  }
  
  public void setEndingTime(CMTime paramCMTime)
  {
    this.mEndingTime = paramCMTime;
  }
  
  public void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  public void setNeedCentered(boolean paramBoolean)
  {
    this.mNeedCentered = paramBoolean;
  }
  
  public void setOverlapTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.mOverlapTimeRange = paramCMTimeRange;
  }
  
  public void setVolume(float paramFloat)
  {
    this.mVolume = paramFloat;
  }
  
  public void updateMovieClips(List<TAVMovieClip> paramList, boolean paramBoolean)
  {
    this.mNeedCentered = paramBoolean;
    setTavMovieClips(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.TAVRhythmMovieSegment
 * JD-Core Version:    0.7.0.1
 */