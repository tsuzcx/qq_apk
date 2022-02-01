package com.tencent.mobileqq.app.qqdaily;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQDailyArkView$2$1
  implements View.OnClickListener
{
  QQDailyArkView$2$1(QQDailyArkView.2 param2, ArkViewModel paramArkViewModel) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentArkArkViewModel != null) {
      this.jdField_a_of_type_ComTencentArkArkViewModel.reinitArkContainer();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyArkView.2.1
 * JD-Core Version:    0.7.0.1
 */