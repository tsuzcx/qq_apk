package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class OfflinePlugin$2
  extends Handler
{
  OfflinePlugin$2(OfflinePlugin paramOfflinePlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramMessage.what == 121) {
      for (;;)
      {
        try
        {
          localObject1 = (String)((Object[])(Object[])paramMessage.obj)[1];
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("retcode", 0);
          ((JSONObject)localObject4).put("data", Util.a((String)localObject1));
          this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject4).toString() });
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject4;
          Object localObject2;
          Object localObject3;
          StringBuilder localStringBuilder;
          continue;
        }
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("retcode", -1);
          ((JSONObject)localObject1).put("msg", "error");
          this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("OfflinePlugin, batchCheckUpdate, JSONException :");
            ((StringBuilder)localObject4).append(localJSONException);
            QLog.d("OfflinePluginQQ", 2, ((StringBuilder)localObject4).toString());
          }
        }
      }
    }
    if (paramMessage.arg1 == 1)
    {
      this.a.b = paramMessage.arg2;
      localObject2 = (String)paramMessage.obj;
      localObject4 = this.a.mRuntime.a();
      if (localObject4 == null) {
        return;
      }
      if (this.a.jdField_a_of_type_Long == -1L) {
        this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      ((CustomWebView)localObject4).loadUrlOriginal((String)localObject2);
      ((CustomWebView)localObject4).requestFocus();
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("mCheckupHandler loadUrl start \n");
        ((StringBuilder)localObject4).append((String)localObject2);
        QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject4).toString());
      }
      this.a.a((String)localObject2);
    }
    else if (paramMessage.arg1 == 2)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("OfflinePluginQQ", 4, "checkOfflineUpBack refresh current url");
      }
      this.a.c();
    }
    else if (paramMessage.arg1 == 3)
    {
      try
      {
        localObject2 = (JSONObject)paramMessage.obj;
        this.a.a((JSONObject)localObject2);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    localObject3 = this.a.mRuntime.a();
    localObject4 = this.a.mRuntime.a(this.a.mRuntime.a());
    if (localObject4 != null)
    {
      if (!(localObject4 instanceof WebUiUtils.QQBrowserBaseActivityInterface)) {
        return;
      }
      if (paramMessage.arg1 == 4)
      {
        if ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(OfflinePlugin.a(this.a))))
        {
          localObject3 = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.a));
          if (this.a.jdField_a_of_type_AndroidWidgetProgressBar != null) {
            this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg2);
          }
          if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localObject4 = this.a.jdField_a_of_type_AndroidWidgetTextView;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(((OfflineUpdateStatus)localObject3).e);
            localStringBuilder.append(paramMessage.arg2);
            localStringBuilder.append("%");
            ((TextView)localObject4).setText(localStringBuilder.toString());
          }
        }
      }
      else if ((paramMessage.arg1 == 5) && (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(OfflinePlugin.a(this.a))))
      {
        localObject4 = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.a));
        if (localObject4 != null) {
          if (paramMessage.arg2 == 0)
          {
            ((OfflineUpdateStatus)localObject4).a(3);
            if (localObject3 != null)
            {
              paramMessage = ((Activity)localObject3).getResources().getDrawable(2130839376);
              paramMessage.setBounds(0, 0, 40, 40);
              if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
                this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessage, null, null, null);
              }
              if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
                this.a.jdField_a_of_type_AndroidWidgetTextView.setText(((OfflineUpdateStatus)localObject4).d);
              }
              if (this.a.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              }
              if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
                this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              }
            }
          }
          else
          {
            if ((paramMessage.arg2 != 5) && (paramMessage.arg2 != 7))
            {
              QQToastUtil.a(1, 2131696089);
              if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
                this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              }
              ((OfflineUpdateStatus)localObject4).a(4);
              return;
            }
            if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            }
            ((OfflineUpdateStatus)localObject4).a(4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.2
 * JD-Core Version:    0.7.0.1
 */