package com.tencent.biz.widgets;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ScannerView$WeakSensorEventListener
  implements SensorEventListener
{
  private WeakReference<ScannerView> a;
  
  public ScannerView$WeakSensorEventListener(ScannerView paramScannerView)
  {
    this.a = new WeakReference(paramScannerView);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    ScannerView localScannerView = (ScannerView)this.a.get();
    if (localScannerView != null)
    {
      localScannerView.a(paramSensorEvent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScannerView", 2, "onSensorChanged but mRef got null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.WeakSensorEventListener
 * JD-Core Version:    0.7.0.1
 */