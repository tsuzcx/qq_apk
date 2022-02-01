package com.tencent.biz.qcircleshadow.lib.variation;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleProfileCardChangeListener;
import com.tencent.biz.qcircleshadow.local.QCircleCardObserver;
import com.tencent.biz.qcircleshadow.local.QCircleMessageFacadeObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleMessageFacadeListener;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

public class HostDataTransUtils
{
  private static final String TAG = "HostDataTransUtils";
  private static final QCircleCardObserver sCardObserver = new QCircleCardObserver();
  private static final QCircleMessageFacadeObserver sMsgFacadeObserver = new QCircleMessageFacadeObserver();
  
  public static void addMsgFacadeObserver(QCircleMessageFacadeListener paramQCircleMessageFacadeListener)
  {
    sMsgFacadeObserver.a(paramQCircleMessageFacadeListener);
    QCircleServiceImpl.getMessageFacade().addObserver(sMsgFacadeObserver);
  }
  
  public static void clearRedDotInfo()
  {
    QCircleServiceImpl.getQQService().clearRedDotInfo();
  }
  
  public static String getA2(String paramString)
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getA2();
  }
  
  public static String getAccount()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public static String getAccountNickName(String paramString)
  {
    return QCircleServiceImpl.getQQService().getAccountName(paramString);
  }
  
  public static Bundle getArkDialogZipArgs(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return QQCustomArkDialogUtil.a(paramString1, paramString2, paramString3, paramString4, null);
  }
  
  public static String getBuddyName(String paramString, boolean paramBoolean)
  {
    return QCircleServiceImpl.getQQService().getBuddyName(paramString);
  }
  
  public static String getDeviceInfo()
  {
    return QCircleServiceImpl.getQZoneService().getDeviceInfo();
  }
  
  public static String getFriendNickName(String paramString)
  {
    return QCircleServiceImpl.getQQService().getFriendNick(paramString);
  }
  
  public static long getLongAccountUin()
  {
    return Long.valueOf(((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount()).longValue();
  }
  
  public static Pair<Integer, List<String>> getQCircleChatRedPointInfoFromMessageList()
  {
    if (QCircleServiceImpl.getInstance() != null)
    {
      QCircleServiceImpl.getInstance().makeRecentBaseDataList();
      return QCircleServiceImpl.getInstance().getQCircleChatRedPointInfoFromMessageList();
    }
    return null;
  }
  
  public static String getQUA3()
  {
    return QCircleServiceImpl.getQZoneService().getQUA3();
  }
  
  public static void getUserFaceBitmap(String paramString, QCircleFaceBitmapListener paramQCircleFaceBitmapListener)
  {
    Object localObject = (AppInterface)QCircleServiceImpl.getAppRunTime();
    localObject = ((IQQAvatarService)((AppInterface)localObject).getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)localObject);
    Bitmap localBitmap = ((IFaceDecoder)localObject).getBitmapFromCache(1, paramString, 1, (byte)1);
    if (localBitmap == null)
    {
      QLog.d("HostDataTransUtils", 1, "shareToWeChat share user icon(need decode task)");
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(new HostDataTransUtils.1(paramQCircleFaceBitmapListener, (IFaceDecoder)localObject));
      ((IFaceDecoder)localObject).requestDecodeFace(paramString, 200, false, 1, true, (byte)1, 1);
      return;
    }
    QLog.d("HostDataTransUtils", 1, "shareToWeChat share user icon(have cache)");
    paramQCircleFaceBitmapListener.getFaceBitmap(localBitmap);
    ((IFaceDecoder)localObject).destory();
  }
  
  public static void init()
  {
    if ((QCircleServiceImpl.getAppRunTime() instanceof AppInterface)) {
      ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).addObserver(sCardObserver);
    }
  }
  
  public static void initVideoSdk(QCircleVideoSdkInitListener paramQCircleVideoSdkInitListener)
  {
    QCircleServiceImpl.getQQService().initSDKAsync(paramQCircleVideoSdkInitListener);
  }
  
  public static boolean isStudyMode()
  {
    return ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
  }
  
  public static boolean isXLarge()
  {
    return FontSettingManager.getFontLevel() > 18.0F;
  }
  
  public static ArrayList<QCircleRecentDataInterface> makeRecentBaseDataList()
  {
    if (QCircleServiceImpl.getInstance() != null) {
      return QCircleServiceImpl.getInstance().makeRecentBaseDataList();
    }
    return null;
  }
  
  public static void registerProfileCardObserver(QCircleProfileCardChangeListener paramQCircleProfileCardChangeListener)
  {
    sCardObserver.a(paramQCircleProfileCardChangeListener);
  }
  
  public static void release()
  {
    if ((QCircleServiceImpl.getAppRunTime() instanceof AppInterface))
    {
      sCardObserver.a();
      ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).removeObserver(sCardObserver);
    }
  }
  
  public static void removeMsgFacadeObserver(QCircleMessageFacadeListener paramQCircleMessageFacadeListener)
  {
    sMsgFacadeObserver.a(null);
    QCircleServiceImpl.getMessageFacade().deleteObserver(sMsgFacadeObserver);
  }
  
  public static void reportStatisticPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public static void unRegisterCardObserver(QCircleProfileCardChangeListener paramQCircleProfileCardChangeListener)
  {
    sCardObserver.b(paramQCircleProfileCardChangeListener);
  }
  
  public static Serializable wrapSerializableMap(HashMap paramHashMap)
  {
    return ((IQQBaseService)QRoute.api(IQQBaseService.class)).wrapSerializableMap(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils
 * JD-Core Version:    0.7.0.1
 */