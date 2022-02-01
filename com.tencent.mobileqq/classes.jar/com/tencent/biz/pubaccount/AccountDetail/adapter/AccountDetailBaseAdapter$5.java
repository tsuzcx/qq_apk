package com.tencent.biz.pubaccount.accountdetail.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import org.json.JSONException;
import org.json.JSONObject;

class AccountDetailBaseAdapter$5
  implements View.OnClickListener
{
  AccountDetailBaseAdapter$5(AccountDetailBaseAdapter paramAccountDetailBaseAdapter, int paramInt, String paramString, DynamicInfo paramDynamicInfo) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    else if ((i == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanDynamicInfo);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_JavaLangString, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanDynamicInfo.a.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanDynamicInfo.a.d), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanDynamicInfo.a.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanDynamicInfo.a.jdField_b_of_type_Int));
    JSONObject localJSONObject = new JSONObject();
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("cha_1", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanDynamicInfo.a.jdField_b_of_type_JavaLangString);
        localJSONObject.put("cha_2", AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter));
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_JavaLangString;
        i = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanDynamicInfo.a.jdField_a_of_type_Int;
        long l = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanDynamicInfo.a.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType != 1) {
          break label305;
        }
        paramView = "02";
        ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X80077FA", "0X80077FA", 0, 0, String.valueOf(i), String.valueOf(l), paramView, localJSONObject.toString());
        return;
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
      return;
      label305:
      paramView = "01";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.5
 * JD-Core Version:    0.7.0.1
 */