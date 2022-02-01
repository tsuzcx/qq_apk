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
  int jdField_a_of_type_Int = -2147483648;
  Handler jdField_a_of_type_AndroidOsHandler;
  ITopic jdField_a_of_type_ComTencentAvgameGamelogicITopic;
  GameRoomStatusListener jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
  HeartBeatListener jdField_a_of_type_ComTencentAvgameGamelogicListenerHeartBeatListener;
  IDataCtrl<EngineData> jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl;
  SyncListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener;
  BaseAVGameAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface;
  volatile boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = -2147483648;
  boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public StatusMonitor(BaseAVGameAppInterface paramBaseAVGameAppInterface, HeartBeatListener paramHeartBeatListener, SyncListener paramSyncListener, GameRoomStatusListener paramGameRoomStatusListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseAVGameAppInterface = paramBaseAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener = paramGameRoomStatusListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl = paramIDataCtrl;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerHeartBeatListener = paramHeartBeatListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener = paramSyncListener;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getUIHandler().getLooper(), this);
  }
  
  private void a(EngineData paramEngineData)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    ITopic localITopic = paramEngineData.a();
    if ((localITopic != null) && (!localITopic.a(this.jdField_a_of_type_ComTencentAvgameGamelogicITopic)))
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = localITopic;
      int j = this.jdField_a_of_type_Int;
      int i = 1;
      if (j != -2147483648) {
        i = 1 + j;
      }
      this.jdField_a_of_type_Int = i;
      if (this.jdField_b_of_type_Int == -2147483648)
      {
        this.jdField_b_of_type_Int = paramEngineData.g();
        this.c = paramEngineData.d();
      }
    }
  }
  
  private void b(EngineData paramEngineData, int paramInt)
  {
    paramInt += 10000;
    if (paramInt <= 0)
    {
      e();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramInt);
  }
  
  private void b(EngineData paramEngineData, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTopicCountReport status=");
      localStringBuilder.append(paramEngineData.a());
      QLog.i("avgame_logic.StatusMonitor", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    int i = paramEngineData.a();
    if (i != 0) {
      if (i != 1)
      {
        if ((i != 2) && (i != 3) && (i != 4))
        {
          if (i == 10) {}
        }
        else {
          a(paramEngineData);
        }
      }
      else
      {
        h();
        g();
        a(paramEngineData);
        return;
      }
    }
    h();
    g();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void e()
  {
    long l1 = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerHeartBeatListener.b();
    long l2 = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerHeartBeatListener.a();
    long l3 = SystemClock.elapsedRealtime();
    long l4 = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a();
    if ((l3 - l1 < 10000L) && (l2 == l4))
    {
      QLog.d("avgame_logic.StatusMonitor", 1, String.format("handleStatusTimeout exit!!! [heartBeatSeq,localSeq]=[%d,%d] [heartBeatTs,curTs]=[%d,%d]", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l3) }));
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(9, MobileQQ.sMobileQQ.getString(2131690331), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    }
  }
  
  private void f()
  {
    QLog.d("avgame_logic.StatusMonitor", 1, String.format("handleTopicTimeout exit!!!", new Object[0]));
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.k();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = -2147483648;
    this.c = 0;
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.StatusMonitor", 2, String.format("doReportTopicCountIfNeed [inSnapshotRound=%b count=%d expectCount=%d gType=%d]", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c) }));
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Int;
      if (i != -2147483648)
      {
        int j = this.jdField_b_of_type_Int;
        if (j == -2147483648) {
          return;
        }
        if (j > i) {
          QualityReporter.a(j, i, j - i, this.c);
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.StatusMonitor", 2, "clearTopicTimeoutMonitor run");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
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
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public void a(EngineData paramEngineData, boolean paramBoolean)
  {
    boolean bool = paramEngineData.d();
    int j = paramEngineData.a();
    if (j != 1)
    {
      if ((j != 2) && (j != 3) && (j != 4))
      {
        c();
      }
      else
      {
        d();
        if (bool)
        {
          c();
          b(paramEngineData, paramEngineData.a().a.c * 1000 - paramEngineData.a().e());
        }
      }
    }
    else
    {
      d();
      if (bool)
      {
        c();
        int m = paramEngineData.a().a.d * 1000;
        int k = paramEngineData.a().a.c;
        int n = paramEngineData.a().d();
        int i = 0;
        if (m > n) {
          i = m - n;
        }
        b(paramEngineData, i + k * 1000);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStatusChanged ");
      localStringBuilder.append(j);
      QLog.i("avgame_logic.StatusMonitor", 2, localStringBuilder.toString());
    }
    b(paramEngineData, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    d();
    c();
    g();
    a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i == 1) {
        f();
      }
    }
    else {
      e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.StatusMonitor
 * JD-Core Version:    0.7.0.1
 */