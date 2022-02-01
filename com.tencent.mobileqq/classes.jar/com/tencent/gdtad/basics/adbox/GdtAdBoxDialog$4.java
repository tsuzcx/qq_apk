package com.tencent.gdtad.basics.adbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtAdBoxDialog$4
  implements View.OnClickListener
{
  GdtAdBoxDialog$4(GdtAdBoxDialog paramGdtAdBoxDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBoxPresenter.a(this.a.jdField_a_of_type_AndroidAppActivity, paramView, this.a.a(paramView), GdtAdBoxDialog.a(this.a), this.a.jdField_a_of_type_ComTencentGdtadBasicsAdboxGdtAdBox.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxDialog.4
 * JD-Core Version:    0.7.0.1
 */