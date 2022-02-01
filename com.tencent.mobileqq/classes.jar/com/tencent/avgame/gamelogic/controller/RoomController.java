package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.business.observer.UserInfoObserver;
import com.tencent.avgame.gamelogic.DelayNotifyRunnable;
import com.tencent.avgame.gamelogic.DelayNotifyRunnable.IOnDelayNotifyDoneListener;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGame;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.PkCJOperationData;
import com.tencent.avgame.gamelogic.data.QuestionClassInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.avgame.gamelogic.handler.GamePlayHandler;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.avgame.gamelogic.listener.SyncListener;
import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RoomController
  extends GameRoomObserver
  implements Handler.Callback, DelayNotifyRunnable.IOnDelayNotifyDoneListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private UserInfoObserver jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver = new RoomController.1(this);
  private ISurvivalRoomController jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController;
  private GameRoomHandler jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler;
  private GameRoomStatusListener jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
  private IDataCtrl<EngineData> jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl;
  private SyncListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener;
  List<DelayNotifyRunnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private Handler b = null;
  
  public RoomController(AVGameAppInterface paramAVGameAppInterface, GameRoomStatusListener paramGameRoomStatusListener, SyncListener paramSyncListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener = paramGameRoomStatusListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener = paramSyncListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl = paramIDataCtrl;
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler = ((GameRoomHandler)paramAVGameAppInterface.getBusinessHandler(HandlerFactory.a));
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this, false);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver, false);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController = new SurvivalRoomController(this);
  }
  
  private void a(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when roomInfo update %s", new Object[] { paramEngineData.a() }));
    }
    paramEngineData.a(((UserInfoHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.b)).a(paramEngineData.a().getUins()));
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 0)
    {
      i -= 1;
      while (i >= 0)
      {
        DelayNotifyRunnable localDelayNotifyRunnable = (DelayNotifyRunnable)this.jdField_a_of_type_JavaUtilList.get(i);
        String str = (String)localDelayNotifyRunnable.a();
        if ((str != null) && (paramHashMap.containsKey(str)))
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localDelayNotifyRunnable);
          this.jdField_a_of_type_JavaUtilList.remove(i);
          localDelayNotifyRunnable.a((String)paramHashMap.get(str));
        }
        i -= 1;
      }
    }
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(paramLong1, paramLong2, false))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format(" bValidSeq=false seq=%d, roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      return false;
    }
    return true;
  }
  
  private boolean a(long paramLong, String paramString)
  {
    EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    if ((paramLong == 0L) || (paramLong != localEngineData.a()))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format("%s bValidSession=false [svrRId,locRId]=[%d,%d]", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(localEngineData.a()) }));
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo.getPlayer(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount()) == null)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(6, BaseApplicationImpl.getApplication().getString(2131690407), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      return false;
    }
    paramRoomInfo = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    int i = paramRoomInfo.a();
    int j = paramRoomInfo.b();
    if ((j == 1) && (i == 10)) {
      paramRoomInfo.a(paramString, j);
    }
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    int i;
    if (paramInt == 0)
    {
      localObject = (Object[])paramObject;
      paramObject = (String)localObject[0];
      i = ((Integer)localObject[1]).intValue();
      localObject = (String)localObject[2];
      if (1 != i) {
        break label147;
      }
      paramObject = String.format(BaseApplicationImpl.getApplication().getString(2131690401), new Object[] { ContactUtils.a(paramObject, 8.0F) });
    }
    for (;;)
    {
      localStringBuilder.append(paramObject);
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(paramObject, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onDelayNotifyDone nt=%d result=%s", new Object[] { Integer.valueOf(paramInt), localStringBuilder.toString() }));
      }
      return;
      label147:
      if (2 == i) {
        paramObject = String.format(BaseApplicationImpl.getApplication().getString(2131690402), new Object[] { ContactUtils.a(paramObject, 5.0F), ContactUtils.a((String)localObject, 5.0F) });
      } else {
        paramObject = "";
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameListFailed() roomId=" + paramLong);
    }
    if (!a(paramLong, "onGetGameListSuccess()")) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.g();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoFailed() roomId = " + paramLong + " data =" + this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    }
    if (paramLong == ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramInt, BaseApplicationImpl.getApplication().getString(2131690407), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString, RoomInfo paramRoomInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onLeaveGameRoomSuccess() leaveType =" + paramInt + " kickUin = " + paramString);
    }
    if (GameEngine.a().f()) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController.a(paramLong, paramInt, paramString, paramRoomInfo);
    }
    do
    {
      return;
      if (2 != paramInt) {
        break;
      }
    } while (!a(paramLong, "onLeaveGameRoomSuccess(kick)"));
    a(paramRoomInfo, false);
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(2, paramString, null, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    ReportController.b(null, "dc00898", "", "", "0X800B02E", "0X800B02E", 0, 0, paramString, "" + paramLong, "", "");
    return;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramInt, null, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B030", "0X800B030", paramInt, 0, "", "" + paramLong, "", "");
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onLeaveGameRoomFailed() leaveType =" + paramInt + " kickUin = " + paramString1 + " errorMsg = " + paramString2);
    }
    if (GameEngine.a().i()) {
      if (GameEngine.a().a().m()) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      CJSurvivalFestivalReporter.a(13, true, "-1", paramString2, bool);
      if (2 != paramInt) {
        break label154;
      }
      if (a(paramLong, "onLeaveGameRoomFailed(kick)")) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(-2, paramString1, BaseApplicationImpl.getApplication().getString(2131690438), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      label154:
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramInt, null, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameSuccess roomId=" + paramLong2);
    }
    if (!a(paramLong2, "onSelectGameSuccess()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameSuccess() seq is invalid just return");
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.h();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (!a(paramLong2, "pushOnGameChange()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnGameChange() seq is invalid just return");
      return;
    }
    EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    localEngineData.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnGameChange() newIndex = " + localEngineData.a);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(localEngineData);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, RoomInfo paramRoomInfo)
  {
    if (!a(paramLong2, "pushOnRoomEnter()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomEnter() seq is invalid just return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("pushOnRoomEnter seq=%d rId=%d enterType=%d enterUin=%s inviterUin=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt), paramString1, paramString2 }));
    }
    a(paramRoomInfo, false);
    if (((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).f())
    {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).f(2);
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.c(paramString1, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin().equals(paramString1))
    {
      paramRoomInfo = ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString1);
      paramString2 = ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString2);
      if ((paramRoomInfo != null) && (!paramRoomInfo.equalsIgnoreCase(paramString1))) {}
      for (int i = 1;; i = 0)
      {
        paramString1 = new DelayNotifyRunnable(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, 0, this, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
        if (i == 0) {
          break;
        }
        paramString1.a(paramRoomInfo);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramString1, 1500L);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b("", (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, RoomInfo paramRoomInfo, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    if (!a(paramLong2, "pushOnRoomExit()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomExit seq is invalid just return");
      return;
    }
    int i = 0;
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 0) {
      if (paramInt3 == 1) {
        if (paramString1.equals(str))
        {
          if (!paramString1.equals(String.valueOf(paramRoomInfo.owner))) {
            break label842;
          }
          paramInt2 = 1;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != 0) {
        GameEngine.a().f();
      }
      a(paramRoomInfo, false);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomExit() isMine = " + bool1 + " tips = " + paramString4);
      }
      if ((!bool1) && (((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).f()))
      {
        i = ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a();
        if ((i != 10) && (i != 0)) {
          ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).f(9);
        }
      }
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(3, paramString4, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
        if (paramInt3 != 1) {
          break;
        }
        if (paramInt2 != 0)
        {
          ReportController.b(null, "dc00898", "", "", "0X800B35A", "0X800B35A", 0, 0, "", "", "", "");
          return;
          if (!str.equals(String.valueOf(paramRoomInfo.owner))) {
            break label826;
          }
          paramString4 = paramString3.replace("#", ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString1));
          bool1 = bool2;
          paramInt2 = i;
          continue;
          if ((paramInt2 != 1) || (!paramString1.equals(str))) {
            break label826;
          }
          bool1 = true;
          if (NetworkUtil.a()) {}
          for (paramInt2 = 2131690407;; paramInt2 = 2131690479)
          {
            paramString4 = BaseApplicationImpl.getApplication().getString(paramInt2);
            paramInt2 = i;
            break;
          }
          if (1 == paramInt1)
          {
            if ((paramInt3 == 1) && (paramString1.equals(str)))
            {
              paramInt2 = 1;
              bool1 = true;
              continue;
            }
            if ((paramInt2 == 1) && (paramString1.equals(str)))
            {
              bool1 = true;
              if (NetworkUtil.a()) {}
              for (paramInt2 = 2131690407;; paramInt2 = 2131690479)
              {
                paramString4 = BaseApplicationImpl.getApplication().getString(paramInt2);
                paramInt2 = i;
                break;
              }
            }
            paramString4 = String.format(BaseApplicationImpl.getApplication().getString(2131690476), new Object[] { ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString2, 8) });
            bool1 = bool2;
            paramInt2 = i;
            if (!((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).f()) {
              continue;
            }
            paramString4 = "";
            bool1 = bool2;
            paramInt2 = i;
            continue;
          }
          if (2 != paramInt1) {
            break label826;
          }
          if (paramString1.equals(str))
          {
            paramString4 = BaseApplicationImpl.getApplication().getString(2131690439);
            bool1 = true;
            paramInt2 = i;
            continue;
          }
          paramString4 = String.format(BaseApplicationImpl.getApplication().getString(2131690440), new Object[] { ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString1, 8) });
          bool1 = bool2;
          paramInt2 = i;
          continue;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B35C", "0X800B35C", 0, 0, "", "", "", "");
        return;
      }
      if ((paramInt1 != 1) && (paramInt3 == 1) && (str.equals(String.valueOf(paramRoomInfo.owner))) && (!paramString1.equals(str)))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(3, paramString1, paramString4, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
        ReportController.b(null, "dc00898", "", "", "0X800B35B", "0X800B35B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(1, paramString1, paramString4, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      return;
      label826:
      paramString4 = "";
      bool1 = bool2;
      paramInt2 = i;
      continue;
      label842:
      bool1 = true;
      paramInt2 = i;
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt, RoomInfo paramRoomInfo)
  {
    if (!a(paramLong2, "pushOnChangeUserStatus()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnChangeUserStatus() seq is invalid just return");
      return;
    }
    a(paramRoomInfo, false);
    ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnChangeUserStatus() uin = " + paramString + " userStatusType =" + paramInt);
    }
    paramRoomInfo = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramString, paramInt, paramRoomInfo);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("avgame_logic.GameRoomController", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusFailed() errorMsg =" + paramString + "errorCode = " + paramInt1 + " from = " + paramInt2);
    }
    if (!a(paramLong, "onChangeUserStatusFailed()")) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2 + " isHostUser =" + ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).e(paramString1));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).e(paramString1))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong, 2, paramString1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, List<QuestionClassInfo> paramList, String paramString2, String paramString3)
  {
    if (!a(paramLong, "onGetGameQuestionClass()")) {
      return;
    }
    ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramList, paramString2, paramString3);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    boolean bool = GameEngine.a().i();
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString + " isQQCJ =" + bool);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong, 1, paramString, paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.b(paramLong, 1, paramString, paramString);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoFailed() uin = " + paramString1 + " isFromSync =" + paramBoolean + " fromType=" + paramInt1);
    }
    if (!a(paramLong, "onGetGameRoomInfoFailed()")) {
      return;
    }
    if (((paramInt2 == 106) || (paramInt2 == 111)) && (paramLong == ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()))
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(6, BaseApplicationImpl.getApplication().getString(2131690407), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramLong, paramString1, paramBoolean, paramString2, paramInt2);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = GameEngine.a().i();
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2 + " isQQCJ=" + bool);
    }
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong, paramString, paramBoolean1, 1, i);
      return;
    }
  }
  
  public void a(RoomInfo paramRoomInfo, int paramInt)
  {
    if (paramRoomInfo == null) {}
    for (long l = 0L; !a(l, "onChangeUserStatusSuccess()"); l = paramRoomInfo.id) {
      return;
    }
    if (!a(paramRoomInfo.seq, paramRoomInfo.id))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusSuccess() seq is invalid just return");
      return;
    }
    a(paramRoomInfo, false);
    if ((paramInt == 4) || (paramInt == 2)) {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), 1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusSuccess() and from = " + paramInt);
    }
    paramRoomInfo = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramRoomInfo, paramInt);
  }
  
  public void a(RoomInfo paramRoomInfo, Game paramGame, List<UserScore> paramList, List<GameItem> paramList1, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    paramGame.a(paramString1.a());
    paramString1.a(paramRoomInfo, false);
    paramString1.a(paramList1, paramInt);
    paramString1.a(paramGame);
    paramString1.a(paramList);
    if ((GameUtil.b(paramString1.c())) && (paramString1.a().size() == 0) && (paramString1.a() >= 0) && (paramString1.a() <= 10)) {
      ((GamePlayHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.c)).a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b(), false);
    }
    if (paramRoomInfo != null) {
      a(paramString1);
    }
  }
  
  public void a(RoomInfo paramRoomInfo, boolean paramBoolean)
  {
    if (paramRoomInfo == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a();
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(paramRoomInfo.seq, paramRoomInfo.id, false);
    }
    EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    localEngineData.a(paramRoomInfo, paramBoolean);
    a(localEngineData);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "selectGame roomId = " + paramLong + " uin = " + paramString + " isHost =" + ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).e(paramString));
    }
    if ((TextUtils.isEmpty(paramString)) || (!((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).e(paramString))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramString, paramLong, paramInt);
  }
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, RoomInfo paramRoomInfo, IGame paramIGame, List<UserScore> paramList, List<GameItem> paramList1, int paramInt2, String paramString2, String paramString3)
  {
    long l1 = paramRoomInfo.seq;
    long l2 = paramRoomInfo.id;
    if (!a(l2, "onGetGameRoomInfoSuccess()")) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(l1, l2, paramBoolean))
      {
        QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoSuccess() seq is invalid just return");
        return;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramRoomInfo, (Game)paramIGame, paramList, paramList1, paramInt2, paramString2, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetSnapshotSuc() fromEnter=%b curGameIndex=%d roomInfo=[%s] game=[%s] scores=[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRoomInfo, paramIGame, Arrays.toString(paramList.toArray()) }));
      }
    } while (!a(paramString1, paramRoomInfo));
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.c((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a(), paramInt1);
    return;
    a(paramRoomInfo, false);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetGameRoomInfoSuccess() roomInfo=[%s]", new Object[] { paramRoomInfo }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramString1, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
  }
  
  public void a(List<GameItem> paramList, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameListSuccess() curGameIndex = " + paramInt + " resUrl =" + paramString1 + " resMd5 =" + paramString2);
    }
    if (!a(paramLong, "onGetGameListSuccess()")) {}
    do
    {
      return;
      paramString1 = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
      paramString1.a(paramList, paramInt);
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramString1);
    } while ((paramList == null) || (paramList.size() <= 0));
    paramString1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramString1.add(Integer.valueOf(((GameItem)paramList.next()).a));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong, paramString1);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPkPoolUserChange isSuc:%b option:%d pkTotalNum:%d listSize:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.size()) }));
    }
    if (paramBoolean)
    {
      EngineData localEngineData = GameEngine.a().a();
      localEngineData.c(paramInt2);
      localEngineData.d(Math.max(localEngineData.m(), paramInt2));
      localEngineData.b(paramList, paramInt1);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, "");
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, List<Long> paramList, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPKInfoResult isSuc:%b interval:%d pkTotalNum:%d isChange:%b realId:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString }));
    }
    EngineData localEngineData = GameEngine.a().a();
    if (paramBoolean1)
    {
      localEngineData.c(paramInt2);
      localEngineData.d(Math.max(localEngineData.m(), paramInt2));
      localEngineData.a(paramList);
      localEngineData.c(paramBoolean3);
      if (paramBoolean2) {
        localEngineData.b(paramInt3);
      }
      paramList = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
      if ((!paramBoolean1) || (paramInt4 != 0)) {
        break label257;
      }
    }
    label257:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      paramList.a(paramBoolean2, paramString);
      if (this.b == null) {
        this.b = new Handler(this);
      }
      if (!paramBoolean1) {
        break label263;
      }
      if ((paramInt1 > 0) && (paramInt4 != 652))
      {
        this.b.removeMessages(0);
        this.b.sendEmptyMessageDelayed(0, paramInt1);
      }
      return;
      if (!localEngineData.g()) {
        break;
      }
      if (!localEngineData.m()) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        CJSurvivalFestivalReporter.a(4, true, String.valueOf(paramInt4), null, paramBoolean2);
        break;
      }
    }
    label263:
    this.b.removeMessages(0);
    this.b.sendEmptyMessageDelayed(0, 1000L);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onCreateRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onStartStrangerMatch isSuc=" + paramBoolean + " roomId=" + paramLong + " shareId=" + paramInt1 + " errCod=" + paramInt2 + " errMsg=" + paramString);
    }
    if (paramBoolean)
    {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramLong, 1);
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).b(paramLong, paramInt1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
      return;
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramLong, 0);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onStopStrangerMatch isSuc=" + paramBoolean + " roomId=" + paramLong + " errCod=" + paramInt + " errMsg=" + paramString);
    }
    if (paramBoolean)
    {
      EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
      localEngineData.b(paramLong, 0);
      localEngineData.a(paramLong, 0);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, paramLong, paramInt, paramString);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onStartStrangerMatchV2 isSuc=").append(paramBoolean).append(" roomId=").append(paramLong).append(" gameType=").append(paramInt1).append(" info=");
      if (paramArrayOfByte != null)
      {
        localObject = Integer.valueOf(paramArrayOfByte.length);
        QLog.i("avgame_logic.GameRoomController", 2, localObject + " errCod=" + paramInt2 + " errMsg=" + paramString);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label169;
      }
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramLong, 1);
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, paramLong, paramInt1, paramArrayOfByte, paramInt2, paramString);
      return;
      localObject = "null";
      break;
      label169:
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramLong, 0);
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(null);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPkUserResult isSuc:%b resultStatus:%d curStatus:%d exitRoom:%b info:%s curRoomId=%d roomId=%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(GameEngine.a().a().o()), Boolean.valueOf(paramBoolean2), paramSurvivalPkResultInfo, Long.valueOf(GameEngine.a().a().a()), Long.valueOf(paramLong2) }));
    }
    if ((GameEngine.a().a().a() != 0L) && (GameEngine.a().a().o() == 0) && ((paramInt == 3) || (paramInt == 4) || (paramInt == 2))) {}
    Object localObject;
    int i;
    label205:
    label238:
    do
    {
      return;
      GameEngine.a().a().a(paramSurvivalPkResultInfo);
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController.a();
      }
      if (paramInt != 2) {
        break label378;
      }
      GameEngine.a().a().f(5);
      if (this.b != null)
      {
        this.b.removeMessages(0);
        localObject = this.b;
        if (!paramBoolean2) {
          break;
        }
        i = 1;
        localObject = ((Handler)localObject).obtainMessage(1, i, paramInt);
        this.b.removeMessages(1);
        this.b.sendMessageDelayed((Message)localObject, 4000L);
      }
      if (((paramInt == 1) || (paramInt == 4) || (paramInt == 5)) && (GameEngine.a().a().i())) {
        GameEngine.a().n();
      }
      GameEngine.a().p();
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean1, paramInt, paramBoolean2, paramSurvivalPkResultInfo);
    } while ((paramInt != 1) && (paramInt != 2) && (paramInt != 3));
    if (paramInt == 2) {
      i = 3;
    }
    for (;;)
    {
      paramInt = GameEngine.a().a().a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount());
      if ((paramSurvivalPkResultInfo.score <= 0) || (paramSurvivalPkResultInfo.score == paramInt)) {
        break;
      }
      CJSurvivalFestivalReporter.a(paramInt, paramSurvivalPkResultInfo.score, i);
      return;
      i = 0;
      break label205;
      label378:
      if (paramInt == 1)
      {
        GameEngine.a().a().f(4);
        GameEngine.a().a().g(paramSurvivalPkResultInfo.winRound);
        if (this.b == null) {
          break label238;
        }
        localObject = this.b;
        if (paramBoolean2) {}
        for (i = 1;; i = 0)
        {
          localObject = ((Handler)localObject).obtainMessage(3, i, 0);
          this.b.removeMessages(3);
          this.b.sendMessageDelayed((Message)localObject, 4000L);
          break;
        }
      }
      if (paramInt == 3)
      {
        GameEngine.a().a().f(10);
        if (this.b == null) {
          break label238;
        }
        this.b.removeMessages(0);
        localObject = this.b;
        if (paramBoolean2) {}
        for (i = 1;; i = 0)
        {
          localObject = ((Handler)localObject).obtainMessage(2, i, paramInt);
          this.b.removeMessages(2);
          this.b.sendMessageDelayed((Message)localObject, 4000L);
          break;
        }
      }
      if (paramInt == 4)
      {
        GameEngine.a().a().g(paramSurvivalPkResultInfo.winRound);
        GameEngine.a().a().f(4);
        if (this.b == null) {
          break label238;
        }
        localObject = this.b;
        if (paramBoolean2) {}
        for (i = 1;; i = 0)
        {
          localObject = ((Handler)localObject).obtainMessage(3, i, 0);
          this.b.removeMessages(3);
          this.b.sendMessageDelayed((Message)localObject, 4000L);
          break;
        }
      }
      if (paramInt != 5) {
        break label238;
      }
      GameEngine.a().a().g(paramSurvivalPkResultInfo.winRound);
      GameEngine.a().a().f(8);
      if (this.b == null) {
        break label238;
      }
      localObject = this.b;
      if (paramBoolean2) {}
      for (i = 1;; i = 0)
      {
        localObject = ((Handler)localObject).obtainMessage(3, i, 0);
        this.b.removeMessages(3);
        this.b.sendMessageDelayed((Message)localObject, 4000L);
        break;
      }
      i = paramInt;
      if (paramInt == 3) {
        i = 2;
      }
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2, boolean paramBoolean3, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onSurvivalPkRoomAction isSuc:%b create:%b roomId:%d needAVRoom:%b peerUin:%d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean3), Long.valueOf(paramLong3) }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController.a(paramBoolean1, paramLong1, paramBoolean2, paramLong2, paramBoolean3, paramLong3);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString, PkCJOperationData paramPkCJOperationData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onSurvivalResult isSuc:%b exit:%b poolId:%d startNum:%d errCode:%d errMsg:%s cjData=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramPkCJOperationData }));
    }
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject;
    if (paramBoolean1)
    {
      localObject = GameEngine.a().a();
      if (paramBoolean2)
      {
        ((EngineData)localObject).f(0);
        ((EngineData)localObject).b(0);
        ((EngineData)localObject).b(true);
        ((EngineData)localObject).a(false);
        ((EngineData)localObject).a(new PkCJOperationData());
        ((EngineData)localObject).e(0);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      GameEngine.a().a().h(paramInt2);
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean1, paramInt3, paramString, bool1);
      }
      return;
      if (((EngineData)localObject).j() == 0)
      {
        bool1 = true;
        ((EngineData)localObject).b(paramInt1);
        ((EngineData)localObject).a(paramPkCJOperationData.isCJ());
        ((EngineData)localObject).b(paramPkCJOperationData.hasAVRoom());
        ((EngineData)localObject).a(paramPkCJOperationData);
        GameEngine.a().n();
      }
      ((EngineData)localObject).g(paramPkCJOperationData.curRound);
      ((EngineData)localObject).e(1);
      continue;
      paramPkCJOperationData = GameEngine.a().a();
      bool1 = bool2;
      if (paramPkCJOperationData.g())
      {
        if (paramInt3 == 0)
        {
          paramInt1 = -1;
          label267:
          localObject = String.valueOf(paramInt1);
          if (!paramBoolean2) {
            break label318;
          }
          if (paramPkCJOperationData.m()) {
            break label312;
          }
        }
        label312:
        for (bool1 = true;; bool1 = false)
        {
          CJSurvivalFestivalReporter.a(11, true, (String)localObject, null, bool1);
          bool1 = bool2;
          break;
          paramInt1 = paramInt3;
          break label267;
        }
        label318:
        if (paramPkCJOperationData.j() != 0) {
          break;
        }
        CJSurvivalFestivalReporter.a(3, false, (String)localObject, null, true);
        bool1 = bool2;
      }
    }
    if (!paramPkCJOperationData.m()) {}
    for (bool1 = true;; bool1 = false)
    {
      CJSurvivalFestivalReporter.a(10, true, (String)localObject, null, bool1);
      bool1 = bool2;
      break;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "getGameRoomList roomId = " + paramLong);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong);
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onRoomMatchStatusChange roomId=" + paramLong + " matchStatus=" + paramInt);
    }
    if (!a(paramLong, "onRoomMatchStatusChange()")) {
      return;
    }
    EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    localEngineData.a(paramLong, paramInt);
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramLong, localEngineData.a(localEngineData.e(GameEngine.a().a().getCurrentAccountUin())));
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameFailed() Failed");
    }
    if (!a(paramLong2, "onSelectGameFailed()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameFailed() seq is invalid just return");
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.i();
  }
  
  public void b(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = GameEngine.a().i();
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1 + " isQQCJ =" + bool);
    }
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong, paramString, paramInt1, paramInt2, i);
      return;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onJoinRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onStartStrangerMatch isSuc=" + paramBoolean + " roomId=" + paramLong + " gameType=" + paramInt1 + " errCod=" + paramInt2 + " errMsg=" + paramString);
    }
    if (paramBoolean)
    {
      EngineData localEngineData = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
      localEngineData.a(paramLong, 0);
      localEngineData.a(null);
      localEngineData.e(false);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController.b();
    a();
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "destroy() ");
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomDestroy()");
    }
    if (!a(paramLong2, "pushOnRoomDestroy()")) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(7, BaseApplicationImpl.getApplication().getString(2131690527), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
  }
  
  public void d(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onPkMatchTimeout");
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.j();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 2: 
    case 1: 
      do
      {
        do
        {
          return false;
          GameEngine.a().n();
          return false;
        } while (GameEngine.a().a().o() != 10);
        GameEngine.a().a().f(6);
        if (this.b != null) {
          this.b.removeMessages(0);
        }
        localGameRoomStatusListener = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
        i = paramMessage.arg2;
        if (paramMessage.arg1 == 1) {}
        for (bool = true;; bool = false)
        {
          localGameRoomStatusListener.a(true, i, bool, null);
          this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(true);
          return false;
        }
      } while (GameEngine.a().a().o() != 5);
      if (this.b != null) {
        this.b.removeMessages(0);
      }
      GameEngine.a().a().f(7);
      localGameRoomStatusListener = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
      int i = paramMessage.arg2;
      if (paramMessage.arg1 == 1) {}
      for (bool = true;; bool = false)
      {
        localGameRoomStatusListener.a(true, i, bool, null);
        this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(false);
        return false;
      }
    }
    GameEngine.a().l();
    GameEngine.a().a().f(1);
    GameRoomStatusListener localGameRoomStatusListener = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
    if (paramMessage.arg1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localGameRoomStatusListener.a(true, 0, bool, null);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController
 * JD-Core Version:    0.7.0.1
 */