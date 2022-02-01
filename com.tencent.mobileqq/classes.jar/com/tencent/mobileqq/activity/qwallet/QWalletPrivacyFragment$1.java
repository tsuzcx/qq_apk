package com.tencent.mobileqq.activity.qwallet;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.TextUrlClickListener;

class QWalletPrivacyFragment$1
  implements QWalletTools.TextUrlClickListener
{
  QWalletPrivacyFragment$1(QWalletPrivacyFragment paramQWalletPrivacyFragment) {}
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletPrivacyFragment.1
 * JD-Core Version:    0.7.0.1
 */