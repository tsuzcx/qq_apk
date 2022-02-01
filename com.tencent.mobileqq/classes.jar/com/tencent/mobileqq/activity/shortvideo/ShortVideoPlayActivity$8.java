package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShortVideoPlayActivity$8
  implements View.OnClickListener
{
  ShortVideoPlayActivity$8(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class).putExtra("url", ShortVideoPlayActivity.access$1100(this.a));
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.8
 * JD-Core Version:    0.7.0.1
 */