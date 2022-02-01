package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

class DatalineChatPie$5
  implements View.OnTouchListener
{
  DatalineChatPie$5(DatalineChatPie paramDatalineChatPie, AsyncImageView paramAsyncImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDatalineChatPie.a == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDatalineChatPie.a.isFinishing())) {}
    while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 0)) {
      return false;
    }
    if (paramMotionEvent.getAction() == 1) {}
    for (int i = 255; Build.VERSION.SDK_INT >= 16; i = 127)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageAlpha(i);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAlpha(i);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.5
 * JD-Core Version:    0.7.0.1
 */