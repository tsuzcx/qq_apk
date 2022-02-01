package com.tencent.biz.pubaccount.accountdetail.adapter;

import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView.OnEndScrollListener;
import com.tencent.qphone.base.util.QLog;

class AccountDetailBaseAdapter$7
  implements AccountDetailXListView.OnEndScrollListener
{
  AccountDetailBaseAdapter$7(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.getFirstVisiblePosition() == 0) && (this.a.b))
    {
      paramInt = -this.a.b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEndScroll scrollY = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" ,isScrollUp = ");
        localStringBuilder.append(this.a.e);
        QLog.d("AccountDetailBaseAdapter", 2, localStringBuilder.toString());
      }
      float f = this.a.jdField_a_of_type_Float * 150.0F;
      if (paramInt != 0)
      {
        if (this.a.e)
        {
          if (paramInt > f)
          {
            this.a.d(paramInt);
            return;
          }
          this.a.e();
          return;
        }
        if (paramInt > this.a.q - f)
        {
          this.a.d(paramInt);
          return;
        }
        this.a.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.7
 * JD-Core Version:    0.7.0.1
 */