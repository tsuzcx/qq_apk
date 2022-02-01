package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditLocalVideoActivity$13
  implements View.OnClickListener
{
  EditLocalVideoActivity$13(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if (EditLocalVideoActivity.q(this.a).isPlaying())
    {
      EditLocalVideoActivity.d(this.a, false);
      EditLocalVideoActivity.q(this.a).pause();
      EditLocalVideoActivity.r(this.a).setVisibility(0);
    }
    else
    {
      EditLocalVideoActivity.d(this.a, true);
      EditLocalVideoActivity.s(this.a).setVisibility(8);
      EditLocalVideoActivity.q(this.a).start();
      EditLocalVideoActivity.r(this.a).setVisibility(4);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.13
 * JD-Core Version:    0.7.0.1
 */