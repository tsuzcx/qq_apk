package com.tencent.mobileqq.apollo.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelBarConfBean;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class ApolloPanelUtil
{
  public static int a(int paramInt)
  {
    if (CmShowAioMatcherImpl.judgeSupported(paramInt, 1)) {
      return 4018;
    }
    if (CmShowAioMatcherImpl.judgeSupported(paramInt, 2)) {
      return 4019;
    }
    return -1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ApolloInfo paramApolloInfo, ApolloActionData paramApolloActionData)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    boolean bool1 = paramQQAppInterface.isObtainActionById(paramApolloActionData.actionId);
    boolean bool2 = paramApolloActionData.hasSound;
    int k = 8;
    if ((!bool2) && (paramApolloInfo.mAudioId <= 0))
    {
      if (paramApolloActionData.actionType == 8) {
        i = 1024;
      } else {
        i = 0;
      }
    }
    else {
      i = 1;
    }
    bool2 = paramQQAppInterface.isLimitFreeActionById(paramApolloActionData.actionId);
    int m = 4;
    if (bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanelUtil", 2, new Object[] { "data actionId:", Integer.valueOf(paramApolloActionData.actionId), "typeValue:", Integer.valueOf(i) });
      }
      return i | 0x2;
    }
    int j = i;
    if (paramApolloActionData.feeType == 6)
    {
      if (bool1) {
        j = 16;
      } else {
        j = 64;
      }
      j = i | j;
    }
    int i = j;
    if (paramApolloActionData.feeType == 2)
    {
      if (bool1) {
        i = m;
      } else {
        i = 128;
      }
      i = j | i;
    }
    if (paramApolloActionData.feeType == 9) {
      i |= 0x2000;
    }
    j = i;
    if (paramApolloActionData.feeType == 7)
    {
      if (bool1) {
        j = k;
      } else {
        j = 512;
      }
      j = i | j;
    }
    return j;
  }
  
  public static String a()
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    if (localQQAppInterface == null) {
      return null;
    }
    String str = localQQAppInterface.getCurrentUin();
    Object localObject = localQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(str);
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    int i = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(str);
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return ((SharedPreferences)localObject).getString("sp_key_apollo_current_page_package_id_3d", String.valueOf(300));
    }
    return ((SharedPreferences)localObject).getString("sp_key_apollo_current_page_package_id_2d", String.valueOf(0));
  }
  
  public static String a(@NotNull String paramString, IApolloResManager paramIApolloResManager)
  {
    AppRuntime localAppRuntime = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
    if (localAppRuntime == null) {
      return null;
    }
    int i = 0;
    paramString = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, localAppRuntime, false, paramIApolloResManager);
    if ((paramString != null) && (paramString.length == 2) && (paramString[1] != null) && (((int[])paramString[1]).length > 0))
    {
      paramString = (int[])paramString[1];
      paramIApolloResManager = new StringBuilder();
      int j = paramString.length;
      while (i < j)
      {
        paramIApolloResManager.append(paramString[i]);
        paramIApolloResManager.append("_");
        i += 1;
      }
      return paramIApolloResManager.toString();
    }
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = ApolloUtilImpl.getQQApp();
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateStoredIndexAndPackageId fail, app null, userStatus:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", index:");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", packageId:");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.w("[cmshow]ApolloPanelUtil", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateStoredIndexAndPackageId, userStatus:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", index:");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", packageId:");
    ((StringBuilder)localObject2).append(paramInt3);
    QLog.i("[cmshow]ApolloPanelUtil", 1, ((StringBuilder)localObject2).toString());
    localObject2 = ((QQAppInterface)localObject1).getApp();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("apollo_sp");
    ((StringBuilder)localObject3).append(((QQAppInterface)localObject1).getCurrentUin());
    localObject3 = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0).edit();
    if (paramInt1 != 2)
    {
      localObject2 = "sp_key_apollo_current_page_index";
      localObject1 = "sp_key_apollo_current_page_package_id_2d";
    }
    else
    {
      localObject2 = "sp_key_apollo_current_page_index_3d";
      localObject1 = "sp_key_apollo_current_page_package_id_3d";
    }
    if (paramInt2 < 0)
    {
      ((SharedPreferences.Editor)localObject3).remove((String)localObject2);
      ((SharedPreferences.Editor)localObject3).remove((String)localObject1);
    }
    else
    {
      ((SharedPreferences.Editor)localObject3).putString((String)localObject2, String.valueOf(paramInt2));
      ((SharedPreferences.Editor)localObject3).putString((String)localObject1, String.valueOf(paramInt3));
    }
    ((SharedPreferences.Editor)localObject3).apply();
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 0) {
      return BaseChatPanelBarConfProcessor.a().b;
    }
    if (paramInt == 1) {
      return BaseChatPanelBarConfProcessor.b().b;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloPanelUtil
 * JD-Core Version:    0.7.0.1
 */