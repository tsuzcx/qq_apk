package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class ReadInJoyAdPopSheetDialog$6
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  ReadInJoyAdPopSheetDialog$6(ReadInJoyAdPopSheetDialog paramReadInJoyAdPopSheetDialog, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - ReadInJoyAdPopSheetDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = AIOUtils.a(140.5F, ReadInJoyAdPopSheetDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog).getResources());
      ReadInJoyAdPopSheetDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ReadInJoyAdPopSheetDialog.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - ReadInJoyAdPopSheetDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = AIOUtils.a(40.0F, ReadInJoyAdPopSheetDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog).getResources());
      ReadInJoyAdPopSheetDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ReadInJoyAdPopSheetDialog.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.6
 * JD-Core Version:    0.7.0.1
 */