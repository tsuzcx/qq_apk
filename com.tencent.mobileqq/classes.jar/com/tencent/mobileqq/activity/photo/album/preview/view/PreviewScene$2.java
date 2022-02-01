package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PreviewScene$2
  implements View.OnClickListener
{
  PreviewScene$2(PreviewScene paramPreviewScene) {}
  
  public void onClick(View paramView)
  {
    this.a.b.i();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene.2
 * JD-Core Version:    0.7.0.1
 */