package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$5
  implements Runnable
{
  BaseChatPie$5(BaseChatPie paramBaseChatPie, boolean paramBoolean, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateSession_forwardType, postDelayed Run! needToBottom=");
      ((StringBuilder)localObject).append(this.a);
      QLog.i("forward", 1, ((StringBuilder)localObject).toString());
    }
    this.this$0.g(this.b);
    if (this.a) {
      BaseChatPie.c(this.this$0);
    }
    if (this.b.getBooleanExtra("isFromShare", false))
    {
      this.b.removeExtra("forward_type");
      this.b.removeExtra("isFromShare");
      String str = this.b.getStringExtra("leftBackText");
      if (str != null)
      {
        localObject = str;
        if (!"".equals(str)) {}
      }
      else
      {
        localObject = this.this$0.e.getString(2131887625);
      }
      if (QLog.isColorLevel())
      {
        str = this.this$0.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set left text from forward: ");
        localStringBuilder.append((String)localObject);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      this.this$0.s.setText((CharSequence)localObject);
      this.this$0.bf();
      if (this.this$0.p != null) {
        this.this$0.p.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.5
 * JD-Core Version:    0.7.0.1
 */