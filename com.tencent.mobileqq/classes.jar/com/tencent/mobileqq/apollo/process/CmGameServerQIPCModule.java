package com.tencent.mobileqq.apollo.process;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureSoManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.CmGamePushItem;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.ApolloLoadResTask;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGamePushManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycleMgr;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportReceiver;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class CmGameServerQIPCModule
  extends QIPCModule
{
  public static boolean a;
  public static boolean b = false;
  private long jdField_a_of_type_Long;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameInitParams jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private CmGameLifeCycleMgr jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr = new CmGameLifeCycleMgr();
  private WeakReference<CmGameLoadingFragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean c;
  
  public CmGameServerQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static CmGameServerQIPCModule a()
  {
    return CmGameServerQIPCModule.CmgameServerClass.a();
  }
  
  public static void b()
  {
    CmGameServerQIPCModule localCmGameServerQIPCModule = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCServerHelper.getInstance().register(localCmGameServerQIPCModule);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr.a();
    }
    QLog.w("cmgame_process.CmGameServerQIPCModule", 1, "no running game.");
    return -1;
  }
  
  public CmGameLifeCycle a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr.a(paramInt);
    }
    return null;
  }
  
  public CmGameLifeCycleMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "closeAllGames");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr.a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          CmGameLifeCycle localCmGameLifeCycle = (CmGameLifeCycle)localList.get(i);
          if ((localCmGameLifeCycle != null) && (!CmGameUtil.a(localCmGameLifeCycle.a())) && (!CmGameUtil.a(localCmGameLifeCycle.a())))
          {
            CmGameClientQIPCModule.a(localCmGameLifeCycle.a());
            QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "closeAllGame gameId:" + localCmGameLifeCycle.a());
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", System.currentTimeMillis());
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_start_cmgame_direct", localBundle, null);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong, CmGameInitParams paramCmGameInitParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingCheckEnd cmGameInitParams:", paramCmGameInitParams });
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
    if (paramStartCheckParam != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    }
    this.jdField_a_of_type_Long = paramLong;
    if (paramLong != 0L) {
      ApolloGameUtil.a(paramStartCheckParam, true);
    }
    this.c = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (CmGameUtil.a(BaseApplicationImpl.getContext())))
    {
      paramStartCheckParam = new Bundle();
      paramStartCheckParam.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      paramStartCheckParam.putLong("ResultCode", this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
        paramStartCheckParam.putSerializable("CmGameInitParams", this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
      }
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_check_game_data", paramStartCheckParam, null);
    }
  }
  
  public void a(CmGameLoadingFragment paramCmGameLoadingFragment, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmGameLoadingFragment);
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingStart startCheckParam:", paramStartCheckParam });
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("CmShow onDressChanged uins.size:");
      if (paramArrayList == null) {
        break label80;
      }
    }
    label80:
    for (int i = paramArrayList.size();; i = 0)
    {
      QLog.i("cmgame_process.CmGameServerQIPCModule", 1, i);
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("key_dress_change_uin", paramArrayList);
      QIPCServerHelper.getInstance().callClient(LocalMultiProcConfig.PROCESS_NAME, "cm_game_client_module", "action_dress_changed", (Bundle)localObject, new CmGameServerQIPCModule.8(this));
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpen", paramBoolean);
    localBundle.putString("key_game_friUin", paramString);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_update_audio_status", localBundle, null);
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingCheckEnd startCheckParam:", paramStartCheckParam });
    }
    ApolloGameUtil.a(paramStartCheckParam, true);
    paramStartCheckParam = new Bundle();
    paramStartCheckParam.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    paramStartCheckParam.putLong("ResultCode", this.jdField_a_of_type_Long);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_game_loading_closed", paramStartCheckParam, null);
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "onCall main server action=" + paramString);
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject2 instanceof QQAppInterface)) {
      return null;
    }
    Object localObject1 = (QQAppInterface)localObject2;
    try
    {
      if ("action_aduio_query_voice_status".equals(paramString))
      {
        paramString = paramBundle.getString("key_game_friUin");
        paramBundle = (ApolloManagerServiceImpl)((AppRuntime)localObject2).getRuntimeService(IApolloManagerService.class, "all");
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("isOpen", paramBundle.getCmGameAudioManager().a(paramString));
        ((Bundle)localObject1).putBoolean("display", CmGameAudioManager.b);
        callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject1));
      }
      else if ("action_audio_exit_room".equals(paramString))
      {
        paramString = paramBundle.getString("key_game_friUin");
        ((ApolloManagerServiceImpl)((AppRuntime)localObject2).getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().c(paramString, 318);
      }
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameServerQIPCModule", 1, paramString, new Object[0]);
    }
    int i;
    if ("action_aduio_enter_room".equals(paramString))
    {
      paramString = paramBundle.getString("key_game_friUin");
      boolean bool = paramBundle.getBoolean("key_open_voice", false);
      paramBundle = ((ApolloManagerServiceImpl)((AppRuntime)localObject2).getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager();
      if ((bool) || ((CmGameAudioManager.jdField_a_of_type_Boolean) && (!paramBundle.b()))) {
        paramBundle.b(paramString, 318);
      }
    }
    else if ("action_voice_switch".equals(paramString))
    {
      paramString = paramBundle.getString("key_game_friUin");
      ((ApolloManagerServiceImpl)((AppRuntime)localObject2).getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().a(paramString, 318);
    }
    else if ("action_chanel_req".equals(paramString))
    {
      CmGameCmdChannel.a((QQAppInterface)localObject1).a(paramBundle.getString("cmd"), paramBundle.getString("reqData"), paramBundle.getBoolean("async"), paramInt, paramBundle.getInt("gameId"));
    }
    else if ("action_get_accountInfo".equals(paramString))
    {
      i = paramBundle.getInt("type");
      paramString = paramBundle.getString("uin");
      CmGameCmdChannel.a((QQAppInterface)localObject1).a(paramInt, paramString, i);
    }
    else if ("action_loadyoutu".equals(paramString))
    {
      paramString = new ReadInJoyCameraCaptureSoManager((QQAppInterface)localObject1, BaseApplicationImpl.getContext());
      b = true;
      paramString.a(new CmGameServerQIPCModule.1(this, paramInt));
      paramString.a();
    }
    else if ("onGameCheckStart".equals(paramString))
    {
      if (!QLog.isColorLevel()) {
        break label2220;
      }
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONGAMECHECKSTART" });
      break label2220;
      paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
      if (paramString == null) {
        return null;
      }
      if (CmGameUtil.a(paramString.gameId))
      {
        if (!QLog.isColorLevel()) {
          break label2226;
        }
        QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "the game is IsLand");
        break label2226;
      }
      ApolloGameUtil.a((QQAppInterface)localObject1, paramString);
    }
    else if ("onDownloadGameResDown".equals(paramString))
    {
      if (!QLog.isColorLevel()) {
        break label2228;
      }
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONDOWNLOADGAMERESDOWN" });
    }
    label2213:
    label2218:
    label2220:
    label2226:
    label2228:
    while (paramBundle != null)
    {
      paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
      if ((paramString == null) || (paramString.game == null)) {
        break label2234;
      }
      ApolloGameUtil.b((QQAppInterface)localObject1, paramString);
      break label2218;
      int j;
      if ("game_activity_lifecycle".equals(paramString))
      {
        paramInt = paramBundle.getInt("gameId");
        i = paramBundle.getInt("status");
        j = paramBundle.getInt("activityId");
        paramString = paramBundle.getSerializable("para");
        if ((paramString == null) || (!(paramString instanceof CmGameStartChecker.StartCheckParam))) {
          break label2213;
        }
      }
      for (paramString = (CmGameStartChecker.StartCheckParam)paramString; this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr != null; paramString = null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLifeCycleMgr.a(paramInt, i, j, paramString);
        break;
        if ("action_get_action_data".equals(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_GET_ACTION_DATA params:" + paramBundle });
          }
          ThreadManager.post(new CmGameServerQIPCModule.2(this, (QQAppInterface)localObject1, paramBundle.getString("reqData"), paramInt), 5, null, true);
          break;
        }
        if ("action_update_game_push".equals(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_UPDATE_GAME_PUSH params:" + paramBundle);
          }
          paramString = (CmGamePushItem)paramBundle.getSerializable("CmGamePushItem");
          if (paramString == null) {
            break;
          }
          ((ApolloManagerServiceImpl)((AppRuntime)localObject2).getRuntimeService(IApolloManagerService.class, "all")).getCmGamePushManager().a(paramString);
          break;
        }
        if ("action_query_check_game_data".equals(paramString))
        {
          paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_QUERY_CHECK_GAME_DATA params:" + paramString);
          }
          if (paramString == null) {
            break;
          }
          paramBundle = new Bundle();
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs != paramString.mCreateTs))
          {
            paramBundle.putInt("result", -1);
            paramBundle.putSerializable("StartCheckParam", paramString);
            callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
          }
          while (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            paramString = (CmGameLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramString == null) {
              break;
            }
            paramString.a(this.c);
            break;
            if (this.c)
            {
              paramBundle.putInt("result", 0);
              paramBundle.putLong("ResultCode", this.jdField_a_of_type_Long);
              if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
                paramBundle.putSerializable("CmGameInitParams", this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
              }
              paramBundle.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
              callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
            }
            else
            {
              QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_QUERY_CHECK_GAME_DATA mCheckGameEnd false");
            }
          }
        }
        if ("action_on_game_activity_closed".equals(paramString))
        {
          paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_ON_GAME_ACTIVITY_CLOSED params:" + paramString);
          }
          if ((paramString == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null)) {
            break;
          }
          paramString = (CmGameLoadingFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((paramString == null) || (paramString.getActivity() == null)) {
            break;
          }
          paramString.a(100L);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_ON_GAME_ACTIVITY_CLOSED close loadingView");
          break;
        }
        if ("action_render_view_get_initavatar_js".equals(paramString))
        {
          paramBundle.setClassLoader(IPCSpriteContext.class.getClassLoader());
          ThreadManagerV2.excute(new CmGameServerQIPCModule.3(this, (IPCSpriteContext)paramBundle.getParcelable("IPCSpriteContext"), paramInt), 16, null, false);
          break;
        }
        if ("action_render_view_get_base_data".equals(paramString))
        {
          ApolloActionHelperImpl.checkBasicActionExit((QQAppInterface)localObject1);
          paramString = new Bundle();
          paramBundle = (ApolloManagerServiceImpl)((AppRuntime)localObject2).getRuntimeService(IApolloManagerService.class, "all");
          paramString.putString("sApolloBaseScriptId", ApolloConstant.H);
          paramString.putBoolean("sDisableCreateRenderThread", paramBundle.isDisableCreateRenderThread());
          paramString.putBoolean("sApolloEngineLockEnable", paramBundle.isApolloEngineLockEnable());
          callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
          break;
        }
        Object localObject3;
        if ("action_init_cmshow_data".equals(paramString))
        {
          paramString = paramBundle.getString("selfUin");
          paramBundle = paramBundle.getString("friendUin");
          QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA selfUin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString) + " friendUin:" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramBundle));
          localObject2 = (ApolloManagerServiceImpl)((AppRuntime)localObject2).getRuntimeService(IApolloManagerService.class, "all");
          localObject3 = (ApolloExtensionHandlerImpl)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
          Object localObject4 = ((ApolloManagerServiceImpl)localObject2).getApolloBaseInfo(paramString);
          ApolloBaseInfo localApolloBaseInfo = ((ApolloManagerServiceImpl)localObject2).getApolloBaseInfo(paramBundle);
          ArrayList localArrayList = new ArrayList();
          if ((!TextUtils.isEmpty(paramString)) && ((localObject4 == null) || (((ApolloBaseInfo)localObject4).apolloLocalTS != ((ApolloBaseInfo)localObject4).apolloServerTS))) {
            localArrayList.add(paramString);
          }
          if ((!TextUtils.isEmpty(paramBundle)) && ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS))) {
            localArrayList.add(paramBundle);
          }
          if (!localArrayList.isEmpty())
          {
            QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA but ApolloBaseInfo need update size:" + localArrayList.size());
            localObject4 = new String[localArrayList.size()];
            i = 0;
            while (i < localArrayList.size())
            {
              localObject4[i] = ((String)localArrayList.get(i));
              i += 1;
            }
            ((ApolloExtensionHandlerImpl)localObject3).a(new CmGameServerQIPCModule.4(this, localArrayList, (ApolloManagerServiceImpl)localObject2, (QQAppInterface)localObject1, paramString, paramBundle, paramInt));
            ((ApolloExtensionHandlerImpl)localObject3).a((String[])localObject4);
            break;
          }
          i = ((ApolloManagerServiceImpl)localObject2).getCmShowStatusNoCareSelfStatus((QQAppInterface)localObject1, paramString, true);
          j = ((ApolloManagerServiceImpl)localObject2).getCmShowStatusNoCareSelfStatus((QQAppInterface)localObject1, paramBundle, true);
          paramString = new Bundle();
          paramString.putInt("selfUinStatus", i);
          paramString.putInt("friendUinStatus", j);
          callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
          break;
        }
        if ("action_render_view_play_action".equals(paramString))
        {
          long l = System.currentTimeMillis();
          QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "CmShow ACTION_RENDER_VIEW_PLAY_ACTION");
          paramBundle.setClassLoader(IPCSpriteContext.class.getClassLoader());
          paramString = (IPCSpriteContext)paramBundle.getParcelable("IPCSpriteContext");
          paramBundle = (PlayActionConfig)paramBundle.getParcelable("PlayActionConfig");
          if ((paramBundle == null) || (paramString == null))
          {
            QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_RENDER_VIEW_PLAY_ACTION playActionConfig == null || ipcSpriteContext == null");
            return null;
          }
          i = paramBundle.a;
          j = paramBundle.b;
          localObject2 = new SpriteTaskParam();
          ((SpriteTaskParam)localObject2).f = i;
          ThreadManagerV2.excute(new CmGameServerQIPCModule.5(this, (QQAppInterface)localObject1, i, (SpriteTaskParam)localObject2, paramString, j, paramBundle, l, paramInt), 16, null, false);
          break;
        }
        if ("action_render_view_preload_res".equals(paramString))
        {
          QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "CmShow ACTION_RENDER_VIEW_PRELOAD_RES");
          paramString = paramBundle.getIntArray("actionIds");
          if ((paramString == null) || (paramString.length < 0))
          {
            QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_RENDER_VIEW_PRELOAD_RES actionIds==null");
            callbackResult(paramInt, EIPCResult.createResult(-1, null));
            break;
          }
          paramBundle = new ArrayList();
          i = 0;
          while (i < paramString.length)
          {
            localObject2 = SpriteUtil.a((QQAppInterface)localObject1, paramString[i]);
            localObject3 = new ApolloResDownloaderImpl.ApolloLoadResTask(3, paramString[i]);
            if (localObject2 != null) {
              ((ApolloResDownloaderImpl.ApolloLoadResTask)localObject3).c = ((ApolloActionData)localObject2).actionType;
            }
            paramBundle.add(localObject3);
            i += 1;
          }
          ApolloResDownloaderImpl.downloadApolloResInner((AppInterface)localObject1, "", new CmGameServerQIPCModule.6(this, paramInt), paramBundle, false);
          break;
        }
        if ("action_cmshow_tracereport".equals(paramString))
        {
          TraceReportReceiver.a(paramBundle.getString("action"), paramBundle.getBundle("bundle"));
          break;
        }
        if ("action_render_view_open_store".equals(paramString))
        {
          paramBundle = paramBundle.getString("url");
          localObject1 = (IApolloUtil)QRoute.api(IApolloUtil.class);
          if (BaseActivity.sTopActivity != null) {}
          for (paramString = BaseActivity.sTopActivity;; paramString = BaseApplicationImpl.getContext())
          {
            ((IApolloUtil)localObject1).openApolloStore(paramString, null, null, paramBundle, null);
            QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_OPEN_STORE url:" + paramBundle);
            callbackResult(paramInt, EIPCResult.createResult(0, null));
            break;
          }
        }
        if (!"action_render_view_change_mode".equals(paramString)) {
          break;
        }
        i = paramBundle.getInt("mode");
        paramString = (ApolloExtensionHandlerImpl)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (i == 2) {}
        for (i = 1;; i = 0)
        {
          paramString.a("cmshow_sdk", i, new CmGameServerQIPCModule.7(this, paramInt));
          break;
        }
      }
      return null;
      if (paramBundle != null) {
        break;
      }
      return null;
      return null;
    }
    return null;
    label2234:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule
 * JD-Core Version:    0.7.0.1
 */