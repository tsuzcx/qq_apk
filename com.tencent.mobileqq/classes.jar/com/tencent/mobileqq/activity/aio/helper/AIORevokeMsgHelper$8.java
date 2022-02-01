package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AIORevokeMsgHelper$8
  implements Runnable
{
  AIORevokeMsgHelper$8(AIORevokeMsgHelper paramAIORevokeMsgHelper, int paramInt) {}
  
  public void run()
  {
    if (this.a > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.a), ", type: ", Integer.valueOf(AIORevokeMsgHelper.c(this.this$0).a) });
      }
      QQToast.makeText(AIORevokeMsgHelper.f(this.this$0), AIORevokeMsgHelper.f(this.this$0).getString(2131891949), 0).show(AIORevokeMsgHelper.e(this.this$0).getTitleBarHeight());
    }
    if ((this.a == 0) && (BaseChatItemLayout.ad)) {
      AIORevokeMsgHelper.d(this.this$0).a(false, null, false);
    }
    if (AIORevokeMsgHelper.d(this.this$0).ao != null) {
      AIORevokeMsgHelper.d(this.this$0).ao.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8
 * JD-Core Version:    0.7.0.1
 */