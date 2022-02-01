package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class DoubleVideoCtrlUI$7
  implements View.OnClickListener
{
  DoubleVideoCtrlUI$7(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.a.d, 1, "quit double screen from reset clicker");
    if ((this.a.a != null) && (this.a.a.get() != null) && ((this.a.a.get() instanceof AVActivity))) {
      ((AVActivity)this.a.a.get()).BtnOnClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.7
 * JD-Core Version:    0.7.0.1
 */