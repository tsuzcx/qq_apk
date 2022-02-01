package com.tencent.autotemplate.filter;

import android.support.annotation.NonNull;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.transition.FaceTransition;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import java.util.List;

public class TAVOneClickFilmStickerEffect
  implements TAVVideoMixEffect
{
  private static final String TAG = "TAVStickerOverlayEffect";
  public static final String TRACK_INDEX = "trackIndex";
  private int count = 0;
  private List<FaceTransition> faceTransitions;
  private int mRenderSceneType = 0;
  protected String reportKey = "TAVOneClickFilmStickerEffect";
  private TAVAutomaticRenderContext stickerContext;
  
  public TAVOneClickFilmStickerEffect(TAVAutomaticRenderContext paramTAVAutomaticRenderContext)
  {
    this.stickerContext = paramTAVAutomaticRenderContext;
  }
  
  public TAVVideoMixEffect.Filter createFilter()
  {
    if (this.count == 0)
    {
      this.count += 1;
      return new TAVOneClickFilmStickerEffect.StickerVideoCompositionMixerEffect(this, this.stickerContext, null);
    }
    return new TAVOneClickFilmStickerEffect.StickerVideoCompositionMixerEffect(this, this.stickerContext.copyRenderContext(), null);
  }
  
  @NonNull
  public String effectId()
  {
    return "TAVOneClickFilmStickerEffect";
  }
  
  public TAVAutomaticRenderContext getStickerContext()
  {
    return this.stickerContext;
  }
  
  public void setFaceTransitions(List<FaceTransition> paramList)
  {
    this.faceTransitions = paramList;
  }
  
  public void setRenderSceneType(int paramInt)
  {
    this.mRenderSceneType = paramInt;
  }
  
  public void setReportKey(String paramString)
  {
    this.reportKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect
 * JD-Core Version:    0.7.0.1
 */