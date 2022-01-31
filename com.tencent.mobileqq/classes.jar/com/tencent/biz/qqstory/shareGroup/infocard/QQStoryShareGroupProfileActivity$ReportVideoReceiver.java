package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.ReportEvilHandler.ReportEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryShareGroupProfileActivity$ReportVideoReceiver
  extends QQUIEventReceiver
{
  public QQStoryShareGroupProfileActivity$ReportVideoReceiver(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull ReportEvilHandler.ReportEvent paramReportEvent)
  {
    if (paramReportEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      QQToast.a(PlayModeUtils.a(), 2, "举报成功，客服人员会尽快处理", 0).a();
      StoryReportor.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramReportEvent.jdField_a_of_type_Int), "5" });
      return;
    }
    QQToast.a(PlayModeUtils.a(), 1, "举报失败，请稍后重试", 0).a();
    StoryReportor.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return ReportEvilHandler.ReportEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.ReportVideoReceiver
 * JD-Core Version:    0.7.0.1
 */