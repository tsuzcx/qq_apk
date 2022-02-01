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
  private static HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new HeartBeatController.1(this);
  private IDataCtrl<EngineData> jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl;
  private SyncListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener;
  private BaseAVGameAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  static
  {
    Object localObject1 = jdField_a_of_type_JavaUtilHashMap;
    Object localObject2 = Integer.valueOf(1);
    ((HashMap)localObject1).put(Integer.valueOf(0), localObject2);
    Object localObject3 = jdField_a_of_type_JavaUtilHashMap;
    localObject1 = Integer.valueOf(2);
    ((HashMap)localObject3).put(localObject2, localObject1);
    jdField_a_of_type_JavaUtilHashMap.put(localObject1, localObject1);
    localObject2 = jdField_a_of_type_JavaUtilHashMap;
    localObject3 = Integer.valueOf(3);
    ((HashMap)localObject2).put(localObject3, localObject1);
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), localObject1);
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), localObject3);
  }
  
  public HeartBeatController(BaseAVGameAppInterface paramBaseAVGameAppInterface, SyncListener paramSyncListener, GameRoomStatusListener paramGameRoomStatusListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface = paramBaseAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener = paramSyncListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl = paramIDataCtrl;
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.addObserver(this, false);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Long == ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a();
  }
  
  private void b(long paramLong, String paramString)
  {
    GameRoomHandler localGameRoomHandler = (GameRoomHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.jdField_a_of_type_JavaLangString);
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()));
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.intValue();
    }
    localGameRoomHandler.a(paramLong, paramString, i);
    com.tencent.avgame.gamelogic.QualityReporter.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void c()
  {
    int i;
    if (NetworkUtil.isNetworkAvailable()) {
      i = 2131690331;
    } else {
      i = 2131690403;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopHeartBeatByLocalTimeOut() then do exitRoom() isNetworkAvailable =");
    localStringBuilder.append(NetworkUtil.isNetworkAvailable());
    QLog.d("HeartBeatController", 1, localStringBuilder.toString());
    IGameEngine.a().a(5, MobileQQ.sMobileQQ.getApplicationContext().getString(i), IGameEngine.a().a());
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 35000L);
  }
  
  private void e()
  {
    QLog.d("HeartBeatController", 1, String.format("maintainHeartBeat() [isStop]=[%b]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, jdField_a_of_type_Int);
    }
  }
  
  public long a()
  {
    return this.b;
  }
  
  public void a()
  {
    e();
    d();
  }
  
  public void a(int paramInt)
  {
    com.tencent.avgame.gamelogic.QualityReporter.jdField_a_of_type_Long = 0L;
    QLog.d("HeartBeatController", 1, String.format("stopHeartBeat() [roomId,fromType]=[%d,%d]", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(paramInt) }));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2)
  {
    if ((!this.jdField_a_of_type_Boolean) && (a()))
    {
      if ((paramInt2 != 303) && (paramInt2 != 302))
      {
        this.b = paramLong1;
        this.c = SystemClock.elapsedRealtime();
        this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(paramLong1, paramLong2, jdField_a_of_type_Int, paramInt2);
        jdField_a_of_type_Int = Math.max(paramInt1, jdField_a_of_type_Int);
        d();
        return;
      }
      QLog.d("HeartBeatController", 1, String.format("onRespHeartBeatSuccess() EC_HEARTBEAT_USER_NOT_IN_ROOM exitRoom() [roomId]=[%d]", new Object[] { Long.valueOf(paramLong2) }));
      ObserverCenter.a().a(GameRoomObserver.class, 7, true, new Object[] { Long.valueOf(paramLong2), Integer.valueOf(4) });
      return;
    }
    QLog.d("HeartBeatController", 1, String.format("onRespHeartBeatSuccess() isStop or validRoomId just return  [roomId,data.getRoomId()]=[%d,%d]", new Object[] { Long.valueOf(paramLong2), Long.valueOf(((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()) }));
  }
  
  public void a(long paramLong, String paramString)
  {
    QLog.d("HeartBeatController", 1, String.format("startHeartBeat() [roomId,userUin]=[%d,%s]", new Object[] { Long.valueOf(paramLong), paramString }));
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
    b(paramLong, paramString);
    e();
    d();
  }
  
  public long b()
  {
    return this.c;
  }
  
  public void b()
  {
    BaseAVGameAppInterface localBaseAVGameAppInterface = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface;
    if (localBaseAVGameAppInterface != null) {
      localBaseAVGameAppInterface.removeObserver(this);
    }
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.HeartBeatController
 * JD-Core Version:    0.7.0.1
 */