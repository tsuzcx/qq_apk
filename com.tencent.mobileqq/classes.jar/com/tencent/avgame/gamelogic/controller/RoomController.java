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
  List<DelayNotifyRunnable> a = new ArrayList();
  private GameRoomHandler b;
  private GameRoomStatusListener c;
  private SyncListener d;
  private IDataCtrl<EngineData> e;
  private AppInterface f;
  private Handler g = new Handler(Looper.getMainLooper());
  private Handler h = null;
  private ISurvivalRoomController i;
  private UserInfoObserver j = new RoomController.1(this);
  private boolean k = false;
  
  public RoomController(AppInterface paramAppInterface, GameRoomStatusListener paramGameRoomStatusListener, SyncListener paramSyncListener, IDataCtrl<EngineData> paramIDataCtrl)
  {
    this.f = paramAppInterface;
    this.c = paramGameRoomStatusListener;
    this.d = paramSyncListener;
    this.e = paramIDataCtrl;
    this.b = ((GameRoomHandler)paramAppInterface.getBusinessHandler(HandlerFactory.a));
    this.f.addObserver(this, false);
    this.f.addObserver(this.j, false);
    this.i = new SurvivalRoomController(this);
  }
  
  private void a(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when roomInfo update %s", new Object[] { paramEngineData.e() }));
    }
    paramEngineData.a(((UserInfoHandler)this.f.getBusinessHandler(HandlerFactory.b)).a(paramEngineData.e().getUins()));
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    int m = this.a.size();
    if (m > 0)
    {
      m -= 1;
      while (m >= 0)
      {
        DelayNotifyRunnable localDelayNotifyRunnable = (DelayNotifyRunnable)this.a.get(m);
        String str = (String)localDelayNotifyRunnable.a();
        if ((str != null) && (paramHashMap.containsKey(str)))
        {
          this.g.removeCallbacks(localDelayNotifyRunnable);
          this.a.remove(m);
          localDelayNotifyRunnable.a((String)paramHashMap.get(str));
        }
        m -= 1;
      }
    }
  }
  
  private boolean a(long paramLong, String paramString)
  {
    EngineData localEngineData = (EngineData)this.e.H();
    if ((paramLong != 0L) && (paramLong == localEngineData.i())) {
      return true;
    }
    QLog.d("avgame_logic.GameRoomController", 1, String.format("%s bValidSession=false [svrRId,locRId]=[%d,%d]", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(localEngineData.i()) }));
    return false;
  }
  
  private boolean a(String paramString, RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo.getPlayer(this.f.getAccount()) == null)
    {
      this.c.a(6, MobileQQ.sMobileQQ.getString(2131887242), (EngineData)this.e.H());
      return false;
    }
    paramRoomInfo = (EngineData)this.e.H();
    int m = paramRoomInfo.j();
    int n = paramRoomInfo.m();
    if ((n == 1) && (m == 10)) {
      paramRoomInfo.a(paramString, n);
    }
    return true;
  }
  
  private boolean e(long paramLong1, long paramLong2)
  {
    if (!this.d.a(paramLong1, paramLong2, false))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format(" bValidSeq=false seq=%d, roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      return false;
    }
    return true;
  }
  
  public void a()
  {
    this.a.clear();
    this.g.removeCallbacksAndMessages(null);
    Handler localHandler = this.h;
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
      int m = ((Integer)localObject[1]).intValue();
      localObject = (String)localObject[2];
      if (1 == m) {
        paramObject = String.format(MobileQQ.sMobileQQ.getString(2131887236), new Object[] { ContactUtils.a(paramObject, 8.0F) });
      } else if (2 == m) {
        paramObject = String.format(MobileQQ.sMobileQQ.getString(2131887237), new Object[] { ContactUtils.a(paramObject, 5.0F), ContactUtils.a((String)localObject, 5.0F) });
      } else {
        paramObject = "";
      }
      localStringBuilder.append(paramObject);
      this.c.b(paramObject, (EngineData)this.e.H());
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
    this.c.h();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetGameRoomInfoFailed() roomId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" data =");
      localStringBuilder.append(this.e.H());
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (paramLong == ((EngineData)this.e.H()).i()) {
      this.c.a(paramInt, MobileQQ.sMobileQQ.getString(2131887242), (EngineData)this.e.H());
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
    if (IGameEngine.I().A())
    {
      this.i.a(paramLong, paramInt, paramString, paramRoomInfo);
      return;
    }
    if (2 == paramInt)
    {
      if (!a(paramLong, "onLeaveGameRoomSuccess(kick)")) {
        return;
      }
      a(paramRoomInfo, false);
      this.c.a(2, paramString, null, (EngineData)this.e.H());
      paramRoomInfo = new StringBuilder();
      paramRoomInfo.append("");
      paramRoomInfo.append(paramLong);
      ReportController.b(null, "dc00898", "", "", "0X800B02E", "0X800B02E", 0, 0, paramString, paramRoomInfo.toString(), "", "");
      return;
    }
    this.c.a(paramInt, null, (EngineData)this.e.H());
    if (this.k) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(paramLong);
    ReportController.b(null, "dc00898", "", "", "0X800B030", "0X800B030", paramInt, 0, "", paramString.toString(), "", "");
    this.k = false;
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
    if (IGameEngine.I().D()) {
      AVGameExceptionReporter.a().a(13, null, "-1", paramString2);
    }
    if (2 == paramInt)
    {
      if (!a(paramLong, "onLeaveGameRoomFailed(kick)")) {
        return;
      }
      this.c.a(-2, paramString1, MobileQQ.sMobileQQ.getString(2131887273), (EngineData)this.e.H());
    }
    else
    {
      this.c.a(paramInt, null, (EngineData)this.e.H());
    }
    this.k = false;
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
    if (!e(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameSuccess() seq is invalid just return");
      return;
    }
    this.c.i();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (!a(paramLong2, "pushOnGameChange()")) {
      return;
    }
    if (!e(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnGameChange() seq is invalid just return");
      return;
    }
    EngineData localEngineData = (EngineData)this.e.H();
    localEngineData.a(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushOnGameChange() newIndex = ");
      localStringBuilder.append(localEngineData.b);
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    this.c.b(localEngineData);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, RoomInfo paramRoomInfo)
  {
    if (!a(paramLong2, "pushOnRoomEnter()")) {
      return;
    }
    if (!e(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomEnter() seq is invalid just return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("pushOnRoomEnter seq=%d rId=%d enterType=%d enterUin=%s inviterUin=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt), paramString1, paramString2 }));
    }
    a(paramRoomInfo, false);
    if (((EngineData)this.e.H()).M())
    {
      ((EngineData)this.e.H()).g(2);
      this.c.c(paramString1, (EngineData)this.e.H());
      return;
    }
    if (!this.f.getCurrentAccountUin().equals(paramString1))
    {
      paramRoomInfo = ((EngineData)this.e.H()).e().getNick(paramString1);
      paramString2 = ((EngineData)this.e.H()).e().getNick(paramString2);
      int m;
      if ((paramRoomInfo != null) && (!paramRoomInfo.equalsIgnoreCase(paramString1))) {
        m = 1;
      } else {
        m = 0;
      }
      paramString1 = new DelayNotifyRunnable(this.f, 0, this, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
      if (m != 0)
      {
        paramString1.a(paramRoomInfo);
        return;
      }
      this.a.add(paramString1);
      this.g.postDelayed(paramString1, 1500L);
      return;
    }
    this.c.b("", (EngineData)this.e.H());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, RoomInfo paramRoomInfo, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    if (!a(paramLong2, "pushOnRoomExit()")) {
      return;
    }
    if (!e(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomExit seq is invalid just return");
      return;
    }
    String str2 = this.f.getCurrentAccountUin();
    int m = 2131887242;
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
        paramString2 = paramString3.replace("#", ((EngineData)this.e.H()).e().getNick(paramString1));
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
          m = 2131887314;
        }
        paramString2 = MobileQQ.sMobileQQ.getString(m);
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
          m = 2131887314;
        }
        paramString2 = MobileQQ.sMobileQQ.getString(m);
      }
      else
      {
        paramString2 = String.format(MobileQQ.sMobileQQ.getString(2131887311), new Object[] { ((EngineData)this.e.H()).e().getNick(paramString2, 8) });
        if (!((EngineData)this.e.H()).M()) {
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
        paramString2 = MobileQQ.sMobileQQ.getString(2131887274);
      }
    }
    label349:
    paramString2 = String.format(MobileQQ.sMobileQQ.getString(2131887275), new Object[] { ((EngineData)this.e.H()).e().getNick(paramString1, 8) });
    label426:
    paramInt2 = 0;
    boolean bool = false;
    label432:
    if (paramInt2 != 0) {
      IGameEngine.I().w();
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
    if ((!bool) && (((EngineData)this.e.H()).M()))
    {
      m = ((EngineData)this.e.H()).j();
      if ((m != 10) && (m != 0)) {
        ((EngineData)this.e.H()).g(9);
      }
    }
    if (bool)
    {
      this.c.a(3, paramString2, (EngineData)this.e.H());
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
        this.c.a(3, paramString1, paramString2, (EngineData)this.e.H());
        ReportController.b(null, "dc00898", "", "", "0X800B35B", "0X800B35B", 0, 0, "", "", "", "");
        return;
      }
      this.c.a(1, paramString1, paramString2, (EngineData)this.e.H());
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt, RoomInfo paramRoomInfo)
  {
    if (!a(paramLong2, "pushOnChangeUserStatus()")) {
      return;
    }
    if (!e(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnChangeUserStatus() seq is invalid just return");
      return;
    }
    a(paramRoomInfo, false);
    ((EngineData)this.e.H()).a(paramString, paramInt);
    if (QLog.isColorLevel())
    {
      paramRoomInfo = new StringBuilder();
      paramRoomInfo.append("pushOnChangeUserStatus() uin = ");
      paramRoomInfo.append(paramString);
      paramRoomInfo.append(" userStatusType =");
      paramRoomInfo.append(paramInt);
      QLog.i("avgame_logic.GameRoomController", 2, paramRoomInfo.toString());
    }
    paramRoomInfo = (EngineData)this.e.H();
    this.c.a(paramString, paramInt, paramRoomInfo);
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
    this.b.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
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
    this.c.a(paramString, paramInt1, paramInt2);
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
      localStringBuilder.append(((EngineData)this.e.H()).g(paramString1));
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!((EngineData)this.e.H()).g(paramString1)) {
        return;
      }
      this.b.a(paramLong, 2, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong, String paramString1, List<QuestionClassInfo> paramList, String paramString2, String paramString3)
  {
    if (!a(paramLong, "onGetGameQuestionClass()")) {
      return;
    }
    ((EngineData)this.e.H()).a(paramList, paramString2, paramString3);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    boolean bool = IGameEngine.I().D();
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
    this.k = paramBoolean;
    if (!bool)
    {
      this.b.a(paramLong, 1, paramString, paramString);
      return;
    }
    this.b.b(paramLong, 1, paramString, paramString);
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
    if (((paramInt2 == 106) || (paramInt2 == 111)) && (paramLong == ((EngineData)this.e.H()).i()))
    {
      this.c.a(6, MobileQQ.sMobileQQ.getString(2131887242), (EngineData)this.e.H());
      return;
    }
    this.c.a(paramLong, paramString1, paramBoolean, paramString2, paramInt2);
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
    if (!e(paramRoomInfo.seq, paramRoomInfo.id))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusSuccess() seq is invalid just return");
      return;
    }
    a(paramRoomInfo, false);
    if ((paramInt == 4) || (paramInt == 2)) {
      ((EngineData)this.e.H()).a(this.f.getCurrentAccountUin(), 1);
    }
    if (QLog.isColorLevel())
    {
      paramRoomInfo = new StringBuilder();
      paramRoomInfo.append("onChangeUserStatusSuccess() and from = ");
      paramRoomInfo.append(paramInt);
      QLog.i("avgame_logic.GameRoomController", 2, paramRoomInfo.toString());
    }
    paramRoomInfo = (EngineData)this.e.H();
    this.c.a(paramRoomInfo, paramInt);
  }
  
  public void a(RoomInfo paramRoomInfo, Game paramGame, List<UserScore> paramList, List<GameItem> paramList1, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = (EngineData)this.e.H();
    paramGame.a(paramString1.v());
    paramString1.a(paramRoomInfo, false);
    paramString1.a(paramList1, paramInt);
    paramString1.b(paramGame);
    paramString1.a(paramList);
    if ((GameUtil.d(paramString1.o())) && (paramString1.t().size() == 0) && (paramString1.j() >= 0) && (paramString1.j() <= 10)) {
      ((GamePlayHandler)this.f.getBusinessHandler(HandlerFactory.c)).a(this.f.getCurrentAccountUin(), paramString1.i(), paramString1.n(), false);
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
      this.d.b();
      this.d.a(paramRoomInfo.seq, paramRoomInfo.id, false);
    }
    EngineData localEngineData = (EngineData)this.e.H();
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
      localStringBuilder.append(((EngineData)this.e.H()).g(paramString));
      QLog.i("avgame_logic.GameRoomController", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!((EngineData)this.e.H()).g(paramString)) {
        return;
      }
      this.b.a(paramString, paramLong, paramInt);
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, RoomInfo paramRoomInfo, IGame paramIGame, List<UserScore> paramList, List<GameItem> paramList1, int paramInt2, String paramString2, String paramString3)
  {
    long l1 = paramRoomInfo.seq;
    long l2 = paramRoomInfo.id;
    if (!a(l2, "onGetGameRoomInfoSuccess()")) {
      return;
    }
    if (!this.d.a(l1, l2, paramBoolean))
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
      this.c.c((EngineData)this.e.H(), paramInt1);
      return;
    }
    a(paramRoomInfo, false);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetGameRoomInfoSuccess() roomInfo=[%s]", new Object[] { paramRoomInfo }));
    }
    this.c.a(paramString1, (EngineData)this.e.H());
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
    paramString1 = (EngineData)this.e.H();
    paramString1.a(paramList, paramInt);
    this.c.a(paramString1);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString1.add(Integer.valueOf(((GameItem)paramList.next()).a));
      }
      this.b.a(paramLong, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPkPoolUserChange isSuc:%b option:%d pkTotalNum:%d listSize:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.size()) }));
    }
    if ((paramBoolean) && (!IGameEngine.J()))
    {
      EngineData localEngineData = IGameEngine.I().s();
      localEngineData.d(paramInt2);
      localEngineData.e(Math.max(localEngineData.S(), paramInt2));
      localEngineData.b(paramList, paramInt1);
    }
    this.c.a(paramBoolean, "");
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, List<Long> paramList, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4, String paramString)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPKInfoResult isSuc:%b interval:%d pkTotalNum:%d isChange:%b realId:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString }));
    }
    EngineData localEngineData = IGameEngine.I().s();
    if (paramBoolean1)
    {
      localEngineData.d(paramInt2);
      localEngineData.e(Math.max(localEngineData.S(), paramInt2));
      localEngineData.b(paramList);
      localEngineData.d(paramBoolean3);
      if (paramBoolean2) {
        localEngineData.c(paramInt3);
      }
    }
    else if (localEngineData.N())
    {
      AVGameExceptionReporter.a().a(4, null, String.valueOf(paramInt4), paramString);
    }
    paramList = this.c;
    if ((paramBoolean1) && (paramInt4 == 0)) {
      paramBoolean2 = bool1;
    } else {
      paramBoolean2 = false;
    }
    paramList.a(paramBoolean2, paramString);
    if (this.h == null) {
      this.h = new Handler(this);
    }
    if (paramBoolean1)
    {
      if ((paramInt1 > 0) && (paramInt4 != 652))
      {
        this.h.removeMessages(0);
        this.h.sendEmptyMessageDelayed(0, paramInt1);
      }
    }
    else
    {
      this.h.removeMessages(0);
      this.h.sendEmptyMessageDelayed(0, 1000L);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onCreateRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    this.c.a(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
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
      ((EngineData)this.e.H()).a(paramLong, 1);
      ((EngineData)this.e.H()).b(paramLong, paramInt1);
    }
    else
    {
      ((EngineData)this.e.H()).a(paramLong, 0);
    }
    this.c.a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
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
      localObject = (EngineData)this.e.H();
      ((EngineData)localObject).b(paramLong, 0);
      ((EngineData)localObject).a(paramLong, 0);
    }
    this.c.a(paramBoolean, paramLong, paramInt, paramString);
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
      ((EngineData)this.e.H()).a(paramLong, 1);
      ((EngineData)this.e.H()).a(paramArrayOfByte);
    }
    else
    {
      ((EngineData)this.e.H()).a(paramLong, 0);
      ((EngineData)this.e.H()).a(null);
    }
    this.c.a(paramBoolean, paramLong, paramInt1, paramArrayOfByte, paramInt2, paramString);
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
    this.i.a(paramBoolean1, paramLong1, paramBoolean2, paramLong2, paramBoolean3, paramLong3);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString, PkCJOperationData paramPkCJOperationData)
  {
    boolean bool3 = QLog.isColorLevel();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onSurvivalResult isSuc:%b exit:%b poolId:%d startNum:%d errCode:%d errMsg:%s cjData=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramPkCJOperationData }));
    }
    if (IGameEngine.J()) {
      return;
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = IGameEngine.I().s();
      if (paramBoolean2)
      {
        ((EngineData)localObject).g(0);
        ((EngineData)localObject).c(0);
        ((EngineData)localObject).c(true);
        ((EngineData)localObject).b(false);
        ((EngineData)localObject).a(new PkCJOperationData());
        ((EngineData)localObject).f(0);
        bool1 = bool2;
      }
      else
      {
        if (((EngineData)localObject).P() == 0)
        {
          ((EngineData)localObject).c(paramInt1);
          ((EngineData)localObject).b(paramPkCJOperationData.isCJ());
          ((EngineData)localObject).c(paramPkCJOperationData.hasAVRoom());
          ((EngineData)localObject).a(paramPkCJOperationData);
          IGameEngine.I().z();
          if (paramPkCJOperationData.isCJ())
          {
            if (paramPkCJOperationData.hasAVRoom()) {
              paramInt1 = 1;
            } else {
              paramInt1 = 2;
            }
            ReportController.b(null, "dc00898", "", "", "survival_call", "survival_call", paramInt1, 0, String.valueOf(CJSurvivalReporterUtil.a().c()), "", CJSurvivalReporterUtil.a().b(), String.valueOf(((EngineData)localObject).Q()));
          }
          bool1 = true;
        }
        ((EngineData)localObject).h(paramPkCJOperationData.curRound);
        ((EngineData)localObject).f(1);
      }
    }
    else
    {
      paramPkCJOperationData = IGameEngine.I().s();
      bool1 = bool2;
      if (paramPkCJOperationData.N())
      {
        ReportController.b(null, "dc00898", "", "", "survival_call", "survival_call", 0, 0, String.valueOf(CJSurvivalReporterUtil.a().c()), "", CJSurvivalReporterUtil.a().b(), String.valueOf(paramPkCJOperationData.Q()));
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
        else if (paramPkCJOperationData.P() == 0)
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
    IGameEngine.I().s().i(paramInt2);
    if (!paramBoolean2)
    {
      this.c.a(paramBoolean1, paramInt3, paramString, bool1);
      return;
    }
  }
  
  public void b()
  {
    this.a.clear();
    Handler localHandler = this.h;
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
    this.b.a(paramLong);
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
    Object localObject = (EngineData)this.e.H();
    ((EngineData)localObject).a(paramLong, paramInt);
    this.c.a(paramLong, ((EngineData)localObject).a(((EngineData)localObject).g(IGameEngine.K().getCurrentAccountUin())));
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameFailed() Failed");
    }
    if (!a(paramLong2, "onSelectGameFailed()")) {
      return;
    }
    if (!e(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameFailed() seq is invalid just return");
      return;
    }
    this.c.j();
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
    this.c.b(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
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
      localObject = (EngineData)this.e.H();
      ((EngineData)localObject).a(paramLong, 0);
      ((EngineData)localObject).a(null);
      ((EngineData)localObject).f(false);
    }
    this.c.b(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
  }
  
  public void c()
  {
    this.f.removeObserver(this);
    this.f.removeObserver(this.j);
    this.i.b();
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
    this.c.a(7, MobileQQ.sMobileQQ.getString(2131887363), (EngineData)this.e.H());
  }
  
  protected void d(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onPkMatchTimeout");
    }
    this.c.k();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (IGameEngine.J()) {
      return false;
    }
    int m = paramMessage.what;
    if (m != 0)
    {
      Object localObject;
      boolean bool;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return false;
          }
          IGameEngine.I().x();
          IGameEngine.I().s().g(1);
          localObject = this.c;
          if (paramMessage.arg1 == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((GameRoomStatusListener)localObject).a(true, 0, bool, null);
          return false;
        }
        if (IGameEngine.I().s().X() == 10)
        {
          IGameEngine.I().s().g(6);
          localObject = this.h;
          if (localObject != null) {
            ((Handler)localObject).removeMessages(0);
          }
          localObject = this.c;
          m = paramMessage.arg2;
          if (paramMessage.arg1 == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((GameRoomStatusListener)localObject).a(true, m, bool, null);
          this.c.b(true);
          return false;
        }
      }
      else if (IGameEngine.I().s().X() == 5)
      {
        localObject = this.h;
        if (localObject != null) {
          ((Handler)localObject).removeMessages(0);
        }
        IGameEngine.I().s().g(7);
        localObject = this.c;
        m = paramMessage.arg2;
        if (paramMessage.arg1 == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((GameRoomStatusListener)localObject).a(true, m, bool, null);
        this.c.b(false);
        return false;
      }
    }
    else
    {
      IGameEngine.I().z();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController
 * JD-Core Version:    0.7.0.1
 */