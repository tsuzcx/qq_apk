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
  static String b = "IGameEngine";
  static IGameEngine c;
  
  public static IGameEngine I()
  {
    c = GameEngine.a();
    return c;
  }
  
  public static boolean J()
  {
    if (I().s() != null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "IGameEngine or EngineData = null");
    }
    return true;
  }
  
  public static AppRuntime K()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static boolean k(EngineData paramEngineData)
  {
    if (K() == null) {
      return false;
    }
    return K().getAccount().equals(paramEngineData.h().b.uin);
  }
  
  public abstract boolean A();
  
  public abstract boolean B();
  
  public abstract boolean C();
  
  public abstract boolean D();
  
  public abstract void G();
  
  public AVGameClientQIPCModule L()
  {
    if ((K() instanceof IAVGameAppInterface)) {
      return ((IAVGameAppInterface)K()).a();
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
  
  public abstract boolean a(int paramInt, String paramString);
  
  public abstract boolean a(GameItem paramGameItem);
  
  public abstract void b(int paramInt);
  
  public abstract void b(GameActivityLifeCycleListener paramGameActivityLifeCycleListener);
  
  public abstract void b(GameResultListener paramGameResultListener);
  
  public abstract void b(GameRoomStatusListener paramGameRoomStatusListener);
  
  public abstract void b(GameStatusListener paramGameStatusListener);
  
  public abstract void b(boolean paramBoolean, int paramInt);
  
  public abstract boolean b(GameItem paramGameItem);
  
  public abstract void c(int paramInt);
  
  public abstract boolean d();
  
  public abstract int e();
  
  public abstract void g();
  
  public abstract EngineData s();
  
  public abstract boolean v();
  
  public abstract void w();
  
  public abstract void x();
  
  public abstract void y();
  
  public abstract void z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.IGameEngine
 * JD-Core Version:    0.7.0.1
 */