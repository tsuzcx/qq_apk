package com.tencent.avgame.gamelogic;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.AudioProcess.OnRecog;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.callback.AVGameUIEventCallback;
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
import com.tencent.avgame.gamelogic.gameres.AvGameMusicPlayer;
import com.tencent.avgame.gamelogic.gameres.AvGameSysMusicPlayer;
import com.tencent.avgame.gamelogic.globalmanage.GlobalExitRoomDialog;
import com.tencent.avgame.gamelogic.handler.GamePlayHandler;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener;
import com.tencent.avgame.gamelogic.listener.GameResultListener;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.GameStatusListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.avgame.localvoicerecog.AVGameVoiceRecog;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.MultiOperatorImplForGame;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
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
  implements AudioProcess.OnRecog, GameResultListener, GameRoomStatusListener, GameStatusListener, IDataCtrl<EngineData>
{
  private int jdField_a_of_type_Int = 0;
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  protected AVGameUIEventCallback a;
  private GameController jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController;
  private HeartBeatController jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController;
  private RoomController jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController;
  private StatusMonitor jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor;
  private SurvivalAssistManager jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager;
  private SyncController jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController;
  private EngineData jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
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
  
  public static boolean a(EngineData paramEngineData)
  {
    return a().a().getAccount().equals(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
  }
  
  private void b(AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData = new EngineData();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.b = new ArrayList(4);
    this.c = new ArrayList(1);
    this.d = new ArrayList(1);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController = new SyncController(paramAVGameAppInterface);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController = new RoomController(paramAVGameAppInterface, this, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController, this);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController = new GameController(paramAVGameAppInterface, this, this, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController, this);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController = new HeartBeatController(paramAVGameAppInterface, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController, this, this);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor = new StatusMonitor(paramAVGameAppInterface, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController, this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSyncController, this, this);
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
    AVGameBusinessCtrl.b().b(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().getPlayers().size();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.d();
  }
  
  public AVGameAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  }
  
  public SurvivalAssistCallback a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicControllerSurvivalAssistManager.a(paramInt);
  }
  
  public EngineData a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
  }
  
  public void a()
  {
    AVGameBusinessCtrl.b().a(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    GameRoomHandler localGameRoomHandler = (GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.a);
    GameItem localGameItem = a().a();
    if (localGameItem != null) {
      localGameRoomHandler.a(a().a(), a().a().owner, localGameItem.jdField_a_of_type_Int, paramInt2);
    }
    do
    {
      return;
      QLog.d("avgame_logic.GameEngine", 2, "startGameMatchV2 no gameItem " + paramInt1);
    } while (paramInt1 <= 0);
    localGameRoomHandler.a(a().a(), a().a().owner, paramInt1, paramInt2);
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
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomList roomId = " + paramLong);
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
    QLog.d("avgame_logic.GameEngine", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController.a(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1 + " from = " + paramInt2);
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
    if (paramBoolean) {}
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramLong, paramString1, paramBoolean, paramString2, paramInt);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2);
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
  
  public void a(AVGameAppInterface paramAVGameAppInterface)
  {
    b(paramAVGameAppInterface);
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
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a()) {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush NotPlayedYet return.");
    }
    for (;;)
    {
      if (paramEngineData.c() == 4)
      {
        QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush disable aec mode");
        ((MultiOperatorImplForGame)QavSDK.a().a()).a(0);
      }
      k(paramEngineData);
      AVGameNodeReportUtil.d();
      p();
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((GameStatusListener)localIterator.next()).a(paramEngineData, paramBoolean);
      }
    }
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
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(a().e(), paramString, paramInt);
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    if (a().a().a() != null) {}
    for (String str = a().a().a().b();; str = "")
    {
      localAVGamePerfReporter.a(true, paramString, str, paramInt, a().b(), a().getCurrentAccountUin(), AVGamePerfReporter.a().a(), a().a());
      return;
    }
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
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b(), paramString1, paramString2);
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
      ((GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(i, paramBoolean);
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
      int i = CJSurvivalFestivalReporter.a(a().a());
      if (i > 0)
      {
        QLog.i("avgame_logic.GameEngine", 1, "exitGameRoom CJSurvivalFestivalReporter refer = " + i);
        CJSurvivalFestivalReporter.a(7, 3, true, i, "1", false);
      }
    }
    ProcessMonitor.a().b("exitGameRoom");
    if (AVGameBusinessCtrl.b() != null)
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
      b(l, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.f()) {
      a().a(paramBoolean2);
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(0, String.valueOf(l));
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    ThreadManager.getUIHandler().postDelayed(new GameEngine.2(this), 1000L);
    QLog.i("avgame_logic.GameEngine", 1, "exitGameRoom svrAlreadyExit = " + paramBoolean1 + " exitType =" + paramInt + " roomId:" + l, new Throwable("not crash, print stack"));
    if (l != 0L) {
      if ((paramInt == 2) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
        if (7 != paramInt) {
          break label437;
        }
      }
    }
    label437:
    for (String str = "0X800B046";; str = "0X800B045")
    {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "" + paramInt, "", "", "");
      AVGameNodeReportUtil.b(AVGameNodeReportUtil.a(paramInt));
      QualityReporter.a();
      return;
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
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.e(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public boolean a(int paramInt, String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() == 0L) {
      return false;
    }
    GameController localGameController = this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController;
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount();
    long l = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    int j = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.k();
    int k = b();
    int m = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.p();
    int n = c();
    if (AVGameVoiceRecog.a().b()) {}
    for (;;)
    {
      localGameController.a(str, l, paramInt, paramString, j, k, m, n, i);
      return true;
      i = 1;
    }
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController.a(paramInt1, paramString, paramInt2, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b(), i(), b());
    return true;
  }
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      GameRoomStatusListener localGameRoomStatusListener = (GameRoomStatusListener)localIterator.next();
      if ((bool) || (localGameRoomStatusListener.a(paramInt, paramString, paramEngineData))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    QLog.i("avgame_logic.GameEngine", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " handled:" + bool);
    if (!bool) {
      a(GlobalExitRoomDialog.a().a(paramInt, paramString, paramEngineData), paramInt);
    }
    return bool;
  }
  
  public boolean a(GameItem paramGameItem)
  {
    boolean bool = true;
    if (GameUtil.b(paramGameItem)) {
      return false;
    }
    paramGameItem = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    List localList = paramGameItem.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((a()) && (paramGameItem.getPlayers().size() > 1) && (i != 0)) {}
      for (;;)
      {
        return bool;
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.g()) {
      return 1;
    }
    return 0;
  }
  
  public void b()
  {
    q();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "selectGame gameType = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(a().getCurrentAccountUin(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a(), paramInt);
  }
  
  public void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString);
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
      b(l1, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    if (AVGameBusinessCtrl.b() != null)
    {
      long l2 = System.currentTimeMillis();
      AVGamePerfReporter.a().a(0, a().a(), a().b(), 0L);
      AVGameHandler.a().a().post(new GameEngine.3(this, l2));
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(3, String.valueOf(l1));
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b();
    QLog.i("avgame_logic.GameEngine", 1, "exitGameRoomForPk svrAlreadyExit = " + paramBoolean + " exitType =" + paramInt + " roomId:" + l1, new Throwable("not crash, print stack"));
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
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b());
    return true;
  }
  
  public boolean b(GameItem paramGameItem)
  {
    boolean bool = true;
    if (GameUtil.b(paramGameItem)) {
      return false;
    }
    paramGameItem = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a();
    List localList = paramGameItem.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((paramGameItem.getPlayers().size() > 1) && (i != 0)) {}
      for (;;)
      {
        return bool;
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  public int c()
  {
    if (h()) {
      return 0;
    }
    return 1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicControllerHeartBeatController.a();
    }
  }
  
  public void c(int paramInt)
  {
    int i = 1;
    int j = AVGameUtils.b();
    if (j == 0)
    {
      ((GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(a().a(), a().a().owner);
      return;
    }
    if (j == 1) {
      i = 0;
    }
    a(paramInt, i);
  }
  
  public void c(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2);
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
    Iterator localIterator;
    if ((i == 10) && (j == 0))
    {
      localIterator = this.b.iterator();
      if (localIterator.hasNext())
      {
        GameStatusListener localGameStatusListener = (GameStatusListener)localIterator.next();
        if (paramInt != 1) {}
        for (boolean bool = true;; bool = false)
        {
          localGameStatusListener.a(paramEngineData, bool);
          break;
        }
      }
      k(paramEngineData);
    }
    for (;;)
    {
      return;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((GameRoomStatusListener)localIterator.next()).c(paramEngineData, paramInt);
      }
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
      return AudioProcess.a().a(this);
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
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b());
  }
  
  public void d(int paramInt)
  {
    if ((e()) && (a()))
    {
      GameItem localGameItem = a().a();
      if (localGameItem != null)
      {
        ((GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(a().a(), a().a().owner, localGameItem.jdField_a_of_type_Int, a().a(), paramInt);
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
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a()) {}
    while (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b() == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerGameController.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.b());
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
    int i = 1;
    int j = AVGameUtils.b();
    if (j == 0)
    {
      if ((e()) && (a()))
      {
        ((GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.a)).a(a().a(), a().i(), a().a().owner);
        return;
      }
      QLog.d("avgame_logic.GameEngine", 2, "stopGameMatch no need");
      return;
    }
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
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.f());
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
    SecurityPolicyChecker.a().a(paramEngineData, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
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
    if ((paramEngineData == null) || (paramEngineData.a() == null) || (paramEngineData.c() == 1)) {
      return;
    }
    int i;
    if ((paramEngineData.c() == 3) && (!paramEngineData.h())) {
      if (paramEngineData.a().d() > paramEngineData.a().f()) {
        i = paramEngineData.s() * 1000 - (paramEngineData.a().d() - paramEngineData.a().f());
      }
    }
    for (;;)
    {
      int k = ((AvGameConfBean)QConfigManager.a().a(642)).c();
      int j = k * 1000 + i;
      i = j;
      if (paramEngineData.h()) {
        i = j + paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.f * 1000;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicControllerStatusMonitor.a(paramEngineData, i);
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "startTopicTimeoutMonitor timeoutTs: ", Integer.valueOf(i), " questionTimeout:" + k });
      return;
      i = paramEngineData.a().f() - paramEngineData.a().d() + paramEngineData.s() * 1000;
      continue;
      i = paramEngineData.a().f() - paramEngineData.a().d();
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
    int j = a().j();
    boolean bool;
    GameRoomHandler localGameRoomHandler;
    int k;
    int m;
    if (j == 0)
    {
      bool = true;
      localGameRoomHandler = (GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.a);
      k = a().k();
      m = a().p();
      if (!AVGameVoiceRecog.a().b()) {
        break label93;
      }
    }
    label93:
    for (int i = 0;; i = 1)
    {
      localGameRoomHandler.a(bool, k, j, m, i);
      if (bool)
      {
        this.jdField_a_of_type_Int = 0;
        CJSurvivalFestivalReporter.a(2, 0, true);
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void m()
  {
    a(false);
  }
  
  public void n()
  {
    int i = 1;
    int j = a().j();
    GameRoomHandler localGameRoomHandler;
    boolean bool1;
    boolean bool2;
    label67:
    int k;
    if (j > 0)
    {
      localGameRoomHandler = (GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.a);
      if (a().e == 0) {
        break label114;
      }
      bool1 = true;
      if ((a().a() == 0) || (a().a() == 10)) {
        break label120;
      }
      bool2 = true;
      k = a().k();
      if (!a().g()) {
        break label126;
      }
    }
    for (;;)
    {
      int m = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = m;
      localGameRoomHandler.a(k, j, i, m, bool1, bool2);
      return;
      label114:
      bool1 = false;
      break;
      label120:
      bool2 = false;
      break label67;
      label126:
      i = 0;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine
 * JD-Core Version:    0.7.0.1
 */