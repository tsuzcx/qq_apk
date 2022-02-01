package com.tencent.mobileqq.activity.aio.helper;

import agvx;
import agvz;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class QWalletAIOLifeCycleHelper$2$1
  implements Runnable
{
  public QWalletAIOLifeCycleHelper$2$1(agvz paramagvz) {}
  
  public void run()
  {
    ((XPanelContainer)agvx.a(this.a.a).c.findViewById(2131376925)).a(1);
    agvx.a(this.a.a).a.setSelection(agvx.a(this.a.a).a.getText().toString().length());
    agvx.a(this.a.a).a.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2.1
 * JD-Core Version:    0.7.0.1
 */