package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.olympic.activity.ARTipsManager.BaikeClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ScanningSurfaceView$8$1
  implements ARTipsManager.BaikeClickListener
{
  ScanningSurfaceView$8$1(ScanningSurfaceView.8 param8) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "onContentClick subFaceData.wikiurl = " + this.a.b.c);
    }
    ScanningSurfaceView.b(this.a.this$0, this.a.b.c);
    ReportController.b(null, "dc00898", "", "", "0X8008351", "0X8008351", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "onFeedbackClick subFaceData.wikiurl = " + this.a.b.c);
    }
    this.a.this$0.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView.8.1
 * JD-Core Version:    0.7.0.1
 */