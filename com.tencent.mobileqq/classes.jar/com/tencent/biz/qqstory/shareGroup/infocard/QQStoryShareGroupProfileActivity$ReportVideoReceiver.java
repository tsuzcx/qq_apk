package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.ReportEvilHandler.ReportEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryShareGroupProfileActivity$ReportVideoReceiver
  extends QQUIEventReceiver<IEventReceiver, ReportEvilHandler.ReportEvent>
{
  public QQStoryShareGroupProfileActivity$ReportVideoReceiver(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull ReportEvilHandler.ReportEvent paramReportEvent)
  {
    if (paramReportEvent.g.isSuccess())
    {
      QQToast.makeText(PlayModeUtils.a(), 2, HardCodeUtil.a(2131908649), 0).show();
      StoryReportor.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramReportEvent.c), "5" });
      return;
    }
    QQToast.makeText(PlayModeUtils.a(), 1, HardCodeUtil.a(2131908644), 0).show();
    StoryReportor.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return ReportEvilHandler.ReportEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.ReportVideoReceiver
 * JD-Core Version:    0.7.0.1
 */