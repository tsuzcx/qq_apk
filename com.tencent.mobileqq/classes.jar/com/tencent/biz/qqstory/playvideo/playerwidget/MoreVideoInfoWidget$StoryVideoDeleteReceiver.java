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
    paramMoreVideoInfoWidget.E();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramMoreVideoInfoWidget.d()).r();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    SLog.b(this.TAG, "delete onEvent");
    if ((!paramDeleteStoryVideoEvent.f) && (paramDeleteStoryVideoEvent.g.isFail()))
    {
      if (QLog.isColorLevel()) {
        SLog.d(this.TAG, "删除失败：%s", new Object[] { paramDeleteStoryVideoEvent.a() });
      }
      QQToast.makeText(paramMoreVideoInfoWidget.y(), 1, HardCodeUtil.a(2131904757), 0).show();
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