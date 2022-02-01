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
  int a;
  int b = (int)(this.c.L * 2.0F);
  
  AccountDetailBaseAdapter$6(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.c.F.getFirstVisiblePosition() == 0)
    {
      if ((this.c.q != null) && (this.c.q.protocolVersion == 0))
      {
        paramInt1 = -this.c.f();
        paramAbsListView = this.c.F.getChildAt(0);
        if (this.c.z)
        {
          if (this.c.u)
          {
            paramInt2 = (int)(paramInt1 - this.c.L * 262.0F);
            this.c.b(paramInt2, paramAbsListView);
          }
          else
          {
            this.c.c(paramInt1, paramAbsListView);
          }
        }
        else if ((this.c.q != null) || (this.c.s != null)) {
          this.c.a(paramInt1, paramAbsListView);
        }
        if ((this.c.Q != null) && (paramInt1 != 0)) {
          if (paramInt1 < this.c.P - this.c.L * 75.0F) {
            this.c.Q.a(false);
          } else {
            this.c.Q.a();
          }
        }
      }
    }
    else
    {
      this.c.h();
      if (this.c.Q != null) {
        this.c.Q.a();
      }
    }
    paramInt2 = this.c.f();
    if (Math.abs(this.a - paramInt2) > this.b) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      if (this.a > paramInt2) {
        this.c.V = true;
      } else {
        this.c.V = false;
      }
    }
    this.a = paramInt2;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      ((IImageManager)QRoute.api(IImageManager.class)).resume();
      if (this.c.V) {
        AccountDetailBaseAdapter.a(this.c, paramAbsListView.getLastVisiblePosition(), AccountDetailBaseAdapter.t());
      } else {
        AccountDetailBaseAdapter.a(this.c, paramAbsListView.getFirstVisiblePosition() - AccountDetailBaseAdapter.t(), AccountDetailBaseAdapter.t());
      }
      if ((this.c.getCount() - paramAbsListView.getLastVisiblePosition() < AccountDetailBaseAdapter.u()) && (this.c.F.h)) {
        AccountDetailBaseAdapter.b(this.c);
      }
    }
    if ((paramAbsListView instanceof AccountDetailXListView)) {
      ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.6
 * JD-Core Version:    0.7.0.1
 */