package com.tencent.mobileqq.activity.qwallet.impl;

import Wallet.PfaFriend;
import Wallet.PfaFriendRsp;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ToPayManagerImpl$4
  implements DialogInterface.OnClickListener
{
  ToPayManagerImpl$4(ToPayManagerImpl paramToPayManagerImpl, WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof QQCustomDialogWtihInputAndChoose)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      ToPayManagerImpl.sendTopay((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaUtilArrayList, (QQCustomDialogWtihInputAndChoose)paramDialogInterface);
    } while ((ToPayManagerImpl.mData == null) || (ToPayManagerImpl.mData.vecRec == null) || (ToPayManagerImpl.mData.vecRec.size() <= 0));
    paramInt = 0;
    label79:
    String str;
    int i;
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      str = "friendpay.selectpage.unrecomchoosefriclick";
      i = 0;
    }
    for (;;)
    {
      paramDialogInterface = str;
      if (i < ToPayManagerImpl.mData.vecRec.size())
      {
        if (((ResultRecord)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).uin.equals(((PfaFriend)ToPayManagerImpl.mData.vecRec.get(i)).uin)) {
          paramDialogInterface = "friendpay.selectpage.recommendfriclick";
        }
      }
      else
      {
        ReportController.b(QWalletTools.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramDialogInterface, 0, 0, "", "", "", "");
        paramInt += 1;
        break label79;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.impl.ToPayManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */