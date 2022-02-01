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
  private WeakReference<BaseActivity> b;
  
  private MergeForwardRevokeHelper$RevokeMessageObserver(MergeForwardRevokeHelper paramMergeForwardRevokeHelper, BaseActivity paramBaseActivity)
  {
    this.b = new WeakReference(paramBaseActivity);
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
    if ((MergeForwardRevokeHelper.a(this.a, paramList)) && (paramBoolean1)) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    paramList = (BaseActivity)this.b.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMsgRevokeNotice  hasMsgRevoked:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("; isSuccess:");
      localStringBuilder.append(paramBoolean1);
      QLog.d("MergeForwardRevokeHelper", 2, localStringBuilder.toString());
    }
    if ((paramBoolean2) && (paramList != null))
    {
      if (this.a.a)
      {
        paramList.finish();
        return;
      }
      if (MergeForwardRevokeHelper.a() == paramList)
      {
        MergeForwardRevokeHelper.a(this.a, paramList);
        return;
      }
      paramList.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper.RevokeMessageObserver
 * JD-Core Version:    0.7.0.1
 */