package com.tencent.avgame.ui;

import com.tencent.mobileqq.widget.QQToast;

class AVGameActivity$4
  implements Runnable
{
  AVGameActivity$4(AVGameActivity paramAVGameActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    QQToast.makeText(this.this$0, this.a, this.b, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.4
 * JD-Core Version:    0.7.0.1
 */