package com.tencent.av.ui.redbag;

import android.text.TextUtils;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.CPreEventInfo;
import com.tencent.qphone.base.util.QLog;

class ResultUI$1
  extends ControlUIObserver
{
  ResultUI$1(ResultUI paramResultUI) {}
  
  public void b(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    if (paramCPreEventInfo.jdField_b_of_type_Boolean) {
      return;
    }
    paramCPreEventInfo.jdField_b_of_type_Boolean = this.a.a("onAVActivityPreBackPressed");
    if (paramCPreEventInfo.jdField_b_of_type_Boolean) {
      paramCPreEventInfo.jdField_b_of_type_JavaLangString = "AVRegbagResultUI";
    }
    QLog.w(this.a.i, 1, "onAVActivityPreBackPressed, BlockSystemBack[" + paramCPreEventInfo.jdField_b_of_type_Boolean + "]");
  }
  
  public void e(String paramString)
  {
    if (this.a.a() != null)
    {
      QLog.w(this.a.i, 1, "onActivityOnResume, peerUin[" + paramString + "], mStarter[" + this.a.a.jdField_b_of_type_Boolean + "], mPlayUin[" + this.a.a.jdField_b_of_type_JavaLangString + "], mStartUin[" + this.a.a.a + "]");
      if (((this.a.a.jdField_b_of_type_Boolean) && (TextUtils.equals(this.a.a.jdField_b_of_type_JavaLangString, paramString))) || ((!this.a.a.jdField_b_of_type_Boolean) && (TextUtils.equals(this.a.a.a, paramString)))) {
        this.a.c();
      }
    }
    else
    {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.ResultUI.1
 * JD-Core Version:    0.7.0.1
 */