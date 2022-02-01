package com.tencent.common.galleryactivity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbstractImageListScene$5
  implements View.OnClickListener
{
  AbstractImageListScene$5(AbstractImageListScene paramAbstractImageListScene) {}
  
  public void onClick(View paramView)
  {
    this.a.o();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene.5
 * JD-Core Version:    0.7.0.1
 */