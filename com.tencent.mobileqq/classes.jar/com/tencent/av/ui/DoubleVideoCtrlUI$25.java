package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;

class DoubleVideoCtrlUI$25
  implements QavInOutAnimation.QavOutAnimationListener
{
  DoubleVideoCtrlUI$25(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong, String paramString) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.j = true;
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.O();
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
    if (localEffectOperateManager != null) {
      localEffectOperateManager.b(false);
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.Q();
  }
  
  public void b()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a();
    TraeHelper.a().b(this.jdField_a_of_type_Long);
    localSessionInfo.f = false;
    if (localSessionInfo.z != -1) {}
    for (;;)
    {
      localSessionInfo.t = true;
      DataReport.d(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController);
      if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.c) {
        DataReport.r(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController);
      }
      if ((localSessionInfo.l()) && (localSessionInfo.d == 2) && (!localSessionInfo.j)) {
        DataReport.e();
      }
      AVLog.printColorLog(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d, "DataReport onClose: ");
      EffectPendantTools.DataReport.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d, this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      EffectZimuManager.DataReport.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      EffectFilterTools.DataReport.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      BeautyToolbar.DataReport.b(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      VoiceChangeDataReport.a(localSessionInfo);
      String str = localSessionInfo.b() + "";
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, 237);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.b(237);
      MagicDataReport.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
      MagicDataReport.a(2, str);
      MagicDataReport.a(2);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_JavaLangString, localSessionInfo.z);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.b = true;
      localSessionInfo.a("onClick_HangeUP", false);
      localSessionInfo.b("onClick_HangeUP", 0);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.j = false;
      return;
      localSessionInfo.z = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.25
 * JD-Core Version:    0.7.0.1
 */