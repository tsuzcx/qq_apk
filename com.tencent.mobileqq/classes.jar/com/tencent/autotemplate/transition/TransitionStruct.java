package com.tencent.autotemplate.transition;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVClip;
import java.util.List;

public class TransitionStruct
{
  public List<List<TAVClip>> channels;
  public List<TAVClip> curChannel;
  public TAVClip curClip = null;
  public int index;
  public List<TAVClip> lastChannel = null;
  public TAVClip lastClip = null;
  public CMTime lastTransitionEndTime = CMTime.CMTimeZero;
  public long totalDurationMsInTimeLine = 0L;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.transition.TransitionStruct
 * JD-Core Version:    0.7.0.1
 */