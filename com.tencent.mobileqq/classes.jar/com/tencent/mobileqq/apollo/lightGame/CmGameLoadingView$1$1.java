package com.tencent.mobileqq.apollo.lightGame;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameLoadingView$1$1
  implements View.OnClickListener
{
  CmGameLoadingView$1$1(CmGameLoadingView.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702137));
    this.a.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.this$0.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.a.this$0.setProgressViewVisibility(true);
    this.a.a.a(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.1.1
 * JD-Core Version:    0.7.0.1
 */