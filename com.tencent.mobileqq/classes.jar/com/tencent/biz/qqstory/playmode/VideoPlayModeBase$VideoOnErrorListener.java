package com.tencent.biz.qqstory.playmode;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnErrorListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import nnn;

public class VideoPlayModeBase$VideoOnErrorListener
  implements IVideoView.OnErrorListener
{
  public StoryVideoItem a;
  public VideoPlayerPagerAdapter.VideoViewHolder a;
  
  public VideoPlayModeBase$VideoOnErrorListener(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder = paramVideoViewHolder;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public boolean a(IVideoView paramIVideoView, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoPlayModeBase", 2, "play error: model:" + paramInt1 + ", what =" + paramInt2 + ", extra = " + paramString + ",VideoUrl = " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoUrl() + ", localVideoPath = " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath);
    }
    if (paramInt2 == 102)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.e = 0L;
      paramIVideoView.d();
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a.a.d();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a.a.b(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b), 0L);
    SLog.b("Q.qqstory.player.YPlayModeUtils", "VideoOnErrorListener set progress bar GONE");
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Int = 7;
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new nnn(this));
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath != null)
    {
      paramString = new File(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath);
      if (paramString.exists())
      {
        boolean bool = paramString.delete();
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayModeBase", 2, "play error: delete file result:" + bool);
        }
      }
    }
    if (paramIVideoView.a() == 1)
    {
      StoryReportor.b("story_steaming", "story_steaming_result", 0, paramInt2, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes + "", "", StoryReportor.a(VideoPlayModeBase.a()), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(104), "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
    for (;;)
    {
      return true;
      StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(106), "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase.VideoOnErrorListener
 * JD-Core Version:    0.7.0.1
 */