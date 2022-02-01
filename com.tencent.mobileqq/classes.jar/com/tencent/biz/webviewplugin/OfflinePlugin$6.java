package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class OfflinePlugin$6
  implements Runnable
{
  OfflinePlugin$6(OfflinePlugin paramOfflinePlugin, String paramString1, String paramString2, CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    int i = QbSdk.getTbsVersion(BaseApplication.getContext());
    Object localObject1 = "OfflinePluginQQ";
    if (i < 43700)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("current tbs version ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" doesn't support ServiceWorker! require >= ");
      ((StringBuilder)localObject1).append(43700);
      QLog.e("OfflinePluginQQ", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject4 = BaseApplication.getContext().getSharedPreferences("offline_sw_register", 4);
    String str1 = HtmlOffline.d(this.jdField_a_of_type_JavaLangString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append("_register_time");
    String str2 = ((StringBuilder)localObject2).toString();
    long l1 = ((SharedPreferences)localObject4).getLong(str2, -1L);
    if ((!"0".equals(this.b)) && (OfflinePlugin.a()))
    {
      QLog.i("OfflinePluginQQ", 1, String.format("now start registerServiceWorkerOffline, current tbs version: %d, url: %s", new Object[] { Integer.valueOf(i), Util.b(this.jdField_a_of_type_JavaLangString, new String[0]) }));
      localObject2 = ((SharedPreferences)localObject4).getString(str1, "");
      Object localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject3 = new HashSet(Arrays.asList(((String)localObject2).split(",")));
      } else {
        localObject3 = new HashSet();
      }
      if (this.this$0.a.size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "shouldInterceptRequest has new resource, need register SW again!");
        }
        ((Set)localObject3).addAll(this.this$0.a);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("merge new bid: ");
          ((StringBuilder)localObject1).append(TextUtils.join(",", (Iterable)localObject3));
          QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = "OfflinePluginQQ";
      }
      Object localObject5;
      Object localObject6;
      for (;;)
      {
        i = 1;
        break label525;
        localObject2 = localObject1;
        if (((Set)localObject3).size() <= 0) {
          break;
        }
        localObject5 = BaseApplication.getContext().getSharedPreferences("bid_update_success_time", 4);
        localObject6 = ((Set)localObject3).iterator();
        long l2;
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject6).hasNext()) {
            break label519;
          }
          localObject2 = (String)((Iterator)localObject6).next();
          l2 = ((SharedPreferences)localObject5).getLong((String)localObject2, -1L);
          if ((l1 == -1L) || (l2 > l1)) {
            break;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("bid ");
          ((StringBuilder)localObject5).append((String)localObject2);
          ((StringBuilder)localObject5).append(" has update, now need register again! updateTime: ");
          ((StringBuilder)localObject5).append(l2);
          ((StringBuilder)localObject5).append(", lastRegisterTime: ");
          ((StringBuilder)localObject5).append(l1);
          localObject2 = ((StringBuilder)localObject5).toString();
          QLog.i((String)localObject1, 2, (String)localObject2);
        }
      }
      label519:
      localObject1 = localObject2;
      i = 0;
      label525:
      if (i != 0)
      {
        localObject2 = new ArrayList();
        if (((Set)localObject3).size() > 0)
        {
          localObject5 = ((Set)localObject3).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (String)((Iterator)localObject5).next();
            localObject6 = this.this$0.b((String)localObject6);
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((List)localObject2).add(localObject6);
            }
          }
        }
        localObject4 = ((SharedPreferences)localObject4).edit();
        if (((List)localObject2).size() > 0)
        {
          ((SharedPreferences.Editor)localObject4).putString(str1, TextUtils.join(",", (Iterable)localObject3));
          ((SharedPreferences.Editor)localObject4).putLong(str2, System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject4).commit();
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("registerServiceWorkerOffline,, paths: ");
            ((StringBuilder)localObject3).append(TextUtils.join(",", (Iterable)localObject2));
            QLog.i((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension().registerServiceWorkerOffline(this.jdField_a_of_type_JavaLangString, (List)localObject2, true);
        }
        if ((this.this$0.a != null) && (this.this$0.a.size() > 0)) {
          this.this$0.a.clear();
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("It doesn't need update and register SW again! ");
        ((StringBuilder)localObject2).append(TextUtils.join(",", (Iterable)localObject3));
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (l1 != -1L)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unRegisterServiceWorker, url: ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject1).toString());
      }
      ((SharedPreferences)localObject4).edit().putLong(str2, -1L).commit();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension().unRegisterServiceWorker(this.jdField_a_of_type_JavaLangString, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.6
 * JD-Core Version:    0.7.0.1
 */