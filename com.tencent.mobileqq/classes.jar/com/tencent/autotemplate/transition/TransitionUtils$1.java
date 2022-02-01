package com.tencent.autotemplate.transition;

import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import java.util.Comparator;

final class TransitionUtils$1
  implements Comparator<TAVStickerLayerInfo>
{
  public int compare(TAVStickerLayerInfo paramTAVStickerLayerInfo1, TAVStickerLayerInfo paramTAVStickerLayerInfo2)
  {
    return paramTAVStickerLayerInfo1.getLayerIndex() - paramTAVStickerLayerInfo2.getLayerIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.transition.TransitionUtils.1
 * JD-Core Version:    0.7.0.1
 */