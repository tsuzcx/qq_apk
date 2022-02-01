package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class CaptureTogetherBannerVideoInfoController$GetStoryTagInfoReceiver
  extends UIBaseEventReceiver<CaptureTogetherBannerVideoInfoController, GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent>
{
  public CaptureTogetherBannerVideoInfoController$GetStoryTagInfoReceiver(CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController)
  {
    super(paramCaptureTogetherBannerVideoInfoController);
  }
  
  public void a(@NonNull CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController, @NonNull GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent paramGetStoryPlayerTagInfoEvent)
  {
    if ((CaptureTogetherBannerVideoInfoController.c(paramCaptureTogetherBannerVideoInfoController) != null) && (paramGetStoryPlayerTagInfoEvent.g.isSuccess()) && (paramGetStoryPlayerTagInfoEvent.a.contains(CaptureTogetherBannerVideoInfoController.c(paramCaptureTogetherBannerVideoInfoController).b)))
    {
      SLog.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramGetStoryPlayerTagInfoEvent.b.toString());
      paramCaptureTogetherBannerVideoInfoController.a.x();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent.class;
  }
  
  public void b(@NonNull CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController, @NonNull GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent paramGetStoryPlayerTagInfoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureTogetherBannerVideoInfoController.GetStoryTagInfoReceiver
 * JD-Core Version:    0.7.0.1
 */