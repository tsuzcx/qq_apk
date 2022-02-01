package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

class QWalletAIOLifeCycleHelper$2$1
  implements Runnable
{
  QWalletAIOLifeCycleHelper$2$1(QWalletAIOLifeCycleHelper.2 param2) {}
  
  public void run()
  {
    ((XPanelContainer)QWalletAIOLifeCycleHelper.a(this.a.a).c.findViewById(2131376809)).a(1);
    QWalletAIOLifeCycleHelper.a(this.a.a).a.setSelection(QWalletAIOLifeCycleHelper.a(this.a.a).a.getText().toString().length());
    QWalletAIOLifeCycleHelper.a(this.a.a).a.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2.1
 * JD-Core Version:    0.7.0.1
 */