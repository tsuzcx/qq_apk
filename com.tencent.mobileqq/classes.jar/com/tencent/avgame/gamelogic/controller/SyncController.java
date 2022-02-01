package com.tencent.avgame.gamelogic.controller;

import android.os.SystemClock;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gamelogic.listener.SyncListener;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

public class SyncController
  implements SyncListener
{
  long a = 0L;
  long b = 0L;
  long c = 0L;
  BaseAVGameAppInterface d;
  
  public SyncController(BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    this.d = paramBaseAVGameAppInterface;
  }
  
  private boolean a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    long l = this.a;
    if (paramBoolean) {
      if (paramLong1 <= l) {}
    }
    boolean bool1;
    boolean bool2;
    for (this.a = paramLong1;; this.a = paramLong1)
    {
      bool1 = true;
      do
      {
        bool1 = false;
        bool2 = false;
        break;
      } while (paramLong1 <= l);
      if ((paramLong1 - l != 1L) && (l > 0L))
      {
        bool1 = false;
        bool2 = true;
        break;
      }
    }
    QLog.d("avgame_logic.SyncController", 1, String.format("onGetNewSeq [%d-->%d] result=%b needSync=%b fromSync=%b", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) }));
    if (bool2) {
      a(paramLong2, paramInt);
    }
    return bool1;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public long a(long paramLong, int paramInt)
  {
    String str = this.d.getCurrentAccountUin();
    boolean bool;
    if (!IGameEngine.J())
    {
      bool = IGameEngine.I().s().N();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("avgame_logic.SyncController", 2, "IGameEngine = null");
      }
      bool = false;
    }
    long l = this.a;
    int i = 1;
    QLog.d("avgame_logic.SyncController", 1, new Object[] { "reqPullSnapshot curSeq=", Long.valueOf(l), " roomId=", Long.valueOf(paramLong), " uin=", str, "isQQCJ=", Boolean.valueOf(bool) });
    l = System.currentTimeMillis();
    if (!bool) {
      i = 0;
    }
    ((GameRoomHandler)this.d.getBusinessHandler(HandlerFactory.a)).a(paramLong, str, true, paramInt, i);
    return l;
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (paramLong1 > this.a)
    {
      long l = SystemClock.elapsedRealtime();
      if ((this.b == paramLong1) && (l - this.c < paramInt1)) {
        return;
      }
      this.b = paramLong1;
      this.c = l;
      a(paramLong2, 2);
      if (QLog.isColorLevel())
      {
        paramLong2 = this.a;
        boolean bool = false;
        if (paramLong1 > this.a) {
          bool = true;
        }
        QLog.d("avgame_logic.SyncController", 1, String.format("onGetNewSeqByHeartBeat [%d-->%d] needSync=%b", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Boolean.valueOf(bool) }));
      }
    }
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.SyncController", 2, String.format("onGetNewSeqByPush [%d], roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    return a(paramLong1, paramLong2, false, 4);
  }
  
  public boolean a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.SyncController", 2, String.format("onGetNewSeqByPullResp [%d], roomId=%d fromSync=%b", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) }));
    }
    return a(paramLong1, paramLong2, paramBoolean, 3);
  }
  
  public void b()
  {
    this.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SyncController
 * JD-Core Version:    0.7.0.1
 */