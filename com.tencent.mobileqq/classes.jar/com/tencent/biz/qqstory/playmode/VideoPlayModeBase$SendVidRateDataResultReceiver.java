package com.tencent.biz.qqstory.playmode;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.SendVidRateDataHandler.SendVidRateDataResultEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class VideoPlayModeBase$SendVidRateDataResultReceiver
  extends QQUIEventReceiver
{
  public VideoPlayModeBase$SendVidRateDataResultReceiver(@NonNull VideoPlayModeBase paramVideoPlayModeBase)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(@NonNull VideoPlayModeBase paramVideoPlayModeBase, @NonNull SendVidRateDataHandler.SendVidRateDataResultEvent paramSendVidRateDataResultEvent)
  {
    int i = paramVideoPlayModeBase.b;
    StoryVideoItem localStoryVideoItem = paramVideoPlayModeBase.a(i);
    if (localStoryVideoItem == null)
    {
      SLog.c(this.TAG, "SendVidRateDataResultReceiver error! StoryVideoItem is null!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    localStoryVideoItem.mRateResult = paramSendVidRateDataResultEvent.jdField_a_of_type_Int;
    localStoryVideoItem.mTotalScore = paramSendVidRateDataResultEvent.jdField_a_of_type_Long;
    localStoryVideoItem.mTotalRateCount = paramSendVidRateDataResultEvent.b;
    PlayModeInteractViewUtils.c(paramVideoPlayModeBase, paramVideoPlayModeBase.a(i), localStoryVideoItem);
  }
  
  public Class acceptEventClass()
  {
    return SendVidRateDataHandler.SendVidRateDataResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase.SendVidRateDataResultReceiver
 * JD-Core Version:    0.7.0.1
 */