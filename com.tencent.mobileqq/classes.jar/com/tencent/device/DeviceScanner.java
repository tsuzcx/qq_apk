package com.tencent.device;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import mqq.app.AppRuntime;

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
    localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_qrcode_error/index.html");
    SmartDevicePluginLoader.a().a(paramActivity, paramQQAppInterface, paramQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
  }
  
  public static boolean openDeviceQCodeUrl(Activity paramActivity, OnQRHandleResultCallback paramOnQRHandleResultCallback, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("device qrcode url:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("smartdevice::DeviceScanner", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    DeviceScanner.DeviceQRCodeParser localDeviceQRCodeParser = new DeviceScanner.DeviceQRCodeParser();
    try
    {
      localDeviceQRCodeParser.parseQRCodeUrl(paramString);
    }
    catch (Exception localException2)
    {
      try
      {
        i = Integer.parseInt(localDeviceQRCodeParser.strDevPid);
        break label82;
        i = 0;
        label82:
        if ((!TextUtils.isEmpty(localDeviceQRCodeParser.strDevPid)) && (!TextUtils.isEmpty(localDeviceQRCodeParser.strDevSN)) && ((TextUtils.isEmpty(localDeviceQRCodeParser.strDevToken)) || (localDeviceQRCodeParser.strDevToken.length() == 32)))
        {
          if (((!TextUtils.isEmpty(localDeviceQRCodeParser.strDevPid)) && ((localDeviceQRCodeParser.strDevPid.length() != 10) || (!TextUtils.isDigitsOnly(localDeviceQRCodeParser.strDevPid)))) || ((!TextUtils.isEmpty(localDeviceQRCodeParser.strDevSN)) && (localDeviceQRCodeParser.strDevSN.length() != 16)))
          {
            if (paramActivity != null) {
              showNoticeDlg(paramActivity, paramOnQRHandleResultCallback, 2131691538, 2131691537);
            }
            return false;
          }
          SmartDeviceReport.a().jdField_a_of_type_Int = i;
          SmartDeviceReport.a().jdField_a_of_type_JavaLangString = localDeviceQRCodeParser.strDevSN;
          if ("SMS".equals(localDeviceQRCodeParser.strTag)) {
            SmartDeviceReport.a().a((AppRuntime)localObject, "Usr_Analyze_URL", 4);
          } else if ((localDeviceQRCodeParser.strDevToken != null) && (localDeviceQRCodeParser.strDevToken.length() > 0)) {
            SmartDeviceReport.a().a((AppRuntime)localObject, "Usr_Analyze_URL", 2);
          } else {
            SmartDeviceReport.a().a((AppRuntime)localObject, "Usr_Analyze_URL", 1);
          }
          if (QLog.isColorLevel())
          {
            paramOnQRHandleResultCallback = new StringBuilder();
            paramOnQRHandleResultCallback.append("device qrcode pid:");
            paramOnQRHandleResultCallback.append(localDeviceQRCodeParser.strDevPid);
            paramOnQRHandleResultCallback.append(" sn:");
            paramOnQRHandleResultCallback.append(localDeviceQRCodeParser.strDevSN);
            QLog.d("smartdevice::DeviceScanner", 2, paramOnQRHandleResultCallback.toString());
          }
          if (!SmartDevicePluginLoader.a().a((QQAppInterface)localObject))
          {
            if (paramActivity != null)
            {
              paramOnQRHandleResultCallback = new Intent(paramActivity, DevicePluginDownloadActivity.class);
              paramOnQRHandleResultCallback.putExtra("DevicePID", localDeviceQRCodeParser.strDevPid);
              paramOnQRHandleResultCallback.putExtra("DeviceSN", localDeviceQRCodeParser.strDevSN);
              paramOnQRHandleResultCallback.putExtra("DeviceToken", localDeviceQRCodeParser.strDevToken);
              paramActivity.startActivity(paramOnQRHandleResultCallback);
            }
            return true;
          }
          paramOnQRHandleResultCallback = new Intent();
          paramOnQRHandleResultCallback.putExtra("DevicePID", localDeviceQRCodeParser.strDevPid);
          paramOnQRHandleResultCallback.putExtra("DeviceSN", localDeviceQRCodeParser.strDevSN);
          paramOnQRHandleResultCallback.putExtra("DeviceToken", localDeviceQRCodeParser.strDevToken);
          paramOnQRHandleResultCallback.putExtra("DataReportSeq", SmartDeviceReport.a().jdField_a_of_type_Long);
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            int i;
            paramOnQRHandleResultCallback.putExtra("nickname", ((QQAppInterface)localObject).getCurrentNickname());
            paramOnQRHandleResultCallback.putExtra("bitmap", ((QQAppInterface)localObject).getFaceBitmap(((QQAppInterface)localObject).getCurrentAccountUin(), (byte)2, false));
            label509:
            SmartDevicePluginLoader.a().a(paramActivity, (AppRuntime)localObject, ((QQAppInterface)localObject).getAccount(), paramOnQRHandleResultCallback, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
            return true;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("device qrcode error pid:");
              localStringBuilder.append(localDeviceQRCodeParser.strDevPid);
              localStringBuilder.append(" sn:");
              localStringBuilder.append(localDeviceQRCodeParser.strDevSN);
              localStringBuilder.append(",token:");
              localStringBuilder.append(localDeviceQRCodeParser.strDevToken);
              QLog.d("smartdevice::DeviceScanner", 2, localStringBuilder.toString());
            }
            SmartDeviceReport.a().jdField_a_of_type_Int = i;
            SmartDeviceReport.a().a((AppRuntime)localObject, "Usr_Analyze_URL", 3);
            SmartDeviceReport.a((AppRuntime)localObject, "Usr_QRCode_Result", 0, 0, i);
            if (paramActivity != null)
            {
              if (paramString.startsWith("http://iot.qq.com"))
              {
                showNoticeDlg(paramActivity, paramOnQRHandleResultCallback, 2131691538, 2131691537);
                return false;
              }
              if ((!TextUtils.isEmpty(localDeviceQRCodeParser.strDevToken)) && (localDeviceQRCodeParser.strDevToken.length() != 32))
              {
                showNoticeDlg(paramActivity, paramOnQRHandleResultCallback, 2131691538, 2131691539);
                return false;
              }
              if (!SmartDevicePluginLoader.a().a((QQAppInterface)localObject))
              {
                showNoticeDlg(paramActivity, paramOnQRHandleResultCallback, 2131691538, 2131691537);
                return false;
              }
              goToErrorPage(paramActivity, (QQAppInterface)localObject);
            }
            return false;
            localException1 = localException1;
          }
          localException2 = localException2;
        }
        catch (Exception paramString)
        {
          break label509;
        }
      }
    }
  }
  
  private static void showNoticeDlg(Activity paramActivity, OnQRHandleResultCallback paramOnQRHandleResultCallback, int paramInt1, int paramInt2)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setNegativeButton(2131694583, new DeviceScanner.1(paramOnQRHandleResultCallback));
    paramActivity.setTitle(paramInt1);
    paramActivity.setMessage(paramInt2);
    paramActivity.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.DeviceScanner
 * JD-Core Version:    0.7.0.1
 */