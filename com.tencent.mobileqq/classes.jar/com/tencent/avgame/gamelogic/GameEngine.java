package com.tencent.avgame.gamelogic;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.avgame.app.IAVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.gamelogic.controller.GameController;
import com.tencent.avgame.gamelogic.controller.HeartBeatController;
import com.tencent.avgame.gamelogic.controller.RoomController;
import com.tencent.avgame.gamelogic.controller.StatusMonitor;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistCallback;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistManager;
import com.tencent.avgame.gamelogic.controller.SyncController;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.globalmanage.GlobalExitRoomDialog;
import com.tencent.avgame.gamelogic.handler.GamePlayHandler;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener;
import com.tencent.avgame.gamelogic.listener.GameResultListener;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.GameStatusListener;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.avgame.localvoicerecog.api.IAVGameVoiceRecog;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.qav.MultiOperatorImplForGame;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.qav.audio.AvGameMusicPlayer;
import com.tencent.avgame.qav.audio.AvGameSysMusicPlayer;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.report.CJSurvivalReporterUtil;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qav.QavSDK;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class GameEngine
  extends IGameEngine
{
  private int jdField_a_of_type_Int = 0;
  protected AVGameUIEventCallback a;
  private GameController jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController;
  private HeartBeatController jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController;
  private RoomController jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController;
  private StatusMonitor jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor;
  private SurvivalAssistManager jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager;
  private SyncController jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController;
  private EngineData jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
  private BaseAVGameAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface;
  private List<GameRoomStatusListener> jdField_a_of_type_JavaUtilList;
  private List<GameStatusListener> b;
  private List<GameResultListener> c;
  private List<GameActivityLifeCycleListener> d;
  
  private GameEngine()
  {
    this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback = new GameEngine.5(this);
  }
  
  public static GameEngine a()
  {
    return GameEngine.INNER.a;
  }
  
  private void a(EngineData paramEngineData, ITopic paramITopic, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "[playEffect] survival: ", Boolean.valueOf(paramEngineData.f()), ", avRoom: ", Boolean.valueOf(paramEngineData.h()), ", topic:", paramITopic, ", effect: ", paramString });
    }
    if ((paramEngineData.f()) && (!paramEngineData.h()))
    {
      AvGameSysMusicPlayer.a().a(paramITopic, paramString);
      return;
    }
    AvGameMusicPlayer.a().a(paramITopic, paramString);
  }
  
  private void b(BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface = paramBaseAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData = new EngineData();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.b = new ArrayList(4);
    this.c = new ArrayList(1);
    this.d = new ArrayList(1);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController = new SyncController(paramBaseAVGameAppInterface);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController = new RoomController(paramBaseAVGameAppInterface, this, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController, this);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController = new GameController(paramBaseAVGameAppInterface, this, this, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController, this);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController = new HeartBeatController(paramBaseAVGameAppInterface, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController, this, this);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor = new StatusMonitor(paramBaseAVGameAppInterface, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController, this, this);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager = new SurvivalAssistManager();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager.a();
    a(this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager);
  }
  
  private void d(EngineData paramEngineData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "[playBgMusic] survival: ", Boolean.valueOf(paramEngineData.f()), ", avRoom: ", Boolean.valueOf(paramEngineData.h()), ", musicType: ", Integer.valueOf(paramInt) });
    }
    if ((paramEngineData.f()) && (!paramEngineData.h()))
    {
      AvGameSysMusicPlayer.a().a(paramInt, paramEngineData.f());
      return;
    }
    AvGameMusicPlayer.a().a(paramInt, paramEngineData.f());
  }
  
  private void k(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "[stopPlay] survival: ", Boolean.valueOf(paramEngineData.f()), ", avRoom: ", Boolean.valueOf(paramEngineData.h()) });
    }
    if ((paramEngineData.f()) && (!paramEngineData.h()))
    {
      AvGameSysMusicPlayer.a().b();
      return;
    }
    AvGameMusicPlayer.a().c();
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController.b();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.c();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.c.clear();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.b();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager.b();
    if (IAVGameBusinessCtrl.f()) {
      return;
    }
    IAVGameBusinessCtrl.a().b(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().getPlayers().size();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.d();
  }
  
  public SurvivalAssistCallback a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager.a(paramInt);
  }
  
  public EngineData a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
  }
  
  public BaseAVGameAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface;
  }
  
  public void a()
  {
    if (IAVGameBusinessCtrl.f()) {
      return;
    }
    IAVGameBusinessCtrl.a().a(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    GameRoomHandler localGameRoomHandler = (GameRoomHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.a);
    Object localObject = a().a();
    if (localObject != null)
    {
      localGameRoomHandler.a(a().a(), a().a().owner, ((GameItem)localObject).jdField_a_of_type_Int, paramInt2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startGameMatchV2 no gameItem ");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.d("avgame_logic.GameEngine", 2, ((StringBuilder)localObject).toString());
    if (paramInt1 > 0) {
      localGameRoomHandler.a(a().a(), a().a().owner, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ((GamePlayHandler)a().getBusinessHandler(HandlerFactory.c)).a(a().getLongAccountUin(), a().b(), paramInt1, paramInt2, paramInt3, b());
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((GameActivityLifeCycleListener)localIterator.next()).a(paramInt, paramActivity);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, EngineData paramEngineData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramInt, paramString1, paramString2, paramEngineData);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGameRoomList roomId = ");
      localStringBuilder.append(paramLong);
      QLog.i("avgame_logic.GameEngine", 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.b(paramLong);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGameShareLink  roomId: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" shareUin: ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" shareName: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" shareType: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" gameId: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" gameType: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" pbMark");
    localStringBuilder.append(paramLong3);
    QLog.d("avgame_logic.GameEngine", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController.a(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeUserStatus roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" userUin =");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" userStatus =");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" from = ");
      localStringBuilder.append(paramInt2);
      QLog.i("avgame_logic.GameEngine", 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.b(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).a(paramLong, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramLong, paramString1, paramBoolean, paramString2, paramInt);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGameRoomInfo roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" fromSync=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" fromEnter=");
      localStringBuilder.append(paramBoolean2);
      QLog.i("avgame_logic.GameEngine", 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramLong, paramBoolean);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramEngineData);
    }
  }
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramEngineData, paramInt);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramEngineData, paramInt);
    }
  }
  
  public void a(EngineData paramEngineData, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).a(paramEngineData, paramString);
    }
  }
  
  public void a(EngineData paramEngineData, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, false);
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a())
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush NotPlayedYet return.");
    }
    else
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((GameStatusListener)localIterator.next()).a(paramEngineData, paramBoolean);
      }
    }
    if (paramEngineData.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush disable aec mode");
      ((MultiOperatorImplForGame)QavSDK.a().a()).a(0);
    }
    k(paramEngineData);
    AVGameNodeReportUtil.d();
    p();
  }
  
  public void a(RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramRoomInfo, true);
  }
  
  public void a(GameActivityLifeCycleListener paramGameActivityLifeCycleListener)
  {
    this.d.add(paramGameActivityLifeCycleListener);
  }
  
  public void a(GameResultListener paramGameResultListener)
  {
    this.c.add(paramGameResultListener);
  }
  
  public void a(GameRoomStatusListener paramGameRoomStatusListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramGameRoomStatusListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramGameRoomStatusListener);
    }
  }
  
  public void a(GameStatusListener paramGameStatusListener)
  {
    if (!this.b.contains(paramGameStatusListener)) {
      this.b.add(paramGameStatusListener);
    }
  }
  
  public void a(BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    b(paramBaseAVGameAppInterface);
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {
      return;
    }
    ((IAVGameAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface).a().b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRecogCallback gameStatus:");
      ((StringBuilder)localObject).append(a().a());
      QLog.d("avgame_logic.GameEngine", 2, ((StringBuilder)localObject).toString());
    }
    if (a().a() != 4) {
      a(a().e(), paramString, paramInt);
    }
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    if (a().a().a() != null) {
      localObject = a().a().a().b();
    } else {
      localObject = "";
    }
    localAVGamePerfReporter.a(true, paramString, (String)localObject, paramInt, a().b(), a().getCurrentAccountUin(), AVGamePerfReporter.a().a(), a().a());
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramString, paramInt, paramEngineData);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramString, paramInt, paramEngineData);
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
    }
  }
  
  public void a(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramString, paramEngineData);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {
      return;
    }
    ((IAVGameAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface).a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b(), paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramHashMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = a().j();
    if (i > 0) {
      ((GameRoomHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(i, paramBoolean);
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a(paramBoolean, paramInt, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean1, paramInt, paramString, paramBoolean2);
    }
    if ((paramBoolean1) && (!g())) {
      AvGameSysMusicPlayer.a().a();
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.g())
    {
      int i = CJSurvivalReporterUtil.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exitGameRoom CJSurvivalFestivalReporter refer = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("avgame_logic.GameEngine", 1, ((StringBuilder)localObject).toString());
      if (i == 2)
      {
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.h()) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_game_quit", "survival_game_quit", i, 0, String.valueOf(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.p()), CJSurvivalReporterUtil.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData), String.valueOf(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.k()));
      }
      else if (i == 1)
      {
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.h()) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_game_quit", "survival_game_quit", i, 0, "", "", "", String.valueOf(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.k()));
      }
    }
    ProcessMonitor.a().b("exitGameRoom");
    if (IAVGameBusinessCtrl.a() != null)
    {
      l = System.currentTimeMillis();
      AVGamePerfReporter.a().a(0, a().a(), a().b(), 0L);
      AVGameHandler.a().a().post(new GameEngine.1(this, l));
    }
    a(paramInt);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.b();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager.c();
    AvGameSysMusicPlayer.a().c();
    long l = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    if ((l != 0L) && (!paramBoolean1)) {
      b(l, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.f()) {
      a().a(paramBoolean2);
    }
    ((IAVGameAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface).a().a(0, String.valueOf(l));
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    ThreadManager.getUIHandler().postDelayed(new GameEngine.2(this), 1000L);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitGameRoom svrAlreadyExit = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" exitType =");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" roomId:");
    ((StringBuilder)localObject).append(l);
    QLog.i("avgame_logic.GameEngine", 1, ((StringBuilder)localObject).toString(), new Throwable("not crash, print stack"));
    if (l != 0L)
    {
      if ((paramInt == 2) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11))
      {
        if (7 == paramInt) {
          localObject = "0X800B046";
        } else {
          localObject = "0X800B045";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt);
        ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, localStringBuilder.toString(), "", "", "");
      }
      AVGameNodeReportUtil.b(AVGameNodeReportUtil.a(paramInt));
      QualityReporter.a();
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean1, paramInt, paramBoolean2, paramSurvivalPkResultInfo);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramLong, paramInt, paramString);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramLong, paramInt1, paramArrayOfByte, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramBoolean, paramString1, paramInt, paramString2);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.e(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin());
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() == 0L) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getAccount(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a(), paramInt, paramString, this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.k(), b(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.p(), c(), ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady() ^ true);
    return true;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController.a(paramInt1, paramString, paramInt2, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b(), i(), b());
    return true;
  }
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label60;
      }
      GameRoomStatusListener localGameRoomStatusListener = (GameRoomStatusListener)((Iterator)localObject).next();
      if ((!bool) && (!localGameRoomStatusListener.a(paramInt, paramString, paramEngineData))) {
        break;
      }
    }
    label60:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRoomSelfExit exitType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" exitRoomTip:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" handled:");
    ((StringBuilder)localObject).append(bool);
    QLog.i("avgame_logic.GameEngine", 1, ((StringBuilder)localObject).toString());
    if (!bool) {
      a(GlobalExitRoomDialog.a().a(paramInt, paramString, paramEngineData), paramInt);
    }
    return bool;
  }
  
  public boolean a(GameItem paramGameItem)
  {
    boolean bool1 = GameUtil.b(paramGameItem);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramGameItem = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    List localList = paramGameItem.getPlayers();
    int i = 0;
    while (i < localList.size())
    {
      if ((localList.get(i) != null) && (((Player)localList.get(i)).status == 0))
      {
        i = 0;
        break label83;
      }
      i += 1;
    }
    i = 1;
    label83:
    bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if (paramGameItem.getPlayers().size() > 1)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    q();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("selectGame gameType = ");
      localStringBuilder.append(paramInt);
      QLog.i("avgame_logic.GameEngine", 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(a().getCurrentAccountUin(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a(), paramInt);
  }
  
  public void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("leaveGameRoomByUser roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" userUin =");
      localStringBuilder.append(paramString);
      QLog.i("avgame_logic.GameEngine", 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong, paramString, a());
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).b(paramLong, paramString1, paramString2);
    }
  }
  
  public void b(EngineData paramEngineData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramEngineData);
    }
  }
  
  public void b(EngineData paramEngineData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).b(paramEngineData, paramInt);
    }
  }
  
  public void b(GameActivityLifeCycleListener paramGameActivityLifeCycleListener)
  {
    this.d.remove(paramGameActivityLifeCycleListener);
  }
  
  public void b(GameResultListener paramGameResultListener)
  {
    this.c.remove(paramGameResultListener);
  }
  
  public void b(GameRoomStatusListener paramGameRoomStatusListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramGameRoomStatusListener);
  }
  
  public void b(GameStatusListener paramGameStatusListener)
  {
    this.b.remove(paramGameStatusListener);
  }
  
  public void b(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramString, paramEngineData);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramBoolean);
    }
    AvGameSysMusicPlayer.a().c();
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    ProcessMonitor.a().b("exitGameRoom");
    a(paramInt);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.b();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.b();
    AvGameSysMusicPlayer.a().b();
    long l1 = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    if ((l1 != 0L) && (!paramBoolean)) {
      b(l1, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin());
    }
    if (IAVGameBusinessCtrl.a() != null)
    {
      long l2 = System.currentTimeMillis();
      AVGamePerfReporter.a().a(0, a().a(), a().b(), 0L);
      AVGameHandler.a().a().post(new GameEngine.3(this, l2));
    }
    ((IAVGameAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface).a().a(3, String.valueOf(l1));
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitGameRoomForPk svrAlreadyExit = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" exitType =");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" roomId:");
    localStringBuilder.append(l1);
    QLog.i("avgame_logic.GameEngine", 1, localStringBuilder.toString(), new Throwable("not crash, print stack"));
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
    }
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b());
    return true;
  }
  
  public boolean b(GameItem paramGameItem)
  {
    boolean bool1 = GameUtil.b(paramGameItem);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramGameItem = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    List localList = paramGameItem.getPlayers();
    int i = 0;
    while (i < localList.size())
    {
      if ((localList.get(i) != null) && (((Player)localList.get(i)).status == 0))
      {
        i = 0;
        break label83;
      }
      i += 1;
    }
    i = 1;
    label83:
    bool1 = bool2;
    if (paramGameItem.getPlayers().size() > 1)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int c()
  {
    return h() ^ true;
  }
  
  public void c()
  {
    HeartBeatController localHeartBeatController = this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController;
    if (localHeartBeatController != null) {
      localHeartBeatController.a();
    }
  }
  
  public void c(int paramInt)
  {
    int j = AVGameUtil.b();
    if (j == 0)
    {
      ((GameRoomHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(a().a(), a().a().owner);
      return;
    }
    int i = 1;
    if (j == 1) {
      i = 0;
    }
    a(paramInt, i);
  }
  
  public void c(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kickGameRoomUserByOwner roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ownerUin =");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" kickedUserUin =");
      localStringBuilder.append(paramString2);
      QLog.i("avgame_logic.GameEngine", 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong, paramString1, paramString2);
  }
  
  public void c(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).c(paramEngineData);
    }
    if (paramEngineData.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartSuc enable aec mode");
      ((MultiOperatorImplForGame)QavSDK.a().a()).a(1);
    }
    a(paramEngineData, paramEngineData.a(), "countdown");
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() != null) {
      d(paramEngineData, this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a());
    }
    AVGameNodeReportUtil.a(paramEngineData.c(), paramEngineData.a().players.size());
  }
  
  public void c(EngineData paramEngineData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, true);
    int i = paramEngineData.a();
    int j = paramEngineData.b();
    if ((i == 10) && (j == 0))
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        GameStatusListener localGameStatusListener = (GameStatusListener)localIterator.next();
        boolean bool;
        if (paramInt != 1) {
          bool = true;
        } else {
          bool = false;
        }
        localGameStatusListener.a(paramEngineData, bool);
      }
      k(paramEngineData);
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).c(paramEngineData, paramInt);
    }
  }
  
  public void c(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).c(paramString, paramEngineData);
    }
  }
  
  public boolean c()
  {
    if ((h()) && (Build.VERSION.SDK_INT >= 16)) {
      return AudioProcess.a().startRecog(this);
    }
    return false;
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameEngine_GameRC", 1, String.format("onclick share:playId[%s]", new Object[] { this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b() }));
    }
    ((IAVGameAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface).a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b());
  }
  
  public void d(int paramInt)
  {
    if ((e()) && (a()))
    {
      GameItem localGameItem = a().a();
      if (localGameItem != null)
      {
        ((GameRoomHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(a().a(), a().a().owner, localGameItem.jdField_a_of_type_Int, a().a(), paramInt);
        return;
      }
      QLog.d("avgame_logic.GameEngine", 2, "stopGameMatchV2 no gameItem");
      return;
    }
    QLog.d("avgame_logic.GameEngine", 2, "stopGameMatch no need");
  }
  
  public void d(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).d(paramEngineData);
    }
  }
  
  public void d(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).d(paramString, paramEngineData);
    }
  }
  
  public boolean d()
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b() == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getAccount(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b());
    return true;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.e();
  }
  
  public void e(EngineData paramEngineData)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).e(paramEngineData);
    }
    ThreadManager.getSubThreadHandler().post(new GameEngine.4(this, paramEngineData));
  }
  
  public void e(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).e(paramString, paramEngineData);
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a(a());
  }
  
  public void f()
  {
    int j = AVGameUtil.b();
    if (j == 0)
    {
      if ((e()) && (a()))
      {
        ((GameRoomHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(a().a(), a().i(), a().a().owner);
        return;
      }
      QLog.d("avgame_logic.GameEngine", 2, "stopGameMatch no need");
      return;
    }
    int i = 1;
    if (j == 1) {
      i = 0;
    }
    d(i);
  }
  
  public void f(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).f(paramEngineData);
    }
    if (paramEngineData.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartPush enable aec mode");
      ((MultiOperatorImplForGame)QavSDK.a().a()).a(1);
    }
    a(paramEngineData, paramEngineData.a(), "countdown");
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() != null) {
      d(paramEngineData, this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a());
    }
    AVGameNodeReportUtil.a(paramEngineData.c(), paramEngineData.a().players.size());
  }
  
  public boolean f()
  {
    EngineData localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
    return (localEngineData != null) && (localEngineData.f());
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).g();
    }
  }
  
  public void g(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).g(paramEngineData);
    }
    a(paramEngineData, paramEngineData.a(), "countdown");
    SecurityPolicyChecker.a().a(paramEngineData, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getCurrentAccountUin());
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.h();
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).h();
    }
  }
  
  public void h(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).h(paramEngineData);
    }
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.h();
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).i();
    }
  }
  
  public void i(EngineData paramEngineData)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).i(paramEngineData);
    }
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.g();
  }
  
  public void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).j();
    }
  }
  
  public void j(EngineData paramEngineData)
  {
    if ((paramEngineData != null) && (paramEngineData.a() != null))
    {
      if (paramEngineData.c() == 1) {
        return;
      }
      if ((paramEngineData.c() == 3) && (!paramEngineData.h()))
      {
        if (paramEngineData.a().d() > paramEngineData.a().f())
        {
          i = paramEngineData.s() * 1000;
          j = paramEngineData.a().d() - paramEngineData.a().f();
        }
        else
        {
          i = paramEngineData.a().f() - paramEngineData.a().d() + paramEngineData.s() * 1000;
          break label128;
        }
      }
      else
      {
        i = paramEngineData.a().f();
        j = paramEngineData.a().d();
      }
      i -= j;
      label128:
      int k = ((AvGameConfBean)QConfigManager.a().a(642)).c();
      int j = i + k * 1000;
      int i = j;
      if (paramEngineData.h()) {
        i = j + paramEngineData.a().a.f * 1000;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, i);
      paramEngineData = new StringBuilder();
      paramEngineData.append(" questionTimeout:");
      paramEngineData.append(k);
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "startTopicTimeoutMonitor timeoutTs: ", Integer.valueOf(i), paramEngineData.toString() });
    }
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.j() != 0;
  }
  
  public void k()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).k();
    }
  }
  
  public void l()
  {
    int i = a().j();
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((GameRoomHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(bool, a().k(), i, a().p(), ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady() ^ true);
    if (bool) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void m()
  {
    a(false);
  }
  
  public void n()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void o()
  {
    ThreadManager.getSubThreadHandler().post(new GameEngine.6(this));
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine
 * JD-Core Version:    0.7.0.1
 */