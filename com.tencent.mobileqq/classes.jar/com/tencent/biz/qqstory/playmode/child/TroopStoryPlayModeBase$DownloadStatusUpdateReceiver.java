package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DownloadStatusChangeEvent;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;

public class TroopStoryPlayModeBase$DownloadStatusUpdateReceiver
  extends QQUIEventReceiver
{
  public TroopStoryPlayModeBase$DownloadStatusUpdateReceiver(@NonNull TroopStoryPlayModeBase paramTroopStoryPlayModeBase)
  {
    super(paramTroopStoryPlayModeBase);
  }
  
  public void a(@NonNull TroopStoryPlayModeBase paramTroopStoryPlayModeBase, @NonNull PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    if ((paramTroopStoryPlayModeBase.a.a == null) || (paramTroopStoryPlayModeBase.a.a.isEmpty())) {
      return;
    }
    int i = paramDownloadStatusChangeEvent.jdField_a_of_type_Int;
    paramDownloadStatusChangeEvent = paramDownloadStatusChangeEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
    boolean bool = PlayModeUtils.a((StoryVideoItem)paramTroopStoryPlayModeBase.a.a.get(paramTroopStoryPlayModeBase.b));
    switch (i)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQToast.a(VideoPlayModeBase.a(), 1, "已有其他下载任务在执行，请稍候", 0).a();
      return;
    case 2: 
      QQToast.a(VideoPlayModeBase.a(), 2, StoryApi.a(2131432083), 0).a();
      if (bool) {}
      for (paramTroopStoryPlayModeBase = "2";; paramTroopStoryPlayModeBase = "1")
      {
        StoryReportor.a("play_video", "down_suc", 0, 0, new String[] { paramTroopStoryPlayModeBase, "", "", paramDownloadStatusChangeEvent });
        return;
      }
    }
    QQToast.a(VideoPlayModeBase.a(), 1, "保存失败，请稍后重试", 0).a();
    if (bool) {}
    for (paramTroopStoryPlayModeBase = "2";; paramTroopStoryPlayModeBase = "1")
    {
      StoryReportor.a("play_video", "down_fail", 0, 0, new String[] { paramTroopStoryPlayModeBase, "", "", paramDownloadStatusChangeEvent });
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayModeUtils.DownloadStatusChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.TroopStoryPlayModeBase.DownloadStatusUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */