package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class BaseChatPie$32
  implements Runnable
{
  BaseChatPie$32(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.this$0.e.setText(this.this$0.a.d);
    if (AppSetting.c)
    {
      String str = this.this$0.e.getText().toString();
      this.this$0.e.setContentDescription(str);
      this.this$0.a().setTitle(this.this$0.e.getText());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.32
 * JD-Core Version:    0.7.0.1
 */