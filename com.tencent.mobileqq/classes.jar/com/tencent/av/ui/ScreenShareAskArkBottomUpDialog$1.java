package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ScreenShareAskArkBottomUpDialog$1
  implements View.OnClickListener
{
  ScreenShareAskArkBottomUpDialog$1(ScreenShareAskArkBottomUpDialog paramScreenShareAskArkBottomUpDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing())
    {
      if (ScreenShareAskArkBottomUpDialog.a(this.a) != null) {
        ScreenShareAskArkBottomUpDialog.a(this.a).a();
      }
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenShareAskArkBottomUpDialog.1
 * JD-Core Version:    0.7.0.1
 */