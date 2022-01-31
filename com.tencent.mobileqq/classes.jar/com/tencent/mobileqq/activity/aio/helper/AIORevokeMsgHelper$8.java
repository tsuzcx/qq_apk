package com.tencent.mobileqq.activity.aio.helper;

import afdq;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import bety;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class AIORevokeMsgHelper$8
  implements Runnable
{
  public AIORevokeMsgHelper$8(afdq paramafdq, int paramInt) {}
  
  public void run()
  {
    if (this.a > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.a), ", type: ", Integer.valueOf(afdq.a(this.this$0).a) });
      }
      QQToast.a(afdq.a(this.this$0), afdq.a(this.this$0).getString(2131694571), 0).b(afdq.a(this.this$0).getTitleBarHeight());
    }
    if ((this.a == 0) && (BaseChatItemLayout.a)) {
      afdq.a(this.this$0).a(false, null, false);
    }
    if (afdq.a(this.this$0).c != null) {
      afdq.a(this.this$0).c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8
 * JD-Core Version:    0.7.0.1
 */