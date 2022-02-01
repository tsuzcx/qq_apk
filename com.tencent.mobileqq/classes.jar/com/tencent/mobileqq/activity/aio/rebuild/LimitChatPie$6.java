package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.IconClickInterceptListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class LimitChatPie$6
  implements PanelIconLinearLayout.IconClickInterceptListener
{
  LimitChatPie$6(LimitChatPie paramLimitChatPie) {}
  
  public boolean a(int paramInt)
  {
    if (this.a.u(paramInt))
    {
      if (this.a.bD()) {
        return false;
      }
      QQToast.makeText(this.a.d.getApp(), 2131896790, 0).show(this.a.f.getResources().getDimensionPixelSize(2131299920));
      ReportController.b(this.a.d, "dc00898", "", "", "0X800B3D2", "0X800B3D2", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.6
 * JD-Core Version:    0.7.0.1
 */