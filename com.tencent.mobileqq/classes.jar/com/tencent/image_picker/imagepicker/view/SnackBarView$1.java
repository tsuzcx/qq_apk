package com.tencent.image_picker.imagepicker.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SnackBarView$1
  implements View.OnClickListener
{
  SnackBarView$1(SnackBarView paramSnackBarView, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    SnackBarView.a(this.b, new SnackBarView.1.1(this, paramView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.view.SnackBarView.1
 * JD-Core Version:    0.7.0.1
 */