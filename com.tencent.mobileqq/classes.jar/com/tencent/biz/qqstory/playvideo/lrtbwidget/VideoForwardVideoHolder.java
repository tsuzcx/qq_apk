package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VideoForwardVideoHolder
  extends VideoHolderBase
  implements View.OnClickListener
{
  private long a;
  
  public VideoForwardVideoHolder(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      VideoLinkInfo localVideoLinkInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a().getVideoLinkInfo();
      if ((localVideoLinkInfo != null) && (localVideoLinkInfo.a()) && (localVideoLinkInfo.a.a()))
      {
        StoryPlayerLauncher.a(a(), localVideoLinkInfo.a.c, localVideoLinkInfo.a.b, 1010);
        StoryReportor.a("play_video", "clk_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a });
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoForwardVideoHolder
 * JD-Core Version:    0.7.0.1
 */