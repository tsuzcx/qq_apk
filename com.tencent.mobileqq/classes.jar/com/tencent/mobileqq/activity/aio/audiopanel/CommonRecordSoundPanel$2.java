package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.Window;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppActivity;

class CommonRecordSoundPanel$2
  implements Runnable
{
  CommonRecordSoundPanel$2(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void run()
  {
    this.this$0.setRequestedOrientation4Recording(true);
    this.this$0.a.getWindow().clearFlags(128);
    QQToast.makeText(this.this$0.a, 2131886619, 1).show(CommonRecordSoundPanel.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.2
 * JD-Core Version:    0.7.0.1
 */