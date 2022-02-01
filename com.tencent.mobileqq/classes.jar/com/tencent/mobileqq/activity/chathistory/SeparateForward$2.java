package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class SeparateForward$2
  extends TroopBusinessObserver
{
  SeparateForward$2(SeparateForward paramSeparateForward) {}
  
  public void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject)
  {
    SeparateForward.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      QLog.e("SeparateForward", 1, new Object[] { "onBatchTroopCardDefaultNick timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    MultiMsgManager.a().b.clear();
    if ((paramBoolean) && (paramObject != null))
    {
      MultiMsgManager.a().b.putAll((Map)paramObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
      }
    }
    for (;;)
    {
      if (MultiMsgManager.a().b.size() != 0) {
        break label201;
      }
      paramObject = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramObject == null) {
        break;
      }
      QQToast.a(paramObject, 2131698460, 0).b(paramObject.getTitleBarHeight());
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
      }
    }
    label201:
    this.a.a((Map)paramObject, MultiMsgManager.a().a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SeparateForward.2
 * JD-Core Version:    0.7.0.1
 */