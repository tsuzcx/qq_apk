package com.tencent.biz.qcircleshadow.lib;

import adxr;
import amsw;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import atju;
import bfvp;
import bfwg;
import blvv;
import bmbz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qzone.QZoneHelper;
import java.util.Map;
import mqq.app.AppRuntime;

public class QCircleHostLauncher
{
  private static final String TAG = "QCircleHostLauncher";
  
  public static void doJumpAction(Context paramContext, String paramString)
  {
    QQAppInterface localQQAppInterface = QCircleCommonUtil.getQQAppInterface();
    if (localQQAppInterface == null)
    {
      QLog.e("QCircleHostLauncher", 1, "getApp is null");
      return;
    }
    paramContext = bfwg.a(localQQAppInterface, paramContext, paramString);
    if (paramContext != null)
    {
      paramContext.a();
      return;
    }
    QLog.e("QCircleHostLauncher", 2, "Push toast content clicked, but jumpAction is null! jumpUrl: " + paramString);
  }
  
  public static void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    QZoneHelper.forwardToMoodSelectLocation(paramContext, paramString, paramInt, paramBundle);
  }
  
  public static void jumpForAECircle(Context paramContext, Intent paramIntent)
  {
    bmbz.a(paramContext, paramIntent);
  }
  
  public static void launchAECameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    blvv.b(paramContext, paramBundle);
  }
  
  public static void launchAEMutiCameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    blvv.c(paramContext, paramBundle);
  }
  
  public static void openFlutterPageForQCircle(Context paramContext, String paramString, Map<String, Object> paramMap, byte[] paramArrayOfByte)
  {
    atju.a(paramContext, paramString, paramMap, paramArrayOfByte);
  }
  
  public static void startProfileCardActivity(Context paramContext, String paramString)
  {
    int i;
    if (paramString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
      i = 0;
    }
    for (;;)
    {
      paramString = new ProfileActivity.AllInOne(paramString, i);
      paramString.a = i;
      paramString.h = 128;
      paramString.i = 3080;
      paramString.l = 2;
      ProfileActivity.a(paramContext, paramString, false);
      return;
      if (((amsw)BaseApplicationImpl.getApplication().getRuntime().getManager(51)).b(paramString)) {
        i = 1;
      } else {
        i = 115;
      }
    }
  }
  
  public static void startWithPublicFragmentActivity(Context paramContext, Intent paramIntent, Class paramClass)
  {
    PublicFragmentActivity.a(paramContext, paramIntent, paramClass);
  }
  
  public static void startWithPublicFragmentActivityForPeak(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2)
  {
    adxr.a(paramContext, paramIntent, paramClass1, paramClass2);
  }
  
  public static void startWithPublicFragmentActivityForPeakForResult(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2, int paramInt)
  {
    adxr.a(paramContext, paramIntent, paramClass1, paramClass2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher
 * JD-Core Version:    0.7.0.1
 */