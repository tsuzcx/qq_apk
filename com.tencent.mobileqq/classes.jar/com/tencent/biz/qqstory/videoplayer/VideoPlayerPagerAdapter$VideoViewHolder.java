package com.tencent.biz.qqstory.videoplayer;

import android.graphics.drawable.AnimationDrawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.view.widget.InteractPasterWidget;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.qphone.base.util.QLog;

public class VideoPlayerPagerAdapter$VideoViewHolder
{
  public int a;
  public long a;
  public SparseArray a;
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public QQStoryVideoPlayerErrorView a;
  public IVideoView a;
  public PollWidgetUtils.IPollWidget a;
  public InteractPasterWidget a;
  public QQStoryLoadingView a;
  public boolean a;
  public int b;
  public ImageView b;
  public LinearLayout b;
  public boolean b;
  public int c;
  public ImageView c;
  public LinearLayout c;
  public boolean c;
  public LinearLayout d;
  public LinearLayout e;
  
  public VideoPlayerPagerAdapter$VideoViewHolder(VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0)) {
      return 1;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() == 0)) {
      return 2;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a() <= 0L)) {
      SLog.d("Q.qqstory.player.VideoPlayerPagerAdapter", "VideoViewHolder no loading, no error, but current position is less than 0");
    }
    return 3;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_c_of_type_AndroidWidgetImageView.getBackground();
      if ((localObject instanceof AnimationDrawable)) {
        ((AnimationDrawable)localObject).stop();
      }
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if ((this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.a();
    }
    Object localObject = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(2131371936);
    if ((localObject instanceof StoryDownloadView)) {
      ((StoryDownloadView)localObject).a();
    }
  }
  
  public void b()
  {
    int j = -1;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("VideoViewHolder doDestory mVideoView = ").append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView).append(", mViewMap = ").append(this.jdField_a_of_type_AndroidUtilSparseArray).append(", size = ");
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null)
      {
        i = -1;
        QLog.i("zivonchen", 2, i);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.removeAllViews();
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      if (this.d != null) {
        this.d.removeAllViews();
      }
      if (this.e != null) {
        this.e.removeAllViews();
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoViewHolder doDestory mVideoView = ").append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView).append(", mViewMap = ").append(this.jdField_a_of_type_AndroidUtilSparseArray).append(", size = ");
        if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
          break label244;
        }
      }
    }
    label244:
    for (int i = j;; i = this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      QLog.i("zivonchen", 2, i);
      return;
      i = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder
 * JD-Core Version:    0.7.0.1
 */