package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class PhotoListPanel$PhotoPanelAdapter$1
  implements View.OnClickListener
{
  PhotoListPanel$PhotoPanelAdapter$1(PhotoListPanel.PhotoPanelAdapter paramPhotoPanelAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ((PhotoListPanel)this.b.a.get()).a(paramView, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.1
 * JD-Core Version:    0.7.0.1
 */