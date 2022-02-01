package com.tencent.common.galleryactivity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbstractImageListScene$2
  implements View.OnClickListener
{
  AbstractImageListScene$2(AbstractImageListScene paramAbstractImageListScene) {}
  
  public void onClick(View paramView)
  {
    this.a.x();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene.2
 * JD-Core Version:    0.7.0.1
 */