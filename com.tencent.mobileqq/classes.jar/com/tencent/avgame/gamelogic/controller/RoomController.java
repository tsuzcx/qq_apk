package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.business.observer.UserInfoObserver;
import com.tencent.avgame.gamelogic.DelayNotifyRunnable;
import com.tencent.avgame.gamelogic.DelayNotifyRunnable.IOnDelayNotifyDoneListener;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGame;
import com.tencent.avgame.gamelogic.IGameEngine;
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
import com.tencent.avgame.report.CJSurvivalReporterUtil;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.avgame.util.ContactUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class RoomController
  extends GameRoomObserver
  implements Handler.Callback, DelayNotifyRunnable.IOnDelayNotifyDoneListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private UserInfoObserver jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver = new RoomController.1(this);
  private ISurvivalRoomController jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController;
  private GameRoomHandler jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler;
  private GameRoomStatusListener jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
  private IDataCtrl<EngineData> jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl;
  private SyncListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  List<DelayNotifyRunnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private Handler b = null;
  
  public RoomController(AppInterface paramAppInterface, GameRoomStatusListener paramGameRoomStatusListener, SyncListener paramSyncListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener = paramGameRoomStatusListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener = paramSyncListener;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl = paramIDataCtrl;
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler = ((GameRoomHandler)paramAppInterface.getBusinessHandler(HandlerFactory.a));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this, false);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver, false);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController = new SurvivalRoomController(this);
  }
  
  private void a(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when roomInfo update %s", new Object[] { paramEngineData.a() }));
    }
    paramEngineData.a(((UserInfoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(HandlerFactory.b)).a(paramEngineData.a().getUins()));
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
    if ((paramLong != 0L) && (paramLong == localEngineData.a())) {
      return true;
    }
    QLog.d("avgame_logic.GameRoomController", 1, String.format("%s bValidSession=false [svrRId,locRId]=[%d,%d]", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(localEngineData.a()) }));
    return false;
  }
  
  private boolean a(String paramString, RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo.getPlayer(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()) == null)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(6, MobileQQ.sMobileQQ.getString(2131690331), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
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
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0)
    {
      Object localObject = (Object[])paramObject;
      paramObject = (String)localObject[0];
      int i = ((Integer)localObject[1]).intValue();
      localObject = (String)localObject[2];
      if (1 == i) {
        paramObject = String.format(MobileQQ.sMobileQQ.getString(2131690325), new Object[] { ContactUtils.a(paramObject, 8.0F) });
      } else if (2 == i) {
        paramObject = String.format(MobileQQ.sMobileQQ.getString(2131690326), new Object[] { ContactUtils.a(paramObject, 5.0F), ContactUtils.a((String)localObject, 5.0F) });
      } else {
        paramObject = "";
      }
      localStringBuilder.append(paramObject);
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(paramObject, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onDelayNotifyDone nt=%d result=%s", new Object[] { Integer.valueOf(paramInt), localStringBuilder.toString() }));
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetGameListFailed() roomId=");
      localStringBuilder.append(paramLong);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (!a(paramLong, "onGetGameListSuccess()")) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.g();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetGameRoomInfoFailed() roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" data =");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (paramLong == ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramInt, MobileQQ.sMobileQQ.getString(2131690331), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString, RoomInfo paramRoomInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLeaveGameRoomSuccess() leaveType =");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" kickUin = ");
      localStringBuilder.append(paramString);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (IGameEngine.a().f())
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController.a(paramLong, paramInt, paramString, paramRoomInfo);
      return;
    }
    if (2 == paramInt)
    {
      if (!a(paramLong, "onLeaveGameRoomSuccess(kick)")) {
        return;
      }
      a(paramRoomInfo, false);
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(2, paramString, null, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      paramRoomInfo = new StringBuilder();
      paramRoomInfo.append("");
      paramRoomInfo.append(paramLong);
      ReportController.b(null, "dc00898", "", "", "0X800B02E", "0X800B02E", 0, 0, paramString, paramRoomInfo.toString(), "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramInt, null, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    if (this.jdField_a_of_type_Boolean) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(paramLong);
    ReportController.b(null, "dc00898", "", "", "0X800B030", "0X800B030", paramInt, 0, "", paramString.toString(), "", "");
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLeaveGameRoomFailed() leaveType =");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" kickUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" errorMsg = ");
      localStringBuilder.append(paramString2);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (IGameEngine.a().i()) {
      AVGameExceptionReporter.a().a(13, null, "-1", paramString2);
    }
    if (2 == paramInt)
    {
      if (!a(paramLong, "onLeaveGameRoomFailed(kick)")) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(-2, paramString1, MobileQQ.sMobileQQ.getString(2131690362), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramInt, null, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelectGameSuccess roomId=");
      localStringBuilder.append(paramLong2);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushOnGameChange() newIndex = ");
      localStringBuilder.append(localEngineData.a);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
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
    if (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin().equals(paramString1))
    {
      paramRoomInfo = ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString1);
      paramString2 = ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString2);
      int i;
      if ((paramRoomInfo != null) && (!paramRoomInfo.equalsIgnoreCase(paramString1))) {
        i = 1;
      } else {
        i = 0;
      }
      paramString1 = new DelayNotifyRunnable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0, this, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
      if (i != 0)
      {
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
    String str2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    int i = 2131690331;
    String str1 = "";
    if (paramInt1 == 0) {
      if (paramInt3 == 1) {
        if (paramString1.equals(str2))
        {
          if (paramString1.equals(String.valueOf(paramRoomInfo.owner))) {
            break label228;
          }
          paramString2 = paramString4;
        }
      }
    }
    label228:
    label380:
    for (;;)
    {
      for (paramInt2 = 0;; paramInt2 = 1)
      {
        bool = true;
        break label432;
        paramString2 = str1;
        if (!str2.equals(String.valueOf(paramRoomInfo.owner))) {
          break label426;
        }
        paramString2 = paramString3.replace("#", ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString1));
        break label426;
        paramString2 = str1;
        if (paramInt2 != 1) {
          break label426;
        }
        paramString2 = str1;
        if (!paramString1.equals(str2)) {
          break label426;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
          i = 2131690403;
        }
        paramString2 = MobileQQ.sMobileQQ.getString(i);
        break label380;
        if (1 != paramInt1) {
          break label349;
        }
        if ((paramInt3 != 1) || (!paramString1.equals(str2))) {
          break;
        }
        paramString2 = paramString4;
      }
      if ((paramInt2 == 1) && (paramString1.equals(str2)))
      {
        if (!NetworkUtil.isNetworkAvailable()) {
          i = 2131690403;
        }
        paramString2 = MobileQQ.sMobileQQ.getString(i);
      }
      else
      {
        paramString2 = String.format(MobileQQ.sMobileQQ.getString(2131690400), new Object[] { ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString2, 8) });
        if (!((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).f()) {
          break label426;
        }
        paramString2 = str1;
        break label426;
        paramString2 = str1;
        if (2 != paramInt1) {
          break label426;
        }
        if (!paramString1.equals(str2)) {
          break;
        }
        paramString2 = MobileQQ.sMobileQQ.getString(2131690363);
      }
    }
    label349:
    paramString2 = String.format(MobileQQ.sMobileQQ.getString(2131690364), new Object[] { ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a().getNick(paramString1, 8) });
    label426:
    paramInt2 = 0;
    boolean bool = false;
    label432:
    if (paramInt2 != 0) {
      IGameEngine.a().f();
    }
    a(paramRoomInfo, false);
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("pushOnRoomExit() isMine = ");
      paramString3.append(bool);
      paramString3.append(" tips = ");
      paramString3.append(paramString2);
      QLog.i("avgame_logic.GameRoomController", 2, paramString3.toString());
    }
    if ((!bool) && (((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).f()))
    {
      i = ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a();
      if ((i != 10) && (i != 0)) {
        ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).f(9);
      }
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(3, paramString2, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      if (paramInt3 == 1)
      {
        if (paramInt2 != 0)
        {
          ReportController.b(null, "dc00898", "", "", "0X800B35A", "0X800B35A", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B35C", "0X800B35C", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if ((paramInt1 != 1) && (paramInt3 == 1) && (str2.equals(String.valueOf(paramRoomInfo.owner))) && (!paramString1.equals(str2)))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(3, paramString1, paramString2, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
        ReportController.b(null, "dc00898", "", "", "0X800B35B", "0X800B35B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(1, paramString1, paramString2, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
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
    if (QLog.isColorLevel())
    {
      paramRoomInfo = new StringBuilder();
      paramRoomInfo.append("pushOnChangeUserStatus() uin = ");
      paramRoomInfo.append(paramString);
      paramRoomInfo.append(" userStatusType =");
      paramRoomInfo.append(paramInt);
      QLog.i("avgame_logic.GameRoomController", 2, paramRoomInfo.toString());
    }
    paramRoomInfo = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramString, paramInt, paramRoomInfo);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGameShareLink  roomId: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" shareUin: ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" shareName: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" shareType: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" gameId: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" gameType: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" pbMark");
    localStringBuilder.append(paramLong3);
    QLog.d("avgame_logic.GameRoomController", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUserStatusFailed() errorMsg =");
      localStringBuilder.append(paramString);
      localStringBuilder.append("errorCode = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" from = ");
      localStringBuilder.append(paramInt2);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (!a(paramLong, "onChangeUserStatusFailed()")) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kickGameRoomUserByOwner roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ownerUin =");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" kickedUserUin =");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" isHostUser =");
      localStringBuilder.append(((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).e(paramString1));
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).e(paramString1)) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong, 2, paramString1, paramString2);
    }
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
    boolean bool = IGameEngine.a().i();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("leaveGameRoomByUser roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" userUin =");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isQQCJ =");
      localStringBuilder.append(bool);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetGameRoomInfoFailed() uin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" isFromSync =");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" fromType=");
      localStringBuilder.append(paramInt1);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (!a(paramLong, "onGetGameRoomInfoFailed()")) {
      return;
    }
    if (((paramInt2 == 106) || (paramInt2 == 111)) && (paramLong == ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a()))
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(6, MobileQQ.sMobileQQ.getString(2131690331), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramLong, paramString1, paramBoolean, paramString2, paramInt2);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(RoomInfo paramRoomInfo, int paramInt)
  {
    long l;
    if (paramRoomInfo == null) {
      l = 0L;
    } else {
      l = paramRoomInfo.id;
    }
    if (!a(l, "onChangeUserStatusSuccess()")) {
      return;
    }
    if (!a(paramRoomInfo.seq, paramRoomInfo.id))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusSuccess() seq is invalid just return");
      return;
    }
    a(paramRoomInfo, false);
    if ((paramInt == 4) || (paramInt == 2)) {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 1);
    }
    if (QLog.isColorLevel())
    {
      paramRoomInfo = new StringBuilder();
      paramRoomInfo.append("onChangeUserStatusSuccess() and from = ");
      paramRoomInfo.append(paramInt);
      QLog.i("avgame_logic.GameRoomController", 2, paramRoomInfo.toString());
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
      ((GamePlayHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(HandlerFactory.c)).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b(), false);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("selectGame roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isHost =");
      localStringBuilder.append(((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).e(paramString));
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).e(paramString)) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramString, paramLong, paramInt);
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, RoomInfo paramRoomInfo, IGame paramIGame, List<UserScore> paramList, List<GameItem> paramList1, int paramInt2, String paramString2, String paramString3)
  {
    long l1 = paramRoomInfo.seq;
    long l2 = paramRoomInfo.id;
    if (!a(l2, "onGetGameRoomInfoSuccess()")) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSyncListener.a(l1, l2, paramBoolean))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoSuccess() seq is invalid just return");
      return;
    }
    if (paramBoolean)
    {
      a(paramRoomInfo, (Game)paramIGame, paramList, paramList1, paramInt2, paramString2, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetSnapshotSuc() fromEnter=%b curGameIndex=%d roomInfo=[%s] game=[%s] scores=[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRoomInfo, paramIGame, Arrays.toString(paramList.toArray()) }));
      }
      if (!a(paramString1, paramRoomInfo)) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.c((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a(), paramInt1);
      return;
    }
    a(paramRoomInfo, false);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetGameRoomInfoSuccess() roomInfo=[%s]", new Object[] { paramRoomInfo }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramString1, (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
  }
  
  public void a(List<GameItem> paramList, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetGameListSuccess() curGameIndex = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" resUrl =");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" resMd5 =");
      localStringBuilder.append(paramString2);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (!a(paramLong, "onGetGameListSuccess()")) {
      return;
    }
    paramString1 = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    paramString1.a(paramList, paramInt);
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramString1);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString1.add(Integer.valueOf(((GameItem)paramList.next()).a));
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPkPoolUserChange isSuc:%b option:%d pkTotalNum:%d listSize:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.size()) }));
    }
    if ((paramBoolean) && (!IGameEngine.k()))
    {
      EngineData localEngineData = IGameEngine.a().a();
      localEngineData.c(paramInt2);
      localEngineData.d(Math.max(localEngineData.m(), paramInt2));
      localEngineData.b(paramList, paramInt1);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, "");
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, List<Long> paramList, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4, String paramString)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPKInfoResult isSuc:%b interval:%d pkTotalNum:%d isChange:%b realId:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString }));
    }
    EngineData localEngineData = IGameEngine.a().a();
    if (paramBoolean1)
    {
      localEngineData.c(paramInt2);
      localEngineData.d(Math.max(localEngineData.m(), paramInt2));
      localEngineData.a(paramList);
      localEngineData.c(paramBoolean3);
      if (paramBoolean2) {
        localEngineData.b(paramInt3);
      }
    }
    else if (localEngineData.g())
    {
      AVGameExceptionReporter.a().a(4, null, String.valueOf(paramInt4), paramString);
    }
    paramList = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
    if ((paramBoolean1) && (paramInt4 == 0)) {
      paramBoolean2 = bool1;
    } else {
      paramBoolean2 = false;
    }
    paramList.a(paramBoolean2, paramString);
    if (this.b == null) {
      this.b = new Handler(this);
    }
    if (paramBoolean1)
    {
      if ((paramInt1 > 0) && (paramInt4 != 652))
      {
        this.b.removeMessages(0);
        this.b.sendEmptyMessageDelayed(0, paramInt1);
      }
    }
    else
    {
      this.b.removeMessages(0);
      this.b.sendEmptyMessageDelayed(0, 1000L);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onCreateRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartStrangerMatch isSuc=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" roomId=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" shareId=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" errCod=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" errMsg=");
      localStringBuilder.append(paramString);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramLong, 1);
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).b(paramLong, paramInt1);
    }
    else
    {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramLong, 0);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStopStrangerMatch isSuc=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" roomId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" errCod=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" errMsg=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("avgame_logic.GameRoomController", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
      ((EngineData)localObject).b(paramLong, 0);
      ((EngineData)localObject).a(paramLong, 0);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, paramLong, paramInt, paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartStrangerMatchV2 isSuc=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" roomId=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" gameType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" info=");
      Object localObject;
      if (paramArrayOfByte != null) {
        localObject = Integer.valueOf(paramArrayOfByte.length);
      } else {
        localObject = "null";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(" errCod=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" errMsg=");
      localStringBuilder.append(paramString);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramLong, 1);
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramArrayOfByte);
    }
    else
    {
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(paramLong, 0);
      ((EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a()).a(null);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean, paramLong, paramInt1, paramArrayOfByte, paramInt2, paramString);
  }
  
  protected void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2, boolean paramBoolean3, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onSurvivalPkRoomAction isSuc:%b create:%b roomId:%d needAVRoom:%b peerUin:%d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean3), Long.valueOf(paramLong3) }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerISurvivalRoomController.a(paramBoolean1, paramLong1, paramBoolean2, paramLong2, paramBoolean3, paramLong3);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString, PkCJOperationData paramPkCJOperationData)
  {
    boolean bool3 = QLog.isColorLevel();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onSurvivalResult isSuc:%b exit:%b poolId:%d startNum:%d errCode:%d errMsg:%s cjData=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramPkCJOperationData }));
    }
    if (IGameEngine.k()) {
      return;
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = IGameEngine.a().a();
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
      else
      {
        if (((EngineData)localObject).j() == 0)
        {
          ((EngineData)localObject).b(paramInt1);
          ((EngineData)localObject).a(paramPkCJOperationData.isCJ());
          ((EngineData)localObject).b(paramPkCJOperationData.hasAVRoom());
          ((EngineData)localObject).a(paramPkCJOperationData);
          IGameEngine.a().n();
          if (paramPkCJOperationData.isCJ())
          {
            if (paramPkCJOperationData.hasAVRoom()) {
              paramInt1 = 1;
            } else {
              paramInt1 = 2;
            }
            ReportController.b(null, "dc00898", "", "", "survival_call", "survival_call", paramInt1, 0, String.valueOf(CJSurvivalReporterUtil.a().a()), "", CJSurvivalReporterUtil.a().a(), String.valueOf(((EngineData)localObject).k()));
          }
          bool1 = true;
        }
        ((EngineData)localObject).g(paramPkCJOperationData.curRound);
        ((EngineData)localObject).e(1);
      }
    }
    else
    {
      paramPkCJOperationData = IGameEngine.a().a();
      bool1 = bool2;
      if (paramPkCJOperationData.g())
      {
        ReportController.b(null, "dc00898", "", "", "survival_call", "survival_call", 0, 0, String.valueOf(CJSurvivalReporterUtil.a().a()), "", CJSurvivalReporterUtil.a().a(), String.valueOf(paramPkCJOperationData.k()));
        if (paramInt3 == 0) {
          paramInt1 = -1;
        } else {
          paramInt1 = paramInt3;
        }
        localObject = String.valueOf(paramInt1);
        if (paramBoolean2)
        {
          AVGameExceptionReporter.a().a(11, null, (String)localObject, paramString);
          bool1 = bool2;
        }
        else if (paramPkCJOperationData.j() == 0)
        {
          AVGameExceptionReporter.a().a(3, null, (String)localObject, paramString);
          bool1 = bool2;
        }
        else
        {
          AVGameExceptionReporter.a().a(10, null, (String)localObject, paramString);
          bool1 = bool2;
        }
      }
    }
    IGameEngine.a().a().h(paramInt2);
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramBoolean1, paramInt3, paramString, bool1);
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGameRoomList roomId = ");
      localStringBuilder.append(paramLong);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicHandlerGameRoomHandler.a(paramLong);
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRoomMatchStatusChange roomId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" matchStatus=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("avgame_logic.GameRoomController", 2, ((StringBuilder)localObject).toString());
    }
    if (!a(paramLong, "onRoomMatchStatusChange()")) {
      return;
    }
    Object localObject = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
    ((EngineData)localObject).a(paramLong, paramInt);
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(paramLong, ((EngineData)localObject).a(((EngineData)localObject).e(IGameEngine.a().getCurrentAccountUin())));
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onJoinRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStartStrangerMatch isSuc=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" roomId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" gameType=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" errCod=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" errMsg=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("avgame_logic.GameRoomController", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a();
      ((EngineData)localObject).a(paramLong, 0);
      ((EngineData)localObject).a(null);
      ((EngineData)localObject).e(false);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverUserInfoObserver);
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
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.a(7, MobileQQ.sMobileQQ.getString(2131690452), (EngineData)this.jdField_a_of_type_ComTencentAvgameGamelogicListenerIDataCtrl.a());
  }
  
  protected void d(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onPkMatchTimeout");
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.j();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (IGameEngine.k()) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      Object localObject;
      boolean bool;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
          IGameEngine.a().l();
          IGameEngine.a().a().f(1);
          localObject = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
          if (paramMessage.arg1 == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((GameRoomStatusListener)localObject).a(true, 0, bool, null);
          return false;
        }
        if (IGameEngine.a().a().o() == 10)
        {
          IGameEngine.a().a().f(6);
          localObject = this.b;
          if (localObject != null) {
            ((Handler)localObject).removeMessages(0);
          }
          localObject = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
          i = paramMessage.arg2;
          if (paramMessage.arg1 == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((GameRoomStatusListener)localObject).a(true, i, bool, null);
          this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(true);
          return false;
        }
      }
      else if (IGameEngine.a().a().o() == 5)
      {
        localObject = this.b;
        if (localObject != null) {
          ((Handler)localObject).removeMessages(0);
        }
        IGameEngine.a().a().f(7);
        localObject = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener;
        i = paramMessage.arg2;
        if (paramMessage.arg1 == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((GameRoomStatusListener)localObject).a(true, i, bool, null);
        this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameRoomStatusListener.b(false);
        return false;
      }
    }
    else
    {
      IGameEngine.a().n();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController
 * JD-Core Version:    0.7.0.1
 */