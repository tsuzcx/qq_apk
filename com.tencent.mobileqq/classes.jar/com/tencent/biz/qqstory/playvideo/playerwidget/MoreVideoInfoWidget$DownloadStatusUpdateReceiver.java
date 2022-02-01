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

public class MoreVideoInfoWidget$DownloadStatusUpdateReceiver
  extends QQUIEventReceiver<MoreVideoInfoWidget, PlayModeUtils.DownloadStatusChangeEvent>
{
  public MoreVideoInfoWidget$DownloadStatusUpdateReceiver(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget)
  {
    super(paramMoreVideoInfoWidget);
  }
  
  public void a(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget, @NonNull PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    if (TextUtils.equals(String.valueOf(paramMoreVideoInfoWidget.hashCode()), paramDownloadStatusChangeEvent.a)) {
      b(paramMoreVideoInfoWidget, paramDownloadStatusChangeEvent);
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayModeUtils.DownloadStatusChangeEvent.class;
  }
  
  public void b(MoreVideoInfoWidget paramMoreVideoInfoWidget, PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    paramMoreVideoInfoWidget = ((StoryPlayerGroupHolder)paramMoreVideoInfoWidget.d()).r();
    if (paramMoreVideoInfoWidget != null) {
      paramMoreVideoInfoWidget.c(false);
    }
    if (paramDownloadStatusChangeEvent.c == null) {
      return;
    }
    boolean bool = PlayModeUtils.a(paramDownloadStatusChangeEvent.c);
    int i = paramDownloadStatusChangeEvent.b;
    if (i != 0)
    {
      if (i != 1)
      {
        paramMoreVideoInfoWidget = "2";
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if (!bool) {
            paramMoreVideoInfoWidget = "1";
          }
          StoryReportor.a("play_video", "down_fail", 0, 0, new String[] { paramMoreVideoInfoWidget, "", "", paramDownloadStatusChangeEvent.c.mVid });
          QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131904762), 0).show();
          return;
        }
        if (!bool) {
          paramMoreVideoInfoWidget = "1";
        }
        StoryReportor.a("play_video", "down_suc", 0, 0, new String[] { paramMoreVideoInfoWidget, "", "", paramDownloadStatusChangeEvent.c.mVid });
        QQToast.makeText(BaseApplicationImpl.getContext(), 2, StoryApi.b(2131897991), 0).show();
        return;
      }
      QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131904760), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.DownloadStatusUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */