package com.tencent.biz.pubaccount.accountdetail.adapter;

import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class AccountDetailBaseAdapter$6
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  int b = (int)(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float * 2.0F);
  
  AccountDetailBaseAdapter$6(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.protocolVersion == 0))
      {
        paramInt1 = -this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.b();
        paramAbsListView = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.getChildAt(0);
        if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.c)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.b)
          {
            paramInt2 = (int)(paramInt1 - this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float * 262.0F);
            this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.b(paramInt2, paramAbsListView);
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.c(paramInt1, paramAbsListView);
          }
        }
        else if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl != null) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.a(paramInt1, paramAbsListView);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager != null) && (paramInt1 != 0)) {
          if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.q - this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_Float * 75.0F) {
            this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager.a(false);
          } else {
            this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager.a();
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager.a();
      }
    }
    paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.b();
    if (Math.abs(this.jdField_a_of_type_Int - paramInt2) > this.b) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      if (this.jdField_a_of_type_Int > paramInt2) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.e = true;
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.e = false;
      }
    }
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      ((IImageManager)QRoute.api(IImageManager.class)).resume();
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.e) {
        AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter, paramAbsListView.getLastVisiblePosition(), AccountDetailBaseAdapter.d());
      } else {
        AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter, paramAbsListView.getFirstVisiblePosition() - AccountDetailBaseAdapter.d(), AccountDetailBaseAdapter.d());
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.getCount() - paramAbsListView.getLastVisiblePosition() < AccountDetailBaseAdapter.e()) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.a)) {
        AccountDetailBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter);
      }
    }
    if ((paramAbsListView instanceof AccountDetailXListView)) {
      ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.6
 * JD-Core Version:    0.7.0.1
 */