package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.QualityReporter;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.HeartBeatListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.avgame.gamelogic.listener.SyncListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class StatusMonitor
  implements Handler.Callback
{
  int jdField_a_of_type_Int = -2147483648;
  Handler jdField_a_of_type_AndroidOsHandler;
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  ITopic jdField_a_of_type_ComTencentAvgameGamelogicITopic;
  GameRoomStatusListener jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
  HeartBeatListener jdField_a_of_type_ComTencentAvgameGamelogicListenerHeartBeatListener;
  IDataCtrl<EngineData> jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl;
  SyncListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener;
  volatile boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = -2147483648;
  boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public StatusMonitor(AVGameAppInterface paramAVGameAppInterface, HeartBeatListener paramHeartBeatListener, SyncListener paramSyncListener, GameRoomStatusListener paramGameRoomStatusListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener = paramGameRoomStatusListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl = paramIDataCtrl;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerHeartBeatListener = paramHeartBeatListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener = paramSyncListener;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getUIHandler().getLooper(), this);
  }
  
  private void a(EngineData paramEngineData)
  {
    if (this.jdField_b_of_type_Boolean) {}
    ITopic localITopic;
    do
    {
      return;
      localITopic = paramEngineData.a();
    } while ((localITopic == null) || (localITopic.a(this.jdField_a_of_type_ComTencentAvgameGamelogicITopic)));
    this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = localITopic;
    if (this.jdField_a_of_type_Int == -2147483648) {}
    for (int i = 1;; i = this.jdField_a_of_type_Int + 1)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_b_of_type_Int != -2147483648) {
        break;
      }
      this.jdField_b_of_type_Int = paramEngineData.g();
      this.c = paramEngineData.d();
      return;
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
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.StatusMonitor", 2, "handleTopicCountReport status=" + paramEngineData.a());
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    switch (paramEngineData.a())
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return;
    case 1: 
      h();
      g();
      a(paramEngineData);
      return;
    case 2: 
    case 3: 
    case 4: 
      a(paramEngineData);
      return;
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
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(9, BaseApplicationImpl.getApplication().getString(2131690407), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
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
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == -2147483648) || (this.jdField_b_of_type_Int == -2147483648)) {}
    while (this.jdField_b_of_type_Int <= this.jdField_a_of_type_Int) {
      return;
    }
    QualityReporter.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - this.jdField_a_of_type_Int, this.c);
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
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.StatusMonitor", 2, "startTopicTimeoutMonitor timeoutTs:" + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public void a(EngineData paramEngineData, boolean paramBoolean)
  {
    boolean bool = paramEngineData.d();
    int j = paramEngineData.a();
    switch (j)
    {
    default: 
      c();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.StatusMonitor", 2, "onStatusChanged " + j);
      }
      b(paramEngineData, paramBoolean);
      return;
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
        continue;
        d();
        if (bool)
        {
          c();
          b(paramEngineData, paramEngineData.a().a.c * 1000 - paramEngineData.a().e());
        }
      }
    }
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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      e();
      continue;
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.StatusMonitor
 * JD-Core Version:    0.7.0.1
 */