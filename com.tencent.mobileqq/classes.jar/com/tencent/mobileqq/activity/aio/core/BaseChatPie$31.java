package com.tencent.mobileqq.activity.aio.core;

import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class BaseChatPie$31
  implements Runnable
{
  BaseChatPie$31(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.this$0.mTitleText.setText(this.this$0.sessionInfo.curFriendNick);
    if (AppSetting.c)
    {
      String str = this.this$0.mTitleText.getText().toString();
      this.this$0.mTitleText.setContentDescription(str);
      this.this$0.getActivity().setTitle(this.this$0.mTitleText.getText());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.31
 * JD-Core Version:    0.7.0.1
 */