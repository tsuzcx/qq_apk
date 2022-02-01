package com.tencent.mobileqq.apollo.game.process;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycleMgr;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportReceiver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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
  public static boolean a = false;
  public static boolean b = false;
  private CmGameLifeCycleMgr a;
  
  public CmGameServerQIPCModule(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLifeCycleMgr = new CmGameLifeCycleMgr();
  }
  
  public static CmGameServerQIPCModule a()
  {
    return CmGameServerQIPCModule.CmgameServerClass.a();
  }
  
  public static void a()
  {
    CmGameServerQIPCModule localCmGameServerQIPCModule = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCServerHelper.getInstance().register(localCmGameServerQIPCModule);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    int i;
    if ("action_open_cmshow_2d".equals(paramString))
    {
      i = 0;
    }
    else
    {
      if (!"action_open_cmshow_3d".equals(paramString)) {
        return;
      }
      i = 1;
    }
    int j = ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "")).getApolloUserStatus();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openCMShowIfNeed apolloUserStatus ");
    localStringBuilder.append(j);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 2, localStringBuilder.toString());
    if (j == 0) {
      ((ApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramString, i, new CmGameServerQIPCModule.2(this, i));
    }
  }
  
  public CmGameLifeCycle a(int paramInt)
  {
    CmGameLifeCycleMgr localCmGameLifeCycleMgr = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLifeCycleMgr;
    if (localCmGameLifeCycleMgr != null) {
      return localCmGameLifeCycleMgr.a(paramInt);
    }
    return null;
  }
  
  public CmGameLifeCycleMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLifeCycleMgr;
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
    QIPCServerHelper.getInstance().callClient(LocalMultiProcConfig.PROCESS_NAME, "cm_game_client_module", "action_dress_changed", (Bundle)localObject, new CmGameServerQIPCModule.3(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpen", paramBoolean);
    localBundle.putString("key_game_friUin", paramString);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_update_audio_status", localBundle, null);
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
    label514:
    label516:
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
        int i;
        if ("action_get_accountInfo".equals(paramString))
        {
          i = paramBundle.getInt("type");
          paramString = paramBundle.getString("uin");
          CmGameCmdChannel.a((AppInterface)localObject).a(paramInt, paramString, i);
          return null;
        }
        if ("onGameCheckStart".equals(paramString)) {
          return null;
        }
        bool = "onDownloadGameResDown".equals(paramString);
        if (bool)
        {
          if (!QLog.isColorLevel()) {
            break label508;
          }
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "[cmshow]apollo_cmGame_", " ACTION_START_CHECKER_ONDOWNLOADGAMERESDOWN" });
          break label508;
          paramString = (StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (paramString == null) {
            break label514;
          }
          if (paramString.game == null) {
            return null;
          }
          ApolloGameUtil.a((QQAppInterface)localObject, paramString);
          return null;
        }
        if ("game_activity_lifecycle".equals(paramString))
        {
          paramInt = paramBundle.getInt("gameId");
          i = paramBundle.getInt("status");
          int j = paramBundle.getInt("activityId");
          paramString = paramBundle.getSerializable("para");
          if ((paramString == null) || (!(paramString instanceof StartCheckParam))) {
            break label516;
          }
          paramString = (StartCheckParam)paramString;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLifeCycleMgr != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameLifeCycleMgr.a(paramInt, i, j, paramString);
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
          if (("action_open_cmshow_2d".equals(paramString)) || ("action_open_cmshow_3d".equals(paramString)))
          {
            paramBundle = new StringBuilder();
            paramBundle.append("action: ");
            paramBundle.append(paramString);
            QLog.i("cmgame_process.CmGameServerQIPCModule", 2, paramBundle.toString());
            a((QQAppInterface)localObject, paramString);
            return null;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameServerQIPCModule", 1, paramString, new Object[0]);
      }
      return null;
      label508:
      if (paramBundle == null)
      {
        return null;
        return null;
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule
 * JD-Core Version:    0.7.0.1
 */