package com.tencent.avgame.ui;

import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import noj;

public class AVGameActivity$6
  implements Runnable
{
  AVGameActivity$6(AVGameActivity paramAVGameActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    String str = this.this$0.getString(2131690290);
    QLog.d("AVGameActivity", 2, "showDialogTip content:" + this.a);
    bhdj.a(this.this$0, 230, null, this.a, str, str, new noj(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.6
 * JD-Core Version:    0.7.0.1
 */