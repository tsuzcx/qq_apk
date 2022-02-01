package com.tencent.common.galleryactivity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbstractImageListScene$4
  implements View.OnClickListener
{
  AbstractImageListScene$4(AbstractImageListScene paramAbstractImageListScene) {}
  
  public void onClick(View paramView)
  {
    this.a.l();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene.4
 * JD-Core Version:    0.7.0.1
 */