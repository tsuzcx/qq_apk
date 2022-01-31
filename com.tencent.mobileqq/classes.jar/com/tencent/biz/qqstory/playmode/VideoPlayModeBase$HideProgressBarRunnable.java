package com.tencent.biz.qqstory.playmode;

import android.os.Handler;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import java.lang.ref.WeakReference;

public class VideoPlayModeBase$HideProgressBarRunnable
  implements Runnable
{
  public int a;
  private WeakReference a;
  
  public VideoPlayModeBase$HideProgressBarRunnable(VideoPlayModeBase paramVideoPlayModeBase)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoPlayModeBase);
  }
  
  public void run()
  {
    VideoPlayModeBase localVideoPlayModeBase = (VideoPlayModeBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localVideoPlayModeBase == null) {}
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
    do
    {
      return;
      localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)localVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_Int);
    } while (localVideoViewHolder == null);
    if (localVideoViewHolder.b.getVisibility() != 0)
    {
      localVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.m(this.jdField_a_of_type_Int);
      return;
    }
    if (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a() > 100L)
    {
      if (localVideoViewHolder.b.getVisibility() != 8)
      {
        localVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.m(this.jdField_a_of_type_Int);
        localVideoViewHolder.b.setVisibility(8);
        SLog.d("Q.qqstory.player.YPlayModeUtils", "[8] HideProgressBarRunnable hide video cover");
      }
      SLog.b("Q.qqstory.player.YPlayModeUtils", "HideProgressBarRunnable set progress bar GONE");
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      return;
    }
    localVideoPlayModeBase.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase.HideProgressBarRunnable
 * JD-Core Version:    0.7.0.1
 */