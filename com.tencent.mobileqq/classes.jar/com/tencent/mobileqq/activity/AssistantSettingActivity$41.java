package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.qphone.base.util.QLog;

class AssistantSettingActivity$41
  implements DialogInterface.OnClickListener
{
  AssistantSettingActivity$41(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("vip_ptt.AssistantSettingActivity", 1, "click pay for auto ptt");
    paramDialogInterface = QVipAutoPttProcessor.c();
    if (TextUtils.isEmpty(paramDialogInterface.a))
    {
      QVipUtils.a(this.a, "https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&type=!svip&aid=mvip.n.a.zdzwz");
    }
    else
    {
      paramDialogInterface = paramDialogInterface.a.replace("{aid}", "mvip.n.a.zdzwz");
      QVipUtils.a(this.a, paramDialogInterface);
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.41
 * JD-Core Version:    0.7.0.1
 */