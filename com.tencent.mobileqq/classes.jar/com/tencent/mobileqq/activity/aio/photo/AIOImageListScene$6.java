package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOImageListScene$6
  implements View.OnClickListener
{
  AIOImageListScene$6(AIOImageListScene paramAIOImageListScene) {}
  
  public void onClick(View paramView)
  {
    this.a.a(((TextView)paramView).getText().toString());
    this.a.w();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.6
 * JD-Core Version:    0.7.0.1
 */