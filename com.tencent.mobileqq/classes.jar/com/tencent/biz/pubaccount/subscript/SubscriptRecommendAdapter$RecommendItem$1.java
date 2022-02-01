package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class SubscriptRecommendAdapter$RecommendItem$1
  implements View.OnClickListener
{
  SubscriptRecommendAdapter$RecommendItem$1(SubscriptRecommendAdapter.RecommendItem paramRecommendItem, SubscriptRecommendAdapter paramSubscriptRecommendAdapter) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.a), "", "", "");
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo != null)
    {
      str = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.a);
      if (!TextUtils.isEmpty(str)) {
        break label116;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label116:
      if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.c == 0)
      {
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity, 2131694459, 0).b(((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.a(2);
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.c = 2;
          MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
          if ((localMqqHandler != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity instanceof SubscriptFeedsActivity))) {
            localMqqHandler.sendEmptyMessage(1007);
          }
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity, str, new SubscriptRecommendAdapter.RecommendPublicAccountObserver(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem));
        }
      }
      else {
        SubscriptRecommendAdapter.RecommendItem.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem.1
 * JD-Core Version:    0.7.0.1
 */