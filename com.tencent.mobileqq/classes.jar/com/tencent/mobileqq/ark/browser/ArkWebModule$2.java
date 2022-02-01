package com.tencent.mobileqq.ark.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.impl.webviewModule.AbsWVModule.WebViewRuntimeCompat;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class ArkWebModule$2
  implements View.OnClickListener
{
  ArkWebModule$2(ArkWebModule paramArkWebModule) {}
  
  public void onClick(View paramView)
  {
    ArkWebModule.a(this.a).put(ArkWebModule.a(this.a).a, Integer.valueOf(1));
    Activity localActivity = ArkWebModule.a(this.a).a();
    if (!PackageUtil.a(localActivity, ArkWebModule.a(this.a).c))
    {
      if (!TextUtils.isEmpty(ArkWebModule.a(this.a).g))
      {
        Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", ArkWebModule.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        localActivity.startActivity(localIntent);
      }
      DoraemonUtil.a(ArkWebModule.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      ArkWebModule.a(this.a).a();
      ArkWebModule.a(this.a).dismiss();
      ArkWebModule.a(this.a, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ArkWebModule.a(this.a, ArkWebModule.a(this.a).a, ArkWebModule.a(this.a).b, ArkWebModule.a(this.a).c, ArkWebModule.a(this.a).d, ArkWebModule.a(this.a).e, ArkWebModule.a(this.a).f);
      DoraemonUtil.a(ArkWebModule.a(this.a), APIParam.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkWebModule.2
 * JD-Core Version:    0.7.0.1
 */