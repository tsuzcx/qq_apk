package com.tencent.av.ui.redbag;

import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.CEffectEntrancePreClickInfo;
import com.tencent.av.ui.ControlUIObserver.CPreChangButtonStyleInfo;
import com.tencent.av.ui.ControlUIObserver.CPreEventInfo;

class OtherBtnController$1
  extends ControlUIObserver
{
  String jdField_a_of_type_JavaLangString = "AVRedbag_GameMode";
  
  OtherBtnController$1(OtherBtnController paramOtherBtnController) {}
  
  public void a(ControlUIObserver.CEffectEntrancePreClickInfo paramCEffectEntrancePreClickInfo)
  {
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if ((!this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a()) || (localAVActivity == null)) {
      return;
    }
    if (paramCEffectEntrancePreClickInfo.jdField_a_of_type_Int == 1) {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695799);
    }
    for (;;)
    {
      paramCEffectEntrancePreClickInfo.jdField_b_of_type_Boolean = true;
      paramCEffectEntrancePreClickInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      return;
      if (paramCEffectEntrancePreClickInfo.jdField_a_of_type_Int == 2) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695798);
      }
    }
  }
  
  public void a(ControlUIObserver.CPreChangButtonStyleInfo paramCPreChangButtonStyleInfo)
  {
    AVRedBagMgr localAVRedBagMgr = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if (localAVRedBagMgr == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!localAVRedBagMgr.a());
      i = paramCPreChangButtonStyleInfo.a().getId();
    } while ((i != 2131695326) && (i != 2131695327));
    if (i == 2131695326) {
      this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_Int = paramCPreChangButtonStyleInfo.jdField_a_of_type_Int;
    }
    paramCPreChangButtonStyleInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramCPreChangButtonStyleInfo.jdField_a_of_type_Boolean = false;
  }
  
  public void c(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if ((!this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a()) || (localAVActivity == null)) {
      return;
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695794);
    paramCPreEventInfo.jdField_b_of_type_Boolean = true;
    paramCPreEventInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public void d(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if ((!this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a()) || (localAVActivity == null)) {
      return;
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695796);
    paramCPreEventInfo.jdField_b_of_type_Boolean = true;
    paramCPreEventInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public void e(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    AVRedBagMgr localAVRedBagMgr = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if (localAVRedBagMgr == null) {}
    while ((localAVRedBagMgr.a == null) || (localAVRedBagMgr.a.a == null) || (localAVRedBagMgr.a.a.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().j) || (this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a() == null) || (!this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a())) {
      return;
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1045, 2131695795);
    paramCPreEventInfo.jdField_b_of_type_Boolean = true;
    paramCPreEventInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public void f(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    paramCPreEventInfo = this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    if ((paramCPreEventInfo != null) && (paramCPreEventInfo.a())) {
      RedBagReport.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.OtherBtnController.1
 * JD-Core Version:    0.7.0.1
 */