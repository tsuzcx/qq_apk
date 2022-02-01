package com.tencent.biz.pubaccount.readinjoy.viola.view;

import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$23
  implements Runnable
{
  ViolaBaseView$23(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (ViolaBaseView.a(this.this$0))
    {
      QLog.d(ViolaBaseView.a(), 1, "[waitingNativeVue]: activity is destroy");
      return;
    }
    QLog.d(ViolaBaseView.a(), 1, "[waitingNativeVue]: hit");
    ViolaBaseView.j(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.23
 * JD-Core Version:    0.7.0.1
 */