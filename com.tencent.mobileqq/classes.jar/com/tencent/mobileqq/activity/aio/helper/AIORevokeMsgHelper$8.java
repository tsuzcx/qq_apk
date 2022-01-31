package com.tencent.mobileqq.activity.aio.helper;

import aezb;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import bepp;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class AIORevokeMsgHelper$8
  implements Runnable
{
  public AIORevokeMsgHelper$8(aezb paramaezb, int paramInt) {}
  
  public void run()
  {
    if (this.a > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIORevokeMsgHelper", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.a), ", type: ", Integer.valueOf(aezb.a(this.this$0).a) });
      }
      QQToast.a(aezb.a(this.this$0), aezb.a(this.this$0).getString(2131694569), 0).b(aezb.a(this.this$0).getTitleBarHeight());
    }
    if ((this.a == 0) && (BaseChatItemLayout.a)) {
      aezb.a(this.this$0).a(false, null, false);
    }
    if (aezb.a(this.this$0).c != null) {
      aezb.a(this.this$0).c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.8
 * JD-Core Version:    0.7.0.1
 */