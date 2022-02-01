package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class QWalletAIOLifeCycleHelper$2
  implements View.OnClickListener
{
  QWalletAIOLifeCycleHelper$2(QWalletAIOLifeCycleHelper paramQWalletAIOLifeCycleHelper, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.a.equals("0"))
      {
        QWalletAIOLifeCycleHelper.c(this.c).Y.getText().clear();
        QWalletAIOLifeCycleHelper.e(this.c).reportPasswdTipsClick(QWalletAIOLifeCycleHelper.d(this.c));
      }
      int i = QWalletAIOLifeCycleHelper.c(this.c).Y.getSelectionStart();
      Editable localEditable = QWalletAIOLifeCycleHelper.c(this.c).Y.getText();
      this.c.a = true;
      localEditable.insert(i, this.b);
      this.c.a = false;
      QWalletAIOLifeCycleHelper.c(this.c).Y.setSelection(localEditable.length());
      this.c.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2
 * JD-Core Version:    0.7.0.1
 */