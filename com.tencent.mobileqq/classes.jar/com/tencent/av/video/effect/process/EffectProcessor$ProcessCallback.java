package com.tencent.av.video.effect.process;

import com.tencent.av.video.effect.core.EffectFrame;

public abstract interface EffectProcessor$ProcessCallback
{
  public abstract void onComplete(EffectFrame paramEffectFrame);
  
  public abstract void onError(EffectFrame paramEffectFrame, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.process.EffectProcessor.ProcessCallback
 * JD-Core Version:    0.7.0.1
 */