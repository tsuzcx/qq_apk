package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class ScanEntryProviderContainerView$2
  implements Runnable
{
  ScanEntryProviderContainerView$2(ScanEntryProviderContainerView paramScanEntryProviderContainerView) {}
  
  public void run()
  {
    QQToast localQQToast = QQToast.makeText(this.this$0.a, HardCodeUtil.a(2131910985), 1);
    localQQToast.setAutoTextSize();
    localQQToast.show();
    ((Activity)this.this$0.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.2
 * JD-Core Version:    0.7.0.1
 */