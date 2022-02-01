package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class ApolloPanelUtil
{
  public static int a(QQAppInterface paramQQAppInterface, ApolloInfo paramApolloInfo, ApolloActionData paramApolloActionData)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    boolean bool = paramQQAppInterface.isObtainActionById(paramApolloActionData.actionId);
    int i;
    if ((paramApolloActionData.hasSound) || (paramApolloInfo.mAudioId > 0)) {
      i = 1;
    }
    for (;;)
    {
      if (paramQQAppInterface.isLimitFreeActionById(paramApolloActionData.actionId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanelUtil", 2, new Object[] { "data actionId:", Integer.valueOf(paramApolloActionData.actionId), "typeValue:", Integer.valueOf(i) });
        }
        j = i | 0x2;
      }
      label143:
      label168:
      do
      {
        return j;
        if (paramApolloActionData.actionType != 8) {
          break label245;
        }
        i = 1024;
        break;
        j = i;
        if (paramApolloActionData.feeType == 6)
        {
          if (!bool) {
            break label223;
          }
          j = 16;
          j = i | j;
        }
        int k = j;
        if (paramApolloActionData.feeType == 2)
        {
          if (!bool) {
            break label230;
          }
          i = 4;
          k = j | i;
        }
        i = k;
        if (paramApolloActionData.feeType == 9) {
          i = k | 0x2000;
        }
        j = i;
      } while (paramApolloActionData.feeType != 7);
      if (bool) {}
      for (int j = 8;; j = 512)
      {
        j = i | j;
        break;
        label223:
        j = 64;
        break label143;
        label230:
        i = 128;
        break label168;
      }
      label245:
      i = 0;
    }
  }
  
  public static String a(@NotNull String paramString)
  {
    Object localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if (localObject == null) {
      return null;
    }
    paramString = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, (QQAppInterface)localObject, false);
    if ((paramString != null) && (paramString.length == 2) && (paramString[1] != null) && (((int[])paramString[1]).length > 0))
    {
      paramString = (int[])paramString[1];
      localObject = new StringBuilder();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(paramString[i]).append("_");
        i += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloPanelUtil
 * JD-Core Version:    0.7.0.1
 */