package com.tencent.autotemplate.stickertransition;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.composition.video.TAVVideoTransition.Filter;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;

public class TAVStickerTransition
  implements TAVVideoTransition
{
  private TAVStickerRenderContext tavStickerContext;
  
  public TAVStickerTransition(TAVStickerContext paramTAVStickerContext)
  {
    this.tavStickerContext = paramTAVStickerContext;
  }
  
  public TAVVideoTransition.Filter createFilter()
  {
    return new TAVStickerTransition.StickerVideoTransitionEffect(this, this.tavStickerContext);
  }
  
  public String effectId()
  {
    return "TAVStickerTransition";
  }
  
  public CMTime getDuration()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.stickertransition.TAVStickerTransition
 * JD-Core Version:    0.7.0.1
 */