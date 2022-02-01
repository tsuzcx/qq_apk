package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.ZanDoubleDialog.BtnClickListener;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class VisitorsActivity$4
  implements ZanDoubleDialog.BtnClickListener
{
  VisitorsActivity$4(VisitorsActivity paramVisitorsActivity, String paramString) {}
  
  public void onLeftClick()
  {
    VasWebviewUtil.a(this.b.app.getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", this.a, "");
    Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
    localIntent.putExtra("fragmentStyle", 3);
    localIntent.putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.b.startActivity(localIntent);
  }
  
  public void onRightClick()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "ZanDoubleDialog: onRightClick: ");
    }
    VasWebviewUtil.a(this.b.app.getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", this.a, "");
    VasH5PayUtil.a(this.b, "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
    VisitorsActivity.a(this.b).set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.4
 * JD-Core Version:    0.7.0.1
 */