package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottomDialog$2
  implements View.OnClickListener
{
  BottomDialog$2(BottomDialog paramBottomDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.BottomDialog.2
 * JD-Core Version:    0.7.0.1
 */