package com.tencent.mobileqq.apollo.utils;

import akvv;
import akwd;
import alud;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import azri;
import bdin;
import bdug;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class ApolloGameUtil$CmStartTask
  implements Runnable
{
  public WeakReference<QQAppInterface> a;
  public WeakReference<CmGameStartChecker.StartCheckParam> b;
  
  public ApolloGameUtil$CmStartTask(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramStartCheckParam);
  }
  
  public void a(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramStartCheckParam);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface;
    CmGameStartChecker.StartCheckParam localStartCheckParam;
    if ((this.a != null) && (this.a.get() != null) && (this.b != null) && (this.b.get() != null))
    {
      localQQAppInterface = (QQAppInterface)this.a.get();
      localStartCheckParam = (CmGameStartChecker.StartCheckParam)this.b.get();
      if ((localQQAppInterface != null) && (localStartCheckParam != null) && (akwd.a(localQQAppInterface, localStartCheckParam))) {}
    }
    else
    {
      return;
    }
    localStartCheckParam.notFullScreen = ApolloUtil.b();
    boolean bool2 = akwd.a(localQQAppInterface.getApp());
    boolean bool1;
    label114:
    Object localObject2;
    if ((localStartCheckParam.game == null) && (!localStartCheckParam.isRequestConf))
    {
      bool1 = true;
      QLog.d("ApolloGameUtil", 1, new Object[] { "[CmStartTask] isGameProcessOn=", Boolean.valueOf(bool2), ", reqConf=", Boolean.valueOf(bool1) });
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("param_gameId", String.valueOf(localStartCheckParam.gameId));
      ((HashMap)localObject2).put("param_src", String.valueOf(localStartCheckParam.src));
      if (!bool1) {
        break label351;
      }
    }
    label351:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ((HashMap)localObject2).put("param_reqConf", localObject1);
      azri.a(localQQAppInterface.getApp()).a(localQQAppInterface.getCurrentAccountUin(), "cmgame_data_req_conf", true, 0L, 0L, (HashMap)localObject2, "", false);
      if (!bool1) {
        break label371;
      }
      if (!bdin.d(localQQAppInterface.getApp())) {
        break label358;
      }
      localObject1 = (bdug)localQQAppInterface.a(71);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_get_game_detail_from", 3);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(localStartCheckParam.gameId));
      ((bdug)localObject1).a(localArrayList, (Bundle)localObject2);
      localStartCheckParam.isRequestConf = true;
      if (bool2) {
        break;
      }
      localObject1 = (WebProcessManager)localQQAppInterface.getManager(13);
      if (localObject1 == null) {
        break;
      }
      ((WebProcessManager)localObject1).a(100);
      return;
      bool1 = false;
      break label114;
    }
    label358:
    ApolloGameUtil.a(alud.a(2131700766), 1, BaseApplicationImpl.getContext());
    return;
    label371:
    if (localStartCheckParam.statMap == null) {
      localStartCheckParam.statMap = new ConcurrentHashMap();
    }
    localStartCheckParam.statMap.clear();
    long l2 = SystemClock.uptimeMillis();
    localStartCheckParam.statMap.put("click_time", Long.valueOf(l2));
    localObject1 = localStartCheckParam.statMap;
    long l1;
    if (bool2) {
      l1 = 1L;
    }
    for (;;)
    {
      ((ConcurrentHashMap)localObject1).put("game_process_on", Long.valueOf(l1));
      QLog.d("CmGameStat", 1, new Object[] { "cmgame, click time=", Long.valueOf(l2) });
      localStartCheckParam.mCreateTs = System.currentTimeMillis();
      if (bool2)
      {
        localStartCheckParam.mLoadingOnMainProcess = false;
        akvv.a().a(localStartCheckParam);
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
        ((Intent)localObject1).putExtra("extra_startcheckparam", localStartCheckParam);
        ((Intent)localObject1).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject1).setComponent(new ComponentName(MobileQQ.getContext(), "com.tencent.mobileqq.webprocess.WebProcessReceiver"));
      }
      try
      {
        QLog.i("ApolloGameUtil", 2, "Send action launch_cmgame.");
        BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
        QLog.d("CmGameStat", 1, "cmgame_ipc_start");
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("param_gameId", String.valueOf(localStartCheckParam.gameId));
        ((HashMap)localObject2).put("param_src", String.valueOf(localStartCheckParam.src));
        if (bool2)
        {
          localObject1 = "1";
          ((HashMap)localObject2).put("param_processOn", localObject1);
          azri.a(localQQAppInterface.getApp()).a(localQQAppInterface.getCurrentAccountUin(), "cmgame_ipc_start", true, 0L, 0L, (HashMap)localObject2, "", false);
          return;
          l1 = 0L;
          continue;
          localStartCheckParam.mLoadingOnMainProcess = true;
          akwd.b(localStartCheckParam);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
          continue;
          String str = "0";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.CmStartTask
 * JD-Core Version:    0.7.0.1
 */