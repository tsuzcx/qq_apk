package com.tencent.mobileqq.activity.framebusiness;

import android.view.View;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class GuildInjectImpl$1
  extends FrameFragment.DragViewPunctureClickListener
{
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */