package com.tencent.mobileqq.activity.aio.helper;

import agjr;
import agjt;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class QWalletAIOLifeCycleHelper$2$1
  implements Runnable
{
  public QWalletAIOLifeCycleHelper$2$1(agjt paramagjt) {}
  
  public void run()
  {
    ((XPanelContainer)agjr.a(this.a.a).mAIORootView.findViewById(2131376947)).a(1);
    agjr.a(this.a.a).input.setSelection(agjr.a(this.a.a).input.getText().toString().length());
    agjr.a(this.a.a).input.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2.1
 * JD-Core Version:    0.7.0.1
 */