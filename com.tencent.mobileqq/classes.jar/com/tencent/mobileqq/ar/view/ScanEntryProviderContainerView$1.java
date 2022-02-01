package com.tencent.mobileqq.ar.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ScanEntryProviderContainerView$1
  implements View.OnTouchListener
{
  ScanEntryProviderContainerView$1(ScanEntryProviderContainerView paramScanEntryProviderContainerView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, String.format("dispatchTouchEvent onTabClickListener", new Object[0]));
    }
    long l = System.currentTimeMillis();
    if (l - ScanEntryProviderContainerView.a(this.a) <= 1000L) {
      QLog.i("ScanEntryProviderContainerView", 1, "avoid user fast click");
    }
    do
    {
      return false;
      ScanEntryProviderContainerView.a(this.a, l);
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      }
      paramView = (Integer)paramView.getTag();
      ScanEntryProviderContainerView.a(this.a).a(paramView.intValue(), new ScanEntryProviderContainerView.1.1(this, paramView));
    } while (paramView.intValue() != 2);
    ReportController.b(null, "dc00898", "", "", "0X800A9CE", "0X800A9CE", 0, 0, "", "0", "0", "");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.1
 * JD-Core Version:    0.7.0.1
 */