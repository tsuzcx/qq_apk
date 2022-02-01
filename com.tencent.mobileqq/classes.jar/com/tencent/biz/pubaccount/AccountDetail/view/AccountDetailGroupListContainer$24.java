package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$24
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$24(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("tel:");
    paramView.append(this.a);
    paramView = new Intent("android.intent.action.CALL", Uri.parse(paramView.toString()));
    ((BaseActivity)this.b.a.get()).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.24
 * JD-Core Version:    0.7.0.1
 */