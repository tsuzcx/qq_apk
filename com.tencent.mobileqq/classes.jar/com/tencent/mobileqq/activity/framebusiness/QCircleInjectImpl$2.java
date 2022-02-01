package com.tencent.mobileqq.activity.framebusiness;

import android.view.View;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class QCircleInjectImpl$2
  extends FrameFragment.DragViewPunctureClickListener
{
  QCircleInjectImpl$2(FrameFragment paramFrameFragment) {}
  
  public void onClick(View paramView)
  {
    Frame localFrame = this.a.a();
    if ((localFrame instanceof QCircleFrame)) {
      ((QCircleFrame)localFrame).b();
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.2
 * JD-Core Version:    0.7.0.1
 */