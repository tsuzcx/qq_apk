package com.tencent.avgame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameQuestionClassSelectDialog$3
  implements View.OnClickListener
{
  AVGameQuestionClassSelectDialog$3(AVGameQuestionClassSelectDialog paramAVGameQuestionClassSelectDialog) {}
  
  public void onClick(View paramView)
  {
    if (!AVGameQuestionClassSelectDialog.c(this.a)) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog.3
 * JD-Core Version:    0.7.0.1
 */