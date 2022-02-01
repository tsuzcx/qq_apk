package com.tencent.mobileqq.apollo.game.process;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.ApolloGameResManager;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycleMgr;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import eipc.EIPCResult;
import java.util.ArrayList;

public class CmGameServerQIPCModule
  extends QIPCModule
{
  public static boolean a;
  private CmGameLifeCycleMgr b = new CmGameLifeCycleMgr();
  
  public CmGameServerQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static CmGameServerQIPCModule b()
  {
    return CmGameServerQIPCModule.CmgameServerClass.a();
  }
  
  public static void c()
  {
    CmGameServerQIPCModule localCmGameServerQIPCModule = b();
    if (!a)
    {
      QIPCServerHelper.getInstance().register(localCmGameServerQIPCModule);
      a = true;
    }
  }
  
  public CmGameLifeCycle a(int paramInt)
  {
    CmGameLifeCycleMgr localCmGameLifeCycleMgr = this.b;
    if (localCmGameLifeCycleMgr != null) {
      return localCmGameLifeCycleMgr.a(paramInt);
    }
    return null;
  }
  
  public CmGameLifeCycleMgr a()
  {
    return this.b;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CmShow onDressChanged uins.size:");
      int i;
      if (paramArrayList != null) {
        i = paramArrayList.size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putStringArrayList("key_dress_change_uin", paramArrayList);
    QIPCServerHelper.getInstance().callClient(LocalMultiProcConfig.PROCESS_NAME, "cm_game_client_module", "action_dress_changed", (Bundle)localObject, new CmGameServerQIPCModule.2(this));
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall main server action=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    for (;;)
    {
      try
      {
        boolean bool = "action_chanel_req".equals(paramString);
        if (bool)
        {
          CmGameCmdChannel.a((AppInterface)localObject).a(paramBundle.getString("cmd"), paramBundle.getString("reqData"), paramBundle.getBoolean("async"), paramInt, paramBundle.getInt("gameId"));
          return null;
        }
        bool = "onDownloadGameResDown".equals(paramString);
        if (bool)
        {
          if (!QLog.isColorLevel()) {
            break label391;
          }
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "[cmshow]apollo_cmGame_", " ACTION_START_CHECKER_ONDOWNLOADGAMERESDOWN" });
          break label391;
          paramString = (StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (paramString == null) {
            break label397;
          }
          if (paramString.game == null) {
            return null;
          }
          ApolloGameResManager.a((QQAppInterface)localObject, paramString);
          return null;
        }
        if ("game_activity_lifecycle".equals(paramString))
        {
          paramInt = paramBundle.getInt("gameId");
          int i = paramBundle.getInt("status");
          int j = paramBundle.getInt("activityId");
          paramString = paramBundle.getSerializable("para");
          if ((paramString == null) || (!(paramString instanceof StartCheckParam))) {
            break label399;
          }
          paramString = (StartCheckParam)paramString;
          if (this.b != null)
          {
            this.b.a(paramInt, i, j, paramString);
            return null;
          }
        }
        else
        {
          if ("action_get_action_data".equals(paramString))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append(" ACTION_GET_ACTION_DATA params:");
              paramString.append(paramBundle);
              QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "[cmshow]apollo_cmGame_", paramString.toString() });
            }
            ThreadManager.post(new CmGameServerQIPCModule.1(this, (QQAppInterface)localObject, paramBundle.getString("reqData"), paramInt), 5, null, true);
            return null;
          }
          if ("action_cmshow_tracereport".equals(paramString))
          {
            TraceReportReceiver.a(paramBundle.getString("action"), paramBundle.getBundle("bundle"));
            return null;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameServerQIPCModule", 1, paramString, new Object[0]);
      }
      return null;
      label391:
      if (paramBundle == null)
      {
        return null;
        label397:
        return null;
        label399:
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule
 * JD-Core Version:    0.7.0.1
 */