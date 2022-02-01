package com.tencent.mobileqq.activity.contact.addcontact;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import org.json.JSONException;
import org.json.JSONObject;

public class InvitationWebViewPlugin
  extends WebViewPlugin
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener
{
  private ShareActionSheetBuilder a;
  private String b;
  private String c;
  private String d;
  
  public InvitationWebViewPlugin()
  {
    this.mPluginNameSpace = "newLogin";
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("METHOD_LOGIN_WITH_UIN_MASK success, jump to LoginActivity, enableLoginWithMask: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("uinMask: ");
    ((StringBuilder)localObject).append(paramString1);
    QLog.d("InvitationFriend", 1, ((StringBuilder)localObject).toString());
    ReportController.a(null, "dc00898", "", "", "0X800B337", "0X800B337", 0, 0, "", "", "", "");
    localObject = new Intent();
    if (paramBoolean)
    {
      ((Intent)localObject).putExtra("is_need_login_with_mask", true);
      ((Intent)localObject).putExtra("uinMask", paramString1);
      ((Intent)localObject).putExtra("uinEncrpyt", paramString2);
    }
    RouteUtils.a(this.mRuntime.d(), (Intent)localObject, "/base/login");
  }
  
  private boolean a()
  {
    return (this.mRuntime == null) || (this.mRuntime.d() == null);
  }
  
  private boolean a(String paramString)
  {
    QLog.d("InvitationFriend", 1, "handleUnbindAccount");
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle newLogin/unbindPhone jsonObj：");
      localStringBuilder.append(((JSONObject)localObject).toString());
      QLog.d("InvitationFriend", 2, localStringBuilder.toString());
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ((this.mRuntime != null) && (this.mRuntime.d() != null))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.InvitationWebViewPlugin.unbindAccount");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("key_login_unbind_phone_account_data", paramString);
        paramString = this.mRuntime.d();
        paramString.sendBroadcast((Intent)localObject);
        paramString.finish();
        return true;
      }
      QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_UNBIND_PHONE error: runtime or activity is null");
      return true;
    }
    catch (JSONException paramString) {}
    return false;
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    return (paramArrayOfString == null) || (paramArrayOfString.length == 0);
  }
  
  private void b()
  {
    QLog.d("InvitationFriend", 1, "handleRegWithNickAndPwd");
    ReportController.a(null, "dc00898", "", "", "0X800B338", "0X800B338", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_reg_from_phone_protect_h5", true);
    RouteUtils.a(this.mRuntime.d(), localIntent, "/base/safe/registerByNickAndPwd");
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
    localIntent.putExtra("sms_body", paramString);
    this.mRuntime.d().startActivity(localIntent);
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] c()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131894174);
    localActionSheetItem.icon = 2130839219;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = HardCodeUtil.a(2131903786);
    localActionSheetItem.icon = 2130839217;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131894163);
    localActionSheetItem.icon = 2130839217;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user denied = sms");
    QQToast.makeText(this.mRuntime.d(), HardCodeUtil.a(2131903784), 1).show();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user grant = sms");
    if (!TextUtils.isEmpty(this.d)) {
      b(this.d);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest url is: ");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(" method: ");
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener.append(" pkgName: ");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(" args: ");
      paramJsBridgeListener.append(paramVarArgs);
      QLog.i("InvitationFriend", 2, paramJsBridgeListener.toString());
    }
    if (!"newLogin".equals(paramString2)) {
      return false;
    }
    if ("shareSMS".equalsIgnoreCase(paramString3)) {
      if (paramVarArgs != null)
      {
        if (paramVarArgs.length != 1) {
          return false;
        }
        paramJsBridgeListener = paramVarArgs[0];
      }
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
      paramString1 = paramJsBridgeListener.getString("desc");
      this.c = paramJsBridgeListener.getString("callback");
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.mRuntime.d().checkSelfPermission("android.permission.SEND_SMS") != 0)
        {
          this.d = paramString1;
          ((AppActivity)this.mRuntime.d()).requestPermissions(this, 1, new String[] { "android.permission.SEND_SMS" });
          return true;
        }
        b(paramString1);
        return true;
      }
      b(paramString1);
      return true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      return false;
    }
    return false;
    if ("callShare".equalsIgnoreCase(paramString3)) {
      if (paramVarArgs != null)
      {
        if (paramVarArgs.length != 1) {
          return false;
        }
        paramJsBridgeListener = paramVarArgs[0];
      }
    }
    try
    {
      this.b = new JSONObject(paramJsBridgeListener).getString("callback");
      paramJsBridgeListener = this.mRuntime.d();
      if (this.a == null) {
        this.a = new ShareActionSheetBuilder(paramJsBridgeListener);
      }
      this.a.setActionSheetTitle(HardCodeUtil.a(2131903785));
      this.a.setActionSheetItems(c());
      this.a.setItemClickListener(this);
      this.a.setOnDismissListener(this);
      if (!paramJsBridgeListener.isFinishing()) {
        try
        {
          this.a.show();
          ReportController.b(null, "dc00898", "", "", "0X80096F9", "0X80096F9", 0, 0, "", "", "", "");
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("actionSheet.show exception=");
            paramString1.append(paramJsBridgeListener);
            QLog.d("InvitationFriend", 2, paramString1.toString());
          }
          return true;
        }
      }
      return false;
    }
    catch (JSONException paramJsBridgeListener) {}
    if ("AutoLogin".equalsIgnoreCase(paramString3)) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("InvitationFriend", 2, "handle newLogin/AutoLogin");
        }
        if ((this.mRuntime != null) && (this.mRuntime.d() != null))
        {
          paramJsBridgeListener = new Intent();
          paramJsBridgeListener.setAction("com.tencent.mobileqq.InvitationWebViewPlugin");
          paramJsBridgeListener.setPackage(MobileQQ.getContext().getPackageName());
          paramJsBridgeListener.putExtra("key_login_by_web", true);
          this.mRuntime.d().sendBroadcast(paramJsBridgeListener);
          return true;
        }
        QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_AUTO_LOGIN error: runtime or activity is null");
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramString1 = new StringBuilder();
        paramString1.append("PLUGIN_METHOD_AUTO_LOGIN error: ");
        paramString1.append(paramJsBridgeListener.getMessage());
        QLog.e("InvitationFriend", 1, paramString1.toString());
        return true;
      }
    }
    if ("loginWithUinMask".equalsIgnoreCase(paramString3))
    {
      QLog.d("InvitationFriend", 1, "handle newLogin/loginWithUinMask");
      if (a(paramVarArgs))
      {
        QLog.e("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK error: args invalid");
        return false;
      }
      if (a())
      {
        QLog.e("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK error: mRuntime invalid");
        return false;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("uinMask");
        paramString2 = paramJsBridgeListener.optString("uinEncrpyt");
        boolean bool = paramJsBridgeListener.optBoolean("enableLoginWithUinMask");
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
        {
          a(paramString1, paramString2, bool);
          return true;
        }
        QLog.e("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK error: params empty");
        return false;
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK error", paramJsBridgeListener);
        return false;
      }
    }
    if ("registerWithNickAndPwd".equalsIgnoreCase(paramString3))
    {
      QLog.d("InvitationFriend", 1, "handle newLogin/registerWithNickAndPwd");
      if (a())
      {
        QLog.e("InvitationFriend", 1, "METHOD_REG_WITH_NICK_PWD error: mRuntime invalid");
        return false;
      }
      b();
      return true;
    }
    if ("accountIdentityNotify".equals(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("InvitationFriend", 2, "handle newLogin/accountIdentityNotify");
      }
      if ((this.mRuntime != null) && (this.mRuntime.d() != null))
      {
        paramJsBridgeListener = new Intent();
        paramJsBridgeListener.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
        paramJsBridgeListener.setPackage(MobileQQ.getContext().getPackageName());
        this.mRuntime.d().sendBroadcast(paramJsBridgeListener);
        return true;
      }
      QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_AUTO_LOGIN error: runtime or activity is null");
      return true;
    }
    if ("unbindPhone".equalsIgnoreCase(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("InvitationFriend", 2, "handle newLogin/unbindPhone");
      }
      if (paramVarArgs != null)
      {
        if (paramVarArgs.length != 1) {
          return false;
        }
        if (a(paramVarArgs[0])) {}
      }
      else
      {
        return false;
      }
    }
    return true;
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    callJs(this.b, new String[] { String.valueOf(paramInt) });
    String str;
    if (paramInt == 0) {
      str = "0X80096FA";
    }
    for (;;)
    {
      break;
      if (paramInt == 1) {
        str = "0X80096FB";
      } else if (paramInt == 2) {
        str = "0X80096FC";
      } else if (paramInt == 3) {
        str = "0X80096FD";
      } else {
        str = "";
      }
    }
    if (!"".equals(str)) {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.InvitationWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */