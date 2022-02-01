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
  protected AVGameUIEventCallback a = new GameEngine.5(this);
  private HeartBeatController d;
  private RoomController e;
  private GameController f;
  private SyncController g;
  private StatusMonitor h;
  private List<GameRoomStatusListener> i;
  private List<GameStatusListener> j;
  private List<GameResultListener> k;
  private List<GameActivityLifeCycleListener> l;
  private SurvivalAssistManager m;
  private BaseAVGameAppInterface n;
  private int o = 0;
  private EngineData p;
  
  private void M()
  {
    this.d.b();
    this.e.c();
    this.i.clear();
    this.j.clear();
    this.k.clear();
    this.g.b();
    this.h.b();
    this.m.b();
    if (IAVGameBusinessCtrl.q()) {
      return;
    }
    IAVGameBusinessCtrl.p().b(this.a);
  }
  
  public static GameEngine a()
  {
    return GameEngine.INNER.a;
  }
  
  private void a(EngineData paramEngineData, ITopic paramITopic, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "[playEffect] survival: ", Boolean.valueOf(paramEngineData.M()), ", avRoom: ", Boolean.valueOf(paramEngineData.O()), ", topic:", paramITopic, ", effect: ", paramString });
    }
    if ((paramEngineData.M()) && (!paramEngineData.O()))
    {
      AvGameSysMusicPlayer.a().a(paramITopic, paramString);
      return;
    }
    AvGameMusicPlayer.b().a(paramITopic, paramString);
  }
  
  private void b(BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    this.n = paramBaseAVGameAppInterface;
    this.p = new EngineData();
    this.i = new CopyOnWriteArrayList();
    this.j = new ArrayList(4);
    this.k = new ArrayList(1);
    this.l = new ArrayList(1);
    this.g = new SyncController(paramBaseAVGameAppInterface);
    this.e = new RoomController(paramBaseAVGameAppInterface, this, this.g, this);
    this.f = new GameController(paramBaseAVGameAppInterface, this, this, this.g, this);
    this.d = new HeartBeatController(paramBaseAVGameAppInterface, this.g, this, this);
    this.h = new StatusMonitor(paramBaseAVGameAppInterface, this.d, this.g, this, this);
    this.m = new SurvivalAssistManager();
    this.m.a();
    a(this.m);
  }
  
  private void d(EngineData paramEngineData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "[playBgMusic] survival: ", Boolean.valueOf(paramEngineData.M()), ", avRoom: ", Boolean.valueOf(paramEngineData.O()), ", musicType: ", Integer.valueOf(paramInt) });
    }
    if ((paramEngineData.M()) && (!paramEngineData.O()))
    {
      AvGameSysMusicPlayer.a().a(paramInt, paramEngineData.M());
      return;
    }
    AvGameMusicPlayer.b().a(paramInt, paramEngineData.M());
  }
  
  private void l(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "[stopPlay] survival: ", Boolean.valueOf(paramEngineData.M()), ", avRoom: ", Boolean.valueOf(paramEngineData.O()) });
    }
    if ((paramEngineData.M()) && (!paramEngineData.O()))
    {
      AvGameSysMusicPlayer.a().c();
      return;
    }
    AvGameMusicPlayer.b().d();
  }
  
  public boolean A()
  {
    EngineData localEngineData = this.p;
    return (localEngineData != null) && (localEngineData.M());
  }
  
  public boolean B()
  {
    return this.p.O();
  }
  
  public boolean C()
  {
    return this.p.O();
  }
  
  public boolean D()
  {
    return this.p.N();
  }
  
  public boolean E()
  {
    return this.p.P() != 0;
  }
  
  public void F()
  {
    ThreadManager.getSubThreadHandler().post(new GameEngine.6(this));
  }
  
  public void G()
  {
    this.h.a();
  }
  
  public void a(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    GameRoomHandler localGameRoomHandler = (GameRoomHandler)this.n.getBusinessHandler(HandlerFactory.a);
    Object localObject = s().f();
    if (localObject != null)
    {
      localGameRoomHandler.a(s().i(), s().e().owner, ((GameItem)localObject).a, paramInt2);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startGameMatchV2 no gameItem ");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.d("avgame_logic.GameEngine", 2, ((StringBuilder)localObject).toString());
    if (paramInt1 > 0) {
      localGameRoomHandler.a(s().i(), s().e().owner, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ((GamePlayHandler)f().getBusinessHandler(HandlerFactory.c)).a(f().getLongAccountUin(), s().n(), paramInt1, paramInt2, paramInt3, m());
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((GameActivityLifeCycleListener)localIterator.next()).a(paramInt, paramActivity);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, EngineData paramEngineData)
  {
    Iterator localIterator = this.i.iterator();
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
    this.e.b(paramLong);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Iterator localIterator = this.j.iterator();
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
    this.e.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.d.a(paramLong, paramString);
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
    this.e.b(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).a(paramLong, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    Iterator localIterator = this.i.iterator();
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
    this.e.a(paramLong, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramLong, paramBoolean);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramEngineData);
    }
  }
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramEngineData, paramInt);
    }
    localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramEngineData, paramInt);
    }
  }
  
  public void a(EngineData paramEngineData, String paramString)
  {
    this.h.a(paramEngineData, false);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).a(paramEngineData, paramString);
    }
  }
  
  public void a(EngineData paramEngineData, boolean paramBoolean)
  {
    this.h.a(paramEngineData, false);
    if (this.h.c())
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush NotPlayedYet return.");
    }
    else
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        ((GameStatusListener)localIterator.next()).a(paramEngineData, paramBoolean);
      }
    }
    if (paramEngineData.o() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush disable aec mode");
      ((MultiOperatorImplForGame)QavSDK.a().c()).a(0);
    }
    l(paramEngineData);
    AVGameNodeReportUtil.d();
    G();
  }
  
  public void a(RoomInfo paramRoomInfo)
  {
    this.e.a(paramRoomInfo, true);
  }
  
  public void a(GameActivityLifeCycleListener paramGameActivityLifeCycleListener)
  {
    this.l.add(paramGameActivityLifeCycleListener);
  }
  
  public void a(GameResultListener paramGameResultListener)
  {
    this.k.add(paramGameResultListener);
  }
  
  public void a(GameRoomStatusListener paramGameRoomStatusListener)
  {
    if (!this.i.contains(paramGameRoomStatusListener)) {
      this.i.add(paramGameRoomStatusListener);
    }
  }
  
  public void a(GameStatusListener paramGameStatusListener)
  {
    if (!this.j.contains(paramGameStatusListener)) {
      this.j.add(paramGameStatusListener);
    }
  }
  
  public void a(BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    b(paramBaseAVGameAppInterface);
  }
  
  public void a(String paramString)
  {
    if (!this.p.d()) {
      return;
    }
    ((IAVGameAppInterface)this.n).a().b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRecogCallback gameStatus:");
      ((StringBuilder)localObject).append(s().j());
      QLog.d("avgame_logic.GameEngine", 2, ((StringBuilder)localObject).toString());
    }
    if (s().j() != 4) {
      a(s().A(), paramString, paramInt);
    }
    AVGamePerfReporter localAVGamePerfReporter = AVGamePerfReporter.a();
    if (s().h().h() != null) {
      localObject = s().h().h().d();
    } else {
      localObject = "";
    }
    localAVGamePerfReporter.a(true, paramString, (String)localObject, paramInt, s().n(), f().getCurrentAccountUin(), AVGamePerfReporter.a().c(), s().i());
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
    localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramString, paramInt, paramEngineData);
    }
    localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramString, paramInt, paramEngineData);
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
    }
  }
  
  public void a(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramString, paramEngineData);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!this.p.d()) {
      return;
    }
    ((IAVGameAppInterface)this.n).a().a(this.p.n(), paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramHashMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = s().P();
    if (i1 > 0) {
      ((GameRoomHandler)this.n.getBusinessHandler(HandlerFactory.a)).a(i1, paramBoolean);
    }
    this.o = 0;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a(paramBoolean, paramInt, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean1, paramInt, paramString, paramBoolean2);
    }
    if ((paramBoolean1) && (!B())) {
      AvGameSysMusicPlayer.a().b();
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (this.p.N())
    {
      int i1 = CJSurvivalReporterUtil.a().a(this.p);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exitGameRoom CJSurvivalFestivalReporter refer = ");
      ((StringBuilder)localObject).append(i1);
      QLog.i("avgame_logic.GameEngine", 1, ((StringBuilder)localObject).toString());
      if (i1 == 2)
      {
        if (this.p.O()) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_game_quit", "survival_game_quit", i1, 0, String.valueOf(this.p.h().f.a), String.valueOf(this.p.Y()), CJSurvivalReporterUtil.a().b(this.p), String.valueOf(this.p.Q()));
      }
      else if (i1 == 1)
      {
        if (this.p.O()) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_game_quit", "survival_game_quit", i1, 0, "", "", "", String.valueOf(this.p.Q()));
      }
    }
    ProcessMonitor.a().b("exitGameRoom");
    if (IAVGameBusinessCtrl.p() != null)
    {
      l1 = System.currentTimeMillis();
      AVGamePerfReporter.a().a(0, s().i(), s().n(), 0L);
      AVGameHandler.a().b().post(new GameEngine.1(this, l1));
    }
    a(paramInt);
    this.g.b();
    this.h.b();
    this.e.a();
    this.m.c();
    AvGameSysMusicPlayer.a().d();
    long l1 = this.p.i();
    if ((l1 != 0L) && (!paramBoolean1)) {
      b(l1, this.n.getCurrentAccountUin());
    }
    if (this.p.M()) {
      a().a(paramBoolean2);
    }
    ((IAVGameAppInterface)this.n).a().b(0, String.valueOf(l1));
    this.p.a();
    ThreadManager.getUIHandler().postDelayed(new GameEngine.2(this), 1000L);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitGameRoom svrAlreadyExit = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" exitType =");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" roomId:");
    ((StringBuilder)localObject).append(l1);
    QLog.i("avgame_logic.GameEngine", 1, ((StringBuilder)localObject).toString(), new Throwable("not crash, print stack"));
    if (l1 != 0L)
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
      AVGameNodeReportUtil.b(AVGameNodeReportUtil.c(paramInt));
      QualityReporter.a();
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean1, paramInt, paramBoolean2, paramSurvivalPkResultInfo);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramLong, paramInt, paramString);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramLong, paramInt1, paramArrayOfByte, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).a(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).a(paramBoolean, paramString1, paramInt, paramString2);
    }
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.p.i() == 0L) {
      return false;
    }
    this.f.a(this.n.getAccount(), this.p.i(), paramInt, paramString, this.p.Q(), m(), this.p.Y(), n(), ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady() ^ true);
    return true;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (!this.p.d()) {
      return false;
    }
    this.f.a(paramInt1, paramString, paramInt2, this.n.getCurrentAccountUin(), this.p.i(), this.p.n(), D(), m());
    return true;
  }
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    Object localObject = this.i.iterator();
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
    paramGameItem = this.p.e();
    List localList = paramGameItem.getPlayers();
    int i1 = 0;
    while (i1 < localList.size())
    {
      if ((localList.get(i1) != null) && (((Player)localList.get(i1)).status == 0))
      {
        i1 = 0;
        break label83;
      }
      i1 += 1;
    }
    i1 = 1;
    label83:
    bool1 = bool2;
    if (d())
    {
      bool1 = bool2;
      if (paramGameItem.getPlayers().size() > 1)
      {
        bool1 = bool2;
        if (i1 != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (IAVGameBusinessCtrl.q()) {
      return;
    }
    IAVGameBusinessCtrl.p().a(this.a);
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
    this.e.a(f().getCurrentAccountUin(), this.p.i(), paramInt);
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
    this.e.a(paramLong, paramString, d());
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).b(paramLong, paramString1, paramString2);
    }
  }
  
  public void b(EngineData paramEngineData)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramEngineData);
    }
  }
  
  public void b(EngineData paramEngineData, int paramInt)
  {
    this.h.a(paramEngineData, false);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).b(paramEngineData, paramInt);
    }
  }
  
  public void b(GameActivityLifeCycleListener paramGameActivityLifeCycleListener)
  {
    this.l.remove(paramGameActivityLifeCycleListener);
  }
  
  public void b(GameResultListener paramGameResultListener)
  {
    this.k.remove(paramGameResultListener);
  }
  
  public void b(GameRoomStatusListener paramGameRoomStatusListener)
  {
    this.i.remove(paramGameRoomStatusListener);
  }
  
  public void b(GameStatusListener paramGameStatusListener)
  {
    this.j.remove(paramGameStatusListener);
  }
  
  public void b(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramString, paramEngineData);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramBoolean);
    }
    AvGameSysMusicPlayer.a().d();
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    ProcessMonitor.a().b("exitGameRoom");
    a(paramInt);
    this.g.b();
    this.h.b();
    this.e.b();
    AvGameSysMusicPlayer.a().c();
    long l1 = this.p.i();
    if ((l1 != 0L) && (!paramBoolean)) {
      b(l1, this.n.getCurrentAccountUin());
    }
    if (IAVGameBusinessCtrl.p() != null)
    {
      long l2 = System.currentTimeMillis();
      AVGamePerfReporter.a().a(0, s().i(), s().n(), 0L);
      AVGameHandler.a().b().post(new GameEngine.3(this, l2));
    }
    ((IAVGameAppInterface)this.n).a().b(3, String.valueOf(l1));
    this.p.b();
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
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).b(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
    }
  }
  
  public boolean b(GameItem paramGameItem)
  {
    boolean bool1 = GameUtil.b(paramGameItem);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramGameItem = this.p.e();
    List localList = paramGameItem.getPlayers();
    int i1 = 0;
    while (i1 < localList.size())
    {
      if ((localList.get(i1) != null) && (((Player)localList.get(i1)).status == 0))
      {
        i1 = 0;
        break label83;
      }
      i1 += 1;
    }
    i1 = 1;
    label83:
    bool1 = bool2;
    if (paramGameItem.getPlayers().size() > 1)
    {
      bool1 = bool2;
      if (i1 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    M();
  }
  
  public void c(int paramInt)
  {
    int i2 = AVGameUtil.b();
    if (i2 == 0)
    {
      ((GameRoomHandler)this.n.getBusinessHandler(HandlerFactory.a)).a(s().i(), s().e().owner);
      return;
    }
    int i1 = 1;
    if (i2 == 1) {
      i1 = 0;
    }
    a(paramInt, i1);
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
    this.e.a(paramLong, paramString1, paramString2);
  }
  
  public void c(EngineData paramEngineData)
  {
    this.h.a(paramEngineData, false);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).c(paramEngineData);
    }
    if (paramEngineData.o() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartSuc enable aec mode");
      ((MultiOperatorImplForGame)QavSDK.a().c()).a(1);
    }
    a(paramEngineData, paramEngineData.s(), "countdown");
    if (this.p.h() != null) {
      d(paramEngineData, this.p.h().d());
    }
    AVGameNodeReportUtil.a(paramEngineData.o(), paramEngineData.e().players.size());
  }
  
  public void c(EngineData paramEngineData, int paramInt)
  {
    this.h.a(paramEngineData, true);
    int i1 = paramEngineData.j();
    int i2 = paramEngineData.m();
    if ((i1 == 10) && (i2 == 0))
    {
      localIterator = this.j.iterator();
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
      l(paramEngineData);
      return;
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).c(paramEngineData, paramInt);
    }
  }
  
  public void c(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).c(paramString, paramEngineData);
    }
  }
  
  public void d(int paramInt)
  {
    if ((v()) && (d()))
    {
      GameItem localGameItem = s().f();
      if (localGameItem != null)
      {
        ((GameRoomHandler)this.n.getBusinessHandler(HandlerFactory.a)).a(s().i(), s().e().owner, localGameItem.a, s().K(), paramInt);
        return;
      }
      QLog.d("avgame_logic.GameEngine", 2, "stopGameMatchV2 no gameItem");
      return;
    }
    QLog.d("avgame_logic.GameEngine", 2, "stopGameMatch no need");
  }
  
  public void d(EngineData paramEngineData)
  {
    this.h.a(paramEngineData, false);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).d(paramEngineData);
    }
  }
  
  public void d(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).d(paramString, paramEngineData);
    }
  }
  
  public boolean d()
  {
    return this.p.g(this.n.getCurrentAccountUin());
  }
  
  public int e()
  {
    return this.p.e().getPlayers().size();
  }
  
  public SurvivalAssistCallback e(int paramInt)
  {
    return this.m.a(paramInt);
  }
  
  public void e(EngineData paramEngineData)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).e(paramEngineData);
    }
    ThreadManager.getSubThreadHandler().post(new GameEngine.4(this, paramEngineData));
  }
  
  public void e(String paramString, EngineData paramEngineData)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).e(paramString, paramEngineData);
    }
  }
  
  public BaseAVGameAppInterface f()
  {
    return this.n;
  }
  
  public void f(EngineData paramEngineData)
  {
    this.h.a(paramEngineData, false);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).f(paramEngineData);
    }
    if (paramEngineData.o() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartPush enable aec mode");
      ((MultiOperatorImplForGame)QavSDK.a().c()).a(1);
    }
    a(paramEngineData, paramEngineData.s(), "countdown");
    if (this.p.h() != null) {
      d(paramEngineData, this.p.h().d());
    }
    AVGameNodeReportUtil.a(paramEngineData.o(), paramEngineData.e().players.size());
  }
  
  public void g()
  {
    HeartBeatController localHeartBeatController = this.d;
    if (localHeartBeatController != null) {
      localHeartBeatController.a();
    }
  }
  
  public void g(EngineData paramEngineData)
  {
    this.h.a(paramEngineData, false);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).g(paramEngineData);
    }
    a(paramEngineData, paramEngineData.s(), "countdown");
    SecurityPolicyChecker.a().a(paramEngineData, this.n.getCurrentAccountUin());
  }
  
  public void h()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).h();
    }
  }
  
  public void h(EngineData paramEngineData)
  {
    this.h.a(paramEngineData, false);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((GameStatusListener)localIterator.next()).h(paramEngineData);
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).i();
    }
  }
  
  public void i(EngineData paramEngineData)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((GameResultListener)localIterator.next()).i(paramEngineData);
    }
  }
  
  public void j()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).j();
    }
  }
  
  public void j(EngineData paramEngineData)
  {
    if ((paramEngineData != null) && (paramEngineData.h() != null))
    {
      if (paramEngineData.o() == 1) {
        return;
      }
      if ((paramEngineData.o() == 3) && (!paramEngineData.O()))
      {
        if (paramEngineData.h().n() > paramEngineData.h().p())
        {
          i1 = paramEngineData.aj() * 1000;
          i2 = paramEngineData.h().n() - paramEngineData.h().p();
        }
        else
        {
          i1 = paramEngineData.h().p() - paramEngineData.h().n() + paramEngineData.aj() * 1000;
          break label128;
        }
      }
      else
      {
        i1 = paramEngineData.h().p();
        i2 = paramEngineData.h().n();
      }
      i1 -= i2;
      label128:
      int i3 = ((AvGameConfBean)QConfigManager.b().b(642)).m();
      int i2 = i1 + i3 * 1000;
      int i1 = i2;
      if (paramEngineData.O()) {
        i1 = i2 + paramEngineData.h().f.f * 1000;
      }
      this.h.a(paramEngineData, i1);
      paramEngineData = new StringBuilder();
      paramEngineData.append(" questionTimeout:");
      paramEngineData.append(i3);
      QLog.d("avgame_logic.GameEngine", 1, new Object[] { "startTopicTimeoutMonitor timeoutTs: ", Integer.valueOf(i1), paramEngineData.toString() });
    }
  }
  
  public void k()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).k();
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((GameRoomStatusListener)localIterator.next()).l();
    }
  }
  
  public int m()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int n()
  {
    return C() ^ true;
  }
  
  public boolean o()
  {
    if (!this.p.d()) {
      return false;
    }
    this.f.a(this.n.getCurrentAccountUin(), this.p.i(), this.p.n());
    return true;
  }
  
  public boolean p()
  {
    if ((C()) && (Build.VERSION.SDK_INT >= 16)) {
      return AudioProcess.b().startRecog(this);
    }
    return false;
  }
  
  public void q()
  {
    if (!this.p.d()) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameEngine_GameRC", 1, String.format("onclick share:playId[%s]", new Object[] { this.p.n() }));
    }
    ((IAVGameAppInterface)this.n).a().a(this.p.n());
  }
  
  public boolean r()
  {
    if (!this.p.d()) {
      return false;
    }
    if (this.p.n() == null) {
      return false;
    }
    this.f.a(this.n.getAccount(), this.p.n());
    return true;
  }
  
  public EngineData s()
  {
    return this.p;
  }
  
  public void t()
  {
    this.p.D();
  }
  
  public long u()
  {
    return this.p.G();
  }
  
  public boolean v()
  {
    return this.p.a(d());
  }
  
  public void w()
  {
    int i2 = AVGameUtil.b();
    if (i2 == 0)
    {
      if ((v()) && (d()))
      {
        ((GameRoomHandler)this.n.getBusinessHandler(HandlerFactory.a)).a(s().i(), s().J(), s().e().owner);
        return;
      }
      QLog.d("avgame_logic.GameEngine", 2, "stopGameMatch no need");
      return;
    }
    int i1 = 1;
    if (i2 == 1) {
      i1 = 0;
    }
    d(i1);
  }
  
  public void x()
  {
    int i1 = s().P();
    boolean bool;
    if (i1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((GameRoomHandler)this.n.getBusinessHandler(HandlerFactory.a)).a(bool, s().Q(), i1, s().Y(), ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).isLocalVoiceModelReady() ^ true);
    if (bool) {
      this.o = 0;
    }
  }
  
  public void y()
  {
    a(false);
  }
  
  public void z()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine
 * JD-Core Version:    0.7.0.1
 */