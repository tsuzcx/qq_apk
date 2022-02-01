package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class OfflinePlugin$7
  implements View.OnClickListener
{
  OfflinePlugin$7(OfflinePlugin paramOfflinePlugin) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.a.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(OfflinePlugin.a(this.a))))
      {
        OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.a));
        if (localOfflineUpdateStatus != null) {
          if (localOfflineUpdateStatus.b() == 3)
          {
            localOfflineUpdateStatus.a();
            this.a.b();
            localOfflineUpdateStatus.a(4);
            if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            }
            OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.remove(OfflinePlugin.a(this.a));
          }
          else if (localOfflineUpdateStatus.b() == 0)
          {
            HtmlOffline.a(localActivity.getApplicationContext(), OfflinePlugin.a(this.a), localOfflineUpdateStatus.f, localOfflineUpdateStatus.a, localOfflineUpdateStatus);
            localOfflineUpdateStatus.a(1);
            if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
            }
            this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.7
 * JD-Core Version:    0.7.0.1
 */