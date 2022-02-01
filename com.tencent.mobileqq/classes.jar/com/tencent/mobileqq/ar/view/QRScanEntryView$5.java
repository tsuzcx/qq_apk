package com.tencent.mobileqq.ar.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QRScanEntryView$5
  implements CompoundButton.OnCheckedChangeListener
{
  QRScanEntryView$5(QRScanEntryView paramQRScanEntryView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    com.tencent.mobileqq.minicode.RecogUtil.SAVE_DETECT_IMAGE = paramBoolean;
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.5
 * JD-Core Version:    0.7.0.1
 */