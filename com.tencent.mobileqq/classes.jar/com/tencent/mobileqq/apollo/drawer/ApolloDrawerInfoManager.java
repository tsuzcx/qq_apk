package com.tencent.mobileqq.apollo.drawer;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;

public class ApolloDrawerInfoManager
{
  public static int a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int a(int paramInt, long paramLong)
  {
    int i = paramInt * 400 / 540;
    double d1 = i;
    double d2 = paramLong;
    Double.isNaN(d2);
    d2 *= 0.7D;
    if (d1 <= d2)
    {
      paramInt = i;
      if (i > 0) {}
    }
    else
    {
      paramInt = (int)d2;
    }
    return paramInt;
  }
  
  public static CheckApolloInfoResult a(QQAppInterface paramQQAppInterface, String paramString, ApolloBaseInfo paramApolloBaseInfo, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramApolloBaseInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      int k = ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString);
      Object localObject1 = paramApolloBaseInfo.getApolloDress();
      int i;
      if (localObject1 != null)
      {
        i = ((ApolloDress)localObject1).roleId;
        localObject1 = ((ApolloDress)localObject1).getDressIds();
      }
      else
      {
        localObject1 = null;
        i = 0;
      }
      Object localObject2 = paramApolloBaseInfo.getApolloDress3D();
      int j;
      if (localObject2 != null)
      {
        j = ((ApolloDress)localObject2).roleId;
        localObject2 = ((ApolloDress)localObject2).getDressIds();
      }
      else
      {
        localObject2 = null;
        j = 0;
      }
      CheckApolloInfoResult localCheckApolloInfoResult = new CheckApolloInfoResult();
      localCheckApolloInfoResult.roleId = i;
      localCheckApolloInfoResult.dressIds = ((int[])localObject1);
      localCheckApolloInfoResult.threeRoleId = j;
      localCheckApolloInfoResult.threeDressIds = ((int[])localObject2);
      localCheckApolloInfoResult.apolloFeatureFlag = paramApolloBaseInfo.apolloStatus;
      localCheckApolloInfoResult.userStatus = k;
      localCheckApolloInfoResult.traceFeatureId = TraceReportUtil.c(paramInt);
      if ((paramInt == 1) && (paramApolloBaseInfo.apolloDrawerStatus == 0))
      {
        QLog.e("[cmshow]ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo apollo not open from:", Integer.valueOf(paramInt), ",apolloDrawerStatus:", Integer.valueOf(paramApolloBaseInfo.apolloDrawerStatus) });
        TraceReportUtil.a(localCheckApolloInfoResult.traceFeatureId, 10, 101, new Object[] { "apollo not open, flag:", Integer.valueOf(paramApolloBaseInfo.apolloDrawerStatus) });
      }
      boolean bool;
      IApolloResManager localIApolloResManager;
      for (;;)
      {
        bool = true;
        break label642;
        if ((paramInt == 2) && (paramApolloBaseInfo.apolloCardStatus == 0))
        {
          QLog.e("[cmshow]ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo apollo not open from:", Integer.valueOf(paramInt), ",apolloCardStatus:", Integer.valueOf(paramApolloBaseInfo.apolloCardStatus) });
          TraceReportUtil.a(localCheckApolloInfoResult.traceFeatureId, 10, 101, new Object[] { "apollo not open, flag:", Integer.valueOf(paramApolloBaseInfo.apolloCardStatus) });
        }
        else
        {
          if (paramInt == 1) {
            paramApolloBaseInfo = Scene.DRAWER;
          } else {
            paramApolloBaseInfo = Scene.FRIEND_CARD;
          }
          localIApolloResManager = ApolloResManagerFacade.a.a(paramApolloBaseInfo);
          if ((k != 1) || ((i > 0) && (localObject1 != null) && (localObject1.length > 0) && ((i <= 0) || (localIApolloResManager.a(paramString, i, (int[])localObject1, paramQQAppInterface))))) {
            break;
          }
          QLog.e("[cmshow]ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo basic not ready, from:", Integer.valueOf(paramInt), ",result:", localCheckApolloInfoResult.toString() });
          i = localCheckApolloInfoResult.traceFeatureId;
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("basic not ready:");
          paramQQAppInterface.append(localCheckApolloInfoResult.toString());
          TraceReportUtil.a(i, 10, 111, new Object[] { paramQQAppInterface.toString() });
        }
      }
      if ((k == 2) && ((j <= 0) || (localObject2 == null) || (localObject2.length <= 0) || ((j > ApolloConstant.f) && (!localIApolloResManager.a(paramString, j, (int[])localObject2, paramQQAppInterface)))))
      {
        QLog.d("[cmshow]ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo 3D not ready, from:", Integer.valueOf(paramInt), ",result:", localCheckApolloInfoResult.toString() });
        TraceReportUtil.a(localCheckApolloInfoResult.traceFeatureId, 10, new Object[] { "3D role/dress not ready but show basic" });
      }
      if (!CMShowPlatform.a.a(paramApolloBaseInfo))
      {
        QLog.d("[cmshow]ApolloDrawerInfoManager", 1, "so is not ready");
        TraceReportUtil.a(localCheckApolloInfoResult.traceFeatureId, 10, 102, new Object[] { "so not ready" });
        bool = true;
      }
      else
      {
        bool = false;
      }
      label642:
      localCheckApolloInfoResult.needStatic = bool;
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.d("[cmshow]ApolloDrawerInfoManager", 2, new Object[] { "checkDrawerRoleDressInfo from:", Integer.valueOf(paramInt), ",result:", localCheckApolloInfoResult.toString() });
      }
      TraceReportUtil.a(localCheckApolloInfoResult.traceFeatureId, 10, new Object[] { localCheckApolloInfoResult.toString() });
      return localCheckApolloInfoResult;
    }
    QLog.e("[cmshow]ApolloDrawerInfoManager", 1, "checkDrawerRoleDressInfo param err");
    return null;
  }
  
  public static int b(int paramInt)
  {
    if (c(paramInt)) {
      return 3;
    }
    return 2;
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager
 * JD-Core Version:    0.7.0.1
 */