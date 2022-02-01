package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
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
        QWalletAIOLifeCycleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper).c(QWalletAIOLifeCycleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperQWalletAIOLifeCycleHelper));
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
      for (;;)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  PasswdRedBagTips throw an exception: " + localThrowable);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.1
 * JD-Core Version:    0.7.0.1
 */