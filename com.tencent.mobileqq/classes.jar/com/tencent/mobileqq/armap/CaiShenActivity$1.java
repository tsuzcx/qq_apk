package com.tencent.mobileqq.armap;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class CaiShenActivity$1
  implements Handler.Callback
{
  CaiShenActivity$1(CaiShenActivity paramCaiShenActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaiShenActivity", 2, "handleMessage : " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      CaiShenActivity.access$000(this.this$0, "正在请求...");
      continue;
      if (this.this$0.mHandler.hasMessages(1001)) {
        this.this$0.mHandler.removeMessages(1001);
      }
      for (;;)
      {
        QQToast.a(this.this$0, "无法领取奖励，请检查网络设置。", 1).a();
        break;
        CaiShenActivity.access$100(this.this$0);
      }
      if ((!this.this$0.isFinishing()) && ((CaiShenActivity.access$200(this.this$0) == 6) || (CaiShenActivity.access$200(this.this$0) == 7)))
      {
        DialogUtil.a(this.this$0, 230, this.this$0.getResources().getString(2131438751), this.this$0.getResources().getString(2131438752), this.this$0.getResources().getString(2131438750), "", null, new CaiShenActivity.1.1(this)).show();
        continue;
        this.this$0.finish();
        ReportController.b(null, "dc01440", "", "", "0X8007A38", "0X8007A38", 0, 0, "", "", "", "");
        CaiShenActivity.access$300(this.this$0).d = true;
        this.this$0.hideGuide();
        if (QLog.isColorLevel()) {
          QLog.i("ARTreasurePlayControl", 2, "initMode when timeout trigger");
        }
        CaiShenActivity.access$300(this.this$0).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.1
 * JD-Core Version:    0.7.0.1
 */