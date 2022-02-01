package com.tencent.autotemplate;

import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import java.util.Comparator;

class TAVAutomaticRenderContext$1
  implements Comparator<TAVStickerLayerInfo>
{
  TAVAutomaticRenderContext$1(TAVAutomaticRenderContext paramTAVAutomaticRenderContext) {}
  
  public int compare(TAVStickerLayerInfo paramTAVStickerLayerInfo1, TAVStickerLayerInfo paramTAVStickerLayerInfo2)
  {
    return paramTAVStickerLayerInfo1.getLayerIndex() - paramTAVStickerLayerInfo2.getLayerIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.TAVAutomaticRenderContext.1
 * JD-Core Version:    0.7.0.1
 */