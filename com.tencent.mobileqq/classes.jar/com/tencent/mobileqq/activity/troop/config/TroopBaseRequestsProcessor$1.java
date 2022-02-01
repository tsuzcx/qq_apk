package com.tencent.mobileqq.activity.troop.config;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class TroopBaseRequestsProcessor$1
  implements Runnable
{
  public void run()
  {
    Object localObject;
    if ((BaseActivity.sTopActivity != null) && (!BaseActivity.sTopActivity.isFinishing()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" 群协议拉取超标！！可能存在循环拉取。请马上联系群的相关开发人员。");
      localObject = ((StringBuilder)localObject).toString();
      DialogUtil.a(BaseActivity.sTopActivity, 230, null, (CharSequence)localObject, null, "我知道了", new TroopBaseRequestsProcessor.1.1(this), null).show();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to show warning dialog. CMD exceeded the limit: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.e("TroopBaseRequestsProcessor", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopBaseRequestsProcessor.1
 * JD-Core Version:    0.7.0.1
 */