package com.tencent.mobileqq.activity.troop.config;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.multicard.MultiCardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.AbsTroopPushHandlerProcessor;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TroopBizTroopPushProcessor
  extends AbsTroopPushHandlerProcessor
{
  private static String a = "TroopBizTroopPushProcessor";
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (TroopLuckyCharacterUtil.a(paramInt1, paramInt2)) {
      ((ITroopListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong, int paramInt)
  {
    Object localObject;
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).removeToopMsgFilter(paramAppInterface, paramString, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApp());
      TroopNotificationHelper.a(paramString, paramAppInterface);
      localObject = (MultiCardManager)paramAppInterface.getManager(QQManagerFactory.TROOP_AIO_MULTI_CARD_MANAGER);
    }
    try
    {
      ((MultiCardManager)localObject).a(Long.parseLong(paramString), null);
      try
      {
        label62:
        boolean bool = paramAppInterface.getAVNotifyCenter().d(Long.parseLong(paramString));
        if (bool) {
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
        }
        if (QLog.isColorLevel())
        {
          paramAppInterface = a;
          paramString = new StringBuilder();
          paramString.append("handlePassiveExitTroop, hasTroopVideo: ");
          paramString.append(bool);
          QLog.d(paramAppInterface, 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramString = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlePassiveExitTroop, excption:");
        ((StringBuilder)localObject).append(paramAppInterface.getMessage());
        QLog.e(paramString, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopBizTroopPushProcessor
 * JD-Core Version:    0.7.0.1
 */