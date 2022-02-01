package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class CardDrawerStrategy
  extends ApolloDrawerStrategy
{
  public CardDrawerStrategy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = 99;
    if (paramQQAppInterface != null)
    {
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_sp");
      localStringBuilder.append(paramQQAppInterface.getCurrentUin());
      int i = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt("hire_priority", 99);
      if (i > this.a) {
        this.a = (i + 1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CardDrawerStrategy", 2, "[CardDrawerStatus] onCreate ");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getUIHandler().post(new CardDrawerStrategy.1(this, paramQQAppInterface));
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
    if (localObject != null) {
      localObject = ((IApolloManagerService)((AppRuntime)localObject).getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("CardDrawerStatus.VOICE_CONTROL", paramBoolean).commit();
        return;
      }
      QLog.e("[cmshow]CardDrawerStrategy", 1, "[setVoicePermission] editor is null ");
      return;
    }
    QLog.e("[cmshow]CardDrawerStrategy", 1, "[setVoicePermission] sp is null ");
  }
  
  public static boolean c()
  {
    Object localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
    if (localObject != null) {
      localObject = ((IApolloManagerService)((AppRuntime)localObject).getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return ((SharedPreferences)localObject).getBoolean("CardDrawerStatus.VOICE_CONTROL", true);
    }
    QLog.e("[cmshow]CardDrawerStrategy", 1, "[getVoicePermission] sp is null ");
    return true;
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((paramSpriteDrawerInfoManager != null) && (paramAppInterface != null) && (paramContext != null))
    {
      if (!this.d) {
        return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
      }
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      IApolloResManager localIApolloResManager = ApolloResManagerFacade.a.a(Scene.FRIEND_CARD);
      paramContext = (QQAppInterface)paramAppInterface;
      paramAppInterface = localApolloManagerServiceImpl.getRandomAppearAction(localIApolloResManager, paramContext, paramAppInterface.getCurrentAccountUin(), new int[] { 2, 4 });
      if (paramAppInterface != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CardDrawerStrategy", 2, new Object[] { "CardDrawerStatus onExecAction actionId:", Integer.valueOf(paramAppInterface.actionId), ",actionType:", Integer.valueOf(paramAppInterface.actionType) });
        }
        a(paramContext);
        SpriteUtil.a(paramSpriteDrawerInfoManager, 12, paramAppInterface);
        return 0;
      }
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = -1;
      paramAppInterface.actionType = 0;
      SpriteUtil.a(paramSpriteDrawerInfoManager, 5, paramAppInterface);
      return 0;
    }
    QLog.e("[cmshow]CardDrawerStrategy", 1, "[onExecAction] null pointer");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.CardDrawerStrategy
 * JD-Core Version:    0.7.0.1
 */