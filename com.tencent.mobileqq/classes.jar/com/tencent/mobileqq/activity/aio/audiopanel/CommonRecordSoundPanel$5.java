package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.Window;
import bbmy;
import com.tencent.mobileqq.app.BaseActivity;

class CommonRecordSoundPanel$5
  implements Runnable
{
  CommonRecordSoundPanel$5(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void run()
  {
    this.this$0.setRequestedOrientation4Recording(true);
    this.this$0.a.getWindow().clearFlags(128);
    bbmy.a(this.this$0.a, 2131624468, 1).b(this.this$0.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.5
 * JD-Core Version:    0.7.0.1
 */