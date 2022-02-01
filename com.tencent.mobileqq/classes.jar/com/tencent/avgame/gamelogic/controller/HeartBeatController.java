package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.TMG.utils.QLog;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.HeartBeatListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.avgame.gamelogic.listener.SyncListener;
import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.HashMap;

public class HeartBeatController
  extends GameRoomObserver
  implements HeartBeatListener
{
  public static int a;
  private static HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new HeartBeatController.1(this);
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private IDataCtrl<EngineData> jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl;
  private SyncListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  static
  {
    jdField_a_of_type_Int = 2000;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), Integer.valueOf(3));
  }
  
  public HeartBeatController(AVGameAppInterface paramAVGameAppInterface, SyncListener paramSyncListener, GameRoomStatusListener paramGameRoomStatusListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener = paramSyncListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl = paramIDataCtrl;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this, false);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Long == ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a();
  }
  
  private void b(long paramLong, String paramString)
  {
    GameRoomHandler localGameRoomHandler = (GameRoomHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.jdField_a_of_type_JavaLangString);
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()));
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      localGameRoomHandler.a(paramLong, paramString, i);
      com.tencent.avgame.gamelogic.QualityReporter.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  private void c()
  {
    if (NetworkUtil.a()) {}
    for (int i = 2131690407;; i = 2131690479)
    {
      QLog.d("HeartBeatController", 1, "stopHeartBeatByLocalTimeOut() then do exitRoom() isNetworkAvailable =" + NetworkUtil.a());
      GameEngine.a().a(5, BaseApplicationImpl.getApplication().getString(i), GameEngine.a().a());
      return;
    }
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
    if ((this.jdField_a_of_type_Boolean) || (!a()))
    {
      QLog.d("HeartBeatController", 1, String.format("onRespHeartBeatSuccess() isStop or validRoomId just return  [roomId,data.getRoomId()]=[%d,%d]", new Object[] { Long.valueOf(paramLong2), Long.valueOf(((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()) }));
      return;
    }
    if (paramInt2 == 303)
    {
      QLog.d("HeartBeatController", 1, String.format("onRespHeartBeatSuccess() EC_HEARTBEAT_USER_NOT_IN_ROOM exitRoom() [roomId]=[%d]", new Object[] { Long.valueOf(paramLong2) }));
      ObserverCenter.a().a(GameRoomObserver.class, 7, true, new Object[] { Long.valueOf(paramLong2), Integer.valueOf(4) });
      return;
    }
    this.b = paramLong1;
    this.c = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(paramLong1, paramLong2, jdField_a_of_type_Int, paramInt2);
    jdField_a_of_type_Int = Math.max(paramInt1, jdField_a_of_type_Int);
    d();
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
    if (this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this);
    }
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.HeartBeatController
 * JD-Core Version:    0.7.0.1
 */