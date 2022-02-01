package com.tencent.autotemplate.filter;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class TAVAspectFillEffect
  implements TAVVideoEffect
{
  private static final float MAX_COLOR_RANGE = 255.0F;
  private static final String TAG = "TAVAspectFillEffect";
  private String bgCIColor;
  private CGSize renderSize;
  protected String reportKey = "TAVAspectFillEffect";
  
  public TAVAspectFillEffect(CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
  
  @NonNull
  private TextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramTAVTextureInfo.width, paramTAVTextureInfo.height, null, 0);
  }
  
  @NonNull
  private TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo)
  {
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, 0);
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new TAVAspectFillEffect.AspectFillVideoCompositionEffect(this, null);
  }
  
  @NonNull
  public String effectId()
  {
    return "TAVAspectFillEffect" + hashCode();
  }
  
  public String getBgCIColor()
  {
    return this.bgCIColor;
  }
  
  public void setBgCIColor(String paramString)
  {
    this.bgCIColor = paramString;
  }
  
  public void setReportKey(String paramString)
  {
    this.reportKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVAspectFillEffect
 * JD-Core Version:    0.7.0.1
 */