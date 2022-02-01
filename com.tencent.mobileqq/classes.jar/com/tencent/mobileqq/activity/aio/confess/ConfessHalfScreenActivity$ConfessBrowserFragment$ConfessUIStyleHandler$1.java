package com.tencent.mobileqq.activity.aio.confess;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ConfessHalfScreenActivity$ConfessBrowserFragment$ConfessUIStyleHandler$1
  implements View.OnClickListener
{
  ConfessHalfScreenActivity$ConfessBrowserFragment$ConfessUIStyleHandler$1(ConfessHalfScreenActivity.ConfessBrowserFragment.ConfessUIStyleHandler paramConfessUIStyleHandler) {}
  
  public void onClick(View paramView)
  {
    this.a.a.getHostActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment.ConfessUIStyleHandler.1
 * JD-Core Version:    0.7.0.1
 */