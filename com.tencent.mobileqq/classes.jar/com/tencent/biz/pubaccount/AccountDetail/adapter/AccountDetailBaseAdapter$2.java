package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountDetailBaseAdapter$2
  implements View.OnClickListener
{
  AccountDetailBaseAdapter$2(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onClick(View paramView)
  {
    this.a.d(this.a.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.2
 * JD-Core Version:    0.7.0.1
 */