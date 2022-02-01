package com.tencent.biz.qqstory.playvideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoCoverListBar$VideoCoverListBarAdapter$ViewHolder$1
  implements View.OnClickListener
{
  VideoCoverListBar$VideoCoverListBarAdapter$ViewHolder$1(VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder paramViewHolder, VideoCoverListBar.VideoCoverListBarAdapter paramVideoCoverListBarAdapter) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter$ViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a) != null) {
      VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter$ViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a).a(VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter$ViewHolder));
    }
    StoryReportor.a("play_video", "clk_mini", 0, 0, new String[] { "2", "", "", VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter$ViewHolder) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */