package com.tencent.biz;

import android.app.Dialog;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class PoiMapActivity$9
  implements AdapterView.OnItemClickListener
{
  PoiMapActivity$9(PoiMapActivity paramPoiMapActivity, Dialog paramDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("setOnItemClickListener");
      paramAdapterView.append(paramInt);
      QLog.i("PoiMapActivity", 2, paramAdapterView.toString());
    }
    paramAdapterView = (PoiMapActivity.POI)this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.get(paramInt);
    if (paramAdapterView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPoiMapActivity;
      paramView.h = true;
      paramView.a(paramAdapterView);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", "click_sch_result", "", "", "", "");
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.9
 * JD-Core Version:    0.7.0.1
 */