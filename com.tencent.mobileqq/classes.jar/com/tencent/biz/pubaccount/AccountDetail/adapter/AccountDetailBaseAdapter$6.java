package com.tencent.biz.pubaccount.AccountDetail.adapter;

import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class AccountDetailBaseAdapter$6
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  int b = (int)(2.0F * this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float);
  
  AccountDetailBaseAdapter$6(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 0))
      {
        paramInt1 = -this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b();
        paramAbsListView = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.c) {
          break label215;
        }
        if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b) {
          break label203;
        }
        paramInt2 = (int)(paramInt1 - 262.0F * this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b(paramInt2, paramAbsListView);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager != null) && (paramInt1 != 0))
        {
          if (paramInt1 >= this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.q - 75.0F * this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float) {
            break label247;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager.a(false);
        }
      }
      label151:
      paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.b();
      if (Math.abs(this.jdField_a_of_type_Int - paramInt2) <= this.b) {
        break label290;
      }
      paramInt1 = 1;
      label177:
      if (paramInt1 != 0) {
        if (this.jdField_a_of_type_Int <= paramInt2) {
          break label295;
        }
      }
    }
    label290:
    label295:
    for (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.e = true;; this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.e = false)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
      label203:
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.c(paramInt1, paramAbsListView);
      break;
      label215:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.a(paramInt1, paramAbsListView);
      break;
      label247:
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager.a();
      break label151;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager == null) {
        break label151;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailVideoManager.a();
      break label151;
      paramInt1 = 0;
      break label177;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      ImageManager.a().c();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.e) {
        break label89;
      }
      AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter, paramAbsListView.getLastVisiblePosition(), AccountDetailBaseAdapter.d());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.getCount() - paramAbsListView.getLastVisiblePosition() < AccountDetailBaseAdapter.e()) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a)) {
        AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter);
      }
      if ((paramAbsListView instanceof AccountDetailXListView)) {
        ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      label89:
      AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailAdapterAccountDetailBaseAdapter, paramAbsListView.getFirstVisiblePosition() - AccountDetailBaseAdapter.d(), AccountDetailBaseAdapter.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.6
 * JD-Core Version:    0.7.0.1
 */