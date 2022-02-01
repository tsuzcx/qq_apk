package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

class QWalletAIOLifeCycleHelper$3$1
  implements Runnable
{
  QWalletAIOLifeCycleHelper$3$1(QWalletAIOLifeCycleHelper.3 param3) {}
  
  public void run()
  {
    ((XPanelContainer)QWalletAIOLifeCycleHelper.c(this.a.a).aZ.findViewById(2131445137)).a(1);
    QWalletAIOLifeCycleHelper.c(this.a.a).Y.setSelection(QWalletAIOLifeCycleHelper.c(this.a.a).Y.getText().toString().length());
    QWalletAIOLifeCycleHelper.c(this.a.a).Y.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.3.1
 * JD-Core Version:    0.7.0.1
 */