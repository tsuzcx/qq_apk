package com.tencent.mobileqq.activity.aio.core;

import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class BaseChatPie$14
  implements Runnable
{
  BaseChatPie$14(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.this$0.C.setText(this.this$0.ah.e);
    if (AppSetting.e)
    {
      String str = this.this$0.C.getText().toString();
      this.this$0.C.setContentDescription(str);
      this.this$0.aX().setTitle(this.this$0.C.getText());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.14
 * JD-Core Version:    0.7.0.1
 */