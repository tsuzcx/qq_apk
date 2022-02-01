package com.tencent.avgame.gamelogic;

import com.tencent.av.audioprocess.AudioProcessCallback.OnRecog;
import com.tencent.avgame.app.IAVGameAppInterface;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener;
import com.tencent.avgame.gamelogic.listener.GameResultListener;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.GameStatusListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class IGameEngine
  implements AudioProcessCallback.OnRecog, GameResultListener, GameRoomStatusListener, GameStatusListener, IDataCtrl<EngineData>
{
  static IGameEngine jdField_a_of_type_ComTencentAvgameGamelogicIGameEngine;
  static String jdField_a_of_type_JavaLangString = "IGameEngine";
  
  public static IGameEngine a()
  {
    jdField_a_of_type_ComTencentAvgameGamelogicIGameEngine = GameEngine.a();
    return jdField_a_of_type_ComTencentAvgameGamelogicIGameEngine;
  }
  
  public static AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static boolean a(EngineData paramEngineData)
  {
    if (a() == null) {
      return false;
    }
    return a().getAccount().equals(paramEngineData.a().a.uin);
  }
  
  public static boolean k()
  {
    if (a().a() != null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "IGameEngine or EngineData = null");
    }
    return true;
  }
  
  public abstract int a();
  
  public abstract EngineData a();
  
  public AVGameClientQIPCModule a()
  {
    if ((a() instanceof IAVGameAppInterface)) {
      return ((IAVGameAppInterface)a()).a();
    }
    return null;
  }
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(RoomInfo paramRoomInfo);
  
  public abstract void a(GameActivityLifeCycleListener paramGameActivityLifeCycleListener);
  
  public abstract void a(GameResultListener paramGameResultListener);
  
  public abstract void a(GameRoomStatusListener paramGameRoomStatusListener);
  
  public abstract void a(GameStatusListener paramGameStatusListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public abstract void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt, String paramString);
  
  public abstract boolean a(GameItem paramGameItem);
  
  public abstract void b(int paramInt);
  
  public abstract void b(GameActivityLifeCycleListener paramGameActivityLifeCycleListener);
  
  public abstract void b(GameResultListener paramGameResultListener);
  
  public abstract void b(GameRoomStatusListener paramGameRoomStatusListener);
  
  public abstract void b(GameStatusListener paramGameStatusListener);
  
  public abstract void b(boolean paramBoolean, int paramInt);
  
  public abstract boolean b(GameItem paramGameItem);
  
  public abstract void c();
  
  public abstract void c(int paramInt);
  
  public abstract boolean e();
  
  public abstract void f();
  
  public abstract boolean f();
  
  public abstract boolean g();
  
  public abstract boolean h();
  
  public abstract boolean i();
  
  public abstract void l();
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract void p();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.IGameEngine
 * JD-Core Version:    0.7.0.1
 */