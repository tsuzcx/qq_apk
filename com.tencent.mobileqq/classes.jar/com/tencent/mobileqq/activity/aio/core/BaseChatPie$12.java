package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$12
  implements Runnable
{
  BaseChatPie$12(BaseChatPie paramBaseChatPie, boolean paramBoolean, Intent paramIntent1, Intent paramIntent2) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("forward", 1, "updateSession_forwardType, postDelayed Run! needToBottom=" + this.val$needToBottom);
    }
    this.this$0.handleForwardData(this.val$fIntent);
    if (this.val$needToBottom) {
      this.this$0.jumpToBottom();
    }
    if (this.val$intent.getBooleanExtra("isFromShare", false))
    {
      this.val$intent.removeExtra("forward_type");
      this.val$intent.removeExtra("isFromShare");
      String str2 = this.val$intent.getStringExtra("leftBackText");
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = this.this$0.mContext.getString(2131690599);
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.tag, 2, "set left text from forward: " + str1);
      }
      this.this$0.mTitleBtnLeft.setText(str1);
      this.this$0.adjustTitleDimension();
      if (this.this$0.mCustomTitleView != null) {
        this.this$0.mCustomTitleView.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.12
 * JD-Core Version:    0.7.0.1
 */