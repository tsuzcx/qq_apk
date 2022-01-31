package com.tencent.biz.qrcode.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VasResourceCheckUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qwallet.plugin.QWalletHelper;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import osx;
import osy;

public class ScannerUtils
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "addDisSource";
    jdField_a_of_type_Int = 1;
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = "ConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
      do
      {
        return;
        if (paramInt == 2)
        {
          localObject = "GroupQRcard";
          break;
        }
      } while (paramInt == 3);
      String str = "ThirdpartyQRcard";
      if (QRUtils.g(paramString))
      {
        StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (QRUtils.i(paramString))
        {
          StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
          localObject = str;
        }
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = Class.forName("android.gestureboost.GestureBoostManager");
          Object localObject2 = ((Class)localObject1).getDeclaredField("sGestureBoostManager");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localObject1);
          localObject1 = ((Class)localObject1).getDeclaredField("mContext");
          ((Field)localObject1).setAccessible(true);
          if (((Field)localObject1).get(localObject2) == paramContext)
          {
            ((Field)localObject1).set(localObject2, null);
            return;
          }
        }
        catch (Throwable paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ScannerUtils", 2, paramContext, new Object[0]);
  }
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, QrHandleResultCallBack paramQrHandleResultCallBack, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new osy(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramQrHandleResultCallBack);
    paramAppActivity = new NewIntent(paramAppActivity, QRCodeServlet.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramAppActivity.setObserver(paramScannerParams);
    paramQQAppInterface.startServlet(paramAppActivity);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("://aq.qq.com"))) {
      paramQQAppInterface.sendWirelessPswReq(3);
    }
  }
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, QrHandleResultCallBack paramQrHandleResultCallBack)
  {
    paramString1 = paramString2.trim();
    if (QLog.isColorLevel()) {
      QLog.d("ScannerUtils", 2, "resultString:" + paramString1);
    }
    if (paramAppActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ScannerUtils", 2, "handleUrl,activity == null");
      }
    }
    for (;;)
    {
      return;
      if (paramScannerParams.a)
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131230756, false);
        }
        paramAppActivity.setResult(-1, paramAppActivity.getIntent().putExtra("scanResult", paramString2));
        paramAppActivity.finish();
        return;
      }
      paramString2 = paramString1.toLowerCase();
      int j = -1;
      int k = 0;
      int i = j;
      if (Pattern.compile("^mecard.*").matcher(paramString2).matches()) {
        if (paramString1.length() <= "MECARD:".length())
        {
          i = j;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          i = 0;
        }
      }
      j = i;
      if (Pattern.compile("^begin:vcard[\\s\\S]*end:vcard").matcher(paramString2).matches()) {
        if (paramString1.length() <= "BEGIN:VCARD\nEND:VCARD".length())
        {
          j = i;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          j = 1;
        }
      }
      i = j;
      if (Pattern.compile("^bizcard.*;;$").matcher(paramString2).matches()) {
        if (paramString1.length() <= "BIZCARD:;;:".length())
        {
          i = j;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          i = 2;
        }
      }
      if (paramString2.startsWith("qqf2f://qf/"))
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131230756, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, paramString1, paramQrHandleResultCallBack);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramQrHandleResultCallBack);
        return;
      }
      if (paramString2.startsWith("http://cmshow.qq.com/start-apollo-game.html"))
      {
        ApolloGameUtil.a(paramAppActivity, paramQQAppInterface, paramString1);
        paramAppActivity.finish();
      }
      j = k;
      if (i != -1) {
        j = 1;
      }
      if (j != 0)
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131230756, false);
        }
        if (j == 0) {
          break label923;
        }
        QRResultHandler.a(paramQQAppInterface, paramAppActivity, paramString1, i);
        i = 0;
      }
      while ((i == 0) && (paramScannerParams.b))
      {
        paramAppActivity.finish();
        return;
        if (!HttpUtil.a(paramAppActivity))
        {
          paramString1 = DialogUtil.a(paramAppActivity, 230);
          paramString1.setMessage(2131429908);
          paramString2 = new osx(paramQrHandleResultCallBack);
          paramString1.setPositiveButton(2131432999, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131230756, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).IsWtLoginUrl(paramString2)) && (!QRUtils.a(paramString2)))
        {
          paramView.setVisibility(0);
          paramString2 = new Intent(paramAppActivity, QRLoginActivity.class);
          paramString2.putExtra("QR_CODE_STRING", paramString1);
          if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
            paramAppActivity.startActivityForResult(paramString2, 2);
          }
          for (;;)
          {
            i = 0;
            break;
            paramAppActivity.startActivity(paramString2);
          }
        }
        if (((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http://iot.qq.com/add"))) || (("ScanSmartDevice".equals(paramAppActivity.getIntent().getStringExtra("from"))) && (!TextUtils.isEmpty(paramString2)) && (!paramString2.startsWith("http://qqapp.eprintsw.com"))))
        {
          SmartDeviceReport.a().a(1);
          SmartDeviceReport.a().jdField_a_of_type_JavaLangString = "";
          SmartDeviceReport.a().jdField_a_of_type_Int = 0;
          SmartDeviceReport.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramQrHandleResultCallBack, paramString1)) {
            paramAppActivity.finish();
          }
          i = 0;
        }
        else if (a(paramString1))
        {
          a(paramString1, paramAppActivity);
          i = 0;
        }
        else if (QRUtils.d(paramString2))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (QRUtils.e(paramString2))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (QRUtils.f(paramString2))
        {
          QWalletHelper.doF2FRedpack(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (QRUtils.h(paramString2))
        {
          if (QRUtils.b(paramString2))
          {
            paramString2 = new Intent(paramAppActivity, JoinDiscussionActivity.class);
            paramString2.putExtra("innerSig", paramString1);
            paramString2.putExtra(jdField_a_of_type_JavaLangString, jdField_a_of_type_Int);
            if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
              paramAppActivity.startActivityForResult(paramString2, 2);
            }
            for (;;)
            {
              i = 0;
              break;
              paramAppActivity.startActivity(paramString2);
            }
          }
          if (VasResourceCheckUtil.a(paramString1))
          {
            VasResourceCheckUtil.a(paramQQAppInterface, paramAppActivity, paramString1);
            i = 0;
          }
          else
          {
            a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramQrHandleResultCallBack, paramView);
            i = 1;
          }
        }
        else
        {
          QRResultHandler.a(paramQQAppInterface, paramAppActivity, paramString1);
          label923:
          i = 0;
        }
      }
    }
  }
  
  private static void a(String paramString, AppActivity paramAppActivity)
  {
    Intent localIntent = new Intent(paramAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("fromQrcode", true);
    localIntent.putExtra("url", paramString);
    if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
      paramAppActivity.startActivityForResult(localIntent, 2);
    }
    for (;;)
    {
      paramAppActivity.finish();
      return;
      paramAppActivity.startActivity(localIntent);
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("app_name=qim");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerUtils
 * JD-Core Version:    0.7.0.1
 */