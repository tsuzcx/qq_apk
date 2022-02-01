package com.tencent.common.galleryactivity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbstractImageListScene$1
  implements View.OnClickListener
{
  AbstractImageListScene$1(AbstractImageListScene paramAbstractImageListScene) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene.1
 * JD-Core Version:    0.7.0.1
 */