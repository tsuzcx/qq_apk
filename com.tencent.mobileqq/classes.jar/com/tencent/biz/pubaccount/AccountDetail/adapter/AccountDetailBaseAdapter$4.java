package com.tencent.biz.pubaccount.accountdetail.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailDynamicListModel;

class AccountDetailBaseAdapter$4
  implements View.OnClickListener
{
  AccountDetailBaseAdapter$4(AccountDetailBaseAdapter paramAccountDetailBaseAdapter, AccountDetailBaseAdapter.ErrorItemHolder paramErrorItemHolder) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$ErrorItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131695235);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$ErrorItemHolder.b.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$ErrorItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    AccountDetailDynamicListModel.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_JavaLangString), ((PublicAccountDetailActivityImpl)this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_AndroidAppActivity).getPublicAccountObserver());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */