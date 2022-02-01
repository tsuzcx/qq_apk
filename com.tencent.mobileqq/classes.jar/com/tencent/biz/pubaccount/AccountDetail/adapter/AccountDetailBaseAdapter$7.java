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
    if ((this.a.F.getFirstVisiblePosition() == 0) && (this.a.u))
    {
      paramInt = -this.a.f();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEndScroll scrollY = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" ,isScrollUp = ");
        localStringBuilder.append(this.a.V);
        QLog.d("AccountDetailBaseAdapter", 2, localStringBuilder.toString());
      }
      float f = this.a.L * 150.0F;
      if (paramInt != 0)
      {
        if (this.a.V)
        {
          if (paramInt > f)
          {
            this.a.e(paramInt);
            return;
          }
          this.a.l();
          return;
        }
        if (paramInt > this.a.P - f)
        {
          this.a.e(paramInt);
          return;
        }
        this.a.l();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.7
 * JD-Core Version:    0.7.0.1
 */