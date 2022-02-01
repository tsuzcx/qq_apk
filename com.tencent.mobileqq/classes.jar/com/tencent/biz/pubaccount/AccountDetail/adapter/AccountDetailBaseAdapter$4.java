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
    this.a.a.setText(2131892969);
    this.a.c.setVisibility(4);
    this.a.b.setVisibility(4);
    AccountDetailDynamicListModel.a(this.b.v, Long.parseLong(this.b.o), ((PublicAccountDetailActivityImpl)this.b.x).getPublicAccountObserver());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */