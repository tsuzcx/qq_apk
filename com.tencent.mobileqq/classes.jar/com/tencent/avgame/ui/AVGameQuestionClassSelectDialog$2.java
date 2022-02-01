package com.tencent.avgame.ui;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameQuestionClassSelectDialog$2
  implements View.OnClickListener
{
  AVGameQuestionClassSelectDialog$2(AVGameQuestionClassSelectDialog paramAVGameQuestionClassSelectDialog) {}
  
  public void onClick(View paramView)
  {
    if (AVGameQuestionClassSelectDialog.c(this.a)) {
      AVGameQuestionClassSelectDialog.d(this.a).removeMessages(0);
    }
    AVGameQuestionClassSelectDialog.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog.2
 * JD-Core Version:    0.7.0.1
 */