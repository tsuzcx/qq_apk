package com.tencent.mobileqq.ar.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.QRSession;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QRScanEntryView$4
  implements View.OnClickListener
{
  QRScanEntryView$4(QRScanEntryView paramQRScanEntryView) {}
  
  public void onClick(View paramView)
  {
    if (QRScanEntryView.c(this.a))
    {
      if (CameraProxy.a().b(QRScanEntryView.d(this.a) ^ true))
      {
        QRScanEntryView localQRScanEntryView = this.a;
        QRScanEntryView.a(localQRScanEntryView, QRScanEntryView.d(localQRScanEntryView) ^ true);
        ((QRSession)this.a.G).a(QRScanEntryView.d(this.a) ^ true, 0L);
        QRScanEntryView.b(this.a, true);
        localQRScanEntryView = this.a;
        QRScanEntryView.c(localQRScanEntryView, QRScanEntryView.d(localQRScanEntryView));
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "initView click mFlashLightTips when view invisble.");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.4
 * JD-Core Version:    0.7.0.1
 */