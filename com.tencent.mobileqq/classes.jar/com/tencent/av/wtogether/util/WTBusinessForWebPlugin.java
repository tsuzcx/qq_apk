package com.tencent.av.wtogether.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WTBusinessForWebPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  public static final String a = WTBusinessForWebPlugin.class.getSimpleName();
  
  public WTBusinessForWebPlugin()
  {
    this.mPluginNameSpace = "c2c_together_business";
  }
  
  private void a()
  {
    Object localObject = this.mRuntime.a().getIntent();
    int i = ((Intent)localObject).getIntExtra("key_from_type", 0);
    int j = ((Intent)localObject).getIntExtra("watch_together_uinType", -1);
    localObject = ((Intent)localObject).getStringExtra("watch_together_uin");
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleLaunchQFileChooser, fromType[" + i + "], uinType[" + j + "], uin[" + (String)localObject + "]");
    }
    AVRecentFileSelectFragment.a(this.mRuntime.a(), i, j, (String)localObject, SwiftWebViewUtils.a(110, WebViewUtil.a(this)));
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i = 0;
    Intent localIntent = this.mRuntime.a().getIntent();
    ChooseFileInfo localChooseFileInfo = new ChooseFileInfo(4);
    localChooseFileInfo.a = localIntent.getIntExtra("key_from_type", 0);
    localChooseFileInfo.g = paramString1;
    if ("1".equalsIgnoreCase(paramString2)) {
      i = 1;
    }
    localChooseFileInfo.d = i;
    localIntent.putExtra("ChooseFileInfo", localChooseFileInfo);
    this.mRuntime.a().setResult(4660, localIntent);
    this.mRuntime.a().finish();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleStartWatchTogether, chooseFileInfo[" + localChooseFileInfo + "]");
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    ChooseFileInfo localChooseFileInfo = new ChooseFileInfo(4);
    localChooseFileInfo.a = 4;
    localChooseFileInfo.g = paramString1;
    if ("1".equalsIgnoreCase(paramString2)) {}
    for (int i = 1;; i = 0)
    {
      localChooseFileInfo.d = i;
      paramString1 = new Intent("com.tencent.WT.WT_OUT_OF_AIO");
      paramString1.putExtra("ChooseFileInfo", localChooseFileInfo);
      paramString1.putExtra("MicroAppType", paramInt);
      this.mRuntime.a().getApplicationContext().sendBroadcast(paramString1, "com.tencent.msg.permission.pushnotify");
      return;
    }
  }
  
  private boolean a()
  {
    return CallStatusClient.a().a();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder("Call WTBusinessForWebPlugin handleJsRequest, url=").append(paramString1).append(" pkgName=").append(paramString2).append(" method=").append(paramString3);
      QLog.d(a, 2, paramJsBridgeListener.toString());
    }
    if (this.mPluginNameSpace.equalsIgnoreCase(paramString2))
    {
      if ("push_to_local_file_controller".equalsIgnoreCase(paramString3)) {
        a();
      }
      for (;;)
      {
        return true;
        if ("select_file_info".equalsIgnoreCase(paramString3)) {
          for (;;)
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("resourceId");
              paramString2 = paramJsBridgeListener.optString("isPay");
              int i = paramJsBridgeListener.optInt("from");
              if (!TextUtils.isEmpty(paramString1))
              {
                if (i == 2) {
                  a(paramString1, paramString2, i);
                }
              }
              else
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(a, 2, "handleJsRequest " + paramString3 + ", resourceId[" + paramString1 + "], isPay[" + paramString2 + "]");
                return true;
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              QLog.d(a, 1, "handleJsRequest " + paramString3 + " exception[" + paramJsBridgeListener.getMessage() + "]");
              return true;
            }
            a(paramString1, paramString2);
          }
        }
        if ("fetch_qav_status".equalsIgnoreCase(paramString3)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            boolean bool = a();
            callJs(paramJsBridgeListener, new String[] { "{\"isInCall\":" + bool + "}" });
            if (QLog.isColorLevel())
            {
              QLog.d(a, 2, "handleJsRequest " + paramString3 + ", isInCall[" + bool + "]");
              return true;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            QLog.d(a, 1, "handleJsRequest " + paramString3 + " exception[" + paramJsBridgeListener.getMessage() + "]");
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (paramString1.contains("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2&inviteeUin")) || ((paramString1.contains("https://film.qq.com/h5/qq-together/detail.html")) && (paramString1.contains("aioId")));
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramInt == -1) && (paramByte == 110) && (paramIntent != null))
    {
      this.mRuntime.a().setResult(4660, paramIntent);
      this.mRuntime.a().finish();
    }
  }
  
  public void onCreate()
  {
    String str = this.mRuntime.a().getIntent().getStringExtra("url");
    if ((str != null) && ((str.contains("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2&inviteeUin")) || ((str.contains("https://film.qq.com/h5/qq-together/detail.html")) && (str.contains("aioId")))))
    {
      CallStatusClient.a().a(this.mRuntime.a());
      CallStatusClient.a().b();
    }
  }
  
  public void onDestroy()
  {
    String str = this.mRuntime.a().getIntent().getStringExtra("url");
    if ((str != null) && ((str.contains("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2&inviteeUin")) || ((str.contains("https://film.qq.com/h5/qq-together/detail.html")) && (str.contains("aioId")))))
    {
      CallStatusClient.a().c();
      CallStatusClient.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTBusinessForWebPlugin
 * JD-Core Version:    0.7.0.1
 */