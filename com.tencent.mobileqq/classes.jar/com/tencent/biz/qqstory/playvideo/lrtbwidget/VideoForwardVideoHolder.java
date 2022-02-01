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
  private long j = 0L;
  
  public VideoForwardVideoHolder(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.b.setOnClickListener(this);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    if ((this.c != null) && (System.currentTimeMillis() - this.j >= 500L))
    {
      this.j = System.currentTimeMillis();
      VideoLinkInfo localVideoLinkInfo = this.c.e().getVideoLinkInfo();
      if ((localVideoLinkInfo != null) && (localVideoLinkInfo.c()) && (localVideoLinkInfo.h.a()))
      {
        StoryPlayerLauncher.a(a(), localVideoLinkInfo.h.c, localVideoLinkInfo.h.b, 1010);
        StoryReportor.a("play_video", "clk_tips", 0, 0, new String[] { "", "", "", this.c.b });
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoForwardVideoHolder
 * JD-Core Version:    0.7.0.1
 */