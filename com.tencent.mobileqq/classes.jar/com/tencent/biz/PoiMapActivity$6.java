package com.tencent.biz;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PoiMapActivity$6
  implements View.OnClickListener
{
  PoiMapActivity$6(PoiMapActivity paramPoiMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.cancel();
    String str2 = this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", "click_sch_cancel", str1, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.6
 * JD-Core Version:    0.7.0.1
 */