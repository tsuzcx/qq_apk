package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class QWalletAIOLifeCycleHelper$1
  implements View.OnClickListener
{
  QWalletAIOLifeCycleHelper$1(QWalletAIOLifeCycleHelper paramQWalletAIOLifeCycleHelper, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        QWalletAIOLifeCycleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper).a.getText().clear();
        QWalletAIOLifeCycleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper).reportPasswdTipsClick(QWalletAIOLifeCycleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper));
      }
      int i = QWalletAIOLifeCycleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper).a.getSelectionStart();
      Editable localEditable = QWalletAIOLifeCycleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper).a.getText();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper.a = true;
      localEditable.insert(i, this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper.a = false;
      QWalletAIOLifeCycleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper).a.setSelection(localEditable.length());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper.a();
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onclick  PasswdRedBagTips throw an exception: ");
      localStringBuilder.append(localThrowable);
      QLog.e("QWalletAIOLifeCycleHelper", 1, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.1
 * JD-Core Version:    0.7.0.1
 */