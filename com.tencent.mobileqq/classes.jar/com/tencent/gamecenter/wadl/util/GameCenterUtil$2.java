package com.tencent.gamecenter.wadl.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class GameCenterUtil$2
  implements View.OnClickListener
{
  GameCenterUtil$2(QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.GameCenterUtil.2
 * JD-Core Version:    0.7.0.1
 */