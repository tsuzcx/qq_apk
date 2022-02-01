package com.tencent.mobileqq.ark.browser;

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
    ArkWebModule.c(this.a).put(ArkWebModule.b(this.a).a, Integer.valueOf(1));
    Object localObject = ArkWebModule.d(this.a).c();
    if (!PackageUtil.a((Context)localObject, ArkWebModule.b(this.a).c))
    {
      if (!TextUtils.isEmpty(ArkWebModule.b(this.a).g))
      {
        Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
        localIntent.putExtra("url", ArkWebModule.b(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        ((Context)localObject).startActivity(localIntent);
      }
      DoraemonUtil.a(ArkWebModule.e(this.a), -4, "need to download");
    }
    else
    {
      localObject = this.a;
      ArkWebModule.a((ArkWebModule)localObject, ArkWebModule.b((ArkWebModule)localObject).a, ArkWebModule.b(this.a).b, ArkWebModule.b(this.a).c, ArkWebModule.b(this.a).d, ArkWebModule.b(this.a).e, ArkWebModule.b(this.a).f);
      DoraemonUtil.a(ArkWebModule.e(this.a), APIParam.a);
    }
    ArkWebModule.b(this.a).a();
    ArkWebModule.a(this.a).dismiss();
    ArkWebModule.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkWebModule.2
 * JD-Core Version:    0.7.0.1
 */