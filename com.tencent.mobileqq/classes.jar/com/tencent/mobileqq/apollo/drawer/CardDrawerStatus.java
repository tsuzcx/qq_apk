package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ypd;

public class CardDrawerStatus
  extends ApolloDrawerStatus
{
  public CardDrawerStatus(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = 99;
    if (paramQQAppInterface != null)
    {
      int i = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.c(), 0).getInt("hire_priority", 99);
      if (i > this.a) {
        this.a = (i + 1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardDrawerStatus", 2, "[CardDrawerStatus] onCreate ");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getUIHandler().post(new ypd(this, paramQQAppInterface));
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = ApolloManager.a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("CardDrawerStatus.VOICE_CONTROL", paramBoolean).commit();
        return;
      }
      QLog.e("CardDrawerStatus", 1, "[setVoicePermission] editor is null ");
      return;
    }
    QLog.e("CardDrawerStatus", 1, "[setVoicePermission] sp is null ");
  }
  
  public static boolean a()
  {
    SharedPreferences localSharedPreferences = ApolloManager.a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("CardDrawerStatus.VOICE_CONTROL", true);
    }
    QLog.e("CardDrawerStatus", 1, "[getVoicePermission] sp is null ");
    return true;
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((paramSpriteDrawerInfoManager == null) || (paramAppInterface == null) || (paramContext == null))
    {
      QLog.e("CardDrawerStatus", 1, "[onExecAction] null pointer");
      return 0;
    }
    paramContext = ((ApolloManager)paramAppInterface.getManager(152)).a((QQAppInterface)paramAppInterface, paramAppInterface.getCurrentAccountUin(), new int[] { 2, 4 });
    if (paramContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardDrawerStatus", 2, new Object[] { "CardDrawerStatus onExecAction actionId:", Integer.valueOf(paramContext.actionId), ",actionType:", Integer.valueOf(paramContext.actionType) });
      }
      a((QQAppInterface)paramAppInterface);
      SpriteUtil.a(paramSpriteDrawerInfoManager, 12, paramContext);
      return 0;
    }
    paramAppInterface = new ApolloActionData();
    paramAppInterface.actionId = -1;
    paramAppInterface.actionType = 0;
    SpriteUtil.a(paramSpriteDrawerInfoManager, 5, paramAppInterface);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.CardDrawerStatus
 * JD-Core Version:    0.7.0.1
 */