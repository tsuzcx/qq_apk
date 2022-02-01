package com.tencent.biz.pubaccount.weishi_new.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSPopupMenuDialog$1
  implements View.OnClickListener
{
  WSPopupMenuDialog$1(WSPopupMenuDialog paramWSPopupMenuDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog.1
 * JD-Core Version:    0.7.0.1
 */