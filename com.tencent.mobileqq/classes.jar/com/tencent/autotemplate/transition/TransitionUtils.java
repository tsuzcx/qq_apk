package com.tencent.autotemplate.transition;

import android.support.annotation.NonNull;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate.ApplyEffectType;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TransitionUtils
{
  public static TransitionEffectParam getFaceTransitionParam(CMTime paramCMTime, String paramString)
  {
    TransitionEffectParam localTransitionEffectParam = new TransitionEffectParam();
    localTransitionEffectParam.setEffectId(paramString);
    localTransitionEffectParam.setLeftTransitionTime(paramCMTime);
    localTransitionEffectParam.setRightTransitionTime(paramCMTime);
    localTransitionEffectParam.setOverlayTime(paramCMTime);
    localTransitionEffectParam.setDurationTime(paramCMTime);
    localTransitionEffectParam.setFilePath("");
    localTransitionEffectParam.setFaceTransition(true);
    return localTransitionEffectParam;
  }
  
  public static TransitionEffectParam getTransitionParams(@NonNull TAVSticker paramTAVSticker, String paramString)
  {
    TransitionEffectParam localTransitionEffectParam = new TransitionEffectParam();
    Object localObject2 = paramTAVSticker.getStickerLayerInfos();
    if (CollectionUtil.isEmptyList((List)localObject2)) {
      return localTransitionEffectParam;
    }
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TAVStickerLayerInfo)((Iterator)localObject2).next();
      if (TAVAutomaticRenderContext.isLayerFillAble((TAVStickerLayerInfo)localObject3)) {
        ((List)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new TransitionUtils.1());
    localObject2 = paramTAVSticker.getStickerImageItems();
    if ((((ArrayList)localObject2).size() == 2) && (((List)localObject1).size() == 0))
    {
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        ((List)localObject1).add(((TAVStickerImageItem)((ArrayList)localObject2).get(i)).getLayerInfo());
        i += 1;
      }
    }
    if (((List)localObject1).size() >= 2)
    {
      localObject3 = (TAVStickerLayerInfo)((List)localObject1).get(0);
      localObject2 = ((TAVStickerLayerInfo)localObject3).getTimeRange().getEnd();
      localObject3 = ((TAVStickerLayerInfo)localObject3).getTimeRange().getDuration();
      Object localObject4 = (TAVStickerLayerInfo)((List)localObject1).get(1);
      localObject1 = ((TAVStickerLayerInfo)localObject4).getTimeRange().getStart();
      localObject4 = ((TAVStickerLayerInfo)localObject4).getTimeRange().getDuration();
      localObject1 = ((CMTime)localObject2).sub((CMTime)localObject1);
      localTransitionEffectParam.setEffectId(paramString);
      localTransitionEffectParam.setLeftTransitionTime((CMTime)localObject3);
      localTransitionEffectParam.setRightTransitionTime((CMTime)localObject4);
      localTransitionEffectParam.setOverlayTime((CMTime)localObject1);
      localTransitionEffectParam.setFilePath(paramTAVSticker.getFilePath());
      localTransitionEffectParam.setFaceTransition(false);
      localTransitionEffectParam.setDurationTime(CMTime.fromUs(paramTAVSticker.durationTime()));
    }
    return localTransitionEffectParam;
  }
  
  @NonNull
  public static ArrayList<TAVTransitionAutomaticEffect> randomTransitionEffects(@NonNull List<TAVTransitionAutomaticEffect> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtil.isEmptyList(paramList)) {
      return localArrayList;
    }
    int k = paramInt1 - 1;
    int m = TAVRhythmAutomaticTemplate.ApplyEffectType.DefaultApplyEffect.ordinal();
    int i = 0;
    int j = 0;
    paramInt1 = 0;
    if (m == paramInt2)
    {
      paramList = (TAVTransitionAutomaticEffect)paramList.get(0);
      while (paramInt1 < k)
      {
        localArrayList.add(paramList);
        paramInt1 += 1;
      }
    }
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal() == paramInt2)
    {
      paramInt1 = i;
      while (paramInt1 < k)
      {
        double d1 = Math.random();
        double d2 = paramList.size();
        Double.isNaN(d2);
        localArrayList.add((TAVTransitionAutomaticEffect)paramList.get((int)(d1 * d2)));
        paramInt1 += 1;
      }
    }
    if (TAVRhythmAutomaticTemplate.ApplyEffectType.SequenceApplyEffect.ordinal() == paramInt2)
    {
      paramInt1 = j;
      while (paramInt1 < k)
      {
        localArrayList.add((TAVTransitionAutomaticEffect)paramList.get(paramInt1 % paramList.size()));
        paramInt1 += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.transition.TransitionUtils
 * JD-Core Version:    0.7.0.1
 */