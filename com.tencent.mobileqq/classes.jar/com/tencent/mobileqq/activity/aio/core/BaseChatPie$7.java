package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$7
  implements Runnable
{
  BaseChatPie$7(BaseChatPie paramBaseChatPie, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = this.this$0.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set left text from update unread: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", isThemeDefault: ");
      localStringBuilder.append(this.this$0.aL);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.this$0.aL)
    {
      this.this$0.x.setText(String.valueOf(this.b));
      if (TextUtils.isEmpty(this.b)) {
        this.this$0.x.setVisibility(8);
      } else {
        this.this$0.x.setVisibility(0);
      }
    }
    else
    {
      this.this$0.t.setText(this.b);
      if (this.this$0.p != null) {
        this.this$0.p.e();
      }
    }
    this.this$0.bf();
    if (ChatActivityConstants.b) {
      this.this$0.p.setLeftContentDescription(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.7
 * JD-Core Version:    0.7.0.1
 */