package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.HashMap;

public class QwalletToHomeAction
  extends JumpAction
{
  private QQAppInterface a;
  
  public QwalletToHomeAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("PayInvokerId", 13);
    ((Bundle)localObject).putString("viewParam", paramString1);
    if (paramString2 != null) {
      ((Bundle)localObject).putString("entry", paramString2);
    }
    paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class);
    paramString1.putExtra("srvBundle", (Bundle)localObject);
    if (paramLong != 0L) {
      paramString1.putExtra("vacreport_key_seq", paramLong);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("&seq=");
    ((StringBuilder)localObject).append(paramLong);
    paramString1.setData(Uri.parse(((StringBuilder)localObject).toString()));
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramString1);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    if (paramLong != 0L) {
      localBundle.putLong("vacreport_key_seq", paramLong);
    }
    if (paramBundle != null) {
      localBundle.putBundle("extra_pay_data", paramBundle);
    }
    VACDReportUtil.a(paramLong, null, "loadPluginStart", null, 0, null);
    QWalletPayBridge.launchForeground((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    return true;
  }
  
  private boolean c()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof QBaseActivity)) {
      return false;
    }
    ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).launchQWalletAct((QBaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    return true;
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        bool = "0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("viewtype"));
        if ((bool) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && ((this.jdField_a_of_type_JavaUtilHashMap.get("view") == null) || ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("view"))))) {
          return c();
        }
        if (("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))))
        {
          bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("entry");
          localObject2 = null;
          if (!bool) {
            break label491;
          }
          str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("entry");
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("seq")) {
            localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("seq");
          }
          l2 = 0L;
          bool = TextUtils.isEmpty((CharSequence)localObject2);
          l1 = l2;
          if (!bool) {
            l1 = l2;
          }
        }
      }
      catch (Exception localException1)
      {
        boolean bool;
        String str;
        long l2;
        long l1;
        Bundle localBundle;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doAction error: ");
        ((StringBuilder)localObject2).append(localException1.getMessage());
        QLog.e("QwalletToHomeAction", 1, ((StringBuilder)localObject2).toString());
        b_("QwalletToHomeAction");
        return false;
      }
      try
      {
        l2 = Long.valueOf((String)localObject2).longValue();
        l1 = l2;
        VACDReportUtil.a(l2, "", "jumpParse", null, 0, null);
        l1 = l2;
      }
      catch (Exception localException2)
      {
        continue;
      }
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
      if ((!"1".equals(localObject2)) && (!"2".equals(localObject2)) && (!"3".equals(localObject2)) && (!"4".equals(localObject2)) && (!"5".equals(localObject2)) && (!"6".equals(localObject2)) && (!"7".equals(localObject2)) && (!"9".equals(localObject2)) && (!"10".equals(localObject2)) && (!"11".equals(localObject2)))
      {
        if ("8".equals(localObject2)) {
          return a((String)localObject2, str, l1);
        }
      }
      else
      {
        localBundle = new Bundle();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tokenid")) {
          localBundle.putString("tokenid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("tokenid"));
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("data")) {
          localBundle.putString("data", (String)this.jdField_a_of_type_JavaUtilHashMap.get("data"));
        }
        bool = a((String)localObject2, str, l1, localBundle);
        return bool;
      }
      return false;
      label491:
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QwalletToHomeAction
 * JD-Core Version:    0.7.0.1
 */