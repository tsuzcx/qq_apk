package com.tencent.mobileqq.apollo.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloGameLoadDialog$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameLoadDialog.2
 * JD-Core Version:    0.7.0.1
 */