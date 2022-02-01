package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PreviewScene$1
  implements View.OnClickListener
{
  PreviewScene$1(PreviewScene paramPreviewScene) {}
  
  @RequiresApi(api=17)
  public void onClick(View paramView)
  {
    this.a.b.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene.1
 * JD-Core Version:    0.7.0.1
 */