package com.tencent.luggage.scanner.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseScanUI$14
  implements View.OnClickListener
{
  BaseScanUI$14(BaseScanUI paramBaseScanUI) {}
  
  public void onClick(View paramView)
  {
    if (BaseScanUI.j(this.a)) {
      BaseScanUI.k(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.14
 * JD-Core Version:    0.7.0.1
 */