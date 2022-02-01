package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class VideoCoverListGroupHolder$GetVideoBasicListReceiver
  extends QQUIEventReceiver<VideoCoverListGroupHolder, VidToBasicInfoHandler.GetVideoBasicInfoListEvent>
{
  public VideoCoverListGroupHolder$GetVideoBasicListReceiver(@NonNull VideoCoverListGroupHolder paramVideoCoverListGroupHolder)
  {
    super(paramVideoCoverListGroupHolder);
  }
  
  public void a(@NonNull VideoCoverListGroupHolder paramVideoCoverListGroupHolder, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if ((paramGetVideoBasicInfoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (VideoCoverListGroupHolder.b(paramVideoCoverListGroupHolder))
    {
      VideoCoverListGroupHolder.b(paramVideoCoverListGroupHolder, true);
      SLog.b("VideoCoverListGroupHolder", "base info return , notify list while idle");
      return;
    }
    paramVideoCoverListGroupHolder.d();
    SLog.b("VideoCoverListGroupHolder", "base info return , notify list now");
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoCoverListGroupHolder.GetVideoBasicListReceiver
 * JD-Core Version:    0.7.0.1
 */