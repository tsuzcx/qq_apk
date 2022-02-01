package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountDetailBaseAdapter$4
  implements View.OnClickListener
{
  AccountDetailBaseAdapter$4(AccountDetailBaseAdapter paramAccountDetailBaseAdapter, AccountDetailBaseAdapter.ErrorItemHolder paramErrorItemHolder) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter$ErrorItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131695239);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter$ErrorItemHolder.b.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter$ErrorItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    AccountDetailDynamicListModel.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_JavaLangString), ((PublicAccountDetailActivityImpl)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_AndroidAppActivity).getPublicAccountObserver());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */