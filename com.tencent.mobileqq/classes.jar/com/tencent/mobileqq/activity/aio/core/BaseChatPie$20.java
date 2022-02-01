package com.tencent.mobileqq.activity.aio.core;

import acvu;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$20
  implements Runnable
{
  BaseChatPie$20(BaseChatPie paramBaseChatPie, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.tag, 2, "set left text from update unread: " + this.val$unRead);
    }
    if (this.this$0.isThemeDefault)
    {
      this.this$0.mDefautlBtnLeft.setText(String.valueOf(this.val$unreadCount));
      if (TextUtils.isEmpty(this.val$unreadCount)) {
        this.this$0.mDefautlBtnLeft.setVisibility(8);
      }
    }
    for (;;)
    {
      this.this$0.adjustTitleDimension();
      if (acvu.a) {
        this.this$0.mCustomTitleView.setLeftContentDescription(this.val$contentDescription);
      }
      return;
      this.this$0.mDefautlBtnLeft.setVisibility(0);
      continue;
      this.this$0.mTitleBubbleLeft.setText(this.val$unreadCount);
      if (this.this$0.mCustomTitleView != null) {
        this.this$0.mCustomTitleView.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.20
 * JD-Core Version:    0.7.0.1
 */