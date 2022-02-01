package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DeviceTipsController$1
  implements View.OnClickListener
{
  DeviceTipsController$1(DeviceTipsController paramDeviceTipsController, DeviceTipsController.OnClickTipsListener paramOnClickTipsListener) {}
  
  public void onClick(View paramView)
  {
    DeviceTipsController.OnClickTipsListener localOnClickTipsListener = this.a;
    if (localOnClickTipsListener != null) {
      localOnClickTipsListener.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DeviceTipsController.1
 * JD-Core Version:    0.7.0.1
 */