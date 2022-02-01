package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.IconClickInterceptListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class LimitChatPie$1
  implements PanelIconLinearLayout.IconClickInterceptListener
{
  LimitChatPie$1(LimitChatPie paramLimitChatPie) {}
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt != 2) && (paramInt != 4))
    {
      bool1 = bool2;
      if (paramInt != 5) {}
    }
    else
    {
      bool1 = bool2;
      if (!LimitChatPie.a(this.a))
      {
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698747, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131299166));
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B3D2", "0X800B3D2", 0, 0, "", "", "", "");
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.1
 * JD-Core Version:    0.7.0.1
 */