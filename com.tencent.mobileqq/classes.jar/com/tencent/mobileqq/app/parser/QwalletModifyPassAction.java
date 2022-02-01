package com.tencent.mobileqq.app.parser;

import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class QwalletModifyPassAction
  extends JumpAction
{
  private QwalletModifyPassAction.QWalletAuthMsgHandler H;
  private QWalletAuthObserver I;
  private Dialog J;
  
  public QwalletModifyPassAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("midas://open_modify_status?status=");
    localStringBuilder.append(paramInt);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    if (this.b.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.b.startActivity(localIntent);
    }
    ((QBaseActivity)this.b).finish();
  }
  
  private void c()
  {
    this.J = DialogUtil.a(this.b, 2131889905, this.b.getString(2131889854), 2131889878, 2131889877, new QwalletModifyPassAction.1(this), new QwalletModifyPassAction.2(this));
    this.J.show();
  }
  
  private void d()
  {
    boolean bool = this.f.containsKey("packageName");
    String str5 = "";
    if (bool) {
      localObject = (String)this.f.get("packageName");
    } else {
      localObject = "";
    }
    String str1;
    if (this.f.containsKey("signareMode")) {
      str1 = (String)this.f.get("signareMode");
    } else {
      str1 = "";
    }
    String str2;
    if (this.f.containsKey("appid")) {
      str2 = (String)this.f.get("appid");
    } else {
      str2 = "";
    }
    String str3;
    if (this.f.containsKey("timeStamp")) {
      str3 = (String)this.f.get("timeStamp");
    } else {
      str3 = "";
    }
    String str4;
    if (this.f.containsKey("resetWordMode")) {
      str4 = (String)this.f.get("resetWordMode");
    } else {
      str4 = "";
    }
    if (this.f.containsKey("offerid")) {
      str5 = (String)this.f.get("offerid");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("packageName : ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" signatureMode :");
      localStringBuilder.append(str1);
      localStringBuilder.append(" appid : ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" timestamp : ");
      localStringBuilder.append(str3);
      localStringBuilder.append(" resetWordMode : ");
      localStringBuilder.append(str4);
      localStringBuilder.append(" offerId : ");
      localStringBuilder.append(str5);
      QLog.d("QwalletModifyPassAction", 2, localStringBuilder.toString());
    }
    Object localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
    ((QWalletAuthHandler)this.a.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a((ReqCheckChangePwdAuth)localObject);
    this.H = new QwalletModifyPassAction.QWalletAuthMsgHandler(this, null);
    this.I = new QWalletAuthObserver(this.H);
    this.a.addObserver(this.I);
  }
  
  private void e()
  {
    com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = true;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("userId", this.a.getCurrentAccountUin());
        localJSONObject.put("viewTag", "pswManage");
        if (!PayBridgeActivity.tenpay((Activity)this.b, localJSONObject.toString(), 5, ""))
        {
          i = 1;
          a(i);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a(1);
        return;
      }
      int i = 0;
    }
  }
  
  private boolean f()
  {
    if (!(this.b instanceof QBaseActivity)) {
      return false;
    }
    String str;
    if (this.f.containsKey("uin")) {
      str = (String)this.f.get("uin");
    } else {
      str = "";
    }
    if (!str.equals(this.a.getCurrentAccountUin()))
    {
      c();
      return false;
    }
    d();
    return false;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = f();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QwalletModifyPassAction", 1, localStringBuilder.toString());
      h_("QwalletModifyPassAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QwalletModifyPassAction
 * JD-Core Version:    0.7.0.1
 */