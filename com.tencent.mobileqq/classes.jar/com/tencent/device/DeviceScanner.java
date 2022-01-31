package com.tencent.device;

import aabm;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import bdcd;
import bdfq;
import bjxx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import xwj;

public class DeviceScanner
{
  public static final String ADD_TAG_SMS = "SMS";
  public static final String HPCLOUD_QCODE = "http://qqapp.eprintsw.com";
  public static final String PARAM_PID = "pid";
  public static final int PARAM_PID_MIN_VALUE = 1000000000;
  public static final String PARAM_SCAN_FROM = "ScanSmartDevice";
  public static final String PARAM_SN = "sn";
  public static final int PARAM_SN_LEN = 16;
  public static final String PARAM_TAG = "addtag";
  public static final String PARAM_TOKEN = "token";
  public static final String QCODE = "http://iot.qq.com/add";
  public static final String QCODE_EX = "https://iot.qq.com/add";
  static final String TAG = "smartdevice::DeviceScanner";
  
  static void goToErrorPage(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_qrcode_error/index.html");
    bjxx.a().a(paramActivity, paramQQAppInterface, paramQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
  }
  
  public static boolean openDeviceQCodeUrl(Activity paramActivity, xwj paramxwj, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::DeviceScanner", 2, "device qrcode url:" + paramString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    DeviceScanner.DeviceQRCodeParser localDeviceQRCodeParser = new DeviceScanner.DeviceQRCodeParser();
    try
    {
      localDeviceQRCodeParser.parseQRCodeUrl(paramString);
      int i;
      do
      {
        try
        {
          i = Integer.parseInt(localDeviceQRCodeParser.strDevPid);
          if ((TextUtils.isEmpty(localDeviceQRCodeParser.strDevPid)) || (TextUtils.isEmpty(localDeviceQRCodeParser.strDevSN)) || ((!TextUtils.isEmpty(localDeviceQRCodeParser.strDevToken)) && (localDeviceQRCodeParser.strDevToken.length() != 32)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("smartdevice::DeviceScanner", 2, "device qrcode error pid:" + localDeviceQRCodeParser.strDevPid + " sn:" + localDeviceQRCodeParser.strDevSN + ",token:" + localDeviceQRCodeParser.strDevToken);
            }
            aabm.a().jdField_a_of_type_Int = i;
            aabm.a().a(localQQAppInterface, "Usr_Analyze_URL", 3);
            aabm.a(localQQAppInterface, "Usr_QRCode_Result", 0, 0, i);
            if (paramActivity != null)
            {
              if (paramString.startsWith("http://iot.qq.com")) {
                showNoticeDlg(paramActivity, paramxwj, 2131691624, 2131691623);
              }
            }
            else {
              return false;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            i = 0;
          }
          if ((!TextUtils.isEmpty(localDeviceQRCodeParser.strDevToken)) && (localDeviceQRCodeParser.strDevToken.length() != 32))
          {
            showNoticeDlg(paramActivity, paramxwj, 2131691624, 2131691625);
            return false;
          }
          if (!bjxx.a().a(localQQAppInterface))
          {
            showNoticeDlg(paramActivity, paramxwj, 2131691624, 2131691623);
            return false;
          }
          goToErrorPage(paramActivity, localQQAppInterface);
          return false;
        }
        if (((TextUtils.isEmpty(localDeviceQRCodeParser.strDevPid)) || ((localDeviceQRCodeParser.strDevPid.length() == 10) && (TextUtils.isDigitsOnly(localDeviceQRCodeParser.strDevPid)))) && ((TextUtils.isEmpty(localDeviceQRCodeParser.strDevSN)) || (localDeviceQRCodeParser.strDevSN.length() == 16))) {
          break;
        }
      } while (paramActivity == null);
      showNoticeDlg(paramActivity, paramxwj, 2131691624, 2131691623);
      return false;
      aabm.a().jdField_a_of_type_Int = i;
      aabm.a().jdField_a_of_type_JavaLangString = localDeviceQRCodeParser.strDevSN;
      if ("SMS".equals(localDeviceQRCodeParser.strTag)) {
        aabm.a().a(localQQAppInterface, "Usr_Analyze_URL", 4);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("smartdevice::DeviceScanner", 2, "device qrcode pid:" + localDeviceQRCodeParser.strDevPid + " sn:" + localDeviceQRCodeParser.strDevSN);
        }
        if (bjxx.a().a(localQQAppInterface)) {
          break;
        }
        if (paramActivity != null)
        {
          paramxwj = new Intent(paramActivity, DevicePluginDownloadActivity.class);
          paramxwj.putExtra("DevicePID", localDeviceQRCodeParser.strDevPid);
          paramxwj.putExtra("DeviceSN", localDeviceQRCodeParser.strDevSN);
          paramxwj.putExtra("DeviceToken", localDeviceQRCodeParser.strDevToken);
          paramActivity.startActivity(paramxwj);
        }
        return true;
        if ((localDeviceQRCodeParser.strDevToken != null) && (localDeviceQRCodeParser.strDevToken.length() > 0)) {
          aabm.a().a(localQQAppInterface, "Usr_Analyze_URL", 2);
        } else {
          aabm.a().a(localQQAppInterface, "Usr_Analyze_URL", 1);
        }
      }
      paramxwj = new Intent();
      paramxwj.putExtra("DevicePID", localDeviceQRCodeParser.strDevPid);
      paramxwj.putExtra("DeviceSN", localDeviceQRCodeParser.strDevSN);
      paramxwj.putExtra("DeviceToken", localDeviceQRCodeParser.strDevToken);
      paramxwj.putExtra("DataReportSeq", aabm.a().jdField_a_of_type_Long);
    }
    catch (Exception localException2)
    {
      try
      {
        paramxwj.putExtra("nickname", localQQAppInterface.getCurrentNickname());
        paramxwj.putExtra("bitmap", localQQAppInterface.a(localQQAppInterface.getCurrentAccountUin(), (byte)2, false));
        label666:
        bjxx.a().a(paramActivity, localQQAppInterface, localQQAppInterface.getAccount(), paramxwj, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
        return true;
        localException2 = localException2;
      }
      catch (Exception paramString)
      {
        break label666;
      }
    }
  }
  
  private static void showNoticeDlg(Activity paramActivity, xwj paramxwj, int paramInt1, int paramInt2)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = bdcd.a(paramActivity, 230);
    paramActivity.setNegativeButton(2131694951, new DeviceScanner.1(paramxwj));
    paramActivity.setTitle(paramInt1);
    paramActivity.setMessage(paramInt2);
    paramActivity.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.DeviceScanner
 * JD-Core Version:    0.7.0.1
 */