package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.QualityReporter;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.HeartBeatListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.avgame.gamelogic.listener.SyncListener;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class StatusMonitor
  implements Handler.Callback
{
  BaseAVGameAppInterface a;
  GameRoomStatusListener b;
  IDataCtrl<EngineData> c;
  HeartBeatListener d;
  SyncListener e;
  Handler f;
  volatile boolean g = true;
  int h = -2147483648;
  int i = -2147483648;
  int j = 0;
  ITopic k;
  boolean l;
  
  public StatusMonitor(BaseAVGameAppInterface paramBaseAVGameAppInterface, HeartBeatListener paramHeartBeatListener, SyncListener paramSyncListener, GameRoomStatusListener paramGameRoomStatusListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.a = paramBaseAVGameAppInterface;
    this.b = paramGameRoomStatusListener;
    this.c = paramIDataCtrl;
    this.d = paramHeartBeatListener;
    this.e = paramSyncListener;
    this.f = new Handler(ThreadManager.getUIHandler().getLooper(), this);
  }
  
  private void a(EngineData paramEngineData)
  {
    if (this.l) {
      return;
    }
    ITopic localITopic = paramEngineData.s();
    if ((localITopic != null) && (!localITopic.a(this.k)))
    {
      this.k = localITopic;
      int n = this.h;
      int m = 1;
      if (n != -2147483648) {
        m = 1 + n;
      }
      this.h = m;
      if (this.i == -2147483648)
      {
        this.i = paramEngineData.H();
        this.j = paramEngineData.p();
      }
    }
  }
  
  private void b(EngineData paramEngineData, int paramInt)
  {
    paramInt += 10000;
    if (paramInt <= 0)
    {
      f();
      return;
    }
    this.f.sendEmptyMessageDelayed(0, paramInt);
  }
  
  private void b(EngineData paramEngineData, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTopicCountReport status=");
      localStringBuilder.append(paramEngineData.j());
      QLog.i("avgame_logic.StatusMonitor", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.l = paramBoolean;
    }
    int m = paramEngineData.j();
    if (m != 0) {
      if (m != 1)
      {
        if ((m != 2) && (m != 3) && (m != 4))
        {
          if (m == 10) {}
        }
        else {
          a(paramEngineData);
        }
      }
      else
      {
        i();
        h();
        a(paramEngineData);
        return;
      }
    }
    i();
    h();
  }
  
  private void d()
  {
    this.f.removeMessages(0);
  }
  
  private void e()
  {
    this.g = false;
  }
  
  private void f()
  {
    long l1 = this.d.d();
    long l2 = this.d.c();
    long l3 = SystemClock.elapsedRealtime();
    long l4 = this.e.a();
    if ((l3 - l1 < 10000L) && (l2 == l4))
    {
      QLog.d("avgame_logic.StatusMonitor", 1, String.format("handleStatusTimeout exit!!! [heartBeatSeq,localSeq]=[%d,%d] [heartBeatTs,curTs]=[%d,%d]", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l3) }));
      this.b.a(9, MobileQQ.sMobileQQ.getString(2131887242), (EngineData)this.c.H());
    }
  }
  
  private void g()
  {
    QLog.d("avgame_logic.StatusMonitor", 1, String.format("handleTopicTimeout exit!!!", new Object[0]));
    this.b.l();
  }
  
  private void h()
  {
    this.k = null;
    this.l = false;
    this.h = -2147483648;
    this.i = -2147483648;
    this.j = 0;
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.StatusMonitor", 2, String.format("doReportTopicCountIfNeed [inSnapshotRound=%b count=%d expectCount=%d gType=%d]", new Object[] { Boolean.valueOf(this.l), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j) }));
    }
    if (!this.l)
    {
      int m = this.h;
      if (m != -2147483648)
      {
        int n = this.i;
        if (n == -2147483648) {
          return;
        }
        if (n > m) {
          QualityReporter.a(n, m, n - m, this.j);
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.StatusMonitor", 2, "clearTopicTimeoutMonitor run");
    }
    this.f.removeMessages(1);
  }
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("startTopicTimeoutMonitor timeoutTs:");
      paramEngineData.append(paramInt);
      QLog.d("avgame_logic.StatusMonitor", 2, paramEngineData.toString());
    }
    this.f.removeMessages(1);
    this.f.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public void a(EngineData paramEngineData, boolean paramBoolean)
  {
    boolean bool = paramEngineData.z();
    int n = paramEngineData.j();
    if (n != 1)
    {
      if ((n != 2) && (n != 3) && (n != 4))
      {
        d();
      }
      else
      {
        e();
        if (bool)
        {
          d();
          b(paramEngineData, paramEngineData.h().f.c * 1000 - paramEngineData.h().o());
        }
      }
    }
    else
    {
      e();
      if (bool)
      {
        d();
        int i2 = paramEngineData.h().f.d * 1000;
        int i1 = paramEngineData.h().f.c;
        int i3 = paramEngineData.h().n();
        int m = 0;
        if (i2 > i3) {
          m = i2 - i3;
        }
        b(paramEngineData, m + i1 * 1000);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStatusChanged ");
      localStringBuilder.append(n);
      QLog.i("avgame_logic.StatusMonitor", 2, localStringBuilder.toString());
    }
    b(paramEngineData, paramBoolean);
  }
  
  public void b()
  {
    e();
    d();
    h();
    a();
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 0)
    {
      if (m == 1) {
        g();
      }
    }
    else {
      f();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.StatusMonitor
 * JD-Core Version:    0.7.0.1
 */