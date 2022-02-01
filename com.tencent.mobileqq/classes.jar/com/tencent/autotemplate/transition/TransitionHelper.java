package com.tencent.autotemplate.transition;

import android.os.Bundle;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.extra.FaceInfo;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.utils.TavStickerUtils;
import com.tencent.autotemplate.utils.TemplateUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransitionHelper
{
  private ExtraData extraData;
  private List<FaceTransition> faceTransitions;
  protected String templateDir;
  protected List<TransitionEffectModel> transitionEffectModels = new ArrayList();
  protected List<TAVSticker> transitionStickers;
  protected List<TAVTransitionAutomaticEffect> transitions;
  
  public TransitionHelper(List<TAVTransitionAutomaticEffect> paramList, ExtraData paramExtraData, String paramString, List<TAVSticker> paramList1, List<FaceTransition> paramList2)
  {
    this.transitionStickers = paramList1;
    this.faceTransitions = paramList2;
    this.transitions = paramList;
    this.templateDir = paramString;
    this.extraData = paramExtraData;
  }
  
  private void addExtraInfoToClip(TAVClip paramTAVClip)
  {
    Object localObject = TemplateUtils.getResourcePath(paramTAVClip.getResource());
    FaceInfo localFaceInfo = this.extraData.getFaceInfo((String)localObject);
    localObject = this.extraData.getFrameInfo((String)localObject);
    paramTAVClip.putExtraTrackInfo("extra_face_info", localFaceInfo);
    paramTAVClip.putExtraTrackInfo("extra_frame_info", localObject);
  }
  
  private void applyFaceTransitionsToChannel(TransitionStruct paramTransitionStruct, TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect)
  {
    long l = paramTAVTransitionAutomaticEffect.getDuration();
    Object localObject = new CMTime(paramTransitionStruct.totalDurationMsInTimeLine - l, 1000);
    if ((faceTransitionAvailable(paramTransitionStruct.lastClip, paramTransitionStruct.curClip)) && (((CMTime)localObject).bigThan(paramTransitionStruct.lastTransitionEndTime)))
    {
      paramTransitionStruct.curChannel.add(new TAVClip((CMTime)localObject));
      paramTransitionStruct.curClip.setStartTime((CMTime)localObject);
      paramTransitionStruct.curChannel.add(paramTransitionStruct.curClip);
      paramTransitionStruct.totalDurationMsInTimeLine = (paramTransitionStruct.totalDurationMsInTimeLine - l + paramTransitionStruct.curClip.getDuration().getTimeUs() / 1000L);
      localObject = new CMTimeRange((CMTime)localObject, new CMTime(l, 1000));
      localFaceTransition = new FaceTransition();
      localFaceTransition.timeRange = ((CMTimeRange)localObject);
      localFaceTransition.procMethod = paramTAVTransitionAutomaticEffect.getProcMethod();
      this.faceTransitions.add(localFaceTransition);
      addExtraInfoToClip(paramTransitionStruct.curClip);
      addExtraInfoToClip(paramTransitionStruct.lastClip);
      paramTransitionStruct.lastTransitionEndTime = ((CMTimeRange)localObject).getEnd();
      paramTransitionStruct.lastChannel = paramTransitionStruct.curChannel;
      paramTransitionStruct.lastClip = paramTransitionStruct.curClip;
      paramTransitionStruct.channels.add(paramTransitionStruct.curChannel);
    }
    while (CollectionUtil.isEmptyList(paramTAVTransitionAutomaticEffect.getSubTransitions()))
    {
      FaceTransition localFaceTransition;
      return;
    }
    paramTAVTransitionAutomaticEffect = randomTransition(paramTAVTransitionAutomaticEffect.getSubTransitions());
    if (TAVAutomaticTemplate.isMapping)
    {
      applyNormalTransitionInChannel(paramTransitionStruct, paramTAVTransitionAutomaticEffect);
      return;
    }
    applyNormalTransitionsToChannel(paramTransitionStruct, paramTAVTransitionAutomaticEffect);
  }
  
  private void applyNormalTransitionInChannel(TransitionStruct paramTransitionStruct, TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect)
  {
    TAVSticker localTAVSticker = getTAVSticker(paramTAVTransitionAutomaticEffect);
    if (localTAVSticker != null)
    {
      paramTAVTransitionAutomaticEffect = TransitionUtils.getTransitionParams(localTAVSticker, paramTAVTransitionAutomaticEffect.effectId);
      if (shouldAddTransition(paramTAVTransitionAutomaticEffect, paramTransitionStruct))
      {
        applyTransitionsToClip(paramTransitionStruct, paramTAVTransitionAutomaticEffect, localTAVSticker);
        return;
      }
    }
    paramTransitionStruct.lastChannel.add(paramTransitionStruct.curClip);
    paramTransitionStruct.lastClip = paramTransitionStruct.curClip;
    paramTransitionStruct.totalDurationMsInTimeLine += paramTransitionStruct.curClip.getDuration().getTimeUs() / 1000L;
  }
  
  @Deprecated
  private void applyNormalTransitionsToChannel(TransitionStruct paramTransitionStruct, TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect)
  {
    long l = 0L;
    CMTime localCMTime = null;
    TAVSticker localTAVSticker = getTAVSticker(paramTAVTransitionAutomaticEffect);
    if (localTAVSticker != null)
    {
      l = ((float)localTAVSticker.durationTime() / 1000.0F);
      localCMTime = new CMTime(paramTransitionStruct.totalDurationMsInTimeLine - l, 1000);
    }
    if ((localTAVSticker != null) && (localCMTime.bigThan(paramTransitionStruct.lastTransitionEndTime)))
    {
      applyTransitionsToClip(paramTransitionStruct, l, localCMTime, localTAVSticker, paramTAVTransitionAutomaticEffect.effectId);
      return;
    }
    paramTransitionStruct.lastChannel.add(paramTransitionStruct.curClip);
    paramTransitionStruct.lastClip = paramTransitionStruct.curClip;
    paramTransitionStruct.totalDurationMsInTimeLine += paramTransitionStruct.curClip.getDuration().getTimeUs() / 1000L;
  }
  
  private void applyTransitionsToChannel(TransitionStruct paramTransitionStruct)
  {
    if (paramTransitionStruct.index == 0)
    {
      paramTransitionStruct.curChannel.add(paramTransitionStruct.curClip);
      paramTransitionStruct.totalDurationMsInTimeLine += paramTransitionStruct.curClip.getDuration().getTimeUs() / 1000L;
      paramTransitionStruct.lastChannel = paramTransitionStruct.curChannel;
      paramTransitionStruct.lastClip = paramTransitionStruct.curClip;
      paramTransitionStruct.channels.add(paramTransitionStruct.curChannel);
      return;
    }
    TAVTransitionAutomaticEffect localTAVTransitionAutomaticEffect = randomTransition(this.transitions);
    if (localTAVTransitionAutomaticEffect.isFaceTransition())
    {
      applyFaceTransitionsToChannel(paramTransitionStruct, localTAVTransitionAutomaticEffect);
      return;
    }
    if (TAVAutomaticTemplate.isMapping)
    {
      applyNormalTransitionInChannel(paramTransitionStruct, localTAVTransitionAutomaticEffect);
      return;
    }
    applyNormalTransitionsToChannel(paramTransitionStruct, localTAVTransitionAutomaticEffect);
  }
  
  private void applyTransitionsToChannels(List<? extends TAVTransitionableVideo> paramList, List<List<TAVClip>> paramList1)
  {
    TransitionStruct localTransitionStruct = new TransitionStruct();
    localTransitionStruct.totalDurationMsInTimeLine = 0L;
    localTransitionStruct.lastTransitionEndTime = CMTime.CMTimeZero;
    localTransitionStruct.lastChannel = null;
    localTransitionStruct.lastClip = null;
    localTransitionStruct.channels = paramList1;
    this.transitionEffectModels.clear();
    int i = 0;
    while (i < paramList.size())
    {
      localTransitionStruct.curClip = ((TAVClip)paramList.get(i));
      localTransitionStruct.curChannel = new ArrayList();
      localTransitionStruct.index = i;
      applyTransitionsToChannel(localTransitionStruct);
      i += 1;
    }
  }
  
  @Deprecated
  private void applyTransitionsToClip(TransitionStruct paramTransitionStruct, long paramLong, CMTime paramCMTime, TAVSticker paramTAVSticker, String paramString)
  {
    paramTransitionStruct.curChannel.add(new TAVClip(paramCMTime));
    paramTransitionStruct.curClip.setStartTime(paramCMTime);
    paramTransitionStruct.curChannel.add(paramTransitionStruct.curClip);
    paramTransitionStruct.totalDurationMsInTimeLine = (paramTransitionStruct.totalDurationMsInTimeLine - paramLong + paramTransitionStruct.curClip.getDuration().getTimeUs() / 1000L);
    paramTAVSticker.setTimeRange(new CMTimeRange(paramCMTime, new CMTime(paramLong, 1000)));
    this.transitionStickers.add(paramTAVSticker);
    paramCMTime = new TransitionEffectModel();
    paramCMTime.setTransitionPosition(paramTransitionStruct.index - 1);
    paramCMTime.setStickerId(paramTAVSticker.getStickerId());
    paramCMTime.setFilePath(paramTAVSticker.getFilePath());
    paramCMTime.setEffectId(paramString);
    this.transitionEffectModels.add(paramCMTime);
    paramTransitionStruct.lastTransitionEndTime = paramTAVSticker.getTimeRange().getEnd();
    paramTransitionStruct.lastChannel = paramTransitionStruct.curChannel;
    paramTransitionStruct.lastClip = paramTransitionStruct.curClip;
    paramTransitionStruct.channels.add(paramTransitionStruct.curChannel);
  }
  
  private void applyTransitionsToClip(TransitionStruct paramTransitionStruct, TransitionEffectParam paramTransitionEffectParam, TAVSticker paramTAVSticker)
  {
    long l = paramTransitionEffectParam.getOverlayTime().getTimeUs() / 1000L;
    CMTime localCMTime1 = new CMTime(paramTransitionStruct.totalDurationMsInTimeLine - l, 1000);
    paramTransitionStruct.curChannel.add(new TAVClip(localCMTime1));
    paramTransitionStruct.curClip.setStartTime(localCMTime1);
    paramTransitionStruct.curChannel.add(paramTransitionStruct.curClip);
    paramTransitionStruct.totalDurationMsInTimeLine = (paramTransitionStruct.totalDurationMsInTimeLine - l + paramTransitionStruct.curClip.getDuration().getTimeUs() / 1000L);
    CMTime localCMTime2 = CMTime.fromUs(paramTAVSticker.durationTime());
    Object localObject = localCMTime1;
    if (TAVAutomaticTemplate.isMapping) {
      localObject = localCMTime1.add(paramTransitionEffectParam.getOverlayTime()).sub(paramTransitionEffectParam.getLeftTransitionTime());
    }
    paramTAVSticker.setTimeRange(new CMTimeRange((CMTime)localObject, localCMTime2));
    if (TAVAutomaticTemplate.isMapping) {
      paramTAVSticker.getExtraBundle().putString("key_extra_sticker_type", "sticker_video_transition");
    }
    this.transitionStickers.add(paramTAVSticker);
    localObject = new TransitionEffectModel();
    ((TransitionEffectModel)localObject).setTransitionPosition(paramTransitionStruct.index - 1);
    ((TransitionEffectModel)localObject).setStickerId(paramTAVSticker.getStickerId());
    ((TransitionEffectModel)localObject).setFilePath(paramTAVSticker.getFilePath());
    ((TransitionEffectModel)localObject).setEffectId(paramTransitionEffectParam.getEffectId());
    ((TransitionEffectModel)localObject).setLeftTransitionMs(paramTransitionEffectParam.getLeftTransitionTime().getTimeUs() / 1000L);
    ((TransitionEffectModel)localObject).setRightTransitionMs(paramTransitionEffectParam.getRightTransitionTime().getTimeUs() / 1000L);
    ((TransitionEffectModel)localObject).setOverlayTransitionMs(paramTransitionEffectParam.getOverlayTime().getTimeUs() / 1000L);
    ((TransitionEffectModel)localObject).setTimeRange(paramTAVSticker.getTimeRange());
    this.transitionEffectModels.add(localObject);
    paramTransitionStruct.lastTransitionEndTime = paramTAVSticker.getTimeRange().getEnd();
    paramTransitionStruct.lastChannel = paramTransitionStruct.curChannel;
    paramTransitionStruct.lastClip = paramTransitionStruct.curClip;
    paramTransitionStruct.channels.add(paramTransitionStruct.curChannel);
  }
  
  private boolean shouldAddTransition(TransitionEffectParam paramTransitionEffectParam, TransitionStruct paramTransitionStruct)
  {
    if (paramTransitionStruct.index == 0) {
      return false;
    }
    List localList = paramTransitionStruct.lastChannel;
    TAVClip localTAVClip = null;
    if (!CollectionUtil.isEmptyCollection(localList)) {
      localTAVClip = (TAVClip)localList.get(localList.size() - 1);
    }
    if (localTAVClip != null) {}
    for (boolean bool1 = localTAVClip.getTimeRange().getEnd().sub(paramTransitionStruct.lastTransitionEndTime).bigThan(paramTransitionEffectParam.getLeftTransitionTime());; bool1 = false)
    {
      boolean bool2 = paramTransitionStruct.curClip.getDuration().bigThan(paramTransitionEffectParam.getRightTransitionTime());
      if ((!bool1) || (!bool2)) {
        break;
      }
      return true;
    }
  }
  
  public void applyTransitionToComposition(TAVComposition paramTAVComposition)
  {
    Object localObject1 = (List)paramTAVComposition.getVideoChannels().get(0);
    paramTAVComposition.getVideoChannels().clear();
    paramTAVComposition.getAudioChannels().clear();
    Object localObject2 = new ArrayList();
    applyTransitionsToChannels((List)localObject1, (List)localObject2);
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      paramTAVComposition.addVideoChannel((List)localObject2);
      paramTAVComposition.addAudioChannel((List)localObject2);
    }
  }
  
  public boolean clipSupportFaceTransition(TAVClip paramTAVClip)
  {
    Object localObject = TemplateUtils.getResourcePath(paramTAVClip.getResource());
    paramTAVClip = this.extraData.getFaceInfo((String)localObject);
    localObject = this.extraData.getFrameInfo((String)localObject);
    return (paramTAVClip != null) && (localObject != null);
  }
  
  public boolean faceTransitionAvailable(TAVClip paramTAVClip1, TAVClip paramTAVClip2)
  {
    return (clipSupportFaceTransition(paramTAVClip2)) && (clipSupportFaceTransition(paramTAVClip1));
  }
  
  public TAVSticker getTAVSticker(TAVTransitionAutomaticEffect paramTAVTransitionAutomaticEffect)
  {
    TAVSticker localTAVSticker = TavStickerUtils.createSticker(this.templateDir + File.separator + paramTAVTransitionAutomaticEffect.parameter.filePath, false);
    if (localTAVSticker == null) {
      return null;
    }
    localTAVSticker.setStickerId(paramTAVTransitionAutomaticEffect.effectId);
    return localTAVSticker;
  }
  
  public boolean needTransition(TAVComposition paramTAVComposition)
  {
    paramTAVComposition = (List)paramTAVComposition.getVideoChannels().get(0);
    return (paramTAVComposition != null) && (paramTAVComposition.size() > 1) && (!CollectionUtil.isEmptyList(this.transitions));
  }
  
  public TAVTransitionAutomaticEffect randomTransition(List<TAVTransitionAutomaticEffect> paramList)
  {
    return (TAVTransitionAutomaticEffect)paramList.get((int)(Math.random() * paramList.size()));
  }
  
  public void setTransitionEffectModels(List<TransitionEffectModel> paramList)
  {
    this.transitionEffectModels = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.transition.TransitionHelper
 * JD-Core Version:    0.7.0.1
 */