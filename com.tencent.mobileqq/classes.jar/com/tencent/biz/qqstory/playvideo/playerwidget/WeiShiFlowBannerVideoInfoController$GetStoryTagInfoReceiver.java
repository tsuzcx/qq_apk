package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class WeiShiFlowBannerVideoInfoController$GetStoryTagInfoReceiver
  extends UIBaseEventReceiver<WeiShiFlowBannerVideoInfoController, GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent>
{
  public WeiShiFlowBannerVideoInfoController$GetStoryTagInfoReceiver(WeiShiFlowBannerVideoInfoController paramWeiShiFlowBannerVideoInfoController)
  {
    super(paramWeiShiFlowBannerVideoInfoController);
  }
  
  public void a(@NonNull WeiShiFlowBannerVideoInfoController paramWeiShiFlowBannerVideoInfoController, @NonNull GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent paramGetStoryPlayerTagInfoEvent)
  {
    if ((WeiShiFlowBannerVideoInfoController.a(paramWeiShiFlowBannerVideoInfoController) != null) && (paramGetStoryPlayerTagInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetStoryPlayerTagInfoEvent.jdField_a_of_type_JavaUtilList.contains(WeiShiFlowBannerVideoInfoController.a(paramWeiShiFlowBannerVideoInfoController).a)))
    {
      SLog.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramGetStoryPlayerTagInfoEvent.b.toString());
      paramWeiShiFlowBannerVideoInfoController.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent.class;
  }
  
  public void b(@NonNull WeiShiFlowBannerVideoInfoController paramWeiShiFlowBannerVideoInfoController, @NonNull GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent paramGetStoryPlayerTagInfoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.WeiShiFlowBannerVideoInfoController.GetStoryTagInfoReceiver
 * JD-Core Version:    0.7.0.1
 */