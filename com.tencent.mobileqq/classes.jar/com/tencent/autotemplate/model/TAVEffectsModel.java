package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.Iterator;
import java.util.List;

public class TAVEffectsModel
{
  @SerializedName("filters")
  public List<TAVEffectAutomaticEffect> filterEffects;
  @SerializedName("lyricsStyles")
  public List<TAVEffectAutomaticEffect> lyricsStyles;
  @SerializedName("overlays")
  public List<TAVEffectAutomaticEffect> overlayEffects;
  @SerializedName("painting")
  public List<TAVEffectAutomaticEffect> paintings;
  @SerializedName("text")
  public List<TAVEffectAutomaticEffect> textStickers;
  
  public void setAllFileDir(String paramString)
  {
    Iterator localIterator;
    if (!CollectionUtil.isEmptyList(this.filterEffects))
    {
      localIterator = this.filterEffects.iterator();
      while (localIterator.hasNext()) {
        ((TAVEffectAutomaticEffect)localIterator.next()).fileDir = paramString;
      }
    }
    if (!CollectionUtil.isEmptyList(this.overlayEffects))
    {
      localIterator = this.overlayEffects.iterator();
      while (localIterator.hasNext()) {
        ((TAVEffectAutomaticEffect)localIterator.next()).fileDir = paramString;
      }
    }
    if (!CollectionUtil.isEmptyList(this.lyricsStyles))
    {
      localIterator = this.lyricsStyles.iterator();
      while (localIterator.hasNext()) {
        ((TAVEffectAutomaticEffect)localIterator.next()).fileDir = paramString;
      }
    }
    if (!CollectionUtil.isEmptyList(this.textStickers))
    {
      localIterator = this.textStickers.iterator();
      while (localIterator.hasNext()) {
        ((TAVEffectAutomaticEffect)localIterator.next()).fileDir = paramString;
      }
    }
    if (!CollectionUtil.isEmptyList(this.paintings))
    {
      localIterator = this.paintings.iterator();
      while (localIterator.hasNext()) {
        ((TAVEffectAutomaticEffect)localIterator.next()).fileDir = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVEffectsModel
 * JD-Core Version:    0.7.0.1
 */