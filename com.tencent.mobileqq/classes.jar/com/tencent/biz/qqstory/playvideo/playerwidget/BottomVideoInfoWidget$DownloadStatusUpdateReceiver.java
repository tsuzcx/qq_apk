package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DownloadStatusChangeEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class BottomVideoInfoWidget$DownloadStatusUpdateReceiver
  extends QQUIEventReceiver<BottomVideoInfoWidget, PlayModeUtils.DownloadStatusChangeEvent>
{
  public BottomVideoInfoWidget$DownloadStatusUpdateReceiver(@NonNull BottomVideoInfoWidget paramBottomVideoInfoWidget)
  {
    super(paramBottomVideoInfoWidget);
  }
  
  public void a(@NonNull BottomVideoInfoWidget paramBottomVideoInfoWidget, @NonNull PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    if (TextUtils.equals(String.valueOf(paramBottomVideoInfoWidget.hashCode()), paramDownloadStatusChangeEvent.jdField_a_of_type_JavaLangString)) {
      b(paramBottomVideoInfoWidget, paramDownloadStatusChangeEvent);
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayModeUtils.DownloadStatusChangeEvent.class;
  }
  
  public void b(BottomVideoInfoWidget paramBottomVideoInfoWidget, PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    paramBottomVideoInfoWidget = ((StoryPlayerGroupHolder)paramBottomVideoInfoWidget.a()).a();
    if (paramBottomVideoInfoWidget != null) {
      paramBottomVideoInfoWidget.c(false);
    }
    if (paramDownloadStatusChangeEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = PlayModeUtils.a(paramDownloadStatusChangeEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    int i = paramDownloadStatusChangeEvent.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        paramBottomVideoInfoWidget = "2";
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if (!bool) {
            paramBottomVideoInfoWidget = "1";
          }
          StoryReportor.a("play_video", "down_fail", 0, 0, new String[] { paramBottomVideoInfoWidget, "", "", paramDownloadStatusChangeEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
          QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131701392), 0).a();
          return;
        }
        if (!bool) {
          paramBottomVideoInfoWidget = "1";
        }
        StoryReportor.a("play_video", "down_suc", 0, 0, new String[] { paramBottomVideoInfoWidget, "", "", paramDownloadStatusChangeEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, StoryApi.a(2131699938), 0).a();
        return;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131701391), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.DownloadStatusUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */