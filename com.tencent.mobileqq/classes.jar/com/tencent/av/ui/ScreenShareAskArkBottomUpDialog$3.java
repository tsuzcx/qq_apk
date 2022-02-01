package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ScreenShareAskArkBottomUpDialog$3
  implements View.OnClickListener
{
  ScreenShareAskArkBottomUpDialog$3(ScreenShareAskArkBottomUpDialog paramScreenShareAskArkBottomUpDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (ScreenShareAskArkBottomUpDialog.a(this.a) != null) {
      ScreenShareAskArkBottomUpDialog.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenShareAskArkBottomUpDialog.3
 * JD-Core Version:    0.7.0.1
 */