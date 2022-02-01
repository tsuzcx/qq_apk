package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class SeparateForward$1
  extends FriendListObserver
{
  SeparateForward$1(SeparateForward paramSeparateForward) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    SeparateForward.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      MultiMsgManager.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        MultiMsgManager.a().b.putAll((Map)paramObject);
      }
      Object localObject;
      if (MultiMsgManager.a().b.size() == 0)
      {
        localObject = (QBaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if (localObject != null) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698526, 0).b(((QBaseActivity)localObject).getTitleBarHeight());
        }
      }
      else
      {
        this.a.a((Map)paramObject, MultiMsgManager.a().a);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetFriendNickBatch = ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SeparateForward.1
 * JD-Core Version:    0.7.0.1
 */