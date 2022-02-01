package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditActivity$7
  implements View.OnClickListener
{
  EditActivity$7(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((EditActivity.h(this.a) != null) && (EditActivity.h(this.a).isShowing()) && (EditActivity.h(this.a).getWindow() != null)) {
      EditActivity.h(this.a).dismiss();
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity.7
 * JD-Core Version:    0.7.0.1
 */