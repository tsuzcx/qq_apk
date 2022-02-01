package com.tencent.biz.webviewplugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomContextMenuDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import mqq.app.AppActivity;

public class PubAccountMailJsPlugin
  extends WebViewPlugin
{
  String a = null;
  ActionSheet b = null;
  private android.content.ClipboardManager c = null;
  private android.text.ClipboardManager d = null;
  private QQCustomContextMenuDialog e = null;
  
  public PubAccountMailJsPlugin()
  {
    this.mPluginNameSpace = "mail";
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.setType(paramString2);
    paramString1.putExtra("phone", this.a);
    this.mRuntime.d().startActivity(paramString1);
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Object localObject = this.mRuntime.d();
      if ((localObject instanceof AppActivity))
      {
        localObject = (AppActivity)localObject;
        if (((AppActivity)localObject).checkSelfPermission("android.permission.CALL_PHONE") != 0)
        {
          ((AppActivity)localObject).requestPermissions(new PubAccountMailJsPlugin.2(this), 1, new String[] { "android.permission.CALL_PHONE" });
          return;
        }
        c();
      }
    }
    else
    {
      c();
    }
  }
  
  private void c()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004B43", "0X8004B43", 0, 0, "", "", "", "");
    this.mRuntime.d().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] { this.a }))));
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMailJsPlugin", 2, String.format("Dial %s success", new Object[] { this.a }));
    }
  }
  
  private void d()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Object localObject = this.mRuntime.d();
      if ((localObject instanceof AppActivity))
      {
        localObject = (AppActivity)localObject;
        if (((AppActivity)localObject).checkSelfPermission("android.permission.SEND_SMS") != 0)
        {
          ((AppActivity)localObject).requestPermissions(new PubAccountMailJsPlugin.3(this), 1, new String[] { "android.permission.SEND_SMS" });
          return;
        }
        e();
      }
    }
    else
    {
      e();
    }
  }
  
  private void e()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004B44", "0X8004B44", 0, 0, "", "", "", "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("smsto:");
    ((StringBuilder)localObject).append(this.a);
    localObject = new Intent("android.intent.action.SENDTO", Uri.parse(((StringBuilder)localObject).toString()));
    this.mRuntime.d().startActivity((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMailJsPlugin", 2, String.format("Send SMS to %s success", new Object[] { this.a }));
    }
  }
  
  private void f()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Object localObject = this.mRuntime.d();
      if ((localObject instanceof AppActivity))
      {
        localObject = (AppActivity)localObject;
        if (((AppActivity)localObject).checkSelfPermission("android.permission.WRITE_CONTACTS") != 0)
        {
          ((AppActivity)localObject).requestPermissions(new PubAccountMailJsPlugin.4(this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
          return;
        }
        g();
      }
    }
    else
    {
      g();
    }
  }
  
  private void g()
  {
    Activity localActivity = this.mRuntime.d();
    Object localObject = this.e;
    if (localObject == null)
    {
      localObject = new QQCustomMenu();
      ((QQCustomMenu)localObject).a(1, localActivity.getString(2131897884));
      ((QQCustomMenu)localObject).a(2, localActivity.getString(2131897885));
      ((QQCustomMenu)localObject).a(String.format(localActivity.getString(2131897883), new Object[] { this.a }));
      this.e = DialogUtil.a(localActivity, (QQCustomMenu)localObject, new PubAccountMailJsPlugin.5(this));
      if (this.e != null) {}
    }
    else
    {
      ((QQCustomContextMenuDialog)localObject).setTitle(String.format(localActivity.getString(2131897883), new Object[] { this.a }));
    }
    this.e.show();
  }
  
  @TargetApi(11)
  private void h()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (this.d == null) {
        this.d = ((android.text.ClipboardManager)this.mRuntime.d().getSystemService("clipboard"));
      }
      this.d.setText(this.a);
    }
    else
    {
      if (this.c == null) {
        this.c = ((android.content.ClipboardManager)this.mRuntime.d().getSystemService("clipboard"));
      }
      ClipData localClipData = ClipData.newPlainText("qqMailTel", this.a);
      android.content.ClipboardManager localClipboardManager = this.c;
      ClipboardMonitor.setPrimaryClip(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMailJsPlugin", 2, String.format("Copy %s success", new Object[] { this.a }));
    }
  }
  
  private void i()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004B45", "0X8004B45", 0, 0, "", "", "", "");
    a("android.intent.action.INSERT", "vnd.android.cursor.dir/contact");
  }
  
  private void j()
  {
    ReportController.b(null, "CliOper", "", "", "0X8004B46", "0X8004B46", 0, 0, "", "", "", "");
    a("android.intent.action.INSERT_OR_EDIT", "vnd.android.cursor.item/person");
  }
  
  public void a()
  {
    ActionSheet localActionSheet = this.b;
    if (localActionSheet == null)
    {
      this.b = ActionSheet.create(this.mRuntime.d());
      this.b.addButton(String.format("%s%s", new Object[] { this.mRuntime.d().getString(2131888562), this.a }));
      this.b.addButton(2131897886);
      this.b.addButton(2131897883);
      this.b.addButton(2131888244);
      this.b.addCancelButton(2131887648);
      this.b.setOnButtonClickListener(new PubAccountMailJsPlugin.1(this));
    }
    else
    {
      localActionSheet.updateButton(0, String.format("%s%s", new Object[] { this.mRuntime.d().getString(2131888562), this.a }));
    }
    this.b.show();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest url: ");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append("pkgName:");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append("method:");
      paramJsBridgeListener.append(paramString3);
      QLog.e("PubAccountMailJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("mail")))
    {
      if (TextUtils.isEmpty(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PubAccountMailJsPlugin", 2, "method is null");
        }
        return false;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        paramJsBridgeListener = paramVarArgs[0];
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMailJsPlugin", 2, String.format("Params phone is %s", new Object[] { paramJsBridgeListener }));
        }
        if (!TextUtils.isEmpty(paramJsBridgeListener))
        {
          if (paramString3.equals("showMenu"))
          {
            paramString1 = this.b;
            if ((paramString1 == null) || (!paramString1.isShowing()))
            {
              paramString1 = this.e;
              if ((paramString1 == null) || (!paramString1.isShowing())) {}
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label253;
              }
              QLog.d("PubAccountMailJsPlugin", 2, "mSheet or mDialog is showing, so ignore request");
              return false;
            }
            this.a = paramJsBridgeListener;
            a();
            return true;
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.e("PubAccountMailJsPlugin", 2, "Phone is empty");
        }
        label253:
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PubAccountMailJsPlugin", 2, "args is empty");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PubAccountMailJsPlugin", 2, "pkgName is null");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountMailJsPlugin
 * JD-Core Version:    0.7.0.1
 */