package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MoreVideoInfoWidget$StoryVideoDeleteReceiver
  extends QQUIEventReceiver<MoreVideoInfoWidget, DeleteStoryVideoEvent>
{
  public MoreVideoInfoWidget$StoryVideoDeleteReceiver(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget)
  {
    super(paramMoreVideoInfoWidget);
  }
  
  public void a(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    paramMoreVideoInfoWidget.l();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramMoreVideoInfoWidget.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    SLog.b(this.TAG, "delete onEvent");
    if ((!paramDeleteStoryVideoEvent.jdField_a_of_type_Boolean) && (paramDeleteStoryVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        SLog.d(this.TAG, "删除失败：%s", new Object[] { paramDeleteStoryVideoEvent.a() });
      }
      QQToast.a(paramMoreVideoInfoWidget.b(), 1, HardCodeUtil.a(2131706912), 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.StoryVideoDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */