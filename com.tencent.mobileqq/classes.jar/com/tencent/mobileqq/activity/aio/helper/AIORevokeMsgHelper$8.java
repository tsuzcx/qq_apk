package com.tencent.mobileqq.activity.aio.helper;

import agtj;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import bjbs;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class AIORevokeMsgHelper$8
  implements Runnable
{
  public AIORevokeMsgHelper$8(agtj paramagtj, int paramInt) {}
  
  public void run()
  {
    if (this.a > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.a), ", type: ", Integer.valueOf(agtj.a(this.this$0).a) });
      }
      QQToast.a(agtj.a(this.this$0), agtj.a(this.this$0).getString(2131693854), 0).b(agtj.a(this.this$0).getTitleBarHeight());
    }
    if ((this.a == 0) && (BaseChatItemLayout.a)) {
      agtj.a(this.this$0).a(false, null, false);
    }
    if (agtj.a(this.this$0).c != null) {
      agtj.a(this.this$0).c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8
 * JD-Core Version:    0.7.0.1
 */