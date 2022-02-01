package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class DetailVideoInfoWidget$GetStoryTagInfoReceiver
  extends UIBaseEventReceiver<DetailVideoInfoWidget, GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent>
{
  public DetailVideoInfoWidget$GetStoryTagInfoReceiver(DetailVideoInfoWidget paramDetailVideoInfoWidget)
  {
    super(paramDetailVideoInfoWidget);
  }
  
  public void a(@NonNull DetailVideoInfoWidget paramDetailVideoInfoWidget, @NonNull GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent paramGetStoryPlayerTagInfoEvent)
  {
    if ((paramDetailVideoInfoWidget.a != null) && (paramGetStoryPlayerTagInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetStoryPlayerTagInfoEvent.jdField_a_of_type_JavaUtilList.contains(paramDetailVideoInfoWidget.a.a)))
    {
      SLog.a(this.TAG, "receive tag info change event. %s", paramGetStoryPlayerTagInfoEvent.toString());
      paramDetailVideoInfoWidget.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent.class;
  }
  
  public void b(@NonNull DetailVideoInfoWidget paramDetailVideoInfoWidget, @NonNull GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent paramGetStoryPlayerTagInfoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.GetStoryTagInfoReceiver
 * JD-Core Version:    0.7.0.1
 */