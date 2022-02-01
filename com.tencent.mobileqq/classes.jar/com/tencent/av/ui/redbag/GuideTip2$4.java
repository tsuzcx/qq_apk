package com.tencent.av.ui.redbag;

import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.CPreEventInfo;
import com.tencent.qphone.base.util.QLog;

class GuideTip2$4
  extends ControlUIObserver
{
  GuideTip2$4(GuideTip2 paramGuideTip2) {}
  
  public void b(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    if (paramCPreEventInfo.jdField_b_of_type_Boolean) {
      return;
    }
    paramCPreEventInfo.jdField_b_of_type_Boolean = this.a.a(false, 2);
    if (paramCPreEventInfo.jdField_b_of_type_Boolean) {
      paramCPreEventInfo.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + paramCPreEventInfo.jdField_b_of_type_Boolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GuideTip2.4
 * JD-Core Version:    0.7.0.1
 */