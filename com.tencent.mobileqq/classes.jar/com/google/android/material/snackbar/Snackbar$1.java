package com.google.android.material.snackbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Snackbar$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.onClick(paramView);
    this.b.a(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.Snackbar.1
 * JD-Core Version:    0.7.0.1
 */