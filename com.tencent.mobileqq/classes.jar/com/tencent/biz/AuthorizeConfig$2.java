package com.tencent.biz;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import azqs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListRequset;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import myl;
import mym;
import mzx;
import ndd;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class AuthorizeConfig$2
  implements Runnable
{
  public AuthorizeConfig$2(myl parammyl, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {}
    String str3;
    try
    {
      Thread.sleep(5000L);
      str3 = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getString("qqVersion", null);
      localObject3 = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject3 == null) {
        break label350;
      }
      Object localObject1 = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getString("lastVersion", null);
      localObject4 = new mobileqq_mp.WebviewWhiteListRequset();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ("2013 8.3.5".equals(str3)))
      {
        ((mobileqq_mp.WebviewWhiteListRequset)localObject4).version.set((String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Local white list version=" + (String)localObject1);
        }
      }
      while (!QLog.isColorLevel())
      {
        ((mobileqq_mp.WebviewWhiteListRequset)localObject4).qqversion.set("8.3.5");
        ((mobileqq_mp.WebviewWhiteListRequset)localObject4).gziped.set(true);
        ((mobileqq_mp.WebviewWhiteListRequset)localObject4).implat.set(109);
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "send whitelist request， lastversion: " + ((mobileqq_mp.WebviewWhiteListRequset)localObject4).version.get() + ", qq version: " + ((mobileqq_mp.WebviewWhiteListRequset)localObject4).qqversion.get() + ", isGzip: " + ((mobileqq_mp.WebviewWhiteListRequset)localObject4).gziped.get());
        }
        localObject1 = new NewIntent(this.this$0.jdField_a_of_type_AndroidContentContext, mzx.class);
        ((NewIntent)localObject1).setWithouLogin(true);
        ((NewIntent)localObject1).putExtra("cmd", "JsApiSvr.webview.whitelist");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.WebviewWhiteListRequset)localObject4).toByteArray());
        ((NewIntent)localObject1).setObserver(new mym(this));
        ((AppRuntime)localObject3).startServlet((NewIntent)localObject1);
        return;
      }
      catch (Exception localException1)
      {
        String str1;
        QLog.d("AuthorizeConfig", 1, "toByteArray failed", localException1);
        this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        return;
      }
      localInterruptedException = localInterruptedException;
      this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      return;
    }
    if (TextUtils.isEmpty(localInterruptedException)) {}
    for (str1 = "Local white list may not exist";; str1 = "QQ version changed so ignore version of local white list")
    {
      QLog.d("AuthorizeConfig", 2, str1);
      break;
    }
    label350:
    Object localObject4 = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getString("lastMod", null);
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (localObject4 != null)
    {
      localObject2 = localObject3;
      if (((String)localObject4).length() > 0)
      {
        localObject2 = localObject3;
        if ("2013 8.3.5".equals(str3))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("If-Modified-Since", (String)localObject4);
        }
      }
    }
    localObject3 = Uri.parse("http://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json").getHost();
    localObject4 = MsfSdkUtils.insertMtype("qb_offline", "http://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json");
    int i;
    label654:
    do
    {
      for (;;)
      {
        try
        {
          localObject3 = ndd.a(this.this$0.jdField_a_of_type_AndroidContentContext, (String)localObject4, (String)localObject3, "GET", null, (Bundle)localObject2);
          if (localObject3 != null)
          {
            i = ((HttpResponse)localObject3).getStatusLine().getStatusCode();
            if (QLog.isColorLevel()) {
              QLog.d("AuthorizeConfig", 2, "status code: " + String.valueOf(i));
            }
            if (i != 200) {
              break;
            }
            localObject2 = ((HttpResponse)localObject3).getFirstHeader("Last-Modified");
            if (localObject2 != null) {
              break label654;
            }
            localObject2 = null;
            localObject3 = ndd.a((HttpResponse)localObject3);
            this.this$0.a((String)localObject3, (String)localObject2, "lastMod");
            azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_success", 1, 1, 0, "", "", "", "");
          }
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "update error: " + localException2);
          }
          this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 1, 1, 0, "", "", "", "");
          return;
        }
        String str2 = localException2.getValue();
      }
    } while (i != 304);
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("lastUpdate", System.currentTimeMillis()).commit();
    azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_not_modify", 1, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.2
 * JD-Core Version:    0.7.0.1
 */