package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TroopReportor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class QRDisplayActivity$15$2
  implements Runnable
{
  QRDisplayActivity$15$2(QRDisplayActivity.15 param15, String paramString) {}
  
  public void run()
  {
    if (this.b.this$0.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.a))
    {
      if (this.b.this$0.t == 2) {
        TroopReportor.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.b.this$0.n, String.valueOf(this.b.this$0.q), "1" });
      }
      QRUtils.a(1, 2131894251);
      return;
    }
    String str;
    if (this.b.this$0.t == 2)
    {
      if (this.b.this$0.i) {
        str = this.b.this$0.getString(2131889085, new Object[] { this.b.this$0.l });
      } else {
        str = this.b.this$0.getString(2131889084, new Object[] { this.b.this$0.l, this.b.this$0.n });
      }
    }
    else
    {
      if (this.b.this$0.t != 5) {
        break label247;
      }
      str = this.b.this$0.getString(2131889083, new Object[] { this.b.this$0.l });
    }
    for (;;)
    {
      break;
      label247:
      if (this.b.this$0.t == 11) {
        str = this.b.this$0.getString(2131890650);
      } else {
        str = this.b.this$0.getString(2131889087);
      }
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.b.this$0.app.getAccount();
    localUserInfo.nickname = ContactUtils.f(this.b.this$0.app, this.b.this$0.app.getAccount());
    QZoneHelper.forwardToPublishMood(this.b.this$0, localUserInfo, this.a, this.b.this$0.getString(2131889086), str, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.15.2
 * JD-Core Version:    0.7.0.1
 */