package com.tencent.mobileqq.activity.aio.helper;

import agmv;
import agmx;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class QWalletAIOLifeCycleHelper$2$1
  implements Runnable
{
  public QWalletAIOLifeCycleHelper$2$1(agmx paramagmx) {}
  
  public void run()
  {
    ((XPanelContainer)agmv.a(this.a.a).c.findViewById(2131376788)).a(1);
    agmv.a(this.a.a).a.setSelection(agmv.a(this.a.a).a.getText().toString().length());
    agmv.a(this.a.a).a.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2.1
 * JD-Core Version:    0.7.0.1
 */