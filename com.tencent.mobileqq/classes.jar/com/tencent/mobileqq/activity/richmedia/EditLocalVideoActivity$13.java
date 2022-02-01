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
    if (EditLocalVideoActivity.a(this.a).isPlaying())
    {
      EditLocalVideoActivity.b(this.a, false);
      EditLocalVideoActivity.a(this.a).pause();
      EditLocalVideoActivity.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      EditLocalVideoActivity.b(this.a, true);
      EditLocalVideoActivity.b(this.a).setVisibility(8);
      EditLocalVideoActivity.a(this.a).start();
      EditLocalVideoActivity.a(this.a).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.13
 * JD-Core Version:    0.7.0.1
 */