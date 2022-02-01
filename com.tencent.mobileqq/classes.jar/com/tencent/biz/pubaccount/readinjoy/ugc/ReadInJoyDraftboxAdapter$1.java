package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyDraftboxAdapter$1
  implements View.OnClickListener
{
  ReadInJoyDraftboxAdapter$1(ReadInJoyDraftboxAdapter paramReadInJoyDraftboxAdapter, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter), ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("readinjoy_draftbox_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    if ((ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter) instanceof BaseActivity))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.type == 0) {
        ((BaseActivity)ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter)).startActivityForResult(localIntent, 1000);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80096DF", "0X80096DF", 0, 0, ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem) + "", "", "", "", false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.1
 * JD-Core Version:    0.7.0.1
 */