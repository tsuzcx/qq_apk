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
    ((PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a.get()).a(paramView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.1
 * JD-Core Version:    0.7.0.1
 */