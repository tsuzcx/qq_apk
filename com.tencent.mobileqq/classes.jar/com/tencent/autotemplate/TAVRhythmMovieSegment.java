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
    int j = 0;
    int i;
    if (getTimeRange().getStart().smallThan(paramTAVRhythmMovieSegment.getTimeRange().getStart())) {
      i = -1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (getTimeRange().getStart().equalsTo(paramTAVRhythmMovieSegment.getTimeRange().getStart()));
      i = j;
    } while (!getTimeRange().getStart().bigThan(paramTAVRhythmMovieSegment.getTimeRange().getStart()));
    return 1;
  }
  
  public CMTime getCorrectStartTime()
  {
    if (this.mCorrectStartTime != null) {
      return this.mCorrectStartTime;
    }
    return getTimeRange().getStart();
  }
  
  public List<TAVClip> getFullTavClips()
  {
    if ((this.mEndingTime != null) && (this.mEndingTime.bigThan(CMTime.CMTimeZero)))
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
    CMTime localCMTime = CMTime.CMTimeZero;
    List localList = separateSegmentByTimeEffects();
    Object localObject = localCMTime;
    if (localList != null)
    {
      localObject = localCMTime;
      if (!localList.isEmpty())
      {
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localCMTime = localCMTime.add(((TAVMovieTimeEffect)((Iterator)localObject).next()).getSourceTimeRange().getDuration());
        }
        localObject = localCMTime;
      }
    }
    return localObject;
  }
  
  public List<TAVClip> getTavClips()
  {
    if ((this.tavClips == null) || (this.tavClips.isEmpty())) {
      return this.tavClips;
    }
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
    if ((this.mTimeEffects == null) || (this.mTimeEffects.isEmpty())) {}
    Object localObject3;
    do
    {
      return null;
      localObject3 = TAVMovieTimeEffectUtil.getNoOverlapTimeEffects(CloneUtil.cloneMovieTimeEffects(this.mTimeEffects));
    } while ((localObject3 == null) || (((List)localObject3).isEmpty()));
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = CMTime.CMTimeZero;
    Object localObject1 = localObject2;
    if (this.mTimeEffects != null)
    {
      localObject1 = localObject2;
      if (!this.mTimeEffects.isEmpty()) {
        localObject1 = ((TAVMovieTimeEffect)this.mTimeEffects.get(0)).getTimeRange().getStart();
      }
    }
    localObject2 = ((List)localObject3).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TAVMovieTimeEffect)((Iterator)localObject2).next();
      CMTime localCMTime = ((TAVMovieTimeEffect)localObject3).getTimeRange().getStart().sub((CMTime)localObject1);
      if (localCMTime.getTimeUs() > 0L)
      {
        TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
        localTAVMovieTimeEffect.setTimeRange(new CMTimeRange((CMTime)localObject1, localCMTime));
        localArrayList.add(localTAVMovieTimeEffect);
      }
      localArrayList.add(localObject3);
      localObject1 = ((TAVMovieTimeEffect)localObject3).getTimeRange().getEnd();
    }
    return localArrayList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.TAVRhythmMovieSegment
 * JD-Core Version:    0.7.0.1
 */