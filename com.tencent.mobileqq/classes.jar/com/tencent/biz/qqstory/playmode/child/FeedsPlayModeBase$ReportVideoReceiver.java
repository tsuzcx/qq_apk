package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.ReportEvilHandler.ReportEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;

public class FeedsPlayModeBase$ReportVideoReceiver
  extends QQUIEventReceiver
{
  public FeedsPlayModeBase$ReportVideoReceiver(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull ReportEvilHandler.ReportEvent paramReportEvent)
  {
    paramIEventReceiver = (FeedsPlayModeBase)paramIEventReceiver;
    Object localObject = (StoryVideoItem)paramIEventReceiver.a.a.get(paramIEventReceiver.b);
    localObject = ((UserManager)SuperManager.a(2)).b(((StoryVideoItem)localObject).mOwnerUid);
    if ((localObject != null) && (((QQUserUIItem)localObject).isVip))
    {
      i = 1;
      paramIEventReceiver = paramIEventReceiver.a(paramIEventReceiver.b);
      if (paramIEventReceiver == null) {
        break label167;
      }
      paramIEventReceiver = StoryReportor.a(paramIEventReceiver) + "";
      label92:
      if (!paramReportEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
        break label178;
      }
      QQToast.a(PlayModeUtils.a(), 2, "举报成功，客服人员会尽快处理", 0).a();
      if (i == 0) {
        break label173;
      }
    }
    label167:
    label173:
    for (int i = 1;; i = 2)
    {
      StoryReportor.a("play_video", "report_suc", i, 0, new String[] { String.valueOf(paramReportEvent.jdField_a_of_type_Int), paramIEventReceiver, "", paramReportEvent.jdField_a_of_type_JavaLangString });
      return;
      i = 0;
      break;
      paramIEventReceiver = "4";
      break label92;
    }
    label178:
    QQToast.a(PlayModeUtils.a(), 1, "举报失败，请稍后重试", 0).a();
    if (i != 0) {}
    for (i = 1;; i = 2)
    {
      StoryReportor.a("play_video", "report_fail", i, 0, new String[] { "", paramIEventReceiver, "", paramReportEvent.jdField_a_of_type_JavaLangString });
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return ReportEvilHandler.ReportEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase.ReportVideoReceiver
 * JD-Core Version:    0.7.0.1
 */