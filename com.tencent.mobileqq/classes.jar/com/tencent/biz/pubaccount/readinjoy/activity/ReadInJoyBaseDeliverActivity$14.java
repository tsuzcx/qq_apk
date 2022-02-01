package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyBaseDeliverActivity$14
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyBaseDeliverActivity$14(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity, boolean paramBoolean1, long paramLong, boolean paramBoolean2, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.jdField_a_of_type_Boolean = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        ForwardSdkShareOption.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity, true, "shareToQQ", this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.moveTaskToBack(true);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.finish();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.e();
      if (this.b) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008661", "0X8008661", 0, 0, this.jdField_a_of_type_Int + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.14
 * JD-Core Version:    0.7.0.1
 */