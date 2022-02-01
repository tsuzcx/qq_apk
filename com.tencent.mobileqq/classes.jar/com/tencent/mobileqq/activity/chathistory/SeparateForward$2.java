package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class SeparateForward$2
  extends TroopObserver
{
  SeparateForward$2(SeparateForward paramSeparateForward) {}
  
  protected void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject)
  {
    SeparateForward.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      MultiMsgManager.a().b.clear();
      if ((paramBoolean) && (paramObject != null))
      {
        MultiMsgManager.a().b.putAll((Map)paramObject);
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onBatchTroopCardDefaultNick = ");
          localStringBuilder.append(paramObject);
          QLog.d("MultiMsg_TAG", 4, localStringBuilder.toString());
        }
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
      }
      if (MultiMsgManager.a().b.size() == 0)
      {
        paramObject = (QBaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if (paramObject != null) {
          QQToast.a(paramObject, 2131698526, 0).b(paramObject.getTitleBarHeight());
        }
      }
      else
      {
        this.a.a((Map)paramObject, MultiMsgManager.a().a);
      }
      return;
    }
    QLog.e("SeparateForward", 1, new Object[] { "onBatchTroopCardDefaultNick timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SeparateForward.2
 * JD-Core Version:    0.7.0.1
 */