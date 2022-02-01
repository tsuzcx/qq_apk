package com.tencent.avgame.ui;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class AVGameActivity$5
  implements Runnable
{
  AVGameActivity$5(AVGameActivity paramAVGameActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    String str = this.this$0.getString(2131690357);
    QLog.d("AVGameActivity", 2, "showDialogTip content:" + this.a);
    DialogUtil.a(this.this$0, 230, null, this.a, str, str, new AVGameActivity.5.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.5
 * JD-Core Version:    0.7.0.1
 */