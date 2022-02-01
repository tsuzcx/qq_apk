package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class AVGameHelper$1$2
  implements Runnable
{
  AVGameHelper$1$2(AVGameHelper.1 param1, int paramInt) {}
  
  public void run()
  {
    if (this.a == 0)
    {
      AVGameHelper.b(this.b.a).d();
      ReportController.b(null, "dc00898", "", "", "0X800B033", "0X800B033", 0, 0, "", "", AVGameHelper.a(this.b.a).b, "");
      return;
    }
    QQToast.makeText(this.b.a.a, 1, this.b.a.a.getResources().getString(2131887416), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2
 * JD-Core Version:    0.7.0.1
 */