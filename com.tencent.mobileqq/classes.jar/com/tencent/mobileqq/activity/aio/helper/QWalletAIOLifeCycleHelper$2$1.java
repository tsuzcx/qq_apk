package com.tencent.mobileqq.activity.aio.helper;

import afbe;
import afbg;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class QWalletAIOLifeCycleHelper$2$1
  implements Runnable
{
  public QWalletAIOLifeCycleHelper$2$1(afbg paramafbg) {}
  
  public void run()
  {
    ((XPanelContainer)afbe.a(this.a.a).c.findViewById(2131375981)).a(1);
    afbe.a(this.a.a).a.setSelection(afbe.a(this.a.a).a.getText().toString().length());
    afbe.a(this.a.a).a.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2.1
 * JD-Core Version:    0.7.0.1
 */