package com.tencent.autotemplate.utils;

import com.tencent.autotemplate.transition.TransitionEffectParam;
import com.tencent.tavmovie.base.TAVMovieClip;

public class TAVMovieClipEx
{
  private boolean isCurrentReverse;
  private boolean isLastReverse;
  @Deprecated
  private boolean isReverse;
  private TAVMovieClip tavMovieClip;
  private TransitionEffectParam transitionEffectParam = new TransitionEffectParam();
  
  public TAVMovieClipEx(TAVMovieClip paramTAVMovieClip)
  {
    this.tavMovieClip = paramTAVMovieClip;
  }
  
  public TAVMovieClipEx clone()
  {
    TAVMovieClipEx localTAVMovieClipEx = new TAVMovieClipEx(this.tavMovieClip.clone());
    localTAVMovieClipEx.isCurrentReverse = this.isCurrentReverse;
    localTAVMovieClipEx.isLastReverse = this.isLastReverse;
    localTAVMovieClipEx.isReverse = this.isReverse;
    localTAVMovieClipEx.setTransitionEffectParam(this.transitionEffectParam.clone());
    return localTAVMovieClipEx;
  }
  
  public TAVMovieClip getTavMovieClip()
  {
    return this.tavMovieClip;
  }
  
  public TransitionEffectParam getTransitionEffectParam()
  {
    return this.transitionEffectParam;
  }
  
  public boolean isCurrentReverse()
  {
    return this.isCurrentReverse;
  }
  
  public boolean isLastReverse()
  {
    return this.isLastReverse;
  }
  
  public boolean isReverse()
  {
    return this.isReverse;
  }
  
  public void setCurrentReverse(boolean paramBoolean)
  {
    this.isCurrentReverse = paramBoolean;
  }
  
  public void setLastReverse(boolean paramBoolean)
  {
    this.isLastReverse = paramBoolean;
  }
  
  public void setReverse(boolean paramBoolean)
  {
    this.isReverse = paramBoolean;
  }
  
  public void setTavMovieClip(TAVMovieClip paramTAVMovieClip)
  {
    this.tavMovieClip = paramTAVMovieClip;
  }
  
  public void setTransitionEffectParam(TransitionEffectParam paramTransitionEffectParam)
  {
    this.transitionEffectParam = paramTransitionEffectParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.utils.TAVMovieClipEx
 * JD-Core Version:    0.7.0.1
 */