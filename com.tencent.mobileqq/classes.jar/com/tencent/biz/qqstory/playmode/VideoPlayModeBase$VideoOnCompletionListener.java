package com.tencent.biz.qqstory.playmode;

import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnCompletionListener;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import njc;

public class VideoPlayModeBase$VideoOnCompletionListener
  implements IVideoView.OnCompletionListener
{
  public int a;
  
  public VideoPlayModeBase$VideoOnCompletionListener(VideoPlayModeBase paramVideoPlayModeBase, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(IVideoView paramIVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayModeBase", 2, "video onCompletion time:" + System.currentTimeMillis() + ",position:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b >= 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b < this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoPlayModeBase", 2, "onCompletion, mCurrentIndex >= mAdapter.mStoryVideoItemList.size(), mCurrentIndex" + this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b + ",mAdapter.mStoryVideoItemList.size():" + this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size());
    return;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.i(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.n(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.a(this.jdField_a_of_type_Int);
      paramIVideoView.d();
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.e = 0L;
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b), 0L, paramIVideoView.b(), null);
      return;
    }
    if (((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d == 2) && (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() == 1)) || ((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d == 3) && (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a() == 1)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.n(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.a(this.jdField_a_of_type_Int);
      paramIVideoView.d();
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b), 0L, paramIVideoView.b(), null);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_AndroidOsHandler.post(new njc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase.VideoOnCompletionListener
 * JD-Core Version:    0.7.0.1
 */