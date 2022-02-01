package com.tencent.biz;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class PoiMapActivity$PoiTab$1
  implements AdapterView.OnItemClickListener
{
  PoiMapActivity$PoiTab$1(PoiMapActivity.PoiTab paramPoiTab, PoiMapActivity paramPoiMapActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.a(paramInt, true);
    int i = this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.a.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.e != paramInt) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.a[paramInt].a(-1, false);
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiTab.1
 * JD-Core Version:    0.7.0.1
 */