package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import bdla;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.DelayNotifyRunnable;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ndl;
import ndr;
import nfb;
import nfc;
import nff;
import nfg;
import nfr;
import nfv;
import nfw;
import nga;
import ngb;
import ngt;
import ngu;
import ngx;
import nha;
import nhb;
import nhd;

public class RoomController
  extends nhd
  implements Handler.Callback, nfb
{
  private volatile int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private volatile RoomController.PkLeavingRoomRunnable jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController$PkLeavingRoomRunnable;
  List<DelayNotifyRunnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ndr jdField_a_of_type_Ndr = new nfr(this);
  private ngu jdField_a_of_type_Ngu;
  private ngx jdField_a_of_type_Ngx;
  private nha<nfv> jdField_a_of_type_Nha;
  private nhb jdField_a_of_type_Nhb;
  private volatile boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private volatile boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public RoomController(AVGameAppInterface paramAVGameAppInterface, ngx paramngx, nhb paramnhb, nha<nfv> paramnha)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Ngx = paramngx;
    this.jdField_a_of_type_Nhb = paramnhb;
    this.jdField_a_of_type_Nha = paramnha;
    this.jdField_a_of_type_Ngu = ((ngu)paramAVGameAppInterface.a(1));
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this, false);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this.jdField_a_of_type_Ndr, false);
  }
  
  private void a(int paramInt)
  {
    nfv localnfv = nfc.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "dealPkCreateRoomOrJoinAfterExitRoom " + paramInt + " " + localnfv.m());
    }
    ngu localngu;
    long l;
    if (localnfv.m() == 2)
    {
      localnfv.d(3);
      localngu = (ngu)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1);
      l = localnfv.jdField_a_of_type_Long;
      if (l <= 0L) {
        localngu.a(10, null, 0);
      }
    }
    else
    {
      return;
    }
    localngu.a(7, String.valueOf(l), "");
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
  
  private void a(nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when roomInfo update %s", new Object[] { paramnfv.a() }));
    }
    paramnfv.a(((ndl)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(2)).a(paramnfv.a().getUins()));
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    if (!this.jdField_a_of_type_Nhb.a(paramLong1, paramLong2, false))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format(" bValidSeq=false seq=%d, roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      return false;
    }
    return true;
  }
  
  private boolean a(long paramLong, String paramString)
  {
    nfv localnfv = (nfv)this.jdField_a_of_type_Nha.a();
    if ((paramLong == 0L) || (paramLong != localnfv.a()))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format("%s bValidSession=false [svrRId,locRId]=[%d,%d]", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(localnfv.a()) }));
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo.getPlayer(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount()) == null)
    {
      this.jdField_a_of_type_Ngx.a(6, BaseApplicationImpl.getApplication().getString(2131690333), (nfv)this.jdField_a_of_type_Nha.a());
      return false;
    }
    paramRoomInfo = (nfv)this.jdField_a_of_type_Nha.a();
    int i = paramRoomInfo.a();
    int j = paramRoomInfo.b();
    if ((j == 1) && (i == 10)) {
      paramRoomInfo.a(paramString, j);
    }
    return true;
  }
  
  private void d()
  {
    e();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "leavePkRoomSubThread ");
    }
    ThreadManager.getSubThreadHandler().post(new RoomController.3(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
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
        break label149;
      }
      paramObject = String.format(BaseApplicationImpl.getApplication().getString(2131690327), new Object[] { ContactUtils.getFitString(paramObject, 8.0F) });
    }
    for (;;)
    {
      localStringBuilder.append(paramObject);
      this.jdField_a_of_type_Ngx.b(paramObject, (nfv)this.jdField_a_of_type_Nha.a());
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onDelayNotifyDone nt=%d result=%s", new Object[] { Integer.valueOf(paramInt), localStringBuilder.toString() }));
      }
      return;
      label149:
      if (2 == i) {
        paramObject = String.format(BaseApplicationImpl.getApplication().getString(2131690328), new Object[] { ContactUtils.getFitString(paramObject, 5.0F), ContactUtils.getFitString((String)localObject, 5.0F) });
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
    this.jdField_a_of_type_Ngx.g();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoFailed() roomId = " + paramLong + " data =" + this.jdField_a_of_type_Nha.a());
    }
    if (paramLong == ((nfv)this.jdField_a_of_type_Nha.a()).a()) {
      this.jdField_a_of_type_Ngx.a(paramInt, BaseApplicationImpl.getApplication().getString(2131690333), (nfv)this.jdField_a_of_type_Nha.a());
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString, RoomInfo paramRoomInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onLeaveGameRoomSuccess() leaveType =" + paramInt + " kickUin = " + paramString);
    }
    if (nfc.a().f())
    {
      paramString = nfc.a().a();
      if (paramString.m() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameRoomController", 2, "onLeaveGameRoomSuccess() pk to create or join new room " + this.jdField_a_of_type_Boolean);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label112;
        }
      }
    }
    label112:
    do
    {
      do
      {
        return;
      } while (paramString.m() != 2);
      a(1);
      return;
      if (2 != paramInt) {
        break;
      }
    } while (!a(paramLong, "onLeaveGameRoomSuccess(kick)"));
    a(paramRoomInfo, false);
    this.jdField_a_of_type_Ngx.a(2, paramString, null, (nfv)this.jdField_a_of_type_Nha.a());
    bdla.b(null, "dc00898", "", "", "0X800B02E", "0X800B02E", 0, 0, paramString, "" + paramLong, "", "");
    return;
    this.jdField_a_of_type_Ngx.a(paramInt, null, (nfv)this.jdField_a_of_type_Nha.a());
    if (this.c) {}
    for (paramInt = 1;; paramInt = 2)
    {
      bdla.b(null, "dc00898", "", "", "0X800B030", "0X800B030", paramInt, 0, "", "" + paramLong, "", "");
      this.c = false;
      return;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onLeaveGameRoomFailed() leaveType =" + paramInt + " kickUin = " + paramString1 + " errorMsg = " + paramString2);
    }
    if (2 == paramInt)
    {
      if (!a(paramLong, "onLeaveGameRoomFailed(kick)")) {
        return;
      }
      this.jdField_a_of_type_Ngx.a(-2, paramString1, BaseApplicationImpl.getApplication().getString(2131690358), (nfv)this.jdField_a_of_type_Nha.a());
    }
    for (;;)
    {
      this.c = false;
      return;
      this.jdField_a_of_type_Ngx.a(paramInt, null, (nfv)this.jdField_a_of_type_Nha.a());
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
    this.jdField_a_of_type_Ngx.h();
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
    nfv localnfv = (nfv)this.jdField_a_of_type_Nha.a();
    localnfv.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnGameChange() newIndex = " + localnfv.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Ngx.b(localnfv);
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
    if (((nfv)this.jdField_a_of_type_Nha.a()).e())
    {
      ((nfv)this.jdField_a_of_type_Nha.a()).f(2);
      this.jdField_a_of_type_Ngx.c(paramString1, (nfv)this.jdField_a_of_type_Nha.a());
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin().equals(paramString1))
    {
      paramRoomInfo = ((nfv)this.jdField_a_of_type_Nha.a()).a().getNick(paramString1);
      paramString2 = ((nfv)this.jdField_a_of_type_Nha.a()).a().getNick(paramString2);
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
    this.jdField_a_of_type_Ngx.b("", (nfv)this.jdField_a_of_type_Nha.a());
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
            break label843;
          }
          paramInt2 = 1;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != 0) {
        nfc.a().f();
      }
      a(paramRoomInfo, false);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomExit() isMine = " + bool1 + " tips = " + paramString4);
      }
      if ((!bool1) && (((nfv)this.jdField_a_of_type_Nha.a()).e()))
      {
        i = ((nfv)this.jdField_a_of_type_Nha.a()).a();
        if ((i != 10) && (i != 0))
        {
          ((nfv)this.jdField_a_of_type_Nha.a()).f(9);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RoomController.2(this), 4000L);
        }
      }
      if (bool1)
      {
        this.jdField_a_of_type_Ngx.a(3, paramString4, (nfv)this.jdField_a_of_type_Nha.a());
        if (paramInt3 != 1) {
          break;
        }
        if (paramInt2 != 0)
        {
          bdla.b(null, "dc00898", "", "", "0X800B35A", "0X800B35A", 0, 0, "", "", "", "");
          return;
          if (!str.equals(String.valueOf(paramRoomInfo.owner))) {
            break label828;
          }
          paramString4 = paramString3.replace("#", ((nfv)this.jdField_a_of_type_Nha.a()).a().getNick(paramString1));
          bool1 = bool2;
          paramInt2 = i;
          continue;
          if ((paramInt2 != 1) || (!paramString1.equals(str))) {
            break label828;
          }
          bool1 = true;
          if (NetworkUtil.isNetworkAvailable()) {}
          for (paramInt2 = 2131690333;; paramInt2 = 2131690390)
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
              if (NetworkUtil.isNetworkAvailable()) {}
              for (paramInt2 = 2131690333;; paramInt2 = 2131690390)
              {
                paramString4 = BaseApplicationImpl.getApplication().getString(paramInt2);
                paramInt2 = i;
                break;
              }
            }
            paramString4 = String.format(BaseApplicationImpl.getApplication().getString(2131690387), new Object[] { ((nfv)this.jdField_a_of_type_Nha.a()).a().getNick(paramString2, 8) });
            bool1 = bool2;
            paramInt2 = i;
            if (!((nfv)this.jdField_a_of_type_Nha.a()).e()) {
              continue;
            }
            paramString4 = "";
            bool1 = bool2;
            paramInt2 = i;
            continue;
          }
          if (2 != paramInt1) {
            break label828;
          }
          if (paramString1.equals(str))
          {
            paramString4 = BaseApplicationImpl.getApplication().getString(2131690359);
            bool1 = true;
            paramInt2 = i;
            continue;
          }
          paramString4 = String.format(BaseApplicationImpl.getApplication().getString(2131690360), new Object[] { ((nfv)this.jdField_a_of_type_Nha.a()).a().getNick(paramString1, 8) });
          bool1 = bool2;
          paramInt2 = i;
          continue;
        }
        bdla.b(null, "dc00898", "", "", "0X800B35C", "0X800B35C", 0, 0, "", "", "", "");
        return;
      }
      if ((paramInt1 != 1) && (paramInt3 == 1) && (str.equals(String.valueOf(paramRoomInfo.owner))) && (!paramString1.equals(str)))
      {
        this.jdField_a_of_type_Ngx.a(3, paramString1, paramString4, (nfv)this.jdField_a_of_type_Nha.a());
        bdla.b(null, "dc00898", "", "", "0X800B35B", "0X800B35B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Ngx.a(1, paramString1, paramString4, (nfv)this.jdField_a_of_type_Nha.a());
      return;
      label828:
      paramString4 = "";
      bool1 = bool2;
      paramInt2 = i;
      continue;
      label843:
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
    ((nfv)this.jdField_a_of_type_Nha.a()).a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnChangeUserStatus() uin = " + paramString + " userStatusType =" + paramInt);
    }
    paramRoomInfo = (nfv)this.jdField_a_of_type_Nha.a();
    this.jdField_a_of_type_Ngx.a(paramString, paramInt, paramRoomInfo);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("avgame_logic.GameRoomController", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_Ngu.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusFailed() errorMsg =" + paramString + "errorCode = " + paramInt1 + " from = " + paramInt2);
    }
    if (!a(paramLong, "onChangeUserStatusFailed()")) {
      return;
    }
    this.jdField_a_of_type_Ngx.a(paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2 + " isHostUser =" + ((nfv)this.jdField_a_of_type_Nha.a()).e(paramString1));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!((nfv)this.jdField_a_of_type_Nha.a()).e(paramString1))) {
      return;
    }
    this.jdField_a_of_type_Ngu.a(paramLong, 2, paramString1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, List<ngb> paramList, String paramString2, String paramString3)
  {
    if (!a(paramLong, "onGetGameQuestionClass()")) {
      return;
    }
    ((nfv)this.jdField_a_of_type_Nha.a()).a(paramList, paramString2, paramString3);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString);
    }
    this.c = paramBoolean;
    this.jdField_a_of_type_Ngu.a(paramLong, 1, paramString, paramString);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoFailed() uin = " + paramString1 + " isFromSync =" + paramBoolean + " fromType=" + paramInt1);
    }
    if (!a(paramLong, "onGetGameRoomInfoFailed()")) {
      return;
    }
    if (((paramInt2 == 106) || (paramInt2 == 111)) && (paramLong == ((nfv)this.jdField_a_of_type_Nha.a()).a()))
    {
      this.jdField_a_of_type_Ngx.a(6, BaseApplicationImpl.getApplication().getString(2131690333), (nfv)this.jdField_a_of_type_Nha.a());
      return;
    }
    this.jdField_a_of_type_Ngx.a(paramLong, paramString1, paramBoolean, paramString2, paramInt2);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2);
    }
    this.jdField_a_of_type_Ngu.a(paramLong, paramString, paramBoolean1, 1);
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
      ((nfv)this.jdField_a_of_type_Nha.a()).a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), 1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusSuccess() and from = " + paramInt);
    }
    paramRoomInfo = (nfv)this.jdField_a_of_type_Nha.a();
    this.jdField_a_of_type_Ngx.a(paramRoomInfo, paramInt);
  }
  
  public void a(RoomInfo paramRoomInfo, nfw paramnfw, List<UserScore> paramList, List<nga> paramList1, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = (nfv)this.jdField_a_of_type_Nha.a();
    paramnfw.a(paramString1.a());
    paramString1.a(paramRoomInfo, false);
    paramString1.a(paramList1, paramInt);
    paramString1.a(paramnfw);
    paramString1.a(paramList);
    if ((nff.b(paramString1.c())) && (paramString1.a().size() == 0) && (paramString1.a() >= 0) && (paramString1.a() <= 10)) {
      ((ngt)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b(), false);
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
      this.jdField_a_of_type_Nhb.a();
      this.jdField_a_of_type_Nhb.a(paramRoomInfo.seq, paramRoomInfo.id, false);
    }
    nfv localnfv = (nfv)this.jdField_a_of_type_Nha.a();
    localnfv.a(paramRoomInfo, paramBoolean);
    a(localnfv);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "selectGame roomId = " + paramLong + " uin = " + paramString + " isHost =" + ((nfv)this.jdField_a_of_type_Nha.a()).e(paramString));
    }
    if ((TextUtils.isEmpty(paramString)) || (!((nfv)this.jdField_a_of_type_Nha.a()).e(paramString))) {
      return;
    }
    this.jdField_a_of_type_Ngu.a(paramString, paramLong, paramInt);
  }
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, RoomInfo paramRoomInfo, nfg paramnfg, List<UserScore> paramList, List<nga> paramList1, int paramInt2, String paramString2, String paramString3)
  {
    long l1 = paramRoomInfo.seq;
    long l2 = paramRoomInfo.id;
    if (!a(l2, "onGetGameRoomInfoSuccess()")) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Nhb.a(l1, l2, paramBoolean))
      {
        QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoSuccess() seq is invalid just return");
        return;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramRoomInfo, (nfw)paramnfg, paramList, paramList1, paramInt2, paramString2, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetSnapshotSuc() fromEnter=%b curGameIndex=%d roomInfo=[%s] game=[%s] scores=[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRoomInfo, paramnfg, Arrays.toString(paramList.toArray()) }));
      }
    } while (!a(paramString1, paramRoomInfo));
    this.jdField_a_of_type_Ngx.c((nfv)this.jdField_a_of_type_Nha.a(), paramInt1);
    return;
    a(paramRoomInfo, false);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetGameRoomInfoSuccess() roomInfo=[%s]", new Object[] { paramRoomInfo }));
    }
    this.jdField_a_of_type_Ngx.a(paramString1, (nfv)this.jdField_a_of_type_Nha.a());
  }
  
  public void a(List<nga> paramList, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameListSuccess() curGameIndex = " + paramInt + " resUrl =" + paramString1 + " resMd5 =" + paramString2);
    }
    if (!a(paramLong, "onGetGameListSuccess()")) {}
    do
    {
      return;
      paramString1 = (nfv)this.jdField_a_of_type_Nha.a();
      paramString1.a(paramList, paramInt);
      this.jdField_a_of_type_Ngx.a(paramString1);
    } while ((paramList == null) || (paramList.size() <= 0));
    paramString1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramString1.add(Integer.valueOf(((nga)paramList.next()).jdField_a_of_type_Int));
    }
    this.jdField_a_of_type_Ngu.a(paramLong, paramString1);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPKInfoResult isSuc:%b option:%d pkTotalNum:%d listSize:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.size()) }));
    }
    if (paramBoolean)
    {
      nfv localnfv = nfc.a().a();
      localnfv.c(paramInt2);
      localnfv.b(paramList, paramInt1);
    }
    this.jdField_a_of_type_Ngx.b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Long> paramList, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPKInfoResult isSuc:%b interval:%d pkTotalNum:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    }
    if (paramBoolean)
    {
      paramString = nfc.a().a();
      paramString.c(paramInt2);
      paramString.a(paramList);
    }
    this.jdField_a_of_type_Ngx.b(paramBoolean);
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this);
    }
    if (paramInt1 > 0)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramInt1);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onCreateRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if (!paramBoolean) {
      nfc.a().l();
    }
    for (;;)
    {
      this.jdField_a_of_type_Ngx.a(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
      return;
      nfc.a().a().d(4);
      a(paramRoomInfo, true);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onStartStrangerMatch isSuc=" + paramBoolean + " roomId=" + paramLong + " shareId=" + paramInt1 + " errCod=" + paramInt2 + " errMsg=" + paramString);
    }
    if (paramBoolean)
    {
      ((nfv)this.jdField_a_of_type_Nha.a()).a(paramLong, 1);
      ((nfv)this.jdField_a_of_type_Nha.a()).b(paramLong, paramInt1);
    }
    this.jdField_a_of_type_Ngx.a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onStopStrangerMatch isSuc=" + paramBoolean + " roomId=" + paramLong + " errCod=" + paramInt + " errMsg=" + paramString);
    }
    if (paramBoolean)
    {
      nfv localnfv = (nfv)this.jdField_a_of_type_Nha.a();
      localnfv.b(paramLong, 0);
      localnfv.a(paramLong, 0);
    }
    this.jdField_a_of_type_Ngx.a(paramBoolean, paramLong, paramInt, paramString);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onPkUserResult isSuc:%b resultStatus:%d exitRoom:%b info:%s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), paramSurvivalPkResultInfo }));
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramBoolean2) {
      d();
    }
    if (paramInt == 2)
    {
      nfc.a().a().f(5);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RoomController.4(this, paramInt, paramBoolean2), 4000L);
    }
    for (;;)
    {
      nfc.a().a().a(paramSurvivalPkResultInfo);
      this.jdField_a_of_type_Ngx.a(paramBoolean1, paramInt, paramBoolean2, paramSurvivalPkResultInfo);
      return;
      if (paramInt == 1)
      {
        nfc.a().a().f(4);
        nfc.a().a().g(paramSurvivalPkResultInfo.winRound);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RoomController.5(this, paramBoolean2), 4000L);
      }
      else if (paramInt == 3)
      {
        nfc.a().a().f(4);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RoomController.6(this, paramInt, paramBoolean2), 4000L);
      }
      else if (paramInt == 4)
      {
        nfc.a().a().g(paramSurvivalPkResultInfo.winRound);
        nfc.a().a().f(4);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RoomController.7(this, paramBoolean2), 4000L);
      }
      else if (paramInt == 5)
      {
        nfc.a().a().g(paramSurvivalPkResultInfo.winRound);
        nfc.a().a().f(8);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RoomController.8(this, paramBoolean2), 4000L);
      }
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onSurvivalPkRoomAction isSuc:%b create:%b roomId:%d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong2) }));
    }
    if (paramBoolean1)
    {
      localObject = nfc.a().a();
      ((nfv)localObject).f(1);
      if (((nfv)localObject).a() <= 0L) {
        break label105;
      }
      ((nfv)localObject).d(2);
      if (paramBoolean2) {
        break label96;
      }
    }
    label96:
    for (((nfv)localObject).jdField_a_of_type_Long = paramLong2;; ((nfv)localObject).jdField_a_of_type_Long = 0L)
    {
      d();
      return;
    }
    label105:
    ((nfv)localObject).d(3);
    Object localObject = (ngu)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1);
    if (paramBoolean2)
    {
      ((ngu)localObject).a(10, null, 0);
      return;
    }
    ((ngu)localObject).a(7, String.valueOf(paramLong2), "");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onSurvivalResult isSuc:%b exit:%b poolId:%d startNum:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    }
    nfv localnfv;
    if (paramBoolean1)
    {
      localnfv = nfc.a().a();
      if (paramBoolean2)
      {
        localnfv.f(0);
        localnfv.b(0);
        localnfv.d(0);
        if (this.jdField_b_of_type_AndroidOsHandler != null) {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
        }
      }
    }
    for (;;)
    {
      nfc.a().a().h(paramInt2);
      if (!paramBoolean2) {
        this.jdField_a_of_type_Ngx.a(paramBoolean1, paramInt3, paramString);
      }
      return;
      if (localnfv.j() == 0)
      {
        localnfv.b(paramInt1);
        nfc.a().m();
      }
      localnfv.d(1);
      continue;
      if (nfc.a().a().a() > 0L) {
        nfc.a().a(false, 1);
      }
      nfc.a().a().a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "getGameRoomList roomId = " + paramLong);
    }
    this.jdField_a_of_type_Ngu.a(paramLong);
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onRoomMatchStatusChange roomId=" + paramLong + " matchStatus=" + paramInt);
    }
    if (!a(paramLong, "onRoomMatchStatusChange()")) {
      return;
    }
    nfv localnfv = (nfv)this.jdField_a_of_type_Nha.a();
    localnfv.a(paramLong, paramInt);
    this.jdField_a_of_type_Ngx.a(paramLong, localnfv.a(localnfv.e(nfc.a().a().getCurrentAccountUin())));
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
    this.jdField_a_of_type_Ngx.i();
  }
  
  public void b(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1);
    }
    this.jdField_a_of_type_Ngu.a(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onJoinRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if (!paramBoolean) {
      nfc.a().l();
    }
    for (;;)
    {
      this.jdField_a_of_type_Ngx.b(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
      return;
      nfc.a().a().f(2);
      nfc.a().a().d(4);
      a(paramRoomInfo, true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this.jdField_a_of_type_Ndr);
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
    this.jdField_a_of_type_Ngx.a(7, BaseApplicationImpl.getApplication().getString(2131690434), (nfv)this.jdField_a_of_type_Nha.a());
  }
  
  public void d(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onPkMatchTimeout");
    }
    this.jdField_a_of_type_Ngx.j();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      nfc.a().m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController
 * JD-Core Version:    0.7.0.1
 */