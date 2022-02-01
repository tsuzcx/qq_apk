package com.tencent.avgame.ui;

import bglp;
import bgpa;
import com.tencent.qphone.base.util.QLog;
import neo;

public class AVGameActivity$5
  implements Runnable
{
  AVGameActivity$5(AVGameActivity paramAVGameActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    String str = this.this$0.getString(2131690218);
    QLog.d("AVGameActivity", 2, "showDialogTip content:" + this.a);
    bglp.a(this.this$0, 230, null, this.a, str, str, new neo(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.5
 * JD-Core Version:    0.7.0.1
 */