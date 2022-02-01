package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
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
    if (i < 43700) {
      QLog.e("OfflinePluginQQ", 1, "current tbs version " + i + " doesn't support ServiceWorker! require >= " + 43700);
    }
    Object localObject2;
    String str1;
    String str2;
    long l1;
    do
    {
      return;
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("offline_sw_register", 4);
      str1 = HtmlOffline.d(this.jdField_a_of_type_JavaLangString);
      str2 = str1 + "_register_time";
      l1 = ((SharedPreferences)localObject2).getLong(str2, -1L);
      if ((!"0".equals(this.b)) && (OfflinePlugin.a())) {
        break;
      }
    } while (l1 == -1L);
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "unRegisterServiceWorker, url: " + this.jdField_a_of_type_JavaLangString);
    }
    ((SharedPreferences)localObject2).edit().putLong(str2, -1L).commit();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension().unRegisterServiceWorker(this.jdField_a_of_type_JavaLangString, true);
    return;
    QLog.i("OfflinePluginQQ", 1, String.format("now start registerServiceWorkerOffline, current tbs version: %d, url: %s", new Object[] { Integer.valueOf(i), Util.b(this.jdField_a_of_type_JavaLangString, new String[0]) }));
    Object localObject1 = ((SharedPreferences)localObject2).getString(str1, "");
    int j;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new HashSet(Arrays.asList(((String)localObject1).split(",")));
      j = 0;
      if (this.this$0.a.size() <= 0) {
        break label466;
      }
      if (QLog.isColorLevel()) {
        QLog.i("OfflinePluginQQ", 2, "shouldInterceptRequest has new resource, need register SW again!");
      }
      ((Set)localObject1).addAll(this.this$0.a);
      j = 1;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("OfflinePluginQQ", 2, "merge new bid: " + TextUtils.join(",", (Iterable)localObject1));
        i = j;
      }
    }
    label796:
    for (;;)
    {
      label368:
      if (i != 0)
      {
        Object localObject3 = new ArrayList();
        if (((Set)localObject1).size() > 0)
        {
          Iterator localIterator = ((Set)localObject1).iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              String str3 = (String)localIterator.next();
              str3 = this.this$0.b(str3);
              if (!TextUtils.isEmpty(str3))
              {
                ((List)localObject3).add(str3);
                continue;
                localObject1 = new HashSet();
                break;
                i = j;
                if (((Set)localObject1).size() <= 0) {
                  break label796;
                }
                localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("bid_update_success_time", 4);
                localIterator = ((Set)localObject1).iterator();
                long l2;
                do
                {
                  i = j;
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  str3 = (String)localIterator.next();
                  l2 = ((SharedPreferences)localObject3).getLong(str3, -1L);
                } while ((l1 != -1L) && (l2 <= l1));
                i = 1;
                if (!QLog.isColorLevel()) {
                  break label796;
                }
                QLog.i("OfflinePluginQQ", 2, "bid " + str3 + " has update, now need register again! updateTime: " + l2 + ", lastRegisterTime: " + l1);
                i = 1;
                break label368;
              }
            }
          }
        }
        localObject2 = ((SharedPreferences)localObject2).edit();
        if (((List)localObject3).size() > 0)
        {
          ((SharedPreferences.Editor)localObject2).putString(str1, TextUtils.join(",", (Iterable)localObject1));
          ((SharedPreferences.Editor)localObject2).putLong(str2, System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject2).commit();
          if (QLog.isColorLevel()) {
            QLog.i("OfflinePluginQQ", 2, "registerServiceWorkerOffline,, paths: " + TextUtils.join(",", (Iterable)localObject3));
          }
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension().registerServiceWorkerOffline(this.jdField_a_of_type_JavaLangString, (List)localObject3, true);
        }
        if ((this.this$0.a == null) || (this.this$0.a.size() <= 0)) {
          break;
        }
        this.this$0.a.clear();
        return;
      }
      label466:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("OfflinePluginQQ", 2, "It doesn't need update and register SW again! " + TextUtils.join(",", (Iterable)localObject1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.6
 * JD-Core Version:    0.7.0.1
 */