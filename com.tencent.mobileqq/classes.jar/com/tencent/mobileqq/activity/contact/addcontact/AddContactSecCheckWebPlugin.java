package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class AddContactSecCheckWebPlugin
  extends VasWebviewJsPlugin
{
  private int a = 0;
  private String b;
  
  public AddContactSecCheckWebPlugin()
  {
    this.mPluginNameSpace = "addContact_SecCheck";
  }
  
  private int a(Activity paramActivity, int paramInt)
  {
    WebViewProvider localWebViewProvider = this.mRuntime.f();
    if ((paramActivity instanceof WebViewPluginContainer)) {
      return ((WebViewPluginContainer)paramActivity).switchRequestCode(this, (byte)paramInt);
    }
    int i = paramInt;
    if (localWebViewProvider != null) {
      i = localWebViewProvider.switchRequestCode(this, (byte)paramInt);
    }
    return i;
  }
  
  @Nullable
  private static Intent a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramContext = new Intent(paramContext, QQBrowserActivity.class);
    paramContext.putExtra("uin", paramAppInterface.getCurrentAccountUin());
    paramContext.putExtra("url", paramString);
    return paramContext;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openSecCheckWeb, requestCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString);
      QLog.d("AddContactSecCheckWebPlugin", 2, localStringBuilder.toString());
    }
    paramAppInterface = a(paramAppInterface, paramContext, paramString);
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      ((Activity)paramContext).startActivityForResult(paramAppInterface, paramInt);
      return;
    }
    catch (SecurityException paramAppInterface) {}
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, QBaseFragment paramQBaseFragment, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openSecCheckWeb, requestCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString);
      QLog.d("AddContactSecCheckWebPlugin", 2, localStringBuilder.toString());
    }
    paramAppInterface = a(paramAppInterface, paramContext, paramString);
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramQBaseFragment.startActivityForResult(paramAppInterface, paramInt);
      return;
    }
    catch (SecurityException paramAppInterface) {}
  }
  
  protected void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("ticket");
      if (this.mRuntime.a() == null) {
        return;
      }
      if (this.mRuntime.b() == null) {
        return;
      }
      Object localObject = this.mRuntime.d();
      if (localObject == null) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("ticket", paramString);
      ((Activity)localObject).setResult(-1, localIntent);
      if (!((Activity)localObject).isFinishing()) {
        ((Activity)localObject).finish();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setTicket, ticket_len = ");
        int i;
        if (TextUtils.isEmpty(paramString)) {
          i = 0;
        } else {
          i = paramString.length();
        }
        ((StringBuilder)localObject).append(i);
        QLog.d("AddContactSecCheckWebPlugin", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  protected void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optInt("targetAct", 0);
      this.b = paramString.optString("callBackName", "");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("launchAct, mTargetAct=");
        paramString.append(this.a);
        paramString.append(", mCallBackName=");
        paramString.append(this.b);
        QLog.d("AddContactSecCheckWebPlugin", 2, paramString.toString());
      }
      if ((this.a > 0) && (!TextUtils.isEmpty(this.b)))
      {
        if ((this.mRuntime != null) && (this.mRuntime.d() != null))
        {
          paramString = this.mRuntime.d();
          int i = this.a;
          Intent localIntent;
          if (i == 1)
          {
            localIntent = new Intent(paramString, BindNumberActivity.class);
            localIntent.putExtra("kSrouce", 21);
            localIntent.putExtra("cmd_param_is_from_uni", true);
            paramString.startActivityForResult(localIntent, a(paramString, 1));
            return;
          }
          if (this.a == 2)
          {
            localIntent = new Intent(paramString, PhoneUnityBindInfoActivity.class);
            localIntent.putExtra("kSrouce", 21);
            localIntent.putExtra("kIsWeb", true);
            paramString.startActivityForResult(localIntent, a(paramString, 2));
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("AddContactSecCheckWebPlugin", 2, "launchAct, runtime is null");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddContactSecCheckWebPlugin", 2, "launchAct, param is illeagal");
        }
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("AddContactSecCheckWebPlugin", 2, "launchAct,", paramString);
    }
    return;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("addContact_SecCheck".equals(paramString2))
    {
      if (("setTicket".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        a(paramVarArgs[0]);
        return false;
      }
      if (("launchAct".equals(paramString3)) && (paramVarArgs.length == 1)) {
        b(paramVarArgs[0]);
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("doOnActivityResult requestCode = ");
      paramIntent.append(paramByte);
      paramIntent.append(" resultCode = ");
      paramIntent.append(paramInt);
      QLog.d("AddContactSecCheckWebPlugin", 2, paramIntent.toString());
    }
    if (this.mRuntime.a() == null) {
      return;
    }
    if (paramInt == -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("targetAct", paramByte);
      paramIntent.put("status", paramInt);
      callJs(this.b, new String[] { paramIntent.toString() });
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e("AddContactSecCheckWebPlugin", 1, "doOnActivityResult exception:", paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactSecCheckWebPlugin
 * JD-Core Version:    0.7.0.1
 */