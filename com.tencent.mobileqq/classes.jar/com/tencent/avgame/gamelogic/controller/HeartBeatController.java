package com.tencent.avgame.gamelogic.controller;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.HeartBeatListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.avgame.gamelogic.listener.SyncListener;
import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class HeartBeatController
  extends GameRoomObserver
  implements HeartBeatListener
{
  public static int a = 2000;
  private static HashMap<Integer, Integer> k = new HashMap();
  private BaseAVGameAppInterface b;
  private SyncListener c;
  private IDataCtrl<EngineData> d;
  private volatile boolean e;
  private long f;
  private long g;
  private long h;
  private String i;
  private Handler j = new HeartBeatController.1(this);
  
  static
  {
    Object localObject1 = k;
    Object localObject2 = Integer.valueOf(1);
    ((HashMap)localObject1).put(Integer.valueOf(0), localObject2);
    Object localObject3 = k;
    localObject1 = Integer.valueOf(2);
    ((HashMap)localObject3).put(localObject2, localObject1);
    k.put(localObject1, localObject1);
    localObject2 = k;
    localObject3 = Integer.valueOf(3);
    ((HashMap)localObject2).put(localObject3, localObject1);
    k.put(Integer.valueOf(4), localObject1);
    k.put(Integer.valueOf(10), localObject3);
  }
  
  public HeartBeatController(BaseAVGameAppInterface paramBaseAVGameAppInterface, SyncListener paramSyncListener, GameRoomStatusListener paramGameRoomStatusListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.b = paramBaseAVGameAppInterface;
    this.c = paramSyncListener;
    this.d = paramIDataCtrl;
    this.b.addObserver(this, false);
  }
  
  private void b(long paramLong, String paramString)
  {
    GameRoomHandler localGameRoomHandler = (GameRoomHandler)this.b.getBusinessHandler(HandlerFactory.a);
    Integer localInteger = (Integer)k.get(Integer.valueOf(((EngineData)this.d.H()).j()));
    int m;
    if (localInteger == null) {
      m = 0;
    } else {
      m = localInteger.intValue();
    }
    localGameRoomHandler.a(paramLong, paramString, m);
    com.tencent.avgame.gamelogic.QualityReporter.a = System.currentTimeMillis();
  }
  
  private void e()
  {
    int m;
    if (NetworkUtil.isNetworkAvailable()) {
      m = 2131887242;
    } else {
      m = 2131887314;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopHeartBeatByLocalTimeOut() then do exitRoom() isNetworkAvailable =");
    localStringBuilder.append(NetworkUtil.isNetworkAvailable());
    QLog.d("HeartBeatController", 1, localStringBuilder.toString());
    IGameEngine.I().a(5, MobileQQ.sMobileQQ.getApplicationContext().getString(m), IGameEngine.I().s());
  }
  
  private void f()
  {
    this.j.removeMessages(2);
    this.j.sendEmptyMessageDelayed(2, 35000L);
  }
  
  private void g()
  {
    QLog.d("HeartBeatController", 1, String.format("maintainHeartBeat() [isStop]=[%b]", new Object[] { Boolean.valueOf(this.e) }));
    if (!this.e)
    {
      this.j.removeMessages(1);
      this.j.sendEmptyMessageDelayed(1, a);
    }
  }
  
  private boolean h()
  {
    return this.f == ((EngineData)this.d.H()).i();
  }
  
  public void a()
  {
    g();
    f();
  }
  
  public void a(int paramInt)
  {
    com.tencent.avgame.gamelogic.QualityReporter.a = 0L;
    QLog.d("HeartBeatController", 1, String.format("stopHeartBeat() [roomId,fromType]=[%d,%d]", new Object[] { Long.valueOf(this.f), Integer.valueOf(paramInt) }));
    this.e = true;
    this.j.removeCallbacksAndMessages(null);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2)
  {
    if ((!this.e) && (h()))
    {
      if ((paramInt2 != 303) && (paramInt2 != 302))
      {
        this.g = paramLong1;
        this.h = SystemClock.elapsedRealtime();
        this.c.a(paramLong1, paramLong2, a, paramInt2);
        a = Math.max(paramInt1, a);
        f();
        return;
      }
      QLog.d("HeartBeatController", 1, String.format("onRespHeartBeatSuccess() EC_HEARTBEAT_USER_NOT_IN_ROOM exitRoom() [roomId]=[%d]", new Object[] { Long.valueOf(paramLong2) }));
      ObserverCenter.a().a(GameRoomObserver.class, 7, true, new Object[] { Long.valueOf(paramLong2), Integer.valueOf(4) });
      return;
    }
    QLog.d("HeartBeatController", 1, String.format("onRespHeartBeatSuccess() isStop or validRoomId just return  [roomId,data.getRoomId()]=[%d,%d]", new Object[] { Long.valueOf(paramLong2), Long.valueOf(((EngineData)this.d.H()).i()) }));
  }
  
  public void a(long paramLong, String paramString)
  {
    QLog.d("HeartBeatController", 1, String.format("startHeartBeat() [roomId,userUin]=[%d,%s]", new Object[] { Long.valueOf(paramLong), paramString }));
    this.j.removeCallbacksAndMessages(null);
    this.f = paramLong;
    this.i = paramString;
    this.e = false;
    b(paramLong, paramString);
    g();
    f();
  }
  
  public void b()
  {
    BaseAVGameAppInterface localBaseAVGameAppInterface = this.b;
    if (localBaseAVGameAppInterface != null) {
      localBaseAVGameAppInterface.removeObserver(this);
    }
    a(1);
  }
  
  public long c()
  {
    return this.g;
  }
  
  public long d()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.HeartBeatController
 * JD-Core Version:    0.7.0.1
 */