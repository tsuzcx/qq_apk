package com.tencent.gamecenter.wadl.biz.jsplugin;

import android.app.Activity;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class WadlWebViewJsPlugin$1
  implements Runnable
{
  WadlWebViewJsPlugin$1(WadlWebViewJsPlugin paramWadlWebViewJsPlugin, WadlParams paramWadlParams) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.d();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      try
      {
        DialogUtil.a(localActivity, 230, null, "主人的手机空间不足咯，继续下载可能导致本次下载出现异常哦~\n建议主人手动清理手机空间，帮助本次下载顺利完成。", HardCodeUtil.a(2131913791), HardCodeUtil.a(2131913790), new WadlWebViewJsPlugin.1.1(this), new WadlWebViewJsPlugin.1.2(this)).show();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("Wadl_WadlWebViewJsPlugin", 1, "showDialog exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */