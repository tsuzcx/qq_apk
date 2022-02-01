package com.tencent.biz.qcircleshadow.lib;

import aeow;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import anvk;
import auon;
import bheh;
import bhey;
import bmkk;
import bmol;
import bmom;
import bnlf;
import bnrj;
import com.tencent.biz.qcircleshadow.lib.bean.QCircleVasRewardAdParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.Map;
import mqq.app.AppRuntime;

public class QCircleHostLauncher
{
  private static final String TAG = "QCircleHostLauncher";
  
  public static void VasAdvInitDeviceInfo()
  {
    bmkk.a().a(null);
  }
  
  public static void doJumpAction(Context paramContext, String paramString)
  {
    QQAppInterface localQQAppInterface = QCircleCommonUtil.getQQAppInterface();
    if (localQQAppInterface == null)
    {
      QLog.e("QCircleHostLauncher", 1, "getApp is null");
      return;
    }
    paramContext = bhey.a(localQQAppInterface, paramContext, paramString);
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
    bnrj.a(paramContext, paramIntent);
  }
  
  public static void launchAECameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    bnlf.b(paramContext, paramBundle);
  }
  
  public static void launchAEMutiCameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    bnlf.c(paramContext, paramBundle);
  }
  
  public static void launchQQPhotoSelect(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 31);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(localIntent, 20000);
      return;
    }
    QLog.e("QCircleHostLauncher", 1, "launchQQPhotoSelect activity is not Activity");
  }
  
  public static void openFlutterPageForQCircle(Context paramContext, String paramString, Map<String, Object> paramMap, byte[] paramArrayOfByte)
  {
    auon.a(paramContext, paramString, paramMap, paramArrayOfByte);
  }
  
  public static void reportDC02880(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = new LpReportInfo_dc02880(2, 2, null, paramString2);
    LpReportManager.getInstance().reportToDC02880(paramString1, false, true);
  }
  
  public static void requestAd(Context paramContext, QCircleVasRewardAdParams paramQCircleVasRewardAdParams, QCircleHostLauncher.InnerVasRewardAdCallback paramInnerVasRewardAdCallback)
  {
    paramQCircleVasRewardAdParams = new bmol(Integer.valueOf(paramQCircleVasRewardAdParams.mAdvPos), Integer.valueOf(paramQCircleVasRewardAdParams.mRewardType), paramQCircleVasRewardAdParams.mRewardItem, paramQCircleVasRewardAdParams.mRewardText, Long.valueOf(paramQCircleVasRewardAdParams.mUin), paramQCircleVasRewardAdParams.mGdtBizId, paramQCircleVasRewardAdParams.mBizSrcId).a();
    new bmom((Activity)paramContext, paramQCircleVasRewardAdParams, new QCircleHostLauncher.1(paramInnerVasRewardAdCallback)).a();
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
      if (((anvk)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString)) {
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
    aeow.a(paramContext, paramIntent, paramClass1, paramClass2);
  }
  
  public static void startWithPublicFragmentActivityForPeakForResult(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2, int paramInt)
  {
    aeow.a(paramContext, paramIntent, paramClass1, paramClass2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher
 * JD-Core Version:    0.7.0.1
 */