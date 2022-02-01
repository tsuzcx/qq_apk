package com.tencent.mobileqq.apollo.drawer;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ApolloDrawerInfoManager
{
  public static int a(int paramInt)
  {
    if (a(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public static int a(int paramInt, long paramLong)
  {
    int i = paramInt * 400 / 540;
    if (i <= paramLong * 0.7D)
    {
      paramInt = i;
      if (i > 0) {}
    }
    else
    {
      paramInt = (int)(paramLong * 0.7D);
    }
    return paramInt;
  }
  
  public static CheckApolloInfoResult a(QQAppInterface paramQQAppInterface, String paramString, ApolloBaseInfo paramApolloBaseInfo, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramApolloBaseInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloDrawerInfoManager", 1, "checkDrawerRoleDressInfo param err");
      return null;
    }
    int k = ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramQQAppInterface, paramString);
    int m = paramApolloBaseInfo.apolloStatus;
    Object localObject = paramApolloBaseInfo.getApolloDress();
    int i;
    if (localObject != null)
    {
      i = ((ApolloDress)localObject).roleId;
      localObject = ((ApolloDress)localObject).getDressIds();
    }
    for (;;)
    {
      paramApolloBaseInfo = paramApolloBaseInfo.getApolloDress3D();
      int j;
      if (paramApolloBaseInfo != null)
      {
        j = paramApolloBaseInfo.roleId;
        paramApolloBaseInfo = paramApolloBaseInfo.getDressIds();
      }
      for (;;)
      {
        CheckApolloInfoResult localCheckApolloInfoResult = new CheckApolloInfoResult();
        localCheckApolloInfoResult.jdField_a_of_type_Int = i;
        localCheckApolloInfoResult.jdField_a_of_type_ArrayOfInt = ((int[])localObject);
        localCheckApolloInfoResult.jdField_b_of_type_Int = j;
        localCheckApolloInfoResult.jdField_b_of_type_ArrayOfInt = paramApolloBaseInfo;
        localCheckApolloInfoResult.c = m;
        localCheckApolloInfoResult.d = k;
        localCheckApolloInfoResult.e = SpriteUtil.b(paramInt);
        boolean bool;
        if (m != 1)
        {
          bool = true;
          QLog.e("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo apollo not open from:", Integer.valueOf(paramInt), ",apolloFeatureFlag:", Integer.valueOf(m) });
          TraceReportUtil.a(localCheckApolloInfoResult.e, 10, 101, new Object[] { "apollo not open, flag:", Integer.valueOf(m) });
        }
        for (;;)
        {
          localCheckApolloInfoResult.jdField_a_of_type_Boolean = bool;
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.d("ApolloDrawerInfoManager", 2, new Object[] { "checkDrawerRoleDressInfo from:", Integer.valueOf(paramInt), ",result:", localCheckApolloInfoResult.toString() });
          }
          TraceReportUtil.a(localCheckApolloInfoResult.e, 10, new Object[] { localCheckApolloInfoResult.toString() });
          return localCheckApolloInfoResult;
          if ((k == 1) && ((i <= 0) || (localObject == null) || (localObject.length <= 0) || ((i > 0) && (!ApolloActionHelperImpl.isRscValid(paramString, i, (int[])localObject, paramQQAppInterface)))))
          {
            bool = true;
            QLog.e("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo basic not ready, from:", Integer.valueOf(paramInt), ",result:", localCheckApolloInfoResult.toString() });
            TraceReportUtil.a(localCheckApolloInfoResult.e, 10, 111, new Object[] { "basic not ready:" + localCheckApolloInfoResult.toString() });
          }
          else
          {
            if ((k == 2) && ((j <= 0) || (paramApolloBaseInfo == null) || (paramApolloBaseInfo.length <= 0) || ((j > ApolloConstant.jdField_b_of_type_Int) && (!ApolloActionHelperImpl.isRscValid(paramString, j, paramApolloBaseInfo, paramQQAppInterface)))))
            {
              QLog.d("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo 3D not ready, from:", Integer.valueOf(paramInt), ",result:", localCheckApolloInfoResult.toString() });
              TraceReportUtil.a(localCheckApolloInfoResult.e, 10, new Object[] { "3D role/dress not ready but show basic" });
            }
            if (!ApolloEngine.a())
            {
              QLog.d("ApolloDrawerInfoManager", 1, "so is not ready");
              TraceReportUtil.a(localCheckApolloInfoResult.e, 10, 102, new Object[] { "so not ready" });
              bool = true;
            }
            else
            {
              bool = false;
            }
          }
        }
        paramApolloBaseInfo = null;
        j = 0;
      }
      localObject = null;
      i = 0;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static int b(int paramInt)
  {
    if (a(paramInt)) {
      return 3;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager
 * JD-Core Version:    0.7.0.1
 */