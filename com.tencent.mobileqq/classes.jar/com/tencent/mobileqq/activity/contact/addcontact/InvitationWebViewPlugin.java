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
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public InvitationWebViewPlugin()
  {
    this.mPluginNameSpace = "newLogin";
  }
  
  private void a()
  {
    QLog.d("InvitationFriend", 1, "handleRegWithNickAndPwd");
    ReportController.a(null, "dc00898", "", "", "0X800B338", "0X800B338", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_reg_from_phone_protect_h5", true);
    RouteUtils.a(this.mRuntime.a(), localIntent, "/base/safe/registerByNickAndPwd");
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
    localIntent.putExtra("sms_body", paramString);
    this.mRuntime.a().startActivity(localIntent);
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
    RouteUtils.a(this.mRuntime.a(), (Intent)localObject, "/base/login");
  }
  
  private boolean a()
  {
    return (this.mRuntime == null) || (this.mRuntime.a() == null);
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    return (paramArrayOfString == null) || (paramArrayOfString.length == 0);
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131696420);
    localActionSheetItem.icon = 2130839071;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131696402);
    localActionSheetItem.icon = 2130839065;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = HardCodeUtil.a(2131705905);
    localActionSheetItem.icon = 2130839063;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131696391);
    localActionSheetItem.icon = 2130839063;
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
    QQToast.a(this.mRuntime.a(), HardCodeUtil.a(2131705903), 1).a();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user grant = sms");
    if (!TextUtils.isEmpty(this.c)) {
      a(this.c);
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
      this.b = paramJsBridgeListener.getString("callback");
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.mRuntime.a().checkSelfPermission("android.permission.SEND_SMS") != 0)
        {
          this.c = paramString1;
          ((AppActivity)this.mRuntime.a()).requestPermissions(this, 1, new String[] { "android.permission.SEND_SMS" });
          return true;
        }
        a(paramString1);
        return true;
      }
      a(paramString1);
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
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramJsBridgeListener).getString("callback");
      paramJsBridgeListener = this.mRuntime.a();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(paramJsBridgeListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(HardCodeUtil.a(2131705904));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(this);
      if (!paramJsBridgeListener.isFinishing()) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
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
        if ((this.mRuntime != null) && (this.mRuntime.a() != null))
        {
          paramJsBridgeListener = new Intent();
          paramJsBridgeListener.setAction("com.tencent.mobileqq.InvitationWebViewPlugin");
          paramJsBridgeListener.setPackage(MobileQQ.getContext().getPackageName());
          paramJsBridgeListener.putExtra("key_login_by_web", true);
          this.mRuntime.a().sendBroadcast(paramJsBridgeListener);
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
      a();
      return true;
    }
    if ("accountIdentityNotify".equals(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("InvitationFriend", 2, "handle newLogin/accountIdentityNotify");
      }
      if ((this.mRuntime != null) && (this.mRuntime.a() != null))
      {
        paramJsBridgeListener = new Intent();
        paramJsBridgeListener.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
        paramJsBridgeListener.setPackage(MobileQQ.getContext().getPackageName());
        this.mRuntime.a().sendBroadcast(paramJsBridgeListener);
        return true;
      }
      QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_AUTO_LOGIN error: runtime or activity is null");
    }
    return true;
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramInt) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.InvitationWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */