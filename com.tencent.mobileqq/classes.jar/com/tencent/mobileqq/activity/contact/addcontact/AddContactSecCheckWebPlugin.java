package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AddContactSecCheckWebPlugin
  extends VasWebviewJsPlugin
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  
  public AddContactSecCheckWebPlugin()
  {
    this.mPluginNameSpace = "addContact_SecCheck";
  }
  
  private int a(Activity paramActivity, int paramInt)
  {
    WebViewProvider localWebViewProvider = this.mRuntime.a();
    int i;
    if ((paramActivity instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)paramActivity).switchRequestCode(this, (byte)paramInt);
    }
    do
    {
      return i;
      i = paramInt;
    } while (localWebViewProvider == null);
    return localWebViewProvider.switchRequestCode(this, (byte)paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactSecCheckWebPlugin", 2, "openSecCheckWeb, requestCode=" + paramInt + ", url=" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    paramString2.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString2.putExtra("url", paramString1);
    try
    {
      ((Activity)paramContext).startActivityForResult(paramString2, paramInt);
      return;
    }
    catch (SecurityException paramQQAppInterface) {}
  }
  
  protected void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("ticket");
      if (this.mRuntime.a() == null) {
        return;
      }
      if (this.mRuntime.a() != null)
      {
        Object localObject = this.mRuntime.a();
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("ticket", paramString);
          ((Activity)localObject).setResult(-1, localIntent);
          if (!((Activity)localObject).isFinishing()) {
            ((Activity)localObject).finish();
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("setTicket, ticket_len = ");
            if (TextUtils.isEmpty(paramString)) {}
            for (int i = 0;; i = paramString.length())
            {
              QLog.d("AddContactSecCheckWebPlugin", 2, i);
              return;
            }
          }
        }
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
      this.jdField_a_of_type_Int = paramString.optInt("targetAct", 0);
      this.jdField_a_of_type_JavaLangString = paramString.optString("callBackName", "");
      if (QLog.isColorLevel()) {
        QLog.d("AddContactSecCheckWebPlugin", 2, "launchAct, mTargetAct=" + this.jdField_a_of_type_Int + ", mCallBackName=" + this.jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_Int <= 0) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("AddContactSecCheckWebPlugin", 2, "launchAct, param is illeagal");
        return;
      }
      if ((this.mRuntime == null) || (this.mRuntime.a() == null))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("AddContactSecCheckWebPlugin", 2, "launchAct, runtime is null");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("AddContactSecCheckWebPlugin", 2, "launchAct,", paramString);
      return;
    }
    paramString = this.mRuntime.a();
    Intent localIntent;
    if (this.jdField_a_of_type_Int == 1)
    {
      localIntent = new Intent(paramString, BindNumberActivity.class);
      localIntent.putExtra("kSrouce", 21);
      localIntent.putExtra("cmd_param_is_from_uni", true);
      paramString.startActivityForResult(localIntent, a(paramString, 1));
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      localIntent = new Intent(paramString, PhoneUnityBindInfoActivity.class);
      localIntent.putExtra("kSrouce", 21);
      localIntent.putExtra("kIsWeb", true);
      paramString.startActivityForResult(localIntent, a(paramString, 2));
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("addContact_SecCheck".equals(paramString2))
    {
      if ((!"setTicket".equals(paramString3)) || (paramVarArgs.length != 1)) {
        break label36;
      }
      a(paramVarArgs[0]);
    }
    label36:
    while ((!"launchAct".equals(paramString3)) || (paramVarArgs.length != 1)) {
      return false;
    }
    b(paramVarArgs[0]);
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AddContactSecCheckWebPlugin", 2, "doOnActivityResult requestCode = " + paramByte + " resultCode = " + paramInt);
    }
    if (this.mRuntime.a() == null) {
      return;
    }
    if (paramInt == -1) {
      i = 1;
    }
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("targetAct", paramByte);
      paramIntent.put("status", i);
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramIntent.toString() });
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e("AddContactSecCheckWebPlugin", 1, "doOnActivityResult exception:", paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactSecCheckWebPlugin
 * JD-Core Version:    0.7.0.1
 */