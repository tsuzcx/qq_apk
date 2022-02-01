package com.tencent.biz;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PoiMapActivity$7
  implements View.OnClickListener
{
  PoiMapActivity$7(PoiMapActivity paramPoiMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.7
 * JD-Core Version:    0.7.0.1
 */