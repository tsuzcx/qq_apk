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
    boolean bool2 = false;
    boolean bool1;
    if (QRScanEntryView.a(this.a))
    {
      Object localObject = CameraProxy.a();
      if (!QRScanEntryView.b(this.a))
      {
        bool1 = true;
        if (((CameraProxy)localObject).a(bool1))
        {
          localObject = this.a;
          if (QRScanEntryView.b(this.a)) {
            break label131;
          }
          bool1 = true;
          label56:
          QRScanEntryView.a((QRScanEntryView)localObject, bool1);
          localObject = (QRSession)this.a.a;
          bool1 = bool2;
          if (!QRScanEntryView.b(this.a)) {
            bool1 = true;
          }
          ((QRSession)localObject).a(bool1, 0L);
          QRScanEntryView.a(this.a, true);
          QRScanEntryView.b(this.a, QRScanEntryView.b(this.a));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool1 = false;
      break;
      label131:
      bool1 = false;
      break label56;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_QRScanEntryView", 2, "initView click mFlashLightTips when view invisble.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.4
 * JD-Core Version:    0.7.0.1
 */