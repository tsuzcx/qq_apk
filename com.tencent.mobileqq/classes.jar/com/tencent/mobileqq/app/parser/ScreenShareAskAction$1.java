package com.tencent.mobileqq.app.parser;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ScreenShareAskAction$1
  implements Runnable
{
  ScreenShareAskAction$1(ScreenShareAskAction paramScreenShareAskAction) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.this$0.b;
    String str1 = (String)this.this$0.f.get("requestUin");
    Object localObject = (String)this.this$0.f.get("expireDate");
    long l1;
    if (localObject != null) {
      l1 = Long.parseLong((String)localObject);
    } else {
      l1 = 0L;
    }
    long l2 = System.currentTimeMillis() / 1000L;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doAction requestUin: ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("curuin: ");
      ((StringBuilder)localObject).append(ScreenShareAskAction.a(this.this$0).getCurrentAccountUin());
      ((StringBuilder)localObject).append(" expireDate: ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("nowDate: ");
      ((StringBuilder)localObject).append(l2);
      QLog.i("ScreenShareAskAction", 1, ((StringBuilder)localObject).toString());
    }
    if (l2 > l1)
    {
      QQToast.makeText(this.this$0.b, 1, 2131916056, 1).show();
    }
    else if (str1.equals(ScreenShareAskAction.a(this.this$0).getCurrentAccountUin()))
    {
      localObject = localBaseActivity.getString(2131916061);
      String str2 = localBaseActivity.getString(2131916060);
      DialogUtil.a(localBaseActivity, 230, null, (CharSequence)localObject, str2, str2, new ScreenShareAskAction.1.1(this), null).show();
    }
    else
    {
      this.this$0.a(localBaseActivity, str1);
    }
    ReportController.b(null, "dc00898", "", str1, "0X800B8A4", "0X800B8A4", 0, 0, str1, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ScreenShareAskAction.1
 * JD-Core Version:    0.7.0.1
 */