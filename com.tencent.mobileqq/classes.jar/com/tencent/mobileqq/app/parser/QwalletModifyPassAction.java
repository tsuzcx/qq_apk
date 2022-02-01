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
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver;
  private QwalletModifyPassAction.QWalletAuthMsgHandler jdField_a_of_type_ComTencentMobileqqAppParserQwalletModifyPassAction$QWalletAuthMsgHandler;
  
  public QwalletModifyPassAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692801, this.jdField_a_of_type_AndroidContentContext.getString(2131692783), 2131692785, 2131692784, new QwalletModifyPassAction.1(this), new QwalletModifyPassAction.2(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
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
    if (this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    ((QBaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  private void b()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName");
    String str5 = "";
    if (bool) {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
    } else {
      localObject = "";
    }
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
    } else {
      str1 = "";
    }
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    } else {
      str2 = "";
    }
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
    } else {
      str3 = "";
    }
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
    } else {
      str4 = "";
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");
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
    ((QWalletAuthHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a((ReqCheckChangePwdAuth)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppParserQwalletModifyPassAction$QWalletAuthMsgHandler = new QwalletModifyPassAction.QWalletAuthMsgHandler(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_ComTencentMobileqqAppParserQwalletModifyPassAction$QWalletAuthMsgHandler);
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
  }
  
  private void c()
  {
    com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = true;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("userId", this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin());
        localJSONObject.put("viewTag", "pswManage");
        if (!PayBridgeActivity.tenpay((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, ""))
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
  
  private boolean c()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof QBaseActivity)) {
      return false;
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    } else {
      str = "";
    }
    if (!str.equals(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin()))
    {
      a();
      return false;
    }
    b();
    return false;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = c();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QwalletModifyPassAction", 1, localStringBuilder.toString());
      b_("QwalletModifyPassAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QwalletModifyPassAction
 * JD-Core Version:    0.7.0.1
 */