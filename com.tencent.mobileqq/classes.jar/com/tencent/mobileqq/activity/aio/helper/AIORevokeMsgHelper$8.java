package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.a), ", type: ", Integer.valueOf(AIORevokeMsgHelper.a(this.this$0).a) });
      }
      QQToast.a(AIORevokeMsgHelper.a(this.this$0), AIORevokeMsgHelper.a(this.this$0).getString(2131694346), 0).b(AIORevokeMsgHelper.a(this.this$0).getTitleBarHeight());
    }
    if ((this.a == 0) && (BaseChatItemLayout.a)) {
      AIORevokeMsgHelper.a(this.this$0).a(false, null, false);
    }
    if (AIORevokeMsgHelper.a(this.this$0).c != null) {
      AIORevokeMsgHelper.a(this.this$0).c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8
 * JD-Core Version:    0.7.0.1
 */