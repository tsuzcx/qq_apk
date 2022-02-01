package com.tencent.mobileqq.activity.qwallet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import cooperation.qwallet.plugin.QWalletPrivacyUtils;

class QWalletPrivacyFragment$2
  implements DialogInterface.OnClickListener
{
  QWalletPrivacyFragment$2(QWalletPrivacyFragment paramQWalletPrivacyFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QWalletPrivacyUtils.setHasClickAgree(this.a.getActivity().app);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletPrivacyFragment.2
 * JD-Core Version:    0.7.0.1
 */