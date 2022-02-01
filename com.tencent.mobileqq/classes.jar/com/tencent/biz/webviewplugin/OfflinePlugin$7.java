package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class OfflinePlugin$7
  implements View.OnClickListener
{
  OfflinePlugin$7(OfflinePlugin paramOfflinePlugin) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.a.mRuntime.d();
    if ((localActivity != null) && (OfflinePlugin.e != null) && (!TextUtils.isEmpty(OfflinePlugin.a(this.a))))
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.e.get(OfflinePlugin.a(this.a));
      if (localOfflineUpdateStatus != null) {
        if (localOfflineUpdateStatus.c() == 3)
        {
          localOfflineUpdateStatus.a();
          this.a.c();
          localOfflineUpdateStatus.a(4);
          if (this.a.a != null) {
            this.a.a.setVisibility(8);
          }
          OfflinePlugin.e.remove(OfflinePlugin.a(this.a));
        }
        else if (localOfflineUpdateStatus.c() == 0)
        {
          HtmlOffline.a(localActivity.getApplicationContext(), OfflinePlugin.a(this.a), localOfflineUpdateStatus.f, localOfflineUpdateStatus.g, localOfflineUpdateStatus);
          localOfflineUpdateStatus.a(1);
          if (this.a.c != null) {
            this.a.c.setCompoundDrawables(null, null, null, null);
          }
          this.a.u.postDelayed(this.a.B, 2000L);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.7
 * JD-Core Version:    0.7.0.1
 */