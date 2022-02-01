package com.tencent.mobileqq.app;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FrameFragment$DragViewPunctureClickListener
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (!FrameFragment.e) {
      localViewGroup.callOnClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener
 * JD-Core Version:    0.7.0.1
 */