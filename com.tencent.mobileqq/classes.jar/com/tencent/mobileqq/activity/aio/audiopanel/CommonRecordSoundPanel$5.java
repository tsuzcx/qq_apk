package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class CommonRecordSoundPanel$5
  implements Runnable
{
  CommonRecordSoundPanel$5(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void run()
  {
    this.this$0.setRequestedOrientation4Recording(true);
    this.this$0.a.getWindow().clearFlags(128);
    QQToast.a(this.this$0.a, 2131689965, 1).b(this.this$0.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.5
 * JD-Core Version:    0.7.0.1
 */