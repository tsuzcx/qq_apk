package com.tencent.mobileqq.activity.aio.forward;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class MergeForwardRevokeHelper$RevokeMessageObserver
  extends MessageObserver
{
  private WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  private MergeForwardRevokeHelper$RevokeMessageObserver(MergeForwardRevokeHelper paramMergeForwardRevokeHelper, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
    if ((MergeForwardRevokeHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper, paramList)) && (paramBoolean1)) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      paramList = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("MergeForwardRevokeHelper", 2, "onMsgRevokeNotice  hasMsgRevoked:" + paramBoolean2 + "; isSuccess:" + paramBoolean1);
      }
      if ((paramBoolean2) && (paramList != null))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper.a) {
          break;
        }
        paramList.finish();
      }
      return;
    }
    if (MergeForwardRevokeHelper.a() == paramList)
    {
      MergeForwardRevokeHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioForwardMergeForwardRevokeHelper, paramList);
      return;
    }
    paramList.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper.RevokeMessageObserver
 * JD-Core Version:    0.7.0.1
 */