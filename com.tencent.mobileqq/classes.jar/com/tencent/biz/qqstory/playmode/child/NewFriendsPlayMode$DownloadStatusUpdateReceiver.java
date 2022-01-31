package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DownloadStatusChangeEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;

public class NewFriendsPlayMode$DownloadStatusUpdateReceiver
  extends QQUIEventReceiver
{
  public NewFriendsPlayMode$DownloadStatusUpdateReceiver(@NonNull VideoPlayModeBase paramVideoPlayModeBase)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(@NonNull VideoPlayModeBase paramVideoPlayModeBase, @NonNull PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    if ((paramDownloadStatusChangeEvent.jdField_a_of_type_Int != 0) && ((paramVideoPlayModeBase instanceof NewFriendsPlayMode)))
    {
      NewFriendsPlayMode localNewFriendsPlayMode = (NewFriendsPlayMode)paramVideoPlayModeBase;
      if (localNewFriendsPlayMode.o) {
        Dispatchers.get().unRegisterSubscriber(localNewFriendsPlayMode.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode$DownloadStatusUpdateReceiver);
      }
    }
    if (TextUtils.equals(paramDownloadStatusChangeEvent.jdField_a_of_type_JavaLangString, "forShare"))
    {
      b(paramVideoPlayModeBase, paramDownloadStatusChangeEvent);
      return;
    }
    c(paramVideoPlayModeBase, paramDownloadStatusChangeEvent);
  }
  
  public Class acceptEventClass()
  {
    return PlayModeUtils.DownloadStatusChangeEvent.class;
  }
  
  public void b(VideoPlayModeBase paramVideoPlayModeBase, PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    paramVideoPlayModeBase = (NewFriendsPlayMode)paramVideoPlayModeBase;
    switch (paramDownloadStatusChangeEvent.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    SLog.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramDownloadStatusChangeEvent.b);
    NewFriendsPlayMode.a(paramVideoPlayModeBase).b(paramDownloadStatusChangeEvent.b);
    NewFriendsPlayMode.a(paramVideoPlayModeBase, paramVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getContext(), NewFriendsPlayMode.a(paramVideoPlayModeBase));
    NewFriendsPlayMode.a(paramVideoPlayModeBase).a();
  }
  
  public void c(VideoPlayModeBase paramVideoPlayModeBase, PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    if ((paramVideoPlayModeBase.a.a == null) || (paramVideoPlayModeBase.a.a.size() <= paramVideoPlayModeBase.b)) {
      return;
    }
    boolean bool = PlayModeUtils.a((StoryVideoItem)paramVideoPlayModeBase.a.a.get(paramVideoPlayModeBase.b));
    switch (paramDownloadStatusChangeEvent.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
    case 1: 
      for (;;)
      {
        paramVideoPlayModeBase.s();
        return;
        QQToast.a(VideoPlayModeBase.a(), 1, "已有其他下载任务在执行，请稍候", 0).a();
      }
    case 2: 
      if (bool) {}
      for (str = "2";; str = "1")
      {
        StoryReportor.a("play_video", "down_suc", 0, 0, new String[] { str, "", "", paramDownloadStatusChangeEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(VideoPlayModeBase.a(), 2, StoryApi.a(2131432083), 0).a();
        break;
      }
    }
    if (bool) {}
    for (String str = "2";; str = "1")
    {
      StoryReportor.a("play_video", "down_fail", 0, 0, new String[] { str, "", "", paramDownloadStatusChangeEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(VideoPlayModeBase.a(), 1, "保存失败，请稍后重试", 0).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode.DownloadStatusUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */