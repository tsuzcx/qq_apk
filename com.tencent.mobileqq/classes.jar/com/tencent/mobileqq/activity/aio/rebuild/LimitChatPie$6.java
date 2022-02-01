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
    if (this.a.d(paramInt))
    {
      if (this.a.t()) {
        return false;
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698822, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131299168));
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B3D2", "0X800B3D2", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.6
 * JD-Core Version:    0.7.0.1
 */