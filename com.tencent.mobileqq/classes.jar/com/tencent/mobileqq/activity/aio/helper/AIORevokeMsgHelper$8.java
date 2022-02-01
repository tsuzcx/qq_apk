package com.tencent.mobileqq.activity.aio.helper;

import afpd;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import bhht;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class AIORevokeMsgHelper$8
  implements Runnable
{
  public AIORevokeMsgHelper$8(afpd paramafpd, int paramInt) {}
  
  public void run()
  {
    if (this.a > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.a), ", type: ", Integer.valueOf(afpd.a(this.this$0).curType) });
      }
      QQToast.a(afpd.a(this.this$0), afpd.a(this.this$0).getString(2131693953), 0).b(afpd.a(this.this$0).getTitleBarHeight());
    }
    if ((this.a == 0) && (BaseChatItemLayout.a)) {
      afpd.a(this.this$0).setLeftCheckBoxVisible(false, null, false);
    }
    if (afpd.a(this.this$0).mProgressDialog != null) {
      afpd.a(this.this$0).mProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8
 * JD-Core Version:    0.7.0.1
 */