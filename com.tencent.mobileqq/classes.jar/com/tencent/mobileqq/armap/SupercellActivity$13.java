package com.tencent.mobileqq.armap;

import android.os.Handler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SupercellActivity$13
  implements CameraSurfaceView.CameraSurfaceViewCallBack
{
  SupercellActivity$13(SupercellActivity paramSupercellActivity) {}
  
  public void onStartPreview(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SupercellActivity", 2, "onStartPreview isSucc:" + paramBoolean);
    }
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      ReportController.b(null, "dc01440", "", "", "0X8007A3A", "0X8007A3A", 0, 0, str, "", "", "");
      SupercellActivity.access$2200(this.this$0).post(new SupercellActivity.13.1(this, paramBoolean));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.13
 * JD-Core Version:    0.7.0.1
 */