package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class EqqAccountDetailActivityImpl$13
  implements ActionSheet.OnButtonClickListener
{
  EqqAccountDetailActivityImpl$13(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, ActionSheet paramActionSheet, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.jdField_a_of_type_JavaLangString);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.startActivity(paramView);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.eqqDetail != null)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.app;
      EqqAccountDetailActivityImpl localEqqAccountDetailActivityImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl;
      CrmUtils.a(paramView, localEqqAccountDetailActivityImpl, localEqqAccountDetailActivityImpl.eqqDetail.name, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin, "IvrEnterpriseDetailEngineFalse");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.13
 * JD-Core Version:    0.7.0.1
 */