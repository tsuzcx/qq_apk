package com.tencent.mobileqq.ar.view;

import android.widget.CheckBox;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class QRScanEntryView$8
  implements Runnable
{
  QRScanEntryView$8(QRScanEntryView paramQRScanEntryView) {}
  
  public void run()
  {
    QRScanEntryView.e(this.this$0).setChecked(false);
    QQToast.makeText(this.this$0.getContext(), HardCodeUtil.a(2131908827), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.8
 * JD-Core Version:    0.7.0.1
 */