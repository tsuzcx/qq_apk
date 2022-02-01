package com.tencent.biz.pubaccount.accountdetail.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class AccountDetailBaseItemClickHandler$2
  implements View.OnClickListener
{
  AccountDetailBaseItemClickHandler$2(AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("tel:");
    paramView.append(this.a);
    paramView = new Intent("android.intent.action.CALL", Uri.parse(paramView.toString()));
    AccountDetailBaseItemClickHandler.a(this.b).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler.2
 * JD-Core Version:    0.7.0.1
 */