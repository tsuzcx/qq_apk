package com.tencent.mobileqq.apollo.aio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.model.ApolloRelationTag;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApolloIntimateActionPlayController
{
  private static volatile ApolloIntimateActionPlayController a;
  
  private int a(long paramLong)
  {
    int j = (int)paramLong;
    int i = 1;
    if (j != 1)
    {
      i = 2;
      if (j != 2)
      {
        i = 3;
        if (j != 3)
        {
          i = 26;
          if (j != 26) {
            i = 0;
          }
        }
      }
    }
    return i;
  }
  
  private int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    paramQQAppInterface = localApolloDaoManagerServiceImpl.getRelationTagList();
    int j = localIApolloManagerService.getCmShowStatus(paramString);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
    {
      int i = 0;
      while (i < paramQQAppInterface.size())
      {
        paramString = (ApolloRelationTag)paramQQAppInterface.get(i);
        if (paramInt == paramString.type)
        {
          i = localApolloDaoManagerServiceImpl.getWhiteFaceIdMapping(Integer.parseInt(paramString.action), j);
          paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("CmshowIntimateAction_sp", 4);
          paramQQAppInterface.edit().putInt("relationType", paramInt).apply();
          paramQQAppInterface.edit().putInt("actionId", i).apply();
          return i;
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] type error");
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] relationTagList is null");
    }
    return -1;
  }
  
  public static ApolloIntimateActionPlayController a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ApolloIntimateActionPlayController();
        }
      }
      finally {}
    }
    return a;
  }
  
  private SpriteTaskParam a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    paramInt = a(paramQQAppInterface, paramInt, paramString1);
    if (paramInt <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] actionId <= 0");
      }
      return null;
    }
    paramQQAppInterface = new ArrayList();
    paramQQAppInterface.add(Integer.valueOf(paramInt));
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = ((Integer)paramQQAppInterface.get(0)).intValue();
    localSpriteTaskParam.d = 1;
    localSpriteTaskParam.c = 1;
    localSpriteTaskParam.g = 2;
    localSpriteTaskParam.h = -10000L;
    localSpriteTaskParam.l = true;
    localSpriteTaskParam.r = paramQQAppInterface;
    localSpriteTaskParam.j = paramString1;
    localSpriteTaskParam.k = paramString2;
    return localSpriteTaskParam;
  }
  
  private boolean b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CmshowIntimateAction_sp", 4);
    long l = localSharedPreferences.getLong("timestamp", 0L);
    Date localDate1 = new Date();
    if (l > 0L)
    {
      Date localDate2 = new Date(l);
      if ((localDate2.getYear() == localDate1.getYear()) && (localDate2.getMonth() == localDate1.getMonth()) && (localDate2.getDay() == localDate1.getDay()))
      {
        int i = CmShowWnsUtils.T();
        int j = localSharedPreferences.getInt("times", 0);
        if (j < i)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] same day, nowTimes < maxTimes");
          }
          localSharedPreferences.edit().putLong("timestamp", localDate1.getTime()).apply();
          localSharedPreferences.edit().putInt("times", j + 1).apply();
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] play maxTimes,not show");
        }
        return false;
      }
    }
    localSharedPreferences.edit().putLong("timestamp", localDate1.getTime()).apply();
    localSharedPreferences.edit().putInt("times", 1).apply();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] new day");
    }
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo != null) && (paramQQAppInterface != null) && (paramSessionInfo.a == 0))
    {
      Object localObject1 = ((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
      if ((localObject1 != null) && (!((ISpriteBridge)localObject1).a()))
      {
        Object localObject2 = MutualMarkDataCenter.a(paramQQAppInterface, paramSessionInfo.b, true);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] intimate null");
          }
          return;
        }
        int i = a(((MutualMarkForDisplayInfo)localObject2).a);
        localObject2 = a(paramQQAppInterface, i, paramQQAppInterface.getCurrentUin(), paramSessionInfo.b);
        if ((localObject2 != null) && (b()))
        {
          ((ISpriteBridge)localObject1).b((SpriteTaskParam)localObject2);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[playIntimateAction] play action:");
            ((StringBuilder)localObject1).append(((SpriteTaskParam)localObject2).f);
            QLog.d("[cmshow]ApolloIntimateActionPlayController", 2, ((StringBuilder)localObject1).toString());
          }
          long l = BaseApplicationImpl.getApplication().getSharedPreferences("CmshowIntimateAction_sp", 4).getLong("timestamp", 0L) / 1000L;
          ApolloDtReportUtil.a("aio", "sprite_intimateRelation", "expose", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(paramQQAppInterface)).b(ApolloDtReportUtil.a(paramSessionInfo.a)).c(paramSessionInfo.b).f(String.valueOf(((SpriteTaskParam)localObject2).f)).b(Integer.valueOf(i)).a(Long.valueOf(l)).a());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] hasUnreadAction");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("[cmshow]ApolloIntimateActionPlayController", 2, "[playIntimateAction] sessionInfo or app is null or not C2C,return.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloIntimateActionPlayController
 * JD-Core Version:    0.7.0.1
 */